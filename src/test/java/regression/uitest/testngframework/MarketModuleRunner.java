package regression.uitest.testngframework;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.marketingmodule.FilterShoppingCartPricingRuleByIdAndRule;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MarketModuleRunner extends TestBase {

    AdminLoginPage adminLoginPage;
    FilterShoppingCartPricingRuleByIdAndRule filterShoppingCartPricingRuleByIdAndRule;
    @BeforeClass
    public void setUp(ITestContext context) {
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties", "backEndURL"));
        context.setAttribute("driver", driver);
    }

    @Test
    public void FilterShoppingCartPricingRuleByIdAndRule(){
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("marketingManager");
        filterShoppingCartPricingRuleByIdAndRule=new FilterShoppingCartPricingRuleByIdAndRule(driver);
        filterShoppingCartPricingRuleByIdAndRule.OpenShoppingCartPricesRules();
        Assert.assertTrue(filterShoppingCartPricingRuleByIdAndRule.changeIdAndVerifyIt());
        filterShoppingCartPricingRuleByIdAndRule.resetTheFilter();
        Assert.assertTrue(filterShoppingCartPricingRuleByIdAndRule.changeRuleNameAndVerify());
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }

}
