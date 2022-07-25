package regression.uitest.cucumberframework.salesmodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.salesmodule.ManageViewShoppingCart;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewShoppingCartSteps extends TestBase {

    AdminLoginPage adminLoginPage;
    String configFile="config.properties";
    ManageViewShoppingCart manageViewShoppingCart;

    @Before()
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile,"backEndURL"));
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("salesManager");
    }
    @Given("Sales Manager on the dashboard page")
    public void SalesManagerOnTheDashboardPage() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.verifyAdminLoginSuccessfully();
        manageViewShoppingCart=new ManageViewShoppingCart(driver);

    }
    @When("Sales Manager views shopping cart")
    public void SalesManagerViewsShoppingCart() {
       manageViewShoppingCart.ViewShoppingCart();

    }
    @Then("Shopping cart should be viewed")
    public void ShoppingCartShouldBeViewed() {
        manageViewShoppingCart.VerifyShoppingCartTable();

    }


    @After("@ManageViewShoppingCartForCustomers")
    public void teardown(){
        closeBrowser();
    }
}


