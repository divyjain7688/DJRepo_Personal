package DDT;

import org.testng.annotations.*;
import org.testng.asserts.*;
import java.util.concurrent.TimeoutException;
import org.openqa.*;

public class DDTusingparameters {
  @Test
 @Parameters({"author","searchKey"})
  public void datafromparameters(@Optional("Aaru") String author, String searchkey) {
	  System.out.println("author is " + author);
	  System.out.println("searchkey is " + searchkey);
  }
}

/*author is Aaru
searchkey is UK*/

