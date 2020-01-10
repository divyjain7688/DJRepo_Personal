package com.selenium.ebiz.account_management.login;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;

public class ExploreHDSupplyIndustyTypeDropdown_NOTWORKING extends BaseClass{

	HomePage homePage;
	DBCon dbConnection;
	ArrayList<UsersListBean> usersList;	
	List<WebElement> accountLabelsList;
	LoginPage loginPage;

	@BeforeMethod	
	public void driverSetup() throws Exception {
		driver = initialize();	
		loginPage = new LoginPage(driver);
		homePage = loginPage.loginToHdSupplySite(prop.getProperty("username"),prop.getProperty("password"));
		dbConnection = new DBCon();		
	}

	/** Divy Jain : reviewed and updated. Not able to see any dropdown on homepage so commenting the code
	 * 
	 *@storyDescription : To verify the explore hd supply industry type dropdown options and when user selects any specific industry from dropdown menu
	 * all content below this section changes to adapt to the content related to the Industry selected.
	 * @US :US-Cat-233
	 * @author lakshmi
	 * */
	/*		
	@Test
	public void verifyExploreHDSupplyIndustyTypeDropdownList() throws Exception {		
		//Assert.assertTrue(homePage.isDisplayedexploreHDSupplyDropDown());
		usersList = dbConnection.loadDataFromExcel("verifyExploreHDSupplyDropdownList","HomePage");
		//verify the options available in industry type dropdown.
		Assert.assertTrue(homePage.verifyexploreHDSupplyDropDownOptions(usersList.get(0).getIndustryType()));
		String[] colonArray = usersList.get(0).getIndustryType().split(":");
		homePage.selectOptionsFromIndustryTypeDowndown(colonArray[2]);
		//after dropdown content not displaying.
	}*/

}
