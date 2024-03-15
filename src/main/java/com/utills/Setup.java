package com.utills;

import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Setup implements ITestListener {
    private static ExtentReports extentReport;
    @Override
    public void onStart(ITestContext context) {
        extentReport =  ExtentReportManager.createInstance(ExtentReportManager.getReportNameWithTimeStamp(),"TestApiAutomaction","Api Testing")

    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReport!=null){
            extentReport.flush();
        }
    }
}
