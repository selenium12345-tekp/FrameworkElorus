package com.elorus.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.elorus.ApplicationSettingsPage;
import com.elorus.BaseTest;
import com.elorus.LoginPage;

public class ApplicationSettingsTest extends BaseTest {

    @Test(groups = {"integration"})
    public void updateApplicationSettings() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "dhanushree3107@gmail.com",
                "Dhanu@495"
        );

        // Application Settings
        ApplicationSettingsPage settingsPage =
                new ApplicationSettingsPage(driver);

        settingsPage.openSettings();

        settingsPage.openApplicationSettings();

        settingsPage.selectAmountSetting();

        settingsPage.clickSave();

        Assert.assertTrue(
                settingsPage.verifyAmountSetting(),
                "Application setting was not updated"
        );

        System.out.println(
                "Application setting updated and verified successfully."
        );
    }
}