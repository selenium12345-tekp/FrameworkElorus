package com.elorus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoicePage {

    WebDriver driver;
    WebDriverWait wait;

    public InvoicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Click Invoice
    public void clickInvoice() {

        WebElement invoiceButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@data-tooltip-content='Invoice']")
                )
        );

        invoiceButton.click();

        // Wait for Create Invoice dialog
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'eos-modal-content')]")
                )
        );
    }

    // Invoice Time
    public void selectInvoiceTime() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//label[contains(.,'Invoice time')]")
                )
        );

        System.out.println("Invoice Time option is visible.");
    }

    // FIRST NEXT
    public void clickNext() {

        clickVisibleNextButton();

        System.out.println("First Next clicked.");
    }

    // SECOND NEXT
    public void clickNextAfterInvoiceTime() {

        clickVisibleNextButton();

        System.out.println("Second Next clicked.");
    }

    // Click the currently visible Next button
    private void clickVisibleNextButton() {

        By nextLocator = By.xpath(
                "//div[contains(@class,'eos-modal-content')]"
                + "//a[contains(@class,'btn-success') and contains(@class,'btn')]"
        );

        WebElement nextButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(nextLocator)
        );

        // Scroll to the button
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                nextButton
        );

        // Move mouse to button and click
        Actions actions = new Actions(driver);

        actions.moveToElement(nextButton)
               .pause(Duration.ofMillis(300))
               .click()
               .perform();

        // Small wait for page/modal transition
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}