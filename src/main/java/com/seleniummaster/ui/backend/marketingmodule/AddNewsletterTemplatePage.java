package com.seleniummaster.ui.backend.marketingmodule;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddNewsletterTemplatePage {

    TestUtility testUtility;

    WebDriver driver;

    AdminLoginPage adminLoginPage;

    int rowSizeOld;

    int rowSizeNew;

    public AddNewsletterTemplatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "//span[text()='Newsletter']")
    WebElement newsletterButton;

    @FindBy(xpath = "//span[text()='Newsletter Templates']")
    WebElement newsletterTemplateButton;

    @FindBy(xpath = "//select[@name=\"limit\"]")
    WebElement templateLimitDropDown;

    @FindBy(xpath = "//span[text()='Add New Template']")
    WebElement addNewTemplateButton;

    @FindBy(id="code")
    WebElement templateNameField;

    @FindBy(id = "subject")
    WebElement templateSubjectField;

    @FindBy(xpath = "//span[text()='Save Template']")
    WebElement saveTemplateButton;

    @FindBy(xpath = "//span[text()='Dashboard']")
    WebElement dashboardField;

    public void addNewsletterTemplate(){

        testUtility.waitForElementPresent(newsletterButton);
        newsletterButton.click();
        testUtility.waitForElementPresent(newsletterTemplateButton);
        newsletterTemplateButton.click();

        testUtility.waitForElementPresent(templateLimitDropDown);
        testUtility.selectValueFromDropDown(templateLimitDropDown,"100");
        List<WebElement> newsletterTemplateNumberOld=driver.findElements(By.xpath("//*[@class=\"hor-scroll\"]/table/tbody/tr"));
        System.out.println("Number of old rows is:"+ newsletterTemplateNumberOld.size());
        rowSizeOld=newsletterTemplateNumberOld.size();

        testUtility.waitForElementPresent(addNewTemplateButton);
        addNewTemplateButton.click();
        testUtility.waitForElementPresent(templateNameField);
        templateNameField.click();
        templateNameField.sendKeys("Team4Test"+testUtility.generateTitle());
        testUtility.waitForElementPresent(templateSubjectField);
        templateSubjectField.click();
        templateSubjectField.sendKeys("Team4Test"+testUtility.generateTitle());
        testUtility.waitForElementPresent(saveTemplateButton);
        saveTemplateButton.click();

        testUtility.waitForElementPresent(templateLimitDropDown);
        testUtility.selectValueFromDropDown(templateLimitDropDown,"100");
        List<WebElement> newsletterTemplateNumberNew=driver.findElements(By.xpath("//*[@class=\"hor-scroll\"]/table/tbody/tr"));
        System.out.println("Number of new rows is:" +newsletterTemplateNumberNew.size());
        rowSizeNew=newsletterTemplateNumberNew.size();
    }

    public boolean verifyNewsletterTemplateAddedSuccessfully(){
        return rowSizeOld < rowSizeNew;
    }

    public void clickOnTheDashboardField(){
        testUtility.waitForElementPresent(dashboardField);
        dashboardField.click();
    }
}
