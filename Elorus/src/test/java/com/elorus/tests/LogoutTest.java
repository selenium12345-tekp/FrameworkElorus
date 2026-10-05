package com.elorus.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.elorus.BaseTest;
import com.elorus.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("dhanushree3107@gmail.com", "Dhanu@495");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Click user name / profile dropdown
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space()='dhanu']")
        )).click();

        // Click Logout
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space()='Logout']")
        )).click();
    }
}