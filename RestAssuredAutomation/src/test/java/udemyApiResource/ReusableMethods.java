package udemyApiResource;

import static io.restassured.RestAssured.given;
import java.util.Random;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods {
	
	public static XmlPath rawToXml(Response res)
	{
		String stringResponse = res.asString();
		System.out.println("stringResponse is "+ stringResponse);
		XmlPath x= new XmlPath(stringResponse);
		return x;
	}
	
	public static JsonPath rawToJson(Response res)
	{
		String stringResponse = res.asString();
		System.out.println("stringResponse is "+ stringResponse);
		JsonPath j= new JsonPath(stringResponse);
		return j;
	}
	
	public static JsonPath rawToJson(String res)
	{
	//	System.out.println("stringResponse is "+ res);
		JsonPath j= new JsonPath(res);
		return j;
	}
	
	public static String getSessionKey()
	{
		RestAssured.baseURI="http://localhost:8000";
		Response res = given().header("Content-Type","application/json").
		body("{ \"username\": \"divy.0871\", \"password\": \"Qwerty@7\"}").
		when().post("/rest/auth/1/session").then().
		statusCode(200).extract().response();
		JsonPath j = ReusableMethods.rawToJson(res);
		String sessionKey = j.get("session.value");
		System.out.println("session key is "+ sessionKey);
		return sessionKey;
	}
	
	public static SessionFilter getSession()
	{
		SessionFilter session = new SessionFilter();
		RestAssured.baseURI="http://localhost:8000";
		Response res = given().header("Content-Type","application/json").
		body("{ \"username\": \"divy.0871\", \"password\": \"Qwerty@7\"}").
		filter(session).
		when().post("/rest/auth/1/session").then().
		statusCode(200).extract().response();
		JsonPath j = ReusableMethods.rawToJson(res);
		String sessionKey = j.get("session.value");
		System.out.println("session key is "+ sessionKey);
		return session;
	}
		
	public static int randomNumber()
	{
		Random rand = new Random();
		return rand.nextInt(50);
	}
	
}
