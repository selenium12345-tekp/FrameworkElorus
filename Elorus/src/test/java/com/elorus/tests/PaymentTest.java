package com.elorus.tests;

import org.testng.annotations.Test;

import com.elorus.BaseTest;
import com.elorus.LoginPage;
import com.elorus.PaymentPage;

public class PaymentTest extends BaseTest {

    @Test(groups = {"system"})
    public void createSupplierRefund() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("dhanushree3107@gmail.com", "Dhanu@495");

        // Payment
        PaymentPage paymentPage = new PaymentPage(driver);

        // Open Payments
        paymentPage.openPayments();

        // Click Add
        paymentPage.clickAdd();

        // Select Supplier Refund
        paymentPage.selectSupplierRefund();

        // Select Supplier
        paymentPage.selectSupplier();

        // Enter Amount - 100
        paymentPage.enterAmount("100");

        // Click Save
        paymentPage.clickSave();

        System.out.println("Supplier refund created successfully.");
    }
}