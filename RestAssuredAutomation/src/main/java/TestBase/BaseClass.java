package TestBase;


import org.apache.log4j.*;
import org.apache.poi.poifs.property.PropertyConstants;
import org.testng.annotations.BeforeClass;


public class BaseClass  {
	public String empId="54768";
	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	
	{
		logger=Logger.getLogger("EmployeeRestAPI");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		
	}

}