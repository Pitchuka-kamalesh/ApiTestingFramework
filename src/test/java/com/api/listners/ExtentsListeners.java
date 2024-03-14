package com.api.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utills.BaseClass;

public class ExtentsListeners implements ITestListener {
    private ExtentReports extent;
    private ExtentTest test;
    public static Logger logger;


    @Override
    public void onStart(ITestContext context) {
        String reportPath = "reports/extent/report.html";
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger = Logger.getLogger(result.getClass());
        test = extent.createTest(result.getMethod().getMethodName());
        logger.info(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
    }



}
