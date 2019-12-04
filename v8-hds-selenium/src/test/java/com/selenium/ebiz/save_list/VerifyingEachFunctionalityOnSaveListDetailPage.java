/**
 * @author Bhavani
 * W80-5097 / FMQAECOMM-370 Verifying each functionality on Save list detail page
 */
package com.selenium.ebiz.save_list;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class VerifyingEachFunctionalityOnSaveListDetailPage extends BaseClassV8_ParallelGrid {
	List<String> savedListParts, scpParts;
	private ArrayList<UsersListBean> usersList;

	@Test(dataProvider = "browsers", enabled = true)
	public void savedList_VerifyingEachFunctionalityOnSaveListDetailPage(String browser, String version, String os, Method method) throws Exception {
		
	 /*
       8/13/2019 Bhavani: Updated nameListEdit Webelement xpath from line 37 in CreateNewSavedListPage
	 */
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.shoppingCartPage().checkClearShoppingCart();
        Log.info("Shopping cart was checked and cleared");
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		pageManager.savedListsPage().createNewPrivateListIfNoListExists();
		pageManager.savedListsPage().clickOnExistingFirstSavedList();
		pageManager.savedListsDetailPage().isSavedListDetailPageTitle();
		Boolean listNameDisplayed = pageManager.savedListsDetailPage().listNameText.isDisplayed();
        Boolean lastUpdatedDateDisplayed = pageManager.savedListsDetailPage().lastUpdatedDate.isDisplayed();
        
        pageManager.savedListsDetailPage().clickEditNotesLink();
        pageManager.savedListsDetailPage().verifyNotesOnClickEditNotesLink();
        savedListParts = pageManager.savedListsDetailPage().getPartNumbersFromSavedList();
        Log.info("SavedListParts: "+ savedListParts);
        pageManager.savedListsDetailPage().clickAddListToCartButton();
        
        pageManager.shoppingCartPage().isDisplayedShoppingCartTitle();
        scpParts = pageManager.shoppingCartPage().getAllPartNumbers();
        Log.info("ScpParts: " + scpParts);
        Boolean compareSaveListAndSCPParts = pageManager.shoppingCartPage().compareParts(savedListParts, scpParts);
        pageManager.homePage().navigateBack();

        usersList = pageManager.dBCon().loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
        pageManager.savedListsDetailPage().addProductFromAddPartToListSection(usersList.get(0).getPartNumber1(),usersList.get(0).getQuantity2());
        pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(usersList.get(0).getPartNumber1());
        
        Assert.assertTrue(listNameDisplayed);
        Assert.assertTrue(lastUpdatedDateDisplayed);
        Assert.assertTrue(compareSaveListAndSCPParts);
	}
	
	@Test(dataProvider = "browsers", enabled = false)
	/*
	 * Marked it false as Print Bin labels pdf is not loading
	 */
	public void savedList_VerifyingEachFunctionalityOnSaveListDetailPage_PrintBinLabels(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		pageManager.savedListsPage().clickOnExistingFirstSavedList();
        
		pageManager.savedListsDetailPage().isSavedListDetailPageTitle();
        pageManager.savedListsDetailPage().clickPrintBinLabelsLink();
        Assert.assertTrue(pageManager.savedListsDetailPage().isContactNumberOnBinLabelDisplayed());
        Assert.assertTrue(pageManager.savedListsDetailPage().isProductDescriptionOnBinLabelDisplayed());
        Assert.assertTrue(pageManager.savedListsDetailPage().isHDSPartTextOnBinLabelDisplayed());
        pageManager.savedListsDetailPage().navigateBackToMainWindowFromPrintLabel();
       
	}
	
	@Test(dataProvider = "browsers", enabled = false)
	public void savedList_VerifyingEachFunctionalityOnSaveListDetailPage_ManageList(String browser, String version, String os, Method method) throws Exception {
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);

		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		pageManager.savedListsPage().clickOnExistingFirstSavedList();
	
		pageManager.savedListsDetailPage().isSavedListDetailPageTitle();
        pageManager.savedListsDetailPage().clickOnConvertToSharedListLink();
        
        pageManager.savedListsDetailPage().clickOnEmailListLink();
        usersList=pageManager.dBCon().loadDataFromExcel("SavedListDetailPage","EMail");
		pageManager.savedListsDetailPage().fillOutEmailFields(usersList.get(0).getEMail(),usersList.get(0).getMessage());
		Boolean emailSuccessfullyDisplayed = pageManager.savedListsDetailPage().isDisplayedEmailedSuccessfulMessage();
		pageManager.savedListsDetailPage().closeModalPopUp();
		
		pageManager.savedListsDetailPage().clickDownLoadTemplateLink();
		pageManager.savedListsDetailPage().clickOnUploadTemplateLink();
		Boolean uploadSavedListTextDisplayed = pageManager.savedListsDetailPage().isDisplayedUploadSavedListText();
		pageManager.savedListsDetailPage().closeModalPopUp();
		
		pageManager.savedListsDetailPage().clickOnDeleteLink();
		Assert.assertTrue(emailSuccessfullyDisplayed);
		Assert.assertTrue(uploadSavedListTextDisplayed);

	}
	
	
}
