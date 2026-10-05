package com.elorus.tests;

import org.testng.annotations.Test;

import com.elorus.BaseTest;
import com.elorus.ExpensePage;
import com.elorus.LoginPage;

public class ExpenseTest extends BaseTest {

    @Test(groups = {"integration"})
    public void createExpenseTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "dhanushree3107@gmail.com",
                "Dhanu@495"
        );

        ExpensePage expensePage = new ExpensePage(driver);

        expensePage.openExpensePage();

        // Date is already filled automatically
        // Only Category and Amount
        expensePage.createExpense("500");
    }
}