package com.seleniummaster.configutility;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.apache.commons.lang3.RandomStringUtils;
import com.google.gson.Gson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class TestUtility {

    private WebDriver driver;

    private int timeout = Integer.parseInt(ApplicationConfig.readFromConfigProperties(
            "config.properties", "timeout"
    ));

    Faker faker = new Faker();

    public TestUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public String generateFirstName() {
        String firstName = faker.name().firstName();
        return firstName;
    }

    public String generateTitle(){
        String title=faker.name().title();
        return title;
    }

    public String generateLastName() {
        String lastName = faker.name().lastName();
        return lastName;
    }

    public String generateCity() {
        String city = faker.address().city();
        return city;
    }

    public String generateZip() {
        String zip = faker.address().zipCode();
        return zip;
    }
    //Zulhumar's Fakes

    public String fakeCategoryName() {
        String categoryName = faker.name().name();
        return categoryName;
    }

    public String fakePageTitle() {
        String title = faker.name().title();
        return title;
    }

    public String metaKeywords() {
            String metaKeyword = faker.commerce().productName();
            return metaKeyword;
        }

    public String metaDescriptions() {
        String metaDescription = faker.commerce().productName();
        return metaDescription;
    }

    public String generateAdminName(){
        String admin=faker.name().name();
        return admin;
    }

    public String  generateRandomLetter() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        System.out.println(generatedString.toLowerCase());
        return generatedString.toLowerCase();
    }

    public String generatePassword(){
        long length=8;
        String generateLong= RandomStringUtils.randomNumeric((int) length);
        return generateLong;
    }
    public String generateGroupName() {
        String groupName = faker.name().name();
        return groupName;
    }
      //Zulhumar's finished.

    public String fakeEmail() {
        String email = faker.internet().emailAddress();
        return email;
    }

    public String fakeName(){
        String name=faker.name().name();
        return name;
    }

    public String  generateRandomStoreCode() {
        int length = 6;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        System.out.println(generatedString.toLowerCase());
        return generatedString.toLowerCase();
    }

    public void waitForAlertPresent(){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void selectValueFromDropDown(WebElement webelement, String value) {
        Select s = new Select(webelement);
        s.selectByValue(value);
    }

    public void selectValueFromDropDown(WebElement webelement, int index) {
        Select s = new Select(webelement);
        s.selectByIndex(index);
    }

    public int generateRandomNumbers(int max, int min){
        return ((int)(Math.random() * max) + min);
    }

    public String generateRandomSentence() {
        return faker.lorem().sentence();
    }


    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100);

    }

    public String generateRandomNumbers(){
        String randomNumber= String.valueOf(faker.number().numberBetween(20,500));
        return randomNumber;
    }

    public void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String fakeCartPriceRulesName(){
     String fakeRuleNames=faker.business().creditCardType().toUpperCase();
     return  fakeRuleNames;
    }

    public String generateStreetName(){
        String StreetName=faker.address().streetName();
        return StreetName;
    }

    public String generateTelephoneNumber(){
       String phoneNUmber= String.valueOf(faker.number().numberBetween(400000000,500000000));
       return phoneNUmber;
    }

    public String productName(){
        String productName=faker.commerce().productName();
        return productName;
    }

}


