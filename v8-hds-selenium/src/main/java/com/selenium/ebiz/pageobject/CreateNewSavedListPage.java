package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CreateNewSavedListPage {

	WebDriver driver;
	private WaitTool waitTool;
	private PageManager pageManager;

	public CreateNewSavedListPage(WebDriver driver)
	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		this.pageManager= new PageManager(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "DELETE")
	WebElement deleteLinkText;	

	@FindBy(xpath = "//a[contains(text(),'Private Lists')]")
	WebElement privateList;

	@FindBy(xpath = "//a[contains(text(),'Shared Lists')]")
	WebElement sharedList;

	@FindBy (xpath = "//a[@name='enter-name--list']")
	WebElement createNewListNameText;

	@FindBy (xpath = "//div[text()='Private']")
	WebElement createNewListPrivateRadioBtn;

	@FindBy (xpath = "//div[text()='Shared']")
	WebElement createNewListSharedRadioBtn;

	@FindBy (xpath = "/html/body/div/div/div/div/div/div/div/div/div/button")
	//button[@data-hds-tag='create-new-list__add-footer__create-list']
	WebElement createNewListButton;
	
	@FindBy(id = "errormessage")
	WebElement errorMessage;
	
	@FindBy (xpath = "//div[text() = '×']")
	List<WebElement> clearButton;

	@FindBy (xpath = "//input[@id='savedList_partNumber_1']")
	WebElement partNumber1Edit;
	
	//@FindBy (xpath = "//div[@id='livechat-full']/following-sibling::div[@class='modal modal--visible']//input[@class='enter-name--list']")
	@FindBy (xpath = "//input[@class='enter-name--list']")
	WebElement nameListEdit;

	@FindBy (xpath = "//div[text()='Private']/../span[1]")
	WebElement privateRadioButton;
	

	
	public boolean isDisplayedCreateNewListButton() {
		return pageManager.common().isElementPresent(createNewListButton);
	}


	public boolean isDisplayedNameListEdit() 
	{
		waitTool.waitForElement(driver, nameListEdit);
		pageManager.common().scrolltoViewElement(nameListEdit, driver);
		return pageManager.common().isElementPresent(nameListEdit);
	}

	public String enterListName() 
	{	
		String list = "List_";
		String random = list +pageManager.common().getRandomString(4);
		nameListEdit.sendKeys(random);
		return random;
	}

	
	public boolean isDisplayedPrivateRadioButton() {
		
		waitTool.waitForElement(driver, privateRadioButton);
		pageManager.common().scrolltoViewElement(privateRadioButton, driver);
		return pageManager.common().isElementPresent(privateRadioButton);
	}

	@FindBy (xpath = "//div[text()='Shared']/../span[1]")
	WebElement sharedRadioButton;

	public boolean isDisplayedSharedRadioButton() {
		return pageManager.common().isElementPresent(sharedRadioButton);
	}

	public boolean isDisplayedPartNumber1Edit() {
		return pageManager.common().isElementPresent(partNumber1Edit);
	}

	public void enterPartNumber1(String pnumber) {
		partNumber1Edit.clear();
		partNumber1Edit.sendKeys(pnumber);
	}
	
	public String getPartNumber1Edit() throws Exception {
		waitTool.waitForElement(driver, partNumber1Edit);
		pageManager.common().scrolltoViewElement(partNumber1Edit, driver);
		return partNumber1Edit.getText().trim();
	}
	
	@FindBy (xpath = "//input[@id=\"savedList_quantity_1\"]")
	WebElement partQuantity1Edit;

	public boolean isDisplayedPartQuantity1Edit() {
		return pageManager.common().isElementPresent(partQuantity1Edit);
	}

	public void enterQuantity1(String quantity) {
		partQuantity1Edit.sendKeys(quantity);
	}
	
	/*@FindBy (xpath = "//div[@class=\"create-new-list__add\"]//button[text()='Create New List']")
	WebElement createNewList;*/
	
	@FindBy (xpath = "//a[@data-hds-tag='create-new-list__add-footer__see-all-lists']")
	WebElement seeAllListsLink;

	public boolean isDisplayedSeeAllListsLink() {
		return pageManager.common().isElementPresent(seeAllListsLink);
	}

	// click on see all lists link
	public SavedListsPage clickSeeAllListsLink() {
		seeAllListsLink.click();	
		return new SavedListsPage(driver);
	}


	@FindBy (xpath = "//div[@id='livechat-full']/following-sibling::div[@class='modal modal--visible']//a[@class='modal__close jq-close-modal']")
	WebElement modalClose;

	public boolean isDisplayedModalClose() {
		return pageManager.common().isElementPresent(modalClose);
	}

	// click on X for the modal
	public void clickModalClose() {
		modalClose.click();	
	}
	
	/*public void clickCreateNewList() {
		createNewList.click();	
	}*/
	
	public void clickClearButton() {
		clearButton.get(0).click();	
	}
	
	

	@FindBy (xpath = "//h1[text()='Saved Lists']")
	WebElement pageHeadingSavedLists;

	public boolean isDisplayedPageHeadingSavedLists() {
		return pageManager.common().isElementPresent(pageHeadingSavedLists);
	}

	//Header HD Logo
	@FindBy(xpath = "//div[@class='header__main']//div[@id='ci_espot__HdsHeaderLogoESpot']")
	WebElement headerHDLogoImage;

	//Header HD Logo
	@FindBy(xpath = "//button[contains(text(),'Add To List')]")
	WebElement addToListBtn;




	//List<WebElement> savedList= driver.findElements(By.xpath("//li[@class='list-add__list-item jq-list-add--select']"));




	//Click on create new list button.
	public CreateNewSavedListPage clickOnCreateNewList() {
		waitTool.waitForElement(driver, createNewListButton);
		createNewListButton.click();
		waitTool.waitFor(driver,true) ;	
		return new CreateNewSavedListPage(driver);
	}

	// Method to click on HDLogo in any of the Pages
	public HomePage clickHeaderHDLogoImage() throws InterruptedException {
		headerHDLogoImage.click();
		return new HomePage(driver);
	} 


	//Create private saved list
	public void createPrivateSavedList(String savedListName) {
		createNewListNameText.sendKeys(savedListName);
		createNewListPrivateRadioBtn.click();	
		clickOnCreateNewList();	}


	//Create shared saved list
	public void createSharedSavedList(String savedListName) {
		createNewListNameText.sendKeys(savedListName);
		createNewListPrivateRadioBtn.click();
		clickOnCreateNewList();
	}
	
	public boolean isDisplayedErrorMessage() 
	{
		waitTool.waitForElement(driver, errorMessage);
		pageManager.common().scrolltoViewElement(errorMessage, driver);
		return pageManager.common().isElementPresent(errorMessage);
	}

	/*public ProductListingPage test(String privatelist) {

		for (int i=0;i<=savedList.size();i++) {
			if(savedList.get(i).getText().equalsIgnoreCase(privatelist)) {
				savedList.get(i).click();
				addToListBtn.click();
				break;
			}
		}
		return new ProductListingPage(driver);

	}*/
	public void createNewPrivateList() throws Exception
	{
			ArrayList<UsersListBean> usersList;
			PageManager pageManager=new PageManager(driver);
			waitTool.waitForElement(driver, privateRadioButton);
			privateRadioButton.click();
			usersList=pageManager.dBCon().loadDataFromExcel("AddFirstPartToList","SavedList");
			System.out.println("value are "+ usersList.get(0).getQuantityAddToList()+usersList.get(0).getPartNumberAddToList());
			partNumber1Edit.sendKeys(usersList.get(0).getPartNumberAddToList());
			enterQuantity1(usersList.get(0).getQuantityAddToList());
			enterListName();
			createNewListButton.click();
	}

}
