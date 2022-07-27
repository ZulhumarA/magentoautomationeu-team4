package com.seleniummaster.ui.backend.salesmodule;

import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class ManageOrdersPageAbide {

   WebDriver driver;
   TestUtility testUtility;
   Actions action;


   @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/a")
    WebElement salesLink;

   @FindBy(xpath = "/html/body/div[1]/div[1]/div[3]/ul/li[2]/ul/li[1]")
   WebElement OrdersLink;

   @FindBy(css = "button[title=\"Create New Order\"]")
   WebElement createNewOrdersButton;

   @FindBy(css = "#sales_order_create_customer_grid_table > tbody > tr:nth-child(1)")
   WebElement customerTablesFirstLine;

   @FindBy(css = "#store_16")
   WebElement storeSelection;

   @FindBy(xpath = "/html/body/div[1]/div[3]/div/form/div[5]/div/div/table/tbody/tr/td[2]/div[6]/div[1]/div/fieldset/div[2]/div[1]/div/table/tbody/tr[2]/td[2]/input")
   WebElement  billingFirstName;

   @FindBy(xpath = "/html/body/div[1]/div[3]/div/form/div[5]/div/div/table/tbody/tr/td[2]/div[6]/div[1]/div/fieldset/div[2]/div[1]/div/table/tbody/tr[4]/td[2]/input")
   WebElement billingLastName;

   @FindBy(css = "td.value>div.multi-input>input[name=\"order[billing_address][street][0]\"]")
   WebElement billingStringAddress1;

   @FindBy(css = "td.value>div.multi-input>input[name=\"order[billing_address][street][1]\"]")
   WebElement billingStreetAddress2;

   @FindBy(css = "input#order-billing_address_city")
   WebElement billingCityName;

   @FindBy(css = "#order-billing_address_region_id")
   WebElement billingProvince;

   @FindBy(css = "#order-billing_address_region_id>option:nth-child(4)")
   WebElement billingProvinceOption;

   @FindBy(css = "input#order-billing_address_postcode")
    WebElement billingPostCode;

   @FindBy(css = "input#order-billing_address_telephone")
    WebElement billingTelephoneNumber;

   @FindBy(css = "div#order-shipping-method-summary>a")
   WebElement shippingMethod;

   @FindBy(css= "input#s_method_freeshipping_freeshipping")
   WebElement shippingMethodOption;

   @FindBy(css = "dl.payment-methods>dt>input#p_method_cashondelivery")
   WebElement paymentMethodOption;

   @FindBy(css = "#messages > ul > li > ul > li > span")
    WebElement successfulMessage;

   @FindBy(css = "div.form-buttons>button")
    WebElement addProductsButton;

  @FindBy(css = "#sales_order_create_search_grid_table > thead > tr.headings > th:nth-child(1) > span > a")
   WebElement IDOrderButton;

  @FindBy(css = "#sales_order_create_search_grid_table > tbody > tr:nth-child(1)")
  WebElement firstProduct;

  @FindBy(css = "button[title=\"Add Selected Product(s) to Order\"]")
  WebElement addProductToOrderButton;

  @FindBy (css = "button#submit_order_top_button")
  WebElement submitOrderButton;

  @FindBy(css = "div.main-col-inner>div.content-header>p.form-buttons>button[title=\"Edit\"]")
  WebElement EditButton;

  @FindBy(css = "div.nobr>input[type=\"checkbox\"]")
  WebElement customPriceInput;

  @FindBy(xpath = "/html/body/div[2]/div[3]/div/form/div[5]/div/table/tbody/tr/td[2]/div[3]/div/div[2]/div[1]/table/tbody/tr[1]/td[3]/input")
  WebElement priceInputBox;

  @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/p/button[3]")
  WebElement submitButtonForEditOrders;

  @FindBy(xpath = "//*[@id=\"messages\"]/ul/li/ul/li/span")
  WebElement SuccessfulMessageForEditOrders;

  @FindBy(css = "select#sales_order_grid_filter_status")
  WebElement statusFilter;

  @FindBy(css = "#sales_order_grid_filter_status > option:nth-child(12)")
  WebElement statusPendingOption;

  @FindBy(css ="button[title=\"Search\"")
  WebElement searchButtonForPendingFilter;

  @FindBy(css = "#sales_order_grid_table > tbody > tr:nth-child(1)")
  WebElement firstOrderInTable;

  @FindBy(css = "button[title=\"Cancel\"]")
  WebElement cancelOrderButton;

  @FindBy(css = "#messages > ul > li > ul > li > span")
  WebElement successfulMessageForCancelOrder;

  @FindBy(css = "#html-body > div.wrapper > div.header > div.header-top > a > img")
  WebElement HomePage;

    public ManageOrdersPageAbide(WebDriver driver) {
        this.driver = driver;
        testUtility=new TestUtility(driver);
        action=new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    //Methods
    public void createOrdersMethod(){
        testUtility.waitForElementPresent(salesLink);
        salesLink.click();
       action.moveToElement(OrdersLink).click().perform();
        testUtility.waitForElementPresent(createNewOrdersButton);
        createNewOrdersButton.click();
        action.moveToElement(customerTablesFirstLine).click().perform();
        testUtility.waitForElementPresent(storeSelection);
        storeSelection.click();
        testUtility.sleep(3);
        action.moveToElement(addProductsButton).click().perform();
        testUtility.waitForElementPresent(IDOrderButton);
        IDOrderButton.click();
        testUtility.sleep(2);
        testUtility.waitForElementPresent(firstProduct);
        firstProduct.click();
        testUtility.sleep(2);
        testUtility.waitForElementPresent(addProductToOrderButton);
        addProductToOrderButton.click();
        testUtility.waitForElementPresent(billingFirstName);
        billingFirstName.sendKeys(testUtility.generateFirstName());
       testUtility.waitForElementPresent(billingLastName);
       billingLastName.sendKeys(testUtility.generateLastName());
       testUtility.waitForElementPresent(billingStringAddress1);
       billingStringAddress1.sendKeys(testUtility.generateStreetName());
       testUtility.waitForElementPresent(billingStreetAddress2);
       billingStreetAddress2.sendKeys(testUtility.generateStreetName());
       testUtility.sleep(1);
       testUtility.waitForElementPresent(billingCityName);
       billingCityName.sendKeys(testUtility.generateCity());
       testUtility.sleep(1);
       testUtility.waitForElementPresent(billingProvince);
       billingProvince.click();
       testUtility.sleep(2);
       testUtility.waitForElementPresent(billingProvinceOption);
       billingProvinceOption.click();
       testUtility.sleep(2);
       testUtility.waitForElementPresent(billingPostCode);
       billingPostCode.sendKeys(testUtility.generateZip());
       testUtility.waitForElementPresent(billingTelephoneNumber);
       billingTelephoneNumber.sendKeys(testUtility.generateTelephoneNumber());
       testUtility.waitForElementPresent(shippingMethod);
       shippingMethod.click();
       testUtility.waitForElementPresent(shippingMethodOption);
       shippingMethodOption.click();
       testUtility.sleep(2);
       testUtility.waitForElementPresent(paymentMethodOption);
       paymentMethodOption.click();
       testUtility.sleep(2);
       testUtility.waitForElementPresent(submitOrderButton);
       submitOrderButton.click();
    }

    public boolean verifyCreateOrdersMethods(){
        testUtility.waitForElementPresent(successfulMessage);
        if (successfulMessage.isDisplayed())
            return true;
        else
            return false;
    }

    public void editOrdersMethods(){
        testUtility.waitForElementPresent(EditButton);
        EditButton.click();
        driver.switchTo().alert().accept();
        testUtility.waitForElementPresent(customPriceInput);
        customPriceInput.click();
        testUtility.waitForElementPresent(priceInputBox);
        priceInputBox.clear();
        priceInputBox.sendKeys(testUtility.generateRandomNumbers());
        testUtility.waitForElementPresent(submitButtonForEditOrders);
        submitButtonForEditOrders.click();
        testUtility.sleep(1);
        driver.switchTo().alert().accept();
    }

    public boolean verifyEditOrdersSuccessfully(){
        testUtility.waitForElementPresent(SuccessfulMessageForEditOrders);
        if (SuccessfulMessageForEditOrders.isDisplayed())
            return true;
        else return false;
    }


   public  void cancelOrders(){
        testUtility.waitForElementPresent(HomePage);
        HomePage.click();
       testUtility.waitForElementPresent(salesLink);
       salesLink.click();
       testUtility.waitForElementPresent(OrdersLink);
       action.moveToElement(OrdersLink).click().perform();
      testUtility.waitForElementPresent(statusFilter);
      statusFilter.click();
      testUtility.waitForElementPresent(statusPendingOption);
      statusPendingOption.click();
      testUtility.waitForElementPresent(searchButtonForPendingFilter);
      searchButtonForPendingFilter.click();
      testUtility.sleep(4);

      testUtility.waitForElementPresent(firstOrderInTable);
      firstOrderInTable.click();
      testUtility.sleep(1);
      testUtility.waitForElementPresent(cancelOrderButton);
      cancelOrderButton.click();
      driver.switchTo().alert().accept();
   }

   public boolean verifyOrderCanceledSuccessfully(){
        testUtility.waitForElementPresent(successfulMessageForCancelOrder);
        if (successfulMessageForCancelOrder.isDisplayed())
            return true;
        else
            return false;
   }
}
