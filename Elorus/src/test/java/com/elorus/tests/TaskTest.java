package com.elorus.tests;

import org.testng.annotations.Test;

import com.elorus.BaseTest;
import com.elorus.LoginPage;
import com.elorus.TaskPage;

public class TaskTest extends BaseTest {

    @Test
    public void taskTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("dhanushree3107@gmail.com", "Dhanu@495");

        // Open project
        TaskPage taskPage = new TaskPage(driver);

        taskPage.openProjects();
        taskPage.openProject();

        // Add task
        taskPage.clickEdit();
        taskPage.addTask();
    }
}