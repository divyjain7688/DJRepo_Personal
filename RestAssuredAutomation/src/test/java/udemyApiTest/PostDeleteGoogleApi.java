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

public class PostDeleteGoogleApi {
	Properties prop = new Properties();

	@BeforeClass
	public void getData() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\udemyApiResource\\env.properties");
		prop.load(fis);
	}

	@Test(invocationCount=1,enabled=true)
	public void postAndDeleteGooglePlace()
	{
		RestAssured.baseURI=prop.getProperty("HOST");

		//POST call
		Response res = given()/*.log().all()*/
				.queryParam("key",prop.getProperty("KEY")).header("Content-Type","application/json")
				.body(payload.addPlacePayload())
				.when()
				.post(resource.placePostResource()).
				then()/*.log().all()*/.assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
				body("status",equalTo("OK")).
				extract().response();				
		System.out.println("res is "+ res);
		String stringResponse = res.asString();
		System.out.println("String response is "+ stringResponse);
		JsonPath js = new JsonPath(stringResponse);
		String placeId = js.get("place_id");
		System.out.println("place id is "+ placeId);

		//GET call with place Id
		Response getResponse = given()/*.log().all()*/
				.queryParam("key", prop.getProperty("KEY"))
				.header("Content-Type","application/json")	//not required for get request
				.queryParam("place_id", placeId)
				.when()
				.get(resource.placeGetResource())
				.then().assertThat().statusCode(200)
				.extract().response();
		JsonPath jsGet = new JsonPath(getResponse.asString());
		String actualAddress = jsGet.getString("address");
		System.out.println("actual Address is "+ actualAddress );

		//Delete call with place Id
		Response delResponse=given().
				queryParam("key",prop.getProperty("KEY")).
				body(payload.deletePlacePayoad(placeId)).
				when().
				post(resource.placeDeleteResource()).
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().and().
				body("status",equalTo("OK")).extract().response();
		String DeleteResponse = delResponse.asString();
		System.out.println("DeleteResponse is "+ DeleteResponse);
		JsonPath delJs = new JsonPath(DeleteResponse);
		System.out.println("status is "+ delJs.get("status"));


		//GET call with place Id
		getResponse = given()/*.log().all()*/
				.queryParam("key", prop.getProperty("KEY"))
				.header("Content-Type","application/json")	//not required for get request
				.queryParam("place_id", placeId)
				.when()
				.get(resource.placeGetResource())
				.then().assertThat().statusCode(404)
				.body("place_id", equalTo(null))
				.extract().response();
		jsGet = new JsonPath(getResponse.asString());
		actualAddress = jsGet.getString("address");
		System.out.println("actual Address is "+ actualAddress );
		

	}

}
