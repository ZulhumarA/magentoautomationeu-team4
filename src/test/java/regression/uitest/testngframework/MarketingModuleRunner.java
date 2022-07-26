package regression.uitest.testngframework;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.ui.backend.marketingmodule.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MarketingModuleRunner extends TestBase {

    AdminLoginPage adminLoginPage;
    FilterShoppingCartPricingRuleByIdAndRule filterShoppingCartPricingRuleByIdAndRule;
    AddNewsletterTemplatePage addNewsletterTemplatePage;
    UpdateNewsletterTemplatePage updateNewsletterTemplatePage;
    DeleteNewsletterTemplatePage deleteNewsletterTemplatePage;
    ViewNewsletterSubscribersPage viewNewsletterSubscribersPage;
    AddNewCartPriceRule addNewCartPriceRule;
    UpdateCartPriceRule updateCartPriceRule;
    AddNewCatalogPriceRule addNewCatalogPriceRule;

    AddNewCartPriceRuleAbide addNewCartPriceRuleAbide;
    DeleteNewsletterTemplatesPageAbide deleteNewsletterTemplatesPageAbide;


    @BeforeClass
    public void setUp(ITestContext context) {
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties", "backEndURL"));
        context.setAttribute("driver", driver);
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.adminLogin("marketingManager");
    }

    @Test(description = "mahmut")
    public void addNewCartPriceRule() {
        addNewCartPriceRule = new AddNewCartPriceRule(driver);
        addNewCartPriceRule.OpenShoppingCartPricesRules();
        addNewCartPriceRule.CreateShoppingCardRule();
        Assert.assertTrue(addNewCartPriceRule.VerifyAddNewRule());
    }

    @Test(description = "mahmut",dependsOnMethods = {"addNewCartPriceRule","UpdateCartRule"})
    public void FilterShoppingCartPricingRuleByIdAndRule()  {
        filterShoppingCartPricingRuleByIdAndRule = new FilterShoppingCartPricingRuleByIdAndRule(driver);
        filterShoppingCartPricingRuleByIdAndRule.OpenShoppingCartPricesRules();
        Assert.assertTrue(filterShoppingCartPricingRuleByIdAndRule.changeIdAndVerifyIt());
        filterShoppingCartPricingRuleByIdAndRule.resetTheFilter();
        Assert.assertTrue(filterShoppingCartPricingRuleByIdAndRule.changeRuleNameAndVerify());
    }

    @Test(description = "mahmut",dependsOnMethods = "addNewCartPriceRule")
    public void UpdateCartRule() {
        updateCartPriceRule = new UpdateCartPriceRule(driver);
        updateCartPriceRule.OpenShoppingCartPricesRules();
        updateCartPriceRule.UpdateRule();
        Assert.assertTrue(updateCartPriceRule.VerifyUpdate());
    }

    @Test(description = "Gvlmihre")
    public void addNewsletterTemplateMethod() {
//        adminLoginPage = new AdminLoginPage(driver);
//        adminLoginPage.adminLogin("marketingManager");
        addNewsletterTemplatePage = new AddNewsletterTemplatePage(driver);
        addNewsletterTemplatePage.addNewsletterTemplate();
        Assert.assertTrue(addNewsletterTemplatePage.verifyNewsletterTemplateAddedSuccessfully());
    }

    @Test(description = "Gvlmihre")
    public void updateNewsletterTemplate() {
//        adminLoginPage = new AdminLoginPage(driver);
//        adminLoginPage.adminLogin("marketingManager");
        updateNewsletterTemplatePage = new UpdateNewsletterTemplatePage(driver);
        updateNewsletterTemplatePage.updateExistingNewsletterTemplate();
        Assert.assertTrue(updateNewsletterTemplatePage.verifyTemplateUpdatedSuccessfully());
    }

    @Test(description = "Gvlmihre")
    public void deleteTemplateMethod() {
//        adminLoginPage = new AdminLoginPage(driver);
//        adminLoginPage.adminLogin("marketingManager");
        deleteNewsletterTemplatePage = new DeleteNewsletterTemplatePage(driver);
        deleteNewsletterTemplatePage.deleteTemplate();
        Assert.assertTrue(deleteNewsletterTemplatePage.verifyTemplateDeletedSuccessfully());
    }

    @Test(description = "Gvlmihre")
    public void viewNewsletterSubscribersMethod() {
//        adminLoginPage = new AdminLoginPage(driver);
//        adminLoginPage.adminLogin("marketingManager");
        viewNewsletterSubscribersPage = new ViewNewsletterSubscribersPage(driver);
        viewNewsletterSubscribersPage.viewNewsletterSubscribers();
        Assert.assertTrue(viewNewsletterSubscribersPage.verifyNewsletterSubscribersViewed());
    }
    @Test(description = "Arzugul")
    public void addNewCatalogPriceRuleTest() throws InterruptedException {
        addNewCatalogPriceRule=new AddNewCatalogPriceRule(driver);
        addNewCatalogPriceRule.addCatalogPriceRule("Team4","08/9/2022");
        Assert.assertTrue(addNewCatalogPriceRule.verifyAddNewCatalogPriceRule());

    }

    @Test(description = "delete newsletter template page--Abide")
    public void deleteNewsletterTemplatesAbide(){
        deleteNewsletterTemplatesPageAbide=new DeleteNewsletterTemplatesPageAbide(driver);
        deleteNewsletterTemplatesPageAbide.deleteNewsletterTemplates();
        Assert.assertTrue(deleteNewsletterTemplatesPageAbide.deleteNewsLetterTemplateSuccessfully());
    }


//    @AfterMethod
//    public void logout(){
//        adminLoginPage = new AdminLoginPage(driver);
//        adminLoginPage.adminLogout();
//    }

    @Test(description = "add new cart price rule--Abide")
    public void AddNewCartPriceRuleAbide(){
        addNewCartPriceRuleAbide=new AddNewCartPriceRuleAbide(driver);
        addNewCartPriceRuleAbide.addNewCartPriceRuleMethod();
        Assert.assertTrue(addNewCartPriceRuleAbide.verifyCartPriceRulesAddedSuccessfully());
    }
    @AfterClass
    public void tearDown() {
        closeBrowser();
    }


}
