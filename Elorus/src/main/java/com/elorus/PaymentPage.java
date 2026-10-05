package com.elorus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    WebDriver driver;
    WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Open Payments received
    public void openPayments() {

        WebElement payments = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(normalize-space(),'Payments received')]")
                )
        );

        payments.click();

        System.out.println("Payments received opened.");
    }

    // Click Add
    public void clickAdd() {

        WebElement add = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@data-tooltip-content='Add']")
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", add);

        System.out.println("Add clicked.");
    }

    // Select Supplier refund
    public void selectSupplierRefund() {

        WebElement supplierRefund = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//a[normalize-space()='Supplier refund']")
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", supplierRefund);

        System.out.println("Supplier refund selected.");
    }

    // Select supplier
    public void selectSupplier() {

        // Click From -> Select...
        WebElement selectBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(text(),'Select...')]")
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                selectBox
        );

        selectBox.click();

        System.out.println("From dropdown clicked.");

        // Select amith - Test yantra
        WebElement supplier = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//*[normalize-space()='amith - Test yantra']"
                        )
                )
        );

        supplier.click();

        System.out.println("amith - Test yantra selected.");
    }

 // Enter amount
    public void enterAmount(String amount) {

        WebElement amountField = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[@type='text' and @value='0.00']")
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                amountField
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = ''; " +
                "arguments[0].value = arguments[1]; " +
                "arguments[0].dispatchEvent(new Event('input', {bubbles:true})); " +
                "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
                amountField,
                amount
        );

        System.out.println("Amount entered: " + amount);
    }
    // Click Save
    public void clickSave() {

        WebElement save = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[contains(@class,'btn-success')]" +
                                "[.//span[normalize-space()='Save']]"
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

        System.out.println("Save clicked.");
    }
}