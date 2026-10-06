package com.elorus.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener implements ITestListener {

    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        ExtentSparkReporter reporter =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo("Project", "Elorus Automation");
        extent.setSystemInfo("Tester", "Admin");
        extent.setSystemInfo("Environment", "QA");
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());

        test.info("Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}