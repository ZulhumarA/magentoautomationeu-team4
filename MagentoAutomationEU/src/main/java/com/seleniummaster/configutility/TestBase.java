package com.seleniummaster.configutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    public WebDriver driver;
    public String browserName="chrome";
    public String configFileName="config-frontend.properties";
    public String adminConfigFileName="config-backend.properties";

        public void userPageBrowserSetUp(){
            if(driver==null){
                if(browserName.equalsIgnoreCase("chrome")){
                    System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
                    driver=new ChromeDriver();
                    driver.manage().window().maximize();
                    if(configFileName.equalsIgnoreCase("config-frontend.properties"))
                    driver.get(ApplicationConfig.readFromConfigProperties(configFileName,"frontEndURL"));
                }
                else if(browserName.equalsIgnoreCase("Fire fox")){
                    System.setProperty("webdriver.gecko.driver","c:\\webdriver\\geckodriver.exe");
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    String configFileName="config-frontend.properties";
                    driver.get(ApplicationConfig.readFromConfigProperties(configFileName,"frontEndURL"));
                }
            }
        }

    public void adminPageBrowserSetUp(){
        if(driver==null){
            if(browserName.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                if(adminConfigFileName.equalsIgnoreCase("config-backend.properties"))
                    driver.get(ApplicationConfig.readFromConfigProperties(adminConfigFileName,"backEndURL"));
            }
            else if(browserName.equalsIgnoreCase("Fire fox")){
                System.setProperty("webdriver.gecko.driver","c:\\webdriver\\geckodriver.exe");
                driver=new FirefoxDriver();
                driver.manage().window().maximize();
                String configFileName="config-frontend.properties";
                driver.get(ApplicationConfig.readFromConfigProperties(configFileName,"frontEndURL"));
            }
        }
    }
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }

    //static wait
    public static void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

