package udemyApiResource;

public class payload {

	public static String addPlacePayload()
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

	public static String deletePlacePayoad(String placeId)
	{
		String s ="{" + 
				"\"place_id\": \""+placeId+"\"" + 
				"}";

		return s;
	}

	public static String complexBookPayload()
	{
		String s = "{\r\n" + 
				"\r\n" + 
				"\"dashboard\": {\r\n" + 
				"\r\n" + 
				"\"purchaseAmount\": 910,\r\n" + 
				"\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"\"courses\": [\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\r\n" + 
				"\"price\": 50,\r\n" + 
				"\r\n" + 
				"\"copies\": 6\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Cypress\",\r\n" + 
				"\r\n" + 
				"\"price\": 40,\r\n" + 
				"\r\n" + 
				"\"copies\": 4\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"RPA\",\r\n" + 
				"\r\n" + 
				"\"price\": 45,\r\n" + 
				"\r\n" + 
				"\"copies\": 10\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"]\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"";
		return s;
	}
	public static String addBook(String isbn,String aisle)
	{
		String payload = "{\r\n\r\n\"name\":\"Learn Appium Automation with Java\",\r\n\"isbn\":\"" + isbn+"\",\r\n\"aisle\":\""+aisle+"\",\r\n\"author\":\"John foe\"\r\n}\r\n \r\n";
		return payload;
	}

	public static String createIssue(int i )
	{
		String payload = "{"+
				"\"fields\": {"+
				"\"project\":{"+
				"\"key\": \"RSA\""+
				"},"+
				"\"summary\": \"Issue  second\","+
				"\"description\": \"Create my "+i+" bug\","+
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

	public static String testResponse()
	{
		return
				"{\r\n"
				+ "\"name\" : \"Divy\",\r\n"
				+ "\"age\" : 34\r\n"
				+ "}";
	}
	
	
	public static String nestedReponse()
	{
		return "{\r\n"
				+ "  \"problems\": [\r\n"
				+ "    {\r\n"
				+ "      \"Diabetes\": [\r\n"
				+ "        {\r\n"
				+ "          \"medications\": [\r\n"
				+ "            {\r\n"
				+ "              \"medicationsClasses\": [\r\n"
				+ "                {\r\n"
				+ "                  \"className\": [\r\n"
				+ "                    {\r\n"
				+ "                      \"associatedDrug\": [\r\n"
				+ "                        {\r\n"
				+ "                          \"name\": \"asprin\",\r\n"
				+ "                          \"dose\": \"\",\r\n"
				+ "                          \"strength\": \"500\",\r\n"
				+ "                          \"unit\": \"mg\"\r\n"
				+ "                        },\r\n"
				+ "                        {\r\n"
				+ "                          \"name\": \"insulin\",\r\n"
				+ "                          \"dose\": \"\",\r\n"
				+ "                          \"strength\": \"1000\",\r\n"
				+ "                          \"unit\": \"mg\"\r\n"
				+ "                        },\r\n"
				+ "                        {\r\n"
				+ "                          \"name\": \"Biguanides\",\r\n"
				+ "                          \"dose\": \"\",\r\n"
				+ "                          \"strength\": \"1250\",\r\n"
				+ "                          \"unit\": \"mg\"\r\n"
				+ "                        }\r\n"
				+ "                      ],\r\n"
				+ "                      \"associatedDrug#2\": [\r\n"
				+ "                        {\r\n"
				+ "                          \"name\": \"somethingElse\",\r\n"
				+ "                          \"dose\": \"\",\r\n"
				+ "                          \"strength\": \"500\",\r\n"
				+ "                          \"unit\": \"mg\"\r\n"
				+ "                        }\r\n"
				+ "                      ]\r\n"
				+ "                    }\r\n"
				+ "                  ],\r\n"
				+ "                  \"Fever\": [\r\n"
				+ "                    {\r\n"
				+ "                      \"associatedDrug\": [\r\n"
				+ "                        {\r\n"
				+ "                          \"name\": \"asprin\",\r\n"
				+ "                          \"dose\": \"\",\r\n"
				+ "                          \"strength\": \"500\",\r\n"
				+ "                          \"unit\": \"mg\"\r\n"
				+ "                        }\r\n"
				+ "                      ],\r\n"
				+ "                      \"associatedDrug#2\": [\r\n"
				+ "                        {\r\n"
				+ "                          \"name\": \"somethingElse\",\r\n"
				+ "                          \"dose\": \"\",\r\n"
				+ "                          \"strength\": \"500\",\r\n"
				+ "                          \"unit\": \"mg\"\r\n"
				+ "                        }\r\n"
				+ "                      ]\r\n"
				+ "                    }\r\n"
				+ "                  ]\r\n"
				+ "                }\r\n"
				+ "              ]\r\n"
				+ "            }\r\n"
				+ "          ],\r\n"
				+ "          \"labs\": [\r\n"
				+ "            {\r\n"
				+ "              \"missing_field\": \"missing_value\"\r\n"
				+ "            }\r\n"
				+ "          ]\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"Asthma\": [\r\n"
				+ "        {}\r\n"
				+ "      ]\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}
}
