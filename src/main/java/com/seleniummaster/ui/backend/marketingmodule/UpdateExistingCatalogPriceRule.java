package com.seleniummaster.ui.backend.marketingmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UpdateExistingCatalogPriceRule extends TestBase {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "//span[text()=\"Promotions\"]")
    WebElement PromotionButton;

    @FindBy(xpath="//span[text()=\"Catalog Price Rules\"]")
    WebElement CatalogPriceRuleButton;

    @FindBy(css = "input[id=\"promo_catalog_grid_filter_name\"]")
    WebElement RuleNameFılterFiled;

    @FindBy(css = "button[title=\"Search\"]")
    WebElement SearchButton;

    @FindBy(css = "div[class='hor-scroll'] tr[title]:nth-child(1)>td:nth-child(2)")
    WebElement FirstFilteredCatalogPriceRule;

    @FindBy(xpath = "//*[@id ='rule_description']")
    WebElement DescriptionLink;

    @FindBy(id = "rule_is_active")
    WebElement StatusDropDown;

    @FindBy(id = "rule_website_ids")
    WebElement WebSiteLink;

    @FindBy(id = "rule_customer_group_ids")
    WebElement customerGroupLink;

    @FindBy(css = "  button[title='Save']")
    WebElement SaveButton;

    @FindBy(css = "li[class='success-msg']")
    WebElement SuccessMessage;


    public UpdateExistingCatalogPriceRule(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);

    }
    public void updateCatalogPriceRule(String ruleName){
        testUtility.waitForElementPresent(PromotionButton);
        PromotionButton.click();
        testUtility.waitForElementPresent(CatalogPriceRuleButton);
        CatalogPriceRuleButton.click();
        testUtility.waitForElementPresent(RuleNameFılterFiled);
        RuleNameFılterFiled.sendKeys(ruleName);
        testUtility.waitForElementPresent(SearchButton);
        SearchButton.click();
        testUtility.waitForElementPresent(FirstFilteredCatalogPriceRule);
        FirstFilteredCatalogPriceRule.click();
        testUtility.waitForElementPresent(DescriptionLink);
        DescriptionLink.sendKeys(testUtility.generateRandomSentence());
        testUtility.waitForElementPresent(StatusDropDown);
        testUtility.selectValueFromDropDown(StatusDropDown,1);
        Select webSites=new Select(WebSiteLink);
        testUtility.waitForElementPresent(WebSiteLink);
        webSites.selectByValue("21");
        Select customerGroup=new Select(customerGroupLink);
        testUtility.waitForElementPresent(customerGroupLink);
        customerGroup.selectByValue("110");
        testUtility.waitForElementPresent(SaveButton);
        SaveButton.click();
    }
    public boolean verifyUpdateExistingCatalogPriceRule(){
        testUtility.waitForElementPresent(SuccessMessage);
        return SuccessMessage.isDisplayed();
    }


}
