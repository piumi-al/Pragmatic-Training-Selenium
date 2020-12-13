package com.pragmatic.selenium.hrm;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUserLogin {

    private WebDriver driver;



    @BeforeClass
    public static void BeforeClass(){
        WebDriverManager.chromedriver().setup();
    }




    @BeforeMethod
    private WebDriver beforeMethod(){

        driver = new ChromeDriver();

        driver.get("http://hrm.pragmatictestlabs.com/");
        return  driver;
    }




    @AfterMethod
    public  void afterMethod(){
        driver.close();
    }



    @Test
    public void testValidUserLogin(){

        WebDriver driver = beforeMethod();

        //type the username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //type the password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");


        //click the login button
        driver.findElement(By.id("btnLogin")).click();



        //get the welcome message
        String welcomeMsg = driver.findElement(By.id("welcome")).getText();

        Assert.assertEquals(welcomeMsg, "Welcome Admin");




    }


    @Test
    public void testValidUserLoginWithEnterValidPasswordFeild(){

        WebDriver driver = beforeMethod();

        //type the username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //type the password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321"+ Keys.ENTER);


        //get the welcome message
        String welcomeMsg = driver.findElement(By.id("welcome")).getText();

        Assert.assertEquals(welcomeMsg, "Welcome Admin");




    }


    @Test
    public void testValidUserLoginWithFormSubmit(){

        WebDriver driver = beforeMethod();

        //type the username
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //type the password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321"+ Keys.ENTER);
        //driver.findElement(By.id("txtPassword")).submit();


        //get the welcome message
        String welcomeMsg = driver.findElement(By.id("welcome")).getText();

        Assert.assertEquals(welcomeMsg, "Welcome Admin");




    }


    @Test
    public void testValidUserLoginWithBlankUsernameAndPassword(){

        WebDriver driver = beforeMethod();

        //type the username
        driver.findElement(By.id("txtUsername")).sendKeys("");

        //type the password
        driver.findElement(By.id("txtPassword")).sendKeys("");
        driver.findElement(By.id("txtPassword")).submit();


        //click the login button
        //driver.findElement(By.id("btnLogin")).click();




        //verify the error message
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Username cannot be empty");

    }


      @Test
      public void testValidUserLoginWithBlankUsername(){

        WebDriver driver = beforeMethod();

        //type the username
        driver.findElement(By.id("txtUsername")).sendKeys("");

        //type the password
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("txtPassword")).submit();


        //click the login button
        //driver.findElement(By.id("btnLogin")).click();




        //verify the error message
        Assert.assertEquals(driver.findElement(By.id("spanMessage")).getText(), "Username cannot be empty");

    }














}
