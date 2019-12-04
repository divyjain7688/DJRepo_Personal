package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.beans.UsersListBean;
import com.selenium.ebiz.tools.PageManager;
import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.ArrayList;

public class CustomizeConfiguratorModal {


        private WebDriver driver;
        private WaitTool waitTool;
        private PageManager pageManager;
        private ArrayList<UsersListBean> usersList;

        public CustomizeConfiguratorModal(WebDriver driver) {
            this.driver = driver;
            this.waitTool = new WaitTool();
            PageFactory.initElements(driver, this);
            this.pageManager = new PageManager(driver);
        }
       
      
        @FindBy(xpath="//button[@class='btn btn--full btn--large btn--hollow']")
        WebElement quickCheckoutButton;
        
        //Customize Cut Blinds web elements
    @FindBy(xpath = "//div[@id='ProductCustomization']/div/p/a/img")
    //id="ctl00_ContentPlaceHolder_b_pc_imggfp"
    public WebElement getAdobeFlashPlayer;
    @FindBy(xpath = "//*[@id='hds_container']")
    WebElement peachtreeContainer;
    @FindBy(xpath = "//*[text()='FLAT OR ASSEMBLED:']/../../td[2]/input")
    WebElement flatOrAssembledTextBox;
    @FindBy(xpath = "//*[text()='LABEL FORMAT:']/../../td[2]/input")
    WebElement labelFormatTextBox;
    @FindBy(xpath = "//*[text()='COLOR:']/../../td[2]/input")
    WebElement colorTextBox;
    @FindBy(xpath = "//*[text()='STYLE (CASE ?):']/../../td[2]/input")
    WebElement styleTextBox;
    @FindBy(xpath = "//*[text()='IMPRINT LINE 1:']/../../td[2]/input")
    WebElement imprintLine1TextBox;
    @FindBy(xpath = "//*[text()='IMPRINT LINE 2:']/../../td[2]/input")
    WebElement imprintLine2TextBox;
    @FindBy(xpath = "//*[text()='IMPRINT LINE 3:']/../../td[2]/input")
    WebElement imprintLine3TextBox;
    @FindBy(xpath = "//*[text()='IMPRINT LINE 4:']/../../td[2]/input")
    WebElement imprintLine4TextBox;
    @FindBy(xpath = "//*[text()='IMPRINT LINE 5:']/../../td[2]/input")
    WebElement imprintLine5TextBox;
    @FindBy(xpath = "//*[text()='IMPRINT LINE 6:']/../../td[2]/input")
    WebElement imprintLine6TextBox;
    @FindBy(xpath = "//*[text()='IMPRINT LINE 7:']/../../td[2]/input")
    WebElement imprintLine7TextBox;
    @FindBy(xpath = "//*[text()='COMMENTS:']/../../td[2]/input")
    WebElement commentsTextBox;
    @FindBy(xpath = "//*[@title='Save']")
    //"//div[@class='save']")
            WebElement plusCartButton;
    @FindBy(xpath = "//input[@value='Approve']")
    WebElement approveButton;
    @FindBy(xpath = "//div[@class='modal modal--visible']")
    WebElement pTConfiguratorModalWindow;
    @FindBy(xpath = "//*[@class='widget-wrapper__header']//*[text()='Customize This Item']")
    WebElement getpTConfiguratorModalWindowTitle;
    @FindBy(xpath = "//iframe[@id='peachTreeIFrame']")
    WebElement customizeThisItemIFrame;
    @FindBy(xpath = "//div[@id='flashcontent']")
    WebElement flashContent;
    @FindBy(xpath = "//iframe[@id='peachTreeIFrame']")
    WebElement peachTreeFrame;
    @FindBy(xpath = "//*[@class='modal__inner']")
    WebElement customizeContainer;
    @FindBy(xpath = "//*[@class='modal__close jq-close-modal']")
    WebElement closeBtnOnCustomizeContainer;
    @FindBy(id = "BLIND_SIZE_TYPE")
    WebElement selectMeasurementOf;

    @FindBy(id = "BLIND_WIDTH")
    WebElement selectBlindsWidth;

    @FindBy(id = "BLIND_WIDTH_INCR")
    WebElement selectBlindsWidthIncrement;

    @FindBy(xpath="//*[@id='BLIND_LENGTH_INCR']")
    WebElement selectBlindsLengthIncrement;
  
