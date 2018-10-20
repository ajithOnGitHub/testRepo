package Test.testCore;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Test.Utilities.MyRetryAnayzer;
import Test.Utilities.TestBase;

public class LoginTest extends TestBase {
	
	
  @Test(retryAnalyzer = MyRetryAnayzer.class, testName = "Test", groups={"testHome"})
  public void validLogin() throws InterruptedException, IOException{
	  ExtentTest test = report.startTest("Login Test");	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  WebElement ele = driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']"));
	  js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);   
	  driver.findElement(By.xpath("//*[@data-nav-role = 'signin']//*[@class='nav-line-1']")).click();
	  Thread.sleep(300);
	  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ajithskn@gmail.com");
	  driver.findElement(By.xpath("//input[@id='continue']")).click();
	  Thread.sleep(300);
	  driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("11111UnniKannan");
	  driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	  Thread.sleep(300);
	  if(driver.findElement(By.xpath("//*[@data-nav-role = 'signin']//*[@class='nav-line-1']")).getText().contains("Agyfftfjith")){
		  System.out.println("Login success");
		  test.log(LogStatus.PASS, "Login success");
	  }else {
		  System.out.println("Login Failed");
		  Assert.fail("Login failed");
		  test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+"Tesst Failed");
	  }
	  report.endTest(test);
  }
  
@Test(groups={"testSearch"})
  public void search() {
	  driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("Mobiles");
	  driver.findElement(By.xpath("//input[@value='Go']")).click();
	  String temp = driver.findElement(By.xpath("//a[@id='bcKwText']")).getText();
	  if(temp.contains("Mobile")) {
		  System.out.println("Search passed");
		  
	  }
	  else {
		  System.out.println("Search failed");
		  Assert.fail("Search failed");
	  }
  }
  
}
