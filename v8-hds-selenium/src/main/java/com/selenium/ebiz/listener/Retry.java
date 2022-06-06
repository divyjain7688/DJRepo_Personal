package com.selenium.ebiz.listener;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.extentreportlistener.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry extends BaseClassV8_Parallel implements IRetryAnalyzer {

	private int count = 0;
	private int maxTry = 1; // Run the failed test 1 time

	@Override
	public boolean retry(ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) { // Check if test not succeed
			if (count < maxTry) { // Check if maxtry count is reached
				count++; // Increase the maxTry count by 1
				iTestResult.setStatus(ITestResult.FAILURE); // Mark test as failed and take base64Screenshot
				try {
					extendReportsFailOperations(iTestResult);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // ExtentReports fail operations
				return true; // Tells TestNG to re-run the test
			}
		} else {
			iTestResult.setStatus(ITestResult.SUCCESS); // If test passes, TestNG marks it as passed
		}
		return false;
	}

	public void extendReportsFailOperations(ITestResult iTestResult) throws Exception {
	Object testClass = iTestResult.getInstance();
	WebDriver webDriver = this.getDriver();
		//	((BaseClassV8_Parallel) testClass).getDriver();
		//WaitTool.hardWait();
		String base64Screenshot = "data:image/png;base64,"
				+ ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
		ExtentTestManager.getTest().log(LogStatus.FAIL, ""+iTestResult.getName(),
			ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		ExtentTestManager.getTest().log(LogStatus.FAIL,iTestResult.getThrowable());
	}

}
