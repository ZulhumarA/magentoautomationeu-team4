package regression.uitest.cucumberframework.storemodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.PublicLoginPage;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.storemodule.CanAddProducts;
import com.seleniummaster.ui.backend.storemodule.CreateStoreViewPage;
import com.seleniummaster.ui.backend.storemodule.EditStoreViewPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StoreModuleSteps extends TestBase {
    CreateStoreViewPage createStoreViewPage;
    EditStoreViewPage editStoreViewPage;
    CanAddProducts canAddProducts;
    String configFile = "config.properties";
    AdminLoginPage adminLoginPage;

    @Given("user Already on the login page")
    public void userAlreadyOnTheLoginPage() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile,"backEndURL"));
    }

    @When("user enter valid userName  and valid Password and click on login Button")
    public void userEnterValidUserNameAndValidPasswordAndClickOnLoginButton() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("storeManager");}


    @Then("user should able to login successfully")
    public void userShouldAbleToLoginSuccessfully() {
        adminLoginPage=new AdminLoginPage(driver);
        Assert.assertTrue(adminLoginPage.verifyAdminLoginSuccessfully());
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


//Kadirya
@When("store manager should be able to add product")
   public void store_manager_should_be_able_to_add_product() {
    CanAddProducts canAddProducts=new CanAddProducts(driver);
    canAddProducts.setCatalogButton();
    canAddProducts.setManegeProductsButton();
    canAddProducts.addProduct();
}
    @Then("a new product should be added")
    public void a_new_product_should_be_added() {
        CanAddProducts canAddProducts=new CanAddProducts(driver);
        Assert.assertTrue(canAddProducts.VerifySavedMassageSuccessfully());
    }

    @After("@ManageStoreTest")
    public void tearDown()
    {
        closeBrowser();
    }

}