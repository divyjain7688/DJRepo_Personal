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
import java.util.Arrays;
import java.util.List;

public class SavedListsDetailPage {

    private WebDriver driver;
    private WaitTool waitTool;
    private PageManager pageManager;
    private ArrayList<UsersListBean> usersList;

    public SavedListsDetailPage(WebDriver driver) {
        this.driver = driver;
        this.waitTool = new WaitTool();
        PageFactory.initElements(driver, this);
        this.pageManager = new PageManager(driver);
    }

    //div[@class="saved-list__item-info"]
    @FindBy(xpath = "//div[@class='saved-list__item']")
    List<WebElement> displayedItems;

    @FindBy(xpath = "//div[@class='el--flex el--margin-right-3']")
            //"//div[@class='el--flex el--margin-right-4']")
    WebElement showXXPerPageText;
    
    @FindBy(xpath = "//strong[@data-hds-tag='saved-list__item-count']")
    WebElement noOfItemsInList;
    
    @FindBy(xpath = "//tr[@class='jq-saved-lists-display-row']/td[1]/strong")
    List<WebElement> displayedListNames;

    @FindBy(xpath = "//*[@data-hds-tag='saved-lists__per-page']")
            //"//div[@class='el--flex el--margin-right-4']/select")
    WebElement showPerPageDropdown;

    @FindBy(xpath = "//*[@class='type--caption el--margin-right-3']//*[text()='0']")
    public WebElement zeroItemsInListText;

    @FindBy(xpath = "//strong[text()='Add parts to your list ']")
    public WebElement addPartsToYourListText;

    @FindBy(xpath = "//strong[@class='jq-list-name']")
    public WebElement listNameText;

    @FindBy(xpath = "//strong[@class='el--margin-right-1'][text()='Notes:']")
    public WebElement notesText;
    
    @FindBy(xpath = "//a[@class='jq-list-notes-edit link--strong']")
    public WebElement editNotesLink;
    
    @FindBy(xpath = "//textarea[@id='notes']")
    public WebElement notesTextArea;
    
    @FindBy(xpath = "//button[@data-hds-tag='saved-list__update-notes']")
    public WebElement notesTextAreaUpdateButton;
    
    @FindBy(xpath = "//span[@data-hds-tag='saved-list__list-notes']")
    WebElement updatedNotesText;
    
    @FindBy(xpath = "//button[@data-hds-tag='saved-list__add-list-to-cart']")
    public WebElement addListToCartButton;
    
    @FindBy(xpath = "//div[@id='QuickAddToListForm']")
    public WebElement addPartsToListFeature;
  
    @FindBy(xpath = "//button[@class='jq-saved-list__quick-checkout btn btn--hollow btn--full']")
    public WebElement quickCheckoutButton;
    
    @FindBy(xpath = "//h3[contains(text(),'Manage List')]")
    public WebElement manageListText;

    @FindBy(xpath = "//button[@class='btn btn--full btn--small btn--light el--margin-top-1'][contains(text(),'REMOVE')]")
    List<WebElement> removeFromListLinkText;
    
    // Bhavani: Updated savedListsDetailPageTitle xpath for 1.16 STG Build
    //@FindBy(xpath = "//*[@data-hds-tag='saved-lists-container__header-name']")
    @FindBy(xpath = "//h1[contains(text(),'Saved Lists Detail')]")
    WebElement savedListsDetailPageTitle;

    @FindBy(xpath = "//*[@data-hds-tag='saved-lists__sort-by']")
    WebElement sortByDropDown;

    @FindBy(xpath = "//*[text()='Sort by:']")
    WebElement sortByText;

    @FindBy(xpath = "//*[@data-hds-tag='saved-list__item-count']")
            //"//span[@class='type--body-large el--margin-right-4']/strong")
    WebElement totalItemsTextValue;

    @FindBy(xpath = "//span[@class='type--body-large el--margin-right-4']/strong[text()='0']/..")
    WebElement noItemAddedMessage;

