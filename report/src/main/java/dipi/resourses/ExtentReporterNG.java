package dipi.resourses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	WebDriver driver;
	ExtentReports	extent;
	ExtentTest test;
	@BeforeTest
public static ExtentReports getReportObject()
{
	String path=	System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Sel Web Automation Results" );
	reporter.config().setDocumentTitle("Test Results 5");
	 
	
	ExtentReports 	extent=new 	ExtentReports();
extent.attachReporter(reporter);
extent.setSystemInfo("Tester", "dhuni");
 
return extent;
}
}
