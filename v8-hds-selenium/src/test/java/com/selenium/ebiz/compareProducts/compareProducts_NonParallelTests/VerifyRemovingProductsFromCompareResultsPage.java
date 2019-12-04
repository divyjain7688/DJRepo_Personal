/**
 * @author Bhavani
 * <p>
 * FMQAECOMM-18 [1]Verify Removing Products from Compare Results Page
 * <p>
 * ALM Test Instance ID: 649463
 */
package com.selenium.ebiz.compareProducts.compareProducts_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VerifyRemovingProductsFromCompareResultsPage extends BaseClassV8_Parallel {

    public int max = 4;
    List<String> partNumFromPLP, partNumFromCP;

    @Test(description = "Search by Product Description")
    public void test_SearchByProductDesc() throws Exception {
        GetUserList("searchByProdDesc", "Search");
        Log.info(usersList.get(0).getSearchProductKeyword());
        pageManager.homePage().searchByKeywordOrPartNumber(usersList.get(0).getSearchProductKeyword());
        Assert.assertTrue(pageManager.productListingPage().isGridViewDisplayed());
    }

    @Test(dependsOnMethods = {"test_SearchByProductDesc"}, description = "Verify Navigated To Compare Products Page")
    public void verifyNavigatedToCompareProductsPage() throws Exception {
        partNumFromPLP = pageManager.productListingPage().getAllPartNumbers(max);

        pageManager.productListingPage().clickonFirstCheckbox();
        pageManager.productListingPage().clickonSecondCheckbox();
        pageManager.productListingPage().clickonThirdCheckbox();
        pageManager.productListingPage().clickonFourthCheckbox();
        //pageManager.productListingPage().clickCompareCheckBoxes(max);

        pageManager.productListingPage().clickCompareTheseButton();
        Assert.assertTrue(pageManager.compareTheseItems().isDisplayedCompareProductsTitle());
    }

    @Test(dependsOnMethods = {"verifyNavigatedToCompareProductsPage"}, description = " Compare Parts Added From PLP To Compare Products ")
    public void ComparePLPPartsAndCPParts() throws Exception {
        partNumFromCP = pageManager.compareTheseItems().getAllPartNumbers();
        Log.info("Compare Parts partNumFromPLP and partNumFromCP");
        Assert.assertTrue(pageManager.compareTheseItems().compareParts(partNumFromPLP, partNumFromCP));
    }

    @Test(dependsOnMethods = {"ComparePLPPartsAndCPParts"}, description = " Verify First Item Added To New List")
    public void verifyRemoveFirstItemFromCompareProductsPage() throws Exception {
        pageManager.compareTheseItems().clickRemoveLinkInsideFirstTileDisplayed();
        Log.info("After del: " + pageManager.compareTheseItems().numberOfComparisonTiles() + "    " + "Before Del: " + max);
        Assert.assertNotEquals(pageManager.compareTheseItems().numberOfComparisonTiles(), max);
    }

}
