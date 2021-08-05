package hardcodeApproach;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GETRequest {
	
	@Test
	public void getWeatherDetails()
	{
		//Specify Base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		//print response
		String responseBody = response.getBody().asString();
		System.out.println("Response body is " + responseBody);
		
		int statusCode = response.statusCode();
		System.out.println("statusCode is " + statusCode);
		
		String statusLine = response.getStatusLine();
		System.out.println("statusLine is " + statusLine);
		
	}

	
	@Test
	public void googleApiTest()
	{
		//Specify Base URI
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//print response
		String responseBody = response.getBody().asString();
		System.out.println("Response body is " + responseBody);
		
		int statusCode = response.statusCode();
		System.out.println("statusCode is " + statusCode);
		
		String statusLine = response.getStatusLine();
		System.out.println("statusLine is " + statusLine);
		
		Headers headers = response.getHeaders();
		System.out.println("headers are "+ headers);
		
		System.out.println("headersss are");
		for(Header header : headers)
		{
			System.out.println(header.getName() + " "+header.getValue());
		}
		
		String contentType = response.header("Content-Type");
		System.out.println("contentType is "+ contentType);
		Assert.assertEquals("application/xml; charset=UTF-8", contentType);
		
	}

	
	@Test
	public void validatingJsonResponse()
	{
		//Specify Base URI
				RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
				
				//Request Object
				RequestSpecification httpRequest = RestAssured.given();
				
				//Response Object
				Response response = httpRequest.request(Method.GET,"/Hyderabad");
				
				//print response
				String responseBody = response.getBody().asString();
				System.out.println("Response body is " + responseBody);
				
				Assert.assertTrue(responseBody.contains("Hyderabad"));
				JsonPath jsonpath = response.jsonPath();
				System.out.println("City is "+ jsonpath.get("City"));
		
	}
	
	@Test
	public void getApiWithAuthentication()
	{
		//Specify Base URI
				RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
				
				//Basic authentication
				PreemptiveBasicAuthScheme preemptiveBasicAuthScheme = new PreemptiveBasicAuthScheme();
				preemptiveBasicAuthScheme.setUserName("ToolsQA");
				preemptiveBasicAuthScheme.setPassword("TestPassword");
				RestAssured.authentication=preemptiveBasicAuthScheme;
				
				//Request Object
				RequestSpecification httpRequest = RestAssured.given();
				
				//Response Object
				Response response = httpRequest.request(Method.GET,"/");
				
				//print response
				String responseBody = response.getBody().asString();
				System.out.println("Response body is " + responseBody);
				
				Assert.assertTrue(responseBody.contains("Basic"));
				JsonPath jsonpath = response.jsonPath();
				System.out.println("FaultId is "+ jsonpath.get("FaultId"));
				Assert.assertEquals("OPERATION_SUCCESS", jsonpath.get("FaultId"));

		
	}

}
