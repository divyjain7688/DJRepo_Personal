package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.InputDataProvider;
import Utility.Screenshotfunction;

public class TestWorkflow extends InputDataProvider {
	WebDriver driver;
	RegiterPage ObjRegiterPage;
	SignIn ObjSignIn;
	BookFlightPage ObjBookFlightPage;
	Screenshotfunction SSF = new Screenshotfunction();

	@DataProvider(name = "RegistrationInputData")
	public Object[][] RegistrationInputData() throws Exception {
		Object[][] data = testdata("RegistrationPage");
		System.out.println("data is " + data);
		return data;
	}

	@DataProvider(name = "FirstFlightBookingInputData")
	public Object[][] FirstFlightBookingInputData() throws Exception {
		Object[][] data = testdata("FirstFlightBooking");
		System.out.println("data is " + data);
		return data;
	}

	@DataProvider(name = "SecondFlightBookingInputData")
	public Object[][] SecondFlightBookingInputData() throws Exception {
		Object[][] data = testdata("SecondFlightBooking");
		System.out.println("data is " + data);
		return data;
	}

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/selenium/newtours/index.php");
		driver.findElement(
				By.xpath("//a[@href=\"register.php\"][text()=\"REGISTER\"]"))
				.click();
	}

	@Test(priority = 0, dataProvider = "RegistrationInputData")
	public void Registration(String strFirstName, String strLastName,
			String strAddress, String strCity, String strUSerName,
			String strPassword, String strConfirmPassword) throws Exception

	{
		ObjRegiterPage = new RegiterPage(driver);
		ObjRegiterPage.FillRegisterForm(strFirstName, strLastName, strAddress,
				strCity, strUSerName, strPassword, strConfirmPassword);

		ObjRegiterPage.VerifyThankyouMessage();
		ObjRegiterPage.VerifyUserNameMessage("divyjain");

		ObjRegiterPage.MoveToSignInPage();
		ObjSignIn = new SignIn(driver);
		ObjSignIn.fillSignInForm(strUSerName, strPassword);
		ObjSignIn.verifyLoginSuccessful();

	}	

	@Test(priority = 1, dataProvider = "FirstFlightBookingInputData")
	public void BookFirstFlight(String StrNumberOfPessangerDropdown,
			String StrDepartingFromDropdown, String StrFromMonthDropdown,
			String StrFromDayDropdownn, String StrArrivingToDropdown,
			String StrToMonthDropdown, String StrToDayDropdownn,
			String StrAirlinesDropdown) throws Exception {
		ObjBookFlightPage = new BookFlightPage(driver);
		ObjBookFlightPage.FirstFlightBooking(StrNumberOfPessangerDropdown,
				StrDepartingFromDropdown, StrFromMonthDropdown,
				StrFromDayDropdownn, StrArrivingToDropdown, StrToMonthDropdown,
				StrToDayDropdownn, StrAirlinesDropdown);
		ObjBookFlightPage.VerifyNoSeatsAvailableMessage();
		ObjBookFlightPage.VerifyBackToHomeMessage();

	}

	@Test(priority = 2, dataProvider = "SecondFlightBookingInputData")
	public void BookSecondFlight(String StrNumberOfPessangerDropdown,
			String StrDepartingFromDropdown, String StrFromMonthDropdown,
			String StrFromDayDropdownn, String StrToDayDropdownn,
			String StrAirlinesDropdown) throws Exception {
		ObjBookFlightPage = new BookFlightPage(driver);
		ObjBookFlightPage.SecondFlightBooking(StrNumberOfPessangerDropdown,
				StrDepartingFromDropdown, StrFromMonthDropdown,
				StrFromDayDropdownn, StrToDayDropdownn, StrAirlinesDropdown);
		ObjBookFlightPage.VerifyNoSeatsAvailableMessage();
		ObjBookFlightPage.VerifyBackToHomeMessage();

	}

	@AfterTest
	public void CloseBrowser() {
		driver.close();
	}

}
