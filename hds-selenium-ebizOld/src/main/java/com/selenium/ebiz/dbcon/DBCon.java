package com.selenium.ebiz.dbcon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.selenium.ebiz.beans.UsersListBean;

public class DBCon {

	protected static String TestDataPath = System.getProperty("user.dir")+"/src/test/resources/InputTestData/InputData.xlsx";

	private final static int TESTSCENARIONAME = 0;

	private final static int QTY1 = 1;
	private final static int QTY2 = 2;
	private final static int SEARCHPRODUCTPARTNUMBER1 = 3;
	private final static int SEARCHPRODUCTPARTNUMBER2 = 4;
	private final static int PRIVATELIST = 5;
	private final static int NEWLIST = 6;
	private final static int SHAREDLIST = 7;
	private final static int CompanyPropertyName = 8;	
	private final static int PurchasersFirstName = 9;
	private final static int PurchasersLastName = 10;
	private final static int Industry = 11;
	private final static int TypeofBusiness = 12;	
	private final static int Numberof = 13;
	private final static int ChooseAUserName = 14;	
	private final static int ChooseAPassword = 15;	
	private final static int ConfirmPassword = 16;	
	private final static int EmailAddress = 17;	
	private final static int ConfirmEmailAddress = 18;	
	private final static int AddressStreetNum = 19;	
	private final static int AddressStreetName = 20;	
	private final static int City = 21;	
	private final static int State = 22;	
	private final static int ZipCode = 23;	
	private final static int PhoneNumber = 24;	
	private final static int FaxNumber = 25;
	private final static int UserName = 26;
	private final static int Password = 27;
	private final static int Category = 28;
	private final static int FooterLink = 29;

	/////////////////////////////////////////////////////////////////////////
	private final static int Registration_TESTSCENARIONAME = 0;
	private final static int Registration_CompanyPropertyName = 1 ;
	private final static int Registration_FirstName = 2 ;
	private final static int Registration_LastName = 3;
	private final static int Registration_IndustryFromDropdown = 4;
	private final static int Registration_TypeOfBusinessFromDropdown = 5;
	private final static int Registration_ShippingAddrsssName = 6;
	private final static int Registration_LookupAddress = 7;
	private final static int Registration_Address = 8;
	private final static int Registration_City = 9;
	private final static int Registration_StateFromDropdown = 10;
	private final static int Registration_Zipcode = 11;
	private final static int Registration_EmailAddress = 12;
	private final static int Registration_Username = 13;
	private final static int Registration_Password = 14;
	
	/////////////////////////////////////////////////////////////////////////
	private final static int LoginTestData_TESTSCENARIONAME = 0;
	private final static int LoginTestData_UserName = 1;
	private final static int LoginTestData_Password = 2;
	private final static int ChooseProperty = 3;
	private final static int LoginTestData_EmailAddress=4;

	//////////////////////////////////////////////////////////////////////////
	private final static int Categories_TESTSCENARIONAME = 0;
	private final static int Categories_SearchProduct = 1;
	private final static int Categories_Categories = 2;
	private final static int Categories_L1Subcategory = 3;
	private final static int Categories_L2Subcategory = 4;

	//////////////////////////////////////////////////////////////////////////
	private final static int Search_TESTSCENARIONAME = 0;
	private final static int Search_SearchProductPartNumber = 1;
	private final static int Search_SearchProductKeyword = 2;
	private final static int Search_GoogleSearchData = 3;

	////////////////////////////////////////////////////////////////////////////
	private final static int HomePage_TESTSCENARIONAME = 0;
	private final static int HomePage_IndustryType = 1;

	////////////////////////////////////////////////////////////////////////////
	private final static int QuickOrder_TESTSCENARIONAME = 0;
	private final static int QuickOrder_PartNumber1 = 1;
	private final static int QuickOrder_PartNumber2 = 2;
	private final static int QuickOrder_PartNumber3 = 3;
	private final static int QuickOrder_PartNumber4 = 4;
	private final static int QuickOrder_PartNumber5 = 5;
	private final static int QuickOrder_PartNumber6 = 6;
	private final static int QuickOrder_PartNumber7 = 7;
	private final static int QuickOrder_Quantity1 = 8;
	private final static int QuickOrder_Quantity2 = 9;
	private final static int QuickOrder_Quantity3 = 10;
	private final static int QuickOrder_Quantity4 = 11;
	private final static int QuickOrder_Quantity5 = 12;
	private final static int QuickOrder_Quantity6 = 13;
	private final static int QuickOrder_Quantity7 = 14;
	
