package getApi;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import apiConfigs.Apipath;
import apiVerfications.ApiVerification;
import baseTest.Basetest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.dynamicJsonValidation;

public class getUsers extends Basetest {
	
	
	
	@Test
	public void getListOfUsers() {
		extentTest.log(Status.INFO, "Test Started : GET nested json");
		Response res = RestAssured.given().when().get(Apipath.apipath.GET_NESTED_JSON);
		ApiVerification.responseCodeValidation(res, 200);
		ApiVerification.responseTimeValidation(res);
		//ApiVerification.resposeKeyValidationfromArray(res, "Store_Name");
		extentTest.log(Status.INFO, "Response Body is: "+ res.getBody().asPrettyString());
		extentTest.log(Status.INFO, "Test ended : GET List of Orders");
		
		JSONObject obj = new JSONObject(res.getBody().asString());
		dynamicJsonValidation.dynamicJsonKeyValidation(obj, "number");
		
				
}
}
	