package com.herokuapp.theinternet.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
    public static final ExtentReports extentReports = new ExtentReports();
    
    public static ExtentReports createExtentReports() {
    	String path = System.getProperty("user.dir")+"/test-output/extent-reports/extent-report.html";
    	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
    	reporter.config().setReportName("Extent Report");
    	extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Environment", "Sandbox");
        return extentReports;
    }

}
