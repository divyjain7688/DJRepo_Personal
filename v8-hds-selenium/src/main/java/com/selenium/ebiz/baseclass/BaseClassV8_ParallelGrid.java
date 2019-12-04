package com.selenium.ebiz.baseclass;

import com.selenium.ebiz.tools.ConfigFileRead;
import com.selenium.ebiz.tools.PropertyLoader;
import com.selenium.ebiz.tools.WaitTool;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseClassV8_ParallelGrid {
	protected String environmentValue;
	protected String baseUrl;
	protected PropertyLoader propertyRead;
	protected ConfigFileRead configread;
	protected SoftAssert softAssert;
	public static final String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	public static final String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
	protected String currentDir = System.getProperty("user.dir") + "/src/main/resources/drivers/";
	public Logger Log = Logger.getLogger(BaseClassV8_ParallelGrid.class.getName());
	public String buildTag = System.getenv("BUILD_TAG");
	public String testName;


	/**
	 * ThreadLocal variable which contains the  {@link WebDriver} instance which is used to perform browser interactions with.
	 */
	private ThreadLocal<RemoteWebDriver> webDriver = new ThreadLocal<>();


	/**
	 * ThreadLocal variable which contains the Sauce Job Id.
	 */
	protected ThreadLocal<String> sessionId = new ThreadLocal<String>();
	protected WaitTool waitTool;

	//@BeforeMethod

	@DataProvider(name = "browsers",parallel = true)
	public static Object[][] sauceBrowserDataProvider(Method testMethod) {
		return new Object[][]{

		//	new Object[]{"internet explorer", "11.0", "Windows 7"},
			new Object[]{"chrome", "74.0", "Windows 10"}
		};
	}


	/**
	 * @return the {@link WebDriver} for the current thread
	 */
	public RemoteWebDriver getWebDriver() {
		return webDriver.get();
	}

	/**
	 *
	 * @return the Sauce Job id for the current thread
	 */
	public String getSessionId() {
		return sessionId.get();
	}



	protected void createDriver(String browser, String version, String os, String methodName) throws MalformedURLException,Exception {
		configread = new ConfigFileRead();

		if (configread.getTestEnv().equalsIgnoreCase("remote")) {
			Log.info("Welcome to Remote Execution in Saucelab");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.BROWSER_NAME, browser);
			if (version != null) {
				caps.setCapability(CapabilityType.VERSION, version);
			}
			caps.setCapability(CapabilityType.PLATFORM, os);

			caps.setCapability("name", methodName + "__" + browser + "_" + version + "__" + os);
			caps.setCapability("screenResolution", "1920x1080");
			caps.setCapability("tunnelIdentifier", "hdsupply");
			caps.setCapability("extendedDebugging", true);

			if (buildTag != null) {
				caps.setCapability("build", buildTag);
			}
			// caps.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("BUILD_NUMBER"));

			// Launch remote browser and set it as the current thread
			webDriver.set(new RemoteWebDriver(
					new URL("https://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub"),
					caps));

			// set current sessionId
			String id = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
			sessionId.set(id);
			Log.info("Session id is: " + sessionId + "  **** WebDriver.get ***  " + getWebDriver());
			testName = methodName + "__" + browser + "_" + version + "__" + os;
			String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s", id, methodName,browser,os,version);
			Log.info("SauceOnDemandSessionID ___" + message);


		}
		else if (configread.getTestEnv().equalsIgnoreCase("local")) {
			Log.info("Welcome to Execution in Local Grid");
			
				DesiredCapabilities caps = new DesiredCapabilities();
				URL url = new URL("http://localhost:4444/wd/hub");
				caps.setCapability(CapabilityType.BROWSER_NAME, browser);
				caps.setCapability(CapabilityType.VERSION, version);
				// Launch remote browser and set it as the current thread
				webDriver.set(new RemoteWebDriver(url,caps));			
		}


		Log.info("Created the driver");
		propertyRead = new PropertyLoader();
		baseUrl = propertyRead.getProperty("site.url");
		webDriver.get().manage().deleteAllCookies();
		Log.info("Deleye cookies");
		getURL();
		getEnvValue();
	//	softAssert = new SoftAssert();
		webDriver.get().manage().window().maximize();
		Log.info("Window maximize");

	}

	protected String getEnvValue() throws Exception {

		String[] envArray = null;
		envArray = baseUrl.substring(8).split("\\.");
		environmentValue = envArray[0];
		Log.info("Display Environment :"+ environmentValue);
		return environmentValue;
	}


	private void getURL(){
		webDriver.get().get(baseUrl);
		Log.info("Getting the url" + baseUrl);
	}
	private void getSignInPageURL(){
		webDriver.get().get("https://qa2.hdsupplysolutions.com/LogonForm?catalogId=10054&langId=-1&URL=&storeId=10051");
		Log.info("Getting the url: " + "https://qa2.hdsupplysolutions.com/LogonForm?catalogId=10054&langId=-1&URL=&storeId=10051");
	}

	protected void printSessionId() {
		String testname = String.format(testName);

		String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
				getWebDriver().getSessionId(), "some job name");

		Log.info("printSessionId:" + message + testname);

	}

	// Method that gets invoked after method.

	@AfterMethod
	public void getReport(ITestResult result) {
		if (configread.getTestEnv().equalsIgnoreCase("remote"))
		{
			String txt = "sauce:job-result=" + (result.isSuccess() ? "passed" : "failed");
			getWebDriver().executeScript(txt);
			printSessionId();
			Log.info("Create ITest Result");

		}
		webDriver.get().quit();
		Log.info("Driver quit");

	}

}
