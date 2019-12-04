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

public class CreatePoolWaterTestingPageAndResultsPageGuestUser extends BaseClassV8_ParallelGrid{
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-387, W80-7273, W80-3749, W80-3745
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers")
	public void pwt_VerifyMandatoryAttributesForGuestUer(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		Assert.assertTrue(pageManager.poolWaterTesting().isPoolWaterTestingHeaderDisplayed());
		Assert.assertTrue(pageManager.poolWaterTesting().areMandatoryFieldsDisplayed());

	}

	@Test(dataProvider = "browsers")
	public void pwt_VerifyCreatePoolWaterTestingPageAndResultsPageForGallonsGuestUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
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
	public void pwt_VerifyCreatePoolWaterTestingPageAndResultsPageForLitersGuestUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
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
	public void pwt_VerifyErrorMessageOnPoolWaterTestGuestUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		usersList = pageManager.dBCon().loadDataFromExcel("enterInvalidData", "PoolWaterTest");
		Assert.assertTrue(pageManager.poolWaterTesting().enterInvalidDataAndVerifyErrors(usersList.get(0).getPoolVolume(), usersList.get(0).getFreeChlorine(), usersList.get(0).getPH()));
		
	}
	
	
	@Test(dataProvider = "browsers")
	public void pwt_VerifyAddToCartFromRecommendedProductGuestUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
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
	public void pwt_VerifyAddToQuoteFromRecommendedProductGuestUser(String browser, String version, String os, Method method) throws Exception {
		String list = "List_";
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
        pageManager.shoppingCartPage().checkClearShoppingCart();
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		usersList = pageManager.dBCon().loadDataFromExcel("enterValidDataForLiter", "PoolWaterTest");
		pageManager.poolWaterTesting().enterDataToGetRecommendProductsForLiters(usersList.get(0).getPoolVolume(),usersList.get(0).getPoolVolumeDropdown(),
				usersList.get(0).getFreeChlorine(),usersList.get(0).getPH(),usersList.get(0).getTotalHardness(),usersList.get(0).getTotalAlkalinity(),
				usersList.get(0).getTotalChlorine(),usersList.get(0).getCyanuricAcid());
		pageManager.poolWaterTesting().getPartNumberOfOneRecommendedPartAndClickAddToQuoteGuestUser();
		Assert.assertTrue(pageManager.signInOrRegisterPage().isSignInOrRegisterTitleDisplayed());
	}
	

	@Test(dataProvider = "browsers")
	public void pwt_VerifyAddToListFromRecommendedProductGuestUser(String browser, String version, String os, Method method) throws Exception {
		String list = "List_";
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
        pageManager.shoppingCartPage().checkClearShoppingCart();
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		usersList = pageManager.dBCon().loadDataFromExcel("enterValidDataForLiter", "PoolWaterTest");
		pageManager.poolWaterTesting().enterDataToGetRecommendProductsForLiters(usersList.get(0).getPoolVolume(),usersList.get(0).getPoolVolumeDropdown(),
				usersList.get(0).getFreeChlorine(),usersList.get(0).getPH(),usersList.get(0).getTotalHardness(),usersList.get(0).getTotalAlkalinity(),
				usersList.get(0).getTotalChlorine(),usersList.get(0).getCyanuricAcid());
		pageManager.poolWaterTesting().getPartNumberOfOneRecommendedPartAndClickAddToListGuesUser();
		Assert.assertTrue(pageManager.signInOrRegisterPage().isSignInOrRegisterTitleDisplayed());
	}
	
	
	@Test(dataProvider = "browsers")
	public void pwt_VerifyNavigateToPDPFromRecommendedProductGuestUser(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.homePage().navigateToPoolCareAndMaintenance();
		pageManager.poolCareAndMaintenance().clickOnPoolWaterTestingToolLink();
		usersList = pageManager.dBCon().loadDataFromExcel("enterValidDataForLiter", "PoolWaterTest");
		pageManager.poolWaterTesting().enterDataToGetRecommendProductsForLiters(usersList.get(0).getPoolVolume(),usersList.get(0).getPoolVolumeDropdown(),
				usersList.get(0).getFreeChlorine(),usersList.get(0).getPH(),usersList.get(0).getTotalHardness(),usersList.get(0).getTotalAlkalinity(),
				usersList.get(0).getTotalChlorine(),usersList.get(0).getCyanuricAcid());
		pageManager.poolWaterTesting().clickOnproductNameOfecommendedPartNumbersGuestUser();
		Assert.assertTrue(pageManager.productDetailsPage().isDisplayedproductDetailsHeader());
		
	}
	
	
}
