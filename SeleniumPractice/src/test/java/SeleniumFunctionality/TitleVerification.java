package SeleniumFunctionality;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleVerification {
	public static void main(String arg[])
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome:";
        String actualTitle = "";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		actualTitle = driver.getTitle();
		if(actualTitle.contains(expectedTitle))
			System.out.println("test case pass");
		else
			System.out.println("test case fail");
		driver.close();
	}

}
