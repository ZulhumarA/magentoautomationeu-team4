package regression.uitest.testngframework;

import com.github.javafaker.App;
import com.seleniummaster.configutility.*;
import com.seleniummaster.ui.backend.storemodule.*;
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
    CanAddProducts canAddProducts;
    CanUpdateProductPage canUpdateProductPage;
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
        CreateStoreViewPage createStoreViewPage = new CreateStoreViewPage(driver);
        createStoreViewPage.openManageStoresPage();
        createStoreViewPage.fillOutStoreViewInformation();
        Assert.assertTrue(createStoreViewPage.verifyStoreViewSuccessfullyCreated());
    }

    @Test(description = "Edit Store view-Zulhumar", priority = 1, dependsOnMethods = "CreateStoreView")
    public void EditStoreView() {
        EditStoreViewPage editStoreViewPage = new EditStoreViewPage(driver);
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

    @Test
    public void CanAddProducts(){
        CanAddProducts canAddProducts=new CanAddProducts(driver);
        canAddProducts.setCatalogButton();
        canAddProducts.setManegeProductsButton();
        canAddProducts.addProduct();
        Assert.assertTrue(addProductCategories.VerifySavedMassageSuccessfully());

    }





    @Test(description = "Add Product Categories-Faruk", priority = 2)
    public void AddProductCategories() {
        addProductCategories.setCatalogButton();
        addProductCategories.setManegeCategoriesButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addProductCategories.setName(ApplicationConfig.readFromConfigProperties("config.properties", "NameF"));
        addProductCategories.setIsActive();
        addProductCategories.setIncludeInNavigationMenu();
        addProductCategories.setSaveCategoryButton();
        Assert.assertTrue(addProductCategories.VerifySavedMassageSuccessfully());
    }
    @Test(description = "Can Update Product Categories-Faruk",priority = 3)
      public void CanUpdateProductPage(){
        canUpdateProductPage=new CanUpdateProductPage(driver);
        canUpdateProductPage.setCatalogButton();
        canUpdateProductPage.setManegeCategoriesButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        canUpdateProductPage.setClickFileName();
        canUpdateProductPage.setEnterDescription(ApplicationConfig.readFromConfigProperties("config.properties","Description"));
        canUpdateProductPage.setEnterPageTitle(ApplicationConfig.readFromConfigProperties("config.properties","PageTitle"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        canUpdateProductPage.setEnterMetaKeywords(ApplicationConfig.readFromConfigProperties("config.properties","MetaKeywords"));
        canUpdateProductPage.setEnterMetaDescription(ApplicationConfig.readFromConfigProperties("config.properties","MetaDescription"));
        canUpdateProductPage.setSaveCategoryButton();
        Assert.assertTrue(canUpdateProductPage.VerifySavedMassageSuccessfully());
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}
