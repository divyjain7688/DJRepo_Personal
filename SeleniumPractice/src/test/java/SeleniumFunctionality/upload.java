package SeleniumFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class upload {
	public static void main(String arg[])
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseurl = "http://demo.guru99.com/test/upload/";
		driver.get(baseurl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
        uploadElement.sendKeys("C:\\DJ\\dj.txt");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.name("send")).click();
        driver.close();
        System.out.println("test caser pass");


	}

}
