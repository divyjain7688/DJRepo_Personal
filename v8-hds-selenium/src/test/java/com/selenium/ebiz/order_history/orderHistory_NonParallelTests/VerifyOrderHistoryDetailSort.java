/**
 * @author Bhavani
 * <p>
 * FMQA-2375 Verify Order History Detail Sort
 * <p>
 * ALM Test Instance ID: 649216
 */
package com.selenium.ebiz.order_history.orderHistory_NonParallelTests;

import com.selenium.ebiz.baseclass.BaseClassV8_Parallel;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyOrderHistoryDetailSort extends BaseClassV8_Parallel {

    /**
     *  Verifying the add to Cart from PLP List View
     * @throws Exception
     */

    @Test(description = "Login")
    public void testLogin() throws Exception {
        LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
    }

    @Test(dependsOnMethods = {"testLogin"}, description = "Verify Orders Page")
    public void verifyOrdersPage() throws Exception {
        pageManager.homePage().clickTopHeaderOrderHistoryStatusLink();
        Assert.assertTrue(pageManager.ordersPage().isDisplayedOrderspageHeading());
    }

    @Test(dependsOnMethods = {"verifyOrdersPage"}, description = "Verify Dropdowns on Orders Page")
    public void verifyDropdownsOnOrderPage() throws Exception {
        Assert.assertTrue(pageManager.ordersPage().isDisplayedorderHistorySortOptionsDropdown());
        Assert.assertTrue(pageManager.ordersPage().isDisplayedorderHistoryFilterDaysDropdown());
        Assert.assertTrue(pageManager.ordersPage().isDisplayedorderHistorySearchFilterDropdown());

    }

    @Test(dependsOnMethods = {"verifyDropdownsOnOrderPage"}, description = "verify Default Values On Drop Down")
    public void verifyDefaultValuesOnDropDown() throws Exception {
        Assert.assertTrue(pageManager.ordersPage().placedOnDefaultVal.isSelected());
        Assert.assertTrue(pageManager.ordersPage().ninetyDaysDefaultVal.isSelected());
        Assert.assertTrue(pageManager.ordersPage().salesOrderNumberDefaultVal.isSelected());

    }
	
	/*@Test(priority = 3, description="verify Default Values On Drop Down")
	public void verifDefaultValuesOnDropDown() throws Exception{
		//Assert.assertEquals(pageManager.ordersPage().getPlacedOnDefaultText(),"Placed On");
		//Assert.assertTrue(pageManager.ordersPage().ninetyDaysDefaultVal.isSelected());
		//Assert.assertTrue(pageManager.ordersPage().salesOrderNumberDefaultVal.isSelected());
		
	}*/

    @Test(dependsOnMethods = {"verifyDefaultValuesOnDropDown"}, description = "Verify All Sort Options Selected From DropDown")
    public void veriyAllSortOptionsFromDropDown() throws Exception {
        //pageManager.ordersPage().isSelectedAllSortOptions();
        pageManager.ordersPage().isSelectedAllSortOptionsFromDropDown();
    }

    @Test(dependsOnMethods = {"veriyAllSortOptionsFromDropDown"}, description = "Verify All Days Selected From DropDown")
    public void verifyAllDaysFromDropDown() throws Exception {
        pageManager.ordersPage().isSelectedAllDaysFromDropDown();
    }

    @Test(dependsOnMethods = {"verifyAllDaysFromDropDown"}, description = "Verify All Search Filter Options Selected From DropDown")
    public void veriyAllFilterSearchFromDropDown() throws Exception {
        pageManager.ordersPage().isSelectedAllFilterSearchFromDropDown();
    }

    @Test(dependsOnMethods = {"veriyAllFilterSearchFromDropDown"}, description = " Verify Order History Details Page")
    public void verifyOrderHistoryDetailsPage() throws Exception {
        pageManager.ordersPage().clickOnFirstOrderNumberInOrdersPage();
        Assert.assertTrue(pageManager.ordersHistoryDetailsPage().isDisplayedOrderHistoryDetailsTitle());
    }

    @Test(dependsOnMethods = {"verifyOrderHistoryDetailsPage"}, description = "Logout")
    public void testLogout() throws Exception {
        pageManager.loginPage().logoutOfApplication();

    }

}
