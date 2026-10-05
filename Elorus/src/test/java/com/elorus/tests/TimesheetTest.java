package com.elorus.tests;

import org.testng.annotations.Test;

import com.elorus.BaseTest;
import com.elorus.LoginPage;
import com.elorus.TimesheetPage;

public class TimesheetTest extends BaseTest {

    @Test(groups = {"system"})
    public void timesheetTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "dhanushree3107@gmail.com",
                "Dhanu@495"
        );

        // Time / Timesheet
        TimesheetPage timesheetPage =
                new TimesheetPage(driver);

        timesheetPage.openTime();

        timesheetPage.openTimesheet();

        timesheetPage.clickSave();
    }
}