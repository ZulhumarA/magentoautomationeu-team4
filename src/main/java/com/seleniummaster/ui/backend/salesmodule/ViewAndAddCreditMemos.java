package com.seleniummaster.ui.backend.salesmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAndAddCreditMemos {
    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath = "//span[text()=\"Sales\"]")
    WebElement Sales;

    @FindBy(xpath="//span[contains(.,'Credit Memos')]")
    WebElement SalesCreditMemos;

    @FindBy(xpath="//a[contains(text(),'View')]")
    WebElement ViewButton;

    @FindBy(id="history_comment")
    WebElement  CommentText;

    @FindBy(id="history_notify")
    WebElement  NotifyCustomer;

    @FindBy(id="history_visible")
    WebElement  VisibleOnFrontend;

    @FindBy(css = "button[title=\"Submit Comment\"]")
    WebElement SubmitCommentButton;

    @FindBy(css="button[title='Send Email']")
    WebElement SendEmailButton;

    @FindBy(xpath="//span[contains(.,'The message was sent.')]")
    WebElement SuccessfulMessage;

    public ViewAndAddCreditMemos(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void CreditMemos(){

        testUtility.waitForElementPresent(Sales);
        Sales.click();
        SalesCreditMemos.click();
        testUtility.waitForElementPresent(ViewButton);
        ViewButton.click();
        testUtility.waitForElementPresent(CommentText);
        CommentText.click();
        CommentText.sendKeys("GOOD");
        NotifyCustomer.click();
        VisibleOnFrontend.click();
        SubmitCommentButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SendEmailButton.click();
        driver.switchTo().alert().accept();
    }
    public boolean VerifySendSuccessfulMessage(){
        testUtility.waitForElementPresent(SuccessfulMessage);
        return SuccessfulMessage.isDisplayed();
    }

}
