package unitTest;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {
	@Test(enabled = false)
	public void getUsersListPreetyPrint() {
		RestAssured.get("https://reqres.in/api/users?page=2").prettyPrint();
	}

	@Test(enabled = false)
	public void getUserList() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());

	}

	@Test(enabled = false)
	public void getUsersListResponseCodeValidation() {
		RestAssured.get("https://reqres.in/api/users?page=2/id/10")
		.then()
		.statusCode(200);

	}

	@Test(enabled = false)
	public void getUsersListResponseCodeValidationNegetiveTest() {
		RestAssured.get("https://reqres.in/api/users?page=2/id/10")
		.then()
		.statusCode(201);
	}

	@Test(enabled = false)
	public void getUsersListLogs() {
		RestAssured.given().log().all()
		.get("https://reqres.in/api/users?page=2/id/10")
		.then()
		.log().all()
		.statusCode(200);

	}
	@Test(enabled = false)
	public void getUsersListResponseValidation() {
		RestAssured.given().log().all()
		.get("https://reqres.in/api/id/12")
		.then()
		.log().all()
		.statusCode(200);
	}
	
	@Test(enabled = true)// Do not pass
	public void getUsersListResponseValidation1() {
		RestAssured.given()
		.log().all()
		.get("https://reqres.in/api/9")
		.then()
		.log().all()
		.statusCode(200)
		.and()
		.body("data[1].id",equalTo(2));
		//.body("firstName",equalTo("Tobies"))
		//.body("lastName", equalTo("Funke"));
		
		
}
	@Test(enabled = true)// Do not pass
	public void getUsersListResponseValidation2() {
		RestAssured.given()
		.log().all()
		.get("https://reqres.in/api/users/9")
		.then()
		.log().all()
		.statusCode(200)
		.and()
		.body("data.id",equalTo(9))
		.body("data.first_name",equalTo("Tobias"))
		.body("data.last_name", equalTo("Funke"));
		
		
}
	}


