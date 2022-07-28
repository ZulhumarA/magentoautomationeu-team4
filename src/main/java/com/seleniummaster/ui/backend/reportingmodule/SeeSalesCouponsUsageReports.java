package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeeSalesCouponsUsageReports extends TestBase {
    WebDriver driver;
    TestUtility testUtility;

    public SeeSalesCouponsUsageReports(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement reportsButton;

    @FindBy(xpath = "//span[text()='Sales']")
    WebElement salesButton;

    @FindBy(xpath = "//span[text()='Coupons']")
    WebElement couponsButton;

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

    @FindBy(id = "sales_report_price_rule_type")
    WebElement ShoppingCartPriceRuleDropdown;

    @FindBy(xpath = "//span[text()='Show Report']")
    WebElement showReportButton;

    @FindBy(xpath="//th[contains(text(),\"Total\")]")
    WebElement ResultPeriod;



    public void OpenCoupenUsagePage() {
        testUtility.waitForElementPresent(reportsButton);
        reportsButton.click();
        testUtility.waitForElementPresent(salesButton);
        salesButton.click();
        testUtility.waitForElementPresent(couponsButton);
        couponsButton.click();
        testUtility.sleep(1);
    }

    public void SeeCouponsUsageReport(String startDate,String endDate){
        testUtility.waitForElementPresent(periodDropdown);
        testUtility.selectValueFromDropDown(periodDropdown,"year");

        testUtility.waitForElementPresent(fromDateField);
        fromDateField.click();
        fromDateField.sendKeys(startDate);
        testUtility.waitForElementPresent(toDateField);
        toDateField.click();
        toDateField.sendKeys(endDate);
        testUtility.sleep(2);
        testUtility.waitForElementPresent(orderStatusDropdown);
        testUtility.selectValueFromDropDown(orderStatusDropdown,"1");
        testUtility.waitForElementPresent(emptyRowsDropdown);
        testUtility.selectValueFromDropDown(orderStatusDropdown,"1");
        testUtility.sleep(2);
        testUtility.waitForElementPresent(ShoppingCartPriceRuleDropdown);
        testUtility.selectValueFromDropDown(ShoppingCartPriceRuleDropdown,"1");
        testUtility.waitForElementPresent(showReportButton);
        showReportButton.click();
    }


    public boolean verifyReportsDisplayed(){
        testUtility.waitForElementPresent(ResultPeriod);
        return ResultPeriod.isDisplayed();
    }




}


