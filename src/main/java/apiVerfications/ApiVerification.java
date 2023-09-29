package apiVerfications;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.restassured.response.Response;
import utils.ExtentReportITestListner;

public class ApiVerification extends ExtentReportITestListner {
	
	public static void responseCodeValidation(Response response, int statuscode) {
		
		try {
			Assert.assertEquals(statuscode, response.getStatusCode());
			extentTest.log(Status.PASS, "Response Code Validated Sucuessfully : "+response.getStatusCode());
			
		} catch (AssertionError e) {
			// TODO: handle exception
			extentTest.log(Status.FAIL,"Expected Status code is : "+statuscode + " Instead of : "+response.getStatusCode() );
			
		}
		catch(Exception e) {
			extentTest.log(Status.FAIL, e.fillInStackTrace());
		}
	}
	
	public static void resposeKeyValidationfromArray(Response res, String key) {
		
		try {
			JSONArray JsonArray = new JSONArray(res.getBody().asString());
			for(int i=0;i<JsonArray.length();i++) {
				
				JSONObject obj = JsonArray.getJSONObject(i);
				
				extentTest.log(Status.PASS, "Validated values are "+ obj.get(key));
				
			}
		} catch (Exception e) {
		
			extentTest.log(Status.FAIL, e.fillInStackTrace());

		}	
	}
	
	public static void responseKeyValidationfromJSONObject(Response res, String Key) {
		try {
			JSONObject jsonobj = new JSONObject(res.getBody().asString());
			if(jsonobj.has(Key)&& jsonobj.get(Key)!=null) {
				extentTest.log(Status.PASS, "Validated value of Key "+ jsonobj.get(Key));
				
			}
			else {
				extentTest.log(Status.FAIL, "Key is not present "+jsonobj.get(Key));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			extentTest.log(Status.FAIL, e.fillInStackTrace());
		}
		
	}
	
	public static void responseTimeValidation(Response res) {
		try {
			long time = res.getTime();
			extentTest.log(Status.PASS, "Response time is "+ time);
			
		} catch (Exception e) {
			
			extentTest.log(Status.FAIL, e.fillInStackTrace());
		}
	}

}
