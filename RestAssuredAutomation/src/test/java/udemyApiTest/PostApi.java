package udemyApiTest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PostApi {

	@Test
	public void postGooglePlace()
	{		
		RestAssured.baseURI="http://216.10.245.166";
		Response res = given().
		queryParam("key","qaclick123").and().
		body("{"+
				  "\"location\": {"+								//freeformatter .com to 
				    "\"lat\": -33.8669710,"+
				    "\"lng\": 151.1958750"+
				  "},"+
				  "\"accuracy\": 50,"+
				  "\"name\": \"Google Shoes!\","+
				  "\"phone_number\": \"(02) 9374 4000\","+
				  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
				  "\"types\": [\"shoe_store\"],"+
				  "\"website\": \"http://www.google.com.au/\","+
				  "\"language\": \"en-AU\""+
				"}").
		when().
		post("/maps/api/place/add/json").
		then()./*log().all().*/assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK")).extract().response();
		System.out.println("res is "+ res);
		String stringResponse = res.asString();
		System.out.println("stringResponse is "+ stringResponse);
		JsonPath js = new JsonPath(stringResponse);
		System.out.println("json body is " + js);
		String placeId = js.get("place_id");
		System.out.println("place id is "+ placeId);

	}

}
