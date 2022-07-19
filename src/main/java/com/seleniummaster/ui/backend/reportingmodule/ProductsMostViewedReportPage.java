package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsMostViewedReportPage {

    WebDriver driver;

    TestUtility testUtility;

    int reportRowSize;

    public ProductsMostViewedReportPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement reportsButton;

    @FindBy(xpath = "//span[text()='Products']")
    WebElement productsButton;

    @FindBy(xpath = "//span[text()='Most Viewed']")
    WebElement mostViewedButton;

   @FindBy(id = "sales_report_period_type")
    WebElement periodDropdown;

    @FindBy(id = "sales_report_from")
    WebElement fromDateField;

    @FindBy(id = "sales_report_to")
    WebElement toDateField;

    @FindBy(id = "sales_report_show_empty_rows")
    WebElement emptyRowsDropdown;

    @FindBy(xpath = "//span[text()='Show Report']")
    WebElement showReportButton;

    public void viewProductsMostViewedReport(String startDate,String endDate){
        testUtility.waitForElementPresent(reportsButton);
        reportsButton.click();
        testUtility.waitForElementPresent(productsButton);
        productsButton.click();
        testUtility.waitForElementPresent(mostViewedButton);
        mostViewedButton.click();
        testUtility.waitForElementPresent(periodDropdown);
        testUtility.selectValueFromDropDown(periodDropdown,"year");
        testUtility.waitForElementPresent(fromDateField);
        fromDateField.click();
        fromDateField.sendKeys(startDate);
        testUtility.waitForElementPresent(toDateField);
        toDateField.click();
        toDateField.sendKeys(endDate);
        testUtility.waitForElementPresent(emptyRowsDropdown);
        testUtility.selectValueFromDropDown(emptyRowsDropdown,"1");
        testUtility.waitForElementPresent(showReportButton);
        showReportButton.click();
    }

    public boolean verifyProductsMostViewedReportDisplayed(){
        List<WebElement> rows=driver.findElements(By.cssSelector("table.data>tbody>tr"));
        reportRowSize=rows.size();
        return reportRowSize>0;
    }


}
