package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeeSaleTotalShippedReport extends TestBase {
    TestUtility testUtility;
    WebDriver driver;
    int reportRowSize;

    public SeeSaleTotalShippedReport(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement reportsButton;

    @FindBy(xpath = "//span[text()='Sales']")
    WebElement salesButton;

    @FindBy(xpath = "//span[text()='Shipping']")
    WebElement shippingButton;

    @FindBy(id = "sales_report_period_type")
    WebElement periodDropdown;

    @FindBy(id = "sales_report_from")
    WebElement fromDateField;

    @FindBy(id = "sales_report_to")
    WebElement toDateField;

    @FindBy(id ="sales_report_show_order_statuses")
    WebElement orderStatusDropdown;

    @FindBy(id = "sales_report_show_empty_rows")
    WebElement emptyRowsDropdown;

    @FindBy(xpath = "//span[text()='Show Report']")
    WebElement showReportButton;

    @FindBy(xpath="//th[contains(text(),\"Total\")]")
    WebElement ResultPeriod;



    public void SeeShippedReport(String startDate,String endDate){
        testUtility.waitForElementPresent(reportsButton);
        reportsButton.click();
        testUtility.waitForElementPresent(salesButton);
        salesButton.click();
        testUtility.waitForElementPresent(shippingButton);
        shippingButton.click();
        testUtility.sleep(1);
        testUtility.waitForElementPresent(periodDropdown);
        testUtility.selectValueFromDropDown(periodDropdown,"month");

        testUtility.waitForElementPresent(fromDateField);
        fromDateField.click();
        fromDateField.sendKeys(startDate);
        testUtility.waitForElementPresent(toDateField);
        toDateField.click();
        toDateField.sendKeys(endDate);
        testUtility.waitForElementPresent(orderStatusDropdown);
        testUtility.selectValueFromDropDown(orderStatusDropdown,"1");
        testUtility.waitForElementPresent(emptyRowsDropdown);
        testUtility.selectValueFromDropDown(emptyRowsDropdown,"1");
        testUtility.waitForElementPresent(showReportButton);
        showReportButton.click();
    }


    public boolean verifyReportsDisplayed(){
        testUtility.waitForElementPresent(ResultPeriod);
        return ResultPeriod.isDisplayed();
    }




}
