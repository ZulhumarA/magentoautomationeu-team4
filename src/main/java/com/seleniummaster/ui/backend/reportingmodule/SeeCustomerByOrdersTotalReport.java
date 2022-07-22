package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeeCustomerByOrdersTotalReport extends TestBase {
    TestUtility testUtility;
    WebDriver driver;

    public SeeCustomerByOrdersTotalReport(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }
    @FindBy(xpath="(//span[contains(text(),'Reports')])[1]")
    WebElement ReportsLink;
    @FindBy(xpath="(//span[contains(text(),\"Customers\")])[1]")
    WebElement CustomerReportsLink;
    @FindBy(xpath="//span[contains(text(),\"Customers by number of orders\")]")
    WebElement  ByOrdersTotal;
    @FindBy(xpath="//input[@id='period_date_from']")
    WebElement ReportFrom;
    @FindBy(css="input[name=\"report_to\"]")
    WebElement ReportTo;
    @FindBy(css="select[id=\"report_period\"]")
    WebElement ShowBy;
    @FindBy(css="button[title=\"Refresh\"]")
    WebElement Refresh;
    @FindBy(xpath="//*[contains(text(),\"Jan 8, 2020\")]")
    WebElement ResultPeriod;
    @FindBy(css=".link-logout")
    WebElement logOutLink;
    public void OpenCustomerByOrdersTotalReportPage() throws InterruptedException {
        testUtility.waitForElementPresent(ReportsLink);
        ReportsLink.click();
        testUtility.waitForElementPresent(CustomerReportsLink);
        CustomerReportsLink.click();
      //  Thread.sleep(3000);
        testUtility.waitForElementPresent(ByOrdersTotal);
        ByOrdersTotal.click();

    }
    public void ShowCustomersByOrdersTotalReportMethod(String startDate,String endDate) throws InterruptedException {
        //  Thread.sleep(3000);
        testUtility.waitForElementPresent(ReportFrom);
        ReportFrom.sendKeys(startDate);
        testUtility.waitForElementPresent(ReportTo);
        ReportTo.sendKeys(endDate);
        testUtility.waitForElementPresent(ShowBy);
        testUtility.selectValueFromDropDown(ShowBy,"day");
        testUtility.waitForElementPresent(Refresh);
        Refresh.click();
    }
    public boolean verifyReportsDisplayed(){
        testUtility.waitForElementPresent(ResultPeriod);
        return ResultPeriod.isDisplayed();
    }
    public void logOut(){
        testUtility.waitForElementPresent(logOutLink);
        logOutLink.click();
    }
}
