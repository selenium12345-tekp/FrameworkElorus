package com.elorus.tests;

import org.testng.annotations.Test;

import com.elorus.BaseTest;
import com.elorus.InvoicePage;
import com.elorus.LoginPage;
import com.elorus.ProjectPage;

public class InvoiceTest extends BaseTest {

    @Test(groups = {"integration"})
    public void createInvoice() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "dhanushree3107@gmail.com",
                "Dhanu@495"
        );

        // Open Projects
        ProjectPage projectPage = new ProjectPage(driver);

        projectPage.openProjects();
        projectPage.openRequiredProject();

        // Invoice
        InvoicePage invoicePage = new InvoicePage(driver);

        invoicePage.clickInvoice();

        // Invoice Time
        invoicePage.selectInvoiceTime();

        // First Next
        invoicePage.clickNext();

        // Second Next
        invoicePage.clickNextAfterInvoiceTime();
    }
}