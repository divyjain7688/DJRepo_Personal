package Task2;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utility.AlertScreenshot;
import Utility.Screenshotfunction;

public class Alertprogram {

	WebDriver driver;
	String url = "https://the-internet.herokuapp.com/";
	String textonAlertTextBox = "divy jain";
	String expectedResult1 = "You successfuly clicked an alert";
	String expectedTextofJSConfirmAlert = "I am a JS Confirm";
	String expectedTextofJSPromptAlert = "I am a JS prompt";
	String expectedResult3 = "You entered: divy jain";
	String expectedResult2 = "You clicked: Cancel";

	Screenshotfunction SSF;
	AlertScreenshot AS;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}

	@Test
	public void alertandframe() throws Exception {
		SSF = new Screenshotfunction();
		AS = new AlertScreenshot();
		WebElement javascriptalertLink = driver.findElement(By
				.xpath("//li/a[text()=\"JavaScript Alerts\"]"));
		SSF.getScreenShot(driver, "clicking javascriptalertLink");
		javascriptalertLink.click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//button[@onclick=\"jsAlert()\"]")));
		WebElement ClickforJSAlertButton = driver.findElement(By
				.xpath("//button[@onclick=\"jsAlert()\"]"));
		SSF.getScreenShot(driver, "clicking ClickforJSAlertButton");
		ClickforJSAlertButton.click();
		Alert alert;
		alert = driver.switchTo().alert();
		AS.getScreenshot("before accepting alert");
		alert.accept();
		AS.getScreenshot("after accepting alert");

		WebElement verifyResult1 = driver.findElement(By
				.xpath("//p[text()=\"You successfuly clicked an alert\"]"));
		String actualResult1 = verifyResult1.getText();
		SSF.getScreenShot(driver, "verify after alert accept");
		Assert.assertEquals(actualResult1, expectedResult1);

		WebElement ClickforJSConfirmButton = driver.findElement(By
				.xpath("//li/button[text()=\"Click for JS Confirm\"]"));
		ClickforJSConfirmButton.click();
		alert = driver.switchTo().alert();
		AS.getScreenshot("before dismissing alert");

		String actualTextofJSConfrmAlert = alert.getText();
		System.out.println("actual text is " + actualTextofJSConfrmAlert);
		Assert.assertEquals(actualTextofJSConfrmAlert,
				expectedTextofJSConfirmAlert);
		alert.dismiss();
		AS.getScreenshot("after dismissing alert");

		WebElement verifyResult2 = driver.findElement(By
				.xpath("//p[text()=\"You clicked: Cancel\"]"));
		SSF.getScreenShot(driver, "verify after alert dismiss");
		String actualResult2 = verifyResult2.getText();
		Assert.assertEquals(actualResult2, expectedResult2);

		WebElement ClickforJSPromtButton = driver.findElement(By
				.xpath("//li/button[text()=\"Click for JS Prompt\"]"));
		ClickforJSPromtButton.click();
		alert = driver.switchTo().alert();
		AS.getScreenshot("before sending data and accepting alert");

		String actualTextofJSPromptAlert = alert.getText();
		Assert.assertEquals(actualTextofJSPromptAlert,
				expectedTextofJSPromptAlert);
		alert.sendKeys(textonAlertTextBox);
		alert.accept();
		AS.getScreenshot("after sending data and accepting alert");

		SSF.getScreenShot(driver, "verify after sending keys and alert acccept");

		String actualResult3 = "You entered: " + textonAlertTextBox;
		Assert.assertEquals(actualResult3, expectedResult3);

	}

	@AfterTest
	public void cleanup() {
		driver.close();
	}
}
