package regression.uitest.testngframework;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import com.seleniummaster.ui.backend.salesmodule.ManageOrdersPageAbide;
import com.seleniummaster.ui.backend.salesmodule.UpdateExistingShoppingCart;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SaleModuleRunner extends TestBase {

    TestUtility testUtility;
    AdminLoginPage adminLoginPage;
    ManageOrdersPageAbide manageOrdersPageAbide;
    UpdateExistingShoppingCart updateExistingShoppingCart;
    @BeforeClass
    public void setUp(ITestContext context) {
        testUtility = new TestUtility(driver);

        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties", "backEndURL"));
        context.setAttribute("driver", driver);
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("salesManager");
        manageOrdersPageAbide=new ManageOrdersPageAbide(driver);
        updateExistingShoppingCart=new UpdateExistingShoppingCart(driver);
    }


    @Test(description = "sales manager can add ,edit,delete orders--Abide")
    public void manageOrdersMethod(){
        manageOrdersPageAbide.createOrdersMethod();
        Assert.assertTrue(manageOrdersPageAbide.verifyCreateOrdersMethods());
        manageOrdersPageAbide.editOrdersMethods();
        Assert.assertTrue(manageOrdersPageAbide.verifyEditOrdersSuccessfully());
        manageOrdersPageAbide.cancelOrders();
        Assert.assertTrue(manageOrdersPageAbide.verifyOrderCanceledSuccessfully());
    }

    @Test(description = "updating existing shopping cart--Abide ")
    public void UpdateExistingShoppingCart(){
        updateExistingShoppingCart.updateExistingShoppingCart();
        Assert.assertTrue(updateExistingShoppingCart.verifyShoppingCartUpdatedSuccessfully());
    }



    @AfterClass(enabled = false)
    public void tearDown() {
        closeBrowser();
    }
}
