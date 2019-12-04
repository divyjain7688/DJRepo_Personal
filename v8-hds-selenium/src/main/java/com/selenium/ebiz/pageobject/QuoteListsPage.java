package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuoteListsPage{

	private WebDriver driver;
	private WaitTool waitTool;
	PageManager pageManager;
	
	public QuoteListsPage(WebDriver driver) 	{
		this.driver = driver;
		this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		this.pageManager = new PageManager(driver);
	}
	
	@FindBy(xpath="//h1[text()='Quote Lists']")
	public WebElement quotespageHeadingText;

	@FindBy(xpath = "//tbody[@id='quote-table-body']/tr[1]//a[text()='Checkout Quote']")
	WebElement checkoutQuoteLinkOfLatestQuote;

	@FindBy(xpath = "//*[@class='table--responsive table--sortable']/tbody/tr/td[1]")
	List<WebElement> listAllQuotesNames;

	@FindBy(xpath = "//td[@class=\"jq-quote-lists-each-display-row\"]")
	public
	List<WebElement> listAllQuotesIDs;

	@FindBy(xpath = "//*[@class='select--alt']")
	WebElement dropDown;
	
	@FindBy(xpath = "//div[@class='quotes__header-right el--margin-top-4']//button[@class='jq-quote-add--create--List btn btn']")
	public WebElement createNewQuoteButton;
	
	@FindBy(xpath = "//table[@class='table--responsive table--sortable']//tr[1]/td[1]")
	WebElement firstQuoteName;
	
	@FindBy(xpath = "//div[@class='quotes__header-left el--margin-top-4']//strong[text()='Digital Quotes']/../../span")
	public WebElement digitalQuotesRadioButton;
	
	@FindBy(xpath = "//div[@class='quotes__header-left el--margin-top-4']//strong[text()='All Other Quotes']/../../span")
	public WebElement allOtherQuotesRadioButton;
	
	@FindBy(xpath = "//div[@class='tabs__bar']/a[contains(text(),'Active')]")
	WebElement digitalQuotesActive;
	
	@FindBy(xpath = "//div[@class='tabs__bar']/a[contains(text(),'Deleted')]")
	public WebElement digitalQuotesDeleted;
	
	@FindBy(xpath = "//div[@class='tabs__bar']/a[contains(text(),'Active')]")
	public WebElement allOtherQuotesActive;
	
	@FindBy(xpath = "//div[@class='tabs__bar']/a[contains(text(),'Expired')]")
	public WebElement allOtherQuotesExpired;
	
	@FindBy(xpath = "//div[@class='quotes__table-action']/a[contains(text(),'Requote')]")
	List<WebElement> digitalQuotesRequoteLink;
	
	@FindBy(xpath = "//a[text()='Requote']")
	List<WebElement> allOtherQuotesRequoteLink;
	
	
	@FindBy(xpath = "//div[@class='quotes__pagination-label']//span[@class='type--body-large']")
	WebElement ResultsPerPage;
	
	@FindBy(xpath = "//div[@class='quotes__pagination-label']//span[@class='type--body-large']/strong")
	WebElement totalQuotesCount;
	
	@FindBy(xpath = "//div[@class='quotes__table-filter select--alt el--margin-right-1']")
	WebElement showPerPage;
	
	@FindBy(xpath = "//div[@class='quotes__table-filter select--alt el--margin-right-1']/select[@class='select--alt']")
	WebElement showPerPageDropdown;
	
	@FindBy(xpath = "//table[@class='table--responsive table--sortable']//th[contains(text(),'Quote Name')]")
	WebElement quoteNameHeaderInTable;
	
	@FindBy(xpath = "//table[@class='table--responsive table--sortable']//th[contains(text(),'Quote ID')]")
	WebElement quoteIDHeaderInTable;
	
	@FindBy(xpath = "//table[@class='table--responsive table--sortable']//th[contains(text(),'Created By')]")
	WebElement createdByHeaderInTable;
	
	@FindBy(xpath = "//table[@class='table--responsive table--sortable']//th[contains(text(),'Created On')]")
	WebElement createdOnHeaderInTable;
	
	@FindBy(xpath = "//table[@class='table--responsive table--sortable']//th[contains(text(),'Last Updated')]")
	WebElement lastUpdatedHeaderInTable;
	
	@FindBy(xpath = "//table[@class='table--responsive table--sortable']//th[contains(text(),'Quote Total')]")
	WebElement quoteTotalHeaderInTable;
	
	@FindBy(xpath = "//div[@class=\"quotes__title-tools\"]//strong[text()='Digital Quotes']")
	WebElement digitalQuoteText;
	
	@FindBy(xpath = "//a[@class='link--strong jq-quote-landing-checkout']")
	List<WebElement> checkOutLink;
	
	@FindBy(xpath = "//div[@class='quotes__table-action']/a[contains(text(),'Delete')]")
	List<WebElement> deleteLink;
	
	@FindBy(xpath = "//a[text()='Checkout Quote']")
	List<WebElement> checkOutQuoteLink;
	
	@FindBy(xpath = "//div[contains(text(),'re sorry! You currently do not have any')]")
	public WebElement noQuotesMessageForDigitalQuotes;
	
	@FindBy(xpath = "//div[contains(text(),' You currently do not have any deleted Digital quotes.')]")
	public WebElement noDeletedQuotesMessageForDigitalQuotes;
	
	@FindBy(xpath = "//div[contains(text(),'You have no quotes that match your filter criteria')]")
	public WebElement noQuotesMessageForAllOtherQuotes;
	
	@FindBy(xpath = "//div[@class='pagination__info']")
	WebElement paginationInfo;
	
	@FindBy(xpath = "//div[@class='pagination']/a")
	WebElement paginationForwardButton;
	
	@FindBy(xpath = "//div[@class='pagination']/a")
	WebElement paginationBackwardButton;
	
	@FindBy(xpath = "//input[@class='jq-pagination-sl-change']")
	WebElement pageNumber;
	
	@FindBy(xpath = "//table[@class='table--responsive table--sortable']")
	public WebElement quotesTable;
	
	@FindBy(xpath = "//tbody/tr/td[1]")
	List<WebElement> quoteNamesList;
	
	@FindBy(xpath = "//tbody/tr/td[2]")
	public List<WebElement> quoteIDList;
	
	@FindBy(xpath = "//tbody/tr/td[3]")
	List<WebElement> CreatedByList;
	
	@FindBy(xpath = "//tbody/tr/td[4]")
	List<WebElement> CreatedOnList;
	
	@FindBy(xpath = "//tbody/tr/td[5]")
	List<WebElement> LastUpdatedList;
	
	@FindBy(xpath = "//tbody/tr/td[6]")
	List<WebElement> quoteTotalList;
	
	@FindBy(xpath = "//a[@class=\"jq-open-modal\"]")
	public WebElement emailToLink;
	
	/**
	 * 
	 * get Page Heading text
	 * @return string page heading text
	 */
	public String getQuotesPageHeadingText() {
		return quotespageHeadingText.getText().trim();
	}

	public boolean isDisplayedQuotesPageHeadingText(){
		return quotespageHeadingText.isDisplayed();	
	}


	public void clickOnCheckoutQuoteLinkOfLatestQuote() throws Exception
	{
		//waitTool.hardWait();
		waitTool.waitForElement(driver, checkoutQuoteLinkOfLatestQuote);
		pageManager.common().scrolltoViewElement(checkoutQuoteLinkOfLatestQuote, driver);
		checkoutQuoteLinkOfLatestQuote.click();

	}
	
	public void clickOnFirstQuoteName() throws Exception
	{
		pageManager.common().refresh();
		waitTool.waitForElement(driver, listAllQuotesNames.get(0));
		pageManager.common().scrolltoViewElement(listAllQuotesNames.get(0), driver);
		listAllQuotesNames.get(0).click();

	}

	public Boolean isAddedQuoteDisplayedInQuotePage(String quoteName)
	{
		waitTool.waitForElement(driver,quotespageHeadingText);
		Boolean flag=false;
		//System.out.println("quote name " + quoteName);
		for(WebElement displayedQuotes : listAllQuotesNames)
		{
			System.out.println("Quote Page displayed quotes: " + displayedQuotes.getText());
		}

		for(WebElement displayedQuotes : listAllQuotesNames)
		{
			if(displayedQuotes.getText().contains(quoteName))
			{
				flag=true;
				System.out.println("flag updated to true");
				break;
			}
		}
		return flag;
	}

	public Boolean isAddedQuoteNumberIDDisplayedInQuotePage(String quoteID)
	{
		waitTool.waitForElement(driver,listAllQuotesNames.get(0));
		Boolean flag=false;
		//System.out.println("quote name " + quoteName);
		for(WebElement displayedQuotesID : listAllQuotesIDs)
		{
			System.out.println("Quote Page displayed quotes id: " + displayedQuotesID.getText());
		}

		for(WebElement displayedQuotesID : listAllQuotesIDs)
		{
			if(displayedQuotesID.getText().contains(quoteID))
			{
				flag=true;
				System.out.println("flag updated to true");
				break;
			}
		}
		return flag;
	}

	public void getSortByDropdown(String text)
	{
		Select select = new Select(dropDown);
		select.selectByVisibleText(text);

	}

	public void clickOnCreateNewQuoteButton()
	{
		waitTool.waitForElement(driver, createNewQuoteButton);
		pageManager.common().scrolltoViewElement(createNewQuoteButton, driver);
		createNewQuoteButton.click();
	}
	
	public String getFirstQuoteName()
	{
		waitTool.waitFor(driver, true);
		waitTool.waitForElement(driver, quotespageHeadingText);
		pageManager.common().refresh();
		System.out.println("firstQuoteName is "+ firstQuoteName);
		return firstQuoteName.getText();
	}
	
	public Boolean AreQuotesPageAttributesDisplayed()
	{
	    waitTool.waitForElement(driver, digitalQuotesRadioButton);
	    Boolean flag = false;
		List<WebElement> elements= new ArrayList<WebElement>();
		elements.add(quoteNameHeaderInTable);
		elements.add(quoteIDHeaderInTable);
		elements.add(createdByHeaderInTable);
		elements.add(createdOnHeaderInTable);
		elements.add(ResultsPerPage);
		elements.add(showPerPage);
		for(WebElement element : elements)
		{
			if(element.isDisplayed())
			{
				flag=true;
			}
			else
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public Boolean AreQuotesPageTableAttributesDisplayed()
	{
	    waitTool.waitForElement(driver, digitalQuotesRadioButton);
	    Boolean flag = false;
		List<WebElement> elements= new ArrayList<WebElement>();
		elements.add(digitalQuotesRadioButton);
		elements.add(allOtherQuotesRadioButton);
		elements.add(digitalQuotesActive);
		elements.add(digitalQuotesDeleted);
		elements.add(lastUpdatedHeaderInTable);
		elements.add(quoteTotalHeaderInTable);
		for(WebElement element : elements)
		{
			if(element.isDisplayed())
			{
				flag=true;
			}
			else
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public Boolean areCheckoutButtonsDisplayed()
	{
		Boolean flag = false;
		if(checkOutLink.size()>0)
		{
			flag=true;
		}
		return flag;
	}
	
	public void isPaginationInfoDisplayed()
	{
		if(checkOutLink.size()>24)
		{
			paginationInfo.isDisplayed();
		}
		else
		{
			System.out.println("pagination section not displayed becauxe products are less than 24");
		}
	}
	
	public Boolean isCreateNewQuoteButtonDisplayedForallOtherQuotes()
	{
		Boolean flag = false;
		allOtherQuotesRadioButton.click();
		waitTool.waitFor(driver, true);
		try
		{
			createNewQuoteButton.isDisplayed();
			flag=true;
		}
		catch(Exception e)
		{
			System.out.println("createNewQuoteButton not displayed "+ e);
		}
		return flag;
	}
	
	public void isActiveTabAndOnlineQuotesDisplayed()
	{
		waitTool.waitForElement(driver, digitalQuotesRadioButton);
		digitalQuotesRadioButton.click();
		Boolean flag = true;
		try
		{
			digitalQuotesActive.isDisplayed();
			quotesTable.isDisplayed();
			int size =  checkOutLink.size();
			Assert.assertNotEquals(0, size);
		}
		catch(Exception e)
		{
			System.out.println("quotes table is not displayed");
		}
	}
	
	public void isActiveTabAndOfflineQuotesDisplayed()
	{
		
		waitTool.waitForElement(driver, allOtherQuotesRadioButton);
		allOtherQuotesRadioButton.click();
		try
		{
			digitalQuotesActive.isDisplayed();
			quotesTable.isDisplayed();
			int size =  checkOutQuoteLink.size();
			Assert.assertNotEquals(0, size);
		}
		catch(Exception e)
		{
			System.out.println("quotes table is not displayed");
		}
	}
	
	public Boolean areDigitalQuoteAttributesDispalyed()
	{
		waitTool.waitForElement(driver, digitalQuotesRadioButton);
		digitalQuotesRadioButton.click();
		Boolean flag = false;
		List<WebElement> elements= new ArrayList<WebElement>();
		elements.add(digitalQuotesActive);
		elements.add(digitalQuotesDeleted);
		try
		{
			noQuotesMessageForDigitalQuotes.isDisplayed();
		}
		catch(Exception e)
		{
			checkOutLink.get(0).isDisplayed();
			deleteLink.get(0).isDisplayed();
		}
		digitalQuotesDeleted.click();
		try
		{
			noQuotesMessageForDigitalQuotes.isDisplayed();
		}
		catch(Exception e)
		{
			digitalQuotesRequoteLink.get(0).isDisplayed();
		}
		for(WebElement element : elements)
		{
			if(element.isDisplayed())
			{
				flag=true;
			}
			else
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public Boolean areAllOtherQuotesAttributesDispalyed()
	{
		waitTool.waitForElement(driver, allOtherQuotesRadioButton);
		allOtherQuotesRadioButton.click();
		Boolean flag = false;
		List<WebElement> elements= new ArrayList<WebElement>();
		elements.add(allOtherQuotesActive);
		elements.add(allOtherQuotesExpired);
		try
		{
			noQuotesMessageForAllOtherQuotes.isDisplayed();

		}
		catch(Exception e)
		{
		checkOutQuoteLink.get(0).isDisplayed();
		}
		allOtherQuotesExpired.click();
		try
		{
			noQuotesMessageForAllOtherQuotes.isDisplayed();

		}
		catch(Exception e)
		{
			allOtherQuotesRequoteLink.get(0).isDisplayed();
		}
		for(WebElement element : elements)
		{
			System.out.println("elemt areee");
			element.getText();
		}
		for(WebElement element : elements)
		{
			if(element.isDisplayed())
			{
				flag=true;
			}
			else
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public Boolean veriyNumberOfQuotesPerPage(int number)
	{
		Boolean flag= false;
		digitalQuotesRadioButton.click();
		try
		{
		waitTool.waitForElement(driver, digitalQuoteText);
		String visibleText = String.valueOf(number);
		Select select = new Select(showPerPageDropdown);
		select.selectByVisibleText(visibleText);
		if(checkOutLink.size()<=number)
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		return flag;
		}
		catch(Exception e)
		{
			noQuotesMessageForDigitalQuotes.isDisplayed();
			System.out.println("noQuotesMessageForDigitalQuotes is displayed ");
			flag=true;
			return flag;
		}

	}

	public void areQuotesSortedByQuoteName() 
	{
		List<String> ListBeforeSort = new ArrayList<String>();
		List<String> ListAfterSort = new ArrayList<String>();

		try
		{
			noQuotesMessageForDigitalQuotes.isDisplayed();
		}
		catch(Exception e)
		{
			for(WebElement List:quoteNamesList)
			{
				ListBeforeSort.add(List.getText());
			}
			quoteNameHeaderInTable.click();
			waitTool.waitFor(driver, true);
			for(WebElement List:quoteNamesList)
			{
				ListAfterSort.add(List.getText());
			}
			Set<String> setBeforeSort = new HashSet<String>(ListBeforeSort);
			System.out.println("ListBeforeSort is "+ ListBeforeSort);
			System.out.println("ListAfterSort is "+ ListAfterSort);

			if(setBeforeSort.size()==1)
			{
				Assert.assertEquals(ListBeforeSort, ListAfterSort);
			}
			else
			{
				Assert.assertNotEquals(ListBeforeSort, ListAfterSort);
			}
		}
	}

	public void areQuotesSortedByQuoteID() 
	{
		List<String> ListBeforeSort = new ArrayList<String>();
		List<String> ListAfterSort = new ArrayList<String>();
		try
		{
			noQuotesMessageForDigitalQuotes.isDisplayed();
		}
		catch(Exception e)
		{
		for(WebElement List:quoteIDList)
		{
			ListBeforeSort.add(List.getText());
		}
		quoteNameHeaderInTable.click();
		waitTool.waitFor(driver, true);
		for(WebElement List:quoteIDList)
		{
			ListAfterSort.add(List.getText());
		}
		Set<String> setBeforeSort = new HashSet<String>(ListBeforeSort);
		if(setBeforeSort.size()==1)
		{
			Assert.assertEquals(ListBeforeSort, ListAfterSort);
		}
		else
		{
			Assert.assertNotEquals(ListBeforeSort, ListAfterSort);
		}
		}
	}

	public void areQuotesSortedByCreatedBy() 
	{
		List<String> ListBeforeSort = new ArrayList<String>();
		List<String> ListAfterSort = new ArrayList<String>();
		try
		{
			noQuotesMessageForDigitalQuotes.isDisplayed();
		}
		catch(Exception e)
		{
		for(WebElement List:CreatedByList)
		{
			ListBeforeSort.add(List.getText());
		}
		createdByHeaderInTable.click();
		waitTool.waitFor(driver, true);
		for(WebElement List:CreatedByList)
		{
			ListAfterSort.add(List.getText());
		}
		Set<String> setBeforeSort = new HashSet<String>(ListBeforeSort);
		if(setBeforeSort.size()==1)
		{
			Assert.assertEquals(ListBeforeSort, ListAfterSort);
		}
		else
		{
			Assert.assertNotEquals(ListBeforeSort, ListAfterSort);
		}
		}

	}

	public void areQuotesSortedByLastUpdated() 
	{
		List<String> ListBeforeSort = new ArrayList<String>();
		List<String> ListAfterSort = new ArrayList<String>();
		try
		{
			noQuotesMessageForDigitalQuotes.isDisplayed();
		}
		catch(Exception e)
		{
		for(WebElement List:LastUpdatedList)
		{
			ListBeforeSort.add(List.getText());
		}
		lastUpdatedHeaderInTable.click();
		waitTool.waitFor(driver, true);
		for(WebElement List:LastUpdatedList)
		{
			ListAfterSort.add(List.getText());
		}
		Set<String> setBeforeSort = new HashSet<String>(ListBeforeSort);
		if(setBeforeSort.size()==1)
		{
			Assert.assertEquals(ListBeforeSort, ListAfterSort);
		}
		else
		{
			Assert.assertNotEquals(ListBeforeSort, ListAfterSort);
		}
		}
	}


	public void areQuotesSortedByQuotesTotal() 
	{
		List<String> ListBeforeSort = new ArrayList<String>();
		List<String> ListAfterSort = new ArrayList<String>();
		try
		{
			noQuotesMessageForDigitalQuotes.isDisplayed();
		}
		catch(Exception e)
		{
		for(WebElement List:quoteTotalList)
		{
			ListBeforeSort.add(List.getText());
		}
		quoteTotalHeaderInTable.click();
		waitTool.waitFor(driver, true);
		for(WebElement List:quoteTotalList)
		{
			ListAfterSort.add(List.getText());
		}
		Set<String> setBeforeSort = new HashSet<String>(ListBeforeSort);
		if(setBeforeSort.size()==1)
		{
			Assert.assertEquals(ListBeforeSort, ListAfterSort);
		}
		else
		{
			Assert.assertNotEquals(ListBeforeSort, ListAfterSort);
		}
		}
	}
	
	public void createNewQuoteIfQuotesAreLessThenTwentyFour() throws Exception
	{
		int counter ;
		ArrayList<UsersListBean> usersList;
		if(checkOutLink.size()<=24)
		{
			counter = 25-checkOutLink.size();
			{
				for(int i=0;i<=counter;i++)
				{
					System.out.println(i + " "+ checkOutLink.size());
					waitTool.waitForElement(driver, createNewQuoteButton);
					pageManager.common().scrolltoViewElement(createNewQuoteButton, driver);
					createNewQuoteButton.click();
					usersList=pageManager.dBCon().loadDataFromExcel("addProductsInCreateNewQuoteModal","Quotes");
				//	pageManager.createNewQuote_Modal().createNewQuoteWithOnePartNumber(usersList.get(0).getPartNumber2());
					// Adding 6 parts into the quote overlapped CreateNew quote btn
					pageManager.createNewQuote_Modal().createNewQuoteWithSixPartNumbers(usersList.get(0).getPartNumber1(), usersList.get(0).getPartNumber2(), usersList.get(0).getPartNumber3(),
							usersList.get(0).getPartNumber4(), usersList.get(0).getPartNumber5(), usersList.get(0).getPartNumber6());
					waitTool.waitFor(driver, true);
					pageManager.common().refresh();

				}

			}
		}
	}
	
	public void createNewQuote() throws Exception
	{
		ArrayList<UsersListBean> usersList;
		waitTool.waitForElement(driver, createNewQuoteButton);
		pageManager.common().scrolltoViewElement(createNewQuoteButton, driver);
		createNewQuoteButton.click();
		usersList=pageManager.dBCon().loadDataFromExcel("addProductsInCreateNewQuoteModal","Quotes");
		System.out.println("Part number added to quote: " + usersList.get(0).getPartNumber1());
		pageManager.createNewQuote_Modal().createNewQuoteWithOnePartNumber(usersList.get(0).getPartNumber1());
		waitTool.waitFor(driver, true);
		pageManager.common().refresh();
	}

	public void createFiveNewQuote() throws Exception
	{
		ArrayList<UsersListBean> usersList;
		for(int i=0;i<6;i++)
		{
			waitTool.waitForElement(driver, createNewQuoteButton);
			pageManager.common().scrolltoViewElement(createNewQuoteButton, driver);
			createNewQuoteButton.click();
			usersList=pageManager.dBCon().loadDataFromExcel("addProductsInCreateNewQuoteModal","Quotes");
			pageManager.createNewQuote_Modal().createNewQuoteWithSixPartNumbers(usersList.get(0).getPartNumber1(), usersList.get(0).getPartNumber2(), usersList.get(0).getPartNumber3(), 
					usersList.get(0).getPartNumber4(), usersList.get(0).getPartNumber5(), usersList.get(0).getPartNumber6());
			waitTool.waitFor(driver, true);
			pageManager.common().refresh();
		}
	}
	

	public String verifyPaginationOption()
	{
		paginationForwardButton.click();
		System.err.println("pageNumber.getText() "+ pageNumber.getAttribute("value"));
		return pageNumber.getAttribute("value");
		
	}
	
	public void navigateBackToFirstPage()
	{
		paginationBackwardButton.click();
	}
	
	public String deleteDigitalQuote() throws Exception
	{
		digitalQuotesRadioButton.click();
		try
		{
			String quoteId = quoteIDList.get(0).getText();
			deleteLink.get(0).click();
			pageManager.common().acceptPopupMessageBox(driver);
			waitTool.waitFor(driver, true);
			pageManager.common().refresh();
			return quoteId;
		}
		catch(Exception e)
		{
			System.out.println(" no quote list displayed"+ noQuotesMessageForDigitalQuotes.isDisplayed());
			createNewQuote();
			String quoteId = quoteIDList.get(0).getText();
			deleteLink.get(0).click();
			pageManager.common().acceptPopupMessageBox(driver);
			waitTool.waitFor(driver, true);
			pageManager.common().refresh();
			return quoteId;
		}

	}
	
	public void deleteFiveDigitalQuote()
	{
		digitalQuotesActive.click();
		waitTool.waitFor(driver, true);
		for(int i=0;i<6;i++)
		{
			waitTool.waitForElement(driver, deleteLink.get(0));
			pageManager.common().scrolltoViewElement(deleteLink.get(0), driver);
			deleteLink.get(0).click();
			pageManager.common().acceptPopupMessageBox(driver);
			waitTool.waitFor(driver, true);
			pageManager.common().refresh();
		}
	}
		
	
	
	public void deleteAllDigitalQuoteIfExist() throws Exception
	{
		digitalQuotesRadioButton.click();
		int deleteLinkSize= deleteLink.size();
		System.out.println("delete link size is " + deleteLinkSize);
		if(deleteLinkSize>0)
		{ 
			int total=Integer.valueOf(totalQuotesCount.getText());
			for(int i=0;i<total;i++)
			{
				deleteLink.get(0).click();
				pageManager.common().acceptPopupMessageBox(driver);
				waitTool.waitFor(driver, true);
				pageManager.common().refresh();
			}
		}
		else
		{
			System.out.println(" not active digital quote present");
		}

	}
	
	public void requoteAllDeletedDigitalQuoteIfExist() throws Exception
	{
		digitalQuotesRadioButton.click();
		digitalQuotesDeleted.click();
		waitTool.waitFor(driver, true);
		//pageManager.common().refresh();
		int requoteLinkSize= digitalQuotesRequoteLink.size();
		System.out.println("requote link size is " + requoteLinkSize);
		if(requoteLinkSize>0)
		{ 
			int total=Integer.valueOf(totalQuotesCount.getText());
			for(int i=0;i<total;i++)
			{
				waitTool.waitForElement(driver, digitalQuotesRequoteLink.get(0));
				pageManager.common().scrolltoViewElement(digitalQuotesRequoteLink.get(0), driver);
				digitalQuotesRequoteLink.get(0).click();
				waitTool.waitFor(driver, true);
				pageManager.common().refresh();
			}
		}
		else
		{
			System.out.println(" not deleted digital quote present to requote");
		}

	}
	
	public String deleteDigitalQuoteAndCancel() throws Exception
	{
		digitalQuotesRadioButton.click();
		try
		{
			String quoteId = quoteIDList.get(0).getText();
			deleteLink.get(0).click();
			pageManager.common().cancelPopupMessageBox(driver);
			return quoteId;
		}
		catch(Exception e)
		{
			System.out.println(" no quote list displayed"+ noQuotesMessageForDigitalQuotes.isDisplayed());
			createNewQuote();
			String quoteId = quoteIDList.get(0).getText();
			deleteLink.get(0).click();
			pageManager.common().cancelPopupMessageBox(driver);
			return quoteId;
		}

	}
	
	
	public void navigateToDigitalQuotesDeleted()
	{
		waitTool.waitFor(driver, true);
		pageManager.common().scrolltoViewElement(digitalQuotesDeleted, driver);
		digitalQuotesDeleted.click();
	}
	
	public Boolean isQuoteDeleted(String quoteId)
	{
		Boolean flag = false;
		navigateToDigitalQuotesDeleted();
		for(WebElement quoteID:quoteIDList)
		{
			if(quoteID.getText().equals(quoteId))
				flag=true;
		}
		return flag;
	}
	
	public void deleteaQuoteIfThereIsNoDeletedQuote() throws Exception
	{
		navigateToDigitalQuotesDeleted();
		int size = digitalQuotesRequoteLink.size();
				if(size<1)
				{
					digitalQuotesActive.click();
					int deleteLinksize = deleteLink.size();
					if(deleteLinksize<1)
					{
					createNewQuote();
					}
					deleteLink.get(0).click();
					pageManager.common().acceptPopupMessageBox(driver);
					waitTool.waitFor(driver, true);
					pageManager.common().refresh();
				}
	}
	
	public Boolean isDigitalQuotesRequoteLinkDisplayed()
	{
		Boolean flag= false;
		for(WebElement link : digitalQuotesRequoteLink)
		{
			if(link.isDisplayed())
			{
				flag=true;
			}
			else
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public String clickOnRequoteLink()
	{
		String quoteId=quoteIDList.get(0).getText();
		digitalQuotesRequoteLink.get(0).click();
		pageManager.common().refresh();
		return quoteId;

	}
	
	public String getFirstAciveDigitalQuoteID()
	{
		waitTool.waitForElement(driver, digitalQuotesActive);
		pageManager.common().scrolltoViewElement(digitalQuotesActive, driver);
		digitalQuotesActive.click();
		waitTool.waitFor(driver, true);
		System.out.println("quoteIDList.get(0).getText();" + quoteIDList.get(0).getText());
		return quoteIDList.get(0).getText();
		
	}
	
	public String getFirstCreatedByName()
	{
		return CreatedByList.get(0).getText();
	}
	
	public Boolean isFirstdeleteAndCheckoutLinkDisplayed()
	{
		Boolean flag = false;
		if(deleteLink.get(0).isDisplayed()&checkOutLink.get(0).isDisplayed())
		{
		flag = true;
		}
		return flag;
	}
	
	
	}
