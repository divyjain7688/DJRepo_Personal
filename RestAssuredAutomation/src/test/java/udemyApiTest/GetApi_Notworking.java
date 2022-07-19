package udemyApiTest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import udemyApiResource.ReusableMethods;

public class GetApi_Notworking {

	@Test
	public void getFirstGooglePlaceId()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		Response res = given().log().all().
		queryParam("location","-33.8670522,151.1957362").
		param("radius","500").
		param("key","AIzaSyBacM-BRdil_wJ2D4RMapmft8p4kufctDk").
		when().
		get("/maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("results[0].name", equalTo("Sydney")).and().header("Server", equalTo("scaffolding on HTTPServer2")).and().
		header("Content-Type", "application/json; charset=UTF-8").and().extract().response();
		String response = res.asString();
		System.out.println("String format response is "+ response);
		JsonPath j = ReusableMethods.rawToJson(res);
		System.out.println("value of first place id is " + j.get("results[0].place_id"));

	}
	
	
	@Test(invocationCount=1)
	public void getAllGooglePlaceIds()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		Response res = given().
		param("location","-33.8670522,151.1957362").
		param("radius","500").
		param("key","AIzaSyBacM-BRdil_wJ2D4RMapmft8p4kufctDk").
		when().
		get("/maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().and().
		body("results[0].name", equalTo("Sydney")).and().header("Server", "scaffolding on HTTPServer2").and().
		header("Content-Type", "application/json; charset=UTF-8").and().extract().response();
		String response = res.asString();
		System.out.println("String format response is "+ response);
		JsonPath j = ReusableMethods.rawToJson(res);
		System.out.println("value of first place id is " + j.get("results[0].place_id"));
		int resultsCount = j.get("results.size()");
		for(int i=0;i<resultsCount;i++)
		{
		System.out.println(j.get("results["+i+"].name"));
		}

	}

}
