package com.selenium.ebiz.search;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ValidatePartsLinkSearch extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Iuliia
    mapped with: W80-6901
	 */

	private ArrayList<UsersListBean> usersList;
	@Test(dataProvider = "browsers")
	public void search_ValidatePartsLinkValidSearch(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.homePage().isDisplayedHeaderHDLogoImage();
		pageManager.homePage().headerPartsLink.click();
		pageManager.partsLinkPage().isPartsLinkPageTitleDisplayed();
		usersList = pageManager.dBCon().loadDataFromExcel("searchByPartsLinkModel", "Search");
		Log.info("search model:  " + usersList.get(0).getSearchProductPartNumber());
		pageManager.partsLinkPage().searchByInputOnPartsLinkPage(usersList.get(0).getSearchProductPartNumber());
		pageManager.partsLinkPage().isMaytagModelNumberDisplayed();
		Assert.assertTrue(pageManager.partsLinkPage().maytagModelNumber.getText().contains(usersList.get(0).getSearchProductPartNumber()));
		Assert.assertTrue(pageManager.partsLinkPage().productsDiagramCarousel.isDisplayed());
	}

    @Test(dataProvider = "browsers")
    public void search_ValidatePartsLinkWithInvalidSearch(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.homePage().isDisplayedHeaderHDLogoImage();
        pageManager.homePage().headerPartsLink.click();
        pageManager.partsLinkPage().isPartsLinkPageTitleDisplayed();
        usersList = pageManager.dBCon().loadDataFromExcel("noSearchResult", "Search");
        Log.info("invalid search model:  " + usersList.get(0).getSearchProductKeyword());
        pageManager.partsLinkPage().searchByInputOnPartsLinkPage(usersList.get(0).getSearchProductKeyword());
        Assert.assertTrue(pageManager.partsLinkPage().invalidSearchResultText.isDisplayed());

    }

}
