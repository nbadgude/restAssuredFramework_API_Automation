package getApi;

import apiConfigs.ApiEndPoints;
import apiConfigs.RequestHeaderConfig;
import apiChecks.ApiValidations;
import baseTest.Basetest;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import utils.LogApiInfoToReport;

import java.io.IOException;
import java.util.List;

public class CM53 extends Basetest {

    @Test()
    public static void GET_CM53(ITestContext context) throws IOException {

        // GET TRACKING ID FROM CM52 RESPONSE AND STORE IT IN VARIABLE
        String tracking_id =  context.getAttribute("tracking_id").toString();
        extentTest.log(Status.INFO, "Test Started : GET CM53");

        // CONSTRUCT A GET REQUEST CM53
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.pathParam("tracking_id", tracking_id);
        requestSpecification.headers(RequestHeaderConfig.headersWithAuth());

        // Make Request CM53 AND STORE RESPONSE
        Response res = requestSpecification.get(ApiEndPoints.apipath.CM53);
        LogApiInfoToReport.LogReqInfoToReport(requestSpecification);

        // RESPONSE VALIDATION OF CM53
        ApiValidations.responseCodeValidation(res, 200);
        ApiValidations.responseTimeValidation(res);
        ApiValidations.responseKeyValidationfromJSONObject(res, "last_updated");
        ApiValidations.responseKeyValidationfromJSONObject(res, "status");
        ApiValidations.responseKeyValidationfromJSONObject(res, "urls");
        ApiValidations.responseTimeValidation(res);
        ApiValidations.SchemaValidator(res,"CM53");

        // FROM RESPONSE EXTRACT THE URLS AND PASS STORE AS CONTEXT VARIABLE
        List urlsdata = res.jsonPath().get("urls");
        context.setAttribute("urls",urlsdata);

        // TEST ENDED
        extentTest.log(Status.INFO, "Test ended : CM53");

    }
}
