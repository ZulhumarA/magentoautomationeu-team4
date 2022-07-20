package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerGroupsPage {

    WebDriver driver;
    TestUtility testUtility;

    //element location
    @FindBy(css = "#nav>li:nth-child(1)>a")
    WebElement CustomersButton;

    @FindBy(css = "#nav > li.active.parent.level0 > ul > li:nth-child(2) > a")
    WebElement    CustomerGroupsLink ;

    @FindBy(css = "div.hor-scroll>table>tbody>tr:nth-child(4)>td:nth-child(2)")
    WebElement  CustomerGroupsInTableFirstLine;


    @FindBy(css = "p>button:nth-child(3)")
    WebElement    DeleteCustomerGroupsButton ;

    @FindBy(css = "li.success-msg>ul>li>span")
    WebElement SuccessfulMessage;

// constructor creation

    public DeleteCustomerGroupsPage(WebDriver driver) {
        this.driver = driver;
        testUtility=new TestUtility(driver);
        PageFactory.initElements(driver,this);
    }


//methods
    public void deleteCustomerGroup(){
        testUtility.waitForElementPresent(CustomersButton);
        CustomersButton.click();
        testUtility.waitForElementPresent(CustomerGroupsLink);
        CustomerGroupsLink.click();
        testUtility.waitForElementPresent(CustomerGroupsInTableFirstLine);
        CustomerGroupsInTableFirstLine.click();
        testUtility.waitForElementPresent(DeleteCustomerGroupsButton);
        DeleteCustomerGroupsButton.click();
        testUtility.sleep(3);
        driver.switchTo().alert().accept();
    }

    public boolean verifyCustomerGroupDeletedSuccessfully(){
        testUtility.waitForElementPresent(SuccessfulMessage);
        if (SuccessfulMessage.isDisplayed())
            return true;
        else
            return false;
    }





}
