package com.seleniummaster.configutility;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public String browserName="chrome";
    public String configFileName="config.properties";


        public void browserSetUp(String url){
            //define the operating system
            String osName = System.getProperty("os.name").toLowerCase().substring(0, 3);
            //define the driver
            if(driver==null){
                if(browserName.equalsIgnoreCase("chrome")) {
                    if (osName.equalsIgnoreCase("win")) {
                        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();

                    } else if (osName.equalsIgnoreCase("mac")) {
                        System.setProperty("webdriver.chrome.driver", "/Users/apple/Documents/JavaWebDriver/chromedriver");
                        //System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                    }

                }else if(browserName.equalsIgnoreCase("Fire fox")){
                    if (osName.equalsIgnoreCase("win")) {
                        System.setProperty("webdriver.gecko.driver","c:\\webdriver\\geckodriver.exe");
                        driver=new FirefoxDriver();;
                        driver.manage().window().maximize();

                    } else if (osName.equalsIgnoreCase("mac")) {
                        System.setProperty("webdriver.gecko.driver", "/Users/apple/Documents/JavaWebDriver/geckodriver");
                        //System.setProperty("webdriver.gecko.driver", "webDrivers/geckodriver");
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                    }
                }
            }
                else if(browserName.equalsIgnoreCase("Fire fox")){
                    System.setProperty("webdriver.gecko.driver","c:\\webdriver\\geckodriver.exe");
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.get(ApplicationConfig.readFromConfigProperties(configFileName,"frontEndURL"));
                }
            assert driver != null;
            driver.get(url);
            }

    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}

