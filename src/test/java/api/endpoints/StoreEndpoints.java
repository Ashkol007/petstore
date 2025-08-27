package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import api.payloads.Order;
import io.restassured.http.ContentType;

public class StoreEndpoints {
	
	
	public static Response getStore() {
		
		Response response = given()
			     .accept(ContentType.JSON)
			     .when()
			     .get(Routes.getStore_url);
		
		return response; 
				
		
	} 
	
	public static Response postOrder(Order payload) {
		
		Response response = given()
			     .accept(ContentType.JSON)
			     .contentType(ContentType.JSON)
			     .body(payload)
			     .when()
			     .post(Routes.postOrder_url);
		
		return response; 
				
		
	} 

}
