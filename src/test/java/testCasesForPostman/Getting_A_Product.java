package testCasesForPostman;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Getting_A_Product {
	@Test
	public void getting_One_Product() {
		Response response = given()
				.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json")
					.queryParam("id", "1669")
				.when()
					.get("read_one.php")
				.then()
					.extract().response();

		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		
		//validatating status code.
		int actual_status_code = response.getStatusCode();
		int excepted_status_code = 200;
		Assert.assertEquals(actual_status_code, excepted_status_code, "code didnot match");

	}

}
