package testCasesForPostman;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Getting_All_Product {
	
	@Test
	public void reading_All_Product() {
		Response response = given()
				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type", "application/json; charset=UTF-8")
				.when()
				.get("/read.php")
				.then()
				.extract()
				.response();

		String body = response.getBody().prettyPrint();
		System.out.println("responsebody" + body);

	}

}
