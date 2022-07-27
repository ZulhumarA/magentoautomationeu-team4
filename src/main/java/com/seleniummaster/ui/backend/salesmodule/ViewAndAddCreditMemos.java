package com.seleniummaster.ui.backend.salesmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(css = "input[id='sales_creditmemo_grid_filter_increment_id']")
    WebElement CreditMemosFiled;

    @FindBy(css = "button[title='Search']")
    WebElement SearchButton;

    @FindBy(css="tbody td[class=' ']")
    WebElement verifyButton;

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

    public void OpenCreditMemosPage(){
        testUtility.waitForElementPresent(Sales);
        Sales.click();
        SalesCreditMemos.click();
    }

    public void FilterCreditMemos(){
        List<WebElement> column = driver.findElements(By.cssSelector("table[id='sales_creditmemo_grid_table'] tbody tr :nth-child(2)"));
        int numberOfColumn = column.size();
        List<String> allCreditMemoText = new ArrayList<>();
        for (int i = 1; i <= numberOfColumn; i++) {
            column.add(driver.findElement(By.cssSelector("table[id='sales_creditmemo_grid_table'] tbody tr td:nth-child(2)")));
            allCreditMemoText.add(column.get(i - 1).getText());
            System.out.println(allCreditMemoText.get(i-1));
        }
        CreditMemosFiled.sendKeys(allCreditMemoText.get(0));
        testUtility.waitForElementPresent(SearchButton);
        SearchButton.click();

    }

    public void VerifyFilterCreditMemos(){
        verifyButton.isDisplayed();
    }


}
