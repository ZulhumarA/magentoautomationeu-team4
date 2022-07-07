package com.seleniummaster.ui.frontend;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewOrderPage {
    TestUtility utility;
    WebDriver driver;

    @FindBy (xpath ="//li[@class='current']//strong")
    WebElement MyOrderButton;

    @FindBy (xpath = "//*[contains(text(),\"View Order\")]")
    WebElement ViewOrderButton;

    @FindBy(css = ".link-print")
    WebElement PrintOrderButton;


    public ViewOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);

    }

    public void OpenMyOrders(){
        utility.waitForElementPresent(MyOrderButton);
        MyOrderButton.click();
    }

    public void ViewOrder(){
        utility.waitForElementPresent(ViewOrderButton);
        ViewOrderButton.click();
    }

    public boolean VerifyOrders(){
        utility.waitForElementPresent(PrintOrderButton);
        return PrintOrderButton.isDisplayed();
    }
}
