package com.seleniummaster.ui.backend.storemodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CanDeleteProductPage extends TestBase {

    TestUtility testUtility;
    WebDriver driver;


    @FindBy(xpath = "//span[contains(text(),'Catalog')]")
    WebElement catalogButton;

    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement manegeCategoriesButton;

    @FindBy(xpath = "//*[span='Team4 Test For Faruk (0)']")
    WebElement clickFileName;

    @FindBy(css = "div[class='content-buttons-placeholder'] button[title=\"Delete Category\"]")
    WebElement clickDeleteCategory;

    @FindBy(xpath = "//*[span='The category has been deleted.']")
    WebElement deleteMassage;




    public CanDeleteProductPage(WebDriver driver) {
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
    public void setClickDeleteCategory(){
        testUtility.waitForElementPresent(clickDeleteCategory);
        clickDeleteCategory.click();
    }
    public boolean VerifyDeleteMassageSuccessfully(){
        testUtility.waitForElementPresent(deleteMassage);
        return deleteMassage.isDisplayed();
    }


}

