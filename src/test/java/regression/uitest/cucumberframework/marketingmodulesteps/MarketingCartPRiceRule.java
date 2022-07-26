package regression.uitest.cucumberframework.marketingmodulesteps;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.marketingmodule.AddNewCartPriceRule;
import com.seleniummaster.ui.backend.marketingmodule.FilterShoppingCartPricingRuleByIdAndRule;
import com.seleniummaster.ui.backend.marketingmodule.UpdateCartPriceRule;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class MarketingCartPRiceRule extends TestBase {
    String configFile = "config.properties";
    AdminLoginPage adminLoginPage;
    AddNewCartPriceRule addNewCartPriceRule;
    FilterShoppingCartPricingRuleByIdAndRule filterShoppingCartPricingRuleByIdAndRule;
    UpdateCartPriceRule updateCartPriceRule;

//The masterpiece of MAHMUT Ibrahim :)
    @Before("@CartPriceRuleTest")
    public void setUp() {
        browserSetUp(ApplicationConfig.readFromConfigProperties
                (configFile, "backEndURL"));
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("marketingManager");
    }

    @Given("Marketing Manager on the dashboard page")
    public void marketing_manager_on_the_dashboard_page() {
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.verifyAdminLoginSuccessfully();
        addNewCartPriceRule = new AddNewCartPriceRule(driver);
        filterShoppingCartPricingRuleByIdAndRule = new FilterShoppingCartPricingRuleByIdAndRule(driver);
        updateCartPriceRule = new UpdateCartPriceRule(driver);
    }

    @When("Marketing manager add a New cart price rule")
    public void marketingManagerAddANewCartPriceRule() {
        addNewCartPriceRule.OpenShoppingCartPricesRules();
        addNewCartPriceRule.CreateShoppingCardRule();
    }

    @Then("the New price rule should be added")
    public void theNewPriceRuleShouldBeAdded() {
        addNewCartPriceRule.VerifyAddNewRule();
    }

    @When(("Marketing Manager filter shopping cart pricing rule by id and Rule"))
    public void FilterShoppingCartPricingRuleByIdAndRule(){
       filterShoppingCartPricingRuleByIdAndRule.OpenShoppingCartPricesRules();
    }

    @Then("the shopping cart pricing rule should be filtered")
    public void ShoppingCartShouldBeFiltered(){
        filterShoppingCartPricingRuleByIdAndRule.changeRuleNameAndVerify();
        filterShoppingCartPricingRuleByIdAndRule.changeIdAndVerifyIt();
    }

    @When("Marketing manager update the shopping cart rule")
    public void marketingManagerUpdateTheShoppingCartRule() {
        updateCartPriceRule.OpenShoppingCartPricesRules();
    }

    @Then("Shopping cart rule should be updated")
    public void shoppingCartRuleShouldBeUpdated() {
        updateCartPriceRule.UpdateRule();
        updateCartPriceRule.VerifyUpdate();
    }

    @After("@CartPriceRuleTest")
    public void teardown() {
        closeBrowser();
    }

}

