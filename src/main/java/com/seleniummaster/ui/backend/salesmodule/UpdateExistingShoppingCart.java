package com.seleniummaster.ui.backend.salesmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateExistingShoppingCart {

 WebDriver driver;
 TestUtility testUtility;

 @FindBy(css = "#messages > ul > li > ul > li > span")
 WebElement successfulMessage;

 @FindBy(css = "#nav > li:nth-child(4)")
 WebElement customersLink;

 @FindBy(css = "#nav > li:nth-child(4) > ul > li:nth-child(1)")
 WebElement manageCustomerLink;

 @FindBy(xpath = "//*[@id=\"customerGrid_table\"]/tbody/tr[1]/td[12]/a")
 WebElement EditButton;

 @FindBy(css = "#customer_info_tabs > li:nth-child(7)>a[title=\"Shopping Cart\"]")
 WebElement ShoppingCartLink;

 @FindBy(css = "thead > tr:nth-child(2) > th:nth-child(2)>div>input")
  WebElement productNameInputBox;

 @FindBy(css = "p.form-buttons>button[title=\"Save Customer\"]")
 WebElement saveCustomerButton;

    public UpdateExistingShoppingCart(WebDriver driver) {
        this.driver = driver;
        testUtility=new TestUtility(driver);
        PageFactory.initElements(driver,this);
    }


   //methods
   public void updateExistingShoppingCart(){
        testUtility.waitForElementPresent(customersLink);
        customersLink.click();
        testUtility.sleep(1);
        testUtility.waitForElementPresent(manageCustomerLink);
        manageCustomerLink.click();
        testUtility.sleep(1);
        testUtility.waitForElementPresent(EditButton);
        EditButton.click();
        testUtility.waitForElementPresent(ShoppingCartLink);
        ShoppingCartLink.click();
        testUtility.sleep(1);
        testUtility.waitForElementPresent(productNameInputBox);
        productNameInputBox.sendKeys(testUtility.productName());
        testUtility.sleep(1);
        testUtility.waitForElementPresent(saveCustomerButton);
        saveCustomerButton.click();
   }

   public boolean verifyShoppingCartUpdatedSuccessfully(){
        testUtility.waitForElementPresent(successfulMessage);
        if (successfulMessage.isDisplayed())
            return true;
        else
            return false;
   }

}
