package utils;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.Header;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogApiInfoToReport extends ExtentReportITestListner {


    public static void LogReqInfoToReport(RequestSpecification specification){
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(specification);
        //Store Headers as List
        List<Header> ReqHeaders = queryableRequestSpecification.getHeaders().asList();

        // Create a new list of lists to store the headers.
        List<List<String>> hds = new ArrayList<>();

        // Iterate over the list of Header objects and add each header to the list of lists.
        for (int i = 0; i < ReqHeaders.size(); i++) {
            Header header = ReqHeaders.get(i);
            List<String> row = new ArrayList<>();
            row.add(header.getName());
            row.add(header.getValue());
            hds.add(row);
        }


        //Request URI
        extentTest.info(MarkupHelper.createLabel("Request URI", ExtentColor.BLUE) );
        extentTest.log(Status.INFO, queryableRequestSpecification.getURI());

        // Request Headers
        extentTest.info(MarkupHelper.createLabel("Request Headers", ExtentColor.BLUE));
        extentTest.info(MarkupHelper.toTable(hds,"table-sm"));

        // Request Authentication
        extentTest.info(MarkupHelper.createLabel("API Authentication", ExtentColor.BLUE));
        extentTest.log(Status.INFO, "API KEY : "+ queryableRequestSpecification.getHeaders().getValue("Authorization"));

        // Request Params
        extentTest.info(MarkupHelper.createLabel("Path Parameters", ExtentColor.BLUE));
        extentTest.log(Status.INFO, queryableRequestSpecification.getPathParams().toString());

        // Request Query Params
        extentTest.info(MarkupHelper.createLabel("Query Parameters", ExtentColor.BLUE));
        extentTest.log(Status.INFO,  queryableRequestSpecification.getQueryParams().toString());





        }


}
