
package com.selenium.ebiz.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.sikuli.script.App;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonFunctions {	

	static int counter=0;
	static Logger log = Logger.getLogger(CommonFunctions.class.getName());

	static char specialCharacters[] = { '!', '@', '#', '$', '%', '^', '&', '*',
		'(', ')', '?', '/', '"', '|', '{', '[', '<', '>', ';', '`', ',',
		'_', '-' };

	/**
	 * Retrieve popup text message.
	 * 
	 * @param WebDriver
	 *            driver
	 * @return
	 */
	public static String getPopupMessage(final WebDriver driver) {
		String message = null;
		try {
			Alert alert = driver.switchTo().alert();

			message = alert.getText();
			//alert.accept();
		} catch (Exception e) {
			// Sometimes the text exist, but not the accept button.
			// this means the popup wasn't displayed and therefore
			// really never existed.
			//
			message = null;
		}
		System.out.println("message"+message);
		return message;
	}
	
	
	
	/**
	 * Get drop down options
	 * 
	 * @param driver
	 * @param 
	 * @param value
	 * 
	 */
	
	public static List<WebElement> selectDropdownOptions(WebDriver driver, WebElement element){
		return new Select (element).getOptions();
	}
	
	
	public static String acceptPopupMessageBox(final WebDriver driver) {
		String message = null;
        WaitTool.waitForAlert(driver);
		try {
			Alert alert = driver.switchTo().alert();

			message = alert.getText();
			alert.accept();
		} catch (Exception e) {
			// Sometimes the text exist, but not the accept button.
			// this means the popup wasn't displayed and therefore
			// really never existed.
			//
			message = null;
		}

		return message;
	}
	
	public static void selectSearchDropdown1(WebElement element, String value){ 
		System.out.println("Enter Element value"+value);
		Select select = new Select(element);
		select.selectByValue(value); 
	}


	public static String cancelPopupMessageBox(final WebDriver driver) {
		String message = null;
		try {
			Alert alert = driver.switchTo().alert();

			message = alert.getText();
			alert.dismiss();
		} catch (Exception e) {
			// Sometimes the text exist, but not the accept button.
			// this means the popup wasn't displayed and therefore
			// really never existed.
			//
			message = null;
		}

		return message;
	}

	private static SecureRandom random = new SecureRandom();

	/**
	 * Generate random string of special characters of length x
	 * 
	 * @return
	 */
	public String getRandomSpecialString(int length) {
		int len = specialCharacters.length;
		String str = "";
		Random randomGenerator = new Random();
		int index;

		for (int i = 0; i < length; i++) {
			index = randomGenerator.nextInt(len - 1);
			str = str + specialCharacters[index];
		}
		return str;
	}

	/**
	 * Generate random string of length x
	 * 
	 * @return
	 */
	public static String getRandomString(int length) {
		String result = new BigInteger(Long.SIZE * length, random).toString(32);
		return result.substring(0, length);
	}
	
	/**
	 * Generate random number
	 * 
	 * @return
	 */
	public static String getRandomNumber() 
	{
		Random r;
		int random;
		r = new Random( System.currentTimeMillis() );
		random =  1000 + r.nextInt(2000);
		return String.valueOf(random);
	}
	

	/**
	 * Generate random string of length x
	 * 
	 * @return
	 */
	public static void populateField(WebDriver driver, By locator, String value) {
		WebElement field = driver.findElement(locator);
		field.clear();
		field.sendKeys(value);

	}

	/**
	 * Check hover message text
	 * 
	 * @param driver
	 * @param by
	 * 
	 * @return string
	 */
	public static String checkHoverMessage(WebDriver driver, By locator){
		String tooltip = driver.findElement(locator).getAttribute("title");
		return tooltip;
	}
	

	/**
	 * Mouse hover
	 */
	public static void mouseHover(WebDriver driver, WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	/**
	 * Select radio button
	 * 
	 * @param driver
	 * @param by
	 * @param value
	 * 
	 */
	public static void selectRadioButton(WebDriver driver, By locator, String value){
		List<WebElement> select = driver.findElements(locator);

		for (WebElement radio : select){
			if (radio.getAttribute("value").equalsIgnoreCase(value)){
				radio.click(); 	            	

			}}}

	/**
	 * Select multiple check boxes
	 * 
	 * @param driver
	 * @param by
	 * @param value
	 * 
	 */
	public static void selectCheckboxes(WebDriver driver, By locator, String value){

		List<WebElement> abc = driver.findElements(locator);
		List<String> list = new ArrayList<String>(Arrays.asList(value.split(",")));

		for (String check : list){
			for (WebElement chk : abc){        	
				if(chk.getAttribute("value").equalsIgnoreCase(check)){	        	
					chk.click();	    	            	
				}      		        		            	
			}
		}
	}


	/**
	 * Select drop down
	 * 
	 * @param driver
	 * @param by
	 * @param value
	 * 
	 */
	public static void selectDropdown(WebDriver driver, By locator, String value){
		new Select (driver.findElement(locator)).selectByVisibleText(value); 
		}
	
	public static List<WebElement> getDropdownOptions(WebDriver driver, WebElement element){
		return new Select(element).getOptions();
		}

	public static void selectDropdown(WebElement element, String value){
		System.out.println("Element value"+value);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	/**
	 * Select auto-suggest search drop down
	 * 
	 * @param driver
	 * @param by
	 * @param value
	 * 
	 */
	public static void selectSearchDropdown(WebElement element, String value){ 
		System.out.println("Enter Element value"+value);
		Select select = new Select(element);
		select.selectByVisibleText(value); 
	}

	


	/**
	 * Upload file
	 * 
	 * @param driver
	 * @param by
	 * @param value
	 * 
	 */
	public static void uploadFile(WebDriver driver, By locator, String value){
		driver.findElement(locator).sendKeys(value);		  
	}


	/**
	 * Takes controls on new tab
	 * 
	 * @param driver
	 * 
	 */
	public static void handleNewTab(WebDriver driver)
	{
		Set<String> allWindowHandles = driver.getWindowHandles();
		String window0 = (String) allWindowHandles.toArray()[1];
		driver.switchTo().window(window0);
	}
	
	public static void handleOldTab(WebDriver driver)
	{
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);
	}

	public static void moveToNewWindow(WebDriver driver)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle :windowHandles)
		{
			driver.switchTo().window(windowHandle);
		}
	}
	
	public static String getTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public static void closecurrentBrowser(WebDriver driver)
	{
		driver.close();
	}
	

	/**
	 * Helper method: looks through a list of WebElements, to find the first WebElement with matching text
	 * 
	 * @param elements
	 * @param text
	 * 
	 * @return WebElement or null
	 */
	public static WebElement findElementByText(List<WebElement> elements, String text) {
		WebElement result = null;
		for (WebElement element : elements) {
			element.getText().trim();
			if (text.equalsIgnoreCase(element.getText().trim())) {
				result = element;
				break;
			}
		}
		return result;
	}


	/**
	 * Compact way to verify if an element is on the page
	 * 
	 * @param driver
	 * @param by
	 * @return
	 */
	public static boolean isElementPresent(final WebDriver driver, By by) {


		try {
			driver.findElement(by);
			
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementPresent(WebElement element) {


		try {
			System.out.println(element.isDisplayed());
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	/**
	 * Downloads a file from the defined url, and saves it into the
	 * OutputDatafolder, using the filename defined
	 * 
	 * @param href
	 * @param fileName
	 */
	public static void downloadFile(String href, String fileName) throws Exception{

		PropertyConfigurator.configure("config/log4j.properties");

		URL url = null;
		URLConnection con = null;
		int i;

		url = new URL(href);

		con = url.openConnection();
		File file = new File(".//OutputData//" + fileName);
		BufferedInputStream bis = new BufferedInputStream(con.getInputStream());

		@SuppressWarnings("resource")
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(file));
		while ((i = bis.read()) != -1) {
			bos.write(i);
		}
		bos.flush();
		bis.close();
	}


	/**
	 * Writes content to the excel sheet
	 * 
	 * @param text
	 * @param fileName
	 */
	public static void writeExcel(String text,String fileName) throws Exception 
	{ 
		FileOutputStream file = new FileOutputStream(".//OutputData//" + fileName+".csv",true);
		WritableWorkbook book = Workbook.createWorkbook(file); 
		WritableSheet sheet = book.createSheet("output", 0);
		Label l = new Label(0, 0, text);
		sheet.addCell(l);
		book.write(); 
		book.close(); 
	}
	
	public static void scrolltoViewElement(WebElement element, WebDriver driver ){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void scrollDown(final WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
	
	}
	public static void scrollDowntillEnd(final WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4000)");
	
	}
	
	public static void scrollDowntillFooterLinks(final WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2800)");
	
	}
	
	public static void scrollUp(final WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-800)");
		
	} 
	
	public static void navigateBack(final WebDriver driver) 
	{
		driver.navigate().back();		
	}
	
	public static void refresh(final WebDriver driver) 
	{
		driver.navigate().refresh();		
	}
	
	/**
	 * Verify if table sorted by column
	 * @param tableColumnHeader
	 * @param columnDataList
	 * @return True if table sorted by column otherwise False
	 */
	public static boolean isTableSortedByColumn(WebElement tableColumnHeader, List<WebElement> columnDataList) {
		tableColumnHeader.click();
		
		ArrayList<String> obtainedList = new ArrayList<>(); 
		for(WebElement we:columnDataList) {
			obtainedList.add(we.getText());
		}
		System.out.println("Obtained List" +obtainedList);

		ArrayList<String> sortedList = new ArrayList<>();   
		for(String s:obtainedList) {
			sortedList.add(s);
		}

		Collections.sort(sortedList);
		System.out.println("Sorted List" +sortedList);
		if(sortedList.equals(obtainedList)) {
			return true;
		}else {
			return false;
		}
	}

	public static int counterIncrease()
	{
		counter++;
		return counter;
	}
	
	/**
	 * print a page by clicking on Print link on a page
	 * @param driver
	 * @param browser
	 * @param printed page file name
	 * @throws Exception
	 */
/*	public static void printAPage(WebDriver driver , String browser , String printedPage) throws Exception {

		String Workingdir = System.getProperty("user.dir");
		String parentWindow = driver.getWindowHandle();

		WebElement printPageLink = driver.findElement(By.xpath("//div[@class='email-print']/a[1]"));
		printPageLink.click();
		WaitTool.hardWait();

		if(browser.equalsIgnoreCase("chrome")) {

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			WebElement printButton = driver.findElement(By.xpath("//button[@class='print default']"));
			printButton.click();

			App app1 = new App("Save Print Output As");
			app1.focus();
			Screen screen = new Screen(); 
			Pattern fileNameImage = new Pattern(Workingdir+"/src/test/resources/InputTestData/sikuliImages/chromeFileName.PNG"); 
			Pattern savefileImage = new Pattern(Workingdir+"/src/test/resources/InputTestData/sikuliImages/chromeSaveFile.PNG"); 
			WaitTool.hardWait();
			screen.type(fileNameImage , printedPage);
			screen.click(savefileImage);
			WaitTool.hardWait();
			driver.switchTo().window(parentWindow);

		}else if(browser.equalsIgnoreCase("firefox")) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);

			App app2 = new App("Save Print Output As");
			app2.focus();
			Screen screen = new Screen(); 
			Pattern fileNameImage = new Pattern(Workingdir+"/src/test/resources/InputTestData/sikuliImages/firefoxFileName.PNG"); 
			Pattern savefileImage = new Pattern(Workingdir+"/src/test/resources/InputTestData/sikuliImages/firefoxSaveFile.PNG"); 
			WaitTool.hardWait();
			screen.type(fileNameImage , printedPage);
			screen.click(savefileImage);
			WaitTool.hardWait();

		}else {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		}
	} */
}