/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-4 Verify Add to Existing Saved List from Compare Results Page
 * <p>
 * ALM Test Instance ID: 649416
 */
package com.selenium.ebiz.compareProducts.compareProducts_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;


public class VerifyAddToExistingSavedListFromCompareResultsPage_Grid extends BaseClassV8_ParallelGrid {

    String existingListName, partNumFromCompareProducts;
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
	
    public void compProd__VerifyAddToExistingSavedListFromCompareResultsPage_Grid(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        pageManager.homePage().moveToSubCategoryPage();
        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().clickCompareTheseButton();
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();

        usersList = pageManager.dBCon().loadDataFromExcel("verifyQuickAddPartsToCart", "QuickOrder");
        Log.info(" ******* qtyInvalid: " + usersList.get(0).getQuantity1());
        pageManager.compareTheseItems().enterQuantity((usersList.get(0).getQuantity1()));

        pageManager.compareTheseItems().addToListInsideFirstComparisonTile.click();
        pageManager.signInOrRegisterPage().isSignInOrRegisterTitleDisplayed();
        pageManager.commonLogin().signIn(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();

        partNumFromCompareProducts = pageManager.compareTheseItems().getPartNumbers(0);
        pageManager.compareTheseItems().addToListInsideFirstComparisonTile.click();
        pageManager.addToExistingORCreateNewList_modal().isAddToExistingOrCreateNewListTitleTextDisplayed();


        existingListName = pageManager.addToExistingORCreateNewList_modal().addItemExistingList();
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();

        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        pageManager.savedListsPage().clickOnList(existingListName);
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(partNumFromCompareProducts));
    }


}
