package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utility.Screenshotfunction;

public class RegiterPage {
	WebDriver driver;
	Screenshotfunction SSF = new Screenshotfunction();

	By FirstName = By.xpath("//input[@name=\"firstName\"]");
	By LastName = By.xpath("//input[@name=\"lastName\"]");
	By Address = By.xpath("//input[@name=\"address1\"]");
	By City = By.xpath("//input[@name=\"city\"]");
	By Country = By.xpath("//select[@name=\"country\"]");
	By CountryName = By.xpath("//input[@name=\"firstName\"]");
	By UserName = By.xpath("//input[@id=\"email\"]");
	By Password = By.xpath("//input[@name=\"password\"]");
	By ConfirmPassword = By.xpath("//input[@name=\"confirmPassword\"]");
	By SubmitQuery = By.xpath("//input[@type=\"submit\"]");
	By SignInLink = By.xpath("//a[@href=\"login.php\"]");
	By ThankyouMessage = By
			.xpath("//font[contains(text(),\"Thank you for registering.\")]");
	By UserNameMessage = By
			.xpath("//b[contains(text(),\"Note: Your user name is\")]");
	By CountryDropdown = By.name("country");

	public RegiterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void FillRegisterForm(String strFirstName, String strLastName,
			String strAddress, String strCity, String strUSerName,
			String strPassword, String strConfirmPassword) throws Exception {
		driver.findElement(FirstName).sendKeys(strFirstName);
		driver.findElement(LastName).sendKeys(strLastName);
		driver.findElement(Address).sendKeys(strAddress);
		// driver.findElement(City).sendKeys(strCity);
		Select CountryDropDown = new Select(driver.findElement(CountryDropdown));
		CountryDropDown.selectByVisibleText(strCity);
		driver.findElement(UserName).sendKeys(strUSerName);
		driver.findElement(Password).sendKeys(strPassword);
		driver.findElement(ConfirmPassword).sendKeys(strConfirmPassword);
		SSF.getScreenShot(driver, "filling registration details");
		driver.findElement(SubmitQuery).click();

	}

	public void VerifyThankyouMessage() throws Exception {
		String ActualThankyoumessage = driver.findElement(ThankyouMessage)
				.getText();
		String ExpectedThankyoumessage = "Thank you for registering. You may now sign-in using the user name and password you've just entered.";
		System.out.println("ActualThankyoumessage" + ActualThankyoumessage);
		System.out.println("ExpectedThankyoumessage" + ExpectedThankyoumessage);
		Assert.assertEquals(ActualThankyoumessage, ExpectedThankyoumessage);
		SSF.getScreenShot(driver, "VerifyThankyouMessage");

	}

	public void VerifyUserNameMessage(String username) throws Exception {
		String ActualUserNameMessage = driver.findElement(UserNameMessage)
				.getText();
		String ExpectedUserNameMessage = "Note: Your user name is " + username
				+ ".";
		System.out.println("ActualUserNameMessage" + ActualUserNameMessage);
		System.out.println("ExpectedUserNameMessage" + ExpectedUserNameMessage);
		Assert.assertEquals(ActualUserNameMessage, ExpectedUserNameMessage);
		SSF.getScreenShot(driver, "VerifyUserNameMessage");
	}

	public void MoveToSignInPage() {
		driver.findElement(SignInLink).click();
	}

}
