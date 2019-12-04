package com.selenium.ebiz.pageobject;

import com.selenium.ebiz.tools.WaitTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyAddressBookPage {

	private  WebDriver driver; private WaitTool   waitTool;


	public MyAddressBookPage(WebDriver driver) 	{
		this.driver = driver;  this.waitTool = new WaitTool();
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 25);
		//wait.until(ExpectedConditions.visibilityOf(addNewShippingAddressButton));
	}

	@FindBy(xpath="//button[contains(text(),'Add New shipping Address')]")
	WebElement addNewShippingAddressButton;
	
	@FindAll(@FindBy(xpath="//a[text()='Edit']/../..//div[@class='address-default__list-details']/p"))
	List<WebElement> addresslines;
	
	@FindAll(@FindBy(xpath="//a[text()='Edit']/../..//div[@class='address-default__list-details']"))
	List<WebElement> addresses;
	
	/**
	 * Click Add Shipping address button 
	 * @return the driver to Add New Shipping Address Page
	 */
	public AddNewShippingAddressPage clickAddNewShippingAddressButton() {
		addNewShippingAddressButton.click();
		waitTool.waitFor(driver, true);
		return new AddNewShippingAddressPage(driver);
		
	}
	
	/**
	 * Method to verify newly added shipping address is displayed correctly in address book page
	 * @param addressline1
	 * @param addressline2
	 * @param addressline3
	 * @return true if newly added shipping address is displayed correctly otherwise false 
	 */
	public boolean isDisplayedAddedAddrress(String addressline1 , String addressline2, String addressline3){
		ArrayList<String> obtainedList = new ArrayList<>();
		int flag = 0;
		for(int i=0 ; i < addresses.size() ; i++){
			for(WebElement we:addresslines) {
				obtainedList.add(we.getText());
			}
		}
		for(int i=0 ; i < obtainedList.size() ; i++) {
			if(obtainedList.get(i).contains(addressline1) && obtainedList.get(i+1).contains(addressline2) && obtainedList.get(i+2).contains(addressline3)) {
				System.out.println("Address1" +obtainedList.get(i)+  "Address2" +obtainedList.get(i+1)+ "Address3"+obtainedList.get(i+2) );
				flag = 1;
				break;
			}
		}
		if(flag == 1) {
			return true;
		}else {
			return false;
		}
	}
		
}

