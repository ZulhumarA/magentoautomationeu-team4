package com.seleniummaster.ui.backend.salesmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatNewOrderPage {


     JavascriptExecutor js;
    TestUtility testUtility;
    WebDriver driver;



    @FindBy(xpath = "//span[text()=\"Sales\"]")
    WebElement SalesButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[3]/ul/li[2]/ul/li[1]")
    WebElement OrderButton;

    @FindBy(xpath = "//*[@id=\"page:main-container\"]/div[2]/table/tbody/tr/td[2]/button")
    WebElement CreateNewOrderButton;

    @FindBy(xpath = "//input[@type=\"text\" and @name=\"entity_id\" " +
            "and @id=\"sales_order_create_customer_grid_filter_entity_id\" " +
            "and @class=\"input-text no-changes\"] ")
    WebElement IDField;

    @FindBy(xpath = "//html/body/div/div[3]/div/form/div[3]/div/div[2]/div/table/tbody/tr/td[2]/button[2]/span")
    WebElement SearchButton;

    @FindBy(css = "tr[title='855']")
    WebElement NameOfSearch;

    @FindBy(xpath = "//*[@id=\"store_5\" and @type=\"radio\"] ")
    WebElement DellButton;

    @FindBy(xpath = "//div[@class=\"form-buttons\"]/button")
    WebElement AddProductsButton;

    @FindBy(xpath = "//tbody//tr//td//a[@class=\"f-right\" " +
            "and @list_type=\"product_to_add\" and @product_id=\"877\"]")
    WebElement BlackNolitaCamiButton;

    @FindBy(xpath = "//select[@name=\"super_attribute[92]\"]")
    WebElement ColorSelection;

    @FindBy(xpath = "//select//option[@value=\"20\" and @price=\"0\"]")
    WebElement BlackSlection;

    @FindBy(xpath = "//select[@name=\"super_attribute[180]\" and @id=\"attribute180\"]")
    WebElement SizeSelection;

    @FindBy(xpath = "//option[@value=\"79\" and @price=\"0\"]")
    WebElement SizeM;

    @FindBy(xpath = "//input[@class=\"input-text\" and @name=\"qty\"]")
    WebElement Quantity;

    @FindBy(xpath = "//span[contains(text(),\"OK\")]")
    WebElement OKButton;

    @FindBy(xpath = "//button[@class=\"scalable add\" and @title=\"Add Selected Product(s) to Order\"]")
    WebElement AddSelectedProductToOrderButton;

    @FindBy(xpath = "//div[@class=\"nobr\"]")
    WebElement CustomPriceCheckBox;

    @FindBy(xpath = "//input[@class=\"input-text item-price\"]")
    WebElement PriceField;

    @FindBy(xpath = "//div[@id=\"order-shipping-method-summary\"]/a")
    WebElement GetShippingMethodsAndRatesLink;

    @FindBy(xpath = "//input[@name=\"order[shipping_method]\" and @id=\"s_method_flatrate_flatrate\"]")
    WebElement FixedBox;

    @FindBy(xpath = "//label[contains(text(),\"Cash On Delivery\")]")
    WebElement CashOnBox;

    @FindBy(xpath = "//button[@id=\"submit_order_top_button\" and@class=\"scalable save\"]")
    WebElement SubmitOrderButton;

    @FindBy(xpath = "//*[contains(text(),\"The order has been created.\")]")
    WebElement VerifyMessageTheOrderHasBeenCreated;

    @FindBy(css = "input[id='email']")
    WebElement CustomerEmailField;

    public CreatNewOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }




    public void OpenOrdersPage(String ID){
        testUtility.waitForElementPresent(SalesButton);
        SalesButton.click();
        testUtility.waitForElementPresent(OrderButton);
        OrderButton.click();
        testUtility.waitForElementPresent(CreateNewOrderButton);
        CreateNewOrderButton.click();
        testUtility.waitForElementPresent(IDField);
        IDField.sendKeys(ID);
        testUtility.waitForElementPresent(SearchButton);
        SearchButton.click();
        testUtility.sleep(2);
        testUtility.waitForElementPresent(NameOfSearch);
        NameOfSearch.click();
        testUtility.waitForElementPresent(DellButton);
        DellButton.click();
        testUtility.sleep(2);
        js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-1000)");
        testUtility.waitForElementPresent(AddProductsButton);
        AddProductsButton.click();
        testUtility.waitForElementPresent(BlackNolitaCamiButton);
        BlackNolitaCamiButton.click();

    }
    public void ChooseSelection(String quantity) {
        testUtility.waitForElementPresent(ColorSelection);
        ColorSelection.click();
        testUtility.waitForElementPresent(BlackSlection);
        BlackSlection.click();
        testUtility.waitForElementPresent(SizeSelection);
        SizeSelection.click();
        testUtility.waitForElementPresent(SizeM);
        SizeM.click();
        testUtility.waitForElementPresent(Quantity);
        Quantity.sendKeys(quantity);
        testUtility.waitForElementPresent(OKButton);
        OKButton.click();
    }
    public void AddSelectedProduct(String ChangePrice){
        testUtility.waitForElementPresent(AddSelectedProductToOrderButton);
        AddSelectedProductToOrderButton.click();
        testUtility.waitForElementPresent(CustomPriceCheckBox);
        CustomPriceCheckBox.click();
        testUtility.waitForElementPresent(PriceField);
        PriceField.clear();
        PriceField.sendKeys(ChangePrice);
        testUtility.sleep(3);
        js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        testUtility.waitForElementPresent(GetShippingMethodsAndRatesLink);
        GetShippingMethodsAndRatesLink.click();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(FixedBox);
        FixedBox.click();
        testUtility.sleep(3);
        testUtility.waitForElementPresent(CashOnBox);
        CashOnBox.click();
        testUtility.waitForElementPresent(CustomerEmailField);
        CustomerEmailField.clear();
        CustomerEmailField.sendKeys(testUtility.fakeEmail());
        testUtility.waitForElementPresent(SubmitOrderButton);
        SubmitOrderButton.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();


    }
    public boolean VerifyMessage(){
        js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-1000)");
        testUtility.waitForElementPresent(VerifyMessageTheOrderHasBeenCreated);
        return VerifyMessageTheOrderHasBeenCreated.isDisplayed();
    }


}
