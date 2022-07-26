package regression.databasetest;

import com.seleniummaster.database.databaseUtility.DatabaseMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataBaseTestRunner {

    DatabaseMethods databaseMethods=new DatabaseMethods();

    @BeforeClass
    public void setUp(){
        databaseMethods.databaseConnectionSetUp();
    }


    @Test
    public void tearDown(){
        databaseMethods.closeDatabaseConnection();
    }



}
