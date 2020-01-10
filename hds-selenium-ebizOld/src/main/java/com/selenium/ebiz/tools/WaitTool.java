package com.selenium.ebiz.tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTool {

	public static long PAGE_LOAD_TIMEOUT = 200;
	public static long IMPLICIT_WAIT = 70;
	public static final int DEFAULT_WAIT_4_ELEMENT = 450;
	private static int defaultWait4Element = 30;
	public static final int DEFAULT_WAIT_4_PAGE = 12;
	private static int defaultWait4Page = 30;
	public static final long DEFAULT_POLLING_4_ELEMENT = 500L;
	private static long defaultPolling4Element = 500L;

	public static void setDefaultWait4Element(Integer timeoutInSeconds) {
		defaultWait4Element = timeoutInSeconds == null ? 7 : timeoutInSeconds.intValue();
	}

	public static int getDefaultWait4Element() {
		return defaultWait4Element;
	}

	public static void setDefaultWait4Page(Integer timeoutInSeconds) {
		defaultWait4Page = timeoutInSeconds == null ? 12 : timeoutInSeconds.intValue();
	}

	public static int getDefaultWait4Page() {
		return defaultWait4Page;
	}

	public static void setDefaultPolling4Element(Integer timeoutInMilliSeconds) {
		defaultPolling4Element = timeoutInMilliSeconds != null && (long) timeoutInMilliSeconds.intValue() > 500L ? (long) timeoutInMilliSeconds.intValue() : 500L;
	}

	public static long getDefaultPolling4Element() {
		return defaultPolling4Element;
	}

	public static void waitFor(WebDriver driver, boolean pageloadDone) {
		new WebDriverWait(driver, DEFAULT_WAIT_4_PAGE).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}

	public static void nullifyImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
	}

	public static void setImplicitWait(WebDriver driver, int waitTime_InSeconds) {
		driver.manage().timeouts().implicitlyWait((long) waitTime_InSeconds, TimeUnit.SECONDS);
	}

	public static void resetImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait((long) getDefaultWait4Page(), TimeUnit.SECONDS);
	}

	public static void resetImplicitWait(WebDriver driver, int newWaittime_InSeconds) {
		driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait((long) newWaittime_InSeconds, TimeUnit.SECONDS);
	}

	public static boolean pageLoadDone(WebDriver driver) {
		new WebDriverWait(driver, DEFAULT_WAIT_4_PAGE).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		return true;
	}

	public static void waitForElementByLocator(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
		wait.until(ExpectedConditions.visibilityOf(element));
        System.out.println(element + "is visible now....");
	}

    public static void waitForAlert(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println( "alertIsPresent is visible now....");
    }

    
	public static void waitForText(WebDriver driver, WebElement element,
			String text) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_ELEMENT);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public static void hardWait() throws Exception {
		Thread.sleep(5000);

	}

	public static void hardWait2sec() throws Exception {
		Thread.sleep(3000);
	}

	public static void hardWait10sec() throws Exception {
		Thread.sleep(10000);
	}

	public static void waitVisibility(WebDriver driver, WebElement element,
			int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void ElementToBeClickable(WebDriver driver, WebElement element,
			int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void ElementPresence(WebDriver driver, WebElement element,
			int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}

	public static void waitVisibilityOfElementLocated(WebDriver driver,
			WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}

	public static void setImplicity(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}
