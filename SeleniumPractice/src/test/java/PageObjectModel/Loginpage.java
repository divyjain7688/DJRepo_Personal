package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Loginpage {
	By loginusername = By.name("uid");
	By loginpassword = By.name("password");
    By logintitle =By.className("barone");
    By login = By.name("btnLogin");
    WebDriver driver;
    
    public Loginpage(WebDriver driver)
    {
    	this.driver = driver;
    }
    
    public void GettitleText()
    {
    	String logintitleText = driver.findElement(logintitle).getText();
    	
    }
    
    public void Setusername(String strUserName)
    {
    	driver.findElement(loginusername).sendKeys(strUserName);
    }
    public void Setpassword(String strpassword)
    {
    driver.findElement(loginpassword).sendKeys(strpassword);
    }
    public void clicksubmit()
    {
    	driver.findElement(login).click();
    }
    
    
    public void login(String strUserName,String strpassword)
    {
    	
    	Setusername(strUserName);
    	Setpassword(strpassword);
    	clicksubmit();
    }
	
}
