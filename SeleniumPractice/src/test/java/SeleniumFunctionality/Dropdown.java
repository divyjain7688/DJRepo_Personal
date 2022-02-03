package SeleniumFunctionality;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.By;

public class Dropdown {
	public static void main(String arg[])
	{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	String baseurl = "http://demo.guru99.com/test/newtours/register.php";
	driver.get(baseurl);
	driver.manage().window().maximize();
	Select dropcountry = new Select(driver.findElement(By.name("country")));
	System.out.println(	dropcountry.isMultiple());
	dropcountry.selectByIndex(1);
	driver.close();
	}
}
