package com.selenium.ebiz.search;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifySortingBasedOnPopularityRanking extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-545, ALM Test ID: 663235
	 */

	private ArrayList<UsersListBean> usersList;
	String relevance = "Relevance";
	String topSellers = "Top Sellers";
	
	@Test(dataProvider = "browsers")
	public void search_VerifySortByFunctionalityLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
    	usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
		Assert.assertTrue(pageManager.productListingPage().getFirstOptionFromSortByDropDown().equals(relevance));
		Assert.assertTrue(pageManager.productListingPage().getSortByDropDownList().contains(topSellers));
		
	}
	

	@Test(dataProvider = "browsers")
	public void search_VerifyProductcountWithDifferentSortByAttributeLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
    	usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
    	pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
    	Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Relevance"));
    	Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Brand"));
    	Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Product Name"));
    	Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Price: Low to High"));
    	Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Price: High to Low"));
    	Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Top Sellers"));
    	//Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Country of Origin"));
		
	}
	
	@Test(dataProvider = "browsers")
	public void search_VerifyNavigationToPDPAndCompareItemsPageLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
    	usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
    	pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
    	pageManager.productListingPage().clickFirstProductInProductList();
    	pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
    	pageManager.productDetailsPage().PageNavigateBack();
    	pageManager.productListingPage().clickonFirstCheckbox();
    	pageManager.productListingPage().clickonSecondCheckbox();
    	pageManager.productListingPage().clickonThirdCheckbox();
    	pageManager.productListingPage().clickonFourthCheckbox();
    	pageManager.productListingPage().clickCompareTheseButton();
    	pageManager.compareTheseItems().backToPLPPageButton.click();
     	Assert.assertTrue(pageManager.productListingPage().isSortByLabelDisplayed());
	}
	
	@Test(dataProvider = "browsers")
	public void search_VerifySortByFunctionalityGuestUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
    	usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
		Assert.assertTrue(pageManager.productListingPage().getFirstOptionFromSortByDropDown().equals(relevance));
		Assert.assertTrue(pageManager.productListingPage().getSortByDropDownList().contains(topSellers));
		
	}
	

	@Test(dataProvider = "browsers")
	public void search_VerifyProductcountWithDifferentSortByAttributeGuestUser(String browser, String version, String os, Method method) throws Exception {
		
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
    	usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
    	pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
      	Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Relevance"));
    	Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Brand"));
    	Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Product Name"));
    	Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Price: Low to High"));
    	Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Price: High to Low"));
    	Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Top Sellers"));
    	//Assert.assertTrue(pageManager.productListingPage().selectAttributeFromSortByDropDown("Country of Origin"));
		
	}
	
	@Test(dataProvider = "browsers")
	public void search_VerifyNavigationToPDPAndCompareItemsPageGuestUser(String browser, String version, String os, Method method) throws Exception {
		
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
    	usersList = pageManager.dBCon().loadDataFromExcel("searchByKeywordOrPartNumber", "Search");
    	pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
    	pageManager.productListingPage().clickFirstProductInProductList();
    	pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
    	pageManager.productDetailsPage().PageNavigateBack();
    	pageManager.productListingPage().clickonFirstCheckbox();
    	pageManager.productListingPage().clickonSecondCheckbox();
    	pageManager.productListingPage().clickonThirdCheckbox();
    	pageManager.productListingPage().clickonFourthCheckbox();
    	pageManager.productListingPage().clickCompareTheseButton();
    	pageManager.compareTheseItems().backToPLPPageButton.click();
     	Assert.assertTrue(pageManager.productListingPage().isSortByLabelDisplayed());
	}
}
