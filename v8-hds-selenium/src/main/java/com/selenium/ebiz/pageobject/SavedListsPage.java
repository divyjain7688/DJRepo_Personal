package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SavedListsPage {
	private  WebDriver driver; 
	private WaitTool waitTool;
	private PageManager pageManager;


	public SavedListsPage(WebDriver driver) 	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager = new PageManager(driver);
	}


	@FindBy(xpath = "//div[@class='el--flex']")
	WebElement showXXPerPageText;

	@FindBy(xpath = "//span[@class='type--caption el--margin-right-3']")
			//"//span[@class='type--body-large el--margin-right-4']")
	WebElement itemsInListText;

	@FindBy(xpath = "//td[@class='saved-lists__table--full-customizedPartWidthDimension jq-saved-lists-each-display-row']/strong")
	public WebElement DisplayedListName;

	@FindBy(xpath = "//div[@class='widget-wrapper__header']//h3[contains(text(),'Add to existing or Create new list')]")
	WebElement addToExistingOrCreateNewListText;

	@FindBy(xpath = "//tr[@class='jq-saved-lists-display-row'][1]/td[1]")
	WebElement existingFirstSavedList;

	@FindBy(xpath = "//button[contains(text(),'ADD TO LIST')]")
	WebElement addButton;

	@FindBy(xpath = "//a[contains(text(),'DELETE')]")
	WebElement deleteButton;

	@FindBy(xpath = "//a[contains(text(),'PRINT BIN LABELS')]")
	WebElement printBinLabelsLink;

	@FindBy(xpath = "//button[contains(text(),'REMOVE')]")
	List<WebElement> RemoveProductsFromSavedList;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[contains(text(),'1-800-431-3000')]")
	public WebElement contactNumberOnBinLabel;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[contains(text(),'1-800-431-3000')]/following-sibling::div[1]")
	public	WebElement productDescriptionOnBinLabel;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[contains(text(),'1-800-431-3000')]/following-sibling::div[3]")
	public	WebElement hDSPartTextOnBinLabel;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[contains(text(),'1-800-431-3000')]/following-sibling::div[4]")
	WebElement hDSPartOnBinLabel;

	@FindBy(xpath = "//tr[@class='jq-saved-lists-display-row'][1]/td[1]")
	public	WebElement firstListUnderPrivateList;

	@FindBy(xpath = "//tr[@class='jq-saved-lists-display-row'][1]/td[1]")
	WebElement firstListUnderSharedList;

	@FindBy(xpath = "//h1[text()='Saved Lists']")
	WebElement savedListspageHeadingText;

	@FindBy(xpath ="//*[@data-hds-tag='saved-lists__add-to-cart']")
	List<WebElement> addListToCartButton;

	@FindBy(xpath = "//a[contains(text(),'DELETE')]")
	WebElement deleteLinkText;

	@FindBy(xpath = "//a[contains(text(),'Private Lists')]")
	WebElement privateList;

	@FindBy(xpath = "//a[contains(text(),'Shared Lists')]")
	WebElement sharedList;

	@FindBy(partialLinkText = "")
	WebElement listNameStartsWithList_LinkText;

	@FindBy(xpath="//tr[@class='jq-saved-lists-display-row'][1]/td[1]")
	WebElement firstSavedListLinkText;


	@FindBy (xpath = "//div[@class='pagination__info']/input")
	WebElement paginationInfo;

	@FindBy (xpath= "//span[@class='type--body-large el--margin-right-4']/strong")
	WebElement savedListItems;

	@FindBy (xpath = "//div[@class='pagination__info']/following-sibling::a")
	WebElement paginationForward;

	@FindBy (xpath = "//div[@class='pagination__info']/preceding-sibling::a")
	WebElement paginationBackWard;

	@FindAll(@FindBy(xpath= "//div[@class='pagination']/preceding-sibling::section"))
	List<WebElement> savedListItemsInAPage;

	@FindBy(xpath = "//div[@class='cart-added__details']//a[contains(text(),'Checkout')]")
	WebElement checkOutButton;

	@FindBy(xpath="//a[contains(text(),'Upload Template')]")
	WebElement upLoadTemplateLinkText;

	@FindBy(xpath="//h3[text() = 'Upload saved list']")
	WebElement uploadSavedListModalHeadingText;

	@FindBy(xpath = "//input[@id='UpLoadedFile']")
	WebElement chooseFile;

	@FindBy(xpath = "//a[text() = 'Click here to download a save list template']")
	WebElement clickHereToDownloadLink;

	@FindBy(xpath = "//div[text()='Add as a New List']")
	WebElement addAsANewListRadioButton;

	@FindBy(xpath="//a[contains(text(),'Download Template')]")
	WebElement downLoadTemplateLinkText;

	@FindBy(xpath ="//table[@class='table--responsive saved-lists__table']")
	public WebElement tableOfLists;
	
	@FindBy(xpath ="//th[contains(text(),'List Name')]")
	WebElement tableHeaderListNameText;
	
	@FindBy(xpath ="//th[contains(text(),'List Name')]")
	WebElement tableHeaderItemsText;
	
	@FindBy(xpath ="//th[contains(text(),'List Name')]")
	WebElement tableHeaderListNotesText;
	
	@FindBy(xpath ="//th[contains(text(),'List Name')]")
	WebElement tableHeaderLastUpdatedText;

	@FindBy(xpath ="//span[@class='type--body-large el--margin-right-4']/strong[text()='0']/..")
	WebElement noItemAddedMessage;

	@FindBy(xpath = "//a[contains(text(),'Private Lists')]")
	WebElement privateLists;

	@FindBy(xpath = "//a[contains(text(),'Shared Lists')]")
	WebElement sharedLists;

	@FindBy (xpath="//a[contains(text(),'Convert To Shared List')]")
	WebElement convertToSharedList;

	@FindBy (xpath="//a[contains(text(),'CONVERT TO PRIVATE LIST')]")
	WebElement convertToPrivateList;

	@FindBy (xpath ="//a[contains(text(),'EMAIL LIST')]")
	WebElement emailList;

	@FindBy (xpath ="//a[contains(text(),'DELETE')]")
	WebElement delete;

	@FindBy(xpath = "//a[contains(text(),'PRINT BIN LABELS')]")
	WebElement printBinLabel;

	@FindBy (xpath = "//input[@id='newListName']")
	WebElement createNewListNameText;

	@FindBy (xpath = "//div[@class='el--margin-top-2 el--hide--mobile']//button[contains(text(),'Create New List')]")
	WebElement createNewListButton;

	@FindBy (xpath = "//div[text()='Private']/../span")
	WebElement createNewListPrivateRadioBtn;

	@FindBy (xpath = "//div[text()='Shared']/../span")
	WebElement createNewListSharedRadioBtn;

	@FindBy(xpath = "//div[text()='Private']/../span")
	WebElement addToPrivateListRadioButton;

	@FindBy(xpath = "//div[text()='Shared']/../span")
	WebElement addToSharedListRadioButton;

	/*@FindBy(xpath="//a[@id='GotoCartButton1']")
	WebElement modalViewCartButton;*/

	/*	@FindBy(xpath="//div[@class=\\'subcat-list-tile__details\\']/div[1][contains(text(),''+productDescription+'')]/../../..//button[contains(text(),'REMOVE FROM LIST')]")
	WebElement removeFromListButtonForNewlyAddedProduct;*/

	@FindBy(xpath="//*[contains(text(),'Recently Updated')]")
	public WebElement recentlyUpdatedLink;
	
	@FindBy(xpath = "//div[contains(text(),'Sort by')]")
	WebElement sortByText;
	
	@FindBy(xpath="//div[@class='saved-lists__sort-by select--alt']//select[@class='select--alt']")
	WebElement sortByDropDown;

	@FindBy(xpath="//div[@class='saved-lists__per-page select--alt el--margin-right-1']/select[@class='select--alt']")
	WebElement showPerPageDropdown;

	@FindBy(xpath="//span[@class='type--body-large el--margin-right-3 el--flex el--flex--center']/strong")
	WebElement numberOfListTextDisplayed;

	@FindBy(xpath="//tr[@class='jq-saved-lists-display-row']/td[1]/strong")
	List<WebElement> DisplayedListNames;

	@FindBy(xpath = "//*[@class='saved-lists__table--full-customizedPartWidthDimension jq-saved-lists-each-display-row']")
	List<WebElement> getListOfAllListsNames;

	//@FindBy(xpath="//div[@class='subcat-list-tile__part-quantity-availability']/span")
	@FindBy(xpath="//div[@class='saved-list__part-number']")
	WebElement partNoFromList;

	@FindBy(xpath="//div[@class='pagination__info']")
	WebElement pageNumberBlock;
	
	@FindBy(xpath="//strong[contains(text(),'Create a new list to start adding items to the list.')]")
	WebElement msgToAddNewList;
	
	@FindBy(xpath = "//td[@class='saved-lists__table--bg-white jq-saved-lists-each-display-row']")
	List<WebElement> itemsCountInEachList;

	@FindBy (xpath = "//strong[text()='Create a new list to start adding items to the list. ']")
	WebElement noPrivateListMessage;
	/**
	 *  Method to verify for the List in the left Pane
	 * @return
	 */
	public boolean isDisplayedListOnLeftPage(){
		return pageManager.common().isElementPresent(firstSavedListLinkText);
	}

	public boolean isDisplayedUpLoadTemplateLinkText(){
		return pageManager.common().isElementPresent(upLoadTemplateLinkText);
	}

	public void clickUpLoadTemplateLinkText() throws InterruptedException {
		upLoadTemplateLinkText.click();
	} 

	public boolean isDisplayedUploadSavedListModalHeadingText(){
		waitTool.waitForElement(driver, uploadSavedListModalHeadingText);
		return uploadSavedListModalHeadingText.isDisplayed();
	}


	/**
	 *  Method to click on Download Template in SavedPages
	 * @return
	 * @throws InterruptedException
	 */
	public HomePage clickUploadFile() throws InterruptedException {
		waitTool.waitForElement(driver, chooseFile);
		pageManager.common().scrolltoViewElement(chooseFile, driver);
		chooseFile.click();
		return new HomePage(driver);
	}

	public boolean isDisplayedChooseFile(){
		return chooseFile.isDisplayed();
	}

	public boolean isDisplayedClickHereToDownloadLink(){
		return clickHereToDownloadLink.isDisplayed();
	}

	public boolean isSelectedAddToPrivateListRadioButton(){
		addToPrivateListRadioButton.click();
		return addToPrivateListRadioButton.isSelected();
	}

	public boolean isSelectedAddToSharedListRadioButton(){
		addToSharedListRadioButton.click();
		return addToSharedListRadioButton.isSelected();
	}



	public boolean isSelectedAddAsANewListRadioButton(){
		addAsANewListRadioButton.click();
		return addAsANewListRadioButton.isSelected();
	}

	public boolean isDisplayedDownLoadTemplateLinkText(){
		return pageManager.common().isElementPresent(downLoadTemplateLinkText);
	}

	public void clickDownLoadTemplateLinkText() throws InterruptedException {
		downLoadTemplateLinkText.click();
	} 
	
	public boolean isDisplayedMsgToAddNewList(){
		return pageManager.common().isElementPresent(msgToAddNewList);
	}
	
	/**



	public boolean isDisplayedRemoveFromListLink(){
		return .isElementPresent(removeFromListLinkText.get(0));
	}

	/**
	 * Click on create new list button.
	 * @return
	 */
	public void clickOnCreateNewList() {
		waitTool.waitForElement(driver, createNewListButton);
		createNewListButton.click();
	}
	
	
	public boolean isDisplayedCreateNewListButton() {
		return pageManager.common().isElementPresent(createNewListButton);
	}

	public boolean isDisplayedPrintBinLabel() {
		return pageManager.common().isElementPresent(printBinLabel);
	}
	
	public boolean isDisplayedsortByText(){
		return pageManager.common().isElementPresent(sortByText);
	}

	public boolean isDisplayedConvertToSharedList() {
		return pageManager.common().isElementPresent(convertToSharedList);
	}

	public void clickOnConvertToSharedList() {
		convertToSharedList.click();
		pageManager.common().acceptPopupMessageBox(driver);
		pageManager.common().acceptPopupMessageBox(driver);
	}

	public boolean isDisplayedEmailList() {
		return pageManager.common().isElementPresent(emailList);
	}
	
	public boolean isDisplayedDelete() {
		return pageManager.common().isElementPresent(delete);
	}
	
	public boolean isDisplayedConvertToPrivateList() {
		return pageManager.common().isElementPresent(convertToPrivateList);
	}

	public void acceptPopUp() {
		pageManager.common().acceptPopupMessageBox(driver);
	}

	public void cancelPopUp() {
		pageManager.common().cancelPopupMessageBox(driver);
	}

	/**
	 * get Page Heading text
	 * @return string page heading text
	 */
	public String getSavedListspageHeadingText() {
		return savedListspageHeadingText.getText().trim();
	}

	public boolean isDisplayedSavedListspageHeadingText() {
		waitTool.waitForElement(driver, savedListspageHeadingText);
		return pageManager.common().isElementPresent(savedListspageHeadingText);
	}

	/**
	 * @return true if new list created displayed in Saved List page otherwise false
	 */
	public String getNewlyCreatedList() 
	{		
		/*waitTool.waitForElement(driver, recentlyUpdatedLink);
		.scrolltoViewElement(recentlyUpdatedLink, driver);
		recentlyUpdatedLink.click();*/
		selectRecentlyUpdatedFromSortByDropdown();
		waitTool.waitForElement(driver, firstListUnderPrivateList);
		pageManager.common().scrolltoViewElement(firstListUnderPrivateList, driver);
		return firstListUnderPrivateList.getText();
	}


	public void clickOnNewlyCreatedList() 
	{
		waitTool.waitForElement(driver, firstListUnderPrivateList);
		pageManager.common().scrolltoViewElement(firstListUnderPrivateList, driver);
		System.out.println("firstListUnderPrivateList is "+ firstListUnderPrivateList);
		firstListUnderPrivateList.click();
		waitTool.waitForElement(driver, pageManager.savedListsDetailPage().lastUpdatedText);
	}

	public void getListNameOfNewlyCreatedList(){
		selectRecentlyUpdatedFromSortByDropdown();
		firstListUnderPrivateList.getText();
	}

	/**
	 * click the list for which name starts with "List_"
	 */
	public void clickListNameStartsWithList_LinkText() {
		listNameStartsWithList_LinkText.click();
	}

	public void clickOnExistingFirstSavedList()
	{
		waitTool.waitForElement(driver, existingFirstSavedList);
		pageManager.common().scrolltoViewElement(existingFirstSavedList, driver);
		existingFirstSavedList.click();
		waitTool.waitForElement(driver, itemsInListText);
	}

	public void deleteTheNewlyCreatedList() throws Exception {
		pageManager.common().scrolltoViewElement(firstListUnderPrivateList, driver);
		firstListUnderPrivateList.click();
		pageManager.common().scrolltoViewElement(deleteButton, driver);
		deleteButton.click();
		waitTool.waitForAlert(driver);
		pageManager.common().acceptPopupMessageBox(driver);
	}

	public boolean checkPrivateListSelected() {
		String classname = privateList.getAttribute("class");
		return classname.contains("tab--selected");			
	}

	/**
	 * click the shared list
	 */
	public void clickSharedListt() {
		waitTool.waitForElement(driver,sharedList);
		pageManager.common().scrolltoViewElement(sharedList, driver);
		sharedList.click();
	}

	/**
	 * Delete the List from Saved Lists
	 */
	public void clickDeleteLinkText() {
		deleteLinkText.click();
		waitTool.waitFor(driver, true);
	}




	public void removeProductsFromExistingList() throws Exception
	{
		for(WebElement RemoveProductFromSavedList : RemoveProductsFromSavedList)
		{

			System.out.println(RemoveProductFromSavedList.getText());
		}

		int i =0;
		for(WebElement RemoveProductFromSavedList : RemoveProductsFromSavedList)
		{
			i++;
			System.out.println("value of i is"+ i);
			//	.refresh(driver);
			waitTool.waitForElement(driver, RemoveProductFromSavedList);
			pageManager.common().scrolltoViewElement(RemoveProductFromSavedList, driver);
			RemoveProductFromSavedList.click();
			//waitTool.hardWait();
			waitTool.waitForAlert(driver);
			pageManager.common().acceptPopupMessageBox(driver);
			//waitTool.hardWait();
			waitTool.waitForAlert(driver);
			//.acceptPopupMessageBox(driver);
			pageManager.common().refresh();
			//clickOnExistingFirstSavedList();
		}

	}

	/*public void removeNewlyAddedPartFromExistingList(String productDescription) throws Exception
	{

		removeFromListButtonForNewlyAddedProduct.click();
		//	waitTool.hardWait();
		waitTool.waitForAlert(driver);
		.acceptPopupMessageBox(driver);
		//	waitTool.hardWait();
		waitTool.waitForAlert(driver);
		.acceptPopupMessageBox(driver);

	}*/
	/**
	 * click email page link
	 */
	/*public void clickEmailPageLink() {
		emailPageLink.click();
	}*/

	/**
	 * @return true if email link is displayed on page otherwise false
	 */
	/*public boolean isDisplayedEmailPageLink(){
		return .isElementPresent(emailPageLink);
	}*/	

	/*public void clickHeaderMiniCartButton() throws InterruptedException {
		waitTool.waitForElement(driver, headerMiniCartButton);
		headerMiniCartButton.click();
		waitTool.waitFor(driver,true) ;
	}
	 */

	/*public void clickModalViewCartButton() throws InterruptedException {
		waitTool.waitForElement(driver, modalViewCartButton);
		modalViewCartButton.click();
		waitTool.waitFor(driver,true) ;
		//	return new ShoppingCartPage(driver);

	}*/

	/**
	 * Below methods will check for Private and shared lists
	 */

	public void clickOnPrivateLists() {
		privateLists.click();
	}
	public void clickOnSharedLists() {
		sharedLists.click();
	}

	public boolean isDisplayedPrivateListsTab() {
		return pageManager.common().isElementPresent(privateLists);
	}

	public boolean isDisplayedSharedListsTab() {
		return pageManager.common().isElementPresent(sharedLists);
	}

	public boolean isDisplayedaddButton() {
		return pageManager.common().isElementPresent(addButton);
	} 
	
	public boolean isDisplayedTableOfLists() {
		pageManager.common().scrolltoViewElement(tableOfLists, driver);
		return pageManager.common().isElementPresent(tableOfLists);
	}
	
	public boolean isDisplayedTableHeaderListNameText() {
		pageManager.common().scrolltoViewElement(tableHeaderListNameText, driver);
		return pageManager.common().isElementPresent(tableHeaderListNameText);
	}
	
	public boolean isDisplayedTableHeaderItemsText() {
		return pageManager.common().isElementPresent(tableHeaderItemsText);
	}
	
	public boolean isDisplayedTableHeaderLastUpdatedText() {
		return pageManager.common().isElementPresent(tableHeaderLastUpdatedText);
	}
	
	public boolean isDisplayedTableHeaderListNotesText() {
		return pageManager.common().isElementPresent(tableHeaderListNotesText);
	}

	public boolean isSelectedSharedListsTab() {
		return sharedLists.isSelected();
	}

	public void paginationVerification() throws Exception {
		int totalSavedListItems= Integer.parseInt(savedListItems.getText());
		if(totalSavedListItems>26) {
			int initialPage = Integer.parseInt(paginationInfo.getAttribute("value"));
			System.out.println(initialPage);
			int maxPage = Integer.parseInt(paginationInfo.getAttribute("max"));
			int minPage = Integer.parseInt(paginationInfo.getAttribute("min"));
			int currentPage=0;
			if(initialPage==1 && pageManager.common().isElementPresent(paginationForward)) {
				Assert.assertEquals(26,savedListItemsInAPage.size());
				for(int i=initialPage;i<maxPage;i++) {
					pageManager.common().scrolltoViewElement(paginationForward, driver);
					paginationForward.click();
					//waitTool.hardWait();
					waitTool.waitForElement(driver, paginationBackWard);
					Assert.assertTrue(pageManager.common().isElementPresent(paginationBackWard));
					currentPage=Integer.parseInt(paginationInfo.getAttribute("value"));
					System.out.println("current page is " + currentPage);
					//Assert.assertTrue(.isElementPresent(paginationForward));
					Assert.assertEquals(initialPage=initialPage+1 ,currentPage );
					/*if(currentPage!=maxPage)
					Assert.assertEquals(totalSavedListItems-26,savedListItemsInAPage.size());
					else
					Assert.assertEquals(totalSavedListItems-26*currentPage-1,savedListItemsInAPage.size());*/
				}

				for(int i=initialPage;i>minPage;i--) {
					pageManager.common().scrolltoViewElement(paginationBackWard, driver);
					paginationBackWard.click();
					//	waitTool.hardWait();
					waitTool.waitForElement(driver, paginationForward);
					Assert.assertTrue(pageManager.common().isElementPresent(paginationForward));
					currentPage=Integer.parseInt(paginationInfo.getAttribute("value"));
					System.out.println("current page is " + currentPage);
					//Assert.assertTrue(.isElementPresent(paginationForward));
					Assert.assertEquals(initialPage=initialPage-1 ,currentPage );
					//Assert.assertEquals(totalSavedListItems-25,savedListItemsInAPage.size());
				}
			}
		}

	}

	/**
	 * click the list 
	 */
	public void clickFirstSavedListNameLinkText() {
		firstSavedListLinkText.click();
	}

	public String getFirstSavedListNameLinkText() {
		return firstSavedListLinkText.getText();
	}

	public void clickOnPrintBinLabelsLink()
	{
		waitTool.waitForElement(driver, printBinLabelsLink);
		pageManager.common().scrolltoViewElement(printBinLabelsLink, driver);
		//	String currentWindowHandle= driver.getWindowHandle();
		//	System.out.println("Current New List window: " + currentWindowHandle);

		printBinLabelsLink.click();
		pageManager.common().moveToNewWindow(driver);
	}

	public void verifyPrintLabelsAreDisplayed() throws Exception{
		String[] labels = {"isContactNumberOnBinLabelDisplayed: " + isContactNumberOnBinLabelDisplayed(),
				"isProductDescriptionOnBinLabelDisplayed: " + isProductDescriptionOnBinLabelDisplayed(),
				"isHDSPartTextOnBinLabelDisplayed:" + isHDSPartTextOnBinLabelDisplayed()};
		for (String l: labels){
			System.out.println("Print Labels: " + l);
		}

	}

	public void navigateBackToMainWindowFromPrintLabel(){

		pageManager.common().closecurrentBrowser(driver);
		pageManager.common().moveToNewWindow(driver);
		driver.navigate().refresh();
	}

	public Boolean isContactNumberOnBinLabelDisplayed() throws Exception
	{

		waitTool.waitForElement(driver, contactNumberOnBinLabel);
		pageManager.common().scrolltoViewElement(contactNumberOnBinLabel, driver);
		contactNumberOnBinLabel.getSize();

		return contactNumberOnBinLabel.isDisplayed();
	}

	public Boolean isProductDescriptionOnBinLabelDisplayed()
	{
		productDescriptionOnBinLabel.getSize();
		return productDescriptionOnBinLabel.isDisplayed();
	}

	public Boolean isHDSPartTextOnBinLabelDisplayed()
	{
		hDSPartTextOnBinLabel.getSize();
		return hDSPartTextOnBinLabel.isDisplayed();
	}

	public String isHDSPartNumberOnBinLabelDisplayed()
	{
		return hDSPartOnBinLabel.getText();
	}


	public void clickOnAddListToCartButton() throws Exception
	{
		waitTool.waitForElement(driver, addListToCartButton.get(0));
		pageManager.common().scrolltoViewElement(addListToCartButton.get(0), driver);
		addListToCartButton.get(0).click();
	}

	public boolean isDisplayedAddListToCart(){
		waitTool.waitForElement(driver, addListToCartButton.get(0));
		return addListToCartButton.get(0).isDisplayed();

	}
	
	public Boolean verifyAddListToCartButtonOnEachList() throws Exception
	{
		Boolean addListToCartDisplayed = false;
		System.out.println("numberOfListDisplayed.size(): "+ DisplayedListNames.size());
		int numberOfList = DisplayedListNames.size();
		for(int i=0; i < numberOfList; i++){
			addListToCartDisplayed = pageManager.common().isElementPresent(addListToCartButton.get(i));
		}
		return addListToCartDisplayed;
	}


	public void clickonCheckOutButton() throws Exception {
		waitTool.waitForElement(driver, checkOutButton);
		pageManager.common().scrolltoViewElement(checkOutButton, driver);
		checkOutButton.click();
		//	return new ShoppingCartPage(driver);
	}

	public void clickOnRecentlyUpdatedLink()
	{
		waitTool.waitForElement(driver, recentlyUpdatedLink);
		pageManager.common().scrolltoViewElement(recentlyUpdatedLink, driver);
		recentlyUpdatedLink.click();
		waitTool.waitFor(driver, true);
	}

	public int getNumberOfListTextDisplayed()
	{
		return Integer.parseInt(numberOfListTextDisplayed.getText());

	}
	
	public boolean isDisplayedNumberOfListText() {
		waitTool.waitForElement(driver, numberOfListTextDisplayed);
		return pageManager.common().isElementPresent(numberOfListTextDisplayed);
}
	
	public Boolean isDisplayedPagination()
	{
		pageManager.common().scrolltoViewElement(pageNumberBlock, driver);
		return pageManager.common().isElementPresent(pageNumberBlock);
	}

	public int getNumberOfListDisplayed()
	{
		int totalPageCount =0;
		int numberOfLists=0;
		numberOfLists=numberOfLists+DisplayedListNames.size();
		Boolean pageNumberCount = false;
		try 
		{ 
			pageNumberBlock.isDisplayed();
			pageNumberCount=true;
		}
		catch(Exception e)
		{
			System.out.println("pageNumberBlock is not displayed " + e);
		}

		if(pageNumberCount.equals(true))
		{
			String totalPage = pageNumberBlock.getText();
			totalPage=totalPage.substring(totalPage.lastIndexOf(" "));
			totalPage=totalPage.trim();
			totalPageCount = Integer.parseInt(totalPage);
			System.out.println("totalPage count is "+totalPage);

			for(int j=0;j<totalPageCount-1;j++)
			{
				try
				{
					paginationForward.click();
				}
				catch(Exception e)
				{
					System.out.println("paginationForward button is not displayed" + e );
				}
				waitTool.waitFor(driver, true);
				numberOfLists=numberOfLists+DisplayedListNames.size();
				System.out.println(j + " numberOfLists = " + numberOfLists);
			}
		}


		return numberOfLists;
	}



	public void clickOnList(String listToBeClicked) 
	{	
		waitTool.waitForElement(driver, recentlyUpdatedLink);
		System.out.println("listToBeClicked isss "+ listToBeClicked);
		for(WebElement DisplayedListName:DisplayedListNames)
		{
			if(DisplayedListName.getText().trim().equals(listToBeClicked))
			{
				System.out.println("DisplayedListName iss +"+ DisplayedListName);
				DisplayedListName.click();
				break;
			}
			else
			{
				System.out.println("listToBeClicked is not displayed");
			}
		}

	}

	public void navigateToSavedListPageAndClickOnRecentlyUpdatedList() {
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		selectRecentlyUpdatedFromSortByDropdown();
	}

	public void selectRecentlyUpdatedFromSortByDropdown()
	{
		waitTool.waitForElement(driver, sortByDropDown);
		pageManager.common().scrolltoViewElement(sortByDropDown, driver);
		Select select = new Select(sortByDropDown);
		select.selectByVisibleText("Recently Updated");
		System.out.println("selectRecentlyUpdatedFromSortByDropdown");
	}

	public void selectListNameAToZFromSortByDropdown()
	{
		waitTool.waitForElement(driver, sortByDropDown);
		pageManager.common().scrolltoViewElement(sortByDropDown, driver);
		Select select = new Select(sortByDropDown);
		select.selectByVisibleText("List Name A-Z");
	}

	public Boolean isShowXXPerPageTextDisplayed()
	{
		waitTool.waitForElement(driver, showXXPerPageText);
		pageManager.common().scrolltoViewElement(showXXPerPageText, driver);
		return pageManager.common().isElementPresent(showXXPerPageText);
	}

	public Boolean isListNameDisplayedInAscendingOrder()
	{
		Boolean sorted=true;
		int i=0;
		String []listNameText =new String[DisplayedListNames.size()];
		for(WebElement DisplayedListName : DisplayedListNames)
		{
			listNameText[i]=DisplayedListName.getText();
			System.out.println("listNameText"+i + listNameText[i]);
			i++;
		}
		List<String> listNames = Arrays.asList(listNameText);  
		for(int j = 0; i < listNames.size() - 1; i++) 
		{
			System.out.println("listName "+j+  listNames.get(j));

			if(listNames.get(j+1).compareTo(listNames.get(j)) < 0) 
			{ 
				sorted=false;
				break;
			}

		}

		return sorted;
	}

	public String getDefaultValueFromShowPerPageDropdown()
	{
		waitTool.waitForElement(driver, showPerPageDropdown);
		pageManager.common().scrolltoViewElement(showPerPageDropdown, driver);
		Select option = new Select(showPerPageDropdown);
		return option.getFirstSelectedOption().getText();
	}

	public void VerifyTheListGetSortedBy(String option) {
		if (getListOfAllListsNames.size()>1) {
			ArrayList<String> defaultList = new ArrayList<>();
			for (WebElement beforeSort: getListOfAllListsNames)

			{
				defaultList.add(beforeSort.getText());
				System.out.println("obtainedList: " + defaultList);
			}
			pageManager.savedListsDetailPage().selectOptionFromSortByDropdown(option);

			ArrayList<String> sortedList = new ArrayList<>();
			for (WebElement afterSort: getListOfAllListsNames)

			{
				sortedList.add(afterSort.getText());
				System.out.println("sortedList: " + sortedList);
			}

			sortedList.addAll(defaultList);
			System.out.println("sortedList: " + sortedList);
			Assert.assertNotEquals(sortedList, defaultList);
		} else {
			System.out.println("There is only one part number in the list");
		}
	}

	public int[] getAllOptionsFromShowPerPageDropdown()
	{
		Select option = new Select(showPerPageDropdown);
		List<WebElement> dropdownValues = option.getOptions();
		int i=0;
		int []optionsText =new int[dropdownValues.size()];
		for(WebElement dropdownValue : dropdownValues)
		{
			optionsText[i]=Integer.parseInt(dropdownValue.getText());
			System.out.println("optionsText"+i + optionsText[i]);
			i++;
		}
		
		System.out.println("actaul valuesss" + Arrays.toString(optionsText));
		return optionsText;
	}
	

	public void verifyNumberOfListDisplayed(String optionValue)
	{
		int numberOfListTextDisplayed =getNumberOfListTextDisplayed();
		if(numberOfListTextDisplayed==0)
		{
			System.out.println("There are 0 list dispalyed on saved list page");
		}
		else
		{
			Select option = new Select(showPerPageDropdown);
			option.selectByVisibleText(optionValue);
			int optionIntegerValue = Integer.parseInt(optionValue);
			if(optionIntegerValue>numberOfListTextDisplayed)
			{
				Assert.assertTrue(DisplayedListNames.size()==numberOfListTextDisplayed);
			}
			else
			{
				Assert.assertTrue(DisplayedListNames.size()==optionIntegerValue);

			}
		}
	}
	
	
	public void verifyPaginationWhenOptionIsSelectedFromDropdown(String optionValue)
	{	
		int optionIntegerValue = Integer.parseInt(optionValue);
		int expectedNumberofPages;
		int numberOfListTextDisplayed =getNumberOfListTextDisplayed();
		if(numberOfListTextDisplayed==0)
		{
			System.out.println("There are 0 list dispalyed on saved list page");
		}
		else
		{
		Select option = new Select(showPerPageDropdown);
		option.selectByVisibleText(optionValue);
		if(numberOfListTextDisplayed>optionIntegerValue)
		{
			expectedNumberofPages= numberOfListTextDisplayed/optionIntegerValue+1;
		}
		else
		{
			expectedNumberofPages= 1/*numberOfListTextDisplayed*/;
		}
		System.out.println("expectedNumberofPages is " + expectedNumberofPages);
		int actualNumberofPages = numberOfPages();
		Assert.assertEquals(actualNumberofPages, expectedNumberofPages);		
		}
	}
	
	
	public int numberOfPages()
	{
		try
		{
			String totalPage = pageNumberBlock.getText();
			totalPage=totalPage.substring(totalPage.lastIndexOf(" "));
			totalPage=totalPage.trim();
			int actualNumberofPages = Integer.parseInt(totalPage);
			System.out.println("actualNumberofPages is "+actualNumberofPages);
			return actualNumberofPages;
		}
		catch(Exception e)
		{
			System.out.println("there is no pagination");
			return 1;
		}
	}
	
	public void deleteListWithZeroProducts() throws InterruptedException
	{
		for(int i=itemsCountInEachList.size()-1;i>=0;i--)
		{
			waitTool.waitForElement(driver, itemsCountInEachList.get(i));
			pageManager.common().scrolltoViewElement(itemsCountInEachList.get(i), driver);
			System.out.println("itemCountInEachList.getText().trim()" + itemsCountInEachList.get(i).getText().trim());

			if(itemsCountInEachList.get(i).getText().trim().equals(("0")))
			{
				itemsCountInEachList.get(i).click();
				pageManager.savedListsDetailPage().clickOnDeleteLink();
				waitTool.waitFor(driver, true);
				pageManager.homePage().clickMyAccountSavedListsQuickLink();
			}
		}
	}
	
	public void createNewPrivateListIfNoListExists()
	{
		try
		{
			noPrivateListMessage.isDisplayed();
			createNewListButton.click();
			PageManager pageManager = new PageManager(driver);
			ArrayList<UsersListBean> usersList;
			usersList=pageManager.dBCon().loadDataFromExcel("AddFirstPartToList","SavedList");
			System.out.println("value out are "+ usersList.get(0).getPartNumberAddToList()+usersList.get(0).getQuantityAddToList());
			pageManager.createNewSavedListPage().createNewPrivateList();
		}
		catch(Exception e)
		{
			System.out.println("private list already exist");
		}
	}
}

