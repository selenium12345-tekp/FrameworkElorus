package com.elorus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskPage {

    WebDriver driver;
    WebDriverWait wait;

    public TaskPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Open Projects
    public void openProjects() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Projects']")))
                .click();
    }

    // Open Automation Project
    public void openProject() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(normalize-space(),'Automation_Project_')]")))
                .click();
    }

    // Click Edit
    public void clickEdit() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/projects/') and contains(@href,'/edit/')]")))
                .click();
    }

    // Add Task
    public void addTask() {

        // Click Add new under Tasks
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class,'btn') and contains(normalize-space(.),'Add new')] | "
                       + "//button[contains(normalize-space(.),'Add new')]")))
                .click();

        // Enter Task Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Name...']")))
                .sendKeys("Automation_Task_" + System.currentTimeMillis());

        // Description is optional

        // Save
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class,'btn-success') and .//span[normalize-space()='Save']] | "
                       + "//button[normalize-space()='Save']")))
                .click();
    }
}