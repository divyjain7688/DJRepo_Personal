package com.selenium.ebiz.tools;

import com.selenium.ebiz.dbcon.DBCon;
import com.selenium.ebiz.pageobject.*;
import org.openqa.selenium.WebDriver;

public class PageManager {

    private WebDriver driver;
    private LoginPage loginPage;
    private com.selenium.ebiz.pageobject.HomePage homePage;

    public PageManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public DBCon dBCon(){
        return new DBCon();
    }

    public LoginPage loginPage(){
        return new LoginPage(driver);
    }

    public HomePage homePage(){
        return new HomePage(driver);
    }

    public AccountRetrievalPage accountRetrievalPage(){
        return new AccountRetrievalPage(driver);
    }

    public AddNewShippingAddressPage addNewShippingAddressPage(){
        return new AddNewShippingAddressPage(driver);
    }

    public Appliances appliances(){
        return new Appliances(driver);
    }

    public CategoryAppliancesPage categoryAppliancesPage(){
        return new CategoryAppliancesPage(driver);
    }

    public CategoryBedBathTableLinensPage categoryBedBathTableLinensPage(){
        return new CategoryBedBathTableLinensPage(driver);
    }

    public CategoryCabinetsAndCounterTopsPage categoryCabinetsAndCounterTopsPage(){
        return new CategoryCabinetsAndCounterTopsPage(driver);
    }

    public CategoryDoorsAndMoldingPage categoryDoorsAndMoldingPage(){
        return new CategoryDoorsAndMoldingPage(driver);
    }

    public CategoryElectricalPage categoryElectricalPage(){
        return new CategoryElectricalPage(driver);
    }

    public CategoryElectronicsPage categoryElectronicsPage(){
        return new CategoryElectronicsPage(driver);
    }
    
    public CategoryFitnessAndExercisePage categoryFitnessAndExercisePage(){
        return new CategoryFitnessAndExercisePage(driver);
    }
    
    public CategoryFlooringAndCeilingPage categoryFlooringAndCeilingPage(){
        return new CategoryFlooringAndCeilingPage(driver);
    }
    
    public CategoryFoodServicePage categoryFoodServicePage(){
        return new CategoryFoodServicePage(driver);
    }
    
    public CategoryFurnitureDecorPage categoryFurnitureDecorPage(){
        return new CategoryFurnitureDecorPage(driver);
    }
    
    public CategoryGroundsPage categoryGroundsPage(){
        return new CategoryGroundsPage(driver);
    }
    
    public CategoryHardwarePage categoryHardwarePage(){
        return new CategoryHardwarePage(driver);
    }
    
    public ShopByCategory categoryPage(){
        return new ShopByCategory(driver);
    }
    
    public ChangeEmailAddressPage changeEmailAddressPage(){
        return new ChangeEmailAddressPage(driver);
    }
    
    public CommunicationsPreferencesPage communicationsPreferencesPage(){
        return new CommunicationsPreferencesPage(driver);
    }
    
    public CompareTheseItems compareTheseItems(){
        return new CompareTheseItems(driver);
    }
    
    public CreateNewSavedListPage createNewSavedListPage(){
        return new CreateNewSavedListPage(driver);
    }
    
    public FrequentlyPurchasedPage frequentlyPurchasedPage(){
        return new FrequentlyPurchasedPage(driver);
    }
    
    public GooglePage googlePage(){
        return new GooglePage(driver);
    }
    
    public GoogleSearchResultPage googleSearchResultPage(){
        return new GoogleSearchResultPage(driver);
    }
    
    public HeaderServicesPage headerServicesPage(){
        return new HeaderServicesPage(driver);
    }
    
    public MinicartPage minicartPage(){
        return new MinicartPage(driver);
    }
    
    public MyAccountPage myAccountPage(){
        return new MyAccountPage(driver);
    }
    
    public MyAddressBookPage myAddressBookPage(){
        return new MyAddressBookPage(driver);
    }
    
    public OfferPage offerPage(){
        return new OfferPage(driver);
    }
    
    public OrdersPage ordersPage(){
        return new OrdersPage(driver);
    }
    
    public OrdersHistoryDetailsPage ordersHistoryDetailsPage(){
        return new OrdersHistoryDetailsPage(driver);
    }
    
    public PropertyLookupPage propertyLookupPage(){
        return new PropertyLookupPage(driver);
    }
    
    public QuickOrderPage quickOrderPage(){
        return new QuickOrderPage(driver);
    }
    
    public QuoteListsPage quoteListsPage(){
        return new QuoteListsPage(driver);
    }
    
    public QuotesPriceDetailPage quotesPriceDetailPage(){
        return new QuotesPriceDetailPage(driver);
    }
    
    public RegisterForAnAccountPage registerForAnAccountPage(){
        return new RegisterForAnAccountPage(driver);
    }

    
    public SignInOrRegisterPage signInOrRegisterPage(){
        return new SignInOrRegisterPage(driver);
    }
    
    public SubCategory subCategory(){
        return new SubCategory(driver);
    }
    
    public SubCategoryBedBathTableLinensPage subCategoryBedBathTableLinensPage(){
        return new SubCategoryBedBathTableLinensPage(driver);
    }
    
