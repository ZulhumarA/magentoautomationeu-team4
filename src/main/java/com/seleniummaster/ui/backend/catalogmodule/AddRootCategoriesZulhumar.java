package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddRootCategoriesZulhumar extends TestBase {
    TestUtility testUtility;
    WebDriver driver;
    Actions action;
    @FindBy(xpath = "//a[@class='active']//span")
    WebElement catalogButton;

    @FindBy(xpath = "//span[contains(text(),\"Manage Categories\")]")
    WebElement manageCategories;

    @FindBy(xpath = "//input[@id=\"group_4name\"]")
    WebElement rootName;

    @FindBy(id = "group_4is_active")
    WebElement isActive;

    @FindBy(id = "group_4description")
    WebElement description;

    @FindBy(id = "group_4meta_title")
    WebElement pageTitle;

    @FindBy(id = "group_4meta_keywords")
    WebElement metaKeywords;

    @FindBy(id = "group_4meta_description")
    WebElement metaDescription;

    @FindBy(xpath = "//*[@title=\"Save Category\"]")
    WebElement saveButton;

    @FindBy(xpath = "//span[contains(text(),\"The category has been saved.\")]")
    WebElement successfulSavesMessage;

    public AddRootCategoriesZulhumar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void openAddNewRootCategoryPage() throws InterruptedException {
        testUtility.waitForElementPresent(catalogButton);
        catalogButton.click();
        Thread.sleep(3000);
        // testUtility.waitForElementPresent(manageCategories);
        manageCategories.click();
    }

    public void fillCategoryInformationAndSave() throws InterruptedException {
        Thread.sleep(3000);
        rootName.sendKeys("Zulhumar" + testUtility.fakeCategoryName() + "Team4");
        Thread.sleep(3000);
        testUtility.waitForElementPresent(isActive);
        Select select = new Select(isActive);
        select.selectByValue("1");
        pageTitle.sendKeys("Zulhumar" + testUtility.fakePageTitle());
        Thread.sleep(3000);

        metaKeywords.sendKeys(testUtility.metaKeywords());
        Thread.sleep(3000);
        metaDescription.sendKeys(testUtility.metaDescriptions());
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean verifyAddRootCategories() throws InterruptedException {
        Thread.sleep(3000);
        testUtility.waitForElementPresent(successfulSavesMessage);
        return successfulSavesMessage.isDisplayed();
    }


}
