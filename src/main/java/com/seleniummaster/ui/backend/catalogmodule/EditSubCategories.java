package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditSubCategories {
    TestUtility testUtility;


    WebDriver driver;

    @FindBy(css=".active > span")
    WebElement CatalogButton;


    @FindBy(xpath="//span[contains(.,'Manage Categories')]")

    WebElement ManageCategoriesButton;

    @FindBy(xpath="//span[contains(.,'Bag (0)')]")
    WebElement BagCategory;

    @FindBy(xpath="//span[contains(.,'bag (0)')]")
    WebElement BagSubCategory;

    @FindBy(xpath="//select[@id='group_4is_active']")
    WebElement IsActive;

    @FindBy(xpath="//textarea")
    WebElement DescriptionArea;

    @FindBy(xpath="//span[contains(.,'Save Category')]")
    WebElement SaveCategoryButton;

    @FindBy(css= "li > span")
    WebElement EditSubCategorySuccessfulMessage;



    public EditSubCategories(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }


    public void SubCategoryEdit() {
        testUtility.waitForElementPresent(CatalogButton);
        CatalogButton.click();
        testUtility.waitForElementPresent(ManageCategoriesButton);
        ManageCategoriesButton.click();
        testUtility.waitForElementPresent(BagCategory);
        BagCategory.click();
        testUtility.waitForElementPresent(BagSubCategory);
        BagSubCategory.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        testUtility.waitForElementPresent(IsActive);
        IsActive.click();
        IsActive.isSelected();
        testUtility.waitForElementPresent(DescriptionArea);
        DescriptionArea.click();
        DescriptionArea.sendKeys("Color and Size");
        testUtility.waitForElementPresent(SaveCategoryButton);
        SaveCategoryButton.click();

    }

    public boolean verifyEditSubCategorySuccessful(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        EditSubCategorySuccessfulMessage.isDisplayed();
        return EditSubCategorySuccessfulMessage.isDisplayed();
    }


}