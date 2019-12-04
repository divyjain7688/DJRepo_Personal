package udemyApiTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.response.Response;
import udemyApiResource.ReusableMethods;
import udemyApiResource.payload;

public class JiraApi {

	Properties prop = new Properties();
	@BeforeClass
	public void getData() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\udemyApiResource\\env.properties");
		prop.load(fis);
	}

	@Test()

	public void createIssue()
	{
		String sessionKey = ReusableMethods.getSessionKey();
		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		Response createIssueResponse = given().header("Content-Type","application/json").
				header("Cookie","JSESSIONID="+sessionKey+"").
				body(payload.createIssue()).
				when().post("/rest/api/2/issue").then().
				statusCode(201).extract().response();	
		JsonPath j = ReusableMethods.rawToJson(createIssueResponse);
		String id = j.get("id");
		System.out.println("id of issue is "+ id );
	}

	@Test
	public void createAndDeleteIssue(){

		String sessionKey = ReusableMethods.getSessionKey();
		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		Response createIssueResponse = given().header("Content-Type","application/json").
				header("Cookie","JSESSIONID="+sessionKey+"").
				body(payload.createIssue()).
				when().post("/rest/api/2/issue").then().
				statusCode(201).extract().response();	
		JsonPath j = ReusableMethods.rawToJson(createIssueResponse);
		String id = j.get("id");
		System.out.println("id of issue is "+ id );
		Response deleteIssueResponse = given().header("Content-Type","application/json").
				header("Cookie","JSESSIONID="+sessionKey+"").
				pathParam("issueIdOrKey", ""+id+"").
				when().delete("/rest/api/2/issue/{issueIdOrKey}").then().
				statusCode(204).extract().response();	

	}


	@Test
	public void createIssueAndAddUpdateComment()
	{
		String sessionKey = ReusableMethods.getSessionKey();
		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		Response createIssueResponse = given().header("Content-Type","application/json").
				header("Cookie","JSESSIONID="+sessionKey+"").
				body(payload.createIssue()).
				when().post("/rest/api/2/issue").then().
				statusCode(201).extract().response();	
		JsonPath j = ReusableMethods.rawToJson(createIssueResponse);
		String id = j.get("id");
		System.out.println("id of issue is "+ id );

		Response createommentResponse = given().header("Content-Type","application/json").
				header("Cookie","JSESSIONID="+sessionKey+"").
				pathParam("issueIdOrKey", ""+id+"").
				body(payload.createComment()).
				when().post("/rest/api/2/issue/{issueIdOrKey}/comment").then().
				statusCode(201).extract().response();
		String createommentRes = createommentResponse.asString();
		System.out.println("createommentRes is" + createommentRes);
		JsonPath js = new JsonPath(createommentRes);
		String cid = js.get("id");

		Response updateCommentResponse = given().header("Content-Type","application/json").
				header("Cookie","JSESSIONID="+sessionKey+"").
				pathParam("issueIdOrKey", ""+id+"").
				pathParam("id", ""+cid+"").
				body(payload.updateComment()).
				when().put("/rest/api/2/issue/{issueIdOrKey}/comment/{id}").then().
				statusCode(200).extract().response();
		String updateCommentRes = updateCommentResponse.asString();
		System.out.println("updateCommentRes is "+ updateCommentRes);


	}
}
