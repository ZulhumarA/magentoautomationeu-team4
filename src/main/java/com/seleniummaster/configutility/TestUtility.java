package com.seleniummaster.configutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtility {

    public TestUtility(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
