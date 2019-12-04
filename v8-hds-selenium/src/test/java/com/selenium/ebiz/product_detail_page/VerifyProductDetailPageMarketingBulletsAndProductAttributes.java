package com.selenium.ebiz.product_detail_page;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyProductDetailPageMarketingBulletsAndProductAttributes extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy Jain
    mapped with: FMQAECOMM-481
    ALM Test ID: 654941
	 */

	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers", enabled = false)

	public void pdp_VerifyProductDetailPageMarketingBulletsAndProductAttributes(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartNumberWithWarranty", "Search");
		pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().isBreadcrumbDisplayed();
		pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
		pageManager.productDetailsPage().isProductAttributesAndMaketingBulletsDisplayed();
		pageManager.productDetailsPage().warrantyLink.isDisplayed();
		pageManager.productDetailsPage().clickOnWarrantyLink();
		pageManager.productDetailsPage().specificationsLink.isDisplayed();
		pageManager.productDetailsPage().packagingDimensionsSection.isDisplayed();
		pageManager.productDetailsPage().makeAndModelSection.isDisplayed();
		pageManager.productDetailsPage().specificationsSection.isDisplayed();
		pageManager.productDetailsPage().productFeaturesSection.isDisplayed();
		pageManager.productDetailsPage().certificationsAndStandardsSection.isDisplayed();
		pageManager.productDetailsPage().clickOnHDSupplyLogoInHeader();
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductPartNumber());
		pageManager.productDetailsPage().isBreadcrumbDisplayed();
		pageManager.productDetailsPage().isDisplayedproductDetailsHeader();
		pageManager.productDetailsPage().isProductAttributesAndMaketingBulletsDisplayed();
		Assert.assertTrue(pageManager.productDetailsPage().warrantyLink.isDisplayed());
	}
}
