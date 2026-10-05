package com.elorus.tests;

import org.testng.annotations.Test;

import com.elorus.BaseTest;
import com.elorus.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginLogoutTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("dhanushree3107@gmail.com", "Dhanu@495");

        loginPage.logout();
    }
}