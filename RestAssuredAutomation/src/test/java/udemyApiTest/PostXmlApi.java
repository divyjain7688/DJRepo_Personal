package udemyApiTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import udemyApiResource.ReusableMethods;


public class PostXmlApi {

	@Test
	public void postXmlData() throws IOException
	{
		System.out.println("path is "+ System.getProperty("user.dir"));
		String postData = GenerateStringFromResource("C:\\Java selenium projects\\RestAssuredUdemy\\RestAssuredAutomation\\src\\main\\resources\\payload\\postGooglePlacedata.xml");
		RestAssured.baseURI="http://216.10.245.166";
		Response res = given().
				queryParam("key","qaclick123").and().
				body(postData).
				when().
				post("/maps/api/place/add/xml").
				then().assertThat().statusCode(200).and().contentType(ContentType.XML).and().
				body("status",equalTo("OK")).extract().response();
		System.out.println("res is "+ res);
		XmlPath x= ReusableMethods.rawToXml(res);
		System.out.println(x.get("PlaceAddResponse.place_id"));
		
	}

	public static String GenerateStringFromResource(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));

	}

}
