package testCasesForPostman;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Updating_A_Product {
	// https://techfios.com/api-prod/api/product/update.php

	String updatepath = ".\\datas\\update_payload.json";

	@Test
	public void update_a_product() {
		Response response = given()
				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type", "application/json; charset=UTF-8")
				.body(new File(updatepath))
				.when()
				.put("/update.php")
				.then().extract().response();

		String response_body = response.getBody().prettyPrint();
	//	System.out.println(response_body);
		
		System.out.println();
		int statuscode=response.getStatusCode();
		System.out.println("Printing the statuscode: " + statuscode);
		Assert.assertEquals(statuscode, 200);
		
		JsonPath jp= new JsonPath(response_body);
		String sucessMessage=jp.getString("message");
		System.out.println("Printing the sucessess Message: "+sucessMessage);
		Assert.assertEquals(sucessMessage, "Product was updated.", "Not matched....");
	}

}
