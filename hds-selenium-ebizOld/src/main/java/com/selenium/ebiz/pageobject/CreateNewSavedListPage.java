package com.selenium.ebiz.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.ebiz.tools.CommonFunctions;
import com.selenium.ebiz.tools.WaitTool;

public class CreateNewSavedListPage {
	WebDriver driver;
	public CreateNewSavedListPage(WebDriver driver) 	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(createNewListPrivateRadioBtn));		
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
	WebElement createNewListButton;

	public boolean isDisplayedCreateNewListButton() {
		return CommonFunctions.isElementPresent(createNewListButton);
	}

	@FindBy (xpath = "//div[@id='livechat-full']/following-sibling::div[@class='modal modal--visible']//input[@class='enter-name--list']")
	WebElement nameListEdit;

	public boolean isDisplayedNameListEdit() 
	{
		return CommonFunctions.isElementPresent(nameListEdit);
	}

	public String enterListName() 
	{	
		String random = CommonFunctions.getRandomString(4);
		nameListEdit.sendKeys(random);
		return random;
	}


	@FindBy (xpath = "//div[text()='Private']/../span[1]")
	WebElement privateRadioButton;

	public boolean isDisplayedPrivateRadioButton() {
		return CommonFunctions.isElementPresent(privateRadioButton);
	}

	@FindBy (xpath = "//div[text()='Shared']/../span[1]")
	WebElement sharedRadioButton;

	public boolean isDisplayedSharedRadioButton() {
		return CommonFunctions.isElementPresent(sharedRadioButton);
	}

	@FindBy (xpath = "//input[@id='savedList_partNumber_1']")
	WebElement partNumber1Edit;

	public boolean isDisplayedPartNumber1Edit() {
		return CommonFunctions.isElementPresent(partNumber1Edit);
	}

	public void enterPartNumber1(String pnumber) {
		partNumber1Edit.sendKeys(pnumber);
	}
	
	@FindBy (xpath = "//input[@id=\"savedList_quantity_1\"]")
	WebElement partQuantity1Edit;

	public boolean isDisplayedPartQuantity1Edit() {
		return CommonFunctions.isElementPresent(partQuantity1Edit);
	}

	public void enterQuantity1(String quantity) {
		partQuantity1Edit.sendKeys(quantity);
	}
	
	@FindBy (xpath = "//div[@class=\"create-new-list__add\"]//button[text()='Create New List']")
	WebElement createNewList;
	
	@FindBy (xpath = "//a[text()='See all lists']")
	WebElement seeAllListsLink;

	public boolean isDisplayedSeeAllListsLink() {
		return CommonFunctions.isElementPresent(seeAllListsLink);
	}

	// click on see all lists link
	public SavedListsPage clickSeeAllListsLink() {
		seeAllListsLink.click();	
		return new SavedListsPage(driver);
	}


	@FindBy (xpath = "//div[@id='livechat-full']/following-sibling::div[@class='modal modal--visible']//a[@class='modal__close jq-close-modal']")
	WebElement modalClose;

	public boolean isDisplayedModalClose() {
		return CommonFunctions.isElementPresent(modalClose);
	}

	// click on X for the modal
	public void clickModalClose() {
		modalClose.click();	
	}
	
	public void clickClickNewList() {
		createNewList.click();	
	}

	@FindBy (xpath = "//h1[text()='Saved Lists']")
	WebElement pageHeadingSavedLists;

	public boolean isDisplayedPageHeadingSavedLists() {
		return CommonFunctions.isElementPresent(pageHeadingSavedLists);
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
		WaitTool.waitForElement(driver, createNewListButton);
		createNewListButton.click();
		WaitTool.waitFor(driver,true) ;	
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


}
