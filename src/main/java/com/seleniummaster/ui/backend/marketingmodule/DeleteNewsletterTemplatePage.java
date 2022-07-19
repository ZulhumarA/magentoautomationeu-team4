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

public class DeleteNewsletterTemplatePage {

    TestUtility testUtility;

    WebDriver driver;

    AdminLoginPage adminLoginPage;

    int templateNumberBeforeDeleting;

    int templateNumberAfterDeleting;

    public DeleteNewsletterTemplatePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "//span[text()='Newsletter']")
    WebElement newsletterButton;

    @FindBy(xpath = "//span[text()='Newsletter Templates']")
    WebElement newsletterTemplateButton;

    @FindBy(xpath = "//select[@name=\"limit\"]")
    WebElement templateLimitDropDown;

    @FindBy(xpath = "//*[@class='field-100']/input[@name='code']")
    WebElement templateNameFilterField;

    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@class='data']/tbody/tr[1]/td[2]")
    WebElement templateToDelete;

    @FindBy(xpath = "//span[text()='Delete Template']")
    WebElement deleteTemplateButton;

    public void deleteTemplate(){
        testUtility.waitForElementPresent(newsletterButton);
        newsletterButton.click();
        testUtility.waitForElementPresent(newsletterTemplateButton);
        newsletterTemplateButton.click();

        testUtility.waitForElementPresent(templateLimitDropDown);
        testUtility.selectValueFromDropDown(templateLimitDropDown,"100");
        List<WebElement> templateNumber1=driver.findElements(By.xpath("//*[@class='data']/tbody/tr"));
        templateNumberBeforeDeleting=templateNumber1.size();
        System.out.println("Template Number Before Deleting Is: "+templateNumberBeforeDeleting);

        testUtility.waitForElementPresent(templateNameFilterField);
        templateNameFilterField.click();
        templateNameFilterField.sendKeys("Team4Test");
        testUtility.waitForElementPresent(searchButton);
        searchButton.click();
        testUtility.waitForElementPresent(templateToDelete);
        templateToDelete.click();
        testUtility.waitForElementPresent(deleteTemplateButton);
        deleteTemplateButton.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }

    public boolean verifyTemplateDeletedSuccessfully(){
        testUtility.waitForElementPresent(templateLimitDropDown);
        testUtility.selectValueFromDropDown(templateLimitDropDown,"100");
        List<WebElement> templateNumber2=driver.findElements(By.xpath("//*[@class='data']/tbody/tr"));
        templateNumberAfterDeleting=templateNumber2.size();
        System.out.println("Template Number After Deleting Is: "+templateNumberAfterDeleting);
        return templateNumberBeforeDeleting>templateNumberAfterDeleting;
    }












}
