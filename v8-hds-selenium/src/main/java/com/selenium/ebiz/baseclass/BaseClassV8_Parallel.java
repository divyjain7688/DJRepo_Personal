package com.selenium.ebiz.baseclass;

import com.selenium.ebiz.tools.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BaseClassV8_Parallel {
    protected WebDriver driver;
    protected String environmentValue;
    protected String baseUrl;
    protected PropertyLoader propertyRead;
    protected PageManager pageManager;
    protected ConfigFileRead configread;
    protected SoftAssert softAssert;
    public static final String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
    public static final String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
    protected String currentDir = System.getProperty("user.dir") + "/src/main/resources/drivers/";
    public Logger Log = Logger.getLogger(BaseClassV8_Parallel.class.getName());
    protected ArrayList<com.selenium.ebiz.beans.UsersListBean> usersList, usersList1,usersList2;

    protected ThreadLocal<String> SessionId = new ThreadLocal<String>();
    protected ThreadLocal<RemoteWebDriver> webdriver = new ThreadLocal<>();

    protected WaitTool waitTool;

    // private static List<Boolean> status = new ArrayList<Boolean>();




    @BeforeClass
    public void driverSetup() throws Exception {
        Log.info("Creating driver Instance  ........");
        createDriver();
        Log.info("Created the driver");
        propertyRead = new PropertyLoader();
        baseUrl = propertyRead.getProperty("site.url");
        pageManager = new PageManager(getDriver());
        Log.info("PageManager:  " + pageManager);
        getURL();
        getEnvValue();
        softAssert = new SoftAssert();
        getDriver().manage().window().maximize();
        Log.info("Window maximize");
        getDriver().manage().deleteAllCookies();
        waitTool = new WaitTool();
    }


    protected void createDriver() throws MalformedURLException {
        configread = new ConfigFileRead();

        if (configread.getTestEnv().equalsIgnoreCase("remote")) {
            Log.info("Welcome to Remote Execution in Saucelab");

            Class<? extends BaseClassV8_Parallel> SLclass = this.getClass();

            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setBrowserName(System.getenv("SELENIUM_BROWSER"));
            caps.setVersion(System.getenv("SELENIUM_VERSION"));
            caps.setCapability(CapabilityType.PLATFORM, System.getenv("SELENIUM_PLATFORM"));
            caps.setCapability("name", SLclass.getSimpleName());
            caps.setCapability("screenResolution", "1920x1080");
            caps.setCapability("tunnelIdentifier", "hdsupply");
            webdriver.set(new RemoteWebDriver(new URL("http://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub"), caps));
            String id = ((RemoteWebDriver) webdriver.get()).getSessionId().toString();
            SessionId.set(id);
            Log.info("Session id is: " + SessionId);
            Log.info("WebDriver.get ***  " + webdriver.get());

        } else if (configread.getTestEnv().equalsIgnoreCase("local")) {

            if (configread.getBrowser().equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", currentDir + "geckodriver.exe");
                webdriver.set(new FirefoxDriver());
            } else if (configread.getBrowser().equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", currentDir + "chromedriver.exe");
                webdriver.set(new ChromeDriver());
                System.out.println("WebDriver.get +++  " + webdriver.get());
            } else if (configread.getBrowser().equals("ie")) {
                System.setProperty("webdriver.ie.driver", currentDir + "IEDriverServer.exe");
                webdriver.set(new InternetExplorerDriver());
            }

            String id = ((RemoteWebDriver) webdriver.get()).getSessionId().toString();
            SessionId.set(id);
            Log.info("Local Session id is: " + SessionId);
        }


      ////  driver = webdriver.get();
     /* if(configread.getEvenListenerFlag().equals("true"))
         {
           setEvenListener();
        }
    */
    }

    protected RemoteWebDriver getDriver() {
        return webdriver.get();
    }
   /*
  private void setEvenListener() {
		e_driver = new EventFiringWebDriver(getDriver());
        eventListener = new EbizEventListener();
       e_driver.register(eventListener);
       getDriver() = e_driver;
	}
*/

    protected void getEnvValue() throws Exception {

        String[] envArray = null;
        envArray = baseUrl.substring(8).split("\\.");
        environmentValue = envArray[0];
        Log.info("Display Environment :"+ environmentValue);
    }


    public void LoginToHDS(String username, String password){
        if(environmentValue.equals("dev1")||environmentValue.equals("dev2")||environmentValue.equals("dev3")) {
            pageManager.loginPage().loginToHDS_V8(RandomAccountSelect.devusers.pop(), configread.getPassword());
         //   pageManager.loginPage().closeShopNowOnFinalDaysToSavePopup.click();

        } else if(environmentValue.equals("beta")){
            pageManager.loginPage().loginToHDS_V8(username, configread.getPassword());
            System.out.println("Username:" + username);
           // pageManager.loginPage().closeShopNowOnFinalDaysToSavePopup.click();


        } else {
            pageManager.loginPage().loginToHDS_V8(username, configread.getPassword());
            System.out.println("Username:" + username);

        }


        pageManager.homePage().scrollToWelcomeNote();
        Log.info("Display welcome message   " + pageManager.homePage().welcomeTextLoggedUser.getText());

        Assert.assertTrue(pageManager.homePage().welcomeTextLoggedUser.getText().contains("Hi"));

    }

    private void getURL(){
        webdriver.get().get(baseUrl);
        Log.info("Getting the url" + baseUrl);
    }

    protected void printSessionId() {

        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
                getDriver().getSessionId(), "some job name");
        System.out.println(message);

    }
    public void GetUserList1(String testcaseName, String sheetName) throws Exception{
        usersList1 = pageManager.dBCon().loadDataFromExcel(testcaseName,sheetName);
        //("loginWithValidCredentialAndLogoutTest", "LoginTestData");
    }
    protected void GetUserList(String testcaseName, String sheetName) throws Exception{
        usersList = pageManager.dBCon().loadDataFromExcel(testcaseName,sheetName);
        //("loginWithValidCredentialAndLogoutTest", "LoginTestData");
    }
    public void GetUserList2(String testcaseName, String sheetName) throws Exception{
        usersList2 = pageManager.dBCon().loadDataFromExcel(testcaseName,sheetName);
        //("loginWithValidCredentialAndLogoutTest", "LoginTestData");
    }


    // Method that gets invoked after test.

    @AfterMethod
    public void getReport(ITestResult result) {
       if (configread.getTestEnv().equalsIgnoreCase("remote")) {
           String txt = "sauce:job-result=" + (result.isSuccess() ? "passed" : "failed");
           getDriver().executeScript(txt);
           printSessionId();
           Log.info("Create ITest Result");
        }
    }


    @AfterClass
    public void teardown()
    {
        getDriver().quit();
        Log.info("driver quit");
    }

    void annotate(String text)
    {
        ((JavascriptExecutor) webdriver.get()).executeScript("sauce:context=" + text);
    }



}
