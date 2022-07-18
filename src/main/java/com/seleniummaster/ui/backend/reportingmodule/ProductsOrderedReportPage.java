package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsOrderedReportPage {

    WebDriver driver;

    TestUtility testUtility;

    int reportTableRowSize;

    public ProductsOrderedReportPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement reportsButton;

    @FindBy(xpath = "//span[text()='Products']")
    WebElement productsButton;

    @FindBy(xpath = "//span[text()='Products Ordered']")
    WebElement productsOrderedButton;

    @FindBy(id = "period_date_from")
    WebElement fromDateField;

    @FindBy(id = "period_date_to")
    WebElement toDateField;

    @FindBy(id = "report_period")
    WebElement reportPeriodDropdown;

    @FindBy(xpath = "//span[text()='Refresh']")
    WebElement refreshButton;

    public void viewProductsOrderedReport(String startDate,String endDate){
       testUtility.waitForElementPresent(reportsButton);
       reportsButton.click();
       testUtility.waitForElementPresent(productsButton);
       productsButton.click();
       testUtility.waitForElementPresent(productsOrderedButton);
       productsOrderedButton.click();
       testUtility.waitForElementPresent(fromDateField);
       fromDateField.click();
       fromDateField.sendKeys(startDate);
       testUtility.waitForElementPresent(toDateField);
       toDateField.click();
       toDateField.sendKeys(endDate);
       testUtility.waitForElementPresent(reportPeriodDropdown);
       testUtility.selectValueFromDropDown(reportPeriodDropdown,"year");
       testUtility.waitForElementPresent(refreshButton);
       refreshButton.click();
    }

    public boolean verifyProductsOrderedReportDisplayed(){
        List<WebElement> rows=driver.findElements(By.cssSelector("table.data>tbody>tr"));
        reportTableRowSize=rows.size();
        return reportTableRowSize > 0;
    }
//    @FindBy(id = "period_date_from_trig")
//    WebElement calendarFrom;
//
//    @FindBy(id = "period_date_to_trig")
//    WebElement calendarTo;
//
//    @FindBy(css = "div.calendar")
//    WebElement calendarOpened;
//
//    @FindBy(css = "div.calendar>table>thead>tr:nth-child(2)>td:nth-child(1)")
//    WebElement holdToSelectYear;












}
