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

public class StoreManagerCanAddProducts extends TestBase {
    String name;
    String description;
    String shortDescription;
    String SKU;
    String weight;
    WebDriver driver;
    TestUtility testUtility;
    String configFile = "config.properties";

    @FindBy(xpath = "//span[contains(text(),'Catalog')]")
    WebElement catalogButton;

    @FindBy(xpath = "//span[text()='Manage Products']")
    WebElement manegeProductsButton;

    @FindBy(css = "button[title='Add Product']")
    WebElement addProductButton;
    @FindBy(css = "select#attribute_set_id")
    WebElement attributeSetDropDown;
    @FindBy(css = "select[name='type']")
    WebElement productTypeDropDown;
    @FindBy(id = "continue_button")
    WebElement continueButton;
    @FindBy(id = "name")
    WebElement nameField;
    @FindBy(id = "description")
    WebElement descriptionField;
    @FindBy(css = "textarea#short_description")
    WebElement shortDescriptionFiled;
    @FindBy(xpath = "//input[@name='product[sku]']")
    WebElement SKUField;
    @FindBy(css = "input#weight")
    WebElement weightFiled;
    @FindBy(css = "select#status")
    WebElement statusDropDown;
    @FindBy(css = "select#visibility")
    WebElement visibilityDropdown;
    @FindBy(css = "button[title='Save']")
    WebElement saveButton;
    @FindBy(xpath = "//span[text()='The product has been saved.']")
    WebElement addProductSuccessMessage;

    public StoreManagerCanAddProducts(WebDriver driver) {
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

    public void addProduct() {

        testUtility.waitForElementPresent(addProductButton);
        addProductButton.click();
        testUtility.sleep(1);

        testUtility.waitForElementPresent(attributeSetDropDown);
        Select select1 = new Select(attributeSetDropDown);
        select1.selectByValue("10");

        testUtility.waitForElementPresent(productTypeDropDown);
        Select select2 = new Select(productTypeDropDown);
        select2.selectByValue("grouped");

        testUtility.waitForElementPresent(continueButton);
        continueButton.click();

        testUtility.waitForElementPresent(nameField);
        nameField.sendKeys(readFromConfigProperties(configFile,"NameK"));

        testUtility.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(readFromConfigProperties(configFile,"description"));

        testUtility.waitForElementPresent(shortDescriptionFiled);
        shortDescriptionFiled.sendKeys(readFromConfigProperties(configFile,"ShortDescription"));

        testUtility.waitForElementPresent(SKUField);
        Random random=new Random();
        char randomizedCharacter = (char) (random.nextInt(26) + 'a');
//       Faker javaFaker=  new Faker();
        String zipCode = testUtility.generateZip().toString().replace("-","_");
        SKUField.sendKeys(randomizedCharacter+zipCode);
        testUtility.waitForElementPresent(statusDropDown);
        Select select3 = new Select(statusDropDown);
        select3.selectByValue("1");
        testUtility.waitForElementPresent(visibilityDropdown);
        Select select4 = new Select(visibilityDropdown);
        select4.selectByValue("4");

        testUtility.waitForElementPresent(saveButton);
        saveButton.click();

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

