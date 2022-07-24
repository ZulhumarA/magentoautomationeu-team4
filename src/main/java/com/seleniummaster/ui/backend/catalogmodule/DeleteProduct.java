package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProduct  extends TestBase {

    TestUtility testUtility;
    WebDriver driver;

    public DeleteProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);

    }


    @FindBy(id ="productGrid_product_filter_name")
    WebElement FilterAddedProductLInk;

    @FindBy(xpath= "//*[@id ='name']")
    WebElement NameLink;

    @FindBy(xpath ="//span[text()='Delete']")
    WebElement DeleteButton;

    @FindBy(css ="button[title=\"Search\"]")
    WebElement SearchButton;

    @FindBy(css ="#productGrid_table > tbody > tr > td:nth-child(3)")
    WebElement SearchedProductLink;

    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement DeleteSuccessMessage;

    public void deleteAddedProduct(String ProductName) throws InterruptedException {
        testUtility.waitForElementPresent(FilterAddedProductLInk);
        FilterAddedProductLInk.sendKeys(ProductName);
        Thread.sleep(3000);
        SearchButton.click();
        Thread.sleep(3000);
        testUtility.waitForElementPresent(SearchedProductLink);
        SearchedProductLink.click();
        Thread.sleep(3000);
        testUtility.waitForElementPresent(NameLink);
        Thread.sleep(3000);
        testUtility.waitForElementPresent(DeleteButton);
        DeleteButton.click();
        driver.switchTo().alert().accept();
    }
    public boolean verifyDeleteProduct(){
        testUtility.waitForElementPresent(DeleteSuccessMessage);
        return
                DeleteSuccessMessage.isDisplayed();

    }
}
