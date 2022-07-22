package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeeCustomerByNumberOfOrders extends TestBase {
    TestUtility testUtility;
    WebDriver driver;

    public SeeCustomerByNumberOfOrders(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }
    @FindBy(xpath="(//span[contains(text(),'Reports')])[1]")
    WebElement ReportsLink;
    @FindBy(xpath="(//span[contains(text(),\"Customers\")])[1]")
    WebElement CustomerReportsLink;
    @FindBy(xpath="//span[contains(text(),\"Customers by number of orders\")]")
    WebElement  ByNumberOfOrder;
    @FindBy(xpath="//input[@id='period_date_from']")
    WebElement ReportFrom;
    @FindBy(css="input[name=\"report_to\"]")
    WebElement ReportTo;
    @FindBy(css="select[id=\"report_period\"]")
    WebElement ShowBy;
    @FindBy(css="button[title=\"Refresh\"]")
    WebElement Refresh;
@FindBy(xpath="//th[contains(text(),\"Total\")]")
WebElement ResultPeriod;




    public void  OpenCustomerByNumberOfOrdersPage() throws InterruptedException {
        testUtility.waitForElementPresent(ReportsLink);
        ReportsLink.click();
        testUtility.waitForElementPresent(CustomerReportsLink);
        CustomerReportsLink.click();
        Thread.sleep(3000);
     //   testUtility.waitForElementPresent(ByNumberOfOrder);
        ByNumberOfOrder.click();

    }
    public void ShowCustomersByNumberOfOrdersReportMethod(String startDate,String endDate) throws InterruptedException {
        //  Thread.sleep(3000);
        testUtility.waitForElementPresent(ReportFrom);
        ReportFrom.sendKeys(startDate);
        testUtility.waitForElementPresent(ReportTo);
        ReportTo.sendKeys(endDate);
        testUtility.waitForElementPresent(ShowBy);
        testUtility.selectValueFromDropDown(ShowBy,"year");
        testUtility.waitForElementPresent(Refresh);
        Refresh.click();
    }
    public boolean verifyReportsDisplayed(){
        testUtility.waitForElementPresent(ResultPeriod);
        return ResultPeriod.isDisplayed();
    }
    }


