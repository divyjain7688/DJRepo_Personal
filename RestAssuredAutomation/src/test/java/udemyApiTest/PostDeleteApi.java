package udemyApiTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import udemyApiResource.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PostDeleteApi {
	Properties prop = new Properties();

	@BeforeClass
	public void getData() throws IOException
	{
		//FileInputStream fis = new FileInputStream("src\\test\\java\\udemyApiResource\\env.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\udemyApiResource\\env.properties");
		prop.load(fis);
	}

	@Test(invocationCount=5)
	public void postAndDeleteGooglePlace()
	{
		RestAssured.baseURI=prop.getProperty("HOST");
		Response res = given().
				queryParam("key",prop.getProperty("KEY")).and().
				body(payload.getPostPayload()).
				when().
				post(resource.placePostResource()).
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
				body("status",equalTo("OK")).
				extract().response();
		System.out.println("res is "+ res);
		String stringResponse = res.asString();
		System.out.println("String response is "+ stringResponse);
		JsonPath js = new JsonPath(stringResponse);
		String placeId = js.get("place_id");
		System.out.println("place id is "+ placeId);

		Response delResponse=given().
				queryParam("key",prop.getProperty("KEY")).
				body("{" + 
						"\"place_id\": \""+placeId+"\"" + 
						"}").
				when().
				post(resource.placeDeleteResource()).
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().and().
		body("status",equalTo("OK")).extract().response();
		String DeleteResponse = delResponse.asString();
		System.out.println("DeleteResponse is "+ DeleteResponse);
		JsonPath delJs = new JsonPath(DeleteResponse);
		System.out.println("status is "+ delJs.get("status"));
		
		
	}

}
