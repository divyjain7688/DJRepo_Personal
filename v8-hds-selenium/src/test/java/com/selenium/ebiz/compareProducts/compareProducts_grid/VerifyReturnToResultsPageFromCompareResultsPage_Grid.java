/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-28 [1]Verify Return to Results Page from Compare Results Page
 * <p>
 * ALM Test Instance ID: 649464
 */
package com.selenium.ebiz.compareProducts.compareProducts_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class VerifyReturnToResultsPageFromCompareResultsPage_Grid extends BaseClassV8_ParallelGrid {

    String searchPLPHeading, subCategory, plpHeading, searchPLPHeadingAfterBackClick;
    String env = "qa2" ;
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers", enabled = false)

    public void compProd_SearchByProductDesc(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        usersList = pageManager.dBCon().loadDataFromExcel("searchByProductDescWithDoubleQuotes", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().isGridViewDisplayed();

        searchPLPHeading = pageManager.productListingPage().getPLPHeadingText();
        pageManager.productListingPage().clickCompareCheckBoxes(4);
        pageManager.productListingPage().clickCompareTheseButton();
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();
        pageManager.compareTheseItems().clickBackToSearchLink();
        searchPLPHeadingAfterBackClick = pageManager.productListingPage().getPLPHeadingText();
        Log.info("searchPLPHeadingAfterBackClick: " + searchPLPHeadingAfterBackClick + "searchPLPHeading: " + searchPLPHeading);

        // description="Verify Navigate To SubCategory Has Ampersand ")
        pageManager.homePage().clickOnHDSupplyLogoInHeader();
        pageManager.homePage().clickCategoryAppliancessLinkText();
        pageManager.appliances().clickTopCategoryRefrigeratorsFreezersLinkText();
        pageManager.productListingPage().isGridViewDisplayed();

        //description="Verify Navigated To Compare Products Page After Selecting Products From Subcategory")
        subCategory = pageManager.productListingPage().getPLPHeadingText();
        pageManager.productListingPage().clickCompareCheckBoxes(4);
        pageManager.productListingPage().clickCompareTheseButton();
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();

        //description="Verify Navigated To Subcategory On Back Search")
        pageManager.compareTheseItems().clickBackToSearchLink();
        plpHeading = pageManager.productListingPage().getPLPHeadingText();
        Log.info("plpHeading: " + plpHeading + "subCategory: " + subCategory);

        //description="Verify Price Selected ")
		pageManager.productListingPage().clickCompareCheckBoxes(4);
		//pageManager.productListingPage().clickClearAllLink();
		String EnvValue = getEnvValue();
		System.out.println("env: " + env + "EnvValue: " + EnvValue );
		if(EnvValue.equals(env)){
			System.out.println("Skipped Price Facet Validation");
		}else{
			pageManager.homePage().clickOnPriceDropdown();
			pageManager.homePage().clickOnPriceLessThan25CheckBox();
			pageManager.productListingPage().clickCompareCheckBoxes(4);
			pageManager.productListingPage().clickCompareTheseButton();
			pageManager.compareTheseItems().isDisplayedCompareProductsTitle();
			pageManager.compareTheseItems().clickBackToSearchLink();
			pageManager.homePage().IsSelectedPriceLessThan25CheckBox();
		}

        Assert.assertEquals(searchPLPHeadingAfterBackClick, searchPLPHeading);
        Assert.assertEquals(plpHeading, subCategory);

    }

}
