package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;


public class DdUserTests {
	
	@Test(priority=1,dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void creatUsers(String userID,String	userName, String FirstName,String lastName,String email,String password,String phone,String status) {
		
		
		User userPayload = new User();
		     
		     userPayload.setId(Integer.parseInt(userID));
		     userPayload.setUsername(userName);
		     userPayload.setFirstName(FirstName);
		     userPayload.setLastName(lastName);
		     userPayload.setEmail(email);
		     userPayload.setPassword(password);
		     userPayload.setPhone(phone);
		     userPayload.setUserStatus(Integer.parseInt(status));
		
		
		Response response = UserEndpoints.createUser(userPayload);
		    	 
		       response.then().log().all();
		       
		       Assert.assertEquals(response.getStatusCode(), 200);
		
		
		}
	
	@Test(priority=2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	public void getUsers(String username) throws InterruptedException {
		
	              Response response = UserEndpoints.getUser(username);
	              
	              response.then().log().all();
	}
	

}
