package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EditRootCategories extends TestBase {
    TestUtility testUtility;
    WebDriver driver;
    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement CatalogButton;
    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement ManageCategoriesButton;
    @FindBy(xpath = "//input[@id=\"group_4name\"]")
    WebElement rootName;

    @FindBy(id="group_4is_active")
    WebElement isActive;

    @FindBy(id="group_4description")
    WebElement description;

    @FindBy(id="group_4meta_title")
    WebElement pageTitle;

    @FindBy(id="group_4meta_keywords")
    WebElement metaKeywords;

    @FindBy(id="group_4meta_description")
    WebElement metaDescription;

    @FindBy(xpath="//*[@title=\"Save Category\"]")
    WebElement saveButton;

    @FindBy(xpath = "//span[contains(text(),\"The category has been saved.\")]")
    WebElement successfulSavesMessage;

    public EditRootCategories(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void openCategoriesPage() {
        testUtility.waitForElementPresent(CatalogButton);
        CatalogButton.click();
        testUtility.waitForElementPresent(ManageCategoriesButton);
        ManageCategoriesButton.click();
    }
    public void editRootCatalogInformation(){
        testUtility.waitForElementPresent(rootName);
        rootName.sendKeys("New Project");
        testUtility.waitForElementPresent(isActive);
        isActive.click();
        testUtility.waitForElementPresent(description);
        description.sendKeys("For better future");
        testUtility.waitForElementPresent(pageTitle);
        pageTitle.sendKeys("Fruits");
    }




}
