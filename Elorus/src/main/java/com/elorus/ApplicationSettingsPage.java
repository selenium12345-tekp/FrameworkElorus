package com.elorus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationSettingsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ApplicationSettingsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Open Settings
    public void openSettings() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space()='Settings']")))
                .click();

        System.out.println("Settings opened.");
    }

    // Open Application settings
    public void openApplicationSettings() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space()='Application settings']")))
                .click();

        System.out.println("Application settings opened.");
    }

    // Select Tax-inclusive, after discounts
    public void selectAmountSetting() {

        // Click the current Amounts are dropdown
        WebElement amountDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//*[normalize-space()='Tax-inclusive, after discounts']"
                        )
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                amountDropdown
        );

        amountDropdown.click();

        // Select Tax-inclusive, after discounts
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//*[normalize-space()='Tax-inclusive, after discounts']"
                        )
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                option
        );

        System.out.println("Amount setting selected.");
    }

    // Click Save
    public void clickSave() {

        WebElement save = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//*[self::a or self::button]"
                                + "[contains(normalize-space(),'Save')]"
                        )
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                save
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                save
        );

        System.out.println("Application settings saved.");
    }

    // Verify setting
    public boolean verifyAmountSetting() {

        WebElement selectedValue = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//*[normalize-space()='Tax-inclusive, after discounts']"
                        )
                )
        );

        return selectedValue.isDisplayed();
    }
}