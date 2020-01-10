package com.selenium.ebiz.frequently_purchased;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.FrequentlyPurchasedPage;
import com.selenium.ebiz.pageobject.HomePage;
import com.selenium.ebiz.pageobject.LoginPage;
import com.selenium.ebiz.pageobject.MyAccountPage;

/**
 * @author dj073227
 *
 */
public class FrequentlyPurchasedPageAuthenticatedUser_WORKING extends BaseClass{
	ArrayList<UsersListBean> usersList;
	DBCon dbConnection = new DBCon();
	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	FrequentlyPurchasedPage frequentlyPurchasedPage;
	ArrayList<String> optionsText = new ArrayList<String>();
	List<WebElement> optionsinDropDown;
	String twelveMonthsInOverThePastDropdown= " 12 Months";
	String nineMonthsInOverThePastDropdown= " 9 Months";
	String sixMonthsInOverThePastDropdown= " 6 Months";
	String threeMonthsInOverThePastDropdown= " 3 Months";
	String frequencyInSortByDropdown = " Frequency";
	String quantityInSortByDropdown = " Quantity";
	String totalSpentInSortByDropdown = " Total Spent";


	/**
	 * This test is used to verify that when user logged in and click on my account link,
	 * user should able to navigate to My account page.
	 */
	@BeforeMethod
	public void driverSetup() throws Exception
	{
		driver=initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("verifyLogin","LoginTestData");
		loginPage.clickOnRegisterOrSignIn();
		homePage= loginPage.signInToApplication(usersList.get(0).getuserName(),usersList.get(0).getpassword());
		myAccountPage=homePage.moveToMyAccountPage();
		frequentlyPurchasedPage=myAccountPage.moveToFrequentlyPurchsedPage();
	}


	/** dj073227
	 * US-PostOrd-072 - This method is used to test that logged in user has ability to filter which products 
	 * on the frequently purchased page I want to view.
	 */
	@Test(priority=1)
	public void verifyFrequentlyPurchasedPageFilters()
	{
		Assert.assertTrue(frequentlyPurchasedPage.isStatusFilterDisplayed());
		Assert.assertTrue(frequentlyPurchasedPage.isCategoryFilterDisplayed());
		Assert.assertTrue(frequentlyPurchasedPage.isSubcategoryFilterDisplayed());
		Assert.assertTrue(frequentlyPurchasedPage.isBrandFilterDisplayed());
		String statusFilterActiveValue = frequentlyPurchasedPage.statusFilterActiveValue();
		String displayedFilterValue = frequentlyPurchasedPage.displayedFilterValue();
		Assert.assertTrue(statusFilterActiveValue.contains(displayedFilterValue));
		String eligibleForSbscriptionsFilterFirstValue = frequentlyPurchasedPage.eligibleForSbscriptionsFilterFirstValue();
		frequentlyPurchasedPage.clickOnEligibleForSbscriptionsFilterFirstValueCheckBox();
		displayedFilterValue = frequentlyPurchasedPage.displayedFilterValue();
		Assert.assertTrue(eligibleForSbscriptionsFilterFirstValue.contains(displayedFilterValue));
		frequentlyPurchasedPage.clickOnEligibleForSbscriptionsFilterFirstValueCheckBox();
		String brandFilterFirstValue = frequentlyPurchasedPage.brandFilterFirstValue();
		frequentlyPurchasedPage.clickOnBrandFilterFirstValueCheckBox();
		displayedFilterValue = frequentlyPurchasedPage.displayedFilterValue();
		Assert.assertTrue(brandFilterFirstValue.contains(displayedFilterValue));
		frequentlyPurchasedPage.clickOnBrandFilterFirstValueCheckBox();
		String categoryFilterFirstValue = frequentlyPurchasedPage.categoryFilterFirstValue();
		frequentlyPurchasedPage.clickOnCategoryFilterFirstValueCheckBox();
		displayedFilterValue = frequentlyPurchasedPage.displayedFilterValue();
		Assert.assertTrue(categoryFilterFirstValue.contains(displayedFilterValue));
		frequentlyPurchasedPage.clickOnCategoryFilterFirstValueCheckBox();
		String subcategoryFilterFirstValue = frequentlyPurchasedPage.subcategoryFilterFirstValue();
		frequentlyPurchasedPage.clickOnSubcategoryFilterFirstValueCheckBox();
		displayedFilterValue = frequentlyPurchasedPage.displayedFilterValue();
		Assert.assertTrue(subcategoryFilterFirstValue.contains(displayedFilterValue));
	}

