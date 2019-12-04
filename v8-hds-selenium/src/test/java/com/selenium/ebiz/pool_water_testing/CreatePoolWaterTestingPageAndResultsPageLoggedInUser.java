package com.selenium.ebiz.pool_water_testing;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class CreatePoolWaterTestingPageAndResultsPageLoggedInUser extends BaseClassV8_ParallelGrid{
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-387, W80-7273, W80-3749, W80-3745
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")
	public void pwt_VerifyMandatoryAttributesForLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		Assert.assertTrue(pageManager.poolWaterTesting().isPoolWaterTestingHeaderDisplayed());
		Assert.assertTrue(pageManager.poolWaterTesting().areMandatoryFieldsDisplayed());

	}

	@Test(dataProvider = "browsers")
	public void pwt_VerifyCreatePoolWaterTestingPageAndResultsPageForGallonsLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		usersList = pageManager.dBCon().loadDataFromExcel("enterValidDataForGallon", "PoolWaterTest");
		pageManager.poolWaterTesting().enterDataToGetRecommendProductsForGallons(usersList.get(0).getPoolVolume(),usersList.get(0).getPoolVolumeDropdown(),
				usersList.get(0).getFreeChlorine(),usersList.get(0).getPH(),usersList.get(0).getTotalHardness(),usersList.get(0).getTotalAlkalinity(),
				usersList.get(0).getTotalChlorine(),usersList.get(0).getCyanuricAcid());
		Assert.assertTrue(pageManager.poolWaterTesting().isListOfrecommendedProductsDisplayed());
		Assert.assertTrue(pageManager.poolWaterTesting().dataPoolSnapshot.isDisplayed());	

	}
	
	@Test(dataProvider = "browsers")
	public void pwt_VerifyCreatePoolWaterTestingPageAndResultsPageForLitersLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		usersList = pageManager.dBCon().loadDataFromExcel("enterValidDataForLiter", "PoolWaterTest");
		pageManager.poolWaterTesting().enterDataToGetRecommendProductsForLiters(usersList.get(0).getPoolVolume(),usersList.get(0).getPoolVolumeDropdown(),
				usersList.get(0).getFreeChlorine(),usersList.get(0).getPH(),usersList.get(0).getTotalHardness(),usersList.get(0).getTotalAlkalinity(),
				usersList.get(0).getTotalChlorine(),usersList.get(0).getCyanuricAcid());
		Assert.assertTrue(pageManager.poolWaterTesting().isListOfrecommendedProductsDisplayed());
		Assert.assertTrue(pageManager.poolWaterTesting().dataPoolSnapshot.isDisplayed());
		Assert.assertTrue(pageManager.poolWaterTesting().emailAndPrintAtBottomOfPage.isDisplayed());
		Assert.assertTrue(pageManager.poolWaterTesting().emailAndPrintAtTopOfPage.isDisplayed());

		

	}
	
	
	@Test(dataProvider = "browsers")
	public void pwt_VerifyErrorMessageOnPoolWaterTestLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		usersList = pageManager.dBCon().loadDataFromExcel("enterInvalidData", "PoolWaterTest");
		Assert.assertTrue(pageManager.poolWaterTesting().enterInvalidDataAndVerifyErrors(usersList.get(0).getPoolVolume(), usersList.get(0).getFreeChlorine(), usersList.get(0).getPH()));
		
	}
	
	
	@Test(dataProvider = "browsers")
	public void pwt_VerifyAddToCartFromRecommendedProductLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		usersList = pageManager.dBCon().loadDataFromExcel("enterValidDataForLiter", "PoolWaterTest");
		pageManager.poolWaterTesting().enterDataToGetRecommendProductsForLiters(usersList.get(0).getPoolVolume(),usersList.get(0).getPoolVolumeDropdown(),
				usersList.get(0).getFreeChlorine(),usersList.get(0).getPH(),usersList.get(0).getTotalHardness(),usersList.get(0).getTotalAlkalinity(),
				usersList.get(0).getTotalChlorine(),usersList.get(0).getCyanuricAcid());
		String partNumber = pageManager.poolWaterTesting().getPartNumberOfOneRecommendedPartAndClickAddToCart();
		pageManager.homePage().clickOnShoppingCartIcon();
		Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(partNumber));
	}
	
	@Test(dataProvider = "browsers")
	public void pwt_VerifyAddToQuoteFromRecommendedProductLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		usersList = pageManager.dBCon().loadDataFromExcel("enterValidDataForLiter", "PoolWaterTest");
		pageManager.poolWaterTesting().enterDataToGetRecommendProductsForLiters(usersList.get(0).getPoolVolume(),usersList.get(0).getPoolVolumeDropdown(),
				usersList.get(0).getFreeChlorine(),usersList.get(0).getPH(),usersList.get(0).getTotalHardness(),usersList.get(0).getTotalAlkalinity(),
				usersList.get(0).getTotalChlorine(),usersList.get(0).getCyanuricAcid());
		String partNumber = pageManager.poolWaterTesting().getPartNumberOfOneRecommendedPartAndClickAddToQuote();
		String quoteName = pageManager.addToExistingORCreateNewQUOTE_modal().addItemToNewQuote();
		pageManager.common().refresh();
		pageManager.homePage().clickQuotesUtilityBar();
		pageManager.quoteListsPage().clickOnFirstQuoteName();
		Assert.assertTrue(pageManager.quotesPriceDetailPage().isAddedpartNumberIsDisplayedOnPriceQuotepage(partNumber));
	}
	
	@Test(dataProvider = "browsers")
	public void pwt_VerifyAddToListFromRecommendedProductGuestUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.shoppingCartPage().checkClearShoppingCart();
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		usersList = pageManager.dBCon().loadDataFromExcel("enterValidDataForLiter", "PoolWaterTest");
		pageManager.poolWaterTesting().enterDataToGetRecommendProductsForLiters(usersList.get(0).getPoolVolume(),usersList.get(0).getPoolVolumeDropdown(),
				usersList.get(0).getFreeChlorine(),usersList.get(0).getPH(),usersList.get(0).getTotalHardness(),usersList.get(0).getTotalAlkalinity(),
				usersList.get(0).getTotalChlorine(),usersList.get(0).getCyanuricAcid());
		String partNumber = pageManager.poolWaterTesting().getPartNumberOfOneRecommendedPartAndClickAddToList();
		pageManager.addToExistingORCreateNewList_modal().createNewListInAddToListModal();
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		pageManager.savedListsPage().clickFirstSavedListNameLinkText();
		Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(partNumber));
	}
	
	
	@Test(dataProvider = "browsers")
	public void pwt_VerifyNavigateToPDPFromRecommendedProductLoggedInUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		usersList = pageManager.dBCon().loadDataFromExcel("enterValidDataForLiter", "PoolWaterTest");
		pageManager.poolWaterTesting().enterDataToGetRecommendProductsForLiters(usersList.get(0).getPoolVolume(),usersList.get(0).getPoolVolumeDropdown(),
				usersList.get(0).getFreeChlorine(),usersList.get(0).getPH(),usersList.get(0).getTotalHardness(),usersList.get(0).getTotalAlkalinity(),
				usersList.get(0).getTotalChlorine(),usersList.get(0).getCyanuricAcid());
		pageManager.poolWaterTesting().clickOnproductNameOfecommendedPartNumbers();
		Assert.assertTrue(pageManager.productDetailsPage().isDisplayedproductDetailsHeader());
		
	}
	
	
}
