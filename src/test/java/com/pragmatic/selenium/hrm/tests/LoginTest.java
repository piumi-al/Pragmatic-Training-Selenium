package com.pragmatic.selenium.hrm.tests;

import com.pragmatic.selenium.hrm.HRMConstant;
import com.pragmatic.selenium.hrm.pages.LandingPage;
import com.pragmatic.selenium.hrm.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {


    private static LoginTest HRMConstants;
    private static final String BASE_URL = HRMConstant.BASE_URL;
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }


    @AfterMethod
    public void afterMethod() {
        driver.close();
    }


    @Test
    public void testValidUserLogin(){

        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.typeUserName("Admin")
                .typePassword("Ptl@#321")
                .clickLogin();

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.getWelcomeMessage(), "Welcome Admin");

    }



    @Test
    public void testLoginWithBlankUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.typeUserName("")
                .typePassword("")
                .clickLogin();

        Assert.assertEquals(loginPage.Error(), "Username cannot be empty");
    }


    @Test
    public void testLoginWithBlankUsername() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.typeUserName("")
                .typePassword("PTL@#321")
                .clickLogin();

        Assert.assertEquals(loginPage.Error(), "Username cannot be empty");
    }
}
