package regression.uitest.testngframework;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import com.seleniummaster.ui.backend.reportingmodule.ProductsLowStockReportPage;
import com.seleniummaster.ui.backend.reportingmodule.ProductsMostViewedReportPage;
import com.seleniummaster.ui.backend.reportingmodule.ProductsOrderedReportPage;
import com.seleniummaster.ui.backend.reportingmodule.SeeCustomersNewAccountReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReportingModuleRunner extends TestBase {

    AdminLoginPage adminLoginPage;
    ProductsOrderedReportPage productsOrderedReportPage;
    ProductsMostViewedReportPage productsMostViewedReportPage;
    ProductsLowStockReportPage productsLowStockReportPage;

    @BeforeClass
    public void setUp(ITestContext context){
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties","backEndURL"));
        context.setAttribute("driver",driver);
    }
@Test(description = "Zulhumar")
public void SeeCustomerNewAccountReport()throws InterruptedException{
    adminLoginPage=new AdminLoginPage(driver);
    adminLoginPage.adminLogin("reportingManager");
    SeeCustomersNewAccountReport seeCustomersNewAccountReport=new SeeCustomersNewAccountReport(driver);
    seeCustomersNewAccountReport.OpenCustomersNewAccountReportPage();
    seeCustomersNewAccountReport.ShowNewAccountReportMethod(
            ApplicationConfig.readFromConfigProperties(
                   "config.properties","startDate"),
          ApplicationConfig.readFromConfigProperties(
                   "config.properties","endDate"));
    Assert.assertTrue(seeCustomersNewAccountReport.verifyReportsDisplayed());
                 }
//    @Test(description = "Zulhumar")
//    public void SeeCustomerByOrderTotalReport (){
//        adminLoginPage=new AdminLoginPage(driver);
//        adminLoginPage.adminLogin("reportingManager");
//        SeeCustomerByOrdersTotalReport seeCustomerByOrdersTotalReport=new SeeCustomerByOrdersTotalReport(driver);
//        seeCustomerByOrdersTotalReport.OpenCustomerByOrdersTotalReportPage();
//    }

    @Test(description = "Gvlmihre")
    public void viewProductsOrderedReportMethod(){
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        productsOrderedReportPage=new ProductsOrderedReportPage(driver);
        productsOrderedReportPage.viewProductsOrderedReport("01/01/2020","01/01/2022");
        Assert.assertTrue(productsOrderedReportPage.verifyProductsOrderedReportDisplayed());
    }

    @Test(description = "Gvlmihre")
    public void viewProductsMostViewedReportMethod(){
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        productsMostViewedReportPage=new ProductsMostViewedReportPage(driver);
        productsMostViewedReportPage.viewProductsMostViewedReport("1/1/2020","1/1/2022");
        Assert.assertTrue(productsMostViewedReportPage.verifyProductsMostViewedReportDisplayed());
    }

    @Test(description = "Gvlmihre")
    public void viewProductsLowStockReportMethod(){
        adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("reportingManager");
        productsLowStockReportPage=new ProductsLowStockReportPage(driver);
        productsLowStockReportPage.viewProductsLowStockReport();
        Assert.assertTrue(productsLowStockReportPage.verifyProductsLowStockReportDisplayed());


    }


    @AfterClass
    public void tearDown() {
        closeBrowser();
    }



}


