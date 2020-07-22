package appiumAutomation;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.homePage;
import pageObjects.preferences;

public class locators extends hybridBaseClass
{
	public static void main(String arg[]) throws MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = capabilities("real");
		//xpath id className AndroidUIAutomator
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		homePage h = new homePage(driver);
		//		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		h.preferences.click();
		
		preferences p = new preferences(driver);
//		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		p.preferenceDependencies.click();
		
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("hello");
		driver.findElements(By.className("android.widget.Button")).get(1).click();

	}
}
