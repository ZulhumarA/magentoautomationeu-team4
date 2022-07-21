package regression.uitest.testngframework;

import com.seleniummaster.configutility.*;
import com.seleniummaster.ui.backend.storemodule.AddProductCategories;
import com.seleniummaster.ui.backend.storemodule.CreateStoreViewPage;
import com.seleniummaster.ui.backend.storemodule.DeleteWebsiteInfo;
import com.seleniummaster.ui.backend.storemodule.EditStoreViewPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreModuleRunner extends TestBase {

    TestUtility testUtility;
    AdminLoginPage adminLoginPage;
    DeleteWebsiteInfo deleteWebsite;
    AddProductCategories addProductCategories;
    @BeforeClass
    public void setUp(ITestContext context) {
        testUtility = new TestUtility(driver);

        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties", "backEndURL"));
        context.setAttribute("driver", driver);
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("storeManager");
        addProductCategories = new AddProductCategories(driver);
    }
@Test(description = "Create store view-Zulhumar")
    public void CreateStoreView() throws InterruptedException {
    CreateStoreViewPage createStoreViewPage=new CreateStoreViewPage(driver);
    createStoreViewPage.openManageStoresPage();
   createStoreViewPage.fillOutStoreViewInformation();
   Assert.assertTrue(createStoreViewPage.verifyStoreViewSuccessfullyCreated());
}
@Test(description = "Edit Store view-Zulhumar",priority = 1,dependsOnMethods = "CreateStoreView")
public void EditStoreView(){


    EditStoreViewPage editStoreViewPage=new EditStoreViewPage(driver);
    editStoreViewPage.openManageStoresPage();
    editStoreViewPage.editStoreViewMethod();
    Assert.assertTrue(editStoreViewPage.verifyStoreViewSuccessfullyUpdated());

}
    @Test
    public void DeleteWebsiteInfo() {
        deleteWebsite = new DeleteWebsiteInfo(driver);
        deleteWebsite.DeleteWebsiteInformation();
        Assert.assertTrue(deleteWebsite.VerifyDeletedMassageSuccessfully());
    }

    @Test(description = "Add Product Categories-Faruk",priority = 2)
    public void AddProductCategories(){
        addProductCategories.setCatalogButton();
        addProductCategories.setManegeCategoriesButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addProductCategories.setName(ApplicationConfig.readFromConfigProperties("config.properties","NameF"));
        addProductCategories.setIsActive();
        addProductCategories.setIncludeInNavigationMenu();
        addProductCategories.setSaveCategoryButton();
        Assert.assertTrue(addProductCategories.VerifySavedMassageSuccessfully());
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}
