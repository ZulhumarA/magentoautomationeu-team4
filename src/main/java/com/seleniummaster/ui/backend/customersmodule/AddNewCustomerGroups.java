package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerGroups extends TestBase
{
    TestUtility testUtility;
    WebDriver driver;
    public AddNewCustomerGroups(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }
@FindBy(css = "#nav>li:nth-child(1)>a")
    WebElement CustomersButton;
    @FindBy(xpath = "//span[contains(text(),\"Customer Groups\")]")
    WebElement  CustomerGroupsLink;
    @FindBy(xpath="(//span[contains(text(),'Add New Customer Group')])[1]")
    WebElement AddNewCustomerGroupLink;
    @FindBy(css="input[id=\"customer_group_code\"]")
WebElement GroupNameField;
    @FindBy(css="select[id=\"tax_class_id\"]")
    WebElement TaxClass;
    @FindBy(xpath="(//span[contains(text(),\"Save Customer Group\")])[1]")
    WebElement SaveButton;
@FindBy(xpath="//span[contains(text(),'The customer group has been saved.')]")
WebElement SuccessfullyAddedMessage;
    public void addNewCustomerGroupMethod(){
      testUtility.waitForElementPresent(CustomersButton);
      CustomersButton.click();
      testUtility.waitForElementPresent(CustomerGroupsLink);
CustomerGroupsLink.click();
testUtility.waitForElementPresent(AddNewCustomerGroupLink);
AddNewCustomerGroupLink.click();
testUtility.waitForElementPresent(GroupNameField);
GroupNameField.sendKeys("team4"+testUtility.generateGroupName());
testUtility.waitForElementPresent(TaxClass);
testUtility.selectValueFromDropDown(TaxClass,"5");
testUtility.waitForElementPresent(SaveButton);
SaveButton.click();
    }
    public boolean verifyCustomerGroupSuccessfullyAdded() throws InterruptedException {
        Thread.sleep(3000);
      //  testUtility.waitForElementPresent(SuccessfullyAddedMessage);
       return SuccessfullyAddedMessage.isDisplayed();}


}
