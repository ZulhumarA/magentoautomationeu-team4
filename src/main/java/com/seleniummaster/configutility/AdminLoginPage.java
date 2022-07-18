package com.seleniummaster.configutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage extends TestBase {

     TestUtility testUtility;

     WebDriver driver;

     @FindBy(id="username")
     WebElement userNameField;

     @FindBy(id="login")
     WebElement passwordField;

     @FindBy(xpath = "//*[@value=\"Login\"]")
     WebElement loginButton;

     @FindBy(css="a[class=\"link-logout\"]")
     WebElement LogoutButton;

     public AdminLoginPage(WebDriver driver) {
          this.driver = driver;
          PageFactory.initElements(driver,this);
          testUtility=new TestUtility(driver);
     }

     public void adminLogin(String userName){
          userNameField.sendKeys(ApplicationConfig.readFromConfigProperties("config.properties",userName));
          passwordField.sendKeys(ApplicationConfig.readFromConfigProperties("config.properties","backEndPassword"));
          loginButton.click();
     }

     public void adminLogout(){
          LogoutButton.click();
     }


}