	/**
	 * dj073227 
	 * US-PostOrd-070 - As a user I want the ability to have a My Account page which provides me information 
	 * on products I've frequently purchased.
	 * @throws Exception 
	 */
	@Test(priority=2)	
	public void verifyFrequentlyPurchasedPagePagination() throws Exception
	{
		Assert.assertTrue(frequentlyPurchasedPage.isBreadCrumbDisplayed());
		Assert.assertTrue(frequentlyPurchasedPage.isFrequentlyPurchasedTextDisplayed());
		Assert.assertTrue(frequentlyPurchasedPage.isPaginationformatdisplayed());
		optionsinDropDown=frequentlyPurchasedPage.getOverThePastDropdown();
		for(WebElement we:optionsinDropDown)  
		{  
			optionsText.add(we.getText());
			System.out.println(optionsText);
		} 
		Assert.assertTrue(optionsText.contains(twelveMonthsInOverThePastDropdown));
		Assert.assertTrue(optionsText.contains(nineMonthsInOverThePastDropdown));
		Assert.assertTrue(optionsText.contains(sixMonthsInOverThePastDropdown));
		Assert.assertTrue(optionsText.contains(threeMonthsInOverThePastDropdown));
		Assert.assertTrue(frequentlyPurchasedPage.defaultValueinOverThePastDropdown().contains(twelveMonthsInOverThePastDropdown));
		optionsinDropDown=frequentlyPurchasedPage.getSortByDropdown();
		for(WebElement we:optionsinDropDown)  
		{  
			optionsText.add(we.getText());
			System.out.println(optionsText);
		}   
		Assert.assertTrue(optionsText.contains(frequencyInSortByDropdown));
		Assert.assertTrue(optionsText.contains(quantityInSortByDropdown));
		Assert.assertTrue(optionsText.contains(totalSpentInSortByDropdown));
		Assert.assertTrue(frequentlyPurchasedPage.isSortByTotalSpentValue());
		System.out.println("frequentlyPurchasedPage.isSortByTotalSpentValue()....................");
		Assert.assertTrue(frequentlyPurchasedPage.isSortByQuantityValue());
		Assert.assertTrue(frequentlyPurchasedPage.isSortByFrequencyValue());
		frequentlyPurchasedPage.clickOnNineMonthsInOverThePastDropdown();
		String displayedFilterValue = frequentlyPurchasedPage.displayedFilterValue();
		String  overThePastNineMonthFilterProducts = frequentlyPurchasedPage.overThePastFilterProducts();
		System.out.println("displayedFilterValue is "+ displayedFilterValue+ "   overThePastNineMonthFilterProducts"+overThePastNineMonthFilterProducts);
		Assert.assertTrue(displayedFilterValue.equals(overThePastNineMonthFilterProducts));
		homePage=frequentlyPurchasedPage.navigateToHomePage();
		myAccountPage=homePage.moveToMyAccountPage();
		frequentlyPurchasedPage=myAccountPage.moveToFrequentlyPurchsedPage();

		frequentlyPurchasedPage.clickOnTwelveMonthsInOverThePastDropdown();
		displayedFilterValue = frequentlyPurchasedPage.displayedFilterValue();
		String  overThePastTwelveMonthFilterProducts = frequentlyPurchasedPage.overThePastFilterProducts();
		System.out.println("displayedFilterValue is "+ displayedFilterValue+ "   overThePastTwelveMonthFilterProducts"+overThePastTwelveMonthFilterProducts);
		Assert.assertTrue(displayedFilterValue.equals(overThePastTwelveMonthFilterProducts));
		homePage=frequentlyPurchasedPage.navigateToHomePage();
		myAccountPage=homePage.moveToMyAccountPage();
		frequentlyPurchasedPage=myAccountPage.moveToFrequentlyPurchsedPage();

		frequentlyPurchasedPage.clickOnThreeMonthsInOverThePastDropdown();
		displayedFilterValue = frequentlyPurchasedPage.displayedFilterValue();
		String  overThePastThreeMonthFilterProducts = frequentlyPurchasedPage.overThePastFilterProducts();
		System.out.println("displayedFilterValue is "+ displayedFilterValue+ "   overThePastThreeMonthFilterProducts"+overThePastThreeMonthFilterProducts);
		Assert.assertTrue(displayedFilterValue.equals(overThePastThreeMonthFilterProducts));
		homePage=frequentlyPurchasedPage.navigateToHomePage();
		myAccountPage=homePage.moveToMyAccountPage();
		frequentlyPurchasedPage=myAccountPage.moveToFrequentlyPurchsedPage();

		frequentlyPurchasedPage.clickOnSixMonthsInOverThePastDropdown();
		displayedFilterValue = frequentlyPurchasedPage.displayedFilterValue();
		String  overThePastSixMonthFilterProducts = frequentlyPurchasedPage.overThePastFilterProducts();
		System.out.println("displayedFilterValue is "+ displayedFilterValue+ "   overThePastSixMonthFilterProducts"+overThePastSixMonthFilterProducts);
		Assert.assertTrue(displayedFilterValue.equals(overThePastSixMonthFilterProducts));
		homePage=frequentlyPurchasedPage.navigateToHomePage();
		myAccountPage=homePage.moveToMyAccountPage();
		frequentlyPurchasedPage=myAccountPage.moveToFrequentlyPurchsedPage();
	}

}
