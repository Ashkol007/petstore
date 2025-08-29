package api.tests;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import api.endpoints.PetEndPoints;
import api.payloads.Pet;
import io.restassured.response.Response;

public class PetTests {
	
	private Pet petPayload;
	
	
	@BeforeTest
	public void setup() {
		
	    petPayload = new Pet();
		 // Create category
        Pet.Category category = new Pet.Category();
        category.setId(1);
        category.setName("Dogs");

        // Create tag
        Pet.Tag tag = new Pet.Tag();
        tag.setId(100);
        tag.setName("Bulldog");

        petPayload.setId(12345);
        petPayload.setCategory(category);
        petPayload.setName("Tommy");
        petPayload.setPhotoUrls(Collections.singletonList("http://example.com/photo1"));
        petPayload.setTags(Arrays.asList(tag));
        petPayload.setStatus("available");
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(petPayload);
        System.out.println(json);
	}
	
	
	@Test(priority=1)
	public void postPetImage() {
		

		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\Userdata.xlsx");
		
		Response response = PetEndPoints.postPetImage(file,"MetaData-Required-Important");
		         response.then().log().all();
		         System.out.println(response.jsonPath().getString("message"));
		         System.out.println(response.time());
                                  		         
		         Assert.assertEquals(response.getStatusCode(), 200);
		        
		
		
	}
	
	@Test(priority=2)
	public void postPet() {
		

		
		Response response = PetEndPoints.postPet(petPayload);
		         response.then().log().all();
		         System.out.println(response.jsonPath().getString("message"));
		         System.out.println(response.time());
                                  		         
		         Assert.assertEquals(response.getStatusCode(), 200);
		        
		
		
	}
	
	

}
