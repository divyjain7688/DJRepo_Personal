package appiumAutomation;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;


public class ecommerce_tc4 extends baseClass{
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
		List<AndroidElement> prices = driver.findElementsById("com.androidsample.generalstore:id/productPrice");
		for(AndroidElement p : prices)
		{
			System.out.println("value is "+p.getText().substring(1));
			System.out.println("value is "+Double.parseDouble(p.getText().substring(1)));

			sum = sum+ Double.parseDouble(p.getText().substring(1));

		}
		System.out.println("sum of amount is "+ sum);
		
		//get total value
		double total = Double.parseDouble(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
		System.out.println("total  of amount is "+ total);
		
		//tap on checkbox
		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		
		//long press tp get pop up msg
		WebElement terms = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(3))).release().perform();
		driver.findElementById("android:id/button1").click();
		
		//navigate to mobile view
		driver.findElementByAndroidUIAutomator("text(\"Visit to the website to complete purchase\")").click();


	}

}
