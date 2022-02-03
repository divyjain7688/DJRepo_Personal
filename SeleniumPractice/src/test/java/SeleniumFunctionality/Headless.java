package SeleniumFunctionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class Headless {
	
	@Test
	public void htmlUnitDriverTest()
	{

	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
	WebDriver driver = new HtmlUnitDriver(); //dependency for htmlunitdriver isadded seperately because it does not come with selenium
	String baseUrl = "https://www.freecrm.com";					
    driver.get(baseUrl);
    System.out.println("title is "+ driver.getTitle());
	}
	
	
	@Test
	public void chromeOptionTest()
	{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--window-size=1400,800");
	options.addArguments("headless");
	WebDriver driver = new ChromeDriver(options);
	String baseUrl = "https://www.freecrm.com";					
    driver.get(baseUrl);
    System.out.println("title is "+ driver.getTitle());
	}
	
	@Test
	public void phantomHeadlessTest()
	{
	System.setProperty("phantomjs.binary.path",System.getProperty("user.dir") + "\\Driver\\phantomjs.exe");
	WebDriver driver = new PhantomJSDriver();
	String baseUrl = "https://www.freecrm.com";					
    driver.get(baseUrl);
    System.out.println("title is "+ driver.getTitle());
	}
}
