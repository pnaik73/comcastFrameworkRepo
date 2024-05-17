package practice.prac;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport {
public	ExtentReports report;
	@BeforeSuite
	public void bsconfib(){
		//spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suit Results");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);

		//add env information & create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("Browser", "chrome");	
	}
	@AfterSuite
	public void asconfig() {
		report.flush();
	}
	@Test
	public void createcontactTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);

		//create test case
		ExtentTest test =report.createTest("createcontactTest");

		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDC")) {
			test.log(Status.PASS,"contact is created");
		}
		else {
			test.addScreenCaptureFromBase64String(filePath,"error file");
		}
		driver.close();
	}
	@Test
	public void createcontactwithOrgTest() {

		//create test case
 		ExtentTest test =report.createTest("createcontactTest");

		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDC")) {
			test.log(Status.PASS,"contact is created");
		}
		else {
			test.log(Status.FAIL,"contact is not created");
		}
		
	}
	@Test
	public void createcontactWithPhNumTest() {

		//create test case
		ExtentTest test =report.createTest("createcontactTest");

		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		}
		else {
			test.log(Status.FAIL,"contact is not created");
		}
		
	}
}
