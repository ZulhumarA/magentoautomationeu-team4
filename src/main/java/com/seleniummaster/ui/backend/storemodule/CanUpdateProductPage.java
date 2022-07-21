package com.seleniummaster.ui.backend.storemodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CanUpdateProductPage extends TestBase {
    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Catalog')]")
    WebElement catalogButton;

    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement manegeCategoriesButton;

    @FindBy(xpath = "//*[span='Team4 Test For Faruk (0)']")
    WebElement clickFileName;

    @FindBy(xpath = "//textarea[@id=\"group_4description\"]")
    WebElement enterDescription;

    @FindBy(xpath = "//input[@id=\"group_4meta_title\"]")
    WebElement enterPageTitle;

    @FindBy(xpath = "//textarea[@id=\"group_4meta_keywords\"]")
    WebElement enterMetaKeywords;

    @FindBy(xpath = "//textarea[@id=\"group_4meta_description\"]")
    WebElement enterMetaDescription;

    @FindBy(css = "div[class='content-buttons-placeholder'] button[title=\"Save Category\"]")
    WebElement saveCategoryButton;

    @FindBy(css = "div[class='content-buttons-placeholder'] button[title=\"Save Category\"]")
    WebElement saveMassage;

    public CanUpdateProductPage(WebDriver driver) {
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

    public void setClickFileName() {
        testUtility.waitForElementPresent(clickFileName);
        clickFileName.click();
    }

    public void setEnterDescription(String description) {
        testUtility.waitForElementPresent(enterDescription);
        enterDescription.sendKeys(description);
    }

    public void setEnterPageTitle(String pageTitle) {
        testUtility.waitForElementPresent(enterPageTitle);
        enterDescription.sendKeys(pageTitle);
    }

    public void setEnterMetaKeywords(String MetaKeywords) {
        testUtility.waitForElementPresent(enterMetaKeywords);
        enterMetaKeywords.sendKeys(MetaKeywords);
    }

    public void setEnterMetaDescription(String MetaDescription) {
        testUtility.waitForElementPresent(enterMetaDescription);
        enterMetaDescription.sendKeys(MetaDescription);
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

