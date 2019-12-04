package SeleniumFunctionality;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		
import java.util.List;		
import java.util.concurrent.TimeUnit;		
import org.openqa.selenium.*;	

public class LinkandWebtable {
	public static void main(String arg[])
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseUrl = "http://demo.guru99.com/test/newtours/";					
	    String UnderConsSite = "Under Construction: Mercury Tours";
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    System.out.println("waited for 5 seconds");
	    driver.get(baseUrl);
	    List<WebElement> linkElements = driver.findElements(By.tagName("a"));
	    String[] linkElementsText = new String[linkElements.size()];
	    int i=0;
	    for(WebElement w : linkElements)
	    {
	    	linkElementsText[i] = w.getText();
	    	System.out.println(linkElementsText[i]);
	    	i++;
	    }
	    for(String s : linkElementsText)
	    {
			driver.findElement(By.linkText(s)).click();	
			if(driver.getTitle().contentEquals(UnderConsSite))
			{
				System.out.println(s+" is under construction");
			}
			else
			{
				System.out.println(s + " is working");
			}
			driver.navigate().back();
	    }
           driver.close();
	}

}
