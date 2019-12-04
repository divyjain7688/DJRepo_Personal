package Task2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.*;

public class HandleProgram {

	WebDriver driver;
	String url = "https://the-internet.herokuapp.com/";
	Screenshotfunction SSF;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test
	public void frameProgram() throws Exception {
		SSF = new Screenshotfunction();

		WebElement FramesLink = driver.findElement(By
				.xpath("//li/a[text()=\"Frames\"]"));
		FramesLink.click();
		SSF.getScreenShot(driver, "clicked FramesLink");

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement IFramelink = driver.findElement(By
				.xpath("//*[text()='iFrame']"));
		IFramelink.click();
		SSF.getScreenShot(driver, "clicked IFramelink");

		WebElement FileLink = driver.findElement(By
				.xpath("//button[@id=\"mceu_15-open\"]"));
		FileLink.click();
		SSF.getScreenShot(driver, "clicked fileLink");

		WebElement NewDocumentLink = driver.findElement(By
				.xpath("//span[text()=\"New document\"]"));
		NewDocumentLink.click();
		SSF.getScreenShot(driver, "clicked NewDocumentLink");

		driver.switchTo().frame("mce_0_ifr");
		WebElement IframeTextbox = driver.findElement(By
				.xpath("//body[@class=\"mce-content-body \"]"));
		IframeTextbox.sendKeys("My name is Divy Jain");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[@id=\"mceu_18-open\"]")).click();
		driver.findElement(
				By.xpath("//span[@class=\"mce-text\"][text()=\"Formats\"]"))
				.click();
		driver.findElement(By.xpath("//span[contains(text(),'Headings')]"))
				.click();
		driver.findElement(By.xpath("//span[contains(text(),'Heading 1')]"))
				.click();
		SSF.getScreenShot(driver, "Heading1");

		driver.switchTo().frame("mce_0_ifr");
		Actions builder = new Actions(driver);
		Action MoveToItalicLine = builder.moveToElement(IframeTextbox).click()
				.sendKeys(Keys.END).sendKeys(Keys.ENTER)
				.sendKeys("I am learning selenium").keyDown(Keys.SHIFT)
				.sendKeys(Keys.HOME).keyUp(Keys.SHIFT).build();
		MoveToItalicLine.perform();

		driver.switchTo().defaultContent();
		driver.findElement(By.id("mceu_2")).click();
		driver.findElement(
				By.xpath("//div[@class='mce-container-body mce-stack-layout']/div[@id='mceu_58']"))
				.click();
		driver.findElement(
				By.xpath("//div[@class='mce-container-body mce-stack-layout']/div[@id='mceu_63']"))
				.click();
		SSF.getScreenShot(driver, "Italic");

		driver.switchTo().frame("mce_0_ifr");
		Action MoveToThirdLine = builder.moveToElement(IframeTextbox).click()
				.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL)
				.sendKeys(Keys.ENTER).build();
		MoveToThirdLine.perform();

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//i[@class=\"mce-ico mce-i-bullist\"]"))
				.click();

		driver.switchTo().frame("mce_0_ifr");
		Action MoveToBulletLines = builder.moveToElement(IframeTextbox).click()
				.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL)
				.sendKeys("This is first bulleted point").sendKeys(Keys.ENTER)
				.sendKeys("This is second bulleted point").sendKeys(Keys.ENTER)
				.sendKeys("This is third bulleted point").build();
		MoveToBulletLines.perform();
		SSF.getScreenShot(driver, "Bullets");

	}

	@AfterTest
	public void cleanup() {
		driver.close();
	}
}