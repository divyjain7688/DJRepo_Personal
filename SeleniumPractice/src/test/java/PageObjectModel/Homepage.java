package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	WebDriver driver;
By HomepageUsername = By.xpath("//table//tr[@class='heading3']");

public Homepage(WebDriver driver)
{
	this.driver= driver;
}

public void VerifyHomepageusername()
{
	System.out.println(driver.findElement(HomepageUsername).getText());
}

}
