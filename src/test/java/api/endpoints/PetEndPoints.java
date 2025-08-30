package api.endpoints;

import static io.restassured.RestAssured.*;

import java.io.File;

import api.payloads.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {

	
	public static Response postPetImage(File file,String additionalData) {
	
		
		Response response = given()
			     .accept(ContentType.JSON)
			     .contentType("multipart/form-data")
			     .multiPart("additionalMetadata",additionalData)
			     .multiPart("file",file)
			     .when()
			     .post(Routes.postPetImage_url);
		
		return response;
		
	}
	
    public static Response postPet(Pet payload) {
	
		
		Response response = given()
			     .accept(ContentType.JSON)
			     .contentType(ContentType.JSON)
			     .body(payload)
			     .when()
			     .post(Routes.postPet_url);
		
		return response;
		
	}
    
   public static Response putPet(Pet payload) {
	
		
		Response response = given()
			     .accept(ContentType.JSON)
			     .contentType(ContentType.JSON)
			     .body(payload)
			     .when()
			     .put(Routes.putPet_url);
		
		return response;
		
	}
	
	
}
