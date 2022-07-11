package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSubCategories {
    TestUtility testUtility;


    WebDriver driver;

    @FindBy(css=".active > span")
    WebElement CatalogButton;


    @FindBy(xpath="//span[contains(.,'Manage Categories')]")

    WebElement ManageCategoriesButton;

    @FindBy(xpath="//span[contains(.,'Bag (0)')]")
    WebElement BagCategory;

    @FindBy(css="button[title='Add Subcategory']")
    WebElement AddSubcategoryButton;

    @FindBy(id="group_4name")
    WebElement NameBox;

    @FindBy(css="button[title='Save Category']")
    WebElement SaveCategoryyButton;

    @FindBy(xpath = "//span[contains(.,'The category has been saved.')]")
    WebElement AddSubCategorySuccessfulMessage;



    public AddSubCategories(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }


    public void SubCategoryAdd() {
        testUtility.waitForElementPresent(CatalogButton);
        CatalogButton.click();
        testUtility.waitForElementPresent(ManageCategoriesButton);
        ManageCategoriesButton.click();
        testUtility.waitForElementPresent(BagCategory);
        BagCategory.click();
        testUtility.waitForElementPresent(AddSubcategoryButton);
        AddSubcategoryButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        testUtility.waitForElementPresent(NameBox);
        NameBox.click();
        NameBox.sendKeys("bag");
        testUtility.waitForElementPresent(SaveCategoryyButton);
        SaveCategoryyButton.click();

    }

    public boolean verifyAddSubCategorySuccessful(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        AddSubCategorySuccessfulMessage.isDisplayed();
        return AddSubCategorySuccessfulMessage.isDisplayed();
    }


}
