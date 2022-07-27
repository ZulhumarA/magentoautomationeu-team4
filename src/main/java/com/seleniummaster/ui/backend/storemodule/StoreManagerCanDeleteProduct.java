package com.seleniummaster.ui.backend.storemodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreManagerCanDeleteProduct extends TestBase {
    WebDriver driver;
    TestUtility testUtility;

    @FindBy(xpath = "//span[contains(text(),'Catalog')]")
    WebElement catalogButton;
    @FindBy(xpath = "//span[text()='Manage Products']")
    WebElement manegeProductsButton;
    @FindBy(xpath = "(//td[@class=' a-right '])[1]")
    WebElement IDField;
    @FindBy(xpath = "//span[text()='Delete']")
    WebElement DeleteField;
    @FindBy(xpath = "//span[text()='The product has been deleted.']")
    WebElement deleteProductSuccessMessage;


    public StoreManagerCanDeleteProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void setCatalogButton() {
        testUtility.waitForElementPresent(catalogButton);
        catalogButton.click();
        testUtility.sleep(2);
    }

    public void setManegeProductsButton() {
        testUtility.waitForElementPresent(manegeProductsButton);
        manegeProductsButton.click();
        testUtility.waitForElementPresent(IDField);
        IDField.click();
    }
    public void DeleteProduct() {
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
        testUtility.sleep(3);
        Alert alert=driver.switchTo().alert();
        alert.accept();

    }

    public boolean VerifySavedMassageSuccessfully() {
        testUtility.waitForElementPresent(deleteProductSuccessMessage);
        // return addProductSuccessMessage.isDisplayed();
        if (deleteProductSuccessMessage.isDisplayed())
            return true;
        else
            return false;
    }



}
