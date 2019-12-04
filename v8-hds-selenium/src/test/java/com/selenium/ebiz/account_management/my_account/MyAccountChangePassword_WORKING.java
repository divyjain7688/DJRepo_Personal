/*
 *  This Test Script changes the password in the profile
 *  
 *  This Script is mapped to US-Acct-480

 */package com.selenium.ebiz.account_management.my_account;

 import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
 import com.selenium.ebiz.beans.UsersListBean;
 import com.selenium.ebiz.tools.PageManager;
 import com.selenium.ebiz.tools.RandomAccountSelect;
 import org.openqa.selenium.WebDriver;
 import org.testng.Assert;
 import org.testng.annotations.Test;

 import java.lang.reflect.Method;
 import java.util.ArrayList;

 public class MyAccountChangePassword_WORKING extends BaseClassV8_ParallelGrid {

	 private ArrayList<UsersListBean> usersList;


	 /**
	  *@storyDescription :  To verify as As an authenticated user, I want to change my password.
	  * @US :US-Acct-480
	  * @author Suresh
	  * 
	  * working
	  * */

	 /*
    @designed by: Divy Jain
    mapped with: W80-7841 : MA: UI - My Profile\About You - Change Password Modal
	  */
	 @Test(dataProvider = "browsers")
	 public void myAccount_verifyChangePasswordAndRevert(String browser, String version, String os, Method method) throws Exception {
		 this.createDriver(browser, version, os, method.getName());
		 WebDriver driver = this.getWebDriver();
		 PageManager pageManager = new PageManager(driver);
		 String username= RandomAccountSelect.users.pop();
		 pageManager.commonLogin().LoginToHDS(username, configread.getPassword());
		 pageManager.homePage().clickAccountLinkText();
		 pageManager.myAccountPage().clickOnMyProfileLogo();
		 usersList = pageManager.dBCon().loadDataFromExcel("verifyMyAccountsPageLinks", "MyAccount");
		 String oldpwd=usersList.get(0).getOldPassword();
		 String newpwd=usersList.get(0).getNewPassword();
		 pageManager.myAccountPage().changePassword(oldpwd,newpwd);
		 pageManager.myAccountPage().logoutFromMyAccount();
		 pageManager.commonLogin().signInToApplicationWithIncorrectPassword(username,oldpwd);
		 pageManager.common().refresh();
		 pageManager.commonLogin().LoginToHDS(username,newpwd);
		 pageManager.homePage().clickAccountLinkText();
		 pageManager.myAccountPage().clickOnMyProfileLogo();
		 pageManager.myAccountPage().changePassword(newpwd,oldpwd);
		 pageManager.myAccountPage().logoutFromMyAccount();
		 pageManager.commonLogin().LoginToHDS(username,oldpwd);

	 }


 }

