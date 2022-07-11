package com.seleniummaster.ui.frontend;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage extends TestBase {
    @FindBy(xpath = "//*[@id=\"header\"]/div/div[@class='skip-links']/div/a/span[@class='label']")
    WebElement account;

    @FindBy(xpath ="//div[@id='header-account']/div/ul/li/a[@title='Register']")
    WebElement registerLink;

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "middlename")
    WebElement middleName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(id = "email_address")
    WebElement emailAddress;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id ="confirmation")
    WebElement confirmPassword;

    @FindBy(xpath = "//form/div/ul/li[@class=\"control\"]/div/input[@id=\"is_subscribed\"]")
    WebElement isSubscribed;

    @FindBy(xpath = "//div[@class=\"buttons-set\"]/button/span")
    WebElement registerButton;

    @FindBy(xpath ="//div/ul/li[@class=\"success-msg\"]//ul/li/span[text()='Thank you for registering with eCommerce Shopping.']")
    WebElement createAnAccountSuccessfulMessage;

    TestUtility testUtility;

    String  publicEmail="test4"+System.currentTimeMillis()+"@gmail.com";
    String publicPassword="12345678943";

    public CreateAnAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        TestUtility testUtility=new TestUtility(driver);

    }

    public void makeEmailAndPassword(){
        publicEmail="test4"+System.currentTimeMillis()+"@gmail.com";
        publicPassword="12345678943";
    }
    public void fillAccountRegistrationForm(){
        account.click();
        registerLink.click();
        firstName.sendKeys("Test4-FirstName");
        middleName.sendKeys("Test4-MiddleName");
        lastName.sendKeys("Test4-LastName");
        emailAddress.sendKeys(publicEmail);
        password.sendKeys("12345678943");
        confirmPassword.sendKeys("12345678943");
        isSubscribed.click();
        registerButton.click();
    }

    public boolean verifyCreateAnAccountSuccessful(){
        createAnAccountSuccessfulMessage.isDisplayed();
        return createAnAccountSuccessfulMessage.isDisplayed();
    }
}

