package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

@FindBy(xpath = "//table//tr[@class='heading3']")
WebElement HomepageUsername;
WebDriver driver;



public Homepage(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver, this);
}

public void VerifyHomepageusername()
{
	System.out.println(HomepageUsername.getText());
}

}
