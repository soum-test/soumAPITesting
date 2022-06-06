package resourceFiles;

public class Payload {
	 
	public static String addPlaceJson() {
		return "{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 50,\r\n"
				+ "    \"name\": \"Lakshmi Nilayam\",\r\n"
				+ "    \"phone_number\": \"(+91) 2355326232\",\r\n"
				+ "    \"address\": \"12th cross Neeladri Rd.\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"Aprtments\",\r\n"
				+ "        \"Home\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"www.samoui.com\",\r\n"
				+ "    \"language\": \"English-IN\"\r\n"
				+ "}";
	}
	
	public static String coursePrice() {
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 910,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}
	
	public static String addBook() {
		return "{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\"bcd\",\r\n"
				+ "\"aisle\":\"292527826\",\r\n"
				+ "\"author\":\"John foer\"\r\n"
				+ "}";
	}
	
}
