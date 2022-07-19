package com.seleniummaster.ui.backend.marketingmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class ViewNewsletterSubscribersPage {

    WebDriver driver;

    TestUtility testUtility;

    String statusOfCustomer;

    public ViewNewsletterSubscribersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(xpath = "//span[text()='Newsletter']")
    WebElement newsletterButton;

    @FindBy(xpath = "//span[text()='Newsletter Subscribers']")
    WebElement newsletterSubscribersButton;

    @FindBy(css = "div.content-header>table>tbody>tr>td")
    WebElement newsletterSubscribersTitle;

    @FindBy(xpath = "//*[@class='hor-scroll']/table/tbody/tr[1]/td[8]")
    WebElement customerStatus;

    public void viewNewsletterSubscribers(){
        testUtility.waitForElementPresent(newsletterButton);
        newsletterButton.click();
        testUtility.waitForElementPresent(newsletterSubscribersButton);
        newsletterSubscribersButton.click();
    }

    public boolean verifyNewsletterSubscribersViewed(){
        statusOfCustomer= customerStatus.getText();
        System.out.println("status of customer is: "+statusOfCustomer);
        return Objects.equals(statusOfCustomer, "Subscribed");
    }
}