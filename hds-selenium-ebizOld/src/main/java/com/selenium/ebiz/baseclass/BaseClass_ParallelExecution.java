package com.selenium.ebiz.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.selenium.ebiz.tools.PropertyLoader;
import com.selenium.ebiz.tools.WaitTool;
import com.selenium.ebiz.tools.WebEventListener;

public class BaseClass_ParallelExecution {

	public WebDriver driver;
	public static Properties prop;
	public EventFiringWebDriver e_driver;
	public WebEventListener eventListener;
	protected PropertyLoader propertyRead;
	private static String baseUrl;
	public DesiredCapabilities caps;
	public static String browserName;
	public static final String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
    public static final String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");

	public BaseClass_ParallelExecution() {
		try {
			prop = new Properties();

			File file = new File(System.getProperty("user.dir") + "/src/test/resources/config/Config.properties");
			FileInputStream fileInput = new FileInputStream(file);

			prop.load(fileInput);

		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}  
	
	//@BeforeMethod
	public WebDriver initialize(String browserType) throws MalformedURLException {
		if(prop.getProperty("testEnv").equalsIgnoreCase("local")){
   		String currentDir = System.getProperty("user.dir") + "/src/main/resources/drivers/";
			if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", currentDir + "chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				System.out.println("Chrome started successfully");
		} 			
				
		else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", currentDir + "geckodriver.exe");			
			//System.setProperty("webdriver.firefox.marionette", currentDir + "geckodriver.exe");	
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} 
		else if (browserType.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", currentDir + "IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, prop.getProperty("url"));
			capabilities.setCapability("requireWindowFocus", true);
			// capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			System.out.println("IE started successfully");
		} 		
		else {
			System.out.println("Sorry!-------------Browser could not be reached");
		}
		
/*		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;*/

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(WaitTool.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(WaitTool.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("prop.getProperty(url) :"+ prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		
		} else if(prop.getProperty("testEnv").equalsIgnoreCase("remote")){
			Class<? extends BaseClass_ParallelExecution> SLclass = this.getClass();
	        // Start with Jenkins
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setBrowserName(System.getenv("SELENIUM_BROWSER"));
	        caps.setVersion(System.getenv("SELENIUM_VERSION"));
	        browserName = caps.getBrowserName();
	        System.out.println("Display Browser Name in BaseclassFile :"+browserName);
	        
	        caps.setCapability("name", SLclass.getSimpleName());
	        caps.setCapability("screenResolution", "1920x1080");
	        caps.setCapability("tunnelIdentifier", "hdsupply");
	        
	        try {
				propertyRead = new PropertyLoader();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        baseUrl = propertyRead.getProperty("site.url");
	        System.out.println("%%%%% baseUrl :"+baseUrl);
	        driver = (new RemoteWebDriver(new URL("http://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub"), caps));
	        
	        driver.get(baseUrl);	        
		} 		
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public DesiredCapabilities getCapabilitiesFromBase(){
		return caps;
	}
	
	private void printSessionId() {
		 
        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
        (((RemoteWebDriver) driver).getSessionId()).toString(), "some job name");
        System.out.println(message);
    }
	
	@AfterMethod(description = "Throw the test execution results into saucelabs")
    public void afterMethod(ITestResult result) throws Exception {

		if(prop.getProperty("testEnv").equalsIgnoreCase("remote")){
			 ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
			 printSessionId(); 
			 driver.quit();
		}
		else
		{
			//driver.close();
		}
    }

	void annotate(String text)
		{
			((JavascriptExecutor) driver).executeScript("sauce:context=" + text);
		}

}
