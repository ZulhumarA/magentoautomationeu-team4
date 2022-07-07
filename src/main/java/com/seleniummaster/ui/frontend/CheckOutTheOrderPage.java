package com.seleniummaster.ui.frontend;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutTheOrderPage {

    TestUtility testUtility;

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'My Orders')]") // div.block-content [href="http://magentoqa2.unitedcoder.com/sales/order/history/"]
    WebElement MyOrders;

    @FindBy(css = "div.page-title h1")
    WebElement MyOrdersSuccessfulMessage;

    public CheckOutTheOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void openMyOrders() {
        testUtility.waitForElementPresent(MyOrders);
        MyOrders.click();
    }

    public boolean verifyMyOrders() {
        testUtility.waitForElementPresent(MyOrdersSuccessfulMessage);
        return true;
    }
}
