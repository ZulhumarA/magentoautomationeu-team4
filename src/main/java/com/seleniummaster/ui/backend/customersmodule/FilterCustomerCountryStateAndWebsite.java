package com.seleniummaster.ui.backend.customersmodule;


import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.seleniummaster.configutility.ApplicationConfig.readFromConfigProperties;

 public class FilterCustomerCountryStateAndWebsite extends TestBase {
    WebDriver driver;
    String configFile = "config.properties";
    String webSite;
    //String statevalue;
    TestUtility testUtility;

    public FilterCustomerCountryStateAndWebsite(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }
    @FindBy(id="customerGrid_filter_billing_country_id")
    WebElement countryField;
    @FindBy(id="customerGrid_filter_billing_region")
    WebElement stateField;
    @FindBy(id="customerGrid_filter_website_id")
    WebElement websiteField;
    @FindBy(css="button[title='Search']")
    WebElement searchButton;
    @FindBy(xpath="//th//input[@id='customerGrid_filter_billing_region']")
    WebElement stateValue;
    @FindBy(xpath ="//button[@title='Reset Filter']")
    WebElement resetFilterButton;

    public static  void selectValueFromDropDown(WebElement webElement,String visibleText){
        Select select=new Select(webElement);
        select.selectByVisibleText(visibleText);
    }
    public void filterCustomerByCountry(){
        testUtility.waitForElementPresent(countryField);
        Select selectCountry=new Select(countryField);
        selectCountry.selectByValue("NL");
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
        testUtility.sleep(3);
    }
    public void verifyFilterByCountry(){
        if(driver.getPageSource().contains("Netherland")){
            System.out.println("Customer Manager Can filter by country test is Passed!");
        }else{
            System.out.println("Customer Manager Can filter by country test is Failed!");
        }
    }
    public void filteCustomerByState(){
        testUtility.waitForElementPresent(stateField);
        stateField.sendKeys(readFromConfigProperties(configFile,"state"));
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(resetFilterButton);
        resetFilterButton.click();
        testUtility.sleep(3);
    }
    public void filterCustomerByWebsite(){
        testUtility.waitForElementPresent(websiteField);
        try {
            websiteField.click();
        }catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            Select selectWebsite=new Select(websiteField);
            selectWebsite.selectByIndex(3);
            testUtility.sleep(5);
            searchButton.click();
        }
    }
    public void verifyFilterByWebsite() {
        if (driver.getPageSource().contains("www.amazon.com")) {
            System.out.println("Customer Manager Can filter by website test is Passed!");
        } else {
            System.out.println("Customer Manager Can filter by website test is Faild!");

        }
    }}