    //Customize Cut Blinds web elements
    @FindBy(id = "BLIND_LENGTH")
    WebElement selectBlindsLength;
    
    @FindBy(xpath = "//select[@data-hds-tag='customize-product__select_BLIND_LENGTH_INCR']")
    WebElement selectBlindLengthIncrement;

    @FindBy(xpath = "//*[@class='customize__buttons']")
    WebElement customizeBtns;

    @FindBy(xpath = "//*[text()='ADD TO CART']")
    WebElement addToCart;
    
	@FindBy(xpath = "//*[text()='ADD TO LIST']")
    WebElement addToList;
	
	@FindBy(xpath = "//div[@class='save']")
    public WebElement updateButton;
	
	@FindBy(xpath = "//input[@placeholder='Optional Placeholder']")
    WebElement notesTextBox;
	
    //@FindBy(xpath = "//*[text()='Update']")
	@FindBy(id = "Update_CustomBlinds")
    public WebElement updateBtnSCP;

    @FindBy(xpath = "//*[@class='btn btn--full btn--large btn--hollow']")
    WebElement quickcheckoutBtn;


    public void switchToIframeAndFillTheForm(String flat, String label, String color, String style,
                                             String imprintLine1, String imprintLine2, String imprintLine3, String imprintLine4,
                                             String imprintLine5, String imprintLine6, String imprintLine7, String comments) throws Exception {
        driver.switchTo().defaultContent();
        System.out.println("driver switch to default content");
        //  pageManager.switchTool().switchframe(driver, null, customizeThisItemIFrame);
        waitTool.waitForFrameToBeAvailiableAndSwithTo(driver, customizeThisItemIFrame);
        // driver.switchTo().frame(customizeThisItemIFrame);
        System.out.println("waiting For Frame To Be Availiable And Swith To it");
        // isPTConfiguratorModalWindowDisplayed();
        pageManager.common().scrolltoViewElement(flatOrAssembledTextBox, driver);
        System.out.println("Scrolling to the flat or assembled text box");
        //flatOrAssembledTextBox.getSize();
        flatOrAssembledTextBox.sendKeys(flat);
        System.out.println("values added in flatOrAssembledTextBox");
        labelFormatTextBox.sendKeys(label);
        colorTextBox.sendKeys(color);
        styleTextBox.sendKeys(style);
        imprintLine1TextBox.sendKeys(imprintLine1);
        imprintLine2TextBox.sendKeys(imprintLine2);
        imprintLine3TextBox.sendKeys(imprintLine3);
        imprintLine4TextBox.sendKeys(imprintLine4);
        imprintLine5TextBox.sendKeys(imprintLine5);
        imprintLine6TextBox.sendKeys(imprintLine6);
        imprintLine7TextBox.sendKeys(imprintLine7);
        commentsTextBox.sendKeys(comments);
        System.out.println("Enter the value to the Comments");


    }

    public void switchToIframeAndFillTheFormSimple(
            String imprintLine1, String imprintLine2, String imprintLine3, String imprintLine4, String comments) throws Exception {
        driver.switchTo().defaultContent();
        System.out.println("driver switch to default content");


        waitTool.waitForFrameToBeAvailiableAndSwithTo(driver, customizeThisItemIFrame);

        System.out.println("waiting For Frame To Be Availiable And Swith To it");

        //   waitTool.waitForElement(driver,peachtreeContainer);

        waitTool.waitForElement(driver, imprintLine1TextBox);
        pageManager.common().scrolltoViewElement(imprintLine1TextBox, driver);
        System.out.println("Scrolling to the imprintLine1TextBox text box");

        imprintLine1TextBox.sendKeys(imprintLine1);
        imprintLine2TextBox.sendKeys(imprintLine2);
        imprintLine3TextBox.sendKeys(imprintLine3);
       // imprintLine4TextBox.sendKeys(imprintLine4);
        commentsTextBox.sendKeys(comments);
        System.out.println("Enter the value to the Comments");


    }


