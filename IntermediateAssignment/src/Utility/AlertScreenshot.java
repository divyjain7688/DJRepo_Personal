package Utility;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.Reporter;

public class AlertScreenshot {

	public void getScreenshot(String name) throws IOException,
			HeadlessException, AWTException {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
				.format(new Date());
		String fileName = name + "-" + timestamp;
		File destFile = new File(System.getProperty("user.dir")
				+ "\\Screenshots\\" + fileName + ".png");
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(
				Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", destFile);
		String filepath = destFile.toString();
		String path = "<a href=\"" + filepath + "</a>";
		System.out.println(path);
		Reporter.log(path);

	}
}