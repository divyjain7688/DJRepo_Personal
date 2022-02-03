package DDT;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class priority {

	  @Test(priority=-5, dependsOnMethods="B")
	  public void A() {
		  System.out.println("A called");

	  }
	  
	  @Test(priority=-5)
	  public void D() {
		  System.out.println("D called");

	  }
	  
	  
	  @Test(priority=0)
	  public void B() {
		  System.out.println("B called");

	  }
	  @Test(priority=1,invocationCount=3)
	  public void C() {
		  System.out.println("C called");
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("beforeMethod called");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("afterMethod called");

	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("beforeTest called");

	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("afterTest called");

	  }


}
