package com.selenium.ebiz.prerequisites_tests;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ListCreationTests extends BaseClassV8_ParallelGrid {
    private ArrayList<UsersListBean> usersList;
    private String newlistcreated,newListName;


    @Test(dataProvider = "browsers",invocationCount = 96)
    public void createNewPrivateAndSharedListForTheUserAccounts(String browser, String version, String os, Method method) throws Exception
    {
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        PageManager pageManager = new PageManager(driver);

        addtoPrivatelist(pageManager);
        driver.navigate().refresh();
        addtoPrivatelist2(pageManager);

        driver.navigate().refresh();

        addtoSharedNewlist(pageManager);
        driver.navigate().refresh();
        addtoSharedNewlist2(pageManager);

    }


    public void addtoPrivatelist(PageManager pageManager) throws Exception {
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickOnQuickOrderLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(),usersList.get(0).getQuantity1());
        pageManager.quickOrderPad().clickAddTolist();
        newlistcreated=pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
    }

    public void addtoPrivatelist2(PageManager pageManager) throws Exception {

        pageManager.homePage().clickOnQuickOrderLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber2(),usersList.get(0).getQuantity1());
        pageManager.quickOrderPad().clickAddTolist();
        newlistcreated=pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
    }

    public void addtoSharedNewlist(PageManager pageManager) throws Exception {
      //  pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
        pageManager.homePage().clickOnQuickOrderLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber1(),usersList.get(0).getQuantity1());
        pageManager.quickOrderPad().clickAddTolist();
        newlistcreated=pageManager.addToExistingORCreateNewList_modal().addItemToNewSharedList(newListName);
    }

    public void addtoSharedNewlist2(PageManager pageManager) throws Exception {

        pageManager.homePage().clickOnQuickOrderLink();
        usersList = pageManager.dBCon().loadDataFromExcel("addProductsUsingQuickOrder", "QuickOrder");
        pageManager.quickOrderPad().fillFirstPartAndQuantityQuickOrderPad(usersList.get(0).getPartNumber2(),usersList.get(0).getQuantity1());
        pageManager.quickOrderPad().clickAddTolist();
        newlistcreated=pageManager.addToExistingORCreateNewList_modal().addItemToNewSharedList(newListName);
    }



}
