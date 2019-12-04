package com.selenium.ebiz.product_listing_page.plp_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class VerifyShowMorePerPageFeatureInPLP extends BaseClassV8_ParallelGrid {

	private ArrayList<UsersListBean> usersList;
    /**
     * @author Bhavani
     * FMQAECOMM-873
     */
    @Test(dataProvider = "browsers")
    public void plp_VerifyShowMorePerPageFeatureInPLP(String browser, String version, String os, Method method) throws Exception {
        int expecteddropdownValues[] = {24, 48, 96};
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
       
        usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc","Search");
        Log.info("Search product number from list" + usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        
        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.productListingPage().isShowXXPerPageTextDisplayed();
        pageManager.productListingPage().getDefaultValueFromShowPerPageDropdown().equals("24");
        int actualdropdownValues[] = pageManager.productListingPage().getAllOptionsFromShowPerPageDropdown();
        Assert.assertTrue(Arrays.equals(expecteddropdownValues, actualdropdownValues));
        
    }
    
    @Test(dataProvider = "browsers")
    public void savedList_VerifyChangeTheNumberOfItemsFunctionalityOnPLP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc","Search");
        Log.info("Search product number from list" + usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        
        pageManager.productListingPage().isGridViewDisplayed();        
        
        pageManager.productListingPage().isShowXXPerPageTextDisplayed();
        pageManager.productListingPage().verifyNumberOfListDisplayed("24");
        pageManager.productListingPage().verifyNumberOfListDisplayed("48");
        pageManager.productListingPage().verifyNumberOfListDisplayed("96");
    }
}
