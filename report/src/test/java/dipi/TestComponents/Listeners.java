package dipi.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import dipi.resourses.ExtentReporterNG;

 

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent=	ExtentReporterNG.getReportObject();
	public void onTestStart(ITestResult result)
	{
	test=	extent.createTest(result.getMethod().getMethodName());
	 
		}
		
		public void onTestSuccess(ITestResult result)
		{
			  	 test.log(Status.PASS, "Test passed");	
		}
		public void onTestFailure(ITestResult result)  
		{
			 //test.log(Status.FAIL, "Test Failed");
			
			test.fail(result.getThrowable());  //shows error message
			
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			//screenshot
	String filepath = null;
	try {
		filepath = getScreenshot(result.getMethod().getMethodName(), driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
			
		}
		public void onstart(ITestContext context) { 
			
		}
		public void onFinish(ITestContext context) {
			//ExtentReports extent = null;
			extent.flush();
		}
		
	}

 