	////////////////////////////////////////////////////////////////////////////
	private final static int ShippingAddress_TESTSCENARIONAME = 0;
	private final static int ShippingAddress_ShippingAddressName = 1;
	private final static int ShippingAddress_CompanyOrPropertyName = 2;
	private final static int ShippingAddress_AttentionOf = 3;
	private final static int ShippingAddress_LookupAddress = 4;
	private final static int ShippingAddress_Address = 5;
	private final static int ShippingAddress_FloorOrSuite = 6;
	private final static int ShippingAddress_City = 7;
	private final static int ShippingAddress_State = 8;
	private final static int ShippingAddress_ZipCode = 9;
	private final static int ShippingAddress_PhoneNumber = 10;


	/////////////////////////////////////////////////////////////////////////
	private final static int HomePageLeftNav_TESTSCENARIONAME = 0;
	private final static int leftNavCategoryName = 1;
	private final static int leftNavCategoryPageURL = 2;
	private final static int leftNavCategoryPageTitle =3;


	//////////////////////////////////////////////////////////////////////////
	private final static int MyAccount_TESTSCENARIONAME = 0;
	private final static int MyAccount_UpdateEmailAddress = 1;
	private final static int MyAccount_OldPassword = 2;
	private final static int MyAccount_NewPassword = 3;
	private final static int MyAccount_Username = 4;
	private final static int MyAccount_ShippingAddressName = 5;
	private final static int MyAccount_Address = 6;
	private final static int MyAccount_FloorOrSuite = 7;
	private final static int MyAccount_City = 8;
	private final static int MyAccount_State = 9;
	private final static int MyAccount_ZipCode = 10;
	private final static int MyAccount_PhoneNumber = 11;
	private final static int MyAccount_CompanyPropertyName = 12;
	
	///////////////////////////////////////////////////////////////////////////
	private final static int SearchCategory_TESTSCENARIONAME = 0;
	private final static int SearchNavCategoryName = 1;
	private final static int SearchNavCategoryPageURL = 2;
	private final static int SearchNavCategoryPageTitle =3;
	
	//////////////////////////////////////////////////////////////////////
	private final static int SmokeTest_TESTSCENARIONAME = 0;
	private final static int SmokeTest_UserName = 1;
	private final static int SmokeTest_Password = 2;
	private final static int SmokeTest_SearchProductPartNumber = 3;
	private final static int SmokeTest_PartNumber1 = 4;
	private final static int SmokeTest_Quantity1 = 5;
	private final static int SmokeTest_PurchaseOrderNumber = 6;
	
	//////////////////////////////////////////////////////////////////////
	private final static int RegistrationIndustryTypeOfBuss_TESTSCENARIONAME = 0;
	private final static int RegistrationIndustryTypeOfBuss_Industry = 1;
	private final static int RegistrationIndustryTypeOfBuss_TypeOfBusiness = 2;
	
	//////////////////////////////////////////////////////////////////////
	private final static int CustomizePeachTreeItem_TESTSCENARIONAME = 0;
	private final static int CustomizePeachTreeItem_FlatOrAssemble = 1;
	private final static int CustomizePeachTreeItem_LabelFormat = 2;
	private final static int CustomizePeachTreeItem_Color = 3;
	private final static int CustomizePeachTreeItem_Style = 4;
	private final static int CustomizePeachTreeItem_ImprintLine1 = 5;
	private final static int CustomizePeachTreeItem_ImprintLine2 = 6;
	private final static int CustomizePeachTreeItem_ImprintLine3 = 7;
	private final static int CustomizePeachTreeItem_ImprintLine4 = 8;
	private final static int CustomizePeachTreeItem_ImprintLine5 = 9;
	private final static int CustomizePeachTreeItem_ImprintLine6 = 10;
	private final static int CustomizePeachTreeItem_ImprintLine7 = 11;
	private final static int CustomizePeachTreeItem_Comments = 12;
	

	
	//protected static HashMap<String, String> _users = new HashMap<String, String>();

