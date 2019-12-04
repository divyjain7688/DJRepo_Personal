package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SavedListsPage_old {
	private  WebDriver driver; 
	private WaitTool waitTool;
	private PageManager pageManager;


	public SavedListsPage_old(WebDriver driver) 	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager = new PageManager(driver);
	}

	@FindBy(xpath = "//strong[text()='Last updated:']")
	WebElement lastUpdatedText;

	@FindBy(xpath = "//div[@class='widget-wrapper__header']//h3[contains(text(),'Add to existing or Create new list')]")
	WebElement addToExistingOrCreateNewListText;

	@FindBy(xpath = "//ul[@class='list-index-list']/li[1]")
	WebElement existingFirstSavedList;

	@FindBy(xpath = "//div[@class='list-details__part-grid']//button[@class='btn btn--small btn--light']")
	WebElement addButton;

	@FindBy(xpath = "//a[contains(text(),'DELETE')]")
	WebElement deleteButton;

	@FindBy(xpath = "//div[@class='list-manage__links']//a[contains(text(),'PRINT BIN LABELS')]")
	WebElement printBinLabelsLink;

	@FindBy(xpath = "//button[contains(text(),'REMOVE FROM LIST')]")
	List<WebElement> RemoveProductsFromSavedList;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[1]")
	public WebElement contactNumberOnBinLabel;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[2]")
	public
	WebElement productDescriptionOnBinLabel;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[4]")
	public
	WebElement hDSPartTextOnBinLabel;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[5]")
	WebElement hDSPartOnBinLabel;

	@FindBy(xpath = "//div[@class='list-index-grid__left']/ul/li[1]")
	public
	WebElement firstListUnderPrivateList;

	@FindBy(xpath = "//div[@class='list-index-grid__left']/ul/li[1]")
	WebElement firstListUnderSharedList;

	@FindBy(xpath = "//h1[text()='Saved Lists']")
	WebElement savedListspageHeadingText;

	@FindBy(xpath ="//*[text()='ADD TO CART']")
	//	"//button[contains(text(),'ADD TO CART')]")
	//a[@id='add2CartBtn']//span[text()='Add to cart']
	WebElement addToCartButton;

	//Header HD Logo
	@FindBy(xpath = "//div[@class='header__main']//div[@id='ci_espot__HdsHeaderLogoESpot']")
	public WebElement headerHDLogoImage;

	@FindBy(linkText = "DELETE")
	WebElement deleteLinkText;	

	@FindBy(xpath = "//section[@class='subcat-list-tile']//span[@class='type--bold'][text()='PART']/..")
	public
	WebElement displayedPartNumber;

	@FindBy(xpath = "//*[@data-hds-tag='saved-lists-container__tabs__list-index-grid__right__list-items__details']")
	public
	List<WebElement> list_displayedPartNumberText;

	@FindBy(xpath = "//span[@class='type--bold'][text()='PART']/..")
	public
	List<WebElement> displayedPartNumbers;

	@FindBy(xpath = "//*[@data-hds-tag='saved-list__item-list-actions-price-value']")
	public
	List<WebElement> displayedPartPrices;

	@FindBy(xpath = "//a[contains(text(),'Private Lists')]")
	WebElement privateList;

	@FindBy(xpath = "//a[contains(text(),'Shared Lists')]")
	WebElement sharedList;

	@FindBy(partialLinkText = "")
	WebElement listNameStartsWithList_LinkText;

	@FindBy(xpath="//div[@class='list-index-grid__left']//li[1]")
	WebElement firstSavedListLinkText;

	@FindBy(xpath = "//div[@class='email-print']/a[2]")
	public WebElement emailPageLink;

	@FindBy (xpath = "//div[@class='pagination__info']/input")
	WebElement paginationInfo;

	@FindBy (xpath= "//div[@class='list-items']//strong")
	WebElement savedListItems;

	@FindBy (xpath = "//div[@class='pagination__info']/following-sibling::a")
	WebElement paginationForward;

	@FindBy (xpath = "//div[@class='pagination__info']/preceding-sibling::a")
	WebElement paginationBackWard;

	@FindAll(@FindBy(xpath= "//div[@class='pagination']/preceding-sibling::section"))
	List<WebElement> savedListItemsInAPage;

	@FindBy (xpath = "//button[contains(text(),'Add List to Cart')]")
	WebElement addListToCartButton;

	@FindBy(xpath = "//div[@class='cart-added__details']//a[contains(text(),'Checkout')]")
	WebElement checkOutButton;

	@FindBy(xpath="//div[@class='list-index-header__links']/a[@class='link--strong jq-open-modal']")
	WebElement upLoadTemplateLinkText;

	@FindBy(xpath="//h3[text() = 'Upload saved list']")
	WebElement uploadSavedListModalHeadingText;

	@FindBy(xpath = "//input[@id='UpLoadedFile']")
	WebElement chooseFile;

	@FindBy(xpath = "//a[text() = 'Click here to download a save list template']")
	WebElement clickHereToDownloadLink;

	@FindBy(xpath = "//div[text()='Add to Private List']")
	WebElement addToPrivateListRadioButton;

	@FindBy(xpath = "//div[text()='Add to Shared List']")
	WebElement addToSharedListRadioButton;

	@FindBy(xpath = "//div[text()='Add as a New List']")
	WebElement addAsANewListRadioButton;

	@FindBy(xpath="//div[@class='list-index-header__links']/a[@class='link--strong']")
	WebElement downLoadTemplateLinkText;

	@FindBy (xpath ="//button[@class='btn btn--full btn--small btn--light type--caps'][2]")
	WebElement removeFromListLinkText;	

	@FindBy (xpath ="//div[@class='list-items']/span/strong")
	WebElement saveListTotalNumberText;	

	@FindBy (xpath ="//div[@id='message']")
	WebElement noItemAddedMessage;

	@FindBy (linkText ="PRIVATE LISTS")
	WebElement privateLists;

	@FindBy( linkText = "SHARED LISTS")
	WebElement sharedLists;

	@FindBy (xpath ="//button[contains(text(),'Add List to Cart')]")
	WebElement addListToCart;

	@FindBy (linkText ="CONVERT TO SHARED LIST")
	WebElement convertToSharedList;

	@FindBy (linkText ="CONVERT TO PRIVATE LIST")
	WebElement convertToPrivateList;

	@FindBy (linkText ="EMAIL LIST")
	WebElement emailList;

	@FindBy (linkText ="DELETE")
	WebElement delete;

	@FindBy (linkText ="PRINT BIN LABELS")
	WebElement printBinLabel;

	@FindBy (xpath = "//a[@name='enter-name--list']")
	WebElement createNewListNameText;

	@FindBy (xpath = "//div[@class='btn btn--large jq-open-modal']")
	WebElement createNewListButton;

	@FindBy (xpath = "//div[text()='Private']")
	WebElement createNewListPrivateRadioBtn;

	@FindBy (xpath = "//div[text()='Private']")
	WebElement createNewListSharedRadioBtn;

	@FindBy(xpath="//a[@id='GotoCartButton1']")
	WebElement modalViewCartButton;

	@FindBy(xpath="//div[@class=\\'subcat-list-tile__details\\']/div[1][contains(text(),''+productDescription+'')]/../../..//button[contains(text(),'REMOVE FROM LIST')]")
	WebElement removeFromListButtonForNewlyAddedProduct;

	@FindBy(xpath="//a[contains(text(),'RECENTLY UPDATED')]")
	public WebElement recentlyUpdatedLink;

	@FindBy(xpath="//*[@class=\"subcat-list-tile\"][1]/div/div[@class=\"subcat-list-tile__image\"]")
	WebElement saveListItemImage;

	@FindBy(xpath="//span[@class='type--body-x-large price--offerprice price--highlight']")
	WebElement saveListItemPrice;

	@FindBy(xpath="//div[@class='list-index-grid__left']/span[@class='type--body-x-large']/strong")
	WebElement numberOfListTextDisplayed;

	@FindBy(xpath="//ul[@class='list-index-list']/li")
	List<WebElement> numberOfListDisplayed;

	//@FindBy(xpath="//div[@class='subcat-list-tile__part-quantity-availability']/span")
	@FindBy(xpath="//div[@class='list-index-grid__right']//div[@class='list-items']//div[@class='subcat-list-tile__part-quantity-availability']/span")
	WebElement partNoFromList;

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

	/**
	 * 
	 * @return To get the total number from list
	 */
	public String getSaveListTotalNumberText() {
		waitTool.waitForElement(driver, saveListTotalNumberText);
		pageManager.common().scrolltoViewElement(saveListTotalNumberText, driver);
		return saveListTotalNumberText.getText().trim();
	}

	public String getSaveListTotalNumberTextAfterRemoveFromList() {
		String saveListTotalOrMessage;
		try{
			saveListTotalNumberText.isDisplayed();
			pageManager.common().scrolltoViewElement(saveListTotalNumberText, driver);
			saveListTotalOrMessage = saveListTotalNumberText.getText().trim();	
		}catch (Exception e) {
			saveListTotalOrMessage = noItemAddedMessage.getText();
		}
		return saveListTotalOrMessage;
	}

	public boolean isDisplayedRemoveFromListLink(){
		return pageManager.common().isElementPresent(removeFromListLinkText);
	}

	/**
	 * Click on create new list button.
	 * @return
	 */
	public void clickOnCreateNewList() {
		waitTool.waitForElement(driver, createNewListButton);
		createNewListButton.click();
		waitTool.waitFor(driver,true) ;	
	}

	public void createPrivateSavedList(String savedListName) {
		createNewListNameText.sendKeys(savedListName);
		createNewListPrivateRadioBtn.click();	
		clickOnCreateNewList();	
	}

	public void createSharedSavedList(String savedListName) {
		createNewListNameText.sendKeys(savedListName);
		createNewListPrivateRadioBtn.click();
		clickOnCreateNewList();
	}

	public HomePage clickHeaderHDLogoImage() throws Exception {
		waitTool.waitForElement(driver, headerHDLogoImage);
		pageManager.common().scrolltoViewElement(headerHDLogoImage, driver);
		headerHDLogoImage.click();
		return new HomePage(driver);
	}  

	public boolean isDisplayedPrintBinLabel() {
		return pageManager.common().isElementPresent(printBinLabel);
	}
	public boolean isDisplayedAddListToCart() {
		return pageManager.common().isElementPresent(addListToCart);
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

	/**
	 * Method to click on the Remove from List Link
	 */
	public void clickRemoveFromListLinkText() {
		removeFromListLinkText.click();
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
		return savedListspageHeadingText.isDisplayed();
	}

	/**
	 * @return true if new list created displayed in Saved List page otherwise false
	 */
	public String getNewlyCreatedList() 
	{		
		waitTool.waitForElement(driver, recentlyUpdatedLink);
		pageManager.common().scrolltoViewElement(recentlyUpdatedLink, driver);
		recentlyUpdatedLink.click();
		waitTool.waitForElement(driver, firstListUnderPrivateList);
		pageManager.common().scrolltoViewElement(firstListUnderPrivateList, driver);
		return firstListUnderPrivateList.getText();
	}


	public void clickOnNewlyCreatedList() 
	{
		waitTool.waitForElement(driver, firstListUnderPrivateList);
		pageManager.common().scrolltoViewElement(firstListUnderPrivateList, driver);
		firstListUnderPrivateList.click();
	}

	public void getListNameOfNewlyCreatedList(){
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
		pageManager.common().scrolltoViewElement(existingFirstSavedList, driver);
		existingFirstSavedList.click();
	}

	public void deleteTheNewlyCreatedList() throws Exception {
		pageManager.common().scrolltoViewElement(firstListUnderPrivateList, driver);
		firstListUnderPrivateList.click();
		pageManager.common().scrolltoViewElement(deleteButton, driver);
		deleteButton.click();
		//waitTool.hardWait();
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

	/**
	 * param partNumber
	 * return true if added item in the saved list is displayed otherwise fals
	 */
	public String displayedAddedItemInExistingList() {
		waitTool.waitForElement(driver, displayedPartNumber);
		pageManager.common().scrolltoViewElement(displayedPartNumber, driver);
		return displayedPartNumber.getText();
	}


	public Boolean isAddedPartDisplayedInSavedList(String pnumber)
	{
		waitTool.waitForElement(driver, lastUpdatedText);
		Boolean flag=true;
		System.out.println("pnumber is " + pnumber);
		for(WebElement displayedPnumber : displayedPartNumbers)
		{
			System.out.println(displayedPnumber.getText());
		}

		for(WebElement displayedPnumber : displayedPartNumbers)
		{
			if(displayedPnumber.getText().contains(pnumber))
			{
				flag=true;
				System.out.println("flag updated to true");
				break;
			}
			else
			{
				flag=false;
			}
		}
		return flag;
	}

	public Boolean isAddedPartPricesDisplayedInSavedList(String price)
	{
		Boolean flag=true;
		System.out.println("price is " + price);
		for(WebElement displayedPprice: displayedPartPrices)
		{
			System.out.println(displayedPprice.getText());
		}

		for(WebElement displayedPprice : displayedPartPrices)
		{
			if(displayedPprice.getText().contains(price))
			{
				flag=true;
				System.out.println("flag updated to true");
				break;
			}
			else
			{
				flag=false;
			}
		}
		return flag;
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
			pageManager.common().refresh();
			//waitTool.hardWait();
			waitTool.waitForElement(driver, RemoveProductFromSavedList);
			pageManager.common().scrolltoViewElement(RemoveProductFromSavedList, driver);
			RemoveProductFromSavedList.click();
			//waitTool.hardWait();
			waitTool.waitForAlert(driver);
			pageManager.common().acceptPopupMessageBox(driver);
			//waitTool.hardWait();
			waitTool.waitForAlert(driver);
			pageManager.common().acceptPopupMessageBox(driver);
			pageManager.common().refresh();
			clickOnExistingFirstSavedList();
		}

	}

	public void removeNewlyAddedPartFromExistingList(String productDescription) throws Exception
	{

		removeFromListButtonForNewlyAddedProduct.click();
		//	waitTool.hardWait();
		waitTool.waitForAlert(driver);
		pageManager.common().acceptPopupMessageBox(driver);
		//	waitTool.hardWait();
		waitTool.waitForAlert(driver);
		pageManager.common().acceptPopupMessageBox(driver);

	}
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
	public void clickModalViewCartButton() throws InterruptedException {
		waitTool.waitForElement(driver, modalViewCartButton);
		modalViewCartButton.click();
		waitTool.waitFor(driver,true) ;
		//	return new ShoppingCartPage(driver);

	}

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

	public void VerifyPrintLabelsAreDisplayed() throws Exception{
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
		waitTool.waitForElement(driver, addListToCartButton);
		pageManager.common().scrolltoViewElement(addListToCartButton, driver);
		addListToCartButton.click();
	}

	public void clickOnAddToCartButton() throws Exception
	{

		int displayedShoppingCartProductCountBeforeAddToCart=pageManager.homePage().getShoppingCartProductCount();
		System.out.println("displayedShoppingCartProductCountBeforeAddToCart   "+ displayedShoppingCartProductCountBeforeAddToCart);
		waitTool.waitForElement(driver, addToCartButton);

		pageManager.common().scrolltoViewElement(addToCartButton, driver);
		addToCartButton.click();
		//	waitTool.hardWait();
		driver.navigate().refresh();
		int displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		while(displayedShoppingCartProductCountAfterAddToCart==displayedShoppingCartProductCountBeforeAddToCart)
		{
			displayedShoppingCartProductCountAfterAddToCart=pageManager.homePage().getShoppingCartProductCount();
		}
		System.out.println("displayedShoppingCartProductCountAfterAddToCart is "+ displayedShoppingCartProductCountAfterAddToCart);
		Assert.assertNotEquals(displayedShoppingCartProductCountBeforeAddToCart,displayedShoppingCartProductCountAfterAddToCart);
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

	public String getdisplayedPartNumber()
	{
		return displayedPartNumber.getText();
	}

	public boolean isDisplayedSaveListPartImage()
	{
		return saveListItemImage.isDisplayed();
	}

	public String getdisplayedPrice()
	{
		return saveListItemPrice.getText();
	}

	//	public void clickAddToCartButton() throws Exception
	//	{
	//       .scrolltoViewElement(addToCartButton, driver);
	//	   addToCartButton.click();
	//	}

	public int getNumberOfListTextDisplayed()
	{
		return Integer.parseInt(numberOfListTextDisplayed.getText());
	}

	public int getNumberOfListDisplayed()
	{
		return numberOfListDisplayed.size();
	}



	public void clickOnList(String listToBeClicked) 
	{	
		waitTool.waitForElement(driver, recentlyUpdatedLink);
		recentlyUpdatedLink.click();
		
		System.out.println("listToBeClicked: " + listToBeClicked.trim());
		System.out.println("numberOfListDisplayed.size(): "+ numberOfListDisplayed.size());
		int recentlyUpdatedList = numberOfListDisplayed.size();
		for(int i=0; i<recentlyUpdatedList; i++){
			System.out.println("ClickOnList: " + numberOfListDisplayed.get(i).getText());
			if(numberOfListDisplayed.get(i).getText().equals(listToBeClicked.trim())){
				System.out.println(" in Loop - numberOfListDisplayed.get(i).getText() :" + numberOfListDisplayed.get(i).getText());
				pageManager.common().scrolltoViewElement(numberOfListDisplayed.get(i), driver);
				numberOfListDisplayed.get(i).click();
				break;
			}else{
				System.out.println("Not clicked");
			}

		}

	}
	

	public String getPartNumNewlyCreatedList(){
		pageManager.common().scrolltoViewElement(partNoFromList, driver);
		return partNoFromList.getText().substring(5);
	}

	public List<String> getPartNumbersFromSavedList()
	{
		List<String> all_SL_partNums=new ArrayList<>();
		List<String> all_SL_partNumbers=new ArrayList<>();

		for(int i=0; i<displayedPartNumbers.size(); i++){
			all_SL_partNums.add(displayedPartNumbers.get(i).getText());
		}
		for(String all_SL_partNum:all_SL_partNums)
		{
			all_SL_partNum=all_SL_partNum.substring(all_SL_partNum.indexOf(" "));
			all_SL_partNum=all_SL_partNum.trim();
			all_SL_partNumbers.add(all_SL_partNum);
		}
		return all_SL_partNumbers;
	}

	public void refresh(){
		pageManager.common().refresh();
	}

	public void navigateToSavedListPageAndClickOnRecentlyUpdatedList() {
		driver.navigate().refresh();
		pageManager.homePage().clickMyAccountSavedListsQuickLink();
		//pageManager.savedListsPage().clickOnRecentlyUpdatedLink();
	//	pageManager.savedListsPage().clickOnNewlyCreatedList();
		waitTool.waitForElement(driver, lastUpdatedText);
	}

}

