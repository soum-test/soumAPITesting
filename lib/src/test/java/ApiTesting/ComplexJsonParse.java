package ApiTesting;

//import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import resourceFiles.Payload;

public class ComplexJsonParse {
	
	@Test
	public static void complexJsonValidation() {
		JsonPath js = new JsonPath(Payload.coursePrice());
		int totalCoursesAvailable = js.getInt("courses.size()");
		
		System.out.println("Total Courses available: " + totalCoursesAvailable);
		
		int iPurchaseAmount = js.getInt("dashboard.purchaseAmount");
		
		System.out.println("Purchase amount for all courses: " + iPurchaseAmount);
		
		String sTitle = js.get("courses[0].title");
		
		System.out.print("Titlte of the First Course: " + sTitle);
		
		System.out.println("Details of existing courses: ");
		
		System.out.println();
		System.out.println();
		
		for(int i=0; i<js.getInt("courses.size()"); i++) {
			
			System.out.println("Title:" + js.getString("courses["+i+"].title"));
			System.out.println("Price:" + js.getInt("courses["+i+"].price"));
			System.out.println("No. of copies:" + js.getInt("courses["+i+"].copies"));
			
			System.out.println();
			System.out.println();
		}
		
		for(int i=0; i<totalCoursesAvailable; i++) {
			
			if(js.getString("courses["+i+"].title").equals("RPA")) {
				System.out.println("No. of copies sold By RPA Course:" + js.getInt("courses["+i+"].copies"));
			
				System.out.println();
				System.out.println();
				break;
			}
		}
		
		int iTotalCost=0;
		for(int i=0; i<totalCoursesAvailable; i++) {
			
		
			iTotalCost+=js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies");
			
		}
		
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(iPurchaseAmount, iTotalCost);
		System.out.println( "Assertion successful");
		
		
		sa.assertAll();

	}

}
