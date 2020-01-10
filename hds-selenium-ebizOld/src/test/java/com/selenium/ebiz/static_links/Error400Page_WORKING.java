package com.selenium.ebiz.static_links;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;

public class Error400Page_WORKING extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;

	@BeforeMethod	
	public void driverSetup() throws MalformedURLException {
		driver= initialize();
		homePage = new HomePage(driver);

	}	

	/**
	 * a user will see the error page 400- Bad Request- 
	 * error when the link is broken. Bad request!Error code: 400It's not you, it's us. This link appears to be broken and needs fixing.
	 * 
	 * US-Acct-341
	 * 
	 * @author nd065733
	 *  
	 */

	@Test
	public void verify400ErrorPage() throws Exception {

		Assert.assertTrue(homePage.getWelcomeNote().contains("Create an account"));

		/*Used tagName method to collect the list of items with tagName "a"
		 findElements - to find all the elements with in the current page. It returns a list of all webelements or an empty list if nothing matches*/


		List<WebElement> links = driver.findElements(By.tagName("a")); 

		//To print the total number of links
		System.out.println("Total links are "+links.size()); 

		//used for loop to get URLs

		for(int i=0; i<links.size(); i++) {

			WebElement element = links.get(i);

			//By using "href" attribute, we could get the url of the requried link

			String url =element.getAttribute("href");

			//calling verifyLink() method here. Passing the parameter as url which we collected in the above link
			homePage.verifyLink(url);
			System.out.println(url);

		}}

}	