    @FindBy(xpath = "//div[@class='saved-list__image']")
    List<WebElement> saveListItemImages;

    @FindBy(xpath = "//*[@class='subcat-grid-tile__tiered-price type--center type--caption']/div[2]/span")
    List<WebElement> saveListItemPrices;

    @FindBy(xpath = "//div[@class='saved-list__item-details']//strong[text()='PART']/..")
    public WebElement displayedPartNumber;

    @FindBy(xpath = "//div[@class='saved-list__item-details']//div[@class='el--margin-right-4']")
    public List<WebElement> list_displayedPartNumberText;

    @FindBy(xpath = "//div[@class='saved-list__item-details']//strong[text()='PART']/..")
    public List<WebElement> displayedPartNumbers;

    @FindBy(xpath = "//*[@data-hds-tag='saved-list__description']")
    public List<WebElement> displayedProductDescription;

    @FindBy(xpath = "//div[@class='saved-list__item-details']//div[@class='saved-list__price el--center']/div/div[1]/span[1]")
    public List<WebElement> displayedPartPrices;

    @FindBy(xpath = "//strong[text()='Last Updated:']")
    public WebElement lastUpdatedText;
    
    @FindBy(xpath = "//span[@data-hds-tag='saved-list__last-updated-date']")
    public WebElement lastUpdatedDate; 

    @FindBy(xpath = "//*[text()='ADD TO CART']")
    List<WebElement> addToCart;

    @FindBy(xpath = "//*[contains(text(),'Recently Updated')]")
    public WebElement recentlyUpdatedText;

    @FindBy(xpath = "//div[@class='el--flex']//input[@name='partNumber_1']")
    public WebElement partNumberTextBox;

    @FindBy(xpath = "//div[@class='el--flex']//input[@name='quantity_1']")
    public WebElement quantityTextBox;

    @FindBy(xpath = "//*[contains(text(),'ADD TO LIST')]")
    public WebElement addToListButton;

    @FindBy(xpath = "//div[@class='pagination__info']")
    WebElement pageNumberBlock;
    
    @FindBy(xpath = "//a[contains(text(),'PRINT BIN LABELS')]")
    public WebElement printBinLabelsLink;
    
    @FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[contains(text(),'1-800-431-3000')]")
	public WebElement contactNumberOnBinLabel;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[contains(text(),'1-800-431-3000')]/following-sibling::div[1]")
	public	WebElement productDescriptionOnBinLabel;

	@FindBy(xpath = "//div[@class='pdfViewer']//div[@class='textLayer']/div[contains(text(),'1-800-431-3000')]/following-sibling::div[3]")
	public	WebElement hDSPartTextOnBinLabel;
    
    @FindBy(xpath = "//a[contains(text(),'Convert To Shared List')]")
    public WebElement convertToSharedListLink;
    
    @FindBy(xpath = "//a[contains(text(),'EMAIL LIST')]")
    public WebElement emailListLink;
    
    @FindBy(xpath = "//textarea[@id='emailSavedList_to']")
    WebElement emailToTextField;
    
    @FindBy(xpath = "//textarea[@id='emailSavedList_message']")
    WebElement messageTextFeild;
    
    @FindBy(xpath = "//div[contains(text(),'List e-mailed successfully')]")
    WebElement emailedSuccessfulMessageText;
    
    @FindBy(xpath = "//a[contains(text(),'Download Template')]")
    public WebElement downloadTemplateLink;
    
    @FindBy(xpath = "//a[contains(text(),'Upload Template')]")
    public WebElement uploadTemplateLink;
    
    @FindBy(xpath = "//a[contains(text(),'DELETE')]")
    public WebElement deleteLink;
    
    @FindBy(xpath = "//div[@class='close_text']")
    public WebElement closePopUp;
    
    @FindBy(xpath = "//a[@class='modal__close jq-close-modal']")
    public WebElement closeModalPopUp;
    
    @FindBy(xpath = "//h3[contains(text(),'Upload saved list')]")
    WebElement uploadSavedListText;
  
