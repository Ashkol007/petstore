package api.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.PetEndPoints;
import io.restassured.response.Response;

public class PetTests {
	
	@Test(priority=1)
	public void postPetImage() {
		

		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Userdata.xlsx");
		
		Response response = PetEndPoints.postPetImage(file,"MetaData-Required-Important");
		         response.then().log().all();
		         System.out.println(response.jsonPath().getString("message"));
		         System.out.println(response.time());
                                  		         
		         Assert.assertEquals(response.getStatusCode(), 200);
		        
		
		
	}
	
	

}
