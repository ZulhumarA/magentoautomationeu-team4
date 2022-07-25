package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProduct extends TestBase {
    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath = "//*[@id ='description']")
    WebElement DescriptionLink;

    @FindBy(xpath = "//*[@id ='short_description']")
    WebElement ShortDescriptionLink;

    @FindBy(xpath =" //*[@id='sku']")
    WebElement SKULink;

    @FindBy(xpath= "//*[@id='weight']")
    WebElement Weight;

    @FindBy(xpath = "//*[@id=\"visibility\"]")
    WebElement VisibilityLink;

    @FindBy(id ="productGrid_product_filter_name")
    WebElement FilterAddedProductLInk;

    @FindBy(css ="button[title=\"Search\"]")
    WebElement SearchButton;

    @FindBy(css ="#productGrid_table > tbody > tr > td:nth-child(3)")
    WebElement SearchedProductLink;

    @FindBy(xpath="//*[@id= 'status']")
    WebElement StatusDropDownList;

    @FindBy(xpath = "//span[contains(text(),\"Save\")]")
    WebElement SaveButton;

    @FindBy(xpath = "//*[contains(text(),\"The product has been saved.\")]")
    WebElement SuccessMessage;
    

    public EditProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void editProductInfo(String productName) throws InterruptedException {
        testUtility.waitForElementPresent(FilterAddedProductLInk);
        FilterAddedProductLInk.sendKeys(productName);
        testUtility.waitForElementPresent(SearchButton);
        SearchButton.click();
        Thread.sleep(3000);
        testUtility.waitForElementPresent(SearchedProductLink);
        SearchedProductLink.click();
        Thread.sleep(3000);
        testUtility.waitForElementPresent(DescriptionLink);
        DescriptionLink.sendKeys(testUtility.generateRandomLetter());
        testUtility.waitForElementPresent(ShortDescriptionLink);
        ShortDescriptionLink.sendKeys(testUtility.generateRandomSentence());
        testUtility.waitForElementPresent(SKULink);
        SKULink.sendKeys(String.valueOf(testUtility.generateRandomNumber()));
        testUtility.waitForElementPresent(Weight);
        Weight.sendKeys(String.valueOf(testUtility.generateRandomNumber()));
        testUtility.waitForElementPresent(VisibilityLink);
        testUtility.selectValueFromDropDown(VisibilityLink,"2");
        testUtility.waitForElementPresent(StatusDropDownList);
        testUtility.selectValueFromDropDown(StatusDropDownList,2);
        testUtility.waitForElementPresent(SaveButton);
        SaveButton.click();


    }
    public boolean verifyEditProductTest() {
        testUtility.waitForElementPresent(SuccessMessage);
        return
                SuccessMessage.isDisplayed();
    }

}


