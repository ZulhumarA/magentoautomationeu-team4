package com.seleniummaster.ui.frontend;

import com.google.common.base.Verify;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeeMyProductReviewsLinkAndContents {

    WebDriver driver;
    TestUtility testUtility;

    public SeeMyProductReviewsLinkAndContents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(xpath = "//*[text()=\"My Product Reviews\"]")
    WebElement MyProductReviewsButton;

    @FindBy(css = "div[class=\"page-title\"]")
    WebElement verifyWords;


    public void SeeMyProductReviews(){
        testUtility.waitForElementPresent(MyProductReviewsButton);
        MyProductReviewsButton.click();
    }

    public boolean Verify(){
        testUtility.waitForElementPresent(verifyWords);
        return verifyWords.isDisplayed();
    }

}
