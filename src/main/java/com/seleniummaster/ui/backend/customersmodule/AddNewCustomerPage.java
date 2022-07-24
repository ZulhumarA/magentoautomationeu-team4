package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddNewCustomerPage extends TestBase {
    TestUtility testUtility;
    WebDriver driver;
    @FindBy(xpath = "(//*[contains(text(),'Add New Customer')])[1]")
    WebElement addNewCustomerLink;

    @FindBy(id = "_accountprefix")
    WebElement prefixField;

    @FindBy(id = "_accountfirstname")
    WebElement firstNameField;

    @FindBy(id = "_accountlastname")
    WebElement lastNameField;

    @FindBy(id = "_accountemail")
    WebElement emailField;

    @FindBy(id = "_accounttaxvat")
    WebElement taxNumberField;

    @FindBy(id = "_accountpassword")
    WebElement passwordfield;

    @FindBy(xpath = "//*[@class='middle']//button[@title='Save Customer']")
    WebElement saveCustomerButton;

    @FindBy(xpath = "//*[contains(text(),'The customer has been saved.')]")
    WebElement customerSuccessfullySavedMessage;

    public AddNewCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void addNewCustomerMethod(String firstName,String lastName,String email,String password) {
        testUtility.waitForElementPresent(addNewCustomerLink);
        addNewCustomerLink.click();
        testUtility.waitForElementPresent(firstNameField);
        firstNameField.sendKeys(firstName);
        testUtility.waitForElementPresent(lastNameField);
        lastNameField.sendKeys(lastName);
        testUtility.waitForElementPresent(emailField);
        emailField.sendKeys(email);
        testUtility.waitForElementPresent(passwordfield);
        passwordfield.sendKeys(password);
        testUtility.waitForElementPresent(saveCustomerButton);
        saveCustomerButton.click();
    }

    public boolean verifyAddCustomer() {
        testUtility.waitForElementPresent(customerSuccessfullySavedMessage);
        return customerSuccessfullySavedMessage.isDisplayed();
    }
}