package appiumAutomation;

import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class leftSwipe extends baseClass {
	public static void main(String arg[]) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		driver.findElement(By.xpath("//*[@content-desc='9']")).click();
		TouchAction t = new TouchAction(driver);
		//long press for 1 second
		t.longPress(longPressOptions().withElement(element(driver.findElementByXPath("//*[@content-desc='15']"))).withDuration(ofSeconds(2)))
		.moveTo(element(driver.findElementByXPath("//*[@content-desc='45']"))).release().perform();	
	}
}
//perform () is mandatory for touchactions