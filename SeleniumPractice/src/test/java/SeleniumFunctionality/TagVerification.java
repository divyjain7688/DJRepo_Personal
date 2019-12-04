package SeleniumFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagVerification {
	public static void main(String arg[])
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

        String baseUrl = "http://www.facebook.com";
        String tagname = "";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		System.out.println(driver.getCurrentUrl());
		tagname = driver.findElement(By.id("email")).getTagName();
		System.out.println("tagname is "+ tagname);
		driver.close();
	}


}
