package com.seleniummaster.ui.backend.customersmodule;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddNewCustomerPage extends TestBase {
    TestUtility testUtility;
    WebDriver driver;
    @FindBy(xpath="(//*[contains(text(),'Add New Customer')])[1]")
    WebElement addNewCustomerLink;

    @FindBy(id="_accountprefix")
    WebElement prefixField;

    @FindBy(id="_accountfirstname")
    WebElement firstNameField;

    @FindBy(id="_accountlastname")
    WebElement lastNameField;

    @FindBy(id="_accountemail")
    WebElement emailField;

    @FindBy(id="_accounttaxvat")
    WebElement taxNumberField;

    @FindBy(id="_accountpassword")
    WebElement passwordfield;

    @FindBy(xpath="//*[@class='middle']//button[@title='Save Customer']")
    WebElement saveCustomerButton;

    @FindBy(xpath = "//*[contains(text(),'The customer has been saved.')]")
    WebElement customerSuccessfullySavedMessage;

    public AddNewCustomerPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
       testUtility=new TestUtility(driver);
    }


    public void clickAddNewCustomer() {
        testUtility.waitForElementPresent(addNewCustomerLink);
        addNewCustomerLink.click();
    }

    public void enterPrefixField(String prefix){
        testUtility.waitForElementPresent(prefixField);
        prefixField.sendKeys(prefix);
    }
public void enterFirstName(String firstName){
    testUtility.waitForElementPresent(firstNameField);
    firstNameField.sendKeys(firstName);}
    public void enterLastName(String lastName) {
        testUtility.waitForElementPresent(lastNameField);
        lastNameField.sendKeys(lastName);
    }
    public void enterEmail(String email) {
        testUtility.waitForElementPresent(emailField);
        emailField.sendKeys(email);
    }
    public void enterTaxNumber(String taxNumber) {
        testUtility.waitForElementPresent(taxNumberField);
        taxNumberField.sendKeys(taxNumber);
    }
    public void enterPassword(String password1) {
        testUtility.waitForElementPresent(passwordfield);
        passwordfield.sendKeys(password1);
    }
public void clickSaveButton(){
    testUtility.waitForElementPresent(saveCustomerButton);
    saveCustomerButton.click();
}
public boolean verifyAddCustomer(){
    testUtility.waitForElementPresent(customerSuccessfullySavedMessage);
    return customerSuccessfullySavedMessage.isDisplayed();
}}