package baseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import io.restassured.RestAssured;
import utils.ExtentReportITestListner;
import utils.FileandEnv;

@Listeners(ExtentReportITestListner.class)
public class Basetest extends ExtentReportITestListner {
	
	@BeforeClass
	public void baseTest() {

		 RestAssured.baseURI = FileandEnv.envAndFile().get("serverUrl");;
	}

}
