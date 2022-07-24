package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage extends TestBase {
    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath = "//input[contains(@name,\"name\")]")
    WebElement searchNameField;

    @FindBy(xpath = "//*[text()=\"Edit\"]")
    WebElement customerHalit;

    @FindBy(xpath = "//button[@class=\"scalable delete\"][1]")
    WebElement deleteButton;

    @FindBy(xpath = "//*[contains(text(),\"The customer has been deleted.\")]")
    WebElement verifyMessage;

    @FindBy(xpath = "//button[contains(@class,\"scalable task\") and @title=\"Search\"]")
    WebElement searchButton;


    public DeleteCustomerPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void clickSearchNameField(){
        testUtility.waitForElementPresent(searchNameField);
        searchNameField.click();
    }

    public void enterSearchName(String firthName){
        testUtility.waitForElementPresent(searchNameField);
        searchNameField.sendKeys(firthName);
    }

    public void clickSearchButton(){
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
    }

    public void clickOnCustomer(){
        testUtility.waitForElementPresent(customerHalit);
        customerHalit.click();
    }

    public void clickOnDelete(){
        testUtility.waitForElementPresent(deleteButton);
        deleteButton.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public boolean deleteMessage(){
        testUtility.waitForElementPresent(verifyMessage);
        return verifyMessage.isDisplayed();
    }



}

