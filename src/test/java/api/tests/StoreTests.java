package api.tests;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndpoints;
import api.payloads.Order;
import io.restassured.response.Response;

public class StoreTests {
	
	Faker faker;
	Order order;
	
	@BeforeTest
	public void setup() {
		
		faker = new Faker();
		order = new Order();
		
		order.setId(faker.number().randomDigit());
		order.setPetId(faker.number().numberBetween(0, 10000));
		order.setQuantity(faker.number().numberBetween(0,1000));
		order.setShipDate(LocalDateTime.now().toString());
		order.setStatus("placed");
		order.setComplete(true);
		
//		order.setId(10);
//		order.setPetId(198772);
//		order.setQuantity(7);
//		order.setShipDate(LocalDateTime.now().toString()); // example: 2025-08-27T14:40:21
//		order.setStatus("placed");
//		order.setComplete(true);
		
		
	}
	
	@Test(priority=1)
	public void getOrders() {
		
		Response response = StoreEndpoints.getStore();
		         response.then().log().all();
		         
		         Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2)
	public void createOrder() {
		
		Response response = StoreEndpoints.postOrder(order);
		         response.then().log().all();
		         response.jsonPath().toString();
		         
		         Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=3)
	public void getOrder() throws InterruptedException {
		
		Response response = StoreEndpoints.getOrder(order.getId());
		         response.then().log().all();
		         response.jsonPath().toString();
		         
		         Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=4)
	public void deleteOrder() throws InterruptedException {
		
		Response response = StoreEndpoints.deleteOrder(order.getId());
		         response.then().log().all();
		         response.jsonPath().toString();
		         
		         Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
