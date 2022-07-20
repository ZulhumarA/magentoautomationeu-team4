package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class EditRootCategories extends TestBase {
    TestUtility testUtility;
    WebDriver driver;
    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement CatalogButton;
    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement ManageCategoriesButton;
    @FindBy(xpath = "//*[@id=\"extdd-276\"]")
    WebElement MyCatalog;
    @FindBy(xpath = "//input[@id=\"group_4name\"]")
    WebElement rootName;

    @FindBy(xpath="//select[@name=\"general[is_active]\"]")
    WebElement isActive;

    @FindBy(xpath="//*[@id=\"group_4description\"]")
    WebElement description;

    @FindBy(xpath="//input[@id='group_4meta_title']")
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
    public void editRootCatalogInformation() throws InterruptedException {
        testUtility.waitForElementPresent(MyCatalog);
        MyCatalog.click();
        testUtility.waitForElementPresent(rootName);
        rootName.clear();
        testUtility.waitForElementPresent(rootName);
        rootName.sendKeys("Team4Test"+testUtility.fakeCategoryName());
        testUtility.waitForElementPresent(isActive);
        Thread.sleep(3000);
        Select select=new Select(isActive);
        select.selectByVisibleText("Yes");

      //  description.sendKeys(testUtility.generateDescription());
      //  testUtility.waitForElementPresent(pageTitle);
        pageTitle.clear();
        pageTitle.sendKeys(testUtility.fakePageTitle());
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean verifyEditRootCategories()  {
        testUtility.waitForElementPresent(successfulSavesMessage);
        return successfulSavesMessage.isDisplayed();
    }


}
