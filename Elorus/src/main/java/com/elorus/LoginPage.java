package com.elorus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    WebActionUtil actionUtil;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;

    @FindBy(css = "input[type='submit']")
    WebElement loginButton;

    // User menu
    @FindBy(css = "a[title='User menu']")
    WebElement profileMenu;

    // Logout
    @FindBy(xpath = "//*[normalize-space()='Logout']")
    WebElement logoutButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.actionUtil = new WebActionUtil(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        actionUtil.click(emailField);
        actionUtil.enterText(emailField, email);
    }

    public void enterPassword(String password) {
        actionUtil.click(passwordField);
        actionUtil.enterText(passwordField, password);
    }

    public void clickLogin() {
        actionUtil.click(loginButton);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public void logout() {
        actionUtil.click(profileMenu);
        actionUtil.click(logoutButton);
    }
}