package regression.uitest.testngframework;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.frontend.PublicModulePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PublicModuleRunner extends TestBase {

    PublicModulePage cartPage;

    @BeforeClass
    public void setUp(){
       userPageBrowserSetUp();
    }


    @Test
    public void addLinenBlazerProductToCart(){
        cartPage=new PublicModulePage(driver);
        cartPage.addLinenBlazerToCart();
        Assert.assertTrue(cartPage.verifyLinenBlazerSuccessfullyAddedMessage());
    }

    @Test
    public void updateProductSize(){
        cartPage=new PublicModulePage(driver);
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





