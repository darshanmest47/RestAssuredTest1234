package com.listeners;

import com.frameworkanntations.FrameWorkAnnotations;
import com.reports.ExtentReports;
import org.testng.*;

public class Listners implements ITestListener, ISuiteListener {

//    @Override
//    public void onFinish(ITestContext context) {
//        ITestListener.super.onFinish(context);
//    }

    @Override
    public void onTestStart(ITestResult result) {
        /* The following can be used to pass the methodname is extentreports*/
        //String method = result.getMethod().getConstructorOrMethod().getMethod().toString();

        /* The following can be used to pass the test description in extentreports */
        String methodDescription = result.getMethod().getDescription().toString();
        ExtentReports.createTest(methodDescription);
        String authors[] = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotations.class).authors();
        String categories[] = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotations.class).catgeories();
        ExtentReports.authors(authors);
        ExtentReports.categories(categories);

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
