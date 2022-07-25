package com.seleniummaster.ui.backend.salesmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageViewShoppingCart {

    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath="//span[contains(.,'Customers')]")
    WebElement Customers;

    @FindBy(xpath="//span[contains(.,'Manage Customers')]")
    WebElement CustomersManageCustomers;

    @FindBy(xpath="//a[contains(.,'Edit')]")
    WebElement EditButton;

    @FindBy(css="#customer_info_tabs_cart > span")
    WebElement ShoppingCartLink;

    @FindBy(id="customer_cart_grid1")
    WebElement ShoppingCartTable;

    public ManageViewShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void ViewShoppingCart(){

        testUtility.waitForElementPresent(Customers);
        Customers.click();
        CustomersManageCustomers.click();
        testUtility.waitForElementPresent(EditButton);
        EditButton.click();
        testUtility.waitForElementPresent(ShoppingCartLink);
        ShoppingCartLink.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

        public boolean VerifyShoppingCartTable(){
        testUtility.waitForElementPresent(ShoppingCartTable);
        return ShoppingCartTable.isDisplayed();
    }
}
