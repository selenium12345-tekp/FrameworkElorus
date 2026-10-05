package com.elorus;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public WebDriver driver;
    public Properties prop;

    @BeforeClass
    public void setPath() {

        try {
            FileInputStream f = new FileInputStream(
                    System.getProperty("user.dir")
                            + "\\src\\test\\resources\\config.properties");

            prop = new Properties();
            prop.load(f);
            f.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameters("BrowserName")
    @BeforeMethod
    public void launchBrowser(@Optional("Chrome") String bn) {

        if (bn.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (bn.equalsIgnoreCase("Firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (bn.equalsIgnoreCase("Edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else {

            throw new IllegalArgumentException(
                    "Invalid browser: " + bn);
        }

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();

        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}