package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utility.Screenshotfunction;

public class SignIn {
	WebDriver driver;
	Screenshotfunction SSF = new Screenshotfunction();
	By userNameTextBox = By.xpath("//input[@name=\"userName\"]");
	By passwordTextBox = By.xpath("//input[@name=\"password\"]");
	By submitButton = By.xpath("//input[@name=\"submit\"]");
	By thankyoumessage = By.xpath("//b[text()=\" Thank you for Loggin. \"]");
	By loginSuccessmessage = By.xpath("//h3[text()=\"Login Successfully\"]");

	public SignIn(WebDriver driver) {
		this.driver = driver;
	}

	public void fillSignInForm(String strUserNameTextBox,
			String strPasswordTextBox) throws Exception {
		driver.findElement(userNameTextBox).sendKeys(strUserNameTextBox);
		driver.findElement(passwordTextBox).sendKeys(strPasswordTextBox);
		SSF.getScreenShot(driver, "verify Submit details");
		driver.findElement(submitButton).click();
	}

	public void verifyLoginSuccessful() throws Exception {
		String actualThankyoumessage = driver.findElement(thankyoumessage).getText();
		String expectedThankyoumessage = "Thank you for Loggin.";

		Assert.assertEquals(actualThankyoumessage, expectedThankyoumessage);
		SSF.getScreenShot(driver, "VerifyLoginSuccessful");

		String actualLoginSuccessmessage = driver.findElement(loginSuccessmessage).getText();
		String expectedLoginSuccessmessage = "Login Successfully";

		Assert.assertEquals(actualLoginSuccessmessage,expectedLoginSuccessmessage);
		SSF.getScreenShot(driver, "VerifyLoginSuccessful");

	}
}
