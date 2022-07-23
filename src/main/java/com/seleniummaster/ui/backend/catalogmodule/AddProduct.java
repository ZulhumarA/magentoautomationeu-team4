package com.seleniummaster.ui.backend.catalogmodule;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {

    TestUtility testUtility;

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),\"Add Product\")]")
    WebElement AddProductsLink;

    @FindBy(xpath="//*[@id='attribute_set_id']")
    WebElement AttributeSetLink;

    @FindBy(xpath="//*[@id='product_type']")
    WebElement ProductTypeLink;

    @FindBy(xpath = "//td[contains(.,'Continue')]")
    WebElement ContinueButton;

    @FindBy(xpath= "//input[@type=\"text\"]")
    WebElement NameLink;

    @FindBy(xpath = "//*[@id ='description']")
    WebElement DescriptionLink;

    @FindBy(xpath = "//*[@id ='short_description']")
    WebElement ShortDescriptionLink;

    @FindBy(xpath =" //*[@id='sku']")
    WebElement SKULink;

    @FindBy(xpath= "//*[@id='weight']")
    WebElement Weight;

    @FindBy(xpath="//*[@id= 'status']")
    WebElement StatusDropDownList;

    @FindBy(xpath = "//*[@id=\"visibility\"]")
    WebElement VisibilityLink;

    @FindBy(xpath = "//span[contains(text(),\"Save\")]")
    WebElement SaveButton;

    @FindBy(xpath = "//*[@id=\"price\"]")
    WebElement PriceLink;

    @FindBy(xpath = "//*[@id=\"tax_class_id\"]")
    WebElement TextClass;

    @FindBy(xpath = "//*[contains(text(),\"The product has been saved.\")]")
    WebElement SuccessMessage;

    public AddProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }

    public void addProductInformation(){
        testUtility.waitForElementPresent(AddProductsLink);
        AddProductsLink.click();
        testUtility.waitForElementPresent(AttributeSetLink);
        testUtility.selectValueFromDropDown(AttributeSetLink,"shoes");
        testUtility.selectValueFromDropDown(ProductTypeLink,"Simple Product");
        testUtility.waitForElementPresent(ContinueButton);
        ContinueButton.click();
        testUtility.waitForElementPresent(NameLink);
        NameLink.sendKeys("Adidas");
        testUtility.waitForElementPresent(DescriptionLink);
        DescriptionLink.sendKeys("Europe 38");
        testUtility.waitForElementPresent(ShortDescriptionLink);
        ShortDescriptionLink.sendKeys("women");
        testUtility.waitForElementPresent(SKULink);
        SKULink.sendKeys("TRB9897770R00000l");
        testUtility.waitForElementPresent(Weight);
        Weight.sendKeys("0.5kg");
        testUtility.waitForElementPresent(StatusDropDownList);
        testUtility.selectValueFromDropDown(StatusDropDownList,"Enabled");
        testUtility.waitForElementPresent(VisibilityLink);
        testUtility.selectValueFromDropDown(VisibilityLink,"Catalog");
        testUtility.waitForElementPresent(SaveButton);
        SaveButton.click();
        testUtility.waitForElementPresent(PriceLink);
        PriceLink.sendKeys("100$");
        testUtility.selectValueFromDropDown(TextClass,"Shipping");
        testUtility.waitForElementPresent(SaveButton);
        SaveButton.click();
    }
    public boolean verifyAddProductTest() {
        testUtility.waitForElementPresent(SuccessMessage);
        return
                SuccessMessage.isDisplayed();
    }





//   // public void clickAddNewProduct() {
//            testUtility.waitForElementPresent(AddProductsLink);
//            AddProductsLink.click();
//   //     }
//   //     public void createProductSetting() {
//            testUtility.waitForElementPresent(AttributeSetLink);
//            AttributeSetLink.click();
//            testUtility.selectValueFromDropDown(AttributeSetLink, "shoes");
//            testUtility.selectValueFromDropDown(ProductTypeLink, "Simple Product");
//            testUtility.waitForElementPresent(ContinueButton);
//            ContinueButton.click();
//
//        }
//
//        public void addProductName(String name) {
//            testUtility.waitForElementPresent(NameLink);
//            NameLink.sendKeys(name);
//
//        }
//
//        public void addDescription(String description) {
//            testUtility.waitForElementPresent(DescriptionLink);
//            DescriptionLink.sendKeys(description);
//        }
//
//        public void addShortDescription(String shortDescription) {
//            testUtility.waitForElementPresent(ShortDescriptionLink);
//            ShortDescriptionLink.sendKeys(shortDescription);
//        }
//
//        public void addSKU(String SKU) {
//            testUtility.waitForElementPresent(SKULink);
//            SKULink.sendKeys(SKU);
//
//        }
//
//        public void addWeight(String weight) {
//            testUtility.waitForElementPresent(Weight);
//            Weight.sendKeys(weight);
//
//        }
//
//        public void selectProductStatus() {
//            testUtility.waitForElementPresent(StatusDropDownList);
//            StatusDropDownList.click();
//            testUtility.selectValueFromDropDown(StatusDropDownList, "Enabled");
//        }
//
//        public void selectVisibility() {
//            testUtility.waitForElementPresent(VisibilityLink);
//            VisibilityLink.click();
//            testUtility.selectValueFromDropDown(VisibilityLink, "Catalog");
//        }
//
//        public void saveGeneralProductPage() {
//            testUtility.waitForElementPresent(SaveButton);
//            SaveButton.click();
//        }
//
//        public void addPrice(String price) {
//            testUtility.waitForElementPresent(PriceLink);
//            PriceLink.sendKeys(price);
//        }
//        public void selectTaxClass(){
//            testUtility.waitForElementPresent(TextClass);
//            TextClass.click();
//            testUtility.selectValueFromDropDown(TextClass,"Shipping");
//        }
//        public void saveProductInformation(){
//            testUtility.waitForElementPresent(SaveButton);
//            SaveButton.click();
////        }
////        public boolean verifyAddProductTest(){
//            testUtility.waitForElementPresent(SuccessMessage);
//            return
//                    SuccessMessage.isDisplayed();
//
//        }//
//    }
}
