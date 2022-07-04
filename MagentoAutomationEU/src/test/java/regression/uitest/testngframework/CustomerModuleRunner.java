package regression.uitest.testngframework;

import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.configutility.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerModuleRunner extends TestBase {

    @Test
    public void setUp(){
        browserSetUp(ApplicationConfig.readFromConfigProperties("config.properties","backEndURL"));


    }


}