    @FindBy(xpath = "//div[contains(text(),'ve customized this item')]")
    public WebElement youHaveCustomizedThisItem;
     
    @FindBy(xpath = "//a[text()='Customize this item']")
    public WebElement customizeThisItem;
    
    
    @FindBy(xpath = "//div[@class='saved-list__part-number']")
    public List<WebElement> partNumbersDisplayed;

    
    public boolean isSavedListDetailPageTitle() {
        waitTool.waitForElement(driver, savedListsDetailPageTitle);
        return savedListsDetailPageTitle.isDisplayed();
    }

    public void selectOptionFromSortByDropdown(String option) {
        waitTool.waitForElement(driver, sortByDropDown);
        pageManager.common().scrolltoViewElement(sortByDropDown, driver);
        Select select = new Select(sortByDropDown);
        select.selectByVisibleText(option);
        System.out.println("selectedOptionSortByDropdown: " + option);
        //Availiable options: Recently Updated, Product Name A-Z, Product Name Z-A
    }


    public String getSaveListTotalNumberText() {
        waitTool.waitForElement(driver, totalItemsTextValue);
        pageManager.common().scrolltoViewElement(totalItemsTextValue, driver);
        return totalItemsTextValue.getText().trim();
    }

    public String getSaveListTotalNumberTextAfterRemoveFromList() {
        String saveListTotalOrMessage;
        try {
            totalItemsTextValue.isDisplayed();
            pageManager.common() .scrolltoViewElement(totalItemsTextValue, driver);
            saveListTotalOrMessage = totalItemsTextValue.getText().trim();
        } catch (Exception e) {
            saveListTotalOrMessage = noItemAddedMessage.getText();
        }
        return saveListTotalOrMessage;
    }

    public boolean isDisplayedSaveDetailListPartImage() {
        return saveListItemImages.get(0).isDisplayed();
    }

    public String getdisplayedPrice() {
		/*
		the method couldn't be applicable as the itemPrice property is dynamically
		 */
        return saveListItemPrices.get(0).getText();
    }

    public String getdisplayedPartNumber() {
        return displayedPartNumbers.get(0).getText();
    }

    /**
     * param partNumber
     * return true if added item in the saved list is displayed otherwise fals
     */
    public String displayedAddedItemInExistingList() {
        waitTool.waitForElement(driver, displayedPartNumbers.get(0));
        pageManager.common().scrolltoViewElement(displayedPartNumbers.get(0), driver);
        return displayedPartNumbers.get(0).getText();
    }


    public Boolean isAddedPartDisplayedInSavedList(String pnumber) {
        waitTool.waitForElement(driver, displayedPartNumber);
        Boolean flag = false;
        System.out.println("part number is " + pnumber);
        for (WebElement displayedPnumber : displayedPartNumbers) {
        	waitTool.waitForElement(driver, displayedPartNumber);
            System.out.println("displayedPnumber on saved list are " +displayedPnumber.getText());
        }

        for (WebElement displayedPnumber : displayedPartNumbers) {
            if (displayedPnumber.getText().contains(pnumber)) {
                flag = true;
                System.out.println("flag updated to true and "+ displayedPnumber.getText() +"equals " + pnumber);
                break;
            } else 
            {
                flag = false;
            }
        }
        System.out.println("flag is "+ flag);
        return flag;
    }

