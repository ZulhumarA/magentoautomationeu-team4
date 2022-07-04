package regression.uitest.testngframework;

import com.seleniummaster.configutility.AdminLoginPage;
import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerModuleRunner extends TestBase {


    @BeforeClass
    public void setUp(ITestContext context){
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties","backEndURL"));
        context.setAttribute("driver",driver);
    }

    @Test
    public void customerManagerLogin(){
        AdminLoginPage adminLoginPage=new AdminLoginPage(driver);
        adminLoginPage.adminLogin("customerManager");
    }





}
