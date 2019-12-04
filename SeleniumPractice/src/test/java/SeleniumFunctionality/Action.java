package SeleniumFunctionality;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Action {
	public static void main(String arg[])
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://www.facebook.com";
		driver.get(baseUrl);
		driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("email"));
        Actions builder = new Actions(driver);
       builder.moveToElement(username).keyDown(username, Keys.SHIFT).sendKeys(username, "hello").keyUp(username, Keys.SHIFT).build().perform();
    
            
	}

}
/*
public class Action {
public static void main(String[] args) {
    String baseUrl = "http://demo.guru99.com/test/newtours/";
    System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();

            driver.get(baseUrl);           
            WebElement link_Home = driver.findElement(By.linkText("Home"));
            WebElement td_Home = driver
                    .findElement(By
                    .xpath("//html/body/div"
                    + "/table/tbody/tr/td"
                    + "/table/tbody/tr/td"
                    + "/table/tbody/tr/td"
                    + "/table/tbody/tr"));    
             
            Actions builder = new Actions(driver);
            Action mouseOverHome = builder
                    .moveToElement(link_Home)
                    .build();
             
            String bgColor = td_Home.getCssValue("background-color");
            System.out.println("Before hover: " + bgColor);        
            mouseOverHome.perform();        
            bgColor = td_Home.getCssValue("background-color");
            System.out.println("After hover: " + bgColor);
            driver.close();
    }
}*/