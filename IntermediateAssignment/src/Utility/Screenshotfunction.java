package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Screenshotfunction {

	public void getScreenShot(WebDriver driver, String name) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
				.format(new Date());
		String fileName = name + "-" + timestamp;
		File screenshotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File(System.getProperty("user.dir") + "\\Screenshots\\"
						+ fileName + ".png"));
		String fileNamePath = "<a href=\"" + System.getProperty("user.dir")
				+ "\\Screenshots\\" + fileName + ".png\"" + ">" + fileName
				+ "_Screenshot" + "</a>";
		System.out.println(fileNamePath);
		Reporter.log(fileNamePath);
	}

}
