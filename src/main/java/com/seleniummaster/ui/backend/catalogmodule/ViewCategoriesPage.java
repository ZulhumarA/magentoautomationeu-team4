package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCategoriesPage extends TestBase {
    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath = "//*[text()=\"Default Category (1)\"]")
    WebElement DefaultCategoryButton;

    @FindBy(xpath = "//*[text()=\"Manage Categories\"]")
    WebElement ManageCategoriesButton;

    @FindBy(xpath = "//a[@class='active']//span")
    WebElement CatalogButton;

    @FindBy(xpath = "//*[@class=\"icon-head head-categories\" and text()=\"Default Category (ID: 2)\"]  ")
    WebElement DefaultCategoryVerifyMessage;

    public ViewCategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

        public void ViewCategories(){
        testUtility.waitForElementPresent(CatalogButton);
        CatalogButton.click();
        ManageCategoriesButton.click();
    }

        public void ClickOnDefaultCategory(){
        testUtility.waitForElementPresent(DefaultCategoryButton);
        DefaultCategoryButton.click();
        }

        public boolean DefaultCategoryVerifyMessage(){
        testUtility.waitForElementPresent(DefaultCategoryVerifyMessage);
        return DefaultCategoryButton.isDisplayed();
    }
}






