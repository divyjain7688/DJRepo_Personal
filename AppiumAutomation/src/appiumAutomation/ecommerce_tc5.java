package appiumAutomation;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;


public class ecommerce_tc5 extends baseClass{
	public static void main(String arg[]) throws MalformedURLException, InterruptedException {
		double  sum=0;
		AndroidDriver<AndroidElement> driver = capabilities(); 
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("hello");
		driver.hideKeyboard(); //to hide the keyboard
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Argentina\"));");
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		/*driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();*/
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		List<AndroidElement> addToCartButtons= driver.findElements(By.xpath("//*[@text='ADD TO CART']"));
		for(AndroidElement cart : addToCartButtons)
		{
			cart.click();
			
		}
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(3000);
		
		//tap on checkbox
		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		
		//navigate to mobile view
		driver.findElementByAndroidUIAutomator("text(\"Visit to the website to complete purchase\")").click();
		
		Thread.sleep(3000);
		Set<String> contexts=  driver.getContextHandles();
		for( String contextName : contexts)
		{
			System.out.println("context name is " + contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("divy jain");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		//back to native android app
		driver.pressKey(new KeyEvent(AndroidKey.BACK));


	}

}
