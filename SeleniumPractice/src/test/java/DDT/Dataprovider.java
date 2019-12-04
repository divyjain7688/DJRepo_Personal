package DDT;

import java.lang.reflect.Method;

import org.testng.annotations.*;
public class Dataprovider {
	
	 @DataProvider
	    public static Object[][] getDataFromDataprovider(Method m){
		 if(m.getName().equalsIgnoreCase("testmethodA"))
	    return new Object[][] 
	    	{
	            { "Guru99", "India" },
	            { "Krishna", "UK" },
	            { "Bhupesh", "USA" }
	        };
	        else
	        	return new Object[][] 
	        	    	{
	        	            { "test1", "indore" },
	        	            { "test2", "dhar" },
	        	            { "test3", "mumbai" }
	        	        };
	        	
	        

	    }
}
