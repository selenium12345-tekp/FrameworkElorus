package com.elorus.tests;

import org.testng.annotations.Test;

import com.elorus.BaseTest;
import com.elorus.LoginPage;
import com.elorus.SupplierPage;

public class SupplierTest extends BaseTest {

    @Test(groups = {"system"})
    public void supplierTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("dhanushree3107@gmail.com", "Dhanu@495");

        SupplierPage supplierPage = new SupplierPage(driver);

        supplierPage.openContacts();
        supplierPage.clickAdd();

        // Select Supplier
        supplierPage.createSupplier();
    }
}