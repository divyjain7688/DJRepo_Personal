package com.selenium.ebiz.email_and_print_pages;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerifyNewEmailFields extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;

    /**
     * verify email Link is displayed and click on email link
     * This Test script is mapped to US-Cat-153
     * Reviewed and modified by Bhavani
	 * Removed unrelated to email tests
     */
	
	@Test(dataProvider = "browsers", enabled = false)
	public void emailPage_FillOutEmailFields(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		pageManager.commonPageObjects().emailPageLink.click();
		pageManager.eMailPage().isDisplayedEmailPageTitle();
		usersList=pageManager.dBCon().loadDataFromExcel("sendQuotesPricePage","EMail");
		pageManager.eMailPage().fillOutEmailFields(usersList.get(0).getEMail(),usersList.get(0).getMessage());
	}


}
