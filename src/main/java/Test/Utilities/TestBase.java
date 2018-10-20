package Test.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;

public class TestBase {
	
	
	public static WebDriver driver;
	public static ExtentReports report;
	@BeforeClass
	public void beforeSuite() {
		System.out.println(1);
		report = new ExtentReports("Reports\\report.html", true);
		System.out.println(2);
	}
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun=true)
	public void setup(String browser) {
		
		System.out.println("Browser   :" + browser);
		new Readproperty();
		if(browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println(Readproperty.getProp("URL"));
			driver.get(Readproperty.getProp("URL"));
			System.out.println("AUT opened in chrome");
		}		
	}
	
	@AfterMethod(alwaysRun=true)
	public void close() {
		driver.quit();
	}
	
	public static String capture(WebDriver driver) throws IOException {
		String path = null;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("/ErrImages/" + System.currentTimeMillis()
		+ ".png");
		path = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return path;
	}
	
	@AfterClass
	public void afterClass() {
		report.flush();
	}
}
