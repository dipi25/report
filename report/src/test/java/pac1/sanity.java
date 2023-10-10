package pac1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sanity {
	WebDriver driver;
@BeforeMethod
public void launchbrowser() {
	WebDriverManager.chromiumdriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	  
}
 
}
