package regression.uitest.testngframework;

import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.PublicLoginPage;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.frontend.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PublicModuleRunner extends TestBase {

    UpdateCartPage updateCartPage;
    PublicLoginPage publicLoginPage;
    ViewAccountInformationPage viewAccountInformationPage;
    CheckOutTheOrderPage checkOutTheOrderPage;
    ViewDownloadableOrdersPage viewDownloadableOrdersPage;
    ViewOrderPage ViewOrderPage;

    @BeforeClass
    public void setUp(){
       browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties","frontEndURL"));
    }


    @Test
    public void addLinenBlazerProductToCart(){
        updateCartPage=new UpdateCartPage(driver);
        updateCartPage.addLinenBlazerToCart();
        Assert.assertTrue(updateCartPage.verifyLinenBlazerSuccessfullyAddedMessage());
    }

    @Test
    public void updateProductSize(){
        updateCartPage=new UpdateCartPage(driver);
        updateCartPage.changeProductSizeMethod();
        Assert.assertTrue(updateCartPage.verifyLinenBlazerProductUpdatedSuccessfully());
    }

     @Test
     public void ViewAccountInformation(){
        publicLoginPage=new PublicLoginPage(driver);
        publicLoginPage.Login();
        viewAccountInformationPage=new ViewAccountInformationPage(driver);
        viewAccountInformationPage.openAccountInformation();
        Assert.assertTrue(viewAccountInformationPage.verifyAccountInformation());

}
    @Test
    public void CheckOutTheOrder(){
        publicLoginPage=new PublicLoginPage(driver);
        publicLoginPage.Login();
        checkOutTheOrderPage=new CheckOutTheOrderPage(driver);
        checkOutTheOrderPage.openMyOrders();
        Assert.assertTrue(checkOutTheOrderPage.verifyMyOrders());
    }

    @Test
    public void viewDownloadableOrders(){
        publicLoginPage=new PublicLoginPage(driver);
        publicLoginPage.Login();
        viewDownloadableOrdersPage=new ViewDownloadableOrdersPage(driver);
        viewDownloadableOrdersPage.ViewDownloableOrders();
        Assert.assertTrue(viewDownloadableOrdersPage.verifyviewDownloadableorders());
    }

    // Test Case Id: MAGE2022-314 A user should be able to create an account
    @Test
    public void createAnAccount(){
        CreateAnAccountPage createAnAccountPage=new CreateAnAccountPage(driver);
        createAnAccountPage.fillAccountRegistrationForm();
        Assert.assertTrue(createAnAccountPage.verifyCreateAnAccountSuccessful());
    }

    @Test
    public void ViewOrder(){
        publicLoginPage=new PublicLoginPage(driver);
        publicLoginPage.Login();
        ViewOrderPage=new ViewOrderPage(driver);
        ViewOrderPage.OpenMyOrders();
        ViewOrderPage.ViewOrder();
        Assert.assertTrue(ViewOrderPage.VerifyOrders());
    }

    @Test(description = "user can add new products to shopping cart-Zulhumar")
    public void addProductsToCart() {
        AddProductsToShoppingCartPage addProductsToShoppingCartPage = new AddProductsToShoppingCartPage(driver);
        addProductsToShoppingCartPage.addChelseaTeaToCart();
        Assert.assertTrue(addProductsToShoppingCartPage.verifySuccessfullyAddProduct());
    }

     @AfterClass
     public void tearDown() {
        closeBrowser();
    }
}


//    @Test
//    public void addMultipleProducts(){
//        cartPage=new CartPage(driver);
//        cartPage.addMultipleProductsToCartMethod();
//        Assert.assertTrue(cartPage.verifyChelseaTeaAdded());
//    }
//
//    @Test
//    public void addProduct(){
//        cartPage=new CartPage(driver);
//        WebElement linenBlazer=driver.findElement(By.xpath("//*[text()=\"Linen Blazer\"]"));
//        cartPage.addProductToCart(linenBlazer,"22","78");
//    }
//





