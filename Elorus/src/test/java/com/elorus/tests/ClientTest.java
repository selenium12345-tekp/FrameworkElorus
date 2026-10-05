package com.elorus.tests;

import org.testng.annotations.Test;

import com.elorus.BaseTest;
import com.elorus.ClientPage;
import com.elorus.LoginPage;

public class ClientTest extends BaseTest {

    @Test
    public void clientTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("dhanushree3107@gmail.com", "Dhanu@495");

        // Open Contacts
        ClientPage clientPage = new ClientPage(driver);

        clientPage.openContacts();

        // Click Add
        clientPage.clickAdd();

        // Create Client
        clientPage.createClient();
    }
}