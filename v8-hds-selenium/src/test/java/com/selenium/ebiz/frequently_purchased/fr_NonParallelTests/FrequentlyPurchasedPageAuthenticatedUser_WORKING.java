package com.selenium.ebiz.frequently_purchased.fr_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dj073227
 */
public class FrequentlyPurchasedPageAuthenticatedUser_WORKING extends BaseClassV8_Parallel {
    /*ArrayList<UsersListBean> usersList;
    DBCon dbConnection = new DBCon();
    LoginPage loginPage;
    HomePage homePage;
    MyAccountPage myAccountPage;
    FrequentlyPurchasedPage frequentlyPurchasedPage;*/
    ArrayList<String> optionsText = new ArrayList<String>();
    List<WebElement> optionsinDropDown;
    String twelveMonthsInOverThePastDropdown = " 12 Months";
    String nineMonthsInOverThePastDropdown = " 9 Months";
    String sixMonthsInOverThePastDropdown = " 6 Months";
    String threeMonthsInOverThePastDropdown = " 3 Months";
    String frequencyInSortByDropdown = " Frequency";
    String quantityInSortByDropdown = " Quantity";
    String totalSpentInSortByDropdown = " Total Spent";


    /**
     * This test is used to verify that when user logged in and click on my account link,
     * user should able to navigate to My account page.
     */
	/*@BeforeMethod
	public void driverSetup() throws Exception
	{
		driver=initialize();
		loginPage = new LoginPage(driver);
		usersList = dbConnection.loadDataFromExcel("verifyLogin","LoginTestData");
		loginPage.clickOnRegisterOrSignIn();
		homePage= loginPage.signInToApplication(usersList.get(0).getuserName(),usersList.get(0).getpassword());
		myAccountPage=homePage.clickAccountLinkText();
		frequentlyPurchasedPage=myAccountPage.moveToFrequentlyPurchsedPage();
	}*/


    /**
     * dj073227
     * US-PostOrd-072 - This method is used to test that logged in user has ability to filter which products
     * on the frequently purchased page I want to view.
     */

