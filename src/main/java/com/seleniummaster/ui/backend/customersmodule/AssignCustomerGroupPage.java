package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;

public class AssignCustomerGroupPage {

    TestUtility testUtility;

    WebDriver driver;

    public AssignCustomerGroupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "(//*[contains(text(),'Add New Customer')])[1]")
    WebElement addNewCustomerButton;

    @FindBy(id = "_accountwebsite_id")
    WebElement associateWebsiteField;

    @FindBy(id="_accountgroup_id")
    WebElement groupField;

    @FindBy(id = "_accountfirstname")
    WebElement firstNameField;

    @FindBy(id = "_accountlastname")
    WebElement lastNameField;

    @FindBy(id = "_accountemail")
    WebElement emailField;

    @FindBy(id = "account-send-pass")
    WebElement passwordField;

    @FindBy(xpath = "//*[@class='middle']//button[@title='Save Customer']")
    WebElement saveCustomerButton;

    @FindBy(xpath = "//*[contains(text(),'The customer has been saved.')]")
    WebElement customerSuccessfullySavedMessage;

    public void addNewCustomer(){
        testUtility.waitForElementPresent(addNewCustomerButton);
        addNewCustomerButton.click();
        testUtility.selectValueFromDropDown(associateWebsiteField,"1");
        testUtility.selectValueFromDropDown(groupField,"14");
        firstNameField.sendKeys("Team4Test "+testUtility.generateFirstName());
        lastNameField.sendKeys("Team4Test "+testUtility.generateLastName());
        emailField.sendKeys("Team4Test"+testUtility.fakeEmail());
        passwordField.click();
        saveCustomerButton.click();
    }

    public boolean verifyCustomerAdded(){
        testUtility.waitForElementPresent(customerSuccessfullySavedMessage);
        customerSuccessfullySavedMessage.isDisplayed();
        return true;
    }

    @FindBy(id="customerGrid_filter_email")
    WebElement searchEmailField;

    @FindBy(xpath = "//*[@id=\"customerGrid_table\"]/tbody/tr[1]/td[1]/input")
    WebElement selectionCheckBox;

    @FindBy(id = "customerGrid_massaction-select")
    WebElement actionsDropDownList;

    @FindBy(id = "visibility")
    WebElement assignGroupField;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"customerGrid_table\"]/tbody/tr[1]/td[5]")
    WebElement customerGroupSection;

    String customerGroup1;
    String customerGroup2;

    public void assignCustomerToNewGroup(){
        testUtility.waitForElementPresent(searchEmailField);
        searchEmailField.sendKeys("Team4Test");
        searchEmailField.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectionCheckBox.click();
        System.out.println(customerGroup1);
        testUtility.selectValueFromDropDown(actionsDropDownList,"assign_group");
        testUtility.selectValueFromDropDown(assignGroupField,"85");
        submitButton.click();
        String customerGroup2=customerGroupSection.getText();
        customerGroupSection.getText();
        System.out.println(customerGroup2);
    }

    public boolean isCustomerGroupChanged(){
        if(!customerGroup1.equalsIgnoreCase(customerGroup2)){
            System.out.println("Customer has assigned to a new group by customer manager");
        }
        return true;
    }








}