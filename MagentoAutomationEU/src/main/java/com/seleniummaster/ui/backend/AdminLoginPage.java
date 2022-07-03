package com.seleniummaster.ui.backend;

import com.seleniummaster.configutility.TestBase;
import com.seleniummaster.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage extends TestBase {

     TestUtility testUtility;

     WebDriver driver;

     @FindBy(id="username")
     WebElement userNameField;

     @FindBy(id="login")
     WebElement passwordField;

     @FindBy(xpath = "//*[@value=\"Login\"]")
     WebElement loginButton;

     public static void adminLogin(String userName,String password){



     }
}
