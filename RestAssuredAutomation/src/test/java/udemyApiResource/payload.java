package udemyApiResource;

public class payload {
	
	public static String getPostPayload()
	{
		String s = "{"+
			"\"location\": {"+
			"\"lat\": -33.8669710,"+
			"\"lng\": 151.1958750"+
			"},"+
			"\"accuracy\": 50,"+
			"\"name\": \"Google Shoes!\","+
			"\"phone_number\": \"(02) 9374 4000\","+
			"\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
			"\"types\": [\"shoe_store\"],"+
			"\"website\": \"http://www.google.com.au/\","+
			"\"language\": \"en-AU\""+
			"}";
		return s;
	}
	
	public static String addBook(String isbn,String aisle)
	{
		String payload = "{\r\n\r\n\"name\":\"Learn Appium Automation with Java\",\r\n\"isbn\":\"" + isbn+"\",\r\n\"aisle\":\""+aisle+"\",\r\n\"author\":\"John foe\"\r\n}\r\n \r\n";
		return payload;
	}
	
	public static String createIssue()
	{
		String payload = "{"+
			    "\"fields\": {"+
			       "\"project\":{"+
			          "\"key\": \"RES\""+
			       "},"+
			       "\"summary\": \"Issue  second\","+
			       "\"description\": \"Create my second bug\","+
			       "\"issuetype\": {"+
			          "\"name\": \"Bug\""+
			       "}"+
			   "}}"
;
		return payload;
	}
	
	
	public static String createComment()
	{
		String payload = "{ \"body\": \"djain adding comment from the automation code\","+
			    "\"visibility\": {"+
		        "\"type\": \"role\","+
		        "\"value\": \"Administrators\" }"+
		"}";
		return payload;
	}
	
	public static String updateComment()
	{
		String payload = "{ \"body\": \"djain again updating  comment from the automation code\","+
			    "\"visibility\": {"+
		        "\"type\": \"role\","+
		        "\"value\": \"Administrators\" }"+
		"}";
		return payload;
	}
	
	public static String deleteBook(String id)
	{
		String payload = "{\r\n \r\n\"ID\" : \""+id+ "\"\r\n \r\n}\r\n";
		return payload;
	}
}
