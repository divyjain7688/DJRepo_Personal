package appiumAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseClass {
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException
	{
		File f = new File("src");
	//	File fs = new File(f,"ApiDemos-debug.apk");
		File fs = new File(f,"General-Store.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2Android9");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,20);

		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		AndroidDriver<AndroidElement> ad = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	    ad.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return ad;
		//AndroidUIAutomator	
		
	}

}
