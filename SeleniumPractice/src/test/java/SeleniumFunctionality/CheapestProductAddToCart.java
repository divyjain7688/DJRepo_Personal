package SeleniumFunctionality;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheapestProductAddToCart {
	
	@Test
	public void verifyCheapestProductAddToCart()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@class=\"submit-button btn_action\"]")).click();
		
		List<WebElement> priceElements= driver.findElements(By.xpath("//div[@class=\"inventory_item\"]//div[@class=\"inventory_item_price\"]"));
		List<Float> prices = new ArrayList<Float>();
		
		for(WebElement priceElement : priceElements)
		{
			prices.add(Float.parseFloat(priceElement.getText().substring(1)));
		}
		for(Float price : prices)
		{
			System.out.println("price is "+ price);
		}
		
		
		Float maxPrice = getMax(prices);
		String maxPriceString = String.valueOf(maxPrice);
		
		driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"][text()='"+maxPriceString+"']/../button")).click();
		
		
		driver.close();
	}
	
	
	public Float getMax(List<Float> prices){
	    Float max = Float.MIN_VALUE;
	    for(int i=0; i<prices.size(); i++){
	        if(prices.get(i) > max){
	            max = prices.get(i);
	        }
	    }
	    return max;
	}

}
