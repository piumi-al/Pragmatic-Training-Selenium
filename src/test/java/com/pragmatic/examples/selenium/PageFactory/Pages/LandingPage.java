package com.pragmatic.examples.selenium.PageFactory.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private WebDriver driver;

    @FindBy(id = "welcome")
    WebElement lnkWelcome;


    public LandingPage(WebDriver driver) {
        this.driver = driver;

        //magic code
        PageFactory.initElements(this.driver, this);
    }


    public String getWelcomeMsg() {
        String welcomeMessage = lnkWelcome.getText();
        return welcomeMessage;
    }
}
