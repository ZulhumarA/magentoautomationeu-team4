package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddAndUpdateExistingCustomerGroupsPage {
 // login to admin page
    //navigate to Customers-Customer Groups
    // click on Customer Groups that we want to change
    // change Customer Groups name and Tax class
    // Then "Save Customer Group" button
    // Verify

    @FindBy(css = "#nav>li:nth-child(1)>a")
    WebElement CustomersLink;

    @FindBy(linkText = "Customer Groups")
    WebElement CustomerGroupsLink;

    @FindBy(xpath = "*//button[@title=\"Reset Filter\"]/span/span")
    WebElement ResetFilterButton;

    @FindBy(xpath = "*//div/div[@id=\"anchor-content\"]/div/div/table/tbody/tr/td/button")
    WebElement AddNewCustomerGroupButton;

    @FindBy(xpath = "(*//p/button[@title=\"Save Customer Group\"]/span/span/span)[1]")
    WebElement SaveCustomerGroupButton;

    @FindBy(xpath = "//*[contains(text(),'The customer group has been saved.')]")
    WebElement CustomerGroupSavedSuccessMessage;

    @FindBy(id="customerGroupGrid_filter_type")
    WebElement CustomerGroupNameFilterInput;

    @FindBy(xpath = "*//div/div/div[@id=\"customerGroupGrid\"]/table/tbody/tr/td/button[@title=\"Search\"]")
    WebElement SearchButton;

    @FindBy(xpath = "*//div[@class=\"grid\"]/div/table/tbody/tr/td[1]")
    WebElement FirstSearchedResult;

    @FindBy(id = "customer_group_code")
    WebElement GroupName;

    @FindBy(id = "tax_class_id")
    WebElement TaxClass;

    @FindBy(xpath = "*//option[@value='3']")
    WebElement TaxClassRetailCustomerOption;

    @FindBy(xpath = "*//option[@value='5']")
    WebElement TaxClassWholesaleCustomerOption;

    @FindBy(xpath = "*//option[@value='7']")
    WebElement TaxClassGeneralOption;

    @FindBy(xpath = "*//option[@value='8']")
    WebElement TaxClassMembersOnlyOption;

    @FindBy(xpath = "*//option[@value='9']")
    WebElement TaxClassPrivateSalesOption;

    @FindBy(xpath = "*//option[@value='10']")
    WebElement TaxClassNotLoggedinOption;

    WebDriver driver;
    TestUtility testUtility;
    String customerGroupName="Team4"+System.currentTimeMillis();
    String customerGroupNameHolder=customerGroupName;
    String customerGroupNameUpdated="Team4Updated"+System.currentTimeMillis();
    public AddAndUpdateExistingCustomerGroupsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    // Navigate to Customer-Customer Groups page and Reset Filter
    public void navigateToCustomerGroups(){
        Actions actions = new Actions(driver);
        actions.moveToElement(CustomersLink).perform();
        actions.moveToElement(CustomerGroupsLink).click().perform();
        testUtility.waitForElementPresent(ResetFilterButton);
        ResetFilterButton.click();
    }
    public void addNewCustomerGroup(){
        testUtility.waitForElementPresent(AddNewCustomerGroupButton);
        AddNewCustomerGroupButton.click();
        GroupName.sendKeys(customerGroupName);
        TaxClass.click();
        TaxClassGeneralOption.click();
        SaveCustomerGroupButton.click();
    }
    public boolean verifyNewCustomerGroupAddedSuccessful(){
        testUtility.waitForElementPresent(CustomerGroupSavedSuccessMessage);
        return CustomerGroupSavedSuccessMessage.isDisplayed();
    }

    public void updateExistingCustomerGroup(){
        testUtility.waitForElementPresent(ResetFilterButton);
        CustomerGroupNameFilterInput.click();
        CustomerGroupNameFilterInput.sendKeys(customerGroupNameHolder);
        SearchButton.click();
        FirstSearchedResult.click();
        GroupName.click();
        GroupName.clear();
        GroupName.sendKeys(customerGroupNameUpdated);
        TaxClass.click();
        Select select=new Select(TaxClass);
        select.selectByValue("3");
        SaveCustomerGroupButton.click();
    }

}
