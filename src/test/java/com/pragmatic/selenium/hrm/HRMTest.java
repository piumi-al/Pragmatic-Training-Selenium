package com.pragmatic.selenium.hrm;

import org.testng.annotations.DataProvider;

public class HRMTest {


    @DataProvider(name = "user-credentials")
    public static Object[][] userCredentials() {
        return new Object[][]{
                {"Admin", "", "Password cannot be empty"},
                {"Admin", "PTEst", "Invalid credentials"},
                {"", "", "Username cannot be empty"},
                {"", "Ptl@#321", "Username cannot be empty"}

        };

    }

}