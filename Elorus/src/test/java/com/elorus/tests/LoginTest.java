package com.elorus.tests;

import org.testng.annotations.Test;

import com.elorus.BaseTest;
import com.elorus.LoginPage;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void loginLogoutTest() {

        LoginPage loginPage = new LoginPage(driver);

        // Login
        loginPage.login("dhanushree3107@gmail.com", "Dhanu@495");

        // Logout
        loginPage.logout();
    }
}