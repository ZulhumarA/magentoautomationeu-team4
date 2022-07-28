package regression.uitest.cucumberframework.storemodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.PublicLoginPage;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.storemodule.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StoreModuleSteps extends TestBase {
    CreateStoreViewPage createStoreViewPage;
    EditStoreViewPage editStoreViewPage;
    String configFile="config.properties";
    AdminLoginPage adminLoginPage;

    @Before("@ManageStoreTest")
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile,"backEndURL"));
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("storeManager");
    }

    @After("@ManageStoreTest")
    public void tearDown()
    {
        closeBrowser();
    }

    @When("user enter valid userName  and valid Password and click on login Button")
    public void userEnterValidUserNameAndValidPasswordAndClickOnLoginButton() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("storeManager");}


    @Then("user should able to login successfully")
    public void userShouldAbleToLoginSuccessfully() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("storeManager");

    }

//Store Manager can create a store view Zulhumar
    @Given("store manager on the dashboard page")
    public void storeManagerOnTheDashboardPage() {
       adminLoginPage=new AdminLoginPage(driver);
        Assert.assertTrue(adminLoginPage.verifyAdminLoginSuccessfully());

    }

    @When("store manager create a new store view")
    public void storeManagerCreateANewStoreView() throws InterruptedException {
       createStoreViewPage= new CreateStoreViewPage(driver);
        createStoreViewPage.openManageStoresPage();
      createStoreViewPage.fillOutStoreViewInformation();

    }


    @Then("successfully created message should be displayed")
    public void successfullyCreatedMessageShouldBeDisplayed() {
        editStoreViewPage=new EditStoreViewPage(driver);
        createStoreViewPage.verifyStoreViewSuccessfullyCreated();

    }
    //Store Manager can edit a store view zulhumar
    @When("store manager edit a store view")
    public void storeManagerEditAStoreView() {
       EditStoreViewPage editStoreViewPage=new EditStoreViewPage(driver);
        editStoreViewPage.openManageStoresPage();
        editStoreViewPage.editStoreViewMethod();
    }
    @Then("successfully edited message should be displayed")
    public void successfullyEditedMessageShouldBeDisplayed() {
      EditStoreViewPage editStoreViewPage=new EditStoreViewPage(driver);
        Assert.assertTrue(editStoreViewPage.verifyStoreViewSuccessfullyUpdated());
    }


//*************************Kadirya*****************************
     StoreManagerCanAddProducts storeManagerCanAddProducts;
    StoreManagerCanUpdateProduct storeManagerCanUpdateProduct;
    StoreManagerCanDeleteProduct storeManagerCanDeleteProduct;


@When("store manager should be able to add product")
   public void store_manager_should_be_able_to_add_product() {
     storeManagerCanAddProducts=new StoreManagerCanAddProducts(driver);
    storeManagerCanAddProducts.setCatalogButton();
    storeManagerCanAddProducts.setManegeProductsButton();
    storeManagerCanAddProducts.addProduct();
}

    @Then("a new product should be added")
    public void a_new_product_should_be_added() {
        storeManagerCanAddProducts=new StoreManagerCanAddProducts(driver);
        Assert.assertTrue(storeManagerCanAddProducts.VerifySavedMassageSuccessfully());
    }



    @When("store manager should be able to update product")
    public void store_manager_should_be_able_to_update_product() {
        storeManagerCanUpdateProduct = new StoreManagerCanUpdateProduct(driver);
        storeManagerCanUpdateProduct.setCatalogButton();
        storeManagerCanUpdateProduct.setManegeProductsButton();
        storeManagerCanUpdateProduct.UpdateProduct();
    }

    @Then("a new product should be updated")
    public void a_new_product_should_be_updated() {
        storeManagerCanUpdateProduct=new StoreManagerCanUpdateProduct(driver);
        Assert.assertTrue(storeManagerCanUpdateProduct.VerifySavedMassageSuccessfully());

    }


    @When("store manager should be able to delete product")
    public void store_manager_should_be_able_to_delete_product() {
        storeManagerCanDeleteProduct = new StoreManagerCanDeleteProduct(driver);
        storeManagerCanDeleteProduct.setCatalogButton();
        storeManagerCanDeleteProduct.setManegeProductsButton();
        storeManagerCanDeleteProduct.DeleteProduct();
    }

    @Then("a old product should be deleted")
    public void a_old_product_should_be_deleted() {
        storeManagerCanDeleteProduct=new StoreManagerCanDeleteProduct(driver);
        Assert.assertTrue(storeManagerCanDeleteProduct.VerifySavedMassageSuccessfully());

    }

    //*************************** Abide ****************************
    @When("store manager cancel orders")
    public void storeManagerCancelOrders() {
    CancelOrdersPage cancelOrdersPage=new CancelOrdersPage(driver);
    cancelOrdersPage.cancelOrders();
    }

    @Then("an order should be canceled")
    public void anOrderShouldBeCanceled() {
        CancelOrdersPage cancelOrdersPage=new CancelOrdersPage(driver);
        Assert.assertTrue(cancelOrdersPage.verifyCancelOrdersSuccessfully());
    }
}