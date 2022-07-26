package com.seleniummaster.ui.backend.salesmodule;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCouponsInTheReports {

    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath = "//span[text()=\"Reports\"]")
    WebElement Reports;

    @FindBy(xpath="//ul[@id='nav']/li[7]/ul/li/a/span")
    WebElement ReportsSales;

    @FindBy(xpath="//span[contains(.,'Coupons')]")
    WebElement SalesCoupons;

    @FindBy(css = "button[title=\"Show Report\"]")
    WebElement ShowReportButton;

    @FindBy(id="sales_report_from")
    WebElement FromArea;

    @FindBy(id="sales_report_to")
    WebElement ToArea;

    @FindBy(xpath="//th[contains(.,'Total')]")
    WebElement Total;


    public ViewCouponsInTheReports(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void CouponsInTheReports(){

        testUtility.waitForElementPresent(Reports);
        Reports.click();
        testUtility.waitForElementPresent(ReportsSales);
        ReportsSales.click();
        testUtility.waitForElementPresent(SalesCoupons);
        SalesCoupons.click();
        testUtility.waitForElementPresent(FromArea);
        FromArea.click();
        FromArea.sendKeys("06/18/2010");
        ToArea.click();
        ToArea.sendKeys("06/18/2022");
        ShowReportButton.click();
    }

    public boolean VerifyViewCoupons(){
        testUtility.waitForElementPresent(Total);
        return Total.isDisplayed();
    }

}
