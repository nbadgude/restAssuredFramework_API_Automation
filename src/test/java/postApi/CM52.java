package postApi;

import apiBuilder.JsonapiBuilder;
import apiConfigs.ApiEndPoints;
import apiConfigs.RequestHeaderConfig;
import apiChecks.ApiValidations;
import baseTest.Basetest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import utils.LogApiInfoToReport;


public class CM52  extends Basetest {

    @Test
    public void CM52(ITestContext context)  {

        String tracking_id;

        // CONSTRUCT A POSE REQUEST - URI, HEADERS, JSON BODY, AUTHENTICATION
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.headers(RequestHeaderConfig.headersWithAuth());
        requestSpecification.body(JsonapiBuilder.JsonPayload("CM52"));


        // MAKE POST REQUEST AND STORE RESPONSE
        Response res = requestSpecification.post(ApiEndPoints.apipath.CM52);
        LogApiInfoToReport.LogReqInfoToReport(requestSpecification);

        // VALIDATE RESPONSE DATA
        ApiValidations.responseCodeValidation(res, 200);
        ApiValidations.responseTimeValidation(res);
        ApiValidations.responseKeyValidationfromJSONObject(res, "tracking_id");
        ApiValidations.SchemaValidator(res,"CM52");


        // CHAIN API TEST, PASS RESPONSE DATA TO CM53, TRACKING ID
        tracking_id = res.jsonPath().get("tracking_id");
        context.setAttribute("tracking_id",tracking_id);
    }
}
