/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-18 [1]Verify Removing Products from Compare Results Page
 * <p>
 * ALM Test Instance ID: 649463
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
import java.util.List;

public class VerifyRemovingProductsFromCompareResultsPage_Grid extends BaseClassV8_ParallelGrid {

    public int max = 4;
    List<String> partNumFromPLP, partNumFromCP;
    private ArrayList<UsersListBean> usersList;

    @Test(dataProvider = "browsers")
    public void compProd__RemoveProductsFromCompareResultsPage(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        usersList = pageManager.dBCon().loadDataFromExcel("searchByProdDesc", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        pageManager.productListingPage().isGridViewDisplayed();

        partNumFromPLP = pageManager.productListingPage().getAllPartNumbers(max);

        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().clickonFourthCheckbox();
        //pageManager.productListingPage().clickCompareCheckBoxes(max);

        pageManager.productListingPage().clickCompareTheseButton();
        pageManager.compareTheseItems().isDisplayedCompareProductsTitle();
        //description=" Compare Parts Added From PLP To Compare Products ")

        partNumFromCP = pageManager.compareTheseItems().getAllPartNumbers();
        Assert.assertTrue(pageManager.compareTheseItems().compareParts(partNumFromPLP, partNumFromCP));
        //description=" Verify First Item Added To New List")
        pageManager.compareTheseItems().clickRemoveLinkInsideFirstTileDisplayed();
        Log.info("After del: " + pageManager.compareTheseItems().numberOfComparisonTiles() + "    " + "Before Del: " + max);
        Assert.assertNotEquals(pageManager.compareTheseItems().numberOfComparisonTiles(), max);
    }

}
