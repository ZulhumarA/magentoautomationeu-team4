package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddressPage extends TestBase {
    TestUtility testUtility;
    WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"customerGrid_table\"]/tbody/tr/td[12]/a")
    WebElement editLinks;
    @FindBy(xpath = "//*[span='Addresses']")
    WebElement addressLinks;
    @FindBy(xpath = "//*[span='Add New Address']")
    WebElement addNewAddressButton;
    @FindBy(id = "_item1street0")
    WebElement enterStreetAddress;
    @FindBy(id = "_item1street1")
    WebElement enterStreetAddress1;
    @FindBy(id = "_item1country_id")
    WebElement enterCountry;
    @FindBy(id = "_item1region")
    WebElement enterState;
    @FindBy(id = "_item1city")
    WebElement enterCity;
    @FindBy(id = "_item1postcode")
    WebElement enterPostCode;
    @FindBy(id = "_item1telephone")
    WebElement enterTelephone;
    @FindBy(xpath = "//*[span='Save Customer']")
    WebElement addSaveCustomerButton;
    @FindBy(xpath = "//*[span='The customer has been saved.']")
    WebElement customerSavedMessage;

    public AddNewAddressPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void setClickEdit(){
        testUtility.waitForElementPresent(editLinks);
        editLinks.click();
    }
    public void setClickAddressLinks(){
        testUtility.waitForElementPresent(addressLinks);
        addressLinks.click();
    }
    public void setAddNewAddressButton(){
        testUtility.waitForElementPresent(addNewAddressButton);
        addNewAddressButton.click();
    }

    public void setEnterStreetAddress(String address){
        //testUtility.waitForElementPresent(enterStreetAddress);
        testUtility.sleep(3);
        enterStreetAddress.sendKeys(address);
    }
    public void setEnterStreetAddress1(String address1){
        testUtility.waitForElementPresent(enterStreetAddress1);
        enterStreetAddress1.sendKeys(address1);
    }
    public void setEnterCountry(){
        testUtility.selectValueFromDropDown(enterCountry,"TR");
    }
    public void setEnterState(String state){
        testUtility.waitForElementPresent(enterState);
        enterState.sendKeys(state);
    }
    public void setEnterCity(String city){
        testUtility.waitForElementPresent(enterCity);
        enterCity.sendKeys(city);
    }
    public void setEnterPostCode(String pastCode){
        testUtility.waitForElementPresent(enterPostCode);
        enterPostCode.sendKeys(pastCode);
    }
    public void setEnterTelephone(String telephone){
        testUtility.waitForElementPresent(enterTelephone);
        enterTelephone.sendKeys(telephone);
    }
    public void setAddSaveCustomerButton(){
        testUtility.waitForElementPresent(addSaveCustomerButton);
        addSaveCustomerButton.click();
    }
    public boolean addNewAddress(){
        testUtility.waitForElementPresent(customerSavedMessage);
        return customerSavedMessage.isDisplayed();
    }
}
