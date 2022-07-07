package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignCustomerToACustomerGroupPage {

    TestUtility testUtility;

    WebDriver driver;

    public AssignCustomerToACustomerGroupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }
    @FindBy(css = "#id_548e49ceda67159450ab058419ba2213")
    WebElement addNewCustomerButton;

    @FindBy(xpath = "//select[@id=\"_accountwebsite_id\"]")
    WebElement associateToWebsiteDropDown;

    public void createNewCustomer(){
        addNewCustomerButton.click();
        testUtility.selectValueFromDropDown(associateToWebsiteDropDown,"16");

    }


}