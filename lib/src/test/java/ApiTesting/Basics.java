package ApiTesting;
import io.restassured.RestAssured;

import org.testng.Assert;
import resourceFiles.Payload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

	public static void main(String[] args) {
		//Validate if Add place API is working as expected
		
		/*	Given - All Input details,
			When - Submit the API request with Resource and HTTP method (Get, Post etc.)
			Then - validate the response
		*/
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String postResponse= given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.addPlaceJson())
		
		.when().post("/maps/api/place/add/json")
		
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		
		String placeId= ReusableMethods.rawJson(postResponse).getString("place_id");
		System.out.println(placeId);
		
		//Update Place
		String sNewAddress = "378 Neeldari rd";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+sNewAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//get place Api
		
		String getResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().body().asString();
		
//		JsonPath jsGet = new JsonPath(getResponse);
		String sActualAddress = ReusableMethods.rawJson(getResponse).getString("address");
		System.out.println("New: " + sNewAddress);
		System.out.println("Actual: " + sActualAddress);
		Assert.assertEquals(sActualAddress, sNewAddress);
	}

}
