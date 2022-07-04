package regression.uitest.testngframework;

import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.frontend.UpdateCartPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PublicModuleRunner extends TestBase {

    UpdateCartPage cartPage;

    @BeforeClass
    public void setUp(){
       browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties","frontEndURL"));
    }


    @Test
    public void addLinenBlazerProductToCart(){
        cartPage=new UpdateCartPage(driver);
        cartPage.addLinenBlazerToCart();
        Assert.assertTrue(cartPage.verifyLinenBlazerSuccessfullyAddedMessage());
    }

    @Test
    public void updateProductSize(){
        cartPage=new UpdateCartPage(driver);
        cartPage.changeProductSizeMethod();
        Assert.assertTrue(cartPage.verifyLinenBlazerProductUpdatedSuccessfully());
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





