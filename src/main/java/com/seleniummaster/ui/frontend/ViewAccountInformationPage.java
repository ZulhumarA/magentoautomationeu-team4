package com.seleniummaster.ui.frontend;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAccountInformationPage {
    TestUtility testUtility;

    WebDriver driver;
    @FindBy(css = "div.account-cart-wrapper a.skip-link.skip-account .label")
    WebElement AccountButton;

    @FindBy(css = "li.current a")
    WebElement AccountInformationButton;

    @FindBy(css = "div.page-title h1")
    WebElement AccountInformationSuccessfulMessage;

    public ViewAccountInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void openAccountInformation() {
        testUtility.waitForElementPresent(AccountInformationButton);
        AccountInformationButton.click();
    }

    public boolean verifyAccountInformation() {
        testUtility.waitForElementPresent(AccountInformationSuccessfulMessage);
        return AccountInformationSuccessfulMessage.isDisplayed();
    }


}
