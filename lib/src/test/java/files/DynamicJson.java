package files;

import org.testng.annotations.Test;

import ApiTesting.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resourceFiles.Payload;

import static io.restassured.RestAssured.*;

public class DynamicJson {

		
	@Test
	public void addBook() {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given().log().all().header("Content-Type", "application/json")
			.body(Payload.addBook())
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReusableMethods.rawJson(response);
		
		System.out.println(js.getString("ID"));
		
	}
}
