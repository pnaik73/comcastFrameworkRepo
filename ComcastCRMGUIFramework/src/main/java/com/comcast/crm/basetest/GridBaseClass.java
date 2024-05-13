package com.comcast.crm.basetest;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.FilleUtility.ExcelUtility;
import com.comcast.crm.generic.FilleUtility.FileUtility;
import com.comcast.crm.generic.WebdriverUtility.JavaUtility;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;
import com.comcast.crm.generic.databaseUtility.DataBaseUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class GridBaseClass  {
public	WebDriver driver=null;
public static	WebDriver sdriver=null;
public	DataBaseUtility dblib=new DataBaseUtility();
public	ExcelUtility elib=new ExcelUtility();
public WebDriverUtility wlib=new WebDriverUtility();
public	JavaUtility jlib=new JavaUtility();
public	FileUtility flib=new FileUtility();
	
	@BeforeSuite(groups ={"smoke test", "regression"})
	public void configBeforeSuit() throws SQLException {
		System.out.println("====connect to db , report config====");
		dblib.getDbConnection();
	}
	//@Parameters("BROWSER")
	@BeforeClass//(groups ={"smoke test", "regression"})
	public void configBeforeClass(/*String browser*/) throws IOException {
		System.out.println("==launch browser");
		//String Browser=browser;
		String Browser=flib.getDataFromPropertiesFile("browser");
		
		URL url = new URL("");
		DesiredCapabilities dc = new DesiredCapabilities();
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		} 
		sdriver=driver;
	}
	@BeforeMethod(groups ={"smoke test", "regression"})
	public void configBeforemethod() throws IOException {
		LoginPage lp =new LoginPage(driver);
		System.out.println("=login=");
		String url = flib.getDataFromPropertiesFile("url");
		String username = flib.getDataFromPropertiesFile("username");
		String password = flib.getDataFromPropertiesFile("password");
		lp.loginToapp(url, username, password);		

	}
	@AfterMethod(groups ={"smoke test", "regression"})
	public void configAftermethod() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		System.out.println("=logout=");Thread.sleep(3000);
		hp.logout();
	}
	@AfterClass(groups ={"smoke test", "regression"})
	public void configAfterClass() {
		System.out.println("==close browser==");
		driver.quit();
	}

	@AfterSuite(groups ={"smoke test", "regression"})
	public void configAfterSuit() {
		System.out.println("====close db , report backup====");
		
	}

}
