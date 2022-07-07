package com.seleniummaster.ui.backend.storemodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteWebsiteInfo {
    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'System')]")
    WebElement SystemButton;
    @FindBy(xpath = "//span[text()='Manage Stores']")
    WebElement ManageStoresButton;
    @FindBy(xpath = "//a[@title='Id: 22']")
    WebElement DesiredWebsite;
    @FindBy(xpath = "//span[text()='Delete Website']")
    WebElement DeleteWebsite;
    @FindBy(xpath = "//span[text()='The website has been deleted.']")
    WebElement DeletedMassage;

    public DeleteWebsiteInfo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void DeleteWebsiteInformation() {
        testUtility.waitForElementPresent(SystemButton);
        SystemButton.click();
        testUtility.waitForElementPresent(ManageStoresButton);
        ManageStoresButton.click();
        testUtility.waitForElementPresent(DesiredWebsite);
        DesiredWebsite.click();
        testUtility.waitForElementPresent(DeleteWebsite);
        DeleteWebsite.click();
    }

    public boolean VerifyDeletedMassageSuccessfully() {
        testUtility.waitForElementPresent(DeletedMassage);
        return DeletedMassage.isDisplayed();
    }

}
