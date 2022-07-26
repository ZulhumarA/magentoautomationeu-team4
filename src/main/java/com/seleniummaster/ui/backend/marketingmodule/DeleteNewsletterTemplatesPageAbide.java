package com.seleniummaster.ui.backend.marketingmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteNewsletterTemplatesPageAbide {
    WebDriver driver;
    TestUtility testUtility;
    Actions action ;

    @FindBy(css = "#nav > li:nth-child(5) > a")
    WebElement newsletterLink;

    @FindBy(css="#nav > li:nth-child(5) > ul > li:nth-child(1) > a > span")
    WebElement newsletterTemplateLink;

    @FindBy(css = "div.hor-scroll>table>tbody>tr:nth-child(1)")
    WebElement templatesTableFirstLine;

    @FindBy(css = "button[title=\"Delete Template\"]")
    WebElement deleteTemplatesButton;

    @FindBy(css = "div.grid>div.hor-scroll>table>tbody>tr:nth-child(1)>td:nth-child(4)")
    WebElement dateUpdated;


    public DeleteNewsletterTemplatesPageAbide(WebDriver driver) {
        this.driver = driver;
        testUtility=new TestUtility(driver);
        action=new Actions(driver);
        PageFactory.initElements(driver,this);
    }

   //methods
   String updatedDate;
   public void deleteNewsletterTemplates(){
        testUtility.waitForElementPresent(newsletterLink);
        newsletterLink.click();

        action.moveToElement(newsletterTemplateLink).click().perform();

        testUtility.sleep(3);
        testUtility.waitForElementPresent(dateUpdated);
        updatedDate=dateUpdated.getText();
        System.out.println(updatedDate);
       testUtility.sleep(1);
        testUtility.waitForElementPresent(templatesTableFirstLine);
        templatesTableFirstLine.click();
        testUtility.sleep(2);
        testUtility.waitForElementPresent(deleteTemplatesButton);
        deleteTemplatesButton.click();
        testUtility.sleep(2);
        driver.switchTo().alert().accept();
   }

   public boolean deleteNewsLetterTemplateSuccessfully(){
        testUtility.waitForElementPresent(dateUpdated);
        System.out.println(dateUpdated.getText());
        if (!updatedDate.equals(dateUpdated.getText()))
            return true;
        else
            return false;
   }



}
