package udemyApiTest;
import org.testng.annotations.Test;
import Pojo.AddPlace;
import Pojo.Location;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

public class PostGoogleApiSerialization {

	@Test
	public void PostGoogleApi()
	{	
		AddPlace a = new AddPlace();
		a.setAccuracy(50);
		a.setName("Frontline house");
		a.setPhone_number("(02) 9374 4000");
		a.setAddress("48 Pirrama Road, Pyrmont, NSW 2009, Australia");
		a.setWebsite("http://www.google.com");
		a.setLanguage("en-AU");
		List<String> typeList = new ArrayList<String>();
		typeList.add("shoe_store");
		typeList.add("part shoe");
		a.setTypes(typeList);
		Location l = new Location();
		l.setLat(-33.866971);
		l.setLng(151.195875);
		a.setLocation(l);
		RestAssured.baseURI="http://216.10.245.166";
		Response res = given().log().all().
		queryParam("key","qaclick123").and().
		body(a).		//		body(a,ObjectMapperType.JAXB). - to explicitly defined the typ of body
		when().
		post("/maps/api/place/add/json").
		then().log().all().assertThat().statusCode(200).extract().response();
		String resp = res.asString();
		System.out.println("response is "+ resp);

	}
}

/*
{
	"accuracy": 50,
	"name": "Frontline house",
	"phone_number": "(02) 9374 4000",
	"address": "48 Pirrama Road, Pyrmont, NSW 2009, Australia",
	"website": "http://www.google.com",
	"language": "en-AU",
	"location": {
		"lat": -33.866971,
		"lng": 151.195875
	},
	"types": [
	          "shoe_store",
	          "part shoe"
	          ]
}
*/