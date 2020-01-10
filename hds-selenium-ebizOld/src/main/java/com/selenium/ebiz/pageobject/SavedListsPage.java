package com.selenium.ebiz.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.selenium.ebiz.baseclass.BaseClass;
import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class SavedListsPage extends BaseClass{

	public SavedListsPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(savedListspageHeadingText));		
	}

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
	WebElement contactNumberOnBinLabel;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[2]")
	WebElement productDescriptionOnBinLabel;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[4]")
	WebElement hDSPartTextOnBinLabel;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[5]")
	WebElement hDSPartOnBinLabel;

	@FindBy(xpath = "//div[@class='list-index-grid__left']/ul/li[1]")
	WebElement firstListUnderPrivateList;

	@FindBy(xpath = "//div[@class='list-index-grid__left']/ul/li[1]")
	WebElement firstListUnderSharedList;
	
	@FindBy(xpath = "//h1[text()='Saved Lists']")
	WebElement savedListspageHeadingText;
	

	@FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
	WebElement addToCartButton;
	
	//Header HD Logo
	@FindBy(xpath = "//div[@class='header__main']//div[@id='ci_espot__HdsHeaderLogoESpot']")
	public WebElement headerHDLogoImage;

	@FindBy(linkText = "DELETE")
	WebElement deleteLinkText;	

	@FindBy(xpath = "//section[@class='subcat-list-tile']//span[@class='type--bold'][text()='PART']/..")
	WebElement displayedPartNumber;

	@FindBy(xpath = "//span[@class='type--bold'][text()='PART']/..")
	List<WebElement> displayedPartNumbers;

	@FindBy(xpath = "//a[contains(text(),'Private Lists')]")
	WebElement privateList;

	@FindBy(xpath = "//a[contains(text(),'Shared Lists')]")
	WebElement sharedList;

	@FindBy(partialLinkText = "")
	WebElement listNameStartsWithList_LinkText;

	@FindBy(xpath="//div[@class='list-index-grid__left']//li[1]")
	WebElement leftListsLinkText;

	@FindBy(xpath = "//div[@class='email-print']/a[2]")
	WebElement emailPageLink;

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
	
	@FindBy(xpath = "//div[@class=\"cart-added__details\"]//a[contains(text(),'Checkout')]")
	WebElement checkOutButton;

	@FindBy(xpath="//div[@class='list-index-header__links']/a[@class='link--strong jq-open-modal']")
	WebElement upLoadTemplateLinkText;
	
	@FindBy(xpath="	//input[@id='UpLoadedFile']")
	WebElement uploadFile;
	
	@FindBy(xpath="//div[@class='list-index-header__links']/a[@class='link--strong']")
	WebElement downLoadTemplateLinkText;
	
	@FindBy (xpath ="//button[@class='btn btn--full btn--small btn--light type--caps'][2]")
	WebElement removeFromListLinkText;	

	@FindBy (xpath ="//div[@class='list-items']/span/strong")
	WebElement saveListTotalNumberText;	
	
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

	@FindBy (xpath = "//a[@class='btn btn--large jq-open-modal']")
	WebElement createNewListButton;

	@FindBy (xpath = "//div[text()='Private']")
	WebElement createNewListPrivateRadioBtn;

	@FindBy (xpath = "//div[text()='Private']")
	WebElement createNewListSharedRadioBtn;

	@FindBy(xpath="//div[@class='main__cart-info']//a[@id='widget_minishopcart'][@role='button']")  
	WebElement shoppingCartIcon;
	
	@FindBy(xpath="//div[@class='main__cart']/a[@id='widget_minishopcart']")
	WebElement headerMiniCartButton;

	@FindBy(xpath="//a[@id='GotoCartButton1']")
	WebElement modalViewCartButton;
	
	/**
	 *  Method to verify for the List in the left Pane
	 * @return
	 */
	public boolean isDisplayedListOnLeftPage(){
		return CommonFunctions.isElementPresent(leftListsLinkText);
	}
	
	public boolean isDisplayedUpLoadTemplateLinkText(){
		return CommonFunctions.isElementPresent(upLoadTemplateLinkText);
	}

	public void clickUpLoadTemplateLinkText() throws InterruptedException {
		upLoadTemplateLinkText.click();
	} 

	/**
	 *  Method to click on Download Template in SavedPages
	 * @return
	 * @throws InterruptedException
	 */
	public HomePage clickUploadFile() throws InterruptedException {
		uploadFile.click();
		return new HomePage(driver);
	}

	public boolean isDisplayedDownLoadTemplateLinkText(){
		return CommonFunctions.isElementPresent(downLoadTemplateLinkText);
	}

	public HomePage clickDownLoadTemplateLinkText() throws InterruptedException {
		downLoadTemplateLinkText.click();
		return new HomePage(driver);
	} 

	/**
	 * 
	 * @return To get the total number from list
	 */
	public String getSaveListTotalNumberText() {
		return saveListTotalNumberText.getText().trim();
	}

	public boolean isDisplayedRemoveFromListLink(){
		return CommonFunctions.isElementPresent(removeFromListLinkText);
	}

	/**
	 * Click on create new list button.
	 * @return
	 */
	public CreateNewSavedListPage clickOnCreateNewList() {
		WaitTool.waitForElement(driver, createNewListButton);
		createNewListButton.click();
		WaitTool.waitFor(driver,true) ;	
		return new CreateNewSavedListPage(driver);
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
        WaitTool.waitForElement(driver, headerHDLogoImage);
		CommonFunctions.scrolltoViewElement(headerHDLogoImage, driver);
		headerHDLogoImage.click();
		return new HomePage(driver);
	}  

	public boolean isDisplayedPrintBinLabel() {
		return CommonFunctions.isElementPresent(printBinLabel);
	}
	public boolean isDisplayedAddListToCart() {
		return CommonFunctions.isElementPresent(addListToCart);
	}
	public boolean isDisplayedConvertToSharedList() {
		return CommonFunctions.isElementPresent(convertToSharedList);
	}
	public boolean isDisplayedEmailList() {
		return CommonFunctions.isElementPresent(emailList);
	}
	public boolean isDisplayeddelete() {
		return CommonFunctions.isElementPresent(delete);
	}
	public boolean isDisplayedConvertToPrivateList() {
		return CommonFunctions.isElementPresent(convertToPrivateList);
	}
	
	/**
	 * Method to click on the Remove from List Link
	 */
	public void clickRemoveFromListLinkText() {
		removeFromListLinkText.click();
	}

	/**
	 * get Page Heading text
	 * @return string page heading text
	 */
	public String getSavedListspageHeadingText() {
		return savedListspageHeadingText.getText().trim();
	}

	/**
	 * @return true if new list created displayed in Saved List page otherwise false
	 */
	public String getNewlyCreatedList() 
	{
		CommonFunctions.scrolltoViewElement(firstListUnderPrivateList, driver);
		return firstListUnderPrivateList.getText();
	}

	public void clickOnNewlyCreatedList() 
	{
		CommonFunctions.scrolltoViewElement(firstListUnderPrivateList, driver);
		firstListUnderPrivateList.click();
	}

	/**
	 * click the list for which name starts with "List_"
	 */
	public void clickListNameStartsWithList_LinkText() {
		listNameStartsWithList_LinkText.click();
	}

	public void clickOnExistingFirstSavedList()
	{
		CommonFunctions.scrolltoViewElement(existingFirstSavedList, driver);
		existingFirstSavedList.click();
	}

	public void deleteTheNewlyCreatedList() throws Exception {
		CommonFunctions.scrolltoViewElement(firstListUnderPrivateList, driver);
		firstListUnderPrivateList.click();
		CommonFunctions.scrolltoViewElement(deleteButton, driver);
		deleteButton.click();
		WaitTool.hardWait();
		CommonFunctions.acceptPopupMessageBox(driver);
	}

	public boolean checkPrivateListSelected() {
		String classname = privateList.getAttribute("class");
		return classname.contains("tab--selected");			
	}

	/**
	 * click the shared list
	 */
	public void clickSharedListt() {
		WaitTool.waitForElement(driver, sharedList);
		CommonFunctions.scrolltoViewElement(sharedList, driver);
		sharedList.click();
	}

	/**
	 * Delete the List from Saved Lists
	 */
	public void clickDeleteLinkText() {
		deleteLinkText.click();
		WaitTool.waitFor(driver, true);
	}

	/**
	 * @param partNumber
	 * @return true if added item in the saved list is displayed otherwise fals
	 */
	public String displayedAddedItemInExistingList() {
		WaitTool.waitForElement(driver, displayedPartNumber);
		CommonFunctions.scrolltoViewElement(displayedPartNumber, driver);
		return displayedPartNumber.getText();
	}

	public Boolean isAddedPartDisplayedInSavedList(String pnumber) 
	{	
		Boolean flag=false;
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
			CommonFunctions.refresh(driver);
			WaitTool.hardWait();
			CommonFunctions.scrolltoViewElement(RemoveProductFromSavedList, driver);
			RemoveProductFromSavedList.click();
			WaitTool.hardWait();
			CommonFunctions.acceptPopupMessageBox(driver);
			WaitTool.hardWait();
			CommonFunctions.acceptPopupMessageBox(driver);
			CommonFunctions.refresh(driver);
			clickOnExistingFirstSavedList();
		}

	}

	public void removeNewlyAddedPartFromExistingList(String productDescription) throws Exception
	{


		WebElement removeFromListButtonForNewlyAddedProduct = driver.findElement(By.xpath("//div[@class=\"subcat-list-tile__details\"]/div[1][contains(text(),'"+productDescription+"')]/../../..//button[contains(text(),'REMOVE FROM LIST')]"));

		/*	prodDesc=productDescription;
				System.out.println("prodDesc is" + prodDesc);*/
		removeFromListButtonForNewlyAddedProduct.click();
		WaitTool.hardWait();
		CommonFunctions.acceptPopupMessageBox(driver);
		WaitTool.hardWait();
		CommonFunctions.acceptPopupMessageBox(driver);

	}
	/**
	 * click email page link
	 */
	public void clickEmailPageLink() {
		emailPageLink.click();
	}

	/**
	 * @return true if email link is displayed on page otherwise false
	 */
	public boolean isDisplayedEmailPageLink(){
		return CommonFunctions.isElementPresent(emailPageLink);
	}	

	public void clickHeaderMiniCartButton() throws InterruptedException {
		WaitTool.waitForElement(driver, headerMiniCartButton);
		headerMiniCartButton.click();
		WaitTool.waitFor(driver,true) ;
	}

	public ShoppingCartPage clickModalViewCartButton() throws InterruptedException {
		WaitTool.waitForElement(driver, modalViewCartButton);
		modalViewCartButton.click();
		WaitTool.waitFor(driver,true) ;
		return new ShoppingCartPage(driver);

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
		return CommonFunctions.isElementPresent(privateLists);
	}
	public boolean isDisplayedSharedListsTab() {
		return CommonFunctions.isElementPresent(sharedLists);
	}

	public boolean isDisplayedaddButton() {
		return CommonFunctions.isElementPresent(addButton);
	} 

	public void paginationVerification() throws Exception {
		int totalSavedListItems= Integer.parseInt(savedListItems.getText());
		if(totalSavedListItems>26) {
			int initialPage = Integer.parseInt(paginationInfo.getAttribute("value"));
			System.out.println(initialPage);
			int maxPage = Integer.parseInt(paginationInfo.getAttribute("max"));
			int minPage = Integer.parseInt(paginationInfo.getAttribute("min"));
			int currentPage=0;
			if(initialPage==1 && CommonFunctions.isElementPresent(paginationForward)) {			
				Assert.assertEquals(26,savedListItemsInAPage.size());
				for(int i=initialPage;i<maxPage;i++) {
					CommonFunctions.scrolltoViewElement(paginationForward, driver);
					paginationForward.click();
					WaitTool.hardWait();
					Assert.assertTrue(CommonFunctions.isElementPresent(paginationBackWard));
					currentPage=Integer.parseInt(paginationInfo.getAttribute("value"));
					System.out.println("current page is " + currentPage);
					//Assert.assertTrue(CommonFunctions.isElementPresent(paginationForward));
					Assert.assertEquals(initialPage=initialPage+1 ,currentPage );
					/*if(currentPage!=maxPage)
					Assert.assertEquals(totalSavedListItems-26,savedListItemsInAPage.size());
					else
					Assert.assertEquals(totalSavedListItems-26*currentPage-1,savedListItemsInAPage.size());*/
				}

				for(int i=initialPage;i>minPage;i--) {
					CommonFunctions.scrolltoViewElement(paginationBackWard, driver);
					paginationBackWard.click();
					WaitTool.hardWait();
					Assert.assertTrue(CommonFunctions.isElementPresent(paginationForward));
					currentPage=Integer.parseInt(paginationInfo.getAttribute("value"));
					System.out.println("current page is " + currentPage);
					//Assert.assertTrue(CommonFunctions.isElementPresent(paginationForward));
					Assert.assertEquals(initialPage=initialPage-1 ,currentPage );
					//Assert.assertEquals(totalSavedListItems-25,savedListItemsInAPage.size());
				}
			}
		}

	}

	/**
	 * click the list 
	 */
	public void clickListNameLinkText() {
		leftListsLinkText.click();
	}

	public void clickOnPrintBinLabelsLink()
	{
		WaitTool.waitForElement(driver, printBinLabelsLink);
		CommonFunctions.scrolltoViewElement(printBinLabelsLink, driver);
		printBinLabelsLink.click();
		CommonFunctions.moveToNewWindow(driver);
		System.out.println("moved to new window" );
		
	}

	public Boolean isContactNumberOnBinLabelDisplayed() throws Exception
	{
	//	Thread.sleep(5000);
		//WebDriverWait wait = new WebDriverWait(driver, 5000);
		//wait.until(ExpectedConditions.visibilityOf(contactNumberOnBinLabel));	
		WaitTool.waitForElement(driver, contactNumberOnBinLabel);
		CommonFunctions.scrolltoViewElement(contactNumberOnBinLabel, driver);
		return contactNumberOnBinLabel.isDisplayed();
	}

	public Boolean isProductDescriptionOnBinLabelDisplayed()
	{
		return productDescriptionOnBinLabel.isDisplayed();
	}

	public Boolean isHDSPartTextOnBinLabelDisplayed()
	{
		return hDSPartTextOnBinLabel.isDisplayed();
	}

	public String isHDSPartNumberOnBinLabelDisplayed()
	{
		return hDSPartOnBinLabel.getText();
	}


	public ShoppingCartPage clickOnShoppingCartIcon() throws Exception {
		//WaitTool.hardWait();
		WaitTool.waitForElement(driver, shoppingCartIcon);
		CommonFunctions.scrolltoViewElement(shoppingCartIcon, driver);
		shoppingCartIcon.click();
		return new ShoppingCartPage(driver);
	}

    public void clickOnAddListToCartButton() throws Exception
    {
        WaitTool.waitForElement(driver, addListToCartButton);
		CommonFunctions.scrolltoViewElement(addListToCartButton, driver);
    	addListToCartButton.click();
		WaitTool.hardWait();

    }
    
    public void clickOnAddToCartButton() throws Exception
    {
    	WaitTool.waitForElement(driver, addToCartButton);
		CommonFunctions.scrolltoViewElement(addToCartButton, driver);
    	addToCartButton.click();
    }
    
    public ShoppingCartPage clickonCheckOutButton() throws Exception {
		WaitTool.waitForElement(driver, checkOutButton);
		CommonFunctions.scrolltoViewElement(checkOutButton, driver);
		checkOutButton.click();
		return new ShoppingCartPage(driver);
	}

}

