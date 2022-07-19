package com.seleniummaster.ui.frontend;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProductsToShoppingCartPage extends TestBase {
    TestUtility testUtility;
    WebDriver driver;
    @FindBy(xpath = "//*[text()='Chelsea Tee']")
    WebElement chelseaTea;

    @FindBy(xpath = "//*[text()=\"Lafayette Convertible Dress\"]")
    WebElement lafayetteConvertibleDress;

    @FindBy(xpath = "//*[text()=\"Tori Tank\"]")
    WebElement toriTank;

    @FindBy(xpath = "//*[@id=\"attribute92\"]")
    WebElement colorOption;

    @FindBy(xpath = "//*[@id=\"attribute180\"]")
    WebElement sizeOption;

    @FindBy(xpath = "//*[@class=\" product-custom-option\"]")
    WebElement testCustomOption;

    @FindBy(xpath = "//*[@id=\"qty\"]")
    WebElement qtyNumber;

    @FindBy(css = ".add-to-cart-buttons>button")
    WebElement addToCartBTN;

    @FindBy(xpath = "//*[contains(text(),\"Chelsea Tee was added to your shopping cart.\")]")
    WebElement chelseaTeeWasAdded;

    @FindBy(css="img[alt=\"Madison Island\"]")
    WebElement homePage;

    public AddProductsToShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testUtility = new TestUtility(driver);
    }
    public void addChelseaTeaToCart(){
        homePage.click();
        testUtility.waitForElementPresent(chelseaTea);
        addProductToCart(chelseaTea,"20","78");
    }


    public void addProductToCart(WebElement productName,String colorValue,String sizeValue) {
        productName.click();
        testUtility.selectValueFromDropDown(colorOption, colorValue);
        testUtility.selectValueFromDropDown(sizeOption, sizeValue);
        addToCartBTN.click();
    }

   public boolean verifySuccessfullyAddProduct() {
      return chelseaTeeWasAdded.isDisplayed();


}}

