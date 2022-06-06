package ApiTesting;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
	public static JsonPath rawJson(String sResponse) {
		JsonPath js = new JsonPath(sResponse);
		return js;
	}
}
