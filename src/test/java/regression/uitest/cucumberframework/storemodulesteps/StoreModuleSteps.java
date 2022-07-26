package regression.uitest.cucumberframework.storemodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.PublicLoginPage;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.storemodule.CreateStoreViewPage;
import com.seleniummaster.ui.backend.storemodule.EditStoreViewPage;
import com.seleniummaster.ui.backend.storemodule.StoreManagerCanUpdateProduct;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StoreModuleSteps extends TestBase {
    CreateStoreViewPage createStoreViewPage;
    EditStoreViewPage editStoreViewPage;
    StoreManagerCanUpdateProduct storeManagerCanUpdateProduct;
    String configFile="config.properties";
    AdminLoginPage adminLoginPage;
    @Before("@ManageStoreTest")
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile,"backEndURL"));
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

    //Store Manager Can Update Produtc --Kadirya
    @When("store manager uptaded product information")
    public void StoreManagerCanUpdatePtoduct() {
        storeManagerCanUpdateProduct.setCatalogButton();
        storeManagerCanUpdateProduct.setManegeProductsButton();
        storeManagerCanUpdateProduct.UpdateProduct();
    }

    @Then("successfully edited message should be displayed")
    public void successfullySaveMessageDisplayed(){
        StoreManagerCanUpdateProduct storeManagerCanUpdateProduct=new StoreManagerCanUpdateProduct(driver);
        Assert.assertTrue(storeManagerCanUpdateProduct.VerifySavedMassageSuccessfully());
    }






    @After("@ManageStoreTest")
    public void tearDown()
    {
        closeBrowser();
    }

}

