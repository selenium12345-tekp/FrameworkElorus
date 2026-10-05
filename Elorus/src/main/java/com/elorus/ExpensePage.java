package com.elorus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpensePage {

    WebDriver driver;
    WebDriverWait wait;

    public ExpensePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // CATEGORY
    private By categoryDropdown = By.xpath(
            "//input[@name='expense_category']/following-sibling::div[contains(@class,'Select-control')]"
    );

    // CATEGORY OPTIONS
    private By categoryOption = By.xpath(
            "//div[contains(@class,'Select-menu-outer')]//div[contains(@class,'Select-option')][1]"
    );

    // AMOUNT
    private By amountField = By.xpath(
            "//label[contains(normalize-space(),'Amount')]/following::input[not(@type='hidden')][1]"
    );

    // Open Expense page
    public void openExpensePage() {

        driver.get("https://qsp-314.elorus.com/expenses/add/");

        wait.until(
                ExpectedConditions.urlContains("/expenses/add")
        );

        System.out.println("Expense Add page opened successfully.");
    }

    // Select Category
    public void selectCategory() {

        WebElement category = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        categoryDropdown
                )
        );

        scrollToElement(category);

        // JavaScript click because React Select can block normal click
        javascriptClick(category);

        System.out.println("Category dropdown clicked.");

        WebElement option = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        categoryOption
                )
        );

        scrollToElement(option);

        javascriptClick(option);

        System.out.println("Category selected successfully.");
    }

    // Enter Amount
    public void enterAmount(String amount) {

        WebElement amountElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        amountField
                )
        );

        scrollToElement(amountElement);

        amountElement.click();
        amountElement.clear();
        amountElement.sendKeys(amount);

        System.out.println("Amount entered: " + amount);
    }

    // Complete Expense
    public void createExpense(String amount) {

        // Date is already automatically entered.
        // DO NOT TOUCH DATE.

        selectCategory();

        enterAmount(amount);

        System.out.println(
                "Category and Amount entered successfully."
        );
    }

    // Scroll
    private void scrollToElement(WebElement element) {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );
    }

    // JavaScript click
    private void javascriptClick(WebElement element) {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                element
        );
    }
}