package regression.uitest.cucumberframework.salesmodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.salesmodule.ManageOrdersPageAbide;
import com.seleniummaster.ui.backend.salesmodule.UpdateExistingShoppingCart;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ManageOrdersAndShoppingCart extends TestBase {

    AdminLoginPage adminLoginPage;
    String configFile = "config.properties";
    ManageOrdersPageAbide manageOrdersPageAbide;
    UpdateExistingShoppingCart updateExistingShoppingCart;

    @Before("@ManageOrdersAndUpdateShoppingCart")
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile, "backEndURL"));
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("salesManager");
    }

    @Given("sales Manager on the dashboard page")
    public void salesManagerOnTheDashboardPage() {
        adminLoginPage.verifyAdminLoginSuccessfully();
        manageOrdersPageAbide=new ManageOrdersPageAbide(driver);
        updateExistingShoppingCart=new UpdateExistingShoppingCart(driver);
    }


    @When("sales manager should be able to create orders")
    public void salesManagerShouldBeAbleToCreateOrders() {
        manageOrdersPageAbide.createOrdersMethod();
    }

    @Then("orders should be created successfully")
    public void ordersShouldBeCreatedSuccessfully() {
        Assert.assertTrue(manageOrdersPageAbide.verifyCreateOrdersMethods());
    }

    @When("sales manager should be able to edit orders")
    public void salesManagerShouldBeAbleToEditOrders() {
        manageOrdersPageAbide.editOrdersMethods();
    }

    @Then("orders edited successfully")
    public void ordersEditedSuccessfully() {
        Assert.assertTrue(manageOrdersPageAbide.verifyEditOrdersSuccessfully());
    }

    @When("sales manager should be able to cancel orders")
    public void salesManagerShouldBeAbleToDeleteOrders() {
        manageOrdersPageAbide.cancelOrders();
    }

    @Then("orders canceled successfully")
    public void ordersDeletedSuccessfully() {
        Assert.assertTrue(manageOrdersPageAbide.verifyOrderCanceledSuccessfully());

    }

    @When("Sales Manager update the customers shopping cart")
    public void salesManagerUpdateTheCustomersShoppingCart() {
        updateExistingShoppingCart.updateExistingShoppingCart();
    }

    @Then("shopping cart should be updated successfully")
    public void shoppingCartShouldBeUpdatedSuccessfully() {
        Assert.assertTrue(updateExistingShoppingCart.verifyShoppingCartUpdatedSuccessfully());
    }
}
