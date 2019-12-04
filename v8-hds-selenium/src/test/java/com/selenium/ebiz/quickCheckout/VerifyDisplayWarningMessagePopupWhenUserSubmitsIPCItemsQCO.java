package com.selenium.ebiz.quickCheckout;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

public class VerifyDisplayWarningMessagePopupWhenUserSubmitsIPCItemsQCO extends BaseClassV8_ParallelGrid {
	/*
    @designed by: Divy 
    mapped with: W80-5951/FMQAECOMM-720
	 */
	
	private ArrayList<UsersListBean> usersList;
	public String newListName = "List_",newlistcreated;
	@Test(dataProvider="browsers",enabled =false)
	//blocked because of defect W80-7644
	public void quickCheckout_VerifyDisplayWarningMessagePopupWhenUserSubmitsIPCItemsQCO(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().headerQuickOrderLinkText.click();
		usersList = pageManager.dBCon().loadDataFromExcel("addPeachtreeProductsUsingQuickOrder", "QuickOrder");
		pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(), usersList.get(0).getQuantity1());
		pageManager.quickOrderPad().quickCheckoutButton.click();
		pageManager.quickCheckout().clickOnCustomizeThisItemLink();
		pageManager.customizeConfigModal().customizeWithPeachTreeProductSimple();
		pageManager.quickCheckout().youHaveCustomizedThisItem.isDisplayed();
		pageManager.quickCheckout().submitSecureOrder();
	}
}
