package com.reports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public final class ExtentReports {
    private ExtentReports() {
    }

    static ExtentTest exttest;

    public static void initialize() {
        ExtentReporterUtility.initReports();
    }

    public static void createTest(String name) {
        exttest = ExtentReporterUtility.createTestMethod(name);
    }

    public static void onTestPass(String result) {
        exttest.pass(MarkupHelper.createCodeBlock(result, CodeLanguage.JSON));
    }

    public static void onTestFailure(String result) {
        exttest.fail(MarkupHelper.createLabel(result, ExtentColor.RED));
    }

    public static void onTestSkip(String result) {
        exttest.skip(MarkupHelper.createLabel(result, ExtentColor.YELLOW));
    }

    public static void flushReports(){
        ExtentReporterUtility.tearDown();
    }
}
