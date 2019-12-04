package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class AddToExistingORCreateNewList_modal {

    private WebDriver driver;
    private WaitTool waitTool;
    private PageManager pageManager;
    private String newListName="List";

    public AddToExistingORCreateNewList_modal(WebDriver driver) 	{
        this.driver = driver;  this.waitTool = new WaitTool();
        PageFactory.initElements(driver, this);
        this.pageManager=new PageManager(driver);
    }

    @FindBy(xpath = "//ul[@class='list-add__list']/li[1]")
     WebElement existingFirstSavedList;

    @FindBy(xpath = "//a[text()='New']")
    public WebElement addToListNewTab;
  
    @FindBy(xpath = "//div[@class='modal modal--visible'][2]//a[text()='New']")
    public WebElement addToListNewTabForCustomizeProduct;
    
    @FindBy(xpath = "//h3[text()='Create New List']")
    WebElement createNewListTextOnNewTab;

    @FindBy(xpath = "//*[@class='enter-name--list jq-list-add--input']")
    public WebElement newListNameEdit;

    @FindBy(xpath = "//div[@class='listCreate']//button[contains(text(),'Create List')]")
    WebElement createListButton;
    
    @FindBy(xpath = "//div[@class='modal modal--visible'][2]//*[@class='enter-name--list jq-list-add--input']")
    public WebElement newListNameEditForCustomizeProduct;

    @FindBy(xpath = "//div[@class='modal modal--visible'][2]//div[@class='listCreate']//button[contains(text(),'Create List')]")
    WebElement createListButtonForCustomizeProduct;

    @FindBy(xpath = "//*[@class='input-group--label-shared']/span")
    WebElement selectSharedListRadioBtn;

    @FindBy(xpath="//div[@class='modal__inner']/a[@class='modal__close jq-close-modal']")
    public
    WebElement closeSavedListModalWindow;

    //Add To List
    @FindBy(xpath="//button[contains(text(),'Add to List')]")
    public
    WebElement addToListButton;

    @FindBy(xpath = "//div[@class='widget-wrapper__header']//h3[contains(text(),'Add to existing or Create new list')]")
    WebElement addToExistingOrCreateNewListText;
  
    @FindBy(xpath = "//div[@class='list-add']/h2")
    public WebElement addToListModalTitleText;
    
    @FindBy(xpath = "//a[text()='Existing']")
    public WebElement addToListExistingTab;

    @FindBy(xpath = "//button[contains(text(),'Add To List')]")
    WebElement addToListButtonOnModal;

    @FindBy(xpath = "//a[text()='Existing']")
    WebElement defaultTabselected;

    @FindBy(xpath = "//ul[@class='list-add__list']/li[1]/strong")
    WebElement firstSavedListText;

    @FindBy(xpath = "//ul[@class='list-add__list']//span[text()='Private']")
    List<WebElement> SavedPrivateListText;

    public void addItemToNewListWithSameName(String newListName) {
        addToListNewTab.click();
        newListNameEdit.sendKeys(newListName);
        createListButton.click();
    }
    
    public boolean isDisplayedCreateNewListTextOnNewTab() {
        waitTool.waitForElement(driver,createNewListTextOnNewTab);
        return createNewListTextOnNewTab.isDisplayed();
    }

    public void closeSavedListModalWindow()
    {
        closeSavedListModalWindow.click();

    }
    /**
     * Add product item to existing List
     */
    public void addItemToExistingList() {
        isAddToExistingOrCreateNewListTitleTextDisplayed();
        waitTool.waitForElement(driver, addToListNewTab);
        addToListExistingTab.click();
      //  firstSavedListText.click();
     //   firstSavedListText.getText();
        clickFirstSavedListInExistingList();
        
    }
    
    public void clickFirstSavedListInExistingList()
    {
    	try
    	{
    		SavedPrivateListText.get(0).click();
    		addToListButtonOnModal.click();
    	}
    	catch(Exception e)
    	{
    		System.out.println("no private list displayed in existing lists");
    		addToListNewTab.click();
    		String random = pageManager.common().getRandomString(4);
    		newListName = newListName + random;
    		System.out.println("new list created " + newListName + " and product added to the list");
    		newListNameEdit.sendKeys(newListName);
    		createListButton.click();    		
    	}
    }
    
    public String addItemExistingList() {
    	 String listName ;
        waitTool.waitForElement(driver, addToListExistingTab);
        addToListExistingTab.click();
        try
        {
        String existingListName =  firstSavedListText.getText().trim();
        firstSavedListText.click();
        addToListButtonOnModal.click();
        System.out.println("existingListName: " + existingListName/*.substring(0, 9)*/);
        listName =  existingListName/*.substring(0, 9)*/;
        System.out.println("list name iss"+ listName);
        }
        catch(Exception e )
        {
        	 waitTool.waitForElement(driver,addToListNewTab);
             addToListNewTab.click();
             String random = pageManager.common().getRandomString(4);
             newListName = newListName + random;
             listName = newListName;
             System.out.println("list name iss" + listName);
             newListNameEdit.sendKeys(newListName);
             createListButton.click();
        }
        return listName;
    }
    
    public boolean WaitForAddToListExistingTabDisplayed() {
        waitTool.waitForElement(driver,addToListExistingTab);
        return addToListExistingTab.isDisplayed();
    }

    /**
     * Add product item to New List
     */
    public String addItemToNewList(String newListName) {
        isAddToExistingOrCreateNewListTitleTextDisplayed();
        waitTool.waitForElement(driver,addToListNewTab);
        pageManager.common().scrolltoViewElement(addToListNewTab, driver);
        addToListNewTab.click();
        String random = pageManager.common().getRandomString(4);
        newListName = newListName + random;
        newListNameEdit.sendKeys(newListName);
        createListButton.click();
        return newListName;
    }

    public String addItemToNewListForCustomizedProduct(String newListName) {
        isAddToExistingOrCreateNewListTitleTextDisplayed();
        waitTool.waitForElement(driver,addToListNewTabForCustomizeProduct);
        addToListNewTabForCustomizeProduct.click();
        String random = pageManager.common().getRandomString(4);
        newListName = newListName + random;
        newListNameEditForCustomizeProduct.sendKeys(newListName);
        createListButtonForCustomizeProduct.click();
        return newListName;
    }

    public String addItemToNewSharedList(String newSharedListName) {
        isAddToExistingOrCreateNewListTitleTextDisplayed();
        waitTool.waitForElement(driver,addToListNewTab);
        addToListNewTab.click();
        selectSharedListRadioBtn.click();
        String random = pageManager.common().getRandomString(4);
        newListName = newListName + random;
        newListNameEdit.sendKeys(newListName);
        createListButton.click();
        return newListName;
    }

    /**
     * @return Add to Existing Or Create New List title text
     */
    public Boolean isAddToExistingOrCreateNewListTitleTextDisplayed() {
    	waitTool.waitForElement(driver,addToExistingOrCreateNewListText);
        pageManager.common().scrolltoViewElement(addToExistingOrCreateNewListText, driver);
        return addToExistingOrCreateNewListText.isDisplayed();
    }

    /**
     * @return product name displayed as Title on Add to list modal window
     */
    public String getAddToListModalTitleText() {
    	waitTool.waitForElement(driver, addToListModalTitleText);
        return addToListModalTitleText.getText();
    }

    /**
     * @return true if New Tab is displayed in Add to List Modal otherwise false
     */
    public boolean isDisplayedExistingOrNewTabsOnAddToListModal() {
        waitTool.waitForElement(driver,addToListExistingTab);
        return addToListExistingTab.isDisplayed() && addToListNewTab.isDisplayed();

    }

    /**
     * @return true if Existing tab is selected by default for user having previously saved lists otherwise New tab should be selected by default
     */
    public boolean isDisplayedDefaultTabSelectedCorrectly() {
        System.out.println("default tab "+defaultTabselected.getText() );
        return ((defaultTabselected.getText().equalsIgnoreCase("Existing") && pageManager.common().isElementPresent(firstSavedListText)));
    }

    public Boolean isAddToLisButtonDisplayed()
    {
        return addToListButton.isDisplayed();
    }

    public void createNewListInAddToListModal() {
    	newListName="List_";
        isAddToExistingOrCreateNewListTitleTextDisplayed();
        String newlistcreated = pageManager.addToExistingORCreateNewList_modal().addItemToNewList(newListName);
        System.out.println("newlistcreated is" + newlistcreated);
        driver.navigate().refresh();
      /*  pageManager.homePage().clickMyAccountSavedListsQuickLink();
        pageManager.savedListsPage().clickOnRecentlyUpdatedLink();*/
        pageManager.savedListsPage().navigateToSavedListPageAndClickOnRecentlyUpdatedList();
        String newlistdisplayed = pageManager.savedListsPage().getNewlyCreatedList();
        System.out.println("Newlistdisplayed is: " + newlistdisplayed + "  " + "Newlistcreated is " + newlistcreated);
        Assert.assertEquals(newlistcreated, newlistdisplayed);
    }



}
