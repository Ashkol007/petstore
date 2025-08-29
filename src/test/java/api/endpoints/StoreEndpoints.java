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
	
    public static Response getOrder(int orderId) throws InterruptedException {
    	
    	
    	Response response = null;
	    for (int i = 0; i < 3; i++) {
	        response = given()
	        		.accept(ContentType.JSON)
				     .contentType(ContentType.JSON)
				     .pathParam("orderId",orderId)
				     .when()
				     .get(Routes.getOrder_url);

	        if (response.getStatusCode() == 200) break;
	        Thread.sleep(1000); // wait 1s before retry
	    }
			     
		return response; 
				
		
	} 
    
    public static Response deleteOrder(int orderId) throws InterruptedException {
    	
    	
    	Response response = null;
	    for (int i = 0; i < 3; i++) {
	    	
	        response = given()
	        		.accept(ContentType.JSON)
				     .contentType(ContentType.JSON)
				     .pathParam("orderId",orderId)
				     .when()
				     .delete(Routes.deleteOrder_url);

	        if (response.getStatusCode() == 200) break;
	        Thread.sleep(1000); // wait 1s before retry
	    }
			     
		return response; 
				
		
	} 

}
