package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeeProductsBestsellersReport extends TestBase {

    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement reportButton;

    @FindBy(xpath = "//span[text()='Products']")
    WebElement productButton;

    @FindBy(xpath = "//span[text()='Bestsellers']")
    WebElement bestsellersButton;

    @FindBy(xpath = "//*[@id='sales_report_period_type']")
    WebElement enterPeriod;

    @FindBy(xpath = "//*[@id=\"sales_report_from\"]")
    WebElement enterFrom;

    @FindBy(xpath = "//*[@id=\"sales_report_to\"]")
    WebElement enterTo;

    @FindBy(xpath = "//*[@id=\"sales_report_show_empty_rows\"]")
    WebElement enterEmptyRows;

    @FindBy(css = "div[class='content-header'] button[title='Show Report']")
    WebElement clickShowReportButton;

    @FindBy(css = "td[class='export a-right'] button[title='Export']")
    WebElement clickExportButton;

    @FindBy(xpath = "//*[@id=\"page:main-container\"]/div[2]/table/tbody/tr/td[1]/h3")
    WebElement showHeadings;

    public SeeProductsBestsellersReport(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }
    public void ReportButton(){
        testUtility.waitForElementPresent(reportButton);
        reportButton.click();
    }
    public void ProductButton(){
        testUtility.waitForElementPresent(productButton);
        productButton.click();
    }
    public void BestsellersButton(){
        testUtility.waitForElementPresent(bestsellersButton);
        bestsellersButton.click();
    }
    public void EnterPeriod(){
        testUtility.selectValueFromDropDown(enterPeriod,"year");
    }
    public void EnterFrom(String StartDay){
        testUtility.waitForElementPresent(enterFrom);
        enterFrom.sendKeys(StartDay);
    }
    public void EnterTo(String EndDay){
        testUtility.waitForElementPresent(enterTo);
        enterTo.sendKeys(EndDay);
    }
    public void EnterEmptyRows(){
        testUtility.selectValueFromDropDown(enterEmptyRows,"1");
    }
    public void ClickShowReportButton(){
        testUtility.waitForElementPresent(clickShowReportButton);
        clickShowReportButton.click();
    }
    public void ClickExportButton(){
        testUtility.waitForElementPresent(clickExportButton);
        clickExportButton.click();
    }
    public boolean VerifyShowHeadingsList(){
        testUtility.waitForElementPresent(showHeadings);
        return showHeadings.isDisplayed();
    }

}
