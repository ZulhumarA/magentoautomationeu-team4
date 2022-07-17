package regression.uitest.testngframework;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.marketingmodule.AddNewsletterTemplatePage;
import com.seleniummaster.ui.backend.marketingmodule.DeleteNewsletterTemplatePage;
import com.seleniummaster.ui.backend.marketingmodule.FilterShoppingCartPricingRuleByIdAndRule;
import com.seleniummaster.ui.backend.marketingmodule.UpdateNewsletterTemplatePage;
import com.seleniummaster.ui.backend.marketingmodule.ViewNewsletterSubscribersPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MarketingModuleRunner extends TestBase {

    AdminLoginPage adminLoginPage;
    FilterShoppingCartPricingRuleByIdAndRule filterShoppingCartPricingRuleByIdAndRule;
    AddNewsletterTemplatePage addNewsletterTemplatePage;
    UpdateNewsletterTemplatePage updateNewsletterTemplatePage;
    DeleteNewsletterTemplatePage deleteNewsletterTemplatePage;
    ViewNewsletterSubscribersPage viewNewsletterSubscribersPage;

    @BeforeClass
    public void setUp(ITestContext context) {
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties", "backEndURL"));
        context.setAttribute("driver", driver);
    }

    @Test
    public void FilterShoppingCartPricingRuleByIdAndRule() {
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("marketingManager");
        filterShoppingCartPricingRuleByIdAndRule = new FilterShoppingCartPricingRuleByIdAndRule(driver);
        filterShoppingCartPricingRuleByIdAndRule.OpenShoppingCartPricesRules();
        Assert.assertTrue(filterShoppingCartPricingRuleByIdAndRule.changeIdAndVerifyIt());
        filterShoppingCartPricingRuleByIdAndRule.resetTheFilter();
        Assert.assertTrue(filterShoppingCartPricingRuleByIdAndRule.changeRuleNameAndVerify());
    }

    @Test
    public void addNewsletterTemplateMethod() {
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("marketingManager");
        addNewsletterTemplatePage = new AddNewsletterTemplatePage(driver);
        addNewsletterTemplatePage.addNewsletterTemplate();
        Assert.assertTrue(addNewsletterTemplatePage.verifyNewsletterTemplateAddedSuccessfully());
    }

    @Test
    public void updateNewsletterTemplate() {
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("marketingManager");
        updateNewsletterTemplatePage = new UpdateNewsletterTemplatePage(driver);
        updateNewsletterTemplatePage.updateExistingNewsletterTemplate();
        Assert.assertTrue(updateNewsletterTemplatePage.verifyTemplateUpdatedSuccessfully());
    }

    @Test
    public void deleteTemplateMethod(){
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("marketingManager");
        deleteNewsletterTemplatePage=new DeleteNewsletterTemplatePage(driver);
        deleteNewsletterTemplatePage.deleteTemplate();
        Assert.assertTrue(deleteNewsletterTemplatePage.verifyTemplateDeletedSuccessfully());
    }

    @Test
    public void viewNewsletterSubscribersMethod() {
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("marketingManager");
        viewNewsletterSubscribersPage = new ViewNewsletterSubscribersPage(driver);
        viewNewsletterSubscribersPage.viewNewsletterSubscribers();
        Assert.assertTrue(viewNewsletterSubscribersPage.verifyNewsletterSubscribersViewed());
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}
