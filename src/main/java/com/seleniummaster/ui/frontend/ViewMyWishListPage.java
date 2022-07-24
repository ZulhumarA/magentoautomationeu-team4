package com.seleniummaster.ui.frontend;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewMyWishListPage {
    WebDriver driver;
    TestUtility testUtility;

    //Elements
    @FindBy(css = "ul>li:nth-child(9)>a")
    WebElement myWishListLink;

    @FindBy(css = "div>button:nth-child(2)[title=\"Add All to Cart\"]")
    WebElement AddAllCartButton;

    @FindBy(css = "div.page-title>h1")
    WebElement PageTitle;


    //constructor
    public ViewMyWishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    //Action Methods
    public void clickMyWishList(){
        testUtility.waitForElementPresent(myWishListLink);
        myWishListLink.click();
    }


    //Verify Method
    public boolean existMyWishListContent(){
        testUtility.waitForElementPresent(PageTitle);
        if (PageTitle.isDisplayed())
            return true;
        else
            return false;
    }



}
