package PageObjectModel;

import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class TestusingPom{
Loginpage lp;
Homepage hp;
WebDriver driver;
String baseurl = "http://www.demo.guru99.com/v4/";

@BeforeTest
public void launchbrowser()
{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
    driver = new ChromeDriver();
driver.get(baseurl);
driver.manage().window().maximize();
}

@Test(priority=0)
public void logintohomepage()
{
	lp = new Loginpage(driver);
lp.GettitleText();
lp.login("mgr123", "mgr!23");
}

@Test(priority=1)
public void verifyhomepage()
{
	hp = new Homepage(driver);
hp.VerifyHomepageusername();	
}
	
@AfterTest
public void closingbrowser()
{
driver.close();	
}
	
}