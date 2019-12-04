package com.selenium.ebiz.peachtree;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class peachtree extends BaseClassV8_ParallelGrid {

    public String newListName = "List_";


    /**
     * This test is used to verify end to end happy path after any deployment.
     * This test solve the purpose of smoke test
     */
    // Temporarily disabled due to the issue on dev
    @Test(description = "PeachTree Customize item", dataProvider = "browsers")
    public void test_PeachTreeCustomizeItemInPDP(String browser, String version, String os, Method method) throws Exception {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        pageManager.commonLogin().navigateToShopAllFromPopUpWindow();
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        // pageManager.loginPage().loggedAccountNumberText.isDisplayed();
        pageManager.homePage().searchByKeywordOrPartNumber("271797");
        pageManager.productListingPage().clickOnFirstCustomizeThisItemLinks();
        pageManager.customizeConfigModal().customizeWithPeachTreeProductSimple();
        pageManager.productDetailsPage().isDisplayedCustomizationIsSuccrssfullPopUp();
        pageManager.productDetailsPage().closeCustomizationIsSuccrssfullPopUp();
        pageManager.homePage().clickOnShoppingCartIcon();
        pageManager.shoppingCartPage().isYouHaveCustomizeLinkDisplayed();
    }
}
