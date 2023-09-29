package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportITestListner implements ITestListener {
	
	protected static ExtentReports extentReports;
	protected static ExtentTest extentTest;

	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		extentReports = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
		extentReports.attachReporter(spark);		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
		extentTest.log(Status.INFO, result.getMethod().getMethodName());
			
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest.log(Status.PASS, "Test is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(Status.FAIL, "Test is fail");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(Status.SKIP, "Test is skipped");
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReports.flush();
		
	}
	


}
