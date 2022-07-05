package regression.uitest.testngframework;

import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.PublicLoginPage;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.frontend.UpdateCartPage;
import com.seleniummaster.ui.frontend.ViewAccountInformationPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PublicModuleRunner extends TestBase {

    UpdateCartPage updateCartPage;
    PublicLoginPage publicLoginPage;
    ViewAccountInformationPage viewAccountInformationPage;
    @BeforeClass
    public void setUp(){
       browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties","frontEndURL"));
    }


    @Test(priority = 1)
    public void addLinenBlazerProductToCart(){
        updateCartPage=new UpdateCartPage(driver);
        updateCartPage.addLinenBlazerToCart();
        Assert.assertTrue(updateCartPage.verifyLinenBlazerSuccessfullyAddedMessage());
    }

    @Test(priority = 2)
    public void updateProductSize(){
        updateCartPage=new UpdateCartPage(driver);
        updateCartPage.changeProductSizeMethod();
        Assert.assertTrue(updateCartPage.verifyLinenBlazerProductUpdatedSuccessfully());
        updateCartPage.returnToHomePage();
    }

    @Test(priority = 3)
    public void ViewAccountInformation(){
        publicLoginPage=new PublicLoginPage(driver);
        publicLoginPage.Login();
        viewAccountInformationPage=new ViewAccountInformationPage(driver);
        viewAccountInformationPage.openAccountInformation();
        Assert.assertTrue(viewAccountInformationPage.verifyAccountInformation());

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





