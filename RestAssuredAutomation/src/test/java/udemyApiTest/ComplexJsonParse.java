package udemyApiTest;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import groovyjarjarasm.asm.TypeReference;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import udemyApiResource.ReusableMethods;
import udemyApiResource.payload;

public class ComplexJsonParse {

	
	@Test
	public void testNestedResponse()
	{
		String response = payload.nestedReponse();
		JsonPath js = new JsonPath(response);
		System.out.println("value is "+ js.get("problems[0].Diabetes[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0].strength").toString());
	}
	
	
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


	//Object will store all type of value.Convert it to string to print it
	@Test
	public void jsonObjectResponseToMap()
	{
		//below url is simple json object
	//	RestAssured.baseURI="https://run.mocky.io/v3/adffbe1f-5203-4411-8b3c-83f4d92f8a87";	//https://designer.mocky.io/design/confirmation
		Response response = given().baseUri("https://run.mocky.io/v3/adffbe1f-5203-4411-8b3c-83f4d92f8a87")
				.header("Content-Type","application/json")
				.when().
				get("/maps/api/place/nearbysearch/json");

		//generate schema on https://www.liquid-technologies.com/online-json-to-schema-converter
		response.then().body(matchesJsonSchema(new File(System.getProperty("user.dir")+"\\src\\test\\resource\\schemas\\mockTest.json")));

		Map<String,Object> responseInMap  = response.as(new TypeRef<Map<String,Object>>(){});
		System.out.println("hasmap values are :");
		for(Map.Entry<String,Object> s : responseInMap.entrySet())
		{
			System.out.println(s.getKey() + " "+ String.valueOf(s.getValue()));
		}

	}

	@Test
	public void jsonArrayObjectResponseToMap()
	{		
		//Below url is combination of json object and json array of object
		RestAssured.baseURI="https://run.mocky.io/v3/17051430-b230-461f-974c-0a80876478d9";	//https://designer.mocky.io/design/confirmation
		Response response = given().header("Content-Type","application/json")
				.when().
				get("/maps/api/place/nearbysearch/json");
	//	System.out.println("Response is "+ response.asPrettyString());

		//storing json in hasmap.It contains object and array of objects
		Map<String,Object> responseInMap  = response.as(new TypeRef<Map<String,Object>>(){});
		System.out.println("hasmap values are --------------------"+ responseInMap);
			
		for(Map.Entry<String,Object> s : responseInMap.entrySet())
		{
			System.out.println(s.getKey() +  " " + String.valueOf(s.getValue()));
			// work same as above once - System.out.println(s.getKey() +  " " +s.getValue());
		}
		
		//name value is in string format and address value is in int format
		Assert.assertEquals(responseInMap.get("name"), "Divy Jain");
		Assert.assertEquals(responseInMap.get("Address"), 123);


		//storing array of object in list of map.
		List<Map<String,Object>> courseList = (List<Map<String, Object>>) responseInMap.get("Course");
		System.out.println("Array of object is " + courseList);

		for (Map<String, Object> map : courseList) {
			
			for(String key : map.keySet())
			{
				if(map.get(key).equals("100"))
				{
					String expectedTitle =(String) map.get("title");
					System.out.println("expectedTitle is "+ expectedTitle);
					Assert.assertEquals(expectedTitle, "Selenium");
				}
			}
		}

		//Storing nested object in map.
		Map<String,Object> links =(Map<String, Object>) responseInMap.get("links");
		for (String key : links.keySet()) {
			if(links.get(key).equals("gmail"))
			{
				String gmailValue = (String) links.get(key);
				System.out.println("gmailValue is"+ gmailValue);
				Assert.assertEquals(gmailValue, "ddd");	
			}
		}

		for(Map.Entry<String, Object> kv :links.entrySet())
		{
			if(kv.getKey().equals("linkedin"))
			{
				System.out.println("Linkedin value is "+ kv.getValue());
				Assert.assertTrue(String.valueOf(kv.getValue()).equals("aaa"));
				Assert.assertTrue((kv.getValue()).equals("aaa"));

			}

		}
	}

	/* api response
	 * {
    "name": "Divy Jain",
    "Address": 123,
    "Course": [
        {
            "title": "Selenium",
            "price": "100"
        },
        {
            "title": "RestAssured",
            "price": "200"
        }
    ],
    "links": {
        "linkedin": "aaa",
        "twitter": "bbb",
        "gmail": "ddd"
    }
}*/
}
