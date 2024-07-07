package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReporterUtility {

    private ExtentReporterUtility() {
    }

    static ExtentReports ext;

    public static void initReports() {
        ExtentSparkReporter extreporter = new ExtentSparkReporter("target/spark.html");
        extreporter.config().setTheme(Theme.DARK);
        ext = new ExtentReports();
        ext.attachReporter(extreporter);
    }


    public static ExtentTest createTestMethod(String name) {
        return ext.createTest(name);
    }

    public static void tearDown(){
        ext.flush();
    }

}
