package udemyApiTest;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pojo.Api;
import Pojo.GetCourse;
import Pojo.WebAutomation;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class OAuth2validationWithPojo {
	String[] courseTitles = {"Selenium Webdriver Java","Cypress","Protractor"};
	@Test
	public void getCourses() throws InterruptedException
	{	
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyfjdss");		
		driver.findElement(By.cssSelector("[type='email']")).sendKeys("divy.0871@gmail.com");
		driver.findElement(By.cssSelector("[type='email']")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("wqrrq");
		driver.findElement(By.cssSelector("[type='password']")).sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		String url=driver.getCurrentUrl();
		String partialcode=url.split("code=")[1];
		String code=partialcode.split("&scope")[0];
		System.out.println("code is " + code);
		driver.close();



		String accessTokenResponse = given().urlEncodingEnabled(false).
				queryParams("code", code).
				queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
				queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
				queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php").		
				queryParams("grant_type", "authorization_code").
				when().log().all().
				post("https://www.googleapis.com/oauth2/v4/token").asString();
		System.out.println("accessTokenResponse is "+ accessTokenResponse);
		JsonPath jsToken = new JsonPath(accessTokenResponse);
		String accessToken = jsToken.get("access_token");
		System.out.println("access token is "+ accessToken);


		GetCourse gc  = given().
				queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON).  //parsing not needed if in header, application type is defined as json
				when().
				get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		System.out.println(gc.getlinkedIn());

		List<Api> apiCourses= gc.getCourses().getApi();
		for(int i=0;i<apiCourses.size();i++)
		{
			if(apiCourses.get(i).getCourseTitle().equals("SoapUI Webservices testing"))
			{
				System.out.println("price is " + apiCourses.get(i).getPrice());
				break;
			}
		}

		ArrayList<String> actualCourses =  new ArrayList<String>();
		List<WebAutomation> webAutomationCoures = gc.getCourses().getWebAutomation();
		for(int j=0;j<webAutomationCoures.size();j++)
		{

			actualCourses.add(webAutomationCoures.get(j).getCourseTitle());
		}
		List<String> expectedCourses = Arrays.asList(courseTitles);
		Assert.assertTrue(actualCourses.equals(expectedCourses));
	}
}



/*
{
"instructor": "Rahul Shetty",
"url": "rahulshettycademy.com",
"services": "projectSupport",
"expertise": "Automation",
"linkedIn": "https://www.linkedin.com/in/rahul-shetty/",
"courses": {
  "webAutomation": [
    {
      "courseTitle": "Selenium Webdriver Java",
      "price": 50
    },
    {
      "courseTitle": "Cypress",
      "price": 40
    },
    {
      "courseTitle": "Protractor",
      "price": 30
    }
  ],
  "api": [
    {
      "courseTitle": "Rest Assured Automation using Java",
      "price": 60
    },
    {
      "courseTitle": "SoapUI Webservices testing",
      "price": 45
    }
  ],
  "mobile": [
    {
      "courseTitle": "Appium-Mobile Automation using Java",
      "price": 70
    }
  ]
}
}

*/