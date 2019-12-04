/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-122 [1]Verify Search Refine By Price
 * <p>
 * ALM Test Instance ID: 657777
 */
package com.selenium.ebiz.product_listing_page.plp_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerifySearchRefineByPrice extends BaseClassV8_ParallelGrid {


    int beforeClickPriceLessThan25, afterClickPriceLessThan25, beforeClickPriceBetween25And50, afterClickPriceBetween25And50;
    String env = "qa2" ;
    @Test(dataProvider = "browsers", enabled = false)
    //description = "Verify Search Refine By Price"
    /*
      7/29/2019 Bhavani: No Issues noticed. 
     
     */
    public void test_VerifySearchRefineByPrice(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);
        ArrayList<UsersListBean> usersList;

        usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());

        pageManager.productListingPage().isGridViewDisplayed();
        pageManager.productListingPage().refreshPage();
        String EnvValue = getEnvValue();
		System.out.println("env: " + env + "EnvValue: " + EnvValue );
		if(EnvValue.equals(env)){
			System.out.println("Skipped Price Facet Validation");
		}else{
        beforeClickPriceLessThan25 = pageManager.productListingPage().getNumOfItemsLessThan25();
        pageManager.productListingPage().clickpriceLessThan25();
        afterClickPriceLessThan25 = pageManager.productListingPage().getNumOfItemsLessThan25();
        Log.info("beforeClickPriceLessThan25: " + beforeClickPriceLessThan25 + "  " + "afterClickPriceLessThan25: " + afterClickPriceLessThan25);
        //Assert.assertEquals(beforeClickPriceLessThan25, afterClickPriceLessThan25);

        pageManager.productListingPage().clickpriceLessThan25();
        pageManager.productListingPage().clickOnListView();
        pageManager.productListingPage().isDisplayedListView();
        beforeClickPriceBetween25And50 = pageManager.productListingPage().getNumOfItemsPriceBetween25And50();
        pageManager.productListingPage().clickPriceBetween25And50();
        pageManager.productListingPage().isDisplayedListView();
        afterClickPriceBetween25And50 = pageManager.productListingPage().getNumOfItemsPriceBetween25And50();
        Log.info("beforeClickPriceBetween25And50: " + beforeClickPriceBetween25And50 + "  " + "afterClickPriceBetween25And50: " + afterClickPriceBetween25And50);
        Assert.assertEquals(beforeClickPriceLessThan25, afterClickPriceLessThan25);
        Assert.assertEquals(beforeClickPriceBetween25And50, afterClickPriceBetween25And50);
    }
    }
}
