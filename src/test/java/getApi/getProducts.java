package getApi;

import apiConfigs.ApiEndPoints;
import apiConfigs.RequestHeaderConfig;
import apiChecks.ApiValidations;
import baseTest.Basetest;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import utils.LogApiInfoToReport;

import java.io.IOException;

public class getProducts extends Basetest {


    @Test
    public static void getSingleProduct() throws IOException {
        extentTest.log(Status.INFO, "Test Started : GET Single Product");

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.pathParam("id", "1");
        requestSpecification.headers(RequestHeaderConfig.defaultHeader());
        LogApiInfoToReport.LogReqInfoToReport(requestSpecification);

        Response res = requestSpecification.get(ApiEndPoints.apipath.GET_SINGLE_PRODUCT);

        ApiValidations.responseCodeValidation(res, 200);
        ApiValidations.responseTimeValidation(res);


        //extentTest.log(Status.INFO, "Existing resource on server is: "+ res.getBody().asPrettyString());
        extentTest.log(Status.INFO, "Test ended : GET Single Product");

    }

}
