package com.pragmatic.selenium.hrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Collections;

public class BrowserManager {


    public static void setupDrivers(String browser_type) {


        if (browser_type.isEmpty()) {
            System.exit(-1);
        }

        switch (browser_type.toLowerCase()) {
            case "chrome" :{
                WebDriverManager.chromedriver().setup();
                break;
            } case  "firefox" : {
                WebDriverManager.firefoxdriver().setup();
                break;
            } case  "edge" : {
                WebDriverManager.edgedriver().setup();
                break;
            } case  "ie" : {
                WebDriverManager.iedriver().setup();
                break;
            } case  "safari":{
                ///WebDriverManager.safari().setup();
            } case  "opera" : {
                WebDriverManager.operadriver().setup();
                break;
            } default : {
                System.exit(-1);
            }


        }



    }

    public static WebDriver launchBrowser(String browser_type) {


        WebDriver driver = null;

        switch (browser_type.toLowerCase()) {
            case "chrome" : {
                ChromeOptions options = new ChromeOptions();


                options.setExperimentalOption("useAutomationExtension", false);
                options.setExperimentalOption("excludeSwitches",
                        Collections.singletonList("enable-automation"));
                driver = new ChromeDriver(options);

            } case "chrome-headless" : {

                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                driver = new ChromeDriver(options);


            } case  "firefox" : {
                driver = new FirefoxDriver();

            } case  "firefox-headless" : {
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                driver = new FirefoxDriver(options);

            } case  "edge" :{
                driver = new EdgeDriver();

            } case  "ie" :{
                driver = new InternetExplorerDriver();

            } case  "safari" : {
                driver = new SafariDriver();

            } case  "opera": {
                driver = new OperaDriver();

            } default: {
                System.exit(-1);
            }


        }

        driver.manage().window().maximize();
        return driver;

    }


    }

