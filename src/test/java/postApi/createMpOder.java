package postApi;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import apiBuilder.PostapiBuilder;
import apiConfigs.Apipath;
import apiConfigs.HeaderConfig;
import apiVerfications.ApiVerification;
import baseTest.Basetest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class createMpOder extends Basetest {
	
	@Test
	public void CreateMpOrder() {
		
		extentTest.log(Status.INFO, "Test Started: Create MarketPlace Order with data provided in Excel tab : orders");
		JSONArray array = PostapiBuilder.orders();
		
		for(int i=0;i<array.length();i++) {
			JSONObject obj  = array.getJSONObject(i);
			Response res = RestAssured.given().headers(HeaderConfig.defaultHeader()).when().
					body(obj.toString()).post(Apipath.apipath.POST_MP_ORDER);
			ApiVerification.responseCodeValidation(res, 201);
			extentTest.log(Status.INFO, "Test ended: Create MarketPlace Order with data provided in Excel tab : orders");
			 
		}
		
		
	}
	

}
