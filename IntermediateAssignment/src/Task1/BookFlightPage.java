package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utility.Screenshotfunction;

public class BookFlightPage {

	WebDriver driver;
	Screenshotfunction SSF = new Screenshotfunction();
	By FlightLink = By.xpath("//a[@href=\"reservation.php\"]");
	By BusinessClassRadioButton = By.xpath("//input[@value=\"Business\"]");
	By FirstClassRadioButton = By.xpath("//input[@value=\"First\"]");
	By ContinueButton = By.xpath("//input[@name=\"findFlights\"]");
	By NoSeatsAvailableText = By
			.xpath("//p[@align=\"left\"]/font[@face=\"Arial, Helvetica, sans-serif\"]/b/font[@size=\"4\"]");
	By BackToHomeText = By.xpath("//font[contains(text(),\"BACK TO HOME\")]");
	By RoundTripRadioButton = By.xpath("//input[@value=\"roundtrip\"]");
	By OnewayTripRadioButton = By.xpath("//input[@value=\"oneway\"]");
	By PassangerCount = By.name("passCount");
	By DepartureFrom = By.name("fromPort");
	By FromMonth = By.name("fromMonth");
	By FromDay = By.name("fromDay");
	By ArrivingTo = By.name("toPort");
	By ToMonth = By.name("toMonth");
	By ToDay = By.name("toDay");
	By Airlines = By.name("airline");

	public BookFlightPage(WebDriver driver) {
		this.driver = driver;
	}

	public void FirstFlightBooking(String StrNumberOfPessangerDropdown,
			String StrDepartingFromDropdown, String StrFromMonthDropdown,
			String StrFromDayDropdownn, String StrArrivingToDropdown,
			String StrToMonthDropdown, String StrToDayDropdownn,
			String StrAirlinesDropdown) throws Exception {
		driver.findElement(FlightLink).click();
		driver.findElement(RoundTripRadioButton).click();
		Select NumberOfPessangerDropdown = new Select(
				driver.findElement(PassangerCount));
		NumberOfPessangerDropdown
				.selectByVisibleText(StrNumberOfPessangerDropdown);
		Select DepartingFromDropdown = new Select(
				driver.findElement(DepartureFrom));
		DepartingFromDropdown.selectByVisibleText(StrDepartingFromDropdown);
		Select FromMonthDropdown = new Select(driver.findElement(FromMonth));
		FromMonthDropdown.selectByVisibleText(StrFromMonthDropdown);
		Select FromDayDropdownn = new Select(driver.findElement(FromDay));
		FromDayDropdownn.selectByVisibleText(StrFromDayDropdownn);
		Select ArrivingToDropdown = new Select(driver.findElement(ArrivingTo));
		ArrivingToDropdown.selectByVisibleText(StrArrivingToDropdown);
		Select ToMonthDropdown = new Select(driver.findElement(ToMonth));
		ToMonthDropdown.selectByVisibleText(StrToMonthDropdown);
		Select ToDayDropdownn = new Select(driver.findElement(ToDay));
		ToDayDropdownn.selectByVisibleText(StrToDayDropdownn);
		driver.findElement(BusinessClassRadioButton).click();
		Select AirlinesDropdown = new Select(driver.findElement(Airlines));
		AirlinesDropdown.selectByVisibleText(StrAirlinesDropdown);
		SSF.getScreenShot(driver, "details of first flight booking");
		driver.findElement(ContinueButton).click();

	}

	public void SecondFlightBooking(String StrNumberOfPessangerDropdown,
			String StrDepartingFromDropdown, String StrFromMonthDropdown,
			String StrFromDayDropdownn, String StrArrivingToDropdown,
			String StrAirlinesDropdown) throws Exception {

		driver.findElement(FlightLink).click();
		driver.findElement(OnewayTripRadioButton).click();
		Select NumberOfPessangerDropdown = new Select(
				driver.findElement(PassangerCount));
		NumberOfPessangerDropdown
				.selectByVisibleText(StrNumberOfPessangerDropdown);
		Select DepartingFromDropdown = new Select(
				driver.findElement(DepartureFrom));
		DepartingFromDropdown.selectByVisibleText(StrDepartingFromDropdown);
		Select FromMonthDropdown = new Select(driver.findElement(FromMonth));
		FromMonthDropdown.selectByVisibleText(StrFromMonthDropdown);
		Select FromDayDropdownn = new Select(driver.findElement(FromDay));
		FromDayDropdownn.selectByVisibleText(StrFromDayDropdownn);
		Select ArrivingToDropdown = new Select(driver.findElement(ArrivingTo));
		ArrivingToDropdown.selectByVisibleText(StrArrivingToDropdown);
		driver.findElement(FirstClassRadioButton).click();
		Select AirlinesDropdown = new Select(driver.findElement(Airlines));
		AirlinesDropdown.selectByVisibleText(StrAirlinesDropdown);
		SSF.getScreenShot(driver, "details of second flight booking");
		driver.findElement(ContinueButton).click();

	}

	public void VerifyNoSeatsAvailableMessage() throws Exception {
		String ExpectedNoSeatsAvailableText = "After flight finder - No Seats Avaialble  ";
		String ActualNoSeatsAvailableText = driver.findElement(
				NoSeatsAvailableText).getText();
		System.out.println("ExpectedNoSeatsAvailableText"
				+ ExpectedNoSeatsAvailableText);
		System.out.println("ActualNoSeatsAvailableTex"
				+ ActualNoSeatsAvailableText);
		Assert.assertEquals(ActualNoSeatsAvailableText,
				ExpectedNoSeatsAvailableText);
		SSF.getScreenShot(driver, "VerifyNoSeatsAvailableMessage");
	}

	public void VerifyBackToHomeMessage() throws Exception {
		String ExpectedBackToHomeText = "Please press your browser's back button to return to the previous page or click the \"BACK TO HOME\" icon below to go to the homepage.";
		String ActualBackToHomeText = driver.findElement(BackToHomeText)
				.getText();
		System.out.println("ExpectedBackToHomeText" + ExpectedBackToHomeText);
		System.out.println("ActualBackToHomeText" + ActualBackToHomeText);
		Assert.assertEquals(ActualBackToHomeText, ExpectedBackToHomeText);
		SSF.getScreenShot(driver, "VerifyBackToHomeMessage");

	}

}
