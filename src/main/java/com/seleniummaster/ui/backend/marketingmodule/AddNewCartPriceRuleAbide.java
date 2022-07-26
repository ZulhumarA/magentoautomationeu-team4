package com.seleniummaster.ui.backend.marketingmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCartPriceRuleAbide {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(css = "#nav > li:nth-child(4) > a")
    WebElement promotionsLink;

    @FindBy(css = "#nav > li:nth-child(4) > ul > li.last.level1 > a")
    WebElement shoppingCartRulesLink;

    @FindBy(css = "tr>td.form-buttons>button[title=\"Add New Rule\" ]")
    WebElement addNewRuleButton;

    @FindBy(css = "#rule_name")
    WebElement RuleNameField;

    @FindBy(css = "#rule_customer_group_ids>option[value=\"1\"]")
    WebElement customerGroupsOption;

    @FindBy(css = "#rule_website_ids>option[value=\"1\"]")
    WebElement websitesOption;

    @FindBy(css = "div.content-header>p.form-buttons>button:nth-child(3)[title=\"Save\"]")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement successfulMessage;

    public AddNewCartPriceRuleAbide(WebDriver driver) {
        this.driver = driver;
        testUtility=new TestUtility(driver);
        PageFactory.initElements(driver,this);
    }

    //methods
    public void addNewCartPriceRuleMethod(){
        testUtility.waitForElementPresent(promotionsLink);
        promotionsLink.click();
        testUtility.waitForElementPresent(shoppingCartRulesLink);
        shoppingCartRulesLink.click();
        testUtility.waitForElementPresent(addNewRuleButton);
        addNewRuleButton.click();
        testUtility.waitForElementPresent(RuleNameField);
        testUtility.sleep(1);
        RuleNameField.sendKeys(testUtility.fakeCartPriceRulesName());
        testUtility.sleep(1);
        testUtility.waitForElementPresent(websitesOption);
        websitesOption.click();
        testUtility.sleep(1);
        testUtility.waitForElementPresent(customerGroupsOption);
        customerGroupsOption.click();
        testUtility.sleep(1);
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean verifyCartPriceRulesAddedSuccessfully(){
        testUtility.waitForElementPresent(successfulMessage);
        if (successfulMessage.isDisplayed())
            return true;
        else
            return false;
    }
}
