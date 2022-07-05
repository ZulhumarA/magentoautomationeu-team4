package com.seleniummaster.ui.backend.marketingmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class FilterShoppingCartPricingRuleByIdAndRule {
    WebDriver driver;
    TestUtility utility;
    @FindBy(xpath = "//span[text()=\"Promotions\"]")
    WebElement PromotionButton;

    @FindBy(xpath = "//span[text()=\"Shopping Cart Price Rules\"]")
    WebElement shoppingCartPriceRule;

    @FindBy(css = "input[name='rule_id']")
    WebElement RuleIdField;

    @FindBy(css = "input[name='name']")
    WebElement NameFiled;

    @FindBy(css = "button[title=\"Search\"]")
    WebElement SaveButton;

    @FindBy(css = "button[title=\"Reset Filter\"]")
    WebElement resetButton;

    public FilterShoppingCartPricingRuleByIdAndRule(WebDriver driver) {
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

    public boolean changeIdAndVerifyIt() {
        utility.waitForElementPresent(RuleIdField);
        List<WebElement> AllId = driver.findElements(By.cssSelector("div[class='hor-scroll'] td[class='a-right ']"));
        List<String> all_elements_text = new ArrayList<>();
        for (int i = 0; i < AllId.size(); i++) {
            all_elements_text.add(AllId.get(i).getText());
        }
        RuleIdField.sendKeys(all_elements_text.get(0));
        SaveButton.click();
        List<WebElement> AllIdAfterFilter = driver.findElements(By.cssSelector("div[class='hor-scroll'] td[class='a-right ']"));
        if (AllId.size() == AllIdAfterFilter.size()) {
            return false;
        } else {
            return true;
        }
    }

    public void resetTheFilter() {
        resetButton.click();
    }

    public boolean changeRuleNameAndVerify() {
        utility.waitForElementPresent(NameFiled);
        List<WebElement> AllRuleNameTitle = driver.findElements(By.cssSelector("div[class='hor-scroll'] tr[title]"));
        int numberOfAllRuleName = AllRuleNameTitle.size();
        List<String> all_RuleElements_text = new ArrayList<>();
        List<WebElement> AllRuleName = new ArrayList<>();
        for (int i = 1; i <= numberOfAllRuleName; i++) {
            AllRuleName.add(driver.findElement(By.cssSelector("div[class='hor-scroll'] tr[title]:nth-child(" + i + ")>td:nth-child(2)")));
            all_RuleElements_text.add(AllRuleName.get(i - 1).getText());
            System.out.println(AllRuleName.get(i-1).getText());
        }
        NameFiled.sendKeys(all_RuleElements_text.get(0));
        SaveButton.click();
        List<WebElement> AllIdAfterFilter = driver.findElements(By.cssSelector("div[class='hor-scroll'] tr[title]:nth-child(1)>td:nth-child(2)"));
        if (numberOfAllRuleName == AllIdAfterFilter.size()) {
            return false;
        } else {
            return true;
        }
    }


}

