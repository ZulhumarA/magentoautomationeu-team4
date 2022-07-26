package com.seleniummaster.ui.backend.marketingmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCatalogPriceRule extends TestBase {


    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath="//span[text()=\"Promotions\"]")
    WebElement PromotionButton;

    @FindBy(xpath="//span[text()=\"Catalog Price Rules\"]")
    WebElement CatalogPriceRuleButton;

    @FindBy(css = "button[title=\"Add New Rule\"]")
    WebElement AddNewRuleButton;

    @FindBy(xpath="//*[@id=\"rule_name\"]")
    WebElement RuleNameLink;

    @FindBy(id = "rule_is_active")
    WebElement StatusDropDown;

    @FindBy(id = "rule_website_ids")
    WebElement WebSiteLink;

    @FindBy(id = "rule_customer_group_ids")
    WebElement customerGroupLink;

    @FindBy(css="input[id=\"rule_from_date\"]")
    WebElement FromDateLInk;

    @FindBy(css = " button:nth-child(3)")
    WebElement SaveButton;

    @FindBy(css = "input[id=\"rule_discount_amount\"]")
    WebElement DiscountAmount;

    @FindBy(css = "li[class='success-msg']")
    WebElement SuccessMessage;


    public AddNewCatalogPriceRule(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void addCatalogPriceRule(String ruleName,String fromDate) throws InterruptedException {
        testUtility.waitForElementPresent(PromotionButton);
        PromotionButton.click();
        testUtility.waitForElementPresent(CatalogPriceRuleButton);
        CatalogPriceRuleButton.click();
        testUtility.waitForElementPresent(AddNewRuleButton);
        AddNewRuleButton.click();
        testUtility.waitForElementPresent(RuleNameLink);
        RuleNameLink.sendKeys(ruleName);
        Thread.sleep(3000);
        testUtility.waitForElementPresent(StatusDropDown);
        testUtility.selectValueFromDropDown(StatusDropDown,0);
        testUtility.waitForElementPresent(WebSiteLink);
        Select webSites=new Select(WebSiteLink);
        testUtility.waitForElementPresent(WebSiteLink);
        webSites.selectByValue("1");
        testUtility.waitForElementPresent(customerGroupLink);
        testUtility.selectValueFromDropDown(customerGroupLink,1);
        testUtility.waitForElementPresent(FromDateLInk);
        FromDateLInk.sendKeys(fromDate);
        testUtility.waitForElementPresent(SaveButton);
        SaveButton.click();
        testUtility.waitForElementPresent(DiscountAmount);
        DiscountAmount.sendKeys(String.valueOf(testUtility.generateRandomNumber()));
        testUtility.waitForElementPresent(SaveButton);
        SaveButton.click();


    }
    public boolean verifyAddNewCatalogPriceRule(){
        testUtility.waitForElementPresent(SuccessMessage);
        return SuccessMessage.isDisplayed();

    }

}
