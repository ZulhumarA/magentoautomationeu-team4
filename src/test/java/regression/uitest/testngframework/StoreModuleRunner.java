package regression.uitest.testngframework;

import com.seleniummaster.configutility.*;
import com.seleniummaster.ui.backend.storemodule.CreateStoreViewPage;
import com.seleniummaster.ui.backend.storemodule.DeleteWebsiteInfo;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreModuleRunner extends TestBase {

    TestUtility testUtility;
    AdminLoginPage adminLoginPage;
    DeleteWebsiteInfo deleteWebsite;

    @BeforeClass
    public void setUp(ITestContext context) {
        testUtility = new TestUtility(driver);

        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties", "backEndURL"));
        context.setAttribute("driver", driver);
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("storeManager");
    }
@Test(description = "Create store view-Zulhumar")
    public void CreateStoreView() throws InterruptedException {
    CreateStoreViewPage createStoreViewPage=new CreateStoreViewPage(driver);
    createStoreViewPage.openManageStoresPage();
   createStoreViewPage.fillOutStoreViewInformation();
   Assert.assertTrue(createStoreViewPage.verifyStoreViewSuccessfullyCreated());
}


    @Test
    public void DeleteWebsiteInfo() {
        deleteWebsite = new DeleteWebsiteInfo(driver);
        deleteWebsite.DeleteWebsiteInformation();
        Assert.assertTrue(deleteWebsite.VerifyDeletedMassageSuccessfully());
    }

    @AfterClass(enabled = false)
    public void tearDown() {
        closeBrowser();
    }
}
