package api.endpoints;

import static io.restassured.RestAssured.*;

import java.io.File;

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
	
	
}
