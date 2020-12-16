package com.pragmatic.selenium.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

private WebDriver driver;



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage typeUserName(String userName){
       driver.findElement(By.id("txtUsername")).sendKeys(userName);
        return this;

    }


    public LoginPage typePassword(String password){
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        return this;

    }


    public void clickLogin(){
        driver.findElement(By.id("btnLogin")).click();
    }


    public String Error(){

      String msg;
      msg = driver.findElement(By.id("spanMessage")).getText();
      return  msg;


    }


}
