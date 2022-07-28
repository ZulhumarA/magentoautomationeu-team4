package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeeSalesTotalRefundedReport extends TestBase {
    TestUtility testUtility;
    WebDriver driver;

    public SeeSalesTotalRefundedReport(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }
    @FindBy(xpath = "//span[text()='Reports']")
    WebElement ReportsButton;

    @FindBy(xpath = "//span[text()='Sales']")
    WebElement SalesButton;

    @FindBy(xpath = "//span[text()='Refunds']")
    WebElement RefundsButton;

    @FindBy(id = "sales_report_report_type")
    WebElement MatchPeriodDropdown;

    @FindBy(id = "sales_report_period_type")
    WebElement PeriodDropdown;

    @FindBy(id = "sales_report_from")
    WebElement FromDateField;

    @FindBy(id = "sales_report_to")
    WebElement ToDateField;

    @FindBy(id ="sales_report_show_order_statuses")
    WebElement OrderStatusDropdown;

    @FindBy(id = "sales_report_show_empty_rows")
    WebElement EmptyRowsDropdown;

    @FindBy(xpath = "//span[text()='Show Report']")
    WebElement ShowReportButton;

    @FindBy(xpath="//th[contains(text(),\"Total\")]")
    WebElement ResultPeriod;


    public void OpenRefundedReportPage(){
        testUtility.waitForElementPresent(ReportsButton);
        ReportsButton.click();
        testUtility.waitForElementPresent(SalesButton);
        SalesButton.click();
        testUtility.waitForElementPresent(RefundsButton);
        RefundsButton.click();
        testUtility.sleep(1);

    }

    public void SeeRefundedReport(String startDate,String endDate){
        //testUtility.waitForElementPresent(MatchPeriodDropdown);
        //testUtility.selectValueFromDropDown(MatchPeriodDropdown,"0");
        testUtility.waitForElementPresent(PeriodDropdown);
        testUtility.selectValueFromDropDown(PeriodDropdown,"day");
        testUtility.waitForElementPresent(FromDateField);
        FromDateField.click();
        FromDateField.sendKeys(startDate);
        testUtility.waitForElementPresent(ToDateField);
        ToDateField.click();
        ToDateField.sendKeys(endDate);
        testUtility.waitForElementPresent(OrderStatusDropdown);
        testUtility.selectValueFromDropDown(OrderStatusDropdown,"0");
        testUtility.waitForElementPresent(EmptyRowsDropdown);
        testUtility.selectValueFromDropDown(EmptyRowsDropdown,"1");
        testUtility.waitForElementPresent(ShowReportButton);
        ShowReportButton.click();
    }

    public boolean verifyReportsDisplayed(){
        testUtility.waitForElementPresent(ResultPeriod);
        return ResultPeriod.isDisplayed();
    }


}







