package com.seleniummaster.ui.backend.storemodule;

import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateStoreViewPage extends TestBase {
TestUtility testUtility;
WebDriver driver;
@FindBy(xpath="//span[contains(text(),\"System\")]")
    WebElement SystemLink;
@FindBy(xpath="//span[contains(text(),\"Manage Stores\")]")
WebElement ManageStoresLink;
@FindBy(xpath="//span[contains(text(),\"Create Store View\")]")
WebElement CreateStoreViewButton;
@FindBy(xpath="//input[@id=\"store_name\"]")
WebElement StoreName;
@FindBy(xpath="//input[@id=\"store_code\"]")
WebElement StoreID;
@FindBy(xpath="//span[contains(text(),\"Save Store View\")]")
WebElement SaveButton;
@FindBy(xpath="//span[contains(text(),\"The store view has been saved\")]")
WebElement SuccessfulCreatedMessage;
@FindBy(css="select[id='store_is_active']")
WebElement StatusField;
    public CreateStoreViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }
    public void openManageStoresPage(){
        testUtility.waitForElementPresent(SystemLink);
        SystemLink.click();
        testUtility.waitForElementPresent(ManageStoresLink);
        ManageStoresLink.click();
        testUtility.waitForElementPresent(CreateStoreViewButton);
        CreateStoreViewButton.click();
    }
public void fillOutStoreViewInformation() throws InterruptedException {
        Thread.sleep(3000);
       // testUtility.waitForElementPresent(StoreName);
        StoreName.sendKeys("Zulhumaraman");
        testUtility.waitForElementPresent(StoreID);
        StoreID.sendKeys(testUtility.generateRandomLetter());
        testUtility.waitForElementPresent(StatusField);
        testUtility.selectValueFromDropDown(StatusField,1);
        testUtility.waitForElementPresent(SaveButton);
        SaveButton.click();
}
public boolean verifyStoreViewSuccessfullyCreated(){
        testUtility.waitForElementPresent(SuccessfulCreatedMessage);
        return true;
}
}
