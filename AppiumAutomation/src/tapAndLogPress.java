import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static java.time.Duration.ofSeconds;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
public class tapAndLogPress extends baseClass {
	public static void main(String arg[]) throws MalformedURLException, InterruptedException
	{
	AndroidDriver<AndroidElement> driver = capabilities();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();	
	//Tap
	TouchAction t = new TouchAction(driver);
	t.tap(tapOptions().withElement(element(driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']")))).perform();
	driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
	//longpress
	t.longPress(longPressOptions().withElement(element(driver.findElementByXPath("//android.widget.TextView[@text='People Names']"))).withDuration(ofSeconds(2))).release().perform();
	System.out.println(driver.findElementById("android:id/title").isDisplayed());
	}
}
