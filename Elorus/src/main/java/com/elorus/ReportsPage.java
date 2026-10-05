package com.elorus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ReportsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Open Reports
    public void openReports() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space()='Reports']")))
                .click();
    }

    // Select required report
    public void selectRequiredReport() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space()='Sales detail']")))
                .click();
    }

    // Verify required report
    public boolean verifyReport() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(normalize-space(), 'Sales detail')]")))
                .isDisplayed();
    }
}