    public void customizeWithPeachTreeProduct() throws Exception {
        usersList = pageManager.dBCon().loadDataFromExcel("customizePeachTreeProductAndAddToCart", "CustomizePeachTreeItem");
        switchToIframeAndFillTheForm(
                usersList.get(0).getFlatOrAssemble(),
                usersList.get(0).getLabelFormat(),
                usersList.get(0).getColor(), usersList.get(0).getStyle(), usersList.get(0).getImprintLine1(),
                usersList.get(0).getImprintLine2(), usersList.get(0).getImprintLine3(), usersList.get(0).getImprintLine4(),
                usersList.get(0).getImprintLine5(), usersList.get(0).getImprintLine6(), usersList.get(0).getImprintLine7(),
                usersList.get(0).getComments());

        waitTool.waitForElement(driver, plusCartButton);
        try {
            plusCartButton.click();
            System.out.println("Clicked Cart+ ");
            //wait.until(ExpectedConditions.elementToBeClickable(approveButton));
            isApprovedDisplayed();
            approveButton.click();
            System.out.println("Clicked on Approve button");
        } catch (Exception e) {
            plusCartButton.click();
            System.out.println("Retry Clicked Cart+ ");
            //wait.until(ExpectedConditions.elementToBeClickable(approveButton));
            isApprovedDisplayed();
            approveButton.click();
            System.out.println("Retry Clicked on Approve button");

        }
    }

    public void customizeWithPeachTreeProductSimple() throws Exception {
        waitTool.waitFor(driver, true);
        usersList = pageManager.dBCon().loadDataFromExcel("customizePeachTreeProductAndAddToCart", "CustomizePeachTreeItem");
        switchToIframeAndFillTheFormSimple(
                usersList.get(0).getImprintLine1(),
                usersList.get(0).getImprintLine2(),
                usersList.get(0).getImprintLine3(),
                usersList.get(0).getImprintLine4(),
                usersList.get(0).getComments());

        waitTool.waitForElement(driver, plusCartButton);
        try {
            plusCartButton.click();
            System.out.println("Clicked Cart+ ");
            //wait.until(ExpectedConditions.elementToBeClickable(approveButton));
            isApprovedDisplayed();
            approveButton.click();
            System.out.println("Clicked on Approve button");
        } catch (Exception e) {
            plusCartButton.click();
            System.out.println("Retry Clicked Cart+ ");
            //wait.until(ExpectedConditions.elementToBeClickable(approveButton));
            isApprovedDisplayed();
            approveButton.click();
            System.out.println("Retry Clicked on Approve button");

        }
    }

    public Boolean isApprovedDisplayed() {
        waitTool.waitForElement(driver, approveButton);
        return approveButton.isDisplayed();
    }


    public Boolean isPTConfiguratorModalWindowDisplayed() {
        waitTool.waitForElement(driver, getpTConfiguratorModalWindowTitle);
        System.out.println("Waiting for the peachtree modal window title to be displayed");
        return getpTConfiguratorModalWindowTitle.isDisplayed();
    }


    public boolean isflashContentDispalyed() {
        waitTool.waitForElement(driver, flashContent);
        pageManager.common().scrolltoViewElement(flashContent, driver);
        return pageManager.common().isElementPresent(flashContent);
    }

    public void clickOngetAdobeFlashPlayer() throws InterruptedException, AWTException {
        waitTool.waitForFrameToBeAvailiableAndSwithTo(driver, peachTreeFrame);
        waitTool.waitForElement(driver, getAdobeFlashPlayer);
        pageManager.common() .scrolltoViewElement(getAdobeFlashPlayer, driver);
        getAdobeFlashPlayer.click();
        pageManager.common().clickOnTabButton(driver);
        pageManager.common().clickOnEnterButton(driver);

    }

    public void customizeBlindsTypeProduct(String measurementOF, String width, String wigthIncrement, String length) {

        waitTool.waitForElement(driver, customizeContainer);
        waitTool.waitForElement(driver, selectMeasurementOf);
        pageManager.common().selectByVisibleTextFromDropdown(selectMeasurementOf, measurementOF);
        waitTool.waitForElement(driver, selectBlindsWidth);
        pageManager.common().selectByVisibleTextFromDropdown(selectBlindsWidth, width);
        waitTool.waitForElement(driver, selectBlindsWidthIncrement);
        pageManager.common().selectByVisibleTextFromDropdown(selectBlindsWidthIncrement, wigthIncrement);
        waitTool.waitForElement(driver, selectBlindsLength);
        pageManager.common().selectByVisibleTextFromDropdown(selectBlindsLength, length);
        waitTool.waitFor(driver, true);
        pageManager.captureScreenShot().TakeScreenShot("sccp.png");
        pageManager.common().scrolltoViewElement(customizeBtns, driver);

    }
    
