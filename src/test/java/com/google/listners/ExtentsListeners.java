package com.google.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utills.ExtentReportManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utills.BaseClass;

import java.util.Arrays;

public class ExtentsListeners implements ITestListener {
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
