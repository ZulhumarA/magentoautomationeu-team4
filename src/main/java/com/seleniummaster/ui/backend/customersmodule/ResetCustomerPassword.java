package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetCustomerPassword {
    TestUtility testUtility;
    WebDriver driver;
    @FindBy(css = "#customerGrid_table tbody .pointer .last a")
    WebElement EditButton;

    @FindBy(css = "[name=\"account\"]")
    WebElement accountInformationButton;

    @FindBy(css = "[class='validate-new-password min-pass-length-7 input-text']")
    WebElement NewPasswordFiled;

    @FindBy(css = "#_accountcurrent_password")
    WebElement CurrentPasswordField;

    @FindBy(css = "button[class=\"scalable save\"]")
    WebElement SaveCustomerButton;

    @FindBy(css = ".success-msg")
    WebElement successfulMessage;

    public ResetCustomerPassword(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void EditCustomerInformation(int NewPassword) {
        testUtility.waitForElementPresent(EditButton);
        EditButton.click();
        testUtility.waitForElementPresent(accountInformationButton);
        accountInformationButton.click();
        testUtility.waitForElementPresent(NewPasswordFiled);
        NewPasswordFiled.sendKeys(String.valueOf(NewPassword));
        testUtility.waitForElementPresent(CurrentPasswordField);
        CurrentPasswordField.sendKeys(ApplicationConfig.readFromConfigProperties("config.properties","backEndPassword"));
        testUtility.waitForElementPresent(SaveCustomerButton);
        SaveCustomerButton.click();
    }

    public boolean VerifyEditPasswordSuccessfully() {
         testUtility.waitForElementPresent(successfulMessage);
         return successfulMessage.isDisplayed();
    }

}
