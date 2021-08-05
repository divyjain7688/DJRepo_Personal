package hardcodeApproach;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTRequest {
	
	@Test
	public void RegistrationSuccessful()
	{
		//Specify Base URI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request payload and header for post request
		JSONObject requestParameter = new JSONObject();
		requestParameter.put("FirstName", "charlie");
		requestParameter.put("LastName", "hanes");
		requestParameter.put("UserName", "chanes");
		requestParameter.put("Password", "test");
		requestParameter.put("Email", "tes@gmail.com");
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParameter.toJSONString());
		
		//Response Object
		Response response = httpRequest.request(Method.POST,"/register");
		
		//print response
		String responseBody = response.getBody().asString();
		System.out.println("Response body is " + responseBody);

		/*int statusCode = response.statusCode();
		System.out.println("statusCode is " + statusCode);
		Assert.assertEquals(201, statusCode);

		String SuccessCode = response.jsonPath().get("SuccessCode");
		System.out.println("SuccessCode is "+ SuccessCode);
		Assert.assertEquals("OPERATION_SUCCESS",SuccessCode);*/

		
		
	}

}
