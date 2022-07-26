package com.seleniummaster.ui.backend.storemodule;

import com.seleniummaster.configutility.TestUtility;
import io.cucumber.java.ur.فرضکیا;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

public class CancelOrdersPage {
    WebDriver driver;
    TestUtility testUtility;

    @FindAll(@FindBy(xpath ="//*[@id=\"sales_order_grid_table\"]/tbody/tr"))
    List<WebElement> tableRows;

    @FindBy(css = "p.form-buttons>button[title=\"Cancel\"]")
    WebElement cancelButton;

    @FindBy(css = "#messages > ul > li > ul > li")
    WebElement successfulMessage;

    @FindBy(css = "#nav > li:nth-child(1) > a")
    WebElement salesLink;

    @FindBy(css = "#nav > li:nth-child(1) > ul > li:nth-child(1) > a")
    WebElement ordersLink;

    @FindBy(css = "#sales_order_grid > table > tbody > tr > td.pager > a:nth-child(3)")
    WebElement nextPageLink;

    public CancelOrdersPage(WebDriver driver) {
        this.driver = driver;
        testUtility=new TestUtility(driver);
        PageFactory.initElements(driver,this);
    }


    //methods
    public void cancelOrders() {
        testUtility.waitForElementPresent(salesLink);
        salesLink.click();
        testUtility.waitForElementPresent(ordersLink);
        ordersLink.click();
        int tableRowsNumber = tableRows.size();
        System.out.println("look here plz"+ tableRowsNumber);
        String statusNameLocation;
        String statusName;
        for (int i = 0; i < tableRowsNumber; i++) {
            statusNameLocation = String.format("//*[@id=\"sales_order_grid_table\"]/tbody/tr[%d]/td[9]",(i+1));
            statusName=driver.findElement(By.xpath(statusNameLocation)).getText();
            testUtility.sleep(2);
            if (statusName.contains("Pending")){
                String viewButtonLocation=String.format("//*[@id=\"sales_order_grid_table\"]/tbody/tr[%d]/td[10]/a",(i+1));
                WebElement ViewButton=driver.findElement(By.xpath(viewButtonLocation));
                testUtility.waitForElementPresent(ViewButton);
                ViewButton.click();
                testUtility.waitForElementPresent(cancelButton);
                cancelButton.click();
                driver.switchTo().alert().accept();
                return;
            }
        }

              testUtility.waitForElementPresent(nextPageLink);
              nextPageLink.click();
        for (int i = 0; i < tableRowsNumber; i++) {
            statusNameLocation = String.format("//*[@id=\"sales_order_grid_table\"]/tbody/tr[%d]/td[9]",(i+1));
            statusName=driver.findElement(By.xpath(statusNameLocation)).getText();
            testUtility.sleep(2);
            if (statusName.contains("Pending")){
                String viewButtonLocation=String.format("//*[@id=\"sales_order_grid_table\"]/tbody/tr[%d]/td[10]/a",(i+1));
                WebElement ViewButton=driver.findElement(By.xpath(viewButtonLocation));
                testUtility.waitForElementPresent(ViewButton);
                ViewButton.click();
                testUtility.waitForElementPresent(cancelButton);
                cancelButton.click();
                driver.switchTo().alert().accept();
                return;
            }
        }
        testUtility.waitForElementPresent(nextPageLink);
        nextPageLink.click();
        for (int i = 0; i < tableRowsNumber; i++) {
            statusNameLocation = String.format("//*[@id=\"sales_order_grid_table\"]/tbody/tr[%d]/td[9]",(i+1));
            statusName=driver.findElement(By.xpath(statusNameLocation)).getText();
            testUtility.sleep(2);
            if (statusName.contains("Pending")){
                String viewButtonLocation=String.format("//*[@id=\"sales_order_grid_table\"]/tbody/tr[%d]/td[10]/a",(i+1));
                WebElement ViewButton=driver.findElement(By.xpath(viewButtonLocation));
                testUtility.waitForElementPresent(ViewButton);
                ViewButton.click();
                testUtility.waitForElementPresent(cancelButton);
                cancelButton.click();
                driver.switchTo().alert().accept();
                return;
            }
        }

        testUtility.waitForElementPresent(nextPageLink);
        nextPageLink.click();
        for (int i = 0; i < tableRowsNumber; i++) {
            statusNameLocation = String.format("//*[@id=\"sales_order_grid_table\"]/tbody/tr[%d]/td[9]",(i+1));
            statusName=driver.findElement(By.xpath(statusNameLocation)).getText();
            testUtility.sleep(2);
            if (statusName.contains("Pending")){
                String viewButtonLocation=String.format("//*[@id=\"sales_order_grid_table\"]/tbody/tr[%d]/td[10]/a",(i+1));
                WebElement ViewButton=driver.findElement(By.xpath(viewButtonLocation));
                testUtility.waitForElementPresent(ViewButton);
                ViewButton.click();
                testUtility.waitForElementPresent(cancelButton);
                cancelButton.click();
                driver.switchTo().alert().accept();
                return;
            }
        }

        testUtility.waitForElementPresent(nextPageLink);
        nextPageLink.click();
        for (int i = 0; i < tableRowsNumber; i++) {
            statusNameLocation = String.format("//*[@id=\"sales_order_grid_table\"]/tbody/tr[%d]/td[9]",(i+1));
            statusName=driver.findElement(By.xpath(statusNameLocation)).getText();
            testUtility.sleep(2);
            if (statusName.contains("Pending")){
                String viewButtonLocation=String.format("//*[@id=\"sales_order_grid_table\"]/tbody/tr[%d]/td[10]/a",(i+1));
                WebElement ViewButton=driver.findElement(By.xpath(viewButtonLocation));
                testUtility.waitForElementPresent(ViewButton);
                ViewButton.click();
                testUtility.waitForElementPresent(cancelButton);
                cancelButton.click();
                driver.switchTo().alert().accept();
                return;
            }
        }

    }




    public boolean verifyCancelOrdersSuccessfully(){
      testUtility.waitForElementPresent(successfulMessage);
      if (successfulMessage.isDisplayed())
          return true;
      else
          return false;
    }
}
