package unitTest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostTest {
	@Test(enabled = false)
	public void postUsersTestStringBody() {
		RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		.basePath("/users")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
		
		
		}
	@Test(enabled = false)//Do not pass
	public void postUsersTestFileBody500() {
		RestAssured.given()
		.baseUri("https://reqres.in")
		.contentType(ContentType.JSON)
		.body(new File("src/test/resources/user.json"))
		.basePath("/api/users")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(500);
	}
	@Test(enabled = false)
	public void postUsersTestInputStrimBody() {
		RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("user.json"))
		.basePath("/users")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
	@Test(enabled = false)
	public void postUsersTestByteBody() {
		try {
			RestAssured.given()
			.baseUri("https://reqres.in/api/users")
			.contentType(ContentType.JSON)
			.body(getClass().getClassLoader().getResourceAsStream("user.json").readAllBytes())
			.basePath("/users")
			.when()
			.log().all()
			.post()
			.then()
			.log().all()
			.statusCode(201);
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	@Test(enabled = true)
	public void postUsersTestMapBody() {
		Map<String,String>map = new HashMap<>();
		map.put("firstName", "Mahmuda");
		map.put("lastName", "Arif");
		map.put("DOB", "02/01/1982");
		map.put("zipcode", "10461");
		
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