    public Boolean isAddedPartPricesDisplayedInSavedList(String price) {
        Boolean flag = true;
        System.out.println("price is " + price);
        for (WebElement displayedPprice : displayedPartPrices) {
            System.out.println(displayedPprice.getText());
        }

        for (WebElement displayedPprice : displayedPartPrices) {
            if (displayedPprice.getText().contains(price)) {
                flag = true;
                System.out.println("flag updated to true");
                break;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    public String getPartNumNewlyCreatedList() {
        pageManager.common().scrolltoViewElement(displayedPartNumbers.get(0), driver);
        return displayedPartNumbers.get(0).getText().substring(5);
    }

    public List<String> getPartNumbersFromSavedList() {
        List<String> all_SL_partNums = new ArrayList<>();
        List<String> all_SL_partNumbers = new ArrayList<>();

        for (int i = 0; i < displayedPartNumbers.size(); i++) {
            all_SL_partNums.add(displayedPartNumbers.get(i).getText());
        }
        for (String all_SL_partNum : all_SL_partNums) {
            all_SL_partNum = all_SL_partNum.substring(all_SL_partNum.indexOf(" "));
            all_SL_partNum = all_SL_partNum.trim();
            all_SL_partNumbers.add(all_SL_partNum);
        }
        return all_SL_partNumbers;
    }

    public void clickonFirstAddToCartbtn() throws Exception {
        int displayedShoppingCartProductCountBeforeAddToCart = pageManager.homePage().getShoppingCartProductCount();
        System.out.println("displayedShoppingCartProductCountBeforeAddToCart   " + displayedShoppingCartProductCountBeforeAddToCart);
        waitTool.waitForElement(driver, addToCart.get(0));
        pageManager.common().scrolltoViewElement(addToCart.get(0), driver);
        addToCart.get(0).click();
        waitTool.waitFor(driver, true);
        int displayedShoppingCartProductCountAfterAddToCart = pageManager.homePage().getShoppingCartProductCount();
        while (displayedShoppingCartProductCountAfterAddToCart == displayedShoppingCartProductCountBeforeAddToCart) {
            displayedShoppingCartProductCountAfterAddToCart = pageManager.homePage().getShoppingCartProductCount();
        }
        System.out.println("displayedShoppingCartProductCountAfterAddToCart is " + displayedShoppingCartProductCountAfterAddToCart);
        Assert.assertTrue(displayedShoppingCartProductCountBeforeAddToCart < displayedShoppingCartProductCountAfterAddToCart);
    }

    public void removeAllProducts() throws InterruptedException {
        if (removeFromListLinkText.size() > 0) {
            for (WebElement removeButton : removeFromListLinkText) {
                System.out.println("size is " + removeFromListLinkText.size());
                waitTool.waitForElement(driver, removeButton);
                pageManager.common().scrolltoViewElement(removeButton, driver);
                removeButton.click();
                waitTool.waitForAlert(driver);
                pageManager.common().acceptPopupMessageBox(driver);
                waitTool.waitFor(driver, true);
                pageManager.common().refresh();
                waitTool.waitForElement(driver, savedListsDetailPageTitle);
            }
        } else {
            System.out.println("List has 0 products");
        }
    }


    /**
     * Method to click on the Remove from List Link
     */
    public void clickRemoveFromListLinkText() {
        removeFromListLinkText.get(0).click();
    }

    public void VerifyTheListGetSortedBy(String option) {
        if (displayedProductDescription.size() > 1) {
            ArrayList<String> defaultList = new ArrayList<>();
            for (WebElement beforeSort : displayedProductDescription)

            {
                defaultList.add(beforeSort.getText());
                System.out.println("obtainedList: " + defaultList);
            }
            selectOptionFromSortByDropdown(option);

            ArrayList<String> sortedList = new ArrayList<>();
            for (WebElement afterSort : displayedProductDescription)

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

    public Boolean isShowXXPerPageTextDisplayed() {
        waitTool.waitForElement(driver, showXXPerPageText);
     //   pageManager.common().scrolltoViewElement(showXXPerPageText, driver);
        return showXXPerPageText.isDisplayed();
    }

    public void selectListNameAToZFromSortByDropdown() {
        waitTool.waitForElement(driver, sortByDropDown);
        pageManager.common().scrolltoViewElement(sortByDropDown, driver);
        Select select = new Select(sortByDropDown);
        select.selectByVisibleText("Product Name A-Z");
    }

    public Boolean isListNameDisplayedInAscendingOrder() {
        Boolean sorted = true;
        int i = 0;
        String[] listNameText = new String[displayedListNames.size()];
        for (WebElement DisplayedListName : displayedListNames) {
            listNameText[i] = DisplayedListName.getText();
            System.out.println("listNameText" + i + listNameText[i]);
            i++;
        }
        List<String> listNames = Arrays.asList(listNameText);
        for (int j = 0; i < listNames.size() - 1; i++) {
            System.out.println("listName " + j + listNames.get(j));

            if (listNames.get(j + 1).compareTo(listNames.get(j)) < 0) {
                sorted = false;
                break;
            }

        }

        return sorted;
    }

    public int[] getAllOptionsFromShowPerPageDropdown() {
        Select option = new Select(showPerPageDropdown);
        List<WebElement> dropdownValues = option.getOptions();
        int i = 0;
        int[] optionsText = new int[dropdownValues.size()];
        for (WebElement dropdownValue : dropdownValues) {
            optionsText[i] = Integer.parseInt(dropdownValue.getText());
            System.out.println("optionsText" + i + optionsText[i]);
            i++;
        }

        System.out.println("actaul valuesss" + Arrays.toString(optionsText));
        return optionsText;
    }


    public String getDefaultValueFromShowPerPageDropdown() {
        waitTool.waitForElement(driver, showPerPageDropdown);
        pageManager.common().scrolltoViewElement(showPerPageDropdown, driver);
        Select option = new Select(showPerPageDropdown);
        return option.getFirstSelectedOption().getText();
    }


    public void acceptPopUp() {
        pageManager.common().acceptPopupMessageBox(driver);
    }


    public void cancelPopUp() {
        pageManager.common().cancelPopupMessageBox(driver);
    }

    public void addProductFromAddPartToListSection(String pnumber, String quantity) {
        partNumberTextBox.clear();
        partNumberTextBox.sendKeys(pnumber);
        quantityTextBox.clear();
        quantityTextBox.sendKeys(quantity);
        waitTool.waitFor(driver,true);
		/*
		Added take screenshot to make driver wait the part number popup to disappear
		 */
		pageManager.captureScreenShot().TakeScreenShot("addPartsToYourCart.png");
        addToListButton.click();
        waitTool.waitFor(driver, true);
    }

    public void addPartsToListIfListIsEmpty() throws Exception {

        try {
            addPartsToYourListText.isDisplayed();
            usersList = pageManager.dBCon().loadDataFromExcel("AddFirstPartToList", "SavedList");
            addProductFromAddPartToListSection(usersList.get(0).getPartNumberAddToList(), usersList.get(0).getQuantityAddToList());
            usersList = pageManager.dBCon().loadDataFromExcel("AddSecondPartToList", "SavedList");
            addProductFromAddPartToListSection(usersList.get(0).getPartNumberAddToList(), usersList.get(0).getQuantityAddToList());
        } catch (Exception e) {
            System.out.println("List has more than 0 products");
        }
    }

    public void verifyPaginationWhenOptionIsSelectedFromDropdown(String optionValue) {
        int optionIntegerValue = Integer.parseInt(optionValue);
        int expectedNumberofPages;
        int numberOfItemsTextDisplayed = Integer.parseInt(totalItemsTextValue.getText());
        if (numberOfItemsTextDisplayed == 0) {
            System.out.println("There are 0 item dispalyed on saved list details page");
        } else {
            Select option = new Select(showPerPageDropdown);
            option.selectByVisibleText(optionValue);
            if (numberOfItemsTextDisplayed > optionIntegerValue) {
                expectedNumberofPages = numberOfItemsTextDisplayed / optionIntegerValue + 1;
            } else {
                expectedNumberofPages = 1;
            }
            System.out.println("expectedNumberofPages is " + expectedNumberofPages);
            int actualNumberofPages = numberOfPages();
            Assert.assertEquals(actualNumberofPages, expectedNumberofPages);
        }
    }

    @FindBy (xpath = "//div[@class='pagination__info']/input")
	WebElement paginationInfo;
    
    @FindBy (xpath = "//div[@class='pagination__info']/following-sibling::a")
	WebElement paginationForward;

	@FindBy (xpath = "//div[@class='pagination__info']/preceding-sibling::a")
	WebElement paginationBackWard;
	
	public void selectValueFromShowPerPageDropdown(String optionValue){
		Select option = new Select(showPerPageDropdown);
        option.selectByVisibleText(optionValue);
	}
	
    public void verifyPaginationWhenOptionIsSelectedFromDropdownInNextPage(String optionValue) throws Exception {
    	int currentPage=0;
    	int optionIntegerValue = Integer.parseInt(optionValue);
    	System.out.println("optionIntegerValue is " + optionIntegerValue);
    	
    	int numberOfItemsTextDisplayed = Integer.parseInt(totalItemsTextValue.getText());
        System.out.println("numberOfItemsTextDisplayed is " + numberOfItemsTextDisplayed);
        if (numberOfItemsTextDisplayed == 0) {
            System.out.println("There are 0 item dispalyed on saved list details page");
        } else if(numberOfItemsTextDisplayed>24) {
        	waitTool.waitForElement(driver, paginationForward);
			paginationForward.click();
			System.out.println("Clicked on Right Pagination");
			
            Select option = new Select(showPerPageDropdown);
            option.selectByVisibleText(optionValue);
            
            if (optionIntegerValue > numberOfItemsTextDisplayed) {
                System.out.println("displayedItems.size() is " + displayedItems.size());
                Assert.assertTrue(displayedItems.size() == numberOfItemsTextDisplayed);
                
                Assert.assertFalse(pageManager.common().isElementPresent(paginationInfo));
                System.out.println("Initial Page as Pagination not displayed");
                
            } else {
                System.out.println("displayedItems.size() is " + displayedItems.size());
                Assert.assertTrue(displayedItems.size() == optionIntegerValue);
                pageManager.common().scrolltoViewElement(paginationInfo, driver);
                currentPage=Integer.parseInt(paginationInfo.getAttribute("value"));
                System.out.println("Current Page " + currentPage);
                Assert.assertEquals(currentPage, 1);
            }
            selectValueFromShowPerPageDropdown("24");   
      }
       
}
		

	
    public int numberOfPages() {
        try {
            String totalPage = pageNumberBlock.getText();
            totalPage = totalPage.substring(totalPage.lastIndexOf(" "));
            totalPage = totalPage.trim();
            int actualNumberofPages = Integer.parseInt(totalPage);
            System.out.println("actualNumberofPages is " + actualNumberofPages);
            return actualNumberofPages;
        } catch (Exception e) {
            System.out.println("there is no pagination");
            return 1;
        }
    }

    public void verifyNumberOFItemDisplayed(String optionValue) {
        int numberOfItemsTextDisplayed = Integer.parseInt(totalItemsTextValue.getText());
        System.out.println("numberOfItemsTextDisplayed is " + numberOfItemsTextDisplayed);
        if (numberOfItemsTextDisplayed == 0) {
            System.out.println("There are 0 item dispalyed on saved list details page");
        } else {
            Select option = new Select(showPerPageDropdown);
            option.selectByVisibleText(optionValue);
            int optionIntegerValue = Integer.parseInt(optionValue);
            System.out.println("optionIntegerValue is " + optionIntegerValue);
            if (optionIntegerValue > numberOfItemsTextDisplayed) {
                System.out.println("displayedItems.size() is " + displayedItems.size());
                Assert.assertTrue(displayedItems.size() == numberOfItemsTextDisplayed);
            } else {
                System.out.println("displayedItems.size() is " + displayedItems.size());
                Assert.assertTrue(displayedItems.size() == optionIntegerValue);

            }
        }
    }
    
    /*public void verifyotesOnClickEditNotesLink(){
    	String enterNotesText = "Recently Updated List";
    	editNotesLink.click();
    	waitTool.waitForElement(driver, notesTextArea);
    	.scrolltoViewElement(notesTextArea, driver);
    	notesTextArea.clear();
    	notesTextArea.sendKeys(enterNotesText);
    	notesTextAreaUpdateButton.click();
    	String updatedText = updatedNotesText.getText();
    	Assert.assertEquals(updatedText, enterNotesText);
    }*/
    
    public void clickEditNotesLink(){
    	editNotesLink.click();
    }
    
    public void verifyNotesOnClickEditNotesLink(){
    	String enterNotesText = "Recently Updated List";
    	
    	waitTool.waitForElement(driver, notesTextArea);
        pageManager.common().scrolltoViewElement(notesTextArea, driver);
    	
    	notesTextArea.clear();
    	notesTextArea.sendKeys(enterNotesText);
    	notesTextAreaUpdateButton.click();
    	clickClosePopUp();
    	String updatedText = updatedNotesText.getText();
    	Assert.assertEquals(updatedText, enterNotesText);
    	
    }
    
    public void clickClosePopUp(){
    	waitTool.waitForElement(driver, closePopUp);
        pageManager.common().scrolltoViewElement(closePopUp, driver);
    	closePopUp.click();
    }
    
    public void clickAddListToCartButton(){
    	addListToCartButton.click();
    }
    
    public String getNoOfItemsInList(){
    	return noOfItemsInList.getText();
    }
    
    public void clickPrintBinLabelsLink(){
    	printBinLabelsLink.click();
        pageManager.common().moveToNewWindow(driver);
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

    public void navigateBackToMainWindowFromPrintLabel(){
        pageManager.common().closecurrentBrowser(driver);
        pageManager.common().moveToNewWindow(driver);
    	driver.navigate().refresh();
    }

    public void clickOnConvertToSharedListLink(){
    	waitTool.waitForElement(driver, convertToSharedListLink);
    	convertToSharedListLink.click();
        pageManager.common().acceptPopupMessageBox(driver);
    }
    
    public void clickOnEmailListLink(){
        pageManager.common().refresh();
    	waitTool.waitForElement(driver, emailListLink);
        pageManager.common().scrolltoViewElement(emailListLink, driver);
    	emailListLink.click();
    	
    }
    
    public void enterEmailToTextFeild(String email){
		emailToTextField.clear();
		emailToTextField.sendKeys(email);	
	}

	public void enterMessageTextFeild(String msg){
		messageTextFeild.clear();
		messageTextFeild.sendKeys(msg);	
	}
    
    public void fillOutEmailFields(String email,String message) {
    	enterEmailToTextFeild(email);
		enterMessageTextFeild(message);
		System.out.println(email +"   "+ message);
		pageManager.eMailPage().clickOnSendButton();
	}
    
    public Boolean isDisplayedEmailedSuccessfulMessage()
	{
    	waitTool.waitForElement(driver, emailedSuccessfulMessageText);
		return pageManager.common().isElementPresent(emailedSuccessfulMessageText);
	}
    
    public void closeModalPopUp(){
    	waitTool.waitForElement(driver, closeModalPopUp);
        pageManager.common().scrolltoViewElement(closeModalPopUp, driver);
    	closeModalPopUp.click();
    }
    
    public void clickDownLoadTemplateLink() {
        pageManager.common().refresh();
    	waitTool.waitForElement(driver, downloadTemplateLink);
    	downloadTemplateLink.click();
	}
    
    public void clickOnUploadTemplateLink(){
    	waitTool.waitForElement(driver, uploadTemplateLink);
    	uploadTemplateLink.click();
    }
    
    public Boolean isDisplayedUploadSavedListText()
	{
    	waitTool.waitForElement(driver, uploadSavedListText);
		return pageManager.common().isElementPresent(uploadSavedListText);
	}
    
    public void clickOnDeleteLink(){
        pageManager.common().refresh();
    	waitTool.waitForElement(driver, deleteLink);
        pageManager.common().scrolltoViewElement(deleteLink, driver);
    	deleteLink.getSize();
    	deleteLink.click();
    }
    

}