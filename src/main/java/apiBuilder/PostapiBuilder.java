package apiBuilder;

import org.json.JSONArray;

import com.aventstack.extentreports.Status;

import apiConfigs.Apipath;
import utils.ExcelTestDatProvider;
import utils.ExtentReportITestListner;
import utils.FileandEnv;

public class PostapiBuilder extends ExtentReportITestListner {
	
	
	public static JSONArray orders() {
	
		String sheetname = (Apipath.apipath.POST_MP_ORDER).substring(1);
		
		String path = System.getProperty("user.dir") + FileandEnv.envAndFile().get("excelpath");
		
		ExcelTestDatProvider obj = new ExcelTestDatProvider();
		JSONArray data = obj.testdataprovider(path, sheetname);
		extentTest.log(Status.PASS, "JSON Body passsed in POST HTTP request is : "+data);
		//System.out.println (data);
		return data;
	}
	
	

	
	

	

}
