package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SeeProductsLowStockReportsAbide {

    WebDriver driver;
    TestUtility testUtility;
    Actions actions;

@FindBy(css = "ul#nav>li:nth-child(3)>a")
WebElement reportsLink;

@FindBy(css = "#nav > li.active.parent.level0 > ul > li:nth-child(3)")
WebElement productsLink;

@FindBy(css = "#nav > li.active.parent.level0 > ul > li:nth-child(3) > ul > li:nth-child(4) > a")
WebElement lowStockLink;

@FindAll(@FindBy(css = "table#gridLowstock_table>tbody>tr:nth-child(1)") )
List<WebElement> firstLineLowStockReportInTable;

    public SeeProductsLowStockReportsAbide(WebDriver driver) {
        this.driver = driver;
        testUtility=new TestUtility(driver);
        actions=new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    //Methods
    public void canSeeProductLowStockReports(){
        testUtility.waitForElementPresent(reportsLink);
        reportsLink.click();
       actions.moveToElement(reportsLink).click().perform();
        testUtility.waitForElementPresent(lowStockLink);
        lowStockLink.click();
    }

    public boolean verifyReportingViewedSuccessfully(){
        firstLineLowStockReportInTable=new ArrayList<>();
        int rowNumber= firstLineLowStockReportInTable.size();
        if (rowNumber>=1)
            return true;
        else
            return false;
    }

}
