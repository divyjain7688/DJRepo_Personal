/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-4 Verify Add to Existing Saved List from Compare Results Page
 * <p>
 * ALM Test Instance ID: 649416
 */
package com.selenium.ebiz.compareProducts.compareProducts_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyAddToExistingSavedListFromCompareResultsPage extends BaseClassV8_Parallel {

    String existingListName, partNumFromCompareProducts;

    @Test(description = "Verify Compare Checkboxes Displayed ")
    public void verifyCompareCheckboxesDisplayed() throws Exception {
        pageManager.homePage().moveToSubCategoryPage();
        Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
    }

    @Test(dependsOnMethods = {"verifyCompareCheckboxesDisplayed"}, description = "Verify Navigated To Compare Products Page")
    public void verifyNavigatedToCompareProductsPage() throws Exception {
        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().clickCompareTheseButton();
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"verifyNavigatedToCompareProductsPage"}, description = " Verify Sign In Or Register Page")
    public void verifySignInOrRegisterPage() throws Exception {
        GetUserList("verifyQuickAddPartsToCart", "QuickOrder");
        Log.info(" ******* qtyInvalid: " + usersList.get(0).getQuantity1());
        pageManager.compareTheseItems().enterQuantity((usersList.get(0).getQuantity1()));

        pageManager.compareTheseItems().addToListInsideFirstComparisonTile.click();
        Assert.assertTrue(pageManager.signInOrRegisterPage().signInOrRegisterTitle.isDisplayed());

    }

    @Test(dependsOnMethods = {"verifySignInOrRegisterPage"}, description = " Enter Valid Credentials")
    public void enterValidCredentials() throws Exception {
        Log.info("Enter Username and Password");
        pageManager.signInOrRegisterPage().loginToFromBrowsePage(RandomAccountSelect.users.pop(), configread.getPassword());
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"enterValidCredentials"}, description = " Verify Add To New List Modal Window")
    public void verifyAddToNewListModalWindow() throws Exception {
        partNumFromCompareProducts = pageManager.compareTheseItems().getPartNumbers(0);
        pageManager.compareTheseItems().addToListInsideFirstComparisonTile.click();
        Assert.assertTrue(pageManager.addToExistingORCreateNewList_modal().isAddToExistingOrCreateNewListTitleTextDisplayed());

    }

    @Test(dependsOnMethods = {"verifyAddToNewListModalWindow"}, description = " Verify Add Item To Existing List")
    public void verifyAddItemToExistingList() throws Exception {
        existingListName = pageManager.addToExistingORCreateNewList_modal().addItemExistingList();
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());

    }

    @Test(dependsOnMethods = {"verifyAddItemToExistingList"}, description = " Verify Item Added To Existing List")
    public void verifyItemAddedToExistingList() throws Exception {
        pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().clickOnList(existingListName);
        pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(partNumFromCompareProducts);
        Assert.assertTrue(pageManager.savedListsDetailPage().isAddedPartDisplayedInSavedList(partNumFromCompareProducts));
    }

    @Test(dependsOnMethods = {"verifyItemAddedToExistingList"}, description = "Logout")
    public void testLogout() throws Exception {
        pageManager.loginPage().logoutOfApplication();

    }

}
