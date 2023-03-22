package unitTest;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutTest {
	@Test(enabled = true)
	public void putUserTest() {
	Map<String,String>map = new HashMap<>();
	map.put("firstName", "Tasnia");
	map.put("lastName", "Moumita");
	map.put("DOB", "21/09/2009");
	map.put("zipcode", "10462");
	
	RestAssured.given()
	.baseUri("https://reqres.in/api/users")
	.contentType(ContentType.JSON)
	.body(map)
	.basePath("/users")
	.when()
	.log().all()
	.post()
	.then()
	.log().all()
	.statusCode(201);

	}
}


