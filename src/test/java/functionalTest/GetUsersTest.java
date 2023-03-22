package functionalTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.Users;

public class GetUsersTest {
	Users users;
	
		@BeforeMethod
		public void initTest() {
			users= new Users();
			users.init();
			
		}
		
		@Test(enabled = false)
		public void getUsersValidation() {
			users.getUsers();
			users.validateStatusCode(200);
		}
		
		@Test(enabled = true)
		public void getUsersById() {
		users.getEachUsers(9);
		users.validatePayloadObject("first_name", "Bobias");
		users.validatePayloadObject("last_name", "Punke");
		//users.validatePayloadObject("DOB", "02/01/1982");
		//users.validatePayloadObject("zipCode","10461");
			
		}
		
		@Test(enabled = false)
		public void responseValidation() {
			users.getEachUsers(2);
			System.out.println(users.getResponse().getBody().jsonPath().getString("name"));
		
	}

}
