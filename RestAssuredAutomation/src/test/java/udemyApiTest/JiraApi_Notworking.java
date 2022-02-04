package udemyApiTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.response.Response;
import udemyApiResource.ReusableMethods;
import udemyApiResource.payload;

public class JiraApi_Notworking {

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
				body(payload.createIssue(ReusableMethods.randomNumber())).
				when().post("/rest/api/2/issue").then().
				statusCode(201).extract().response();	
		JsonPath j = ReusableMethods.rawToJson(createIssueResponse);
		String id = j.get("id");
		System.out.println("id of issue is "+ id );
	}

	@Test()

	public void createIssueWithSession()
	{
		SessionFilter session = new SessionFilter();

		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		given().header("Content-Type","application/json").
		body("{ \"username\": \"divy.0871\", \"password\": \"Qwerty@7\"}").
		filter(session)	//filter listen to the response
		.when().post("/rest/auth/1/session").then().
		statusCode(200).extract().response();

		Response createIssueResponse = given().header("Content-Type","application/json").
				body(payload.createIssue(ReusableMethods.randomNumber())).
				filter(session).
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
				body(payload.createIssue(ReusableMethods.randomNumber())).
				when().post("/rest/api/2/issue").then().
				statusCode(201).extract().response();	
		JsonPath j = ReusableMethods.rawToJson(createIssueResponse);
		String id = j.get("id");
		System.out.println("id of issue is "+ id );

		Response deleteIssueResponse = given().log().all().header("Content-Type","application/json").
				header("Cookie","JSESSIONID="+sessionKey+"").
				pathParam("issueIdOrKey", ""+id+"").
				when().delete("/rest/api/2/issue/{issueIdOrKey}").then().
				statusCode(204).extract().response();	
		System.out.println("Delete issue  is " + deleteIssueResponse.asString());

	}


	@Test
	public void createIssueAndAddUpdateComment()
	{

		//	String sessionKey = ReusableMethods.getSessionKey();
		SessionFilter session = ReusableMethods.getSession();

		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		Response createIssueResponse = given().header("Content-Type","application/json").
				//		header("Cookie","JSESSIONID="+sessionKey+"").
				body(payload.createIssue(ReusableMethods.randomNumber())).
				filter(session).		//listen response
				when().post("/rest/api/2/issue").then().
				statusCode(201).extract().response();	
		JsonPath j = ReusableMethods.rawToJson(createIssueResponse);
		String id = j.get("id");
		System.out.println("id of issue is "+ id );

		Response createommentResponse = given().header("Content-Type","application/json").
				//	header("Cookie","JSESSIONID="+sessionKey+"").
				pathParam("issueIdOrKey", ""+id+"").
				body(payload.createComment()).
				filter(session).
				when().post("/rest/api/2/issue/{issueIdOrKey}/comment").then().
				statusCode(201).extract().response();
		String createommentRes = createommentResponse.asString();
		System.out.println("createommentRes is" + createommentRes);
		JsonPath js = new JsonPath(createommentRes);
		String cid = js.get("id");

		Response updateCommentResponse = given().header("Content-Type","application/json").
				//	header("Cookie","JSESSIONID="+sessionKey+"").
				pathParam("issueIdOrKey", ""+id+"").
				pathParam("id", ""+cid+"").
				body(payload.updateComment()).
				filter(session).
				when().put("/rest/api/2/issue/{issueIdOrKey}/comment/{id}").then().
				statusCode(200).extract().response();
		String updateCommentRes = updateCommentResponse.asString();
		System.out.println("updateCommentRes is "+ updateCommentRes);


	}



	@Test
	public void createIssueAndAddCommentAddAttachment()
	{

		//String sessionKey = ReusableMethods.getSessionKey();
		SessionFilter session = ReusableMethods.getSession();

		//create issue
		RestAssured.baseURI=prop.getProperty("JIRAHOST");
		Response createIssueResponse = given().log().all().header("Content-Type","application/json").
				//header("Cookie","JSESSIONID="+sessionKey+"").
				body(payload.createIssue(ReusableMethods.randomNumber())).
				filter(session).		//listen response
				when().post("/rest/api/2/issue").then().log().all().
				statusCode(201).extract().response();	
		JsonPath j = ReusableMethods.rawToJson(createIssueResponse);
		String id = j.get("id");
		System.out.println("id of issue is "+ id );

		//add comment in issue
		Response createommentResponse = given().log().all().header("Content-Type","application/json").
				//	header("Cookie","JSESSIONID="+sessionKey+"").
				pathParam("issueIdOrKey", ""+id+"").
				body(payload.createComment()).
				filter(session).
				when().post("/rest/api/2/issue/{issueIdOrKey}/comment").then().log().all().
				statusCode(201).extract().response();
		String createommentRes = createommentResponse.asString();
		System.out.println("createommentRes is" + createommentRes);
		JsonPath js = new JsonPath(createommentRes);
		String cid = js.get("id");
		System.out.println("id of issue is "+ id + " comment in it is "+ cid );

		//add attchment in issue
		given().log().all().filter(session).
		header("Content-Type","multipart/form-data").header("X-Atlassian-Token","no-check").
		multiPart("file",new File("jira.txt"))
		.pathParam("issueIdOrKey", id)
		.when().post("/rest/api/2/issue/{issueIdOrKey}/attachments")
		.then().log().all().assertThat().statusCode(200);

		//fetch issue
		String issueGetReponse = given().log().all().filter(session).
				pathParam("issueIdOrKey", id)
				.queryParam("fields", "comment,attachment")
				.when().get("/rest/api/2/issue/{issueIdOrKey}").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("issueGetReponse is "+ issueGetReponse);
		
		JsonPath jsGet = ReusableMethods.rawToJson(issueGetReponse);
		String attachmentName = jsGet.getString("fields.attachment.filename");
		System.out.println("attachmentName is "+ attachmentName);

	}
}
