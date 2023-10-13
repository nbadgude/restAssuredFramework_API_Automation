package postApi;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import apiBuilder.JsonapiBuilder;
import apiConfigs.ApiEndPoints;
import apiConfigs.RequestHeaderConfig;
import apiChecks.ApiValidations;
import baseTest.Basetest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class createMpOrder extends Basetest {
	String Methodname;
	@Test
	public void PostMpOrder() {
		try {
			 Methodname = this.getClass().getMethod("PostMpOrder",this.getClass()).toString();
		}
		catch (NoSuchMethodException exception){
			exception.printStackTrace();
		}


		extentTest.log(Status.INFO, "Test Started: Create MarketPlace Order with data provided in Excel tab : orders");
		JSONArray array = JsonapiBuilder.orders();
		
		for(int i=0;i<array.length();i++) {
			JSONObject obj  = array.getJSONObject(i);
			Response res = RestAssured.given().headers(RequestHeaderConfig.defaultHeader()).when().
					body(obj.toString()).post(ApiEndPoints.apipath.POST_MP_ORDER);
			ApiValidations.responseCodeValidation(res, 201);
			extentTest.log(Status.INFO, "Test ended: Create MarketPlace Order with data provided in Excel tab : orders");
			 
		}
		
		
	}
	

}
