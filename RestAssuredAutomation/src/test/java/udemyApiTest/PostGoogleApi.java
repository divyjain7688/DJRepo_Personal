package udemyApiTest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import udemyApiResource.payload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class PostGoogleApi {

	@Test(enabled=true)
	public void postGooglePlace()
	{		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response res = given().log().all().
				queryParam("key","qaclick123").header("Content-Type","application/json").
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
				then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.body("status",equalTo("OK")).and().body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.18 (Ubuntu)")
				.extract().response();					//equalTo comes from hamcrest package
		System.out.println("res is "+ res);
		String stringResponse = res.asString();
		System.out.println("stringResponse is "+ stringResponse);
		JsonPath js = new JsonPath(stringResponse);
		System.out.println("json body is " + js);
		String placeId = js.get("place_id");
		System.out.println("place id is "+ placeId);

	}

	@Test(enabled=true)
	public void postGooglePlaceFromGetPayloadBoby()
	{		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response res = given().log().all().
				queryParam("key","qaclick123").header("Content-Type","application/json").
				body(payload.addPlacePayload()).
				when().
				post("/maps/api/place/add/json").
				then()/*.log().all()*/.assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.body("status",equalTo("OK")).and().body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.18 (Ubuntu)")
				.extract().response();					//equalTo comes from hamcrest package
		System.out.println("res is "+ res);
		String stringResponse = res.asString();
		System.out.println("stringResponse is "+ stringResponse);
		JsonPath js = new JsonPath(stringResponse);	//for parsing json
		System.out.println("json body is " + js);
		String placeId = js.get("place_id");
		System.out.println("place id is "+ placeId);
		String placeIdS = js.getString("place_id");
		System.out.println("place id string is "+ placeIdS);

	}

}
