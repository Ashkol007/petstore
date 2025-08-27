package api.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User  userPayload;
	User  userPayload1;
	List<User> userList;
	
	@BeforeClass
	public void setup() {
		
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.number().numberBetween(1, 1000));
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().phoneNumber());
		userPayload.setUsername("user" + faker.number().numberBetween(1000, 9999));
		userPayload.setUserStatus(1); 
		
        userPayload1 = new User();
		
		userPayload.setId(faker.number().numberBetween(1, 1000));
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().phoneNumber());
		userPayload.setUsername("user" + faker.number().numberBetween(1000, 9999));
		userPayload.setUserStatus(1); 
		
		userList = new ArrayList<>();
		userList.add(userPayload);
		userList.add(userPayload1);
		
		
	}
	
	
	@Test(priority=1)
	public void createUser() {
	               System.out.println("userPayload : "+ userPayload.getEmail() +userPayload.getUsername()+userPayload.getFirstName());
		
		Response response = UserEndpoints.createUser(userPayload);
		         response.then().log().all();
		         
		         
		         
		         Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	@Test()
	public void createUsers() {
		
		 
	               System.out.println("userList : "+userList);
		
		Response response = UserEndpoints.createUsers(userList);
		         response.then().log().all();
		         response.jsonPath().toString();
		         
		         
		         Assert.assertEquals(response.getStatusCode(),200);

		
	}
	
	@Test(priority=2)
	public void loginUser(){
		Response response = UserEndpoints.loginUser(userPayload.getUsername(), userPayload.getPassword());
		         response.then().log().all();
		         
		         Assert.assertEquals(response.getStatusCode(), 200);
		         Assert.assertTrue(response.jsonPath().getString("message").contains("logged in user session"));
		         System.out.println("response.jsonPath() : "+response.jsonPath().getString("message"));
	}
	

	@Test(priority=3)
	public void getUser() throws InterruptedException {
	    
		System.out.println("Fetching user with username: " + userPayload.getUsername());

		
		Response response = UserEndpoints.getUser(this.userPayload.getUsername());
		         response.then().log().all();
		         
		         Assert.assertEquals(response.getStatusCode(),200);

Assert.assertEquals(response.jsonPath().getString("username"), userPayload.getUsername());
Assert.assertEquals(response.jsonPath().getString("email"), userPayload.getEmail());
Assert.assertEquals(response.jsonPath().getString("firstName"), userPayload.getFirstName());
		
	}
	
	@Test(priority=4)
	public void updateUser() throws InterruptedException {
		
		userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setUsername(faker.name().username());
        
        Response response = UserEndpoints.updateUser(this.userPayload.getUsername(), userPayload);
                 
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        
        Response afterUpdateResponse = UserEndpoints.getUser(this.userPayload.getUsername());
        Assert.assertEquals(afterUpdateResponse.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=5)
	public void deleteUser() {
		
		Response response = UserEndpoints.deleteUser(this.userPayload.getUsername());
		        Assert.assertEquals(response.getStatusCode(), 200);
	}
	

	@Test(priority=6)
	public void logoutUser() {
		
		Response response = UserEndpoints.logoutUser();
		         response.then().log().all(); 
		        Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	

}
