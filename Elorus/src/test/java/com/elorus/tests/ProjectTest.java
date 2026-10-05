package com.elorus.tests;

import org.testng.annotations.Test;

import com.elorus.BaseTest;
import com.elorus.LoginPage;
import com.elorus.ProjectPage;

public class ProjectTest extends BaseTest {

    @Test(groups = {"system"})
    public void projectTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("dhanushree3107@gmail.com", "Dhanu@495");

        // Open Projects
        ProjectPage projectPage = new ProjectPage(driver);

        projectPage.openProjects();
        projectPage.clickAdd();

        // Create Project
        projectPage.createProject();
    }
}