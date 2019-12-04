package com.selenium.ebiz.frequently_purchased.fpp_grid;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FrequentlyPurchasedPageAuthenticatedUser_Grid extends BaseClassV8_ParallelGrid {

    ArrayList<String> optionsText = new ArrayList<String>();
    List<WebElement> optionsinDropDown1, optionsinDropDown2;
    String twelveMonthsInOverThePastDropdown = " 12 Months";
    String nineMonthsInOverThePastDropdown = " 9 Months";
    String sixMonthsInOverThePastDropdown = " 6 Months";
    String threeMonthsInOverThePastDropdown = " 3 Months";
    String frequencyInSortByDropdown = " Frequency";
    String quantityInSortByDropdown = " Quantity";
    String totalSpentInSortByDropdown = " Total Spent";
    String displayedFilterValue1, displayedFilterValue2, displayedFilterValue3, displayedFilterValue4;


    /**
     * Modified By Bhavani
     * US-PostOrd-070 - As a user I want the ability to have a My Account page which provides me information
     * on products I've frequently purchased.
     * throws Exception
     */

    @Test(description = "Verify Frequently PurchasedPage Pagination", dataProvider = "browsers")
    public void fpp_verifyFrequentlyPurchasedPagePagination(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        pageManager.homePage().clickFrePurchasedUtilityBar();

        Log.info("Verify Frequently PurchasedPage Pagination");
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().frequentlyPurchasedpageHeadingText.isDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isBreadCrumbDisplayed());
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().isPaginationformatdisplayed());

    }

    /**
     * @author Bhavani
     * FMQAECOMM-252 [1]FPP_OverthepastFilter
     * Test Instance Id: 657866
     */

    @Test(description = "Verify OverThePast DropDown Options Frequently PurchasedPage ", dataProvider = "browsers", enabled = false)
    public void fpp_verifyOverThePastDropDownOptionsInFPP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        pageManager.homePage().clickFrePurchasedUtilityBar();

        optionsinDropDown1 = pageManager.frequentlyPurchasedPage().getOverThePastDropdown();
        Log.info("optionsinDropDown: " + optionsinDropDown1);
        for (WebElement we : optionsinDropDown1) {
            optionsText.add(we.getText());
            System.out.println(optionsText);
        }

        Log.info("Verify OverThePast DropDown Options Frequently PurchasedPage");
        Assert.assertTrue(optionsText.contains(twelveMonthsInOverThePastDropdown));
        Assert.assertTrue(optionsText.contains(nineMonthsInOverThePastDropdown));
        Assert.assertTrue(optionsText.contains(sixMonthsInOverThePastDropdown));
        Assert.assertTrue(optionsText.contains(threeMonthsInOverThePastDropdown));
        Assert.assertTrue(pageManager.frequentlyPurchasedPage().defaultValueinOverThePastDropdown().contains(twelveMonthsInOverThePastDropdown));
    }

    @Test(description = "verify SortBy DropDown Options In Frequently PurchasedPage Pagination", dataProvider = "browsers", enabled = false)
    public void fpp_verifySortByDropDownOptionsInFPP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        pageManager.homePage().clickFrePurchasedUtilityBar();
        Log.info("verify SortBy DropDown Options In Frequently PurchasedPage Pagination");

        optionsinDropDown2 = pageManager.frequentlyPurchasedPage().getSortByDropdown();
        Log.info("optionsinDropDown: " + optionsinDropDown2);
        for (WebElement we : optionsinDropDown2) {
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
    }

    @Test(description = "verify Months Value DropDown Options In Frequently PurchasedPage Pagination", dataProvider = "browsers", enabled = false)
    public void fpp_verifyMonthsValueOptionsInFPP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        pageManager.homePage().clickFrePurchasedUtilityBar();

        pageManager.frequentlyPurchasedPage().clickOnNineMonthsInOverThePastDropdown();
        displayedFilterValue1 = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        String overThePastNineMonthFilterProducts = pageManager.frequentlyPurchasedPage().overThePastFilterProducts();
        System.out.println("displayedFilterValue1 is " + displayedFilterValue1 + "   overThePastNineMonthFilterProducts" + overThePastNineMonthFilterProducts);

        pageManager.frequentlyPurchasedPage().navigateToHomePage();
        pageManager.homePage().clickAccountLinkText();
        pageManager.myAccountPage().moveToFrequentlyPurchsedPage();

        pageManager.frequentlyPurchasedPage().clickOnTwelveMonthsInOverThePastDropdown();
        displayedFilterValue2 = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        String overThePastTwelveMonthFilterProducts = pageManager.frequentlyPurchasedPage().overThePastFilterProducts();
        System.out.println("displayedFilterValue2 is " + displayedFilterValue2 + "   overThePastTwelveMonthFilterProducts" + overThePastTwelveMonthFilterProducts);

        pageManager.frequentlyPurchasedPage().navigateToHomePage();
        pageManager.homePage().clickAccountLinkText();
        pageManager.myAccountPage().moveToFrequentlyPurchsedPage();

        pageManager.frequentlyPurchasedPage().clickOnThreeMonthsInOverThePastDropdown();
        displayedFilterValue3 = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        String overThePastThreeMonthFilterProducts = pageManager.frequentlyPurchasedPage().overThePastFilterProducts();
        System.out.println("displayedFilterValue3 is " + displayedFilterValue3 + "   overThePastThreeMonthFilterProducts" + overThePastThreeMonthFilterProducts);

        pageManager.frequentlyPurchasedPage().navigateToHomePage();
        pageManager.homePage().clickAccountLinkText();
        pageManager.myAccountPage().moveToFrequentlyPurchsedPage();

        pageManager.frequentlyPurchasedPage().clickOnSixMonthsInOverThePastDropdown();
        displayedFilterValue4 = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        String overThePastSixMonthFilterProducts = pageManager.frequentlyPurchasedPage().overThePastFilterProducts();
        System.out.println("displayedFilterValue4 is " + displayedFilterValue4 + "   overThePastSixMonthFilterProducts" + overThePastSixMonthFilterProducts);
        Assert.assertTrue(displayedFilterValue1.equals(overThePastNineMonthFilterProducts));
        Assert.assertTrue(displayedFilterValue2.equals(overThePastTwelveMonthFilterProducts));
        Assert.assertTrue(displayedFilterValue3.equals(overThePastThreeMonthFilterProducts));
        Assert.assertTrue(displayedFilterValue4.equals(overThePastSixMonthFilterProducts));
        pageManager.frequentlyPurchasedPage().navigateToHomePage();
        pageManager.homePage().clickAccountLinkText();
        pageManager.myAccountPage().moveToFrequentlyPurchsedPage();
    }

    /**
     * @author Bhavani
     * FMQAECOMM-252 [1]FPP_OverthepastFilter
     * Test Instance Id: 657866
     */
    @Test(description = "verify Months Value DropDown In Frequently PurchasedPage Pagination", dataProvider = "browsers", enabled = true )
    public void fpp_verifyMonthsValueInFPP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());

        pageManager.homePage().clickFrePurchasedUtilityBar();

        pageManager.frequentlyPurchasedPage().clickOnTwelveMonthsInOverThePastDropdown();
        displayedFilterValue2 = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        String overThePastTwelveMonthFilterProducts = pageManager.frequentlyPurchasedPage().overThePastFilterProducts();
        System.out.println("displayedFilterValue2 is " + displayedFilterValue2 + "   overThePastTwelveMonthFilterProducts" + overThePastTwelveMonthFilterProducts);

        pageManager.homePage().clickFrePurchasedUtilityBar();

        pageManager.frequentlyPurchasedPage().clickOnNineMonthsInOverThePastDropdown();
        displayedFilterValue1 = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        String overThePastNineMonthFilterProducts = pageManager.frequentlyPurchasedPage().overThePastFilterProducts();
        System.out.println("displayedFilterValue1 is " + displayedFilterValue1 + "   overThePastNineMonthFilterProducts" + overThePastNineMonthFilterProducts);

        pageManager.homePage().clickFrePurchasedUtilityBar();

        pageManager.frequentlyPurchasedPage().clickOnSixMonthsInOverThePastDropdown();
        displayedFilterValue4 = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        String overThePastSixMonthFilterProducts = pageManager.frequentlyPurchasedPage().overThePastFilterProducts();
        System.out.println("displayedFilterValue4 is " + displayedFilterValue4 + "   overThePastSixMonthFilterProducts" + overThePastSixMonthFilterProducts);

        pageManager.homePage().clickFrePurchasedUtilityBar();

        pageManager.frequentlyPurchasedPage().clickOnThreeMonthsInOverThePastDropdown();
        displayedFilterValue3 = pageManager.frequentlyPurchasedPage().displayedFilterValue();
        String overThePastThreeMonthFilterProducts = pageManager.frequentlyPurchasedPage().overThePastFilterProducts();
        System.out.println("displayedFilterValue3 is " + displayedFilterValue3 + "   overThePastThreeMonthFilterProducts" + overThePastThreeMonthFilterProducts);

        Assert.assertTrue(displayedFilterValue1.equals(overThePastNineMonthFilterProducts));
        Assert.assertTrue(displayedFilterValue2.equals(overThePastTwelveMonthFilterProducts));
        Assert.assertTrue(displayedFilterValue3.equals(overThePastThreeMonthFilterProducts));
        Assert.assertTrue(displayedFilterValue4.equals(overThePastSixMonthFilterProducts));


    }

}


