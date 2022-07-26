package regression.databasetest;

import com.seleniummaster.database.DatabaseMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;

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
