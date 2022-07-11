package com.seleniummaster.ui.frontend;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewNewsletterSubscriptionLinkAndContentPage {
    WebDriver driver;
    TestUtility testUtility;

    //Elements
    @FindBy(css = "div.block-content>ul>li:nth-child(11)>a")
    WebElement newsletterSubscriptionLink;

    @FindBy(css = "button[title=\"Save\"]")
    WebElement  saveButton;

    @FindBy(css = "div.page-title>h1")
    WebElement pageTitleField;

    //Constructor
    public ViewNewsletterSubscriptionLinkAndContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    //methods
    public void ViewNewsletterSubscriptionLinkAndContent(){
        testUtility.waitForElementPresent(newsletterSubscriptionLink);
        newsletterSubscriptionLink.click();
    }


    public Boolean VerifyViewNewsletterSubscriptionLinkAndContent(){
        testUtility.waitForElementPresent(pageTitleField);
        if (pageTitleField.isDisplayed())
            return true;
        else
            return false;
    }

}
