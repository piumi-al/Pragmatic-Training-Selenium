package com.pragmatic.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptsPopupExamples {


    private  WebDriver driver;

    @BeforeClass
    public void BeforeClass(){

        WebDriverManager.chromedriver().setup();

    }


    @BeforeMethod
    public void beforeMethod(){


        driver = new ChromeDriver();
        driver.get("http://demosite.pragmatictestlabs.com/Alerts.html");

        driver.manage().window().maximize();

        }



    //@AfterMethod
    //public void afterMethod() {
    //      driver.close();
    // }



    @Test
    public void testBasicAlert() {

        driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();

        //method2
        //Alert alert = driver.switchTo().alert();
        //Assert.assertEquals(alert.getText(), "This Is Simple Alert");
        //alert.accept();
        //String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        //Assert.assertEquals(confirmation, "Alert is gone.");




        //Verify the text
        String strMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(strMessage, "This Is Simple Alert");

        driver.switchTo().alert().accept();

        //Verify the message in web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation, "Alert is gone.");


    }



    @Test
    public void testConfirmAlertOK() {
        driver.findElement(By.xpath("//*[@id=\"cid_8\"]/div/div/div/button")).click();
        //Verify the text
        String strMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(strMessage, "Press a button!");

        //Click the OK/Yes button
        driver.switchTo().alert().accept();

        //Verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation, "Confirmed.");
    }


    @Test
    public void testConfirmationCancel() {
        driver.findElement(By.xpath("//*[@id=\"cid_8\"]/div/div/div/button")).click();
        //Verify the text
        String strMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(strMessage, "Press a button!");

        //Click the OK/Yes button
        driver.switchTo().alert().dismiss();

        //Verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation, "Rejected!");
    }




    @Test
    public void testTimingAlert() {

        driver.findElement(By.xpath("//*[@id=\"timingalert\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());


        //Click the OK button
        driver.switchTo().alert().accept();

        //Verify the message in  web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation, "0");


    }


    @Test
    public void testPrompt() {
        String name = "PTL";
        driver.findElement(By.xpath("//button[text()='Prompt Alert']")).click();
        //Verify the text
        String strMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(strMessage, "Please enter your name");

        //Type text
        driver.switchTo().alert().sendKeys(name);

        //Click the OK/Yes button
        driver.switchTo().alert().accept();

        //Verify the message in the web page
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation, name);
    }


}
