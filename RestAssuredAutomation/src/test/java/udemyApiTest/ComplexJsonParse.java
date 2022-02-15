package udemyApiTest;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import udemyApiResource.ReusableMethods;
import udemyApiResource.payload;

public class ComplexJsonParse {

	@Test()
	public void testComplexJson()
	{
		String response = payload.complexBookPayload();
		JsonPath js = ReusableMethods.rawToJson(response);

		//print number of courses
		//size method only applible for array
		int count = js.get("courses.size()");
		System.out.println("count of courses are "+ count);

		//print purchse amount
		System.out.println("purchase amount is "+ js.getString("dashboard.purchaseAmount"));

		//print title of first course
		System.out.println("First course title is "+ js.getString("courses[0].title"));

		//print all course title and resp price
		System.out.println("All course title and resp prices are ----");
		for(int i =0;i<count;i++)
		{
			System.out.println("title at index " +i +" is " + js.getString("courses["+i+"].title"));
			System.out.println("price at index " +i +" is " + js.get("courses["+i+"].price"));

		}

		//number of copies fo RPA
		for(int i =0;i<count;i++)
		{
			String courseTitle = js.getString("courses["+i+"].title");
			if(courseTitle.equalsIgnoreCase("RPA"))
			{
				System.out.println("number of copies for courseTitle is " + js.getString("courses["+i+"].copies"));
				break;
			}
		}
		
		
		//total is equal to purchase amount
		int expectedPurchaseAmount = js.getInt("dashboard.purchaseAmount");
		int calcPurchaseAmount = 0;
		for(int i =0;i<count;i++)
		{
			int price =  js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");

			calcPurchaseAmount = calcPurchaseAmount + price*copies;
			
		}
		Assert.assertEquals(calcPurchaseAmount,expectedPurchaseAmount );
		
	}
	
	
	//Object will stro all type of value.Convert it to string to print it
	@Test
	public void dataTypeResponse()
	{
		RestAssured.baseURI="https://run.mocky.io/v3/adffbe1f-5203-4411-8b3c-83f4d92f8a87";	//https://designer.mocky.io/design/confirmation
		Response response = given().header("Content-Type","application/json")
		.when().
		get("/maps/api/place/nearbysearch/json");
		Map<String,Object> responseInMap  = response.as(new TypeRef<Map<String,Object>>(){});
		System.out.println("hasmap values are :");
		for(Map.Entry<String,Object> s : responseInMap.entrySet())
		{
			System.out.println(s.getKey() + " "+ String.valueOf(s.getValue()));
		}
		
	}

}
