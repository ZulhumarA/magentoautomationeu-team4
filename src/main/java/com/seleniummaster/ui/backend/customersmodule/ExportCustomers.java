package com.seleniummaster.ui.backend.customersmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExportCustomers {
    TestUtility testUtility;

    WebDriver driver;




    @FindBy(css="button[title='Export']")
    WebElement ExportButton;

    public ExportCustomers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }



    public void ClikExport() {
        testUtility.waitForElementPresent(ExportButton);
        ExportButton.click();
    }


}