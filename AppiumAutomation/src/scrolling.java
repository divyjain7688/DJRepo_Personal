import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class scrolling extends baseClass {
	public static void main(String arg[]) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//appium does not have any swipe method
		driver.findElementByAndroidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Radio Group\"));");

}
}
