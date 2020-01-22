package udemyApiTest;
import org.testng.annotations.Test;

import Pojo.AddPlace;
import Pojo.Location;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

public class PostGoogleApiSerializationWithSpecBuilders {

	@Test
	public void PostGoogleApiSerialization()
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
		
		RequestSpecification req =  new RequestSpecBuilder().setBaseUri("http://216.10.245.166").
		addQueryParam("key","qaclick123").
		setContentType(ContentType.JSON).build();	
		ResponseSpecification resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification res=given().spec(req)
		.body(a);
		Response response =res.when().post("/maps/api/place/add/json").
		then().spec(resspec).extract().response();
		String responseString=response.asString();
		System.out.println(responseString);


	}
}