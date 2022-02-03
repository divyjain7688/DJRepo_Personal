package SeleniumFunctionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class AlertTest {
	public static void main(String arg[])
	{
		String baseurl ="http://demo.guru99.com/test/delete_customer.php";
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get(baseurl);
		driver.manage().window().maximize();
		  driver.findElement(By.name("cusid")).sendKeys("53920");					
	        driver.findElement(By.name("submit")).submit();		
	        Alert alert = driver.switchTo().alert();
	        System.out.println(alert.getText());
	        alert.accept();
	        driver.close();
	    	
	}

} 
