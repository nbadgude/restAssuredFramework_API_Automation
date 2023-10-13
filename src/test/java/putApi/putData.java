package putApi;

import apiBuilder.JsonapiBuilder;
import apiConfigs.ApiEndPoints;
import baseTest.Basetest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class putData extends Basetest {

    @Test
    public void getjsondata(){


             RestAssured.
                given().
                header("Content-Type","application/json").log().all().
                when().
                body(JsonapiBuilder.JsonPayload("POST")).
                post(ApiEndPoints.apipath.POST_MP_ORDER).then().log().all();

    }
}
