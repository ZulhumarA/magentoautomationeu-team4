package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRootCategories {
    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement CatalogButton;
    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement ManageCategoriesButton;
    @FindBy(xpath = "//span[text()='Add Root Category']")
    WebElement AddRootCategoryButton;
    @FindBy(xpath = "//input[@id='group_4name']")
    WebElement NameFiled;
    @FindBy(xpath = "//span[text()='Save Category']")
    WebElement SaveCategoryButton;
    @FindBy(xpath = "//span[text()='The category has been saved.']")
    WebElement SavedMassage;

    public AddRootCategories(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void NewRootCategoryInformation(String Name) {
        testUtility.waitForElementPresent(CatalogButton);
        CatalogButton.click();
        testUtility.waitForElementPresent(ManageCategoriesButton);
        ManageCategoriesButton.click();
        testUtility.waitForElementPresent(AddRootCategoryButton);
        AddRootCategoryButton.click();
        testUtility.waitForElementPresent(NameFiled);
        NameFiled.sendKeys(String.valueOf(Name));
        testUtility.waitForElementPresent(SaveCategoryButton);
        SaveCategoryButton.click();
    }

    public boolean VerifyAddRootCategoriesSuccessfully() {
        testUtility.waitForElementPresent(SavedMassage);
        return SavedMassage.isDisplayed();
    }

}
