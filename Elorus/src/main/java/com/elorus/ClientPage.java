package com.elorus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientPage {

    WebDriver driver;
    WebDriverWait wait;

    public ClientPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Open Contacts
    public void openContacts() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Contacts']")))
                .click();
    }

    // Click Add
    public void clickAdd() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/contacts/add/')]")))
                .click();
    }

    // Create Client
    public void createClient() {

        // Enter First Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='first_name']")))
                .sendKeys("Automation");

        // Enter Last Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='last_name']")))
                .sendKeys("Client");

        // Enter Company
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='company']")))
                .sendKeys("Automation Test Company");

        // Save
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class,'btn-success') and .//span[normalize-space()='Save']] | " +
                         "//button[normalize-space()='Save']")))
                .click();
    }
}