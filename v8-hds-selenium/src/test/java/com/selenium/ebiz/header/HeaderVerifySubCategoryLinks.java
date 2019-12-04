package com.selenium.ebiz.header;

import com.selenium.ebiz.baseclass.BaseClassV8_ParallelGrid;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.RandomAccountSelect;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class HeaderVerifySubCategoryLinks extends BaseClassV8_ParallelGrid{
	
	@Test(dataProvider = "browsers")
	public void header_verifyAllSubCategoryPagesUnderDoorAndMoulding(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickHeaderShopByCategoryLinkText();
		pageManager.homePage().verifyAllSubcategoryPage("clickOnDoorAndMouldingLinks","HDSTestdata");
	} 
	
	@Test(dataProvider = "browsers", enabled = false)
	public void header_verifyAllSubCategoryPagesUnderElectrical(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickHeaderShopByCategoryLinkText();
		pageManager.homePage().verifyAllSubcategoryPage("clickOnElectricalLinks","HDSTestdata");
	} 
	


		/**
		 W80 - 9272 - issue: STG header_verifyAllSubCategoryPagesUnderFlooringCeiling
		 Fixed by - Bino Jayasingh

		 FYI: Enabling the Test.Fixed the issue related to 3 layer selection of sub category.now it supports 3 layer sub category selection.Previously its supports only 2 layer sub category selection
	
		 */
	
	@Test(dataProvider = "browsers")
	public void header_verifyAllSubCategoryPagesUnderFlooringCeiling(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
        pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickHeaderShopByCategoryLinkText();
		pageManager.homePage().verifyAllSubcategoryPage("clickOnFlooringCeilingLinks","HDSTestdata");
	} 


	@Test(dataProvider = "browsers", enabled = false)
	public void header_verifyAllSubCategoryPagesUnderHealthcareSupplies(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickHeaderShopByCategoryLinkText();
		pageManager.homePage().verifyAllSubcategoryPage("clickOnHealthcareSuppliesLinks","HDSTestdata");
	} 

	@Test(dataProvider = "browsers", enabled = false)
	public void header_verifyAllSubCategoryPagesUnderHospitalitySupplies(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickHeaderShopByCategoryLinkText();
		pageManager.homePage().verifyAllSubcategoryPage("clickOnHospitalitySuppliesLinks","HDSTestdata");
	} 
	
	@Test(dataProvider = "browsers", enabled = false)
	public void header_verifyAllSubCategoryPagesUnderHVAC(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickHeaderShopByCategoryLinkText();
		pageManager.homePage().verifyAllSubcategoryPage("clickOnHVACLinks","HDSTestdata");
	} 
	
	@Test(dataProvider = "browsers", enabled = false)
	public void header_verifyAllSubCategoryPagesUnderJanitorial(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickHeaderShopByCategoryLinkText();
		pageManager.homePage().verifyAllSubcategoryPage("clickOnJanitorialLinks","HDSTestdata");
	} 
	
	@Test(dataProvider = "browsers", enabled = false)
	public void header_verifyAllSubCategoryPagesUnderTools(String browser, String version, String os, Method method) throws Exception
	{
		this.createDriver(browser, version, os, method.getName());
		WebDriver driver = this.getWebDriver();
		PageManager pageManager = new PageManager(driver);
		pageManager.commonLogin().LoginToHDS(RandomAccountSelect.users.pop(), configread.getPassword());
		pageManager.homePage().clickHeaderShopByCategoryLinkText();
		pageManager.homePage().verifyAllSubcategoryPage("clickOnToolsLinks","HDSTestdata");
	} 
	
	
}



