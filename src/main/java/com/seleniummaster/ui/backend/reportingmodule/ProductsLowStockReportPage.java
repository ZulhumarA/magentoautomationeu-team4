package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsLowStockReportPage {
     WebDriver driver;

     TestUtility testUtility;

     int reportRowSize;

     public ProductsLowStockReportPage(WebDriver driver){
         this.driver=driver;
         PageFactory.initElements(driver,this);
         testUtility=new TestUtility(driver);
     }

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement reportsButton;

    @FindBy(xpath = "//span[text()='Products']")
    WebElement productsButton;

    @FindBy(xpath = "//span[text()='Low stock']")
    WebElement lowStockButton;

    public void viewProductsLowStockReport(){
        testUtility.waitForElementPresent(reportsButton);
        reportsButton.click();
        testUtility.waitForElementPresent(productsButton);
        productsButton.click();
        testUtility.waitForElementPresent(lowStockButton);
        lowStockButton.click();
    }

    public boolean verifyProductsLowStockReportDisplayed(){
        List<WebElement> rows=driver.findElements(By.cssSelector("table.data>tbody>tr"));
        reportRowSize=rows.size();
        return reportRowSize>0;
    }
}
