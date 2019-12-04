package Grid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import static org.testng.Assert.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class Testbrowserstack {
	Date d1 = new Date( );
	SimpleDateFormat formatting =  new SimpleDateFormat ("hhmmss");
	/*	public static final String USERNAME = "divyjain1";
	public static final String AUTOMATE_KEY = "icqssGgK2AdLQQFZfHYt";*/
	public static final String USERNAME = "divy19";
	public static final String AUTOMATE_KEY = "vweTtZJZDLyhawBt1QLY";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	DesiredCapabilities caps;
	WebDriver driver;
	String ExpectedTitle = "HD Supply Facilities Maintenance";
	String Expectedconfirmationtext = "Thank You for Registering to Order with";
	String Actualconfirmationtext;
	Random r;
	int rand;

	@BeforeTest
	@Parameters("BrowserName")
	public void LaunchBrowser(String browser) throws MalformedURLException {
		if(browser.equalsIgnoreCase("Chrome"))
		{
			caps = new DesiredCapabilities();
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "67.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setPlatform(Platform.WIN10);
			caps.setCapability("browserstack.debug", "true");
			driver = new RemoteWebDriver(new URL(URL), caps);

		}
		else  if(browser.equalsIgnoreCase("IE")) 
		{
			caps = new DesiredCapabilities();
			caps.setCapability("browser", "IE");
			caps.setCapability("browser_version", "10.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "8");
			caps.setCapability("resolution", "1440x900");
			caps.setPlatform(Platform.WIN8);
			caps.setCapability("browserstack.debug", "true");
			driver = new RemoteWebDriver(new URL(URL), caps);
		}
	}

	@Test(priority=1)
	public void verifyingTitle() {
		driver.get("https://qa2.hd.hdsupplysolutions.com");
		driver.manage().window().maximize();
		String ActualTitle = driver.getTitle();
		System.out.println("actual title is " + ActualTitle);
		assertTrue((ActualTitle.contains(ExpectedTitle)));
		System.out.println("ActualTitle.contains(ExpectedTitle)");
		System.out.println("title verified");

	}

	@Test(priority=2)
	public void register() throws Exception
	{
		r = new Random( System.currentTimeMillis() );
		rand =  1000 + r.nextInt(2000);

		driver.findElement(By.xpath("//a[@id=\"register_link\"]")).click();
		driver.findElement(By.xpath("//div[@id=\"register_new\"]//button[@class=\"btn btn-hds mobile-margin-auto\"][contains(text(),'Customer')]")).click();
		
		driver.findElement(By.xpath("//input[@name=\"orgName\"]")).sendKeys("company"+rand);
		driver.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys("divy"+rand);
		driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("jain"+rand);

		Select Industry = new Select(driver.findElement(By.xpath("//select[@id=\"industryType\"]")));
		Industry.selectByVisibleText("Government - State/Local");
		Select TypeOfBusiness = new Select(driver.findElement(By.xpath("//select[@id=\"business_type_select\"]")));
		TypeOfBusiness.selectByVisibleText("State/County/City Government Agency");
		
		driver.findElement(By.xpath("//input[@name=\"orgSize\"]")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id=\"WC_UserRegistrationAddForm_FormInput_logonId_1\"]")).sendKeys("djain"+rand);
		driver.findElement(By.xpath("//input[@id=\"WC_UserRegistrationAddForm_FormInput_logonPassword_1\"]")).sendKeys("password1");
		driver.findElement(By.xpath("//input[@id=\"WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_1\"]")).sendKeys("password1");
		driver.findElement(By.xpath("//input[@name=\"userEmail\"]")).sendKeys("djain"+rand+"@gmail.com");
		driver.findElement(By.xpath("//input[@name=\"userEmailVerify\"]")).sendKeys("djain"+rand+"@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"WC__AddressEntryForm_FormInput_address1_1\"]")).sendKeys("pune");
		driver.findElement(By.xpath("//input[@id=\"WC__AddressEntryForm_FormInput_address2_1\"]")).sendKeys("road");
		driver.findElement(By.xpath("//input[@name=\"ShipTo_city\"]")).sendKeys("garland");

		Select State = new Select(driver.findElement(By.xpath("//select[@name=\"ShipTo_state\"]")));
		State.selectByVisibleText("Texas");
		
		driver.findElement(By.xpath("//input[@name=\"ShipTo_zipCode\"]")).sendKeys("75040");
		driver.findElement(By.xpath("//input[@id=\"WC_OrganizationRegistrationAddForm_FormInput_org_phone1_1\"]")).sendKeys("8001111111");
		
		driver.findElement(By.xpath("//input[@id=\"billingSameAsShipping\"]")).click();
		driver.findElement(By.xpath("//button[@value=\"submit\"]")).click();
		Thread.sleep(10);        
	}

	@Test(priority=3)
	public void verifyRegistration()
	{
		Actualconfirmationtext = driver.findElement(By.xpath("//h1[contains(text(), \"Thank You for Registering to Order with\")]")).getText();
		System.out.println("Actual Text displayed on page is -------> "+ Actualconfirmationtext);
		System.out.println("Expected Text displayed on page is -------> "+ Expectedconfirmationtext);
		assertTrue( Actualconfirmationtext.contains(Expectedconfirmationtext),"Actual text is not matched with Expected text");
	}


	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}
}

















