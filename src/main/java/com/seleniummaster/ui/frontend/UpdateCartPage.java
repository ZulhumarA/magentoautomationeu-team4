package com.seleniummaster.ui.frontend;
import com.seleniummaster.configutility.TestUtility;
import com.seleniummaster.configutility.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UpdateCartPage extends TestBase{

    TestUtility testUtility;

    WebDriver driver;

    @FindBy(xpath="//*[@class=\"item first\"]")
    WebElement linenBlazer;

    @FindBy(xpath="//*[text()=\"Elizabeth Knit Top\"]")
    WebElement elizabethKnitTop;

    @FindBy(xpath = "//*[text()=\"Chelsea Tee\"]")
    WebElement chelseaTee;

    @FindBy(xpath = "//*[text()=\"Lafayette Convertible Dress\"]")
    WebElement lafayetteConvertibleDress;

    @FindBy(xpath = "//*[text()=\"Tori Tank\"]")
    WebElement ToriTank;

    @FindBy(id="attribute92")
    WebElement colorField;

    @FindBy(id="attribute180")
    WebElement sizeField;

    @FindBy(id="header-cart")
    WebElement headerCartField;

    @FindBy(id="qbutton-3244")
    WebElement updateQuantityButton;

    @FindBy(linkText = "Edit item")
    WebElement editItemLink;

    @FindBy(linkText = "Edit")
    WebElement updateProductLink;

    @FindBy(id="qty")
    WebElement quantityField;

    @FindBy(css=".add-to-cart-buttons>button")
    WebElement addToCartButton;

    @FindBy(xpath = "//span[text()='Linen Blazer was added to your shopping cart.']")
    WebElement linenBlazerSuccessfullyAddedMessage;

    @FindBy(xpath="//span[text()='Chelsea Tee was added to your shopping cart.']")
    WebElement chelseaTeeAddedSuccessfullyMessage;

    @FindBy(xpath = "//span[text()='Linen Blazer was updated in your shopping cart.']")
    WebElement linenBlazerSuccessfullyUpdatedMessage;

    @FindBy(xpath = "//span[text()='Update Cart']")
    WebElement updateCartButton;

    @FindBy(xpath = "//*[@class='products-grid']/li")
    List<WebElement> multipleProducts;

    @FindBy(xpath = "//a[@class=\"logo\"]")
    WebElement logo;

    public UpdateCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

//    public void getAllProducts(){
//        int s=multipleProducts.size();
//        for(int i=1;i<s-1;i++){
//            addMultipleProductsToCartMethod();
//        }
//    }


    public void addProductToCartMethod(){
        linenBlazer.click();
        selectValueFromDropDown(colorField,"22");
        selectValueFromDropDown(sizeField,"78");
        addToCartButton.click();
    }

    public void addProductToCart(WebElement productName,String colorValue,String sizeValue){
        productName.click();
        selectValueFromDropDown(colorField, colorValue);
        selectValueFromDropDown(sizeField, sizeValue);
        addToCartButton.click();
    }

    public void addLinenBlazerToCart(){
        addProductToCart(linenBlazer,"22","78");
    }


    public boolean verifyLinenBlazerSuccessfullyAddedMessage(){
        testUtility.waitForElementPresent(linenBlazerSuccessfullyAddedMessage);
        return linenBlazerSuccessfullyAddedMessage.isDisplayed();
    }

    public boolean verifyChelseaTeaAdded(){
        testUtility.waitForElementPresent(chelseaTeeAddedSuccessfullyMessage);
        return chelseaTeeAddedSuccessfullyMessage.isDisplayed();
    }

    public boolean verifyLinenBlazerProductUpdatedSuccessfully(){
        testUtility.waitForElementPresent(linenBlazerSuccessfullyUpdatedMessage);
        return linenBlazerSuccessfullyUpdatedMessage.isDisplayed();
    }


    public void changeQuantityMethod(){
        testUtility=new TestUtility(driver);
        testUtility.waitForElementPresent(quantityField);
        quantityField.sendKeys(Keys.CONTROL + "a");
        quantityField.sendKeys(Keys.DELETE);
        quantityField.sendKeys("5");
    }

    public void changeProductSizeMethod(){
        updateProductLink.click();
        selectValueFromDropDown(sizeField,"77");
        updateCartButton.click();
    }

    public void selectValueFromDropDown(WebElement webelement,String value){
        Select s=new Select(webelement);
        s.selectByValue(value);
    }

    public void selectValueFromDropDown(WebElement webelement,int index){
        Select s=new Select(webelement);
        s.selectByIndex(index);
    }
}








