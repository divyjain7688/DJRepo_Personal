package SeleniumFunctionality;
import java.util.Iterator;		
import java.util.Set;		
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handles {
public static void main(String arg[])
{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	String baseUrl = "http://demo.guru99.com/popup.php";
	driver.get(baseUrl);
	driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();		
	String mainhandle = driver.getWindowHandle();
	Set<String> childhandle = driver.getWindowHandles();
	Iterator<String> i = childhandle.iterator();
	while(i.hasNext())
	{
		String childhan =i.next();
		if(!mainhandle.equalsIgnoreCase(childhan))
		{
			driver.switchTo().window(childhan); 
			driver.findElement(By.name("emailid")).sendKeys("divy.0871@gmail.com");                			
			driver.findElement(By.name("btnLogin")).click();			

			driver.close();		
		}
		driver.switchTo().window(mainhandle);
	}
	System.out.println("test case pass");
	driver.close();

}
}
