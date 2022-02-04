package udemyApiTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import udemyApiResource.payload;

public class LibraryApi {

	@Test(dataProvider="libraryBookData")
	public void postAndDeleteBooks(String isbn,String aisle)
	{		
		RestAssured.baseURI="http://216.10.245.166";
		Response res = given().
		header("Content-Type","application/json").
		body(payload.addBook(isbn,aisle)).				//no query and path parameter here.
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).extract().response();
		String strResponse= res.asString();
		System.out.println("create lib response is "+ strResponse);
		JsonPath j = new JsonPath(strResponse);
		System.out.println("created ID is "+ j.get("ID"));
		String Id = j.get("ID");
		
		Response delRes = given().
		header("Content-Type","application/json").
		body(payload.deleteBook(Id)).
		when().
		post("/Library/DeleteBook.php").
		then().assertThat().statusCode(200).and()./*body("Msg", equalTo("successfully added")).*/
		extract().response();
		String strDelResponse= delRes.asString();
		System.out.println("strDelResponse is "+ strDelResponse);		
	}
	
	@DataProvider
	public Object[][] libraryBookData()
	{
		return new Object[][]{{"fsngkn","455"},{"fkjg","6564"},{"fbjn","8784"}};
	}
	
	

	@Test
	public void postBookFromJsonFile() throws IOException
	{		
		RestAssured.baseURI="http://216.10.245.166";
		Response res = given().
		header("Content-Type","application/json").
		body(GenerateStringFromResource(System.getProperty("user.dir") +"\\src\\main\\resources\\payload\\postLibraryBook.json")).
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).extract().response();
		String strResponse= res.asString();
		JsonPath j = new JsonPath(strResponse);
		System.out.println("created ID is "+ j.get("ID"));
		String Id = j.get("ID");
		
		Response delRes = given().
		header("Content-Type","application/json").
		body(payload.deleteBook(Id)).
		when().
		post("/Library/DeleteBook.php").
		then().assertThat().statusCode(200).and()./*body("Msg", equalTo("successfully added")).*/
		extract().response();
		String strDelResponse= delRes.asString();
		System.out.println("strDelResponse is "+ strDelResponse);		
	}
	
	public static String GenerateStringFromResource(String path) throws IOException
	{
		//one way - return new String(Files.readAllBytes(Paths.get(path)));
	    //second way using commonui jar file method
		String jsonContent = FileUtils.readFileToString(new File(path),
			                StandardCharsets.UTF_8);
	    return jsonContent;
	}

	
	
}
