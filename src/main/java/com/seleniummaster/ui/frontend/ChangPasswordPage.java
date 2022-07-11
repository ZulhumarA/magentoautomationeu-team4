package com.seleniummaster.ui.frontend;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ChangPasswordPage {
    WebDriver driver;
    TestUtility testUtility;
//    @FindBy(xpath = "//span[text()='Account' and @class='label']")
//    WebElement accountMenu;
    @FindBy(xpath = "//a[@title='My Account' and text()='My Account']")
    WebElement myAccount;
    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/div[1]/div/div[2]/p/a")
    WebElement accountInformation;
    @FindBy(id = "current_password")
    WebElement passwordTextBox;
    @FindBy(xpath="//*[@id=\"change_password\"]")
    WebElement changPasswordButton;
    @FindBy(id = "password")
    WebElement newPasswordTextBox;
    @FindBy(id = "confirmation")
    WebElement confirmNewPassword;
    @FindBy(xpath = "//button[@title='Save']")
    WebElement saveButton;
    @FindBy(css = "div.page-title h1")
    WebElement changPasswordSuccessMessage;

    public ChangPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

//    public void clickAccountMenu() {
//        testUtility.waitForElementPresent(accountMenu);
//        accountMenu.click();
//    }

    public void clickMyAccount() {
        testUtility.waitForElementPresent(myAccount);
        myAccount.click();
    }

    public void clickInformation() {
        testUtility.waitForElementPresent(accountInformation);
        accountInformation.click();
    }

    public void enterPasswordTextBox(String password) {
        testUtility.waitForElementPresent(passwordTextBox);
        passwordTextBox.sendKeys(password);
    }

    public void clickChangPasswordButton() {
        testUtility.waitForElementPresent(changPasswordButton);
        changPasswordButton.isDisplayed();
    }

    public void enterNewPassword(String newPassword) {
        testUtility.waitForElementPresent(newPasswordTextBox);
        newPasswordTextBox.sendKeys(newPassword);
    }

    public void enterConfirmPassword(String confirmPassword) {
        testUtility.waitForElementPresent(confirmNewPassword);
        confirmNewPassword.sendKeys(confirmPassword);
    }

    public void clickSaveButton() {
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean clickChangPassword(String currentPassword, String newPassword, String confirmationPassword) {
//    clickAccountMenu();
    clickMyAccount();
    clickInformation();
    enterPasswordTextBox(currentPassword);
    clickChangPasswordButton();
    enterNewPassword(newPassword);
    enterConfirmPassword(confirmationPassword);
    clickSaveButton();
    testUtility.waitForElementPresent(changPasswordSuccessMessage);
    return changPasswordSuccessMessage.isDisplayed();
    }
}