    public SubCategoryCabinetsAndCounterLoopsPage subCategoryCabinetsAndCounterLoopsPage(){
        return new SubCategoryCabinetsAndCounterLoopsPage(driver);
    }
    
    public SubCategoryCabinetsAndCounterTopsPage subCategoryCabinetsAndCounterTopsPage(){
        return new SubCategoryCabinetsAndCounterTopsPage(driver);
    }
    
    public SubCategoryDoorsAndMouldingPage subCategoryDoorsAndMouldingPage(){
        return new SubCategoryDoorsAndMouldingPage(driver);
    }
    
    public SubCategoryElectricalPage subCategoryElectricalPage(){
        return new SubCategoryElectricalPage(driver);
    }
    
    public SubCategoryElectronicsPage subCategoryElectronicsPage(){
        return new SubCategoryElectronicsPage(driver);
    }
    
    public SubCategoryFitnessExercisePage subCategoryFitnessExercisePage(){
        return new SubCategoryFitnessExercisePage(driver);
    }
    
    public SubCategoryFlooringCeilingPage subCategoryFlooringCeilingPage(){
        return new SubCategoryFlooringCeilingPage(driver);
    }
    
    public SubCategoryFoodServicePage subCategoryFoodServicePage(){
        return new SubCategoryFoodServicePage(driver);
    }
    
    public SubCategoryFurnitureAndDecorPage subCategoryFurnitureAndDecorPage(){
        return new SubCategoryFurnitureAndDecorPage(driver);
    }
    
    public SubCategoryGroundsPage subCategoryGroundsPage(){
        return new SubCategoryGroundsPage(driver);
    }
    
    public SubCategoryHardwarePage subCategoryHardwarePage(){
        return new SubCategoryHardwarePage(driver);
    }
    
    public SubCategoryHealthcareSuppliesPage subCategoryHealthcareSuppliesPage(){
        return new SubCategoryHealthcareSuppliesPage(driver);
    }
    
    public SubcategoryHospitalitySuppliesPage subcategoryHospitalitySuppliesPage(){
        return new SubcategoryHospitalitySuppliesPage(driver);
    }
    
    public SubscriptionsPage subscriptionsPage(){
        return new SubscriptionsPage(driver);
    }
    

    public ProductPage productPage(){
        return new ProductPage(driver);
    }


    public SubCategoryAppliancesPage subCategoryAppliancesPage(){
        return new SubCategoryAppliancesPage(driver);
    }

    public ProductDetailsPage productDetailsPage(){
        return new ProductDetailsPage(driver);
    }

    public ShoppingCartPage shoppingCartPage(){
        return new ShoppingCartPage(driver);
    }

    public PaymentAndCheckOutPage paymentAndCheckOutPage(){
        return new PaymentAndCheckOutPage(driver);
    }

    public QuickOrderPad quickOrderPad(){
        return new QuickOrderPad(driver);
    }

    public OrderConfirmationPage orderConfirmationPage(){
        return new OrderConfirmationPage(driver);
    }

    public ProductListingPage productListingPage(){
        return new ProductListingPage(driver);
    }
    
    public QuotesConfirmationPage quotesConfirmationPage(){
        return new QuotesConfirmationPage(driver);
    }

    public SavedListsPage savedListsPage(){
        return new SavedListsPage(driver);
    }

    public SavedListsDetailPage savedListsDetailPage(){
        return new SavedListsDetailPage(driver);
    }
    
    public EMailPage eMailPage(){
        return new EMailPage(driver);
    } 
    
    public EcatalogPage ecatalogPage()
    {
    	return new EcatalogPage(driver);
    }

    public AddToExistingORCreateNewList_modal addToExistingORCreateNewList_modal(){
        return new AddToExistingORCreateNewList_modal(driver);
    }

    public CaptureScreenShot captureScreenShot(){return new CaptureScreenShot(driver);}

    public CommonFunctions common(){
        return new CommonFunctions(driver);
    }

    public commonLogin commonLogin() {
        return new commonLogin(driver);
    }

    public SwitchTool switchTool() {
        return new SwitchTool();
    }

    public ProductListingPageFilters plpFilters(){
        return new ProductListingPageFilters(driver);
    }
    public CustomizeConfiguratorModal customizeConfigModal(){
        return new CustomizeConfiguratorModal(driver);
    }

    public AddToExistingORCreateNewQUOTE_modal addToExistingORCreateNewQUOTE_modal(){
        return new AddToExistingORCreateNewQUOTE_modal(driver);
    }
    
    public CreateNewQuote_Modal createNewQuote_Modal(){
        return new CreateNewQuote_Modal(driver);
    }
    
    public QuickCheckout quickCheckout(){
        return new QuickCheckout(driver);
    }
    
    public PoolCareAndMaintenance poolCareAndMaintenance(){
        return new PoolCareAndMaintenance(driver);
    }
    
    public PoolWaterTestingTool poolWaterTesting(){
        return new PoolWaterTestingTool(driver);
    }
    
    public PartsLinkPage partsLinkPage(){return new PartsLinkPage(driver);}

    public CommonPageObjects commonPageObjects(){return new CommonPageObjects(driver);}
}


