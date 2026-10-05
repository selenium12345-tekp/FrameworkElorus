package com.elorus.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.elorus.BaseTest;
import com.elorus.LoginPage;
import com.elorus.ReportsPage;

public class ReportsTest extends BaseTest {

    @Test(groups = {"system"})
    public void verifyRequiredReport() {

        // Login to Elorus
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "dhanushree3107@gmail.com",
                "Dhanu@495"
        );

        // Open Reports
        ReportsPage reportsPage = new ReportsPage(driver);

        reportsPage.openReports();

        // Select required report
        reportsPage.selectRequiredReport();

        // Verify report
        Assert.assertTrue(
                reportsPage.verifyReport(),
                "Required report is not displayed"
        );
    }
}