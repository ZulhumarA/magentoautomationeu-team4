package com.seleniummaster.ui.backend.marketingmodule;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UpdateNewsletterTemplatePage {
    TestUtility testUtility;

    WebDriver driver;

    AdminLoginPage adminLoginPage;

    int textTemplateSizeOld;

    int textTemplateSizeNew;

    public UpdateNewsletterTemplatePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "//span[text()='Newsletter']")
    WebElement newsletterButton;

    @FindBy(xpath = "//span[text()='Newsletter Templates']")
    WebElement newsletterTemplateButton;

    @FindBy(xpath = "//*[@class='field-100']/input[@name='code']")
    WebElement templateNameFilterField;

    @FindBy(xpath = "//select[@name='type']")
    WebElement templateTypeFilterField;

    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@class='data']/tbody/tr[1]/td[2]")
    WebElement templateToUpdate;

    @FindBy(xpath = "//span[text()='Convert to Plain Text']")
    WebElement convertToPlainTextButton;

    @FindBy(xpath = "//span[text()='Save Template']")
    WebElement saveTemplateButton;

    @FindBy(xpath = "//*[@class=\"data\"]/tbody/tr[1]/td[7]")
    WebElement updatedField1;


    public void updateExistingNewsletterTemplate(){
        testUtility.waitForElementPresent(newsletterButton);
        newsletterButton.click();
        testUtility.waitForElementPresent(newsletterTemplateButton);
        newsletterTemplateButton.click();
        testUtility.waitForElementPresent(templateNameFilterField);
        templateNameFilterField.click();
        templateNameFilterField.sendKeys("Team4Test");
        testUtility.waitForElementPresent(templateTypeFilterField);
        testUtility.selectValueFromDropDown(templateTypeFilterField,"1");
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
        List<WebElement> textTemplates1=driver.findElements(By.xpath("//*[@class='data']/tbody/tr"));
        textTemplateSizeOld=textTemplates1.size();
        System.out.println("Old Text Template Number Is:" +textTemplateSizeOld);

        testUtility.selectValueFromDropDown(templateTypeFilterField,"2");
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
        testUtility.waitForElementPresent(templateToUpdate);
        templateToUpdate.click();
        testUtility.waitForElementPresent(convertToPlainTextButton);
        convertToPlainTextButton.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        testUtility.waitForElementPresent(saveTemplateButton);
        saveTemplateButton.click();
    }

    public boolean verifyTemplateUpdatedSuccessfully(){
        testUtility.waitForElementPresent(templateNameFilterField);
        templateNameFilterField.click();
        templateNameFilterField.sendKeys("Team4Test");
        testUtility.waitForElementPresent(templateTypeFilterField);
        testUtility.selectValueFromDropDown(templateTypeFilterField,"1");
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
        List<WebElement> textTemplates2=driver.findElements(By.xpath("//*[@class='data']/tbody/tr"));
        textTemplateSizeNew=textTemplates2.size();
        System.out.println("New Text Template Number Is:" +textTemplateSizeNew);
        return textTemplateSizeOld < textTemplateSizeNew;
    }

}
