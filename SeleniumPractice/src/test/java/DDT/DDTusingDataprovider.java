package DDT;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class DDTusingDataprovider {
    WebDriver driver;
   

    @BeforeTest
    public void setup(){
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("https://google.com");
         System.out.println("opening google.com");
         driver.manage().window().maximize();
    }
 
    @Test(dataProvider="getDataFromDataprovider",dataProviderClass= Dataprovider.class)
    public void testmethodC(String author,String searchKey) throws InterruptedException {
    {
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(searchKey);
        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
        Thread.sleep(3000);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue +"::::"+searchKey);
        searchText.clear();
       // AssertJUnit.assertTrue(testValue.equalsIgnoreCase(searchKey));
        Assert.assertEquals(testValue, searchKey);
        System.out.println("Assert.assertEquals(testValue, searchKey)");
    }
    }
    @Test(dataProvider="getDataFromDataprovider",dataProviderClass= Dataprovider.class)
    public void testmethodA(String author,String searchKey) throws InterruptedException {
    {
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(searchKey);
        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
        Thread.sleep(3000);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue +"::::"+searchKey);
        searchText.clear();
       // AssertJUnit.assertTrue(testValue.equalsIgnoreCase(searchKey));
        Assert.assertEquals(testValue, searchKey);
        System.out.println("Assert.assertEquals(testValue, searchKey)");
    }
    
    
    }
    @AfterTest
    public void closebrowser()
    {
    	driver.close();
    }

   /* @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Guru99", "India" },
            { "Krishna", "UK" },
            { "Bhupesh", "USA" }
        };

    }*/

}