package com.seleniummaster.ui.backend.marketingmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateCartPriceRule {
    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "//span[text()=\"Promotions\"]")
    WebElement PromotionButton;

    @FindBy(xpath = "//span[text()=\"Shopping Cart Price Rules\"]")
    WebElement shoppingCartPriceRule;

    @FindBy(css = "input[name='name']")
    WebElement NameFiled;

    @FindBy(css = "input[name='rule_id']")
    WebElement RuleIdField;

    @FindBy(css = "div[class='hor-scroll'] tr[title]:nth-child(1)>td:nth-child(2)")
    WebElement FirstColumn;

    @FindBy(css = "input[id=\"rule_name\"]")
    WebElement RuleName;

    @FindBy(css = "div[class='content-header-floating'] button[title=\"Save\"]")
    WebElement FloatSaveButton;

    @FindBy(css = "div[id='content'] button[title='Save']")
    WebElement StableSaveButton;

    @FindBy(css = "li[class='success-msg']")
    WebElement successfulMessage;

    @FindBy(css="a[name=\"from_date\"]")
    WebElement DateStart;


    public UpdateCartPriceRule(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void OpenShoppingCartPricesRules() {
        utility.waitForElementPresent(PromotionButton);
        PromotionButton.click();
        utility.waitForElementPresent(shoppingCartPriceRule);
        shoppingCartPriceRule.click();
    }

    public void UpdateRule() {
        utility.waitForElementPresent(NameFiled);
        NameFiled.sendKeys("Get");
        utility.waitForElementPresent(DateStart);
        DateStart.click();
        utility.waitForElementPresent(FirstColumn);
        FirstColumn.click();
        utility.waitForElementPresent(RuleName);
        RuleName.sendKeys("\u0008");
        utility.waitForElementPresent(StableSaveButton);
        StableSaveButton.click();
    }

    public boolean VerifyUpdate(){
        utility.waitForElementPresent(successfulMessage);
        return successfulMessage.isDisplayed();
    }
}
