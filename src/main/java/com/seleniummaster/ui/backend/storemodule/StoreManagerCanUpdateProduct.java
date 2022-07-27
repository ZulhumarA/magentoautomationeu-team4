package com.seleniummaster.ui.backend.storemodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static com.seleniummaster.configutility.ApplicationConfig.readFromConfigProperties;

public class StoreManagerCanUpdateProduct extends TestBase {
    String description;
    String SKU;
    WebDriver driver;
    TestUtility testUtility;
    String configFile = "config.properties";

    @FindBy(xpath = "//span[contains(text(),'Catalog')]")
    WebElement catalogButton;
    @FindBy(xpath = "//span[text()='Manage Products']")
    WebElement manegeProductsButton;
    @FindBy(xpath = "(//a[text()='Edit'])[1]")
    WebElement Edit;
    @FindBy(id = "description")
    WebElement descriptionField;
    @FindBy(xpath = "//input[@name='product[sku]']")
    WebElement SKUField;
    @FindBy(css = "select#status")
    WebElement statusDropDown;
    @FindBy(css = "select#visibility")
    WebElement visibilityDropdown;
    @FindBy(xpath ="//span[text()='Save and Continue Edit']")
    WebElement saveAndContinuEdit;
    @FindBy(xpath = "//span[text()='The product has been saved.']")
    WebElement addProductSuccessMessage;

    public StoreManagerCanUpdateProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }
    public void setCatalogButton() {
        testUtility.waitForElementPresent(catalogButton);
        catalogButton.click();
        testUtility.sleep(3);
    }
    public void setManegeProductsButton() {
        testUtility.waitForElementPresent(manegeProductsButton);
        manegeProductsButton.click();
    }
    public void UpdateProduct() {

        testUtility.waitForElementPresent(Edit);
        Edit.click();
        testUtility.sleep(1);
        testUtility.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(readFromConfigProperties(configFile, "description1"));
        testUtility.waitForElementPresent(SKUField);
        Random random = new Random();
        char randomizedCharacter = (char) (random.nextInt(26) + 'a');
//       Faker javaFaker=  new Faker();
        String zipCode = testUtility.generateZip().toString().replace("-", "_");
        SKUField.sendKeys(randomizedCharacter + zipCode);
        testUtility.waitForElementPresent(saveAndContinuEdit);
        saveAndContinuEdit.click();
        testUtility.waitForElementPresent(addProductSuccessMessage);
        addProductSuccessMessage.click();
    }
    public boolean VerifySavedMassageSuccessfully() {
        testUtility.waitForElementPresent(addProductSuccessMessage);
        // return addProductSuccessMessage.isDisplayed();
        if (addProductSuccessMessage.isDisplayed())
            return true;
        else
            return false;
    }



    }
