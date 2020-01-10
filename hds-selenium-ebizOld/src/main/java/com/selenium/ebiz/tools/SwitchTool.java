package com.selenium.ebiz.tools;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.ebiz.baseclass.BaseClass;

public class SwitchTool extends BaseClass{

	public static void switchWindowByTitle(WebDriver driver, String title) {
		String mainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (driver.switchTo().window(ChildWindow).getTitle().trim().equalsIgnoreCase(title))
				break;
		}
		driver.switchTo().window(mainWindow);
	}

	public static void switchWindow(WebDriver driver, String windowehandle) {
		driver.switchTo().window(windowehandle);
	}

	public static void switchframe(WebDriver driver, String elementName, WebElement iframe) {
		if (elementName != null) {
		//	ToolKitLogger.logAction(driver, "Switch to frame " + elementName);
		}
		driver.switchTo().frame(iframe);
	}

	public static void switchDefaultframe(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static void switchParentframe(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
}

