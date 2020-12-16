package com.pragmatic.selenium.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private  WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeMessage() {
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        return welcomeMessage;
    }
}
