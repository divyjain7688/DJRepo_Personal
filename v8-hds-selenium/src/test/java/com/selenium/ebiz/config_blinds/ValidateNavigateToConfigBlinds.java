package com.selenium.ebiz.config_blinds;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
@author by: Bhavani
ALM Instance ID: 660488
FMQAECOMM-477: [1]Validate Navigate to Config Blinds
*/
public class ValidateNavigateToConfigBlinds extends BaseClassV8_ParallelGrid {
	
	String expectedPLPHeading = "SHADES & ROLLER SHADES";
	@Test(dataProvider = "browsers")
    public void configBlinds_ValidateNavigateToConfigBlindsLoggedInUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        Log.info("Login");
        pageManager.homePage().clickWindowCoveringsLinkText();
        
        pageManager.subCategory().clickSubCategoryShadesAndRollerShadesLinkText();
        pageManager.productListingPage().isPlpHeadingTextDisplayed();
        String actualPLPHeading = pageManager.productListingPage().getPLPHeadingText();
        
        Boolean displayedCustomizeLink = pageManager.productListingPage().isDisplayedFirstCustomizeThisItemLinks();
        //pageManager.productListingPage().selectFromSortByDropdownAndGridViewDispayed();
       
        pageManager.productListingPage().VerifyTheListGetSortedBy("Relevance");
        pageManager.productListingPage().VerifyTheListGetSortedBy("Brand");
        pageManager.productListingPage().VerifyTheListGetSortedBy("Product Name");
        pageManager.productListingPage().VerifyTheListGetSortedBy("Price: Low to High");
        pageManager.productListingPage().VerifyTheListGetSortedBy("Price: High to Low");
        pageManager.productListingPage().VerifyTheListGetSortedBy("Top Sellers");
       
        Assert.assertTrue(displayedCustomizeLink);
        Assert.assertEquals(actualPLPHeading, expectedPLPHeading);
         
    }
	
	@Test(dataProvider = "browsers")
    public void configBlinds_ValidateNavigateToConfigBlindsGuestUser(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.homePage().clickWindowCoveringsLinkText();
        
        pageManager.subCategory().clickSubCategoryShadesAndRollerShadesLinkText();
        pageManager.productListingPage().isPlpHeadingTextDisplayed();
        String actualPLPHeading = pageManager.productListingPage().getPLPHeadingText();
        
        Boolean displayedCustomizeLink = pageManager.productListingPage().isDisplayedFirstCustomizeThisItemLinks();
        //pageManager.productListingPage().selectFromSortByDropdownAndGridViewDispayed();
       
        pageManager.productListingPage().VerifyTheListGetSortedBy("Relevance");
        pageManager.productListingPage().VerifyTheListGetSortedBy("Brand");
        pageManager.productListingPage().VerifyTheListGetSortedBy("Product Name");
        pageManager.productListingPage().VerifyTheListGetSortedBy("Price: Low to High");
        pageManager.productListingPage().VerifyTheListGetSortedBy("Price: High to Low");
        pageManager.productListingPage().VerifyTheListGetSortedBy("Top Sellers");
       
        Assert.assertTrue(displayedCustomizeLink);
        Assert.assertEquals(actualPLPHeading, expectedPLPHeading);
        
         
    }





}