    public void customizeBlindTypeProduct(String measurementOF, String width, String wigthIncrement, String length, String lengthIncrement) {

        waitTool.waitForElement(driver, customizeContainer);
        waitTool.waitForElement(driver, selectMeasurementOf);
        pageManager.common().selectByVisibleTextFromDropdown(selectMeasurementOf, measurementOF);
        waitTool.waitForElement(driver, selectBlindsWidth);
        pageManager.common().selectByVisibleTextFromDropdown(selectBlindsWidth, width);
        waitTool.waitForElement(driver, selectBlindsWidthIncrement);
        pageManager.common().selectByVisibleTextFromDropdown(selectBlindsWidthIncrement, wigthIncrement);
        waitTool.waitForElement(driver, selectBlindsLength);
        pageManager.common().selectByVisibleTextFromDropdown(selectBlindsLength, length);
        waitTool.waitForElement(driver, selectBlindLengthIncrement);
        pageManager.common().selectByVisibleTextFromDropdown(selectBlindLengthIncrement, lengthIncrement);
        waitTool.waitFor(driver, true);
        pageManager.captureScreenShot().TakeScreenShot("sccp.png");
        pageManager.common().scrolltoViewElement(customizeBtns, driver);

    }

    public void customizeAndAddToCartItemOnPDD(String measurementOF, String width, String wigthIncrement, String length)
    {
        customizeBlindsTypeProduct(measurementOF, width, wigthIncrement, length);
        waitTool.waitForElement(driver, addToCart);
        addToCart.click();
    }

    public void customizeAndClickQuickCheckout(String measurementOF, String width, String wigthIncrement, String length) 
    {
        customizeBlindsTypeProduct(measurementOF, width, wigthIncrement, length);
        waitTool.waitForElement(driver, quickcheckoutBtn);
        quickcheckoutBtn.click();
    }

    //quickcheckoutBtn

    public void customizeAndUpdateItemOnShoppingCart(String measurementOF, String width, String wigthIncrement, String length, String lengthIncrement) {
        customizeBlindTypeProduct(measurementOF, width, wigthIncrement, length, lengthIncrement);
        waitTool.waitFor(driver, true);
     //   .scrolltoViewElement(updateBtnSCP, driver);
        updateBtnSCP.getSize();
        updateBtnSCP.click();
        waitTool.waitFor(driver, true);
    }

    public void clickOnUpdateBtnSCP()
    {
    	waitTool.waitElementToBeClickable(driver, updateBtnSCP);
    	updateBtnSCP.click();;
    }
        public Boolean isQuickCheckoutButtonDisplayed()
        {
        	waitTool.waitForElement(driver, quickCheckoutButton);
        	return quickCheckoutButton.isDisplayed();
        }

        public void customizeProduct() {
        	waitTool.waitForElement(driver, customizeContainer);
            waitTool.waitForElement(driver, selectMeasurementOf);
            pageManager.common().selectFirstValueFromDropdown(selectMeasurementOf);
            waitTool.waitForElement(driver, selectBlindsWidth);
            pageManager.common().selectFirstValueFromDropdown(selectBlindsWidth);
            waitTool.waitForElement(driver, selectBlindsWidthIncrement);
            pageManager.common().selectFirstValueFromDropdown(selectBlindsWidthIncrement);
            waitTool.waitForElement(driver, selectBlindsLength);
            pageManager.common().selectFirstValueFromDropdown(selectBlindsLength);
            notesTextBox.sendKeys("test");
            try
            {
             waitTool.waitForElement(driver, selectBlindsLengthIncrement);
             pageManager.common().selectFirstValueFromDropdown(selectBlindsLengthIncrement);
            }
            catch(Exception e)
            {
            	System.out.println("selectBlindsLengthIncrement is not displayed " + e);
            }
            waitTool.waitFor(driver, true);

        }
        
        public void clickOnAddToList()
        {
            pageManager.common().scrolltoViewElement(addToList, driver);
            waitTool.waitForElement(driver, addToList);
            addToList.click();
        }
        public void clickOnUpdate()
        {
        	/*driver.switchTo().defaultContent();
            System.out.println("driver switch to default content");
            waitTool.waitForFrameToBeAvailiableAndSwithTo(driver, customizeThisItemIFrame);
          System.out.println("waiting For Frame To Be Availiable And Swith To it");*/  
            waitTool.waitForElement(driver, updateButton);
            pageManager.common().scrolltoViewElement(updateButton, driver);
            updateButton.click();
            approveButton.click();
        }
        
}
