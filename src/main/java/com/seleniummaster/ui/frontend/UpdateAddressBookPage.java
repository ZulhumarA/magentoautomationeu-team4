package com.seleniummaster.ui.frontend;
import com.seleniummaster.configutility.PublicLoginPage;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateAddressBookPage {
    WebDriver driver;
    TestUtility testUtility;
    PublicLoginPage publicLoginPage;
    @FindBy(xpath = "//a[text()='Edit Address']")
    WebElement editAddressLink;
    @FindBy(name  = "firstname")
    WebElement firstNameField;
    @FindBy(name  = "lastname")
    WebElement lastNameField;
    @FindBy(name  = "city")
    WebElement cityField;
    @FindBy(name = "postcode")
    WebElement zipField;
    @FindBy(css = ".buttons-set > button")
    WebElement saveAddressButton;
    @FindBy(css = ".success-msg span")
    WebElement successMsg;

    public UpdateAddressBookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);

    }
    public void UpdateAddress(){
        testUtility.waitForElementPresent(editAddressLink);
        editAddressLink.click();

        testUtility.waitForElementPresent(firstNameField);
        firstNameField.clear();
        firstNameField.sendKeys(testUtility.generateFirstName());

        testUtility.waitForElementPresent(lastNameField);
        lastNameField.clear();
        lastNameField.sendKeys(testUtility.generateLastName());


        testUtility.waitForElementPresent(cityField);
        cityField.clear();
        cityField.sendKeys(testUtility.generateCity());

        testUtility.waitForElementPresent(zipField);
        zipField.clear();
        zipField.sendKeys(testUtility.generateZip());

        testUtility.waitForElementPresent(saveAddressButton);
        saveAddressButton.click();

    }
    public boolean verifyUpdatedAddress() {
        return successMsg.getText().equalsIgnoreCase("The address has been saved.");
    }


}