    //@Test(priority = 0, description="Login")
    public void test_Login() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
    }

    @Test(priority = 1, description = "Verify Frequently PurchasedPage Filters")
    public void verifyFrequentlyPurchasedPageFilters() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        pageManager.homePage().clickFrePurchasedUtilityBar();

        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isStatusFilterDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isCategoryFilterDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isSubcategoryFilterDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isBrandFilterDisplayed());
        String statusFilterActiveValue = pageManager.frequentlyPurchasedPage().statusFilterActiveValue();
        String displayedFilterValue = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        Assert.assertTrue(statusFilterActiveValue.contains(displayedFilterValue));
        String eligibleForSbscriptionsFilterFirstValue = pageManager.frequentlyPurchasedPage().eligibleForSbscriptionsFilterFirstValue();
        pageManager.frequentlyPurchasedPage().clickOnEligibleForSbscriptionsFilterFirstValueCheckBox();
        displayedFilterValue = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        Assert.assertTrue(eligibleForSbscriptionsFilterFirstValue.contains(displayedFilterValue));
        pageManager.frequentlyPurchasedPage().clickOnEligibleForSbscriptionsFilterFirstValueCheckBox();
        String brandFilterFirstValue = pageManager.frequentlyPurchasedPage().brandFilterFirstValue();
        pageManager.frequentlyPurchasedPage().clickOnBrandFilterFirstValueCheckBox();
        displayedFilterValue = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        Assert.assertTrue(brandFilterFirstValue.contains(displayedFilterValue));
        pageManager.frequentlyPurchasedPage().clickOnBrandFilterFirstValueCheckBox();
        String categoryFilterFirstValue = pageManager.frequentlyPurchasedPage().categoryFilterFirstValue();
        pageManager.frequentlyPurchasedPage().clickOnCategoryFilterFirstValueCheckBox();
        displayedFilterValue = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        Assert.assertTrue(categoryFilterFirstValue.contains(displayedFilterValue));
        pageManager.frequentlyPurchasedPage().clickOnCategoryFilterFirstValueCheckBox();
        String subcategoryFilterFirstValue = pageManager.frequentlyPurchasedPage().subcategoryFilterFirstValue();
        pageManager.frequentlyPurchasedPage().clickOnSubcategoryFilterFirstValueCheckBox();
        displayedFilterValue = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        Assert.assertTrue(subcategoryFilterFirstValue.contains(displayedFilterValue));
    }

    /**
     * dj073227
     * US-PostOrd-070 - As a user I want the ability to have a My Account page which provides me information
     * on products I've frequently purchased.
     * throws Exception
     */
    @Test(priority = 2, description = "verify Frequently PurchasedPage Pagination")
    public void verifyFrequentlyPurchasedPagePagination() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        pageManager.homePage().clickFrePurchasedUtilityBar();
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isBreadCrumbDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().frequentlyPurchasedpageHeadingText.isDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isPaginationformatdisplayed());
        optionsinDropDown = pageManager.frequentlyPurchasedPage().getOverThePastDropdown();
        for (WebElement we : optionsinDropDown) {
            optionsText.add(we.getText());
            System.out.println(optionsText);
        }
        Assert.assertTrue(optionsText.contains(twelveMonthsInOverThePastDropdown));
        Assert.assertTrue(optionsText.contains(nineMonthsInOverThePastDropdown));
        Assert.assertTrue(optionsText.contains(sixMonthsInOverThePastDropdown));
        Assert.assertTrue(optionsText.contains(threeMonthsInOverThePastDropdown));
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().defaultValueinOverThePastDropdown().contains(twelveMonthsInOverThePastDropdown));
        optionsinDropDown = pageManager.frequentlyPurchasedPage().getSortByDropdown();
        for (WebElement we : optionsinDropDown) {
            optionsText.add(we.getText());
            System.out.println(optionsText);
        }
        Assert.assertTrue(optionsText.contains(frequencyInSortByDropdown));
        Assert.assertTrue(optionsText.contains(quantityInSortByDropdown));
        Assert.assertTrue(optionsText.contains(totalSpentInSortByDropdown));
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isSortByTotalSpentValue());
        System.out.println("frequentlyPurchasedPage.isSortByTotalSpentValue()....................");
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isSortByQuantityValue());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isSortByFrequencyValue());
        pageManager.frequentlyPurchasedPage().clickOnNineMonthsInOverThePastDropdown();
        String displayedFilterValue = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        String overThePastNineMonthFilterProducts = pageManager.frequentlyPurchasedPage().overThePastFilterProducts();
        System.out.println("displayedFilterValue is " + displayedFilterValue + "   overThePastNineMonthFilterProducts" + overThePastNineMonthFilterProducts);
        Assert.assertTrue(displayedFilterValue.equals(overThePastNineMonthFilterProducts));
        pageManager.frequentlyPurchasedPage().navigateToHomePage();
        pageManager.homePage().clickAccountLinkText();
        pageManager.myAccountPage().moveToFrequentlyPurchsedPage();

        pageManager.frequentlyPurchasedPage().clickOnTwelveMonthsInOverThePastDropdown();
        displayedFilterValue = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        String overThePastTwelveMonthFilterProducts = pageManager.frequentlyPurchasedPage().overThePastFilterProducts();
        System.out.println("displayedFilterValue is " + displayedFilterValue + "   overThePastTwelveMonthFilterProducts" + overThePastTwelveMonthFilterProducts);
        Assert.assertTrue(displayedFilterValue.equals(overThePastTwelveMonthFilterProducts));
        pageManager.frequentlyPurchasedPage().navigateToHomePage();
        pageManager.homePage().clickAccountLinkText();
        pageManager.myAccountPage().moveToFrequentlyPurchsedPage();

        pageManager.frequentlyPurchasedPage().clickOnThreeMonthsInOverThePastDropdown();
        displayedFilterValue = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        String overThePastThreeMonthFilterProducts = pageManager.frequentlyPurchasedPage().overThePastFilterProducts();
        System.out.println("displayedFilterValue is " + displayedFilterValue + "   overThePastThreeMonthFilterProducts" + overThePastThreeMonthFilterProducts);
        Assert.assertTrue(displayedFilterValue.equals(overThePastThreeMonthFilterProducts));
        pageManager.frequentlyPurchasedPage().navigateToHomePage();
        pageManager.homePage().clickAccountLinkText();
        pageManager.myAccountPage().moveToFrequentlyPurchsedPage();

        pageManager.frequentlyPurchasedPage().clickOnSixMonthsInOverThePastDropdown();
        displayedFilterValue = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        String overThePastSixMonthFilterProducts = pageManager.frequentlyPurchasedPage().overThePastFilterProducts();
        System.out.println("displayedFilterValue is " + displayedFilterValue + "   overThePastSixMonthFilterProducts" + overThePastSixMonthFilterProducts);
        Assert.assertTrue(displayedFilterValue.equals(overThePastSixMonthFilterProducts));
        pageManager.frequentlyPurchasedPage().navigateToHomePage();
        pageManager.homePage().clickAccountLinkText();
        pageManager.myAccountPage().moveToFrequentlyPurchsedPage();
    }

}
