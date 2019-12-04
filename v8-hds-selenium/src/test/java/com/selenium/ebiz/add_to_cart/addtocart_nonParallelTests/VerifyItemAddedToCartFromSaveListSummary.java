package com.selenium.ebiz.add_to_cart.addtocart_nonParallelTests;

/**
*
* @author Sandhya
*
*  FMQA-2444 To Verify if items can be added from a Saved List Summary
*
*  ALM Test Instance ID: 649406
*/
import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyItemAddedToCartFromSaveListSummary extends BaseClassV8_Parallel {
	String savedListPage;
	String partNumber;
	String price;
	 /**
	 *  To Verify if items can be added from a Saved List Summary 
	 * @throws Exception
	 */
	
	@Test(description="Verify Item Added To Cart From Save List Summary", enabled = false)
	public void test_VerifyItemAddedToCartFromSaveListSummary() throws Exception {
		LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());

		pageManager.shoppingCartPage().checkClearShoppingCart();
        pageManager.homePage().clickSavedListUtilityBar();
 		pageManager.savedListsPage().isDisplayedSavedListspageHeadingText();
 		pageManager.savedListsPage().clickFirstSavedListNameLinkText();
 		partNumber = pageManager.savedListsDetailPage().getdisplayedPartNumber();
 		Log.info("partNumber is "+ partNumber);
 		price = pageManager.savedListsDetailPage().getdisplayedPrice();
		Log.info("price is "+ price);
 	//	pageManager.savedListsDetailPage().isDisplayedSaveListPartImage();
 		pageManager.savedListsDetailPage().clickonFirstAddToCartbtn();
 		pageManager.homePage().clickOnShoppingCartIcon();
 		Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartDisplayedInShoppingCart(partNumber));
 		Assert.assertTrue(pageManager.shoppingCartPage().isAddedPartPriceIsSameInShoppingCart(price));
         
	 }
}
