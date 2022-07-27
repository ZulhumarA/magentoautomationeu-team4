package com.seleniummaster.ui.backend.reportingmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeeProductReviews extends TestBase {
    TestUtility testUtility;
    WebDriver driver;

    public SeeProductReviews(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }
    @FindBy(xpath="(//span[contains(text(),'Reports')])[1]")
    WebElement ReportsLink;
    @FindBy(xpath="(//span[contains(text(),\"Reviews\")])[5]")
    WebElement ReviewsReportsLink;
    @FindBy(xpath="//span[contains(text(),\"Products Reviews\")]")
    WebElement ProductReviews;
    @FindBy(xpath="//*[contains(text(),'446')]/parent::tr//td[@class=\"a-center last\"]")
    WebElement ShowReviewsButton;
    @FindBy(xpath="//h3[contains(text(),\"All Reviews of Product `MP3 Player with Audio`\")]")
    WebElement TheProduct;
public void seeProductReviewsMethod(){
    testUtility.waitForElementPresent(ReportsLink);
    ReportsLink.click();
    testUtility.waitForElementPresent(ReviewsReportsLink);
    ReviewsReportsLink.click();
    testUtility.waitForElementPresent(ProductReviews);
   ProductReviews.click();
testUtility.waitForElementPresent(ShowReviewsButton);
ShowReviewsButton.click();

}

public boolean verifyReviewsDisplayed(){
testUtility.waitForElementPresent(TheProduct);
return TheProduct.isDisplayed();
}


}