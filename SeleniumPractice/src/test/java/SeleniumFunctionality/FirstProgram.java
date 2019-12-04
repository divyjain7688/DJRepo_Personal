package SeleniumFunctionality;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;


public class FirstProgram {
	 public static void main(String[] args) {
      //   System.setProperty("webdriver.gecko.driver","S:\\AppDev\\QA\\ESP\\geckodriver.exe");

	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	String open = "https://www.flipkart.com";
	driver.get(open);
		
	WebElement SearchProduct = driver.findElement(By.xpath("//input[@placeholder=\"Search for Products, Brands and More\"]"));
	SearchProduct.sendKeys("sony led 32 inch");
	WebElement SearchButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
	SearchButton.click();
	
	WebElement FirstProduct = driver.findElement(By.xpath("//img[@src=\"https://rukminim1.flixcart.com/image/312/312/television/u/n/n/sony-klv-32w512d-original-imaes7d3hg2b6vkf.jpeg?q=70\"]"));
	FirstProduct.click();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

	
	WebElement ProductPrice = driver.findElement(By.xpath("//div[@class=\"_1vC4OE _37U4_g\"]"));
	String ProductPriceText = ProductPrice.getText();
	System.out.println("ProductPriceText"+ProductPriceText);
	WebElement ProductName = driver.findElement(By.xpath("//h1[@class=\"_3eAQiD\"]"));
	String ProductNameText = ProductName.getText();
	System.out.println("ProductNameText"+ProductNameText);
	
//	WebElement AddToCartButton = driver.findElement(By.xpath("//button[Text()=\"ADD TO CART\"]"));
	WebElement AddToCartButton = driver.findElement(By.xpath("//button[@class=\"_2AkmmA _2Npkh4 _2MWPVK\"]"));

	
	AddToCartButton.click();
	
	
	WebElement ProductPriceOnCart = driver.findElement(By.xpath("//div[@class=\"I8hxu4\"]"));
	String ProductPriceOnCartText = ProductPriceOnCart.getText();
	System.out.println("ProductPriceOnCartText"+ProductPriceOnCartText);
	WebElement ProductName1OnCart = driver.findElement(By.xpath("//div[@class=\"_1Ox9a7\"]"));
	String ProductName1OnCartText = ProductName1OnCart.getText();
	WebElement ProductName2OnCart = driver.findElement(By.xpath("//div[@class=\"v7-Wbf\"]"));
	String ProductName2OnCartText = ProductName2OnCart.getText();
	String ProductNameOnCartText = ProductName1OnCartText + "  (" + ProductName2OnCartText+")";
	System.out.println("ProductNameOnCartText"+ProductNameOnCartText);
	
	
	
	if(ProductPriceText.equals(ProductPriceOnCartText) && ProductNameText.equals(ProductNameOnCartText))
	{
	System.out.println("Test case passed");
	}
	else
	{
		System.out.println("Test case failed");	
	}
	driver.close();
	
}
}