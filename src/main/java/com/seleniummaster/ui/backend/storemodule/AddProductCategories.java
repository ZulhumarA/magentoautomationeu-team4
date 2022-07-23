package com.seleniummaster.ui.backend.storemodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductCategories extends TestBase {
    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Catalog')]")
    WebElement catalogButton;

    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement manegeCategoriesButton;

    @FindBy(id = "group_4name")
    WebElement name;

    @FindBy(id = "group_4is_active")
    WebElement isActive;

    @FindBy(id = "group_4include_in_menu")
    WebElement includeInNavigationMenu;

    @FindBy(xpath = "//*[span='Save Category']")
    WebElement saveCategoryButton;

    @FindBy(css = "div[class='content-buttons-placeholder'] button[title=\"Save Category\"]")
    WebElement saveMassage;

    public AddProductCategories(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void setCatalogButton() {
        testUtility.waitForElementPresent(catalogButton);
        catalogButton.click();
    }

    public void setManegeCategoriesButton() {
        testUtility.waitForElementPresent(manegeCategoriesButton);
        manegeCategoriesButton.click();
    }

    public void setName(String fileName) {
        testUtility.waitForElementPresent(name);
        name.sendKeys(fileName);
    }

    public void setIsActive() {
        testUtility.selectValueFromDropDown(isActive, "1");
    }

    public void setIncludeInNavigationMenu() {
        testUtility.selectValueFromDropDown(includeInNavigationMenu, "1");
    }

    public void setSaveCategoryButton() {
        testUtility.waitForElementPresent(saveCategoryButton);
        saveMassage.click();
    }

    public boolean VerifySavedMassageSuccessfully() {
        testUtility.waitForElementPresent(saveMassage);
        return saveMassage.isDisplayed();
    }
}
