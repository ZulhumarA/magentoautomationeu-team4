package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterCustomersByEmailPage extends TestBase {

    TestUtility testUtility;
    WebDriver driver;

    @FindBy(id = "customerGrid_filter_email")
    WebElement emailField;

    @FindBy(css = "[title~=Search]")
    WebElement searchButton;

    @FindBy(css = "td:nth-child(4)")
    WebElement CustomerEmail;

    public FilterCustomersByEmailPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver,this);

        testUtility=new TestUtility(driver);
    }


    public void filterEmail(){
        testUtility.waitForElementPresent(emailField);
        emailField.sendKeys(ApplicationConfig.readFromConfigProperties("config.properties","emailAddress2"));
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
    }
    public boolean verifyCustomersByEmail(){
        testUtility.waitForElementPresent(CustomerEmail);

        boolean textFound = false;
        
        try{
             driver.findElement(By.xpath("//*[contains(text(),'someText')]"));
            textFound = true;
        }
        catch (Exception e) {
        textFound = false;
    }


        return textFound;
    }
    }

