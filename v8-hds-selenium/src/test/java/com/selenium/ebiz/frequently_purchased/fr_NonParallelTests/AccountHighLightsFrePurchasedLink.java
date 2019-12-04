package com.selenium.ebiz.frequently_purchased.fr_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountHighLightsFrePurchasedLink extends BaseClassV8_Parallel {

	/*HomePage homePage;
	LoginPage loginPage;
	DBCon dbConnection;
	FrequentlyPurchasedPage frequentlyPurchasedPage;

	@BeforeMethod	
	public void driverSetup() throws MalformedURLException, Exception {
		driver = initialize(); waitTool = new WaitTool();		
		loginPage = new LoginPage(driver);
		dbConnection = new DBCon();	
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"), prop.getProperty("password"));
	}	*/

    /**
     * @throws Exception UserStory : US-238
     *                   To verify when clicked on FrequentlyPurchased link from the account highlights, User should be taken to Frequently Purchased page
     * @throws
     * @author lakshmi
     */

    @Test(priority = 0, description = "Login")
    public void test_Login() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
    }

    @Test(priority = 1, description = "Verify Frequently Purchased Link")
    public void verifyFrequentlyPurchaseLink() throws Exception {

        //click on frequently purchased
        pageManager.homePage().clickFrePurchasedUtilityBar();
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().getFrequentlyPurchasedpageHeadingText().equalsIgnoreCase("FREQUENTLY PURCHASED"));
    }

}
