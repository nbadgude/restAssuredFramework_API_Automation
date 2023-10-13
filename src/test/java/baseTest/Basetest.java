package baseTest;

import io.restassured.config.HttpClientConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import io.restassured.RestAssured;
import utils.ExtentReportITestListner;
import utils.PropertyConfig;

@Listeners(ExtentReportITestListner.class)
public class Basetest extends ExtentReportITestListner {
	
	@BeforeClass
	public void baseTest() {

		 RestAssured.baseURI = PropertyConfig.envAndFile().get("serverUrl");

	}

}
