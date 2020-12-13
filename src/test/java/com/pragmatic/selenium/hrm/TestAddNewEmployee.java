package com.pragmatic.selenium.hrm;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestAddNewEmployee {

    private static final By TXT_USERNAME =By.id("txtUsername") ;
    private static final By TXT_PASSWORD = By.id("txtPassword");
    private static final By BTN_LOGIN = By.id("btnLogin");
    private static final By MNU_PIM= By.id("menu_pim_viewPimModule");
    private static final By MNU_ADD_EMPLOYEE= By.id("menu_pim_addEmployee");
    private static final By TXT_FIRSTNAME= By.id("firstName");
    private static final By TXT_LASTNAME= By.id("lastName");
    private static final By TXT_EMP_ID= By.id("employeeId");
    private static final By PROFILE = By.id("photofile");
    private static final By BTN_SAVE = By.id("btnSave");
    private static final By CHK_LOGIN = By.id("chkLogin");
    private static final By TXT_LOGIN_USERNAME = By.id("user_name");
    private static final By TXT_LOGIN_PASSWORD = By.id("user_password");
    private static final By TXT_LOGIN_PASSWORD_CONFIRM = By.id("re_password");
    private WebDriver driver;
    private Faker faker;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    private WebDriver beforeMethod(){

        driver = new ChromeDriver();

        driver.get("http://hrm.pragmatictestlabs.com/");


        Login();
        navigateToAddEmployeePage();

        return  driver;
    }

    @AfterMethod
    public void afterMethod(){

       // driver.close();

    }


    private void Login(){

        driver.findElement(TXT_USERNAME).sendKeys("Admin");
        driver.findElement(TXT_PASSWORD).sendKeys("Ptl@#321");
        driver.findElement(BTN_LOGIN).click();

    }


    private void navigateToAddEmployeePage(){


        //Click the PIM menu
        driver.findElement(MNU_PIM).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        //Click the Add Employee menu
        wait.until(ExpectedConditions.elementToBeClickable(MNU_ADD_EMPLOYEE)).click();

    }


    @Test
    public void testAddNewEmployeeWithProfileImage() {

        driver.findElement(TXT_FIRSTNAME).sendKeys("Janesh");
        driver.findElement(TXT_LASTNAME).sendKeys("Chandika");

        //give image path
        //driver.findElement(PROFILE).sendKeys("");

        driver.findElement(BTN_SAVE).click();

    }


    @Test
    public void testAddNewEmployeeWithLoginDetailsDisabled() {

        String firstName = faker.name().firstName();
        String lastName =  faker.name().lastName();
        String username = String.format("%s.%s", firstName, lastName);

        driver.findElement(TXT_FIRSTNAME).sendKeys("Janesh");
        driver.findElement(TXT_LASTNAME).sendKeys("Chandika");

        driver.findElement(BTN_SAVE).click();

    }








}
