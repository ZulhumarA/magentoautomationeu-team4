package com.seleniummaster.database.datapaseTestPages;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyNewStoreViewPage {

    TestUtility testUtility;

    WebDriver driver;

    public VerifyNewStoreViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(xpath = "//span[text()='System']")
    WebElement systemButton;

    @FindBy(xpath = "//span[text()='Manage Stores']")
    WebElement manageStoresButton;

    @FindBy(xpath = "//span[text()='Create Store View']")
    WebElement createStoreViewButton;

    @FindBy(id = "store_group_id")
    WebElement storeDropDown;

    @FindBy(id = "store_name")
    WebElement storeNameField;

    @FindBy(id = "store_code")
    WebElement storeCodeField;

    @FindBy(id = "store_is_active")
    WebElement storeStatusDropDown;

    @FindBy(xpath = "//span[text()='The store view has been saved']")
    WebElement storeViewSuccessfullyCreatedMessage;

    public void createNewStoreView(String storeName, String storeCode){
        testUtility.waitForElementPresent(systemButton);
        systemButton.click();
        testUtility.waitForElementPresent(manageStoresButton);
        manageStoresButton.click();
        testUtility.waitForElementPresent(createStoreViewButton);
        createStoreViewButton.click();
        testUtility.waitForElementPresent(storeDropDown);
        testUtility.selectValueFromDropDown(storeDropDown,"99");
        testUtility.waitForElementPresent(storeNameField);
        storeNameField.sendKeys(storeName);
        testUtility.waitForElementPresent(storeCodeField);
        storeCodeField.sendKeys(storeCode);
        testUtility.waitForElementPresent(storeStatusDropDown);
        testUtility.selectValueFromDropDown(storeStatusDropDown,"1");
    }

    public boolean verifyNewStoreViewSuccessfullyCreated(){
        testUtility.waitForElementPresent(storeViewSuccessfullyCreatedMessage);
        return storeViewSuccessfullyCreatedMessage.isDisplayed();
    }

}
