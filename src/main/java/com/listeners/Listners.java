package com.listeners;

import com.reports.ExtentReports;
import org.testng.*;

public class Listners implements ITestListener, ISuiteListener {

//    @Override
//    public void onFinish(ITestContext context) {
//        ITestListener.super.onFinish(context);
//    }

    @Override
    public void onTestStart(ITestResult result) {
        String method = result.getMethod().getConstructorOrMethod().getMethod().toString();
        ExtentReports.createTest(method);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logResult(result, "pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logResult(result, "fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logResult(result, "skip");

    }

    @Override
    public void onStart(ISuite suite) {
        ExtentReports.initialize();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReports.flushReports();
    }

    private void logResult(ITestResult result, String status) {
        String logoutput = Reporter.getOutput(result).stream().filter(output -> output.contains("{") && output.contains("}")).findFirst().orElse(String.valueOf(result.getThrowable()));
        if (status.equals("pass")) {
            ExtentReports.onTestPass(logoutput);
        } else if (status.equals("fail")) {
            ExtentReports.onTestFailure(logoutput);
        } else if (status.equals("skip")) {
            ExtentReports.onTestSkip(logoutput);
        }
    }

}
