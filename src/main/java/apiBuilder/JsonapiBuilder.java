package apiBuilder;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.json.JSONArray;

import com.aventstack.extentreports.Status;

import apiConfigs.ApiEndPoints;
import utils.ExcelTestDatProvider;
import utils.ExtentReportITestListner;
import utils.PropertyConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JsonapiBuilder extends ExtentReportITestListner {
	
	
	public static JSONArray orders() {
	
		String sheetname = (ApiEndPoints.apipath.POST_MP_ORDER).substring(1);
		
		String path = System.getProperty("user.dir") + PropertyConfig.envAndFile().get("excelpath");
		
		ExcelTestDatProvider obj = new ExcelTestDatProvider();
		JSONArray data = obj.testdataprovider(path, sheetname);
		extentTest.log(Status.PASS, "JSON Body passsed in POST HTTP request is : "+data);
		//System.out.println (data);
		return data;
	}

	public static FileInputStream JsonPayload(String MethodName)  {

		String path = System.getProperty("user.dir") + PropertyConfig.envAndFile().get(MethodName);
		File file = new File(path);
		FileInputStream jsonFileIn = null;
		try {
			jsonFileIn = new FileInputStream(file);
			extentTest.info(MarkupHelper.createLabel("Request JSON Body", ExtentColor.BLUE));
			byte [] bytes = new byte[jsonFileIn.available()];
			jsonFileIn.read(bytes);
			String requestbody = new String(bytes);
			System.out.println("Before REQ BODY " + requestbody);
			extentTest.info(MarkupHelper.createCodeBlock(requestbody, CodeLanguage.JSON));

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
            throw new RuntimeException(e);
        }


        return jsonFileIn;
	}


	
	

	
	

	

}
