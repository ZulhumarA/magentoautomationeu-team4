package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteSubCategories {
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

    @FindBy(css="button[title='Delete Category']")
    WebElement DeleteCategoryButton;

    @FindBy(xpath = "//*[text()=\"The category has been deleted.\"]")
    WebElement DeleteSubCategorySuccessfulMessage;



    public DeleteSubCategories(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }


    public void SubCategoryDelete() {
        testUtility.waitForElementPresent(CatalogButton);
        CatalogButton.click();
        testUtility.waitForElementPresent(ManageCategoriesButton);
        ManageCategoriesButton.click();
        testUtility.waitForElementPresent(BagCategory);
        BagCategory.click();
        testUtility.waitForElementPresent(BagSubCategory);
        BagSubCategory.click();
        testUtility.waitForElementPresent(DeleteCategoryButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DeleteCategoryButton.click();
        driver.switchTo().alert().accept();

    }

    public boolean verifyDeleteSubCategorySuccessful(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        DeleteSubCategorySuccessfulMessage.isDisplayed();
        return DeleteSubCategorySuccessfulMessage.isDisplayed();
    }


}