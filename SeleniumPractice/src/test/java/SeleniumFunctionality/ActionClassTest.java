package SeleniumFunctionality;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.interactions.Action;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

public class ActionClassTest {
	
	public static void main(String arg[])
	{
	String fb = "http://www.facebook.com";
	WebDriver driver = new FirefoxDriver();
	/*driver.get(fb);
	driver.manage().window().maximize();
	WebElement EmailOrPhone = driver.findElement(By.xpath("//input[@ id=\"email\"]"));
	System.out.println("element found");
	Actions builder = new Actions(driver);
	Action seriesofaction = builder.moveToElement(EmailOrPhone).click().keyDown(EmailOrPhone, Keys.SHIFT).sendKeys(EmailOrPhone, "HEllo").keyUp(EmailOrPhone, Keys.SHIFT).doubleClick(EmailOrPhone).contextClick(EmailOrPhone).build();
	seriesofaction.perform();
	WebElement login = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
	login.click();
	driver .close();*/
	
	String dd = "http://jqueryui.com/droppable/";
	driver.get(dd);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]")));

WebElement drag = driver.findElement(By.xpath("//p[text()=\"Drag me to my target\"]"));
System.out.println("element found 1");
WebElement dropbeforedrag = driver.findElement(By.xpath("//div[@class=\"ui-widget-header ui-droppable\"]"));
System.out.println("element found 2");


Actions builder1 = new Actions(driver);
Action dragdrop = builder1.dragAndDrop(drag, dropbeforedrag).moveToElement(drag).build();
dragdrop.perform();

WebElement dropafterdrag = driver.findElement(By.xpath("//div[@class=\"ui-widget-header ui-droppable ui-state-highlight\"]"));
System.out.println("element found 3");
Assert.assertTrue(dropafterdrag.isDisplayed());
driver.close();

	

	}
}
