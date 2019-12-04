package com.selenium.ebiz.add_to_cart.addtocart_nonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
*
 @author Divy Jain
 FMQA-2448  Verify Rich Relevance Recommendation section
 ALM Test Instance ID: 649411
*/
public class VerifyRichRelevanceRecommendationsection extends BaseClassV8_Parallel {

	@Test(description="Login")
	public void test_Login() 
	{
		LoginToHDS(RandomAccountSelect.users.pop(),configread.getPassword());
		Assert.assertTrue(pageManager.homePage().isDisplayedLeftNavgation());
	}

	@Test(dependsOnMethods = {"test_Login"}, description="Navigate To PLP Page Using Search and verify RichRelevance")
	public void test_NavigateToPLPPageUsingSearchAndVerifyRichRelevance() throws Exception
	{
		GetUserList("searchByProdDesc","Search");
		Log.info(usersList.get(0).getSearchProductKeyword());
		pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
		Assert.assertTrue(pageManager.productListingPage().richRelevanceThroughSearch.isDisplayed());
	}
	
	@Test(dependsOnMethods = {"test_NavigateToPLPPageUsingSearchAndVerifyRichRelevance"}, description="Navigate To PLP Page Using Navigation and verify RichRelevance")
	public void test_NavigateToPLPPageUsingNavigationAndVerifyRichRelevance() throws Exception
	{
		pageManager.homePage().moveToSubCategoryPage();
		Assert.assertTrue(pageManager.productListingPage().isRichRelevanceDisplayed());
	}


	@Test(dependsOnMethods = {"test_NavigateToPLPPageUsingNavigationAndVerifyRichRelevance"}, description="Verify The Content Of Rich Relevance")
	public void test_verifyAddToCartUnderRichRelevance() throws Exception
	{
		Assert.assertTrue(pageManager.productListingPage().isAddToCartUnderRichRelevanceDisplayed());
		Assert.assertTrue(pageManager.productListingPage().isPriceUnderRichRelevanceDisplayed());

	}
}
