package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAttributeUnderCatalogPage extends TestBase {
    TestUtility testUtility;
    WebDriver driver;
    Actions actions;
    @FindBy(xpath = "//a[@class='active']//span")
    WebElement catalogLink;
    @FindBy(xpath = "//span[text()='Attributes']")
    WebElement attributesLink;
    @FindBy(xpath = "//span[text()='Manage Attributes']")
    WebElement manageAttributesLink;
    @FindBy(xpath = "(//span[text()='Add New Attribute'])[1]")
    WebElement addNewAttributeButton;
@FindBy(xpath ="//input[@id='attribute_code']" )
WebElement attributeCode;
@FindBy(xpath="//input[@id='default_value_text']")
WebElement defaultValue;
@FindBy(xpath = "(//span[text()='Save Attribute'])[1]")
WebElement saveAttributeButton;

@FindBy(xpath = "//input[@class='input-text required-option validation-failed']")
WebElement adminField;
@FindBy(xpath = "//span[text()='Save Attribute']")
    WebElement savaAttributeBTN;
@FindBy(xpath = "//span[text()='The product attribute has been saved.']")
WebElement successfulMessage;
    public AddAttributeUnderCatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);

    }
    public void addNewAttributeMethod(){
        testUtility.waitForElementPresent(catalogLink);
        catalogLink.click();
        attributesLink.click();
        manageAttributesLink.click();
        addNewAttributeButton.click();
        attributeCode.sendKeys(ApplicationConfig.readFromConfigProperties(
                "config.properties","attributeCode"));
        defaultValue.sendKeys(ApplicationConfig.readFromConfigProperties(
                "config.properties","defaultValue"));
        saveAttributeButton.click();
        adminField.sendKeys(ApplicationConfig.readFromConfigProperties(
                "config.properties","admin"));
        savaAttributeBTN.click();
    }
//
//    public void moveToCatalogLink() {
//        testUtility.waitForElementPresent(catalogLink);
//        //  actions.moveToElement(catalogLink).perform();
//        catalogLink.click();
//    }
//
//    public void moveToAttributesLink() {
//        testUtility.waitForElementPresent(attributesLink);
//        attributesLink.click();
//        // actions.moveToElement(attributesLink).perform();
//    }
//
//    public void moveToManageAttributesLink() {
//        testUtility.waitForElementPresent(manageAttributesLink);
//        manageAttributesLink.click();
//        //  actions.moveToElement(manageAttributesLink).perform();
//    }
//
//    public void clickOnAddNewAttributeLink() {
//        testUtility.waitForElementPresent(addNewAttributeButton);
//        addNewAttributeButton.click();
//    }
//
//    public void enterattributeCode(String attributeCodes) {
//        testUtility.waitForElementPresent(attributeCode);
//attributeCode.sendKeys(attributeCodes);}
//
//public void enterDefaultValue(String defaultValues){
//testUtility.waitForElementPresent(defaultValue);
//defaultValue.sendKeys(defaultValues);
//    }
//    public void clickSaveAttributeButton(){
//        testUtility.waitForElementPresent(saveAttributeButton);
//        saveAttributeButton.click();
//    }
//    public void enterAdminField(String admin){
//        testUtility.waitForElementPresent(adminField);
//        adminField.sendKeys(admin);
//    }
//    public void clickSaveAttributeBTN(){
//        testUtility.waitForElementPresent(savaAttributeBTN);
//        savaAttributeBTN.click();
//    }
    public boolean verifyAttributeAddedSuccessfully(){
        testUtility.waitForElementPresent(successfulMessage);
        return successfulMessage.isDisplayed();
    }
}
