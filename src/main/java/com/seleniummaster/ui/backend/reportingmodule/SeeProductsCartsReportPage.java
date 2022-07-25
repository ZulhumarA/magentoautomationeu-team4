package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SeeProductsCartsReportPage extends TestBase {
    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement reportButton;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    WebElement shoppingCartButton;

    @FindBy(xpath = "//span[text()='Products in carts']")
    WebElement productsInCartsButton;

    @FindBy(css = "div[id='gridProducts'] button[title='Export']")
    WebElement exportButton;

    @FindBy(xpath = "//*[@id=\"page:main-container\"]/div[2]/table/tbody/tr/td[1]/h3")
    WebElement massages;

    public SeeProductsCartsReportPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }
    public void clickReportButton(){
        testUtility.waitForElementPresent(reportButton);
        reportButton.click();
    }
    public void clickShoppingCartsButton(){
        testUtility.waitForElementPresent(shoppingCartButton);
        shoppingCartButton.click();
    }
    public void clickProductInCartsButton(){
        testUtility.waitForElementPresent(productsInCartsButton);
        productsInCartsButton.click();
    }
    public void clickExportButton(){
        testUtility.waitForElementPresent(exportButton);
        exportButton.click();
    }
    public boolean VerifyMassageDisplay(){
        testUtility.waitForElementPresent(massages);
        return massages.isDisplayed();
    }
}
