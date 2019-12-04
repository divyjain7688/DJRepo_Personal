package SeleniumFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxRadiobutton {
	public static void main(String arg[])
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseUrl = "http://demo.guru99.com/test/login.html";					
	    driver.get(baseUrl);
        WebElement email = driver.findElement(By.id("email"));							
        WebElement password = driver.findElement(By.name("passwd"));
        WebElement login = driver.findElement(By.id("SubmitLogin"));							
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        email.clear();
        password.clear();
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        login.submit();
        driver.get("http://demo.guru99.com/test/radio.html");		
        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));							
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));	
        radio1.click();
        radio2.click();
        WebElement option1 = driver.findElement(By.id("vfb-6-0"));							
        option1.click();
        if(option1.isSelected())
        System.out.println("checkbox is ticked");
        else
       	System.out.println("checkbox is not ticked");
        driver.get("http://demo.guru99.com/test/facebook.html");					
        WebElement chkFBPersist = driver.findElement(By.id("persist_box"));
        for(int i=0;i<2;i++)
        {
        	chkFBPersist.click();
        	System.out.println(chkFBPersist.isSelected());
        }
        driver.close();
          
        
	}
}
	