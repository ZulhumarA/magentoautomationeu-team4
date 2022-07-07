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

    @FindBy(id="attribute92")
    WebElement colorField;

    @FindBy(id="attribute180")
    WebElement sizeField;

    @FindBy(linkText = "Edit")
    WebElement updateProductLink;

    @FindBy(id="qty")
    WebElement quantityField;

    @FindBy(css=".add-to-cart-buttons>button")
    WebElement addToCartButton;

    @FindBy(xpath = "//span[text()='Linen Blazer was added to your shopping cart.']")
    WebElement linenBlazerSuccessfullyAddedMessage;

    @FindBy(xpath = "//span[text()='Linen Blazer was updated in your shopping cart.']")
    WebElement linenBlazerSuccessfullyUpdatedMessage;

    @FindBy(xpath = "//span[text()='Update Cart']")
    WebElement updateCartButton;

    @FindBy(xpath = "//a[@class=\"logo\"]")
    WebElement logo;

    public UpdateCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    public void addProductToCart(WebElement productName,String colorValue,String sizeValue){
        productName.click();
        testUtility.selectValueFromDropDown(colorField, colorValue);
        testUtility.selectValueFromDropDown(sizeField, sizeValue);
        addToCartButton.click();
    }

    public void addLinenBlazerToCart(){
        addProductToCart(linenBlazer,"22","78");
    }


    public boolean verifyLinenBlazerSuccessfullyAddedMessage(){
        testUtility.waitForElementPresent(linenBlazerSuccessfullyAddedMessage);
        return linenBlazerSuccessfullyAddedMessage.isDisplayed();
    }

    public boolean verifyLinenBlazerProductUpdatedSuccessfully(){
        testUtility.waitForElementPresent(linenBlazerSuccessfullyUpdatedMessage);
        return linenBlazerSuccessfullyUpdatedMessage.isDisplayed();
    }

   /* public void changeQuantityMethod(){
        testUtility=new TestUtility(driver);
        testUtility.waitForElementPresent(quantityField);
        quantityField.sendKeys(Keys.CONTROL + "a");
        quantityField.sendKeys(Keys.DELETE);
        quantityField.sendKeys("5");
    }*/

    public void changeProductSizeMethod(){
        updateProductLink.click();
        testUtility.selectValueFromDropDown(sizeField,"77");
        updateCartButton.click();
    }

    public void returnToHomePage(){
        logo.click();
    }
}








