package udemyApiTest;

import static io.restassured.RestAssured.given;
//import io.restassured.module.jsv.JsonSchemaValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OAuth2validation {
	@Test
	public void getCourses() throws InterruptedException
	{	
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyfjdss");		
		driver.findElement(By.cssSelector("[type='email']")).sendKeys("divy.0871@gmail.com");
		driver.findElement(By.cssSelector("[type='email']")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("ashdg");
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



		String response = given().
				queryParam("access_token", accessToken).
				when().log().all().
				get("https://rahulshettyacademy.com/getCourse.php")
				.asString();
		System.out.println("final response is "+ response);
		
/*		String response = given().
				queryParam("access_token", accessToken).
				when().log().all().
				get("https://rahulshettyacademy.com/getCourse.php").then().assertThat()
			      .body(matchesJsonSchemaInClasspath("event_0.json"));*/
	}
}
