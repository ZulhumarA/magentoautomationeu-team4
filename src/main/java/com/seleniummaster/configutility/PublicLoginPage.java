package com.seleniummaster.configutility;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PublicLoginPage {

    TestUtility testUtility;
    WebDriver driver;
    Faker faker=new Faker();

    @FindBy(css = "a[title='Log In']")
    WebElement LoginButton;

    @FindBy(css = "input[title='Email Address']")
    WebElement InterEmailField;

    @FindBy(css = "input[title='Password']")
    WebElement InterPasswordField;
    @FindBy(css = "div.account-cart-wrapper a.skip-link.skip-account .label")
    WebElement AccountButton;

    @FindBy(css = "div.buttons-set #send2")
    WebElement PublicLoginButtonInLoginPge;

    @FindBy(css="a[title='Log Out']")
    WebElement LogOutButton;


    public PublicLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }


    public void Login() {
        testUtility.waitForElementPresent(AccountButton);
        AccountButton.click();
        testUtility.waitForElementPresent(LoginButton);
        LoginButton.click();
        testUtility.waitForElementPresent(InterEmailField);
        InterEmailField.click();
        InterEmailField.sendKeys(ApplicationConfig.readFromConfigProperties("config.properties", "emailAddress"));
        testUtility.waitForElementPresent(InterPasswordField);
        InterPasswordField.click();
        InterPasswordField.sendKeys( ApplicationConfig.readFromConfigProperties("config.properties", "password"));
        PublicLoginButtonInLoginPge.click();
    }
    public void changPasswordLogin() {
        testUtility.waitForElementPresent(AccountButton);
        AccountButton.click();
        testUtility.waitForElementPresent(LoginButton);
        LoginButton.click();
        testUtility.waitForElementPresent(InterEmailField);
        InterEmailField.click();
        InterEmailField.sendKeys(ApplicationConfig.readFromConfigProperties("config.properties", "emailAddress1"));
        testUtility.waitForElementPresent(InterPasswordField);
        InterPasswordField.click();
        InterPasswordField.sendKeys( ApplicationConfig.readFromConfigProperties("config.properties", "password1"));
        PublicLoginButtonInLoginPge.click();
    }
    public void updateAddressLogin() {
        testUtility.waitForElementPresent(AccountButton);
        AccountButton.click();
        testUtility.waitForElementPresent(LoginButton);
        LoginButton.click();
        testUtility.waitForElementPresent(InterEmailField);
        InterEmailField.click();
        InterEmailField.sendKeys(ApplicationConfig.readFromConfigProperties("config.properties", "emailAddress2"));
        testUtility.waitForElementPresent(InterPasswordField);
        InterPasswordField.click();
        InterPasswordField.sendKeys( ApplicationConfig.readFromConfigProperties("config.properties", "password"));
        PublicLoginButtonInLoginPge.click();
    }
 public void LogOutAndBackToLogInPage(){
        AccountButton.click();
        LogOutButton.click();

 }

}