package com.utills;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Setup implements ITestListener {
    private static ExtentReports extentReport;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    @Override
    public void onStart(ITestContext context) {
        extentReport =  ExtentReportManager.createInstance(ExtentReportManager.getReportNameWithTimeStamp(),"TestApiAutomaction","Api Testing");

    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReport!=null){
            extentReport.flush();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReport.createTest("TestName" +result.getTestClass().getTestName()+" - "+result.getMethod().getMethodName());
        extentTest.set(test);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        // not implemented
    }
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.logFailDetails(result.getThrowable().getMessage());
        ExtentReportManager.logStacktrace(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // not implemented
    }



}
