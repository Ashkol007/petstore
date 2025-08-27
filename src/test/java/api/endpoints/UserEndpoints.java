package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.List;

import api.payloads.User;
import io.restassured.http.ContentType;

public class UserEndpoints {
	
	public static Response createUser(User payload) {
		
		Response response = given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
         .body(payload)		
 		.when()
 		 .post(Routes.post_url);
		
		return response;
		
	}
	
   public static Response createUsers(List<User> payload) {
		
		Response response = given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
         .body(payload)		
 		.when()
 		 .post(Routes.postUsers_url);
		
		return response;
		
	}
	
     public static Response getUser(String username) throws InterruptedException {
		
    	 Response response = null;
    	    for (int i = 0; i < 3; i++) {
    	        response = given()
    	            .pathParam("username", username)
    	            .when()
    	            .get(Routes.get_url);

    	        if (response.getStatusCode() == 200) break;
    	        Thread.sleep(1000); // wait 1s before retry
    	    }
		
		return response;
		
	}

      public static Response updateUser(String username,User payload) {
	
	Response response = given()
	 .contentType(ContentType.JSON)
	 .accept(ContentType.JSON)
	 .pathParam("username", username)
     .body(payload)		
		.when()
		 .put(Routes.update_url);
	
	return response;
	
       }   
      
      public static Response deleteUser(String username) {
  		
  		Response response = given()
  		 .pathParam("username",username)
   		.when()
   		 .delete(Routes.delete_url);
  		
  		return response;
  		
  	}
      
      public static Response loginUser(String username,String password) {
    		
    		Response response = given()
    		 .queryParam("username",username)
    		 .queryParam("password", password)
    		 .accept(ContentType.JSON)
     		.when()
     		 .get(Routes.login_url);
    		
    		return response;
    		
    	}
      
      public static Response logoutUser() {
  		
  		Response response = given()
  		 .accept(ContentType.JSON)
   		.when()
   		 .get(Routes.logout_url);
  		
  		return response;
  		
  	}
      
      
	

}
