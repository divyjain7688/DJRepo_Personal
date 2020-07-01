package appiumAutomation;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class androidAutomator extends baseClass {
	public static void main(String arg[]) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());

	}
}
