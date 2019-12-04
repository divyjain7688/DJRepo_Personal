package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class AddToExistingORCreateNewQUOTE_modal {

    private WebDriver driver;
    private WaitTool waitTool;
    private PageManager pageManager;
    private String newQuoteName;

    public AddToExistingORCreateNewQUOTE_modal(WebDriver driver) 	{
        this.driver = driver;  this.waitTool = new WaitTool();
        PageFactory.initElements(driver, this);
        this.pageManager=new PageManager(driver);
    }

   // @FindBy(xpath = "//ul[@class='list-add__list']/li[1]")
   //  WebElement existingFirstSavedList;

    @FindBy(xpath = "//a[text()='New']")
    public WebElement addToQuoteNewTab;

    @FindBy(xpath = "//*[@class='jq-quote-add--input']")
    public WebElement newQuoteNameEnter;

    @FindBy(xpath = "//*[@data-hds-tag='quote-add__footer__footer-create-btn']")
    WebElement createQuoteButton;

    @FindBy(xpath = "//*[@class='quotes-add__add-to-quote-btn jq-quote-add--add btn btn']")
    public
    WebElement addToQuoteButton;

    @FindBy(xpath = "//*[@data-hds-tag='quote-add__header__product-name']")
    public WebElement partNumberDescriptionOnModalwindow;

    @FindBy(xpath="//a[@data-hds-tag='quote-add__footer__quotelist']")
    public WebElement seeAllQuotesBtn;

    @FindBy(xpath="//*[@class='modal__close jq-close-modal']")
    public WebElement closeQuoteModalWindow;

    @FindBy(xpath = "//*[contains(text(),'Add to existing or new quote')]")
    WebElement addToExistingOrCreateNewQuoteText;

    @FindBy(xpath = "//a[text()='Existing']")
    public WebElement addToExistingQuoteTab;

    @FindBy(xpath = "//*[@class='jq-quote-add--select quote-add__list-item']/td[1]")
    public List<WebElement> listOFExistedQuotesNames;

    @FindBy(xpath = "//*[@class='jq-quote-add--select quote-add__list-item']/td[2]")
    public List<WebElement> listOFExistedQuotesIDs;

    @FindBy(xpath = "//*[contains(text(),'Quote created successfully')]")
    WebElement quoteIsSuccesfullyCreatedPopup;

    @FindBy(xpath = "//*[contains(text(),' is successfully updated!')]")
    WebElement quoteIsSuccesfullyUpdatedPopup;

    @FindBy(xpath = "//*[@class='message_text']/span")
    WebElement popupText;

    @FindBy(xpath = "//*[@class='close_text']")
    WebElement closeQuoteIsSuccesfullyCreatedPopup;
  
    @FindBy(xpath = "//div[contains(text(),'You have no quotes that match your filter criteria')]")
    WebElement noExistingQuoteMessage;

    public void closeSavedListModalWindow()
    {
        closeQuoteModalWindow.click();

    }
    /**
     * Add product item to existing Quote
     */

    public String addItemToExistingQuote() {
        waitTool.waitForElement(driver, addToExistingOrCreateNewQuoteText);
       // addToExistingQuoteTab.click();
        listOFExistedQuotesNames.get(0).click();
        String existingQuoteName =  listOFExistedQuotesNames.get(0).getText();
        addToQuoteButton.click();
        System.out.println("existingQuoteName: " + existingQuoteName.substring(0, 9));
        return existingQuoteName.substring(0, 9);
    }
    
    public boolean WaitForExistingQuoteTabDisplayed() {
        waitTool.waitForElement(driver, addToExistingQuoteTab);
        return addToExistingQuoteTab.isDisplayed();
    }

    /**
     * Add product item to New Quote
     */
    public String addItemToNewQuote() {
        isAddToExistingOrCreateNewQuoteTitleTextDisplayed();
        waitTool.waitForElement(driver,addToQuoteNewTab);
        addToQuoteNewTab.click();
        String random = pageManager.common().getRandomString(4);
        newQuoteName = newQuoteName + random;
        newQuoteNameEnter.sendKeys(newQuoteName);
        createQuoteButton.click();
        return newQuoteName;
    }

    public Boolean isAddToExistingOrCreateNewQuoteTitleTextDisplayed() {
    	waitTool.waitForElement(driver, addToExistingOrCreateNewQuoteText);
        pageManager.common().scrolltoViewElement(addToExistingOrCreateNewQuoteText, driver);
        return addToExistingOrCreateNewQuoteText.isDisplayed();
    }

    public String getAddQuoteModalTitleText() {
    	waitTool.waitForElement(driver, addToExistingOrCreateNewQuoteText);
        return addToExistingOrCreateNewQuoteText.getText();
    }

    /**
     * @return true if New Tab is displayed in Quote Modal otherwise false
     */
    public boolean isDisplayedExistingOrNewTabsOnAddToListModal() {
        waitTool.waitForElement(driver, addToExistingQuoteTab);
        return addToExistingQuoteTab.isDisplayed() && addToQuoteNewTab.isDisplayed();

    }


    public boolean isDisplayedDefaultTabSelectedCorrectly() {
        System.out.println("default tab "+addToExistingQuoteTab.getText() );
        return ((addToExistingQuoteTab.getText().equalsIgnoreCase("Existing")));
    }

    public Boolean isCreateQuoteButtonDisplayed()
    {
        return createQuoteButton.isDisplayed();
    }

    public void createAndVerifyNewQuote() throws Exception {
        isAddToExistingOrCreateNewQuoteTitleTextDisplayed();
        String newquotecreated = addItemToNewQuote();
        System.out.println("newquotecreated is: " + newquotecreated);
        closePopUp();
        pageManager.homePage().clickQuotesUtilityBar();
        pageManager.quoteListsPage().isDisplayedQuotesPageHeadingText();
     //   pageManager.quoteListsPage().getSortByDropdown("Last Updated");
        Assert.assertTrue(pageManager.quoteListsPage().isAddedQuoteDisplayedInQuotePage(newquotecreated));
    }

    public void addItemIntoExistingQuoteById() throws Exception {
        isAddToExistingOrCreateNewQuoteTitleTextDisplayed();
        addToExistingQuoteTab.click();
        System.out.println(pageManager.addToExistingORCreateNewQUOTE_modal().listOFExistedQuotesIDs.get(0).getText());
        pageManager.addToExistingORCreateNewQUOTE_modal().listOFExistedQuotesIDs.get(0).click();
        pageManager.addToExistingORCreateNewQUOTE_modal().addToQuoteButton.click();
        captureQuoteNumberOnPopupAfterAddingToExistingQuote();
        waitTool.waitForElement(driver,closeQuoteIsSuccesfullyCreatedPopup);
        closeQuoteIsSuccesfullyCreatedPopup.click();
        driver.navigate().refresh();

    }

    public void closePopUp() {
        popupText.isDisplayed();
        waitTool.waitForElement(driver,closeQuoteIsSuccesfullyCreatedPopup);
        closeQuoteIsSuccesfullyCreatedPopup.click();
        driver.navigate().refresh();
    }

    public String captureQuoteNumberOnPopupAfterNewquoteWasCreated()
    {
        quoteIsSuccesfullyCreatedPopup.isDisplayed();
        waitTool.waitForElement(driver,closeQuoteIsSuccesfullyCreatedPopup);
        popupText.getText();
        System.out.println(popupText.getText());
        String quoteN=popupText.getText().substring(50);
        System.out.println(quoteN);
        closePopUp();
        return quoteN;
    }

    public String captureQuoteNumberOnPopupAfterAddingToExistingQuote()
    {
//        quoteIsSuccesfullyUpdatedPopup.isDisplayed();
        waitTool.waitForElement(driver,closeQuoteIsSuccesfullyCreatedPopup);
        popupText.getText();
        System.out.println(popupText.getText());
        String quoteN=popupText.getText().substring(11,22);
        System.out.println(quoteN);
        return quoteN;
    }
    
    public Boolean isSeeAllQuotesBtnDisplayed()
    {
    	//waitTool.waitForElement(driver, seeAllQuotesBtn);
    	pageManager.common().scrolltoViewElement(seeAllQuotesBtn, driver);
    	System.out.println("Scrll to See All Quotes btn");
    	return seeAllQuotesBtn.isDisplayed();
    }
    
   /* public void createNewQuoteIfNoQuoteExists()
    {
    	addToExistingQuoteTab.click();
    	noExistingQuoteMessage.isDisplayed();
    	addToQuoteNewTab.click();
         String random = .getRandomString(4);
         newQuoteName = newQuoteName + random;
         newQuoteNameEnter.sendKeys(newQuoteName);
         
         ArrayList<UsersListBean> usersList;
 		waitTool.waitForElement(driver, createNewQuoteButton);
 		pageManager.common().scrolltoViewElement(createNewQuoteButton, driver);
 		createNewQuoteButton.click();
 		usersList=pageManager.dBCon().loadDataFromExcel("addProductsInCreateNewQuoteModal","Quotes");
 		pageManager.createNewQuote_Modal().createNewQuoteWithSixPartNumbers(usersList.get(0).getPartNumber1(), usersList.get(0).getPartNumber2(), usersList.get(0).getPartNumber3(), 
 				usersList.get(0).getPartNumber4(), usersList.get(0).getPartNumber5(), usersList.get(0).getPartNumber6());
 		
 		
         createQuoteButton.click();
    }*/

}
