package com.seleniummaster.ui.frontend;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewDownloadableOrdersPage {

    TestUtility testUtility;
    WebDriver driver;

    @FindBy(xpath ="//a[contains(.,'My Downloadable Products')]" )
    WebElement mydownloadableproductsLink;

    public ViewDownloadableOrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void ViewDownloableOrders(){

        testUtility.waitForElementPresent(mydownloadableproductsLink);
        mydownloadableproductsLink.click();


    }
    public boolean verifyviewDownloadableorders(){
        testUtility.waitForElementPresent(mydownloadableproductsLink);
        if (mydownloadableproductsLink.isDisplayed()) {
            return true;
        } else

            return false;
    }


}


