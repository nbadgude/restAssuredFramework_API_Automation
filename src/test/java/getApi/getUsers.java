package getApi;

import apiChecks.JsonDataValidation;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import apiConfigs.ApiEndPoints;
import apiChecks.ApiValidations;
import baseTest.Basetest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getUsers extends Basetest {
	
	
	@Test(enabled = true)
	public static  void getListOfUsers() {
		extentTest.log(Status.INFO, "Test Started : GET nested json");
		Response res = RestAssured.given().when().get(ApiEndPoints.apipath.GET_LIST_OF_USERS);
		ApiValidations.responseCodeValidation(res, 200);
		ApiValidations.responseTimeValidation(res);
		//ApiVerification.resposeKeyValidationfromArray(res, "Store_Name");
		extentTest.log(Status.INFO, "Response Body is: "+ res.getBody().asPrettyString());
		extentTest.log(Status.INFO, "Test ended : GET List of Orders");
		JsonDataValidation.JsonDataValidation(res, "number");

}

	@Test(enabled = false)
	public static void getSingleUser(){
		extentTest.log(Status.INFO, "Test Started : GET Single user");

		Response res =  RestAssured.given().log().all().pathParam("userIndex", "1").when().get(ApiEndPoints.apipath.GET_SINGLE_USER);
		ApiValidations.responseCodeValidation(res, 200);
		ApiValidations.responseTimeValidation(res);
		extentTest.log(Status.INFO, "Response Body is: "+ res.getBody().asPrettyString());
		extentTest.log(Status.INFO, "Test ended : GET List of Orders");

	}

}
	