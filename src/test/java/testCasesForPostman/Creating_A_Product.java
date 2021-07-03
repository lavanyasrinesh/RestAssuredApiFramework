package testCasesForPostman;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Creating_A_Product {
	
	@Test
	public void create_A_Product() {

		//creation path		https://techfios.com/api-prod/api/product/create.php
		
		String payload_Path = ".\\datas\\create_a_payload.json";

		Response response = given().baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type", "application/json; charset=UTF-8")
				.body(new File(payload_Path))
				.when()
				.post("/create.php")
				.then().extract().response();

		long actual_time = response.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("ActualTime: " + actual_time);

		// validating response time from Response
		
		int  StatusCode=response.getStatusCode();
		System.out.println(StatusCode);
		String responseBody = response.getBody().asString();
		System.out.println("Output_From_Response: " + responseBody);

	}
}
