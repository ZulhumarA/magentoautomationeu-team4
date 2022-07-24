package com.seleniummaster.ui.backend.catalogmodule;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProduct {

    TestUtility testUtility;

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),\"Add Product\")]")
    WebElement AddProductsLink;

    @FindBy(xpath="//*[@id='attribute_set_id']")
    WebElement AttributeSetLink;

    @FindBy(xpath="//*[@id='product_type']")
    WebElement ProductTypeLink;

    @FindBy(css = "#continue_button button")
    WebElement ContinueButton;

    @FindBy(xpath= "//*[@id ='name']")
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

    public void addProductInformation(String ProductName)  {
        testUtility.waitForElementPresent(AddProductsLink);
        AddProductsLink.click();
        testUtility.waitForElementPresent(AttributeSetLink);
        testUtility.selectValueFromDropDown(AttributeSetLink,"11");
        Select select = new Select(ProductTypeLink);
        select.selectByVisibleText("Simple Product");
        testUtility.waitForElementPresent(ContinueButton);
        ContinueButton.click();
        testUtility.waitForElementPresent(NameLink);
        NameLink.sendKeys(ProductName);
        testUtility.waitForElementPresent(DescriptionLink);
        DescriptionLink.sendKeys(testUtility.generateRandomSentence());
        testUtility.waitForElementPresent(ShortDescriptionLink);
        ShortDescriptionLink.sendKeys(testUtility.generateRandomLetter());
        testUtility.waitForElementPresent(SKULink);
        SKULink.sendKeys(String.valueOf(testUtility.generateRandomNumber()));
        testUtility.waitForElementPresent(Weight);
        Weight.sendKeys(String.valueOf(testUtility.generateRandomNumber()));
        testUtility.waitForElementPresent(StatusDropDownList);
        testUtility.selectValueFromDropDown(StatusDropDownList,"1");
        testUtility.waitForElementPresent(VisibilityLink);
        testUtility.selectValueFromDropDown(VisibilityLink,"4");
        testUtility.waitForElementPresent(SaveButton);
        SaveButton.click();
        testUtility.waitForElementPresent(PriceLink);
        PriceLink.sendKeys(String.valueOf(testUtility.generateRandomNumber()));
        testUtility.selectValueFromDropDown(TextClass,"0");
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