	public ArrayList<UsersListBean> loadDataFromExcel(String testcaseName, String sheetName) throws Exception {

		ArrayList<UsersListBean> usersList = new ArrayList<UsersListBean>();

		try {
			File file = new File(System.getProperty("user.dir")+"/src/test/resources/InputTestData/InputData.xlsx");			
			// Create an object of FileInputStream class to read excel file
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);
			UsersListBean users = new UsersListBean();

			if (sheetName.equals("HDSTestdata")){


				XSSFSheet sheet = wb.getSheet("HDSTestdata");
				int row = sheet.getLastRowNum();
				for (int i = 1; i <= row; i++) {
					try {
						Row rows = sheet.getRow(i);
						if (rows.getCell(TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {
							//UsersListBean users = new UsersListBean();
							users.setQty1(rows.getCell(QTY1).getStringCellValue());
							users.setQty2(rows.getCell(QTY2).getStringCellValue());
							users.setSearchProductPartNumber1(rows.getCell(SEARCHPRODUCTPARTNUMBER1).getStringCellValue());
							users.setSearchProductPartNumber2(rows.getCell(SEARCHPRODUCTPARTNUMBER2).getStringCellValue());
							users.setPrivateList(rows.getCell(PRIVATELIST).getStringCellValue());
							users.setNewList(rows.getCell(NEWLIST).getStringCellValue());
							users.setSharedList(rows.getCell(SHAREDLIST).getStringCellValue());
							users.setCompanyPropertyName(rows.getCell(CompanyPropertyName).getStringCellValue());
							users.setPurchasersFirstName(rows.getCell(PurchasersFirstName).getStringCellValue());
							users.setPurchasersLastName(rows.getCell(PurchasersLastName).getStringCellValue());
							users.setIndustry(rows.getCell(Industry).getStringCellValue());
							users.setTypeofBusiness(rows.getCell(TypeofBusiness).getStringCellValue());
							users.setNumberof(rows.getCell(Numberof).getStringCellValue());
							users.setChooseAUserName(rows.getCell(ChooseAUserName).getStringCellValue());
							users.setChooseAPassword(rows.getCell(ChooseAPassword).getStringCellValue());
							users.setConfirmPassword(rows.getCell(ConfirmPassword).getStringCellValue());
							users.setEmailAddress(rows.getCell(EmailAddress).getStringCellValue());
							users.setConfirmEmailAddress(rows.getCell(ConfirmEmailAddress).getStringCellValue());
							users.setAddressStreetNum(rows.getCell(AddressStreetNum).getStringCellValue());
							users.setAddressStreetName(rows.getCell(AddressStreetName).getStringCellValue());
							users.setCity(rows.getCell(City).getStringCellValue());
							users.setState(rows.getCell(State).getStringCellValue());
							users.setZipCode(rows.getCell(ZipCode).getStringCellValue());
							users.setPhoneNumber(rows.getCell(PhoneNumber).getStringCellValue());
							users.setFaxNumber(rows.getCell(FaxNumber).getStringCellValue());
							users.setuserName(rows.getCell(UserName).getStringCellValue());
							users.setpassword(rows.getCell(Password).getStringCellValue()); 
							users.setpassword(rows.getCell(Category).getStringCellValue()); 
							users.setchooseProperty(rows.getCell(ChooseProperty).getStringCellValue()); 
							users.setFooterLink(rows.getCell(FooterLink).getStringCellValue() );

							usersList.add(users);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found1 :" + ex);
					}
				}
			}
			else if(sheetName.equals("LoginTestData")){

				XSSFSheet sheet = wb.getSheet("LoginTestData");
				int row = sheet.getLastRowNum();
				for (int i = 1; i <= row; i++) {
					try {
						Row rows = sheet.getRow(i);
						if (rows.getCell(LoginTestData_TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {
							users.setuserName(rows.getCell(LoginTestData_UserName).getStringCellValue());
							users.setpassword(rows.getCell(LoginTestData_Password).getStringCellValue());
							users.setchooseProperty(rows.getCell(ChooseProperty).getStringCellValue()); 
							users.setEmailAddress(rows.getCell(LoginTestData_EmailAddress).getStringCellValue());
							usersList.add(users);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found2 :" + ex);
					}
				}
			}
			
			else if(sheetName.equals("Categories")){

				XSSFSheet sheet = wb.getSheet("Categories");
				int row = sheet.getLastRowNum();
				for (int i = 1; i <= row; i++) {
					try {
						Row rows = sheet.getRow(i);
						if (rows.getCell(Categories_TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {
							users.setSearchProduct(rows.getCell(Categories_SearchProduct).getStringCellValue());
							users.setCategory(rows.getCell(Categories_Categories).getStringCellValue());
							users.setL1SubCategory(rows.getCell(Categories_L1Subcategory).getStringCellValue());
							users.setL2SubCategory(rows.getCell(Categories_L2Subcategory).getStringCellValue());
							usersList.add(users);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {

						System.out.println("File Could not be Found3 :" + ex);
					}
				}
			}
			
			else if(sheetName.equals("Search")){

				XSSFSheet sheet = wb.getSheet("Search");
				int row = sheet.getLastRowNum();
				for (int i = 1; i <= row; i++) {
					try {
						Row rows = sheet.getRow(i);
						if (rows.getCell(Search_TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {
							users.setSearchProductPartNumber(rows.getCell(Search_SearchProductPartNumber).getStringCellValue());
							users.setSearchProductKeyword(rows.getCell(Search_SearchProductKeyword).getStringCellValue());
							users.setGoogleSearchData(rows.getCell(Search_GoogleSearchData).getStringCellValue());
							usersList.add(users);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found4 :" + ex);
					}
				}
			}

			else if(sheetName.equals("HomePage")){

				XSSFSheet sheet = wb.getSheet("HomePage");
				int row = sheet.getLastRowNum();
				for (int i = 1; i <= row; i++) {
					try {
						Row rows = sheet.getRow(i);
						if (rows.getCell(HomePage_TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {
							users.setIndustryType(rows.getCell(HomePage_IndustryType).getStringCellValue());
							usersList.add(users);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found5 :" + ex);
					}
				}
			}

			else if(sheetName.equals("QuickOrder")){

				XSSFSheet sheet = wb.getSheet("QuickOrder");
				int row = sheet.getLastRowNum();
				for (int i = 1; i <= row; i++) {
					try {
						Row rows = sheet.getRow(i);
						if (rows.getCell(QuickOrder_TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {
							users.setPartNumber1(rows.getCell(QuickOrder_PartNumber1).getStringCellValue());
							users.setPartNumber2(rows.getCell(QuickOrder_PartNumber2).getStringCellValue());
							users.setPartNumber3(rows.getCell(QuickOrder_PartNumber3).getStringCellValue());
							users.setPartNumber4(rows.getCell(QuickOrder_PartNumber4).getStringCellValue());
							users.setPartNumber5(rows.getCell(QuickOrder_PartNumber5).getStringCellValue());
							users.setPartNumber6(rows.getCell(QuickOrder_PartNumber6).getStringCellValue());
							users.setPartNumber7(rows.getCell(QuickOrder_PartNumber7).getStringCellValue());
							users.setQuantity1(rows.getCell(QuickOrder_Quantity1).getStringCellValue());
							users.setQuantity2(rows.getCell(QuickOrder_Quantity2).getStringCellValue());
							users.setQuantity3(rows.getCell(QuickOrder_Quantity3).getStringCellValue());
							users.setQuantity4(rows.getCell(QuickOrder_Quantity4).getStringCellValue());
							users.setQuantity5(rows.getCell(QuickOrder_Quantity5).getStringCellValue());
							users.setQuantity6(rows.getCell(QuickOrder_Quantity6).getStringCellValue());
							users.setQuantity6(rows.getCell(QuickOrder_Quantity7).getStringCellValue());
							usersList.add(users);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found6 :" + ex);
					}
				}
			}
			else if(sheetName.equals("SmokeTest")){

				XSSFSheet sheet = wb.getSheet("SmokeTest");
				int row = sheet.getLastRowNum();
				for (int i = 1; i <= row; i++) {
					try {
						Row rows = sheet.getRow(i);
						if (rows.getCell(SmokeTest_TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {
							users.setUsername(rows.getCell(SmokeTest_UserName).getStringCellValue());
							users.setpassword(rows.getCell(SmokeTest_Password).getStringCellValue());
							users.setSearchProductPartNumber(rows.getCell(SmokeTest_SearchProductPartNumber).getStringCellValue());
							users.setPartNumber1(rows.getCell(SmokeTest_PartNumber1).getStringCellValue());
							users.setQuantity1(rows.getCell(SmokeTest_Quantity1).getStringCellValue());
							users.setPurchaseOrderNumber(rows.getCell(SmokeTest_PurchaseOrderNumber).getStringCellValue());
							usersList.add(users);
				
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found6 :" + ex);
					}
				}
			}

			else if(sheetName.equals("ShippingAddress")){

				XSSFSheet sheet = wb.getSheet("ShippingAddress");
				int row = sheet.getLastRowNum();
				for (int i = 1; i <= row; i++) {
					try {
						Row rows = sheet.getRow(i);
						if (rows.getCell(ShippingAddress_TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {
							users.setShippingAddressName(rows.getCell(ShippingAddress_ShippingAddressName).getStringCellValue());
							users.setCompanyOrPropertyName(rows.getCell(ShippingAddress_CompanyOrPropertyName).getStringCellValue());
							users.setAttentionOf(rows.getCell(ShippingAddress_AttentionOf).getStringCellValue());
							users.setLookupAddress(rows.getCell(ShippingAddress_LookupAddress).getStringCellValue());
							users.setAddress(rows.getCell(ShippingAddress_Address).getStringCellValue());
							users.setFloorOrSuite(rows.getCell(ShippingAddress_FloorOrSuite).getStringCellValue());
							users.setCity(rows.getCell(ShippingAddress_City).getStringCellValue());
							users.setState(rows.getCell(ShippingAddress_State).getStringCellValue());
							users.setZipCode(rows.getCell(ShippingAddress_ZipCode).getStringCellValue());
							users.setPhoneNumber(rows.getCell(ShippingAddress_PhoneNumber).getStringCellValue());
							usersList.add(users);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found6 :" + ex);
					}
				}
			}

			else if(sheetName.equals("MyAccount")){

				XSSFSheet sheet = wb.getSheet("MyAccount");
				int row = sheet.getLastRowNum();
				for (int i = 1; i <= row; i++) {
					try {
						Row rows = sheet.getRow(i);
						if (rows.getCell(MyAccount_TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {
							users.setUpdateEmailAddress(rows.getCell(MyAccount_UpdateEmailAddress).getStringCellValue());
							users.setOldPassword(rows.getCell(MyAccount_OldPassword).getStringCellValue());
							users.setNewPassword(rows.getCell(MyAccount_NewPassword).getStringCellValue());
							users.setUsername(rows.getCell(MyAccount_Username).getStringCellValue());
							users.setShippingAddressName(rows.getCell(MyAccount_ShippingAddressName).getStringCellValue());
							users.setAddress(rows.getCell(MyAccount_Address).getStringCellValue());
							users.setFloorOrSuite(rows.getCell(MyAccount_FloorOrSuite).getStringCellValue());
							users.setCity(rows.getCell(MyAccount_City).getStringCellValue());
							users.setState(rows.getCell(MyAccount_State).getStringCellValue());
							users.setZipCode(rows.getCell(MyAccount_ZipCode).getStringCellValue());
							users.setPhoneNumber(rows.getCell(MyAccount_PhoneNumber).getStringCellValue());
							users.setCompanyOrPropertyName((rows.getCell(MyAccount_CompanyPropertyName).getStringCellValue()));
							usersList.add(users);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found7 :" + ex);
					}
				}
			}


			else if(sheetName.equals("HomePageLeftNav")){

				XSSFSheet sheet = wb.getSheet("HomePageLeftNav");
				int rows = sheet.getLastRowNum();
				//String leftNavCategoryNameValue;
				//String leftNavCategoryPageURLValue;
				//String leftNavCategoryPageTitleValue;
				for (int i = 1; i <= rows; i++) {
					try {
						Row row = sheet.getRow(i);
						UsersListBean usersRow = new UsersListBean();
						usersRow.setleftNavCategoryName(row.getCell(1).getStringCellValue());
						usersRow.setleftNavCategoryPageURL(row.getCell(2).getStringCellValue());
						usersRow.setleftNavCategoryPageTitle(row.getCell(3).getStringCellValue());
						usersList.add(usersRow);

						if (row.getCell(HomePageLeftNav_TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {

						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found6 :" + ex);
					}
				}
			}

			else if(sheetName.equals("CategorySearch")){

				XSSFSheet sheet = wb.getSheet("CategorySearch");
				int rows = sheet.getLastRowNum();
				for (int i = 1; i <= rows; i++) {
					try {
						Row row = sheet.getRow(i);
						UsersListBean usersRow = new UsersListBean();
						usersRow.setSearchCategoryName(row.getCell(1).getStringCellValue());
						usersRow.setSearchCategoryPageURL(row.getCell(2).getStringCellValue());
						usersRow.setSearchCategoryPageTitle(row.getCell(3).getStringCellValue());
						usersList.add(usersRow);

					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found6 :" + ex);
					}
				}
			}

			else if(sheetName.equals("RegistrationIndustryTypeOfBuss")){

				XSSFSheet sheet = wb.getSheet("RegistrationIndustryTypeOfBuss");
				int row = sheet.getLastRowNum();
				for (int i = 1; i <= row; i++) {
					try {
						Row rows = sheet.getRow(i);
						if (rows.getCell(RegistrationIndustryTypeOfBuss_TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {
							users.setIndustry(rows.getCell(RegistrationIndustryTypeOfBuss_Industry).getStringCellValue());
							users.setTypeofBusiness(rows.getCell(RegistrationIndustryTypeOfBuss_TypeOfBusiness).getStringCellValue());
							
							usersList.add(users);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found(RegistrationIndustryTypeOfBuss) :" + ex);
					}
				}
			}
			
			else if(sheetName.equals("Registration")){

				XSSFSheet sheet = wb.getSheet("Registration");
				int row = sheet.getLastRowNum();
				for (int i = 1; i <= row; i++) {
					try {
						Row rows = sheet.getRow(i);
						if (rows.getCell(Registration_TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {
							users.setCompanyOrPropertyName(rows.getCell(Registration_CompanyPropertyName).getStringCellValue());
							users.setFirstName(rows.getCell(Registration_FirstName).getStringCellValue());
							users.setLastName(rows.getCell(Registration_LastName).getStringCellValue());
							users.setIndustry(rows.getCell(Registration_IndustryFromDropdown).getStringCellValue());
							users.setTypeofBusiness(rows.getCell(Registration_TypeOfBusinessFromDropdown).getStringCellValue());
							users.setShippingAddressName(rows.getCell(Registration_ShippingAddrsssName).getStringCellValue());
							users.setLookupAddress(rows.getCell(Registration_LookupAddress).getStringCellValue());
							users.setAddress(rows.getCell(Registration_Address).getStringCellValue());
							users.setCity(rows.getCell(Registration_City).getStringCellValue());
							users.setState(rows.getCell(Registration_StateFromDropdown).getStringCellValue());
							users.setZipCode(rows.getCell(Registration_Zipcode).getStringCellValue());
							users.setEmailAddress(rows.getCell(Registration_EmailAddress).getStringCellValue());
							users.setUsername(rows.getCell(Registration_Username).getStringCellValue());
							users.setpassword(rows.getCell(Registration_Password).getStringCellValue());
							
							usersList.add(users);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found(Registration) :" + ex);
					}
				}
			}
			
			
			else if(sheetName.equals("CustomizePeachTreeItem")){

				XSSFSheet sheet = wb.getSheet("CustomizePeachTreeItem");
				int row = sheet.getLastRowNum();
				for (int i = 1; i <= row; i++) {
					try {
						Row rows = sheet.getRow(i);
						if (rows.getCell(CustomizePeachTreeItem_TESTSCENARIONAME).getStringCellValue().equals(testcaseName)) {
							users.setFlatOrAssemble(rows.getCell(CustomizePeachTreeItem_FlatOrAssemble).getStringCellValue());
							users.setLabelFormat(rows.getCell(CustomizePeachTreeItem_LabelFormat).getStringCellValue());
							users.setColor(rows.getCell(CustomizePeachTreeItem_Color).getStringCellValue());
							users.setStyle(rows.getCell(CustomizePeachTreeItem_Style).getStringCellValue());
							users.setImprintLine1(rows.getCell(CustomizePeachTreeItem_ImprintLine1).getStringCellValue());
							users.setImprintLine2(rows.getCell(CustomizePeachTreeItem_ImprintLine2).getStringCellValue());
							users.setImprintLine3(rows.getCell(CustomizePeachTreeItem_ImprintLine3).getStringCellValue());
							users.setImprintLine4(rows.getCell(CustomizePeachTreeItem_ImprintLine4).getStringCellValue());
							users.setImprintLine5(rows.getCell(CustomizePeachTreeItem_ImprintLine5).getStringCellValue());
							users.setImprintLine6(rows.getCell(CustomizePeachTreeItem_ImprintLine6).getStringCellValue());
							users.setImprintLine7(rows.getCell(CustomizePeachTreeItem_ImprintLine7).getStringCellValue());
							users.setComments(rows.getCell(CustomizePeachTreeItem_Comments).getStringCellValue());							
							usersList.add(users);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						break;
					} catch (Exception ex) {
						System.out.println("File Could not be Found(CustomizePeachTreeItem) :" + ex);
					}
				}
			}
			
			
			
		} catch (FileNotFoundException ex) {
			// log.error("File Could not be Found", ex);
			System.out.println("File Could not be Found7 :" + ex);
		} catch (Exception ex) {
			System.out.println("File Could not be Found8 :" + ex);
		}

		return usersList;
	}

}
