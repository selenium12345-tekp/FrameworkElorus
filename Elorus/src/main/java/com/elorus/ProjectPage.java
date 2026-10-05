package com.elorus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Open Projects
    public void openProjects() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Projects']")))
                .click();
    }

    // Open required project
    public void openRequiredProject() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Automation_Project_1791017283506']")))
                .click();
    }

    // Click Add
    public void clickAdd() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/projects/add/')]")))
                .click();
    }

    // Create Project - mandatory fields only
    public void createProject() {

        // Project Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("name")))
                .sendKeys("Automation_Project_" + System.currentTimeMillis());

        // Client dropdown
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'Select-placeholder') and normalize-space()='Select...']")))
                .click();

        // Select existing client
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space()='Aishwarya - Tekp']")))
                .click();

        // Client portal, Billing method and Hourly rate
        // already have default values

        // Save
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class,'btn-success') and .//span[normalize-space()='Save']] | " +
                         "//button[normalize-space()='Save']")))
                .click();
    }
}