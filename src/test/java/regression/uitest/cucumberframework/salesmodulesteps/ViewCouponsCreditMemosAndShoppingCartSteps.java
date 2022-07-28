package regression.uitest.cucumberframework.salesmodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.salesmodule.CreatNewOrderPage;
import com.seleniummaster.ui.backend.salesmodule.ManageViewShoppingCart;
import com.seleniummaster.ui.backend.salesmodule.ViewAndAddCreditMemos;
import com.seleniummaster.ui.backend.salesmodule.ViewCouponsInTheReports;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

public class ViewCouponsCreditMemosAndShoppingCartSteps extends TestBase {

    AdminLoginPage adminLoginPage;
    ViewCouponsInTheReports viewCouponsInTheReports;
    ViewAndAddCreditMemos viewAndAddCreditMemos;
    ManageViewShoppingCart manageViewShoppingCart;
    CreatNewOrderPage creatNewOrderPage;
    String configFile="config.properties";

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
        viewCouponsInTheReports=new ViewCouponsInTheReports(driver);
        viewAndAddCreditMemos=new ViewAndAddCreditMemos(driver);
        manageViewShoppingCart= new ManageViewShoppingCart(driver);
        creatNewOrderPage=new CreatNewOrderPage(driver);
    }
    //ViewCouponsInTheReports
    @When("Sales Manager enters the dates in the Reports")
    public void salesManagerViewsAndAddCreditMemos(){
        viewCouponsInTheReports.CouponsInTheReports();
    }

    @Then("Sales Manager can view coupons between dates in Reports")
    public void theCreditMemosShouldBeAdded() {
        viewCouponsInTheReports.VerifyViewCoupons();
    }


////ViewAndAddCreditMemos

    @When("Sales Manager views and add credit memos")
    public void SalesManagerViewsAndAddCreditMemos() {
        viewAndAddCreditMemos.CreditMemos();
    }
    @Then("The credit memos should be added")
    public void TheCreditMemosShouldBeAdded() {
        viewAndAddCreditMemos.VerifySendSuccessfulMessage();
    }
//
//    //ManageViewShoppingCart

    @When("Sales Manager views shopping cart")
    public void SalesManagerViewsShoppingCart() {
        manageViewShoppingCart.ViewShoppingCart();

    }
    @Then("Shopping cart should be viewed")
    public void ShoppingCartShouldBeViewed() {
        manageViewShoppingCart.VerifyShoppingCartTable();

    }

    @When("Sales Manager create a new order")
    public void salesManagerCreateANewOrder() {
        creatNewOrderPage.OpenOrdersPage(ApplicationConfig.readFromConfigProperties("config.properties",
                "IDNum"));
        creatNewOrderPage.ChooseSelection(ApplicationConfig.readFromConfigProperties("config.properties",
                "Quantity"));
        creatNewOrderPage.AddSelectedProduct(ApplicationConfig.readFromConfigProperties("config.properties",
                "ChangePrice"));
    }

    @Then("New Order is created")
    public void newOrderIsCreated() {
        Assert.assertTrue(creatNewOrderPage.VerifyMessage());
    }
//    @After("@ViewCouponsCreditMemosAndShoppingCart")
//    public void teardown(){
//        closeBrowser();
//    }


}
