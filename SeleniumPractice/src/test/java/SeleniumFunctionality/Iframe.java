package SeleniumFunctionality;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {
	
	public static void main(String arg[])
	{
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		//getCssValue("color");
		 List<WebElement> frames = driver.findElements(By.tagName("iframe"));	
		 int framesize = driver.findElements(By.tagName("iframe")).size();
		 System.out.println("Number of frames in a page :" + framesize);
		for(WebElement frame : frames) 
		{
	        System.out.println("Frame Id :" + frame.getAttribute("id"));
	        System.out.println("Frame name :" + frame.getAttribute("name"));

		}
	       
		  for (int j=0;j<framesize;j++)
	{
		driver.switchTo().frame(j);
   		int total = driver.findElements(By.xpath("html/body/a/img")).size();
   		System.out.println("total is "+total);
   		driver.switchTo().defaultContent();		
	}
		driver.close();
	}
}
