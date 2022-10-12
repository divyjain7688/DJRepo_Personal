package udemyApiTest;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import Pojo.P01;
import Pojo.Root;
import io.restassured.response.Response;

public class PojoDesrialization {
	static int counter=0;
	static ArrayList<P01> pod = new ArrayList<P01>();
	Root r = new Root();

//	@Test
	public void jsonObjectResponseToPojo1(ITestContext iTestContext)
	{
		Response response = given().baseUri("https://run.mocky.io/v3/5027e95f-12bc-4882-8f54-d2fde8206bb3")
				.header("Content-Type","application/json")
				.when().
				get("/maps/api/place/nearbysearch/json");
		//		for(int i =0;i<8;i++)
		//		{
		//			r.p01.get(0).setColorCode("test colour "+ i);
		//			System.out.println(r.p01.get(0).getColorCode());
		//		}
			String resTime = String.valueOf(response.getTime());
	//	System.out.println("resTime is -- "+ resTime);
		iTestContext.setAttribute("time", resTime);
		;
		//		long  time = iTestResult.getEndMillis()-iTestResult.getStartMillis();
		//		System.out.println("Res time"+response.getTime()+ "time "+ time );


	}

    @Parameters("param")
	@Test
	public void jsonObjectResponseToPojo2(String status, ITestContext iTestContext)
	{
		Response response = given().baseUri("https://run.mocky.io/v3/5027e95f-12bc-4882-8f54-d2fde8206bb3")
				.header("Content-Type","application/json")
				.when().
				get("/maps/api/place/nearbysearch/json");
		String resTime = String.valueOf(response.getTime());
		//		System.out.println("resTime is -- "+ resTime);
		iTestContext.setAttribute("time", resTime);
		iTestContext.setAttribute("status", status);

		//		long  time = iTestResult.getEndMillis()-iTestResult.getStartMillis();
		//		System.out.println("Res time"+response.getTime()+ "time "+ time );
	}

	@AfterMethod()
	public void fillJsonObjectValues(ITestResult iTestResult,ITestContext iTestContext) throws IOException
	{

		String testName = iTestResult.getMethod().getMethodName();
	//	System.out.println(testName);
	//	long  time = iTestResult.getEndMillis()-iTestResult.getStartMillis();
		Object time =  iTestContext.getAttribute("time");
		Object status =  iTestContext.getAttribute("status");

	//	System.out.println(time.toString());
	//	System.out.println("test case "+ testName +" took " + time.toString());

		P01 p01 = new P01();

		p01.setTestCaseName(testName);
		p01.setResponseTime(String.valueOf(time));
		p01.setStatus(String.valueOf(status));
		p01.setColorCode("Green");

		pod.add(p01);
		System.out.println("size of pod is  "+ pod.size());


		r.setP01(pod);
		//	r.getP01().get(0).setResponseTime(String.valueOf(iTestContext.getAttribute("time")));
//		System.out.println("final--- " + r.getP01().get(counter).getResponseTime());
//		System.out.println("final--- " + r.getP01().get(counter).getTestCaseName());
//		System.out.println("final--- " + r.getP01().get(counter).getColorCode());
//		System.out.println("final--- " + r.getP01().get(counter).getStatus());

	//	counter++;

	}

	@AfterClass
	public void showJson() throws JsonProcessingException
	{
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(r);
		System.out.println("Json value is " + json);
	}

}
