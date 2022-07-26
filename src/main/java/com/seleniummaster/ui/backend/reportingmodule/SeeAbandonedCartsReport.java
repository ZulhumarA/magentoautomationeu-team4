package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeeAbandonedCartsReport extends TestBase {

    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement reportButton;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    WebElement shoppingCartButton;

    @FindBy(xpath = "//span[text()='Abandoned carts']")
    WebElement abandonedCartsButton;

    @FindBy(css = "div[id='gridAbandoned'] button[title='Export']")
    WebElement exportButton;

    @FindBy(xpath = "//*[@id=\"page:main-container\"]/div[2]/table/tbody/tr/td[1]/h3")
    WebElement massages;

    public SeeAbandonedCartsReport(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }
    public void setReportButton(){
        testUtility.waitForElementPresent(reportButton);
        reportButton.click();
    }
    public void setShoppingCartsButton(){
        testUtility.waitForElementPresent(shoppingCartButton);
        shoppingCartButton.click();
    }
    public void setAbandonedCartsButton(){
        testUtility.waitForElementPresent(abandonedCartsButton);
        abandonedCartsButton.click();
    }
    public void setExportButton(){
        testUtility.waitForElementPresent(exportButton);
        exportButton.click();
    }
    public boolean VerifyReportMassageDisplay(){
        testUtility.waitForElementPresent(massages);
        return massages.isDisplayed();
    }
}
