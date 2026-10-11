package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.tests.BaseTest;
import com.ui.util.BrowserUtility;
import com.ui.util.ExtentReportUtility;
import com.ui.util.LoggerUtility;

public class TestListener implements ITestListener {
	private Logger logger = LoggerUtility.getLogger(this.getClass());

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " : Passed");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " : Passed");

	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " : Failed");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " : Failed");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

		Object testclass = result.getInstance();
		BrowserUtility browserUtility = ((BaseTest) testclass).getInstance();
		logger.info("Capturing screenshot for failed tests");
		String screenshotpath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("Attaching the screenshot to the HTML File");

		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotpath);

	}

	public void onTestSkipped(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " : Skipped");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " : Skipped");
	}

	public void onStart(ITestContext context) {
		logger.info("Test suite Started");
		ExtentReportUtility.setUpSparkReporter("report.html");
	}

	public void onFinish(ITestContext context) {
		logger.info("Test suite Completed");

		ExtentReportUtility.generateReport();
	}

}
