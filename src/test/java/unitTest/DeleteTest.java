package unitTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteTest {
	
	@Test(enabled = true)//do not pass
	
	public void deleteUsersTest() {
		RestAssured.given()
		.baseUri("https://reqres.in/api/users/2")
		.basePath("/users/2")
		.log().all()
		.delete()
		.then()
		.log().all()
		.statusCode(204);
	}
	

}
