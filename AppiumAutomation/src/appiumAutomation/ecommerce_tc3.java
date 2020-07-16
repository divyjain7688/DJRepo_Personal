package appiumAutomation;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc3 extends baseClass{
	public static void main(String arg[]) throws MalformedURLException, InterruptedException {
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
		System.out.println(driver.findElementsById("com.androidsample.generalstore:id/productName")); //2: it will not list all products count because all are not visible
		
		//go to paraent scrollable tage and then move to child so that complete element in that list is displayed and we can click on add to cart
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		
		int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		for(int i=0;i<count;i++)
		{
			String text =  driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			if(text.equalsIgnoreCase("Jordan 6 Rings"))
			{
				//driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();	
				driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(i).click();
				break;
			}
		}
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(3000);
		String lastpageText=    driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

		System.out.println("lastpageText is " + lastpageText);
		Assert.assertTrue(lastpageText.equals("Jordan 6 Rings"));
	}

}
