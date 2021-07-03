package testCasesForPostman;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Deleting_A_Product {
	
	@Test
	public void delete_a_product() {
		//  https://techfios.com/api-prod/api/product/delete.php
		
		String payload_delete_path="\\datas\\deleting_a_product.json";
		
		
		Response response=
				given()
				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type","application/json; charset=UTF-8")
				.body(payload_delete_path)
				.when()
				.delete("/delete.php")
				.then().extract().response();
		
		String responseBody=response.getBody().prettyPrint();
		
		int statuscodefordelete= response.getStatusCode();
		System.out.println("printing_deleting_statuscode :"+statuscodefordelete);
		Assert.assertEquals(statuscodefordelete, 200);
		
		
		long responseTime=response.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("Printing the ResponseTime :"+responseTime);
	}

}
