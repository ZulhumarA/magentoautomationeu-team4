package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateAnExistingCustomerPage {

    TestUtility testUtility;

    WebDriver driver;

    @FindBy(xpath = "//a[text()='Edit']")
    WebElement EditButton;
    @FindBy(xpath = "//a[@name='account']")
    WebElement AccountInformationButton;
    @FindBy(xpath = "//input[@name='account[taxvat]']")
    WebElement TaxVATFiled;
    @FindBy(xpath = "//span[text()='Save Customer']")
    WebElement SaveCustomerButton;
    @FindBy(xpath = "//span[text()='The customer has been saved.']")
    WebElement SavedMassage;

    public UpdateAnExistingCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void EditAccountInformation(String Tax) {
        testUtility.waitForElementPresent(EditButton);
        EditButton.click();
        testUtility.waitForElementPresent(AccountInformationButton);
        AccountInformationButton.click();
        testUtility.waitForElementPresent(TaxVATFiled);
        TaxVATFiled.sendKeys(String.valueOf(Tax));
        testUtility.waitForElementPresent(SaveCustomerButton);
        SaveCustomerButton.click();
    }

    public boolean VerifyEditPasswordSuccessfully() {
        testUtility.waitForElementPresent(SavedMassage);
        return SavedMassage.isDisplayed();
    }
}

