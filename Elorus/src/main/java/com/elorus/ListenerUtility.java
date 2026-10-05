package com.elorus;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerUtility implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed: " + result.getName());

        BaseTest test = (BaseTest) result.getInstance();

        WebDriver driver = test.getDriver();

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        String screenshotPath = System.getProperty("user.dir")
                + File.separator
                + "screenshots"
                + File.separator
                + result.getName()
                + "_" + timeStamp + ".png";

        try {

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File destination = new File(screenshotPath);

            destination.getParentFile().mkdirs();

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("Screenshot saved at: "
                    + screenshotPath);

        } catch (Exception e) {

            System.out.println("Screenshot failed: "
                    + e.getMessage());
        }
    }
}