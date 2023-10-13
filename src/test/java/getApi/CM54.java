package getApi;

import apiConfigs.RequestHeaderConfig;
import apiChecks.ApiValidations;
import apiChecks.JsonDataValidation;
import baseTest.Basetest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import utils.LogApiInfoToReport;

import java.io.IOException;
import java.util.List;

public class CM54 extends Basetest {

    @Test()
    public static void GET_CM54(ITestContext context) throws IOException {

        // GET LIST OF URLS FROM CM53
        List ListOfUrls = (List) context.getAttribute("urls");

    // FOR EACH URL IN CM53 Make a CM54 GET Request
        for (int i = 0; i < ListOfUrls.size(); i++) {

            // GET URL FROM LIST
            String retrieved_url_from_CM53 = ListOfUrls.get(i).toString();
            System.out.println("Received URL is " + retrieved_url_from_CM53);

            // CONSTRUCT A GET REQUEST
            extentTest.log(Status.INFO, "Test Started : GET CM53");
            RequestSpecification requestSpecification = RestAssured.given();
            requestSpecification.headers(RequestHeaderConfig.headersWithAuth());

            // MAKE A GET REQUEST AND STORE RESPONSE
            Response res = requestSpecification.urlEncodingEnabled(false).get(retrieved_url_from_CM53);

            // RESPONSE VALIDATION OF CM54
            LogApiInfoToReport.LogReqInfoToReport(requestSpecification);
            ApiValidations.responseCodeValidation(res, 200);
            ApiValidations.responseTimeValidation(res);
            JsonDataValidation.JsonDataValidation(res,"mirakl_product_id");
            // PRINT RESPONSE BODY TO REPORT
            extentTest.info(MarkupHelper.createLabel("Response Body", ExtentColor.GREEN));
            extentTest.pass(MarkupHelper.createCodeBlock(res.getBody().prettyPrint(), CodeLanguage.JSON));

        }
    }
}

