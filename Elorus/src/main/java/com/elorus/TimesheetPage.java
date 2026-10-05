package com.elorus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimesheetPage {

    WebDriver driver;
    WebDriverWait wait;

    public TimesheetPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Open Time
    public void openTime() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Time']")))
                .click();

        System.out.println("Time opened.");
    }

    // Open Timesheet
    public void openTimesheet() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space()='Timesheet']")))
                .click();

        System.out.println("Timesheet opened.");
    }

    // Change Monday time from 02:00 to 03:00
    public void changeTime() {

        WebElement timeField = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@value='02:00']")
                )
        );

        timeField.click();
        timeField.clear();
        timeField.sendKeys("03:00");

        System.out.println("Time changed from 02:00 to 03:00.");
    }

    // Save
    public void clickSave() {

        WebElement save = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[contains(@class,'btn-success')" +
                                " and not(contains(@class,'disabled'))" +
                                " and normalize-space()='Save']"
                        )
                )
        );

        save.click();

        System.out.println("Timesheet saved.");
    }
}