package com.selenium.ebiz.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.extentreportlistener.ExtentReporterNG;
import com.selenium.ebiz.extentreportlistener.ExtentTestManager;
import com.selenium.ebiz.tools.WaitTool;


public class TestListener extends BaseClass implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
       // iTestContext.setAttribute("WebDriver", BaseClass.driver);
        iTestContext.setAttribute("WebDriver", getDriver ());
        
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentReporterNG.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
    }	

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
        //Extentreports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        ExtentTestManager.endTest();
        
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
        
       // String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        
        WebDriver webDriver = ((BaseClass) testClass).getDriver();
        
        try {
			WaitTool.hardWait();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
                getScreenshotAs(OutputType.BASE64);

        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL,""+iTestResult.getName(),
                ExtentTestManager.getTest().addScreenCapture(base64Screenshot));
        ExtentTestManager.getTest().log(LogStatus.FAIL,iTestResult.getThrowable());
        ExtentTestManager.endTest();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        ExtentTestManager.endTest();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}

