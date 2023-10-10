package dipi.ExtentReports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemo {
	
	 WebDriver driver;
	ExtentReports	extent;
	ExtentTest test;
	File file;
	//@BeforeTest
	@BeforeMethod
	public void config()
	{
		//ExtentReports,ExtentSparkReporter 
String path=	System.getProperty("user.dir")+"\\satreports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web_Automation_Results" ) ;
		reporter.config().setDocumentTitle("Test Results 5");
		
	 	extent=new 	ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Anamica");
		}
		
		
	 
	
	
	
	
	
@Test 
public void logon()
{
 test=	extent.createTest("Title of page1");
	WebDriverManager.chromedriver() .setup();
	driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com");
System.out.println( 	driver.getTitle());
String test =driver.getTitle();

  //String path = null;
 test.equalsIgnoreCase("Selenium, API Testing , Software Testing & More QA Tutorials | Rahul Shetty Academy");
// test.addScreenCaptureFromPath(file);
 // Assert.assertEquals(test,"Selenium, API Testing , Software Testing & More QA Tutorials | Rahul Shetty Academy"); 
 driver.close( );
 extent.flush();
}

@Test
public void screenshoot(String test,WebDriver driver) {
	//driver.get("https://rahulshettyacademy.com");
	TakesScreenshot ts=(TakesScreenshot)driver; 
ts.getScreenshotAs(OutputType.FILE);
file=new File(System.getProperty("user.dir")+"//satutdayscreenshoot//"+test+"satutdayscreenshoot.png");
}

 
 @AfterTest
 public void teardown1()
	{
driver.close( );
	}
 





	
 








 
	
 








 
	
}
 







	
 

 
