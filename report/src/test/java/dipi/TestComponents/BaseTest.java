package dipi.TestComponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BaseTest {
	 
	WebDriver driver;
	File file;
	 @Test
	public String getScreenshot(String testcasename,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver; 
 ts.getScreenshotAs(OutputType.FILE);
		  file=new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
		 
		
		return testcasename;
		
	}

}
