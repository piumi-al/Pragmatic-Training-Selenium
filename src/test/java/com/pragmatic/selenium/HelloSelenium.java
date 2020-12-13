package com.pragmatic.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {



    public static void main(String[] args) {

        //setup the browser driver
        WebDriverManager.chromedriver().setup();


        //create an instance of the browser
        WebDriver driver = new ChromeDriver();


        //navigate to the login page
        driver.get("http://hrm.pragmatictestlabs.com/");



        //closing the browser
       // driver.close();
    }
}
