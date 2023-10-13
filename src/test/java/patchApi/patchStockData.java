package patchApi;
import apiConfigs.ApiEndPoints;
import apiChecks.ApiValidations;
import apiChecks.JsonDataValidation;
import baseTest.Basetest;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class patchStockData extends Basetest {

   @Test
   public static void patchStockData(){

       JSONObject jsonString = new JSONObject();
       jsonString.put("Stock",60);


      extentTest.log(Status.INFO, "Test Started: Patch Stock Data");
      extentTest.log(Status.INFO, "PATCH request JSON Body is " + "\n" + jsonString.toString());
      Response response = RestAssured.
              given().
                header("Content-Type","application/json").
              pathParam("id",1).
              log().all().
              when().
                body(jsonString.toString()).
                patch(ApiEndPoints.apipath.PATCH_STOCK_DATA);

      ApiValidations.responseCodeValidation(response,200);
      ApiValidations.responseTimeValidation(response);
      JsonDataValidation.JsonDataValidation(response,"Stock");
      extentTest.log(Status.INFO,"The Test Ended: Patch Stock Data ");
      extentTest.log(Status.INFO,"Updated Resource Body is " + response.getBody().asString());
   }
}
