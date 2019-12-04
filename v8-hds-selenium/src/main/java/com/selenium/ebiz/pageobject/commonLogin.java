package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class commonLogin  {

    private WebDriver driver;
    private WaitTool waitTool;
    private PageManager pageManager;
    private ConfigFileRead configread;
    public String environmentValue;
    public String baseUrl;
    protected PropertyLoader propertyRead;
    public Logger Log = Logger.getLogger(commonLogin.class.getName());

    /*
    *** add new methods to the class if getEnv value is needed
     */

    public commonLogin(WebDriver driver)
    {
        this.driver = driver;
        this.waitTool = new WaitTool();
        PageFactory.initElements(driver, this);
        this.pageManager=new PageManager(driver);
        this.configread=new ConfigFileRead();
    }

    public void getEnvValue() throws Exception {
        propertyRead = new PropertyLoader();
        baseUrl = propertyRead.getProperty("site.url");

        String[] envArray = null;
        envArray = baseUrl.substring(8).split("\\.");
        environmentValue = envArray[0];
        System.out.println("Display Environment :"+ environmentValue);
    }


    public void LoginToHDS(String username, String password) throws Exception {
        getEnvValue();
        if(
              //  environmentValue.equals("dev1")||
                     environmentValue.equals("dev2")|| environmentValue.equals("dev3")) {
            pageManager.loginPage().loginToHDS_V8(RandomAccountSelect.devusers.pop(), password);
            //   pageManager.loginPage().closeShopNowOnFinalDaysToSavePopup.click();
        }

        else {
            pageManager.loginPage().loginToHDS_V8(username, password);
            System.out.println("Username:" + username);
        }

         pageManager.homePage().scrollToWelcomeNote();
         Log.info("Display welcome message   " + pageManager.homePage().welcomeTextLoggedUser.getText());
         Assert.assertTrue(pageManager.homePage().welcomeTextLoggedUser.getText().contains("Hi"));
    }

    /*
    Login method without the Welcome message validation
     */

    public void LoginToHDSFromAnyPage(String username, String password) throws Exception {
        getEnvValue();
        if (environmentValue.equals("dev1") || environmentValue.equals("dev2") || environmentValue.equals("dev3")) {
            pageManager.loginPage().loginToHDS_V8(RandomAccountSelect.devusers.pop(), password);
            //   pageManager.loginPage().closeShopNowOnFinalDaysToSavePopup.click();

        } else {
            pageManager.loginPage().loginToHDS_V8(username, password);
            System.out.println("Username:" + username);
        }
        pageManager.loginPage().loggedAccountNumberText.isDisplayed();

    }

    public void LogInToHDSAsSuma(String username, String password) throws Exception {
    	System.out.println("Username:" + username);
    	pageManager.loginPage().loginToHDS_V8(username, password);
        
       /* pageManager.homePage().scrollToWelcomeNote();
        Log.info("Display welcome message   " + pageManager.homePage().welcomeTextLoggedUser.getText());

        Assert.assertTrue(pageManager.homePage().welcomeTextLoggedUser.getText().contains("Hi"));*/

    }

    public void signIn(String username, String password) throws Exception {
        getEnvValue();

        if (environmentValue.equals("dev1") || environmentValue.equals("dev2") || environmentValue.equals("dev3")) {
            pageManager.signInOrRegisterPage().loginToFromBrowsePage(RandomAccountSelect.devusers.pop(), configread.getPassword());
        } else {
            pageManager.signInOrRegisterPage().loginToFromBrowsePage(username, configread.getPassword());
            System.out.println("Username:" + username);
        }
    }

    public void signInToApplicationWithIncorrectPassword(String username,String pwd) throws Exception
    {
        getEnvValue();
        if(environmentValue.equals("dev1")||environmentValue.equals("dev2")||environmentValue.equals("dev3")) {
            pageManager.loginPage().loginToHDSWithIncorrectPassword(RandomAccountSelect.devusers.pop(), pwd);

        } else {
            pageManager.loginPage().loginToHDSWithIncorrectPassword(username, pwd);
            System.out.println("Username:" + username);
        }

        Assert.assertTrue(pageManager.loginPage().invalidUserNameOrPasswordMessageTextIsDisplayed());
    }

    public void navigateToShopAllFromPopUpWindow() throws Exception {
        getEnvValue();
        if(environmentValue.equals("beta")) {
            waitTool.waitFor(driver,true);
            waitTool.waitForElement(driver,pageManager.loginPage().shopNowOnFinalDaysToSavePopup);
            waitTool.waitForElement(driver,pageManager.loginPage().closeShopNowOnFinalDaysToSavePopup);
            pageManager.loginPage().closeShopNowOnFinalDaysToSavePopup.click();
            System.out.println("Popup closed");
           /* waitTool.waitForInvisibilityOfElement(driver,pageManager.loginPage().shopNowOnFinalDaysToSavePopup);*/
            waitTool.waitFor(driver,true);

        } else {
            System.out.println("No Popup to be closed");

        //boolean bool=false;

            //	Assert.assertFalse(shopNowOnFinalDaysToSavePopup.isDisplayed());
            //	waitTool.waitForElement(driver,headerRegisterOrSignInLinkText);
            //	bool= headerRegisterOrSignInLinkText.isDisplayed();
            //	System.out.println("bool is.." + bool );

        }
        //return bool;

    }
}
