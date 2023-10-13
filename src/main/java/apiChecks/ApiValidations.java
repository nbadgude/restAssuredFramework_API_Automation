package apiChecks;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.restassured.response.Response;
import utils.ExtentReportITestListner;

public class ApiValidations extends ExtentReportITestListner {
	
	public static void responseCodeValidation(Response response, int statuscode) {
		
		try {
			Assert.assertEquals(statuscode, response.getStatusCode());
			extentTest.pass(MarkupHelper.createLabel("Response Code Validated", ExtentColor.GREEN));
			extentTest.log(Status.PASS, String.valueOf(response.getStatusCode()));
			
		} catch (AssertionError e) {
			// TODO: handle exception
			extentTest.fail(MarkupHelper.createLabel("Response Code Validation Failed", ExtentColor.RED));
			extentTest.log(Status.FAIL,"Expected Status code is : "+statuscode + " Received Status Code is : "+response.getStatusCode());

			
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

				extentTest.pass(MarkupHelper.createLabel("Response Key Validated", ExtentColor.GREEN));
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


				extentTest.pass(MarkupHelper.createLabel("Response Key Validated", ExtentColor.GREEN));
				extentTest.log(Status.PASS, "Key : "+Key+ " <br/> Value : "+jsonobj.get(Key));
			}
			else {
				extentTest.fail(MarkupHelper.createLabel("Response Key Validation Failed", ExtentColor.RED));
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
			extentTest.info(MarkupHelper.createLabel("Response Time Validated", ExtentColor.GREEN));
			extentTest.log(Status.PASS, String.valueOf(time));
			
		} catch (Exception e) {
			
			extentTest.log(Status.FAIL, e.fillInStackTrace());
		}
	}


	public static void SchemaValidator(Response res, String Test_name){

		try {

			res.then().assertThat().
					body(JsonSchemaValidator.
							matchesJsonSchemaInClasspath(Test_name+".json"));

			extentTest.info(MarkupHelper.createLabel("JSON Schema Validated, for the Response", ExtentColor.GREEN));
			extentTest.pass(MarkupHelper.createCodeBlock(res.getBody().prettyPrint(),CodeLanguage.JSON));
		}
		catch (AssertionError error){
			String errorMsg = error.getMessage();
			extentTest.info(MarkupHelper.createLabel("JSON Schema Validated Failed", ExtentColor.RED));
			extentTest.log(Status.FAIL,errorMsg );
		}


	}

}
