package com.seleniummaster.ui.backend.catalogmodule;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {

        TestUtility testUtility;

        WebDriver driver;




        @FindBy(id = "id_c1592bf502871cd5d25ace2477e1cf85")
        WebElement AddProductsLink;

        @FindBy(id = "attribute_set_id")
        WebElement AttributeSetLink;

        @FindBy(id = "product_type")
        WebElement ProductTypeLink;

        @FindBy(xpath = "//td[contains(.,'Continue')]")
        WebElement ContinueButton;

        @FindBy(name = "product[name]")
        WebElement NameLink;

        @FindBy(id = "description")
        WebElement DescriptionLink;

        @FindBy(id = "short_description")
        WebElement ShortDescriptionLink;

        @FindBy(name = "product[sku]")
        WebElement SKULink;

        @FindBy(id = "weight")
        WebElement Weight;

        @FindBy(id = "status")
        WebElement StatusDropDownList;

        @FindBy(name = "product[visibility]")
        WebElement VisibilityLink;

        @FindBy(id = "id_276556512183203cc7eba4de11c98c8d")
        WebElement SaveButton;

        @FindBy(id = "price")
        WebElement PriceLink;

        @FindBy(id = "tax_class_id")
        WebElement TextClass;

        @FindBy(xpath = "//*[contains(text(),\"The product has been saved.\")]")
        WebElement SuccessMessage;

    public AddProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }


    public void clickAddNewProduct() {
            testUtility.waitForElementPresent(AddProductsLink);
            AddProductsLink.click();
        }
        public void createProductSetting() {
            testUtility.waitForElementPresent(AttributeSetLink);
            AttributeSetLink.click();
            testUtility.selectValueFromDropDown(AttributeSetLink, "shoes");
            testUtility.selectValueFromDropDown(ProductTypeLink, "Simple Product");
            testUtility.waitForElementPresent(ContinueButton);
            ContinueButton.click();

        }

        public void addProductName(String name) {
            testUtility.waitForElementPresent(NameLink);
            NameLink.sendKeys(name);

        }

        public void addDescription(String description) {
            testUtility.waitForElementPresent(DescriptionLink);
            DescriptionLink.sendKeys(description);
        }

        public void addShortDescription(String shortDescription) {
            testUtility.waitForElementPresent(ShortDescriptionLink);
            ShortDescriptionLink.sendKeys(shortDescription);
        }

        public void addSKU(String SKU) {
            testUtility.waitForElementPresent(SKULink);
            SKULink.sendKeys(SKU);

        }

        public void addWeight(String weight) {
            testUtility.waitForElementPresent(Weight);
            Weight.sendKeys(weight);

        }

        public void selectProductStatus() {
            testUtility.waitForElementPresent(StatusDropDownList);
            StatusDropDownList.click();
            testUtility.selectValueFromDropDown(StatusDropDownList, "Enabled");
        }

        public void selectVisibility() {
            testUtility.waitForElementPresent(VisibilityLink);
            VisibilityLink.click();
            testUtility.selectValueFromDropDown(VisibilityLink, "Catalog");
        }

        public void saveGeneralProductPage() {
            testUtility.waitForElementPresent(SaveButton);
            SaveButton.click();
        }

        public void addPrice(String price) {
            testUtility.waitForElementPresent(PriceLink);
            PriceLink.sendKeys(price);
        }
        public void selectTaxClass(){
            testUtility.waitForElementPresent(TextClass);
            TextClass.click();
            testUtility.selectValueFromDropDown(TextClass,"Shipping");
        }
        public void saveProductInformation(){
            testUtility.waitForElementPresent(SaveButton);
            SaveButton.click();
        }
        public boolean verifyAddProductTest(){
            testUtility.waitForElementPresent(SuccessMessage);
            return
                    SuccessMessage.isDisplayed();

        }

    }
