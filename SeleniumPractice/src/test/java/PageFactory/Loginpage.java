package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Loginpage {
	
    @FindBy(name="uid")
    WebElement loginusername;
    @FindBy(name="password")
    WebElement loginpassword;
    @FindBy(className="barone")
    WebElement logintitle;
    @FindBy(name="btnLogin")
    WebElement login;
    
    WebDriver driver;
    
    public Loginpage(WebDriver driver)
    {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void GettitleText()
    {
    	String logintitleText = logintitle.getText();
    	System.out.println("logintitleText is "+logintitleText);
    	
    }
    
    public void Setusername(String strUserName)
    {
    	loginusername.sendKeys(strUserName);
    }
    public void Setpassword(String strpassword)
    {
    loginpassword.sendKeys(strpassword);
    }
    public void clicksubmit()
    {
    	login.click();
    }
    
    
    public void login(String strUserName,String strpassword)
    {
    	
    	Setusername(strUserName);
    	Setpassword(strpassword);
    	clicksubmit();
    }
	
}
