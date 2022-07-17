package com.seleniummaster.ui.backend.marketingmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCartPriceRule {
    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "//span[text()=\"Promotions\"]")
    WebElement PromotionButton;

    @FindBy(xpath = "//span[text()=\"Shopping Cart Price Rules\"]")
    WebElement shoppingCartPriceRule;

    @FindBy(css = "button[title=\"Add New Rule\"]")
    WebElement AddNewRule;

    @FindBy(css = "input[id=\"rule_name\"]")
    WebElement RuleName;

    @FindBy(css = "select[id=\"rule_is_active\"]")
    WebElement status;

    @FindBy(css = "select[id=\"rule_website_ids\"]")
    WebElement Websites;

    @FindBy(css = "select[id=\"rule_customer_group_ids\"]")
    WebElement CustomerGroups;

    @FindBy(css = "select[id=\"rule_coupon_type\"]")
    WebElement Coupon;

    @FindBy(css = "div[class='content-header-floating'] button[title=\"Save\"]")
    WebElement SaveButton;

    @FindBy(css = "li[class='success-msg']")
    WebElement successfulMessage;

    public AddNewCartPriceRule(WebDriver driver) {
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

    public void CreateShoppingCardRule() {
        utility.waitForElementPresent(AddNewRule);
        AddNewRule.click();
        utility.waitForElementPresent(RuleName);
        RuleName.sendKeys("Get" + ((int) (Math.random() * 100) + 5) + "% off in the shopping car");
        utility.waitForElementPresent(status);
        status.click();
        Select select = new Select(status);
        select.selectByIndex(((int) (Math.random() * 0) + 1));
        Select select1 = new Select(Websites);
        select1.selectByIndex(((int) (Math.random() * 1) + 14));
        Select select2 = new Select(CustomerGroups);
        select2.selectByIndex(((int) (Math.random() * 1) + 19));
        Select select3 = new Select(Coupon);
        select3.selectByIndex(0);
        utility.waitForElementPresent(SaveButton);
        SaveButton.click();
    }

    public boolean VerifyAddNewRule() {
        utility.waitForElementPresent(successfulMessage);
        return successfulMessage.isDisplayed();
    }


}
