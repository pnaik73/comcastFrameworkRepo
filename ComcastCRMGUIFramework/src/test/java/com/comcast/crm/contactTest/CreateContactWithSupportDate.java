package com.comcast.crm.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.FilleUtility.ExcelUtility;
import com.comcast.crm.generic.FilleUtility.FileUtility;
import com.comcast.crm.generic.WebdriverUtility.JavaUtility;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactWithSupportDate extends BaseClass {

@Test
public void CreateContactWithSupportDateTest() throws EncryptedDocumentException, IOException, InterruptedException {
		//read data from excel
		String lastName=elib.getDataFromExcel("contact",7,5)+jlib.getRandonNumber();
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		ContactPage cp=new ContactPage(driver);
		cp.getCreateContactbutton().click();

		CreatingNewContactPage cnc=new CreatingNewContactPage(driver);

		cnc.getLastnameEdit().sendKeys(lastName);
		String startdate = jlib.getSystemDateyyyyMMdd();
		String enddate = jlib.getRequiredDateYYYYMMDD(30);
		cnc.getSupportStartDate().clear();
		cnc.getSupportStartDate().sendKeys(startdate);Thread.sleep(2000);
		cnc.getSupportEndDate().clear();
		cnc.getSupportEndDate().sendKeys(enddate);
		cnc.getSavebutton().click();;

		//verification
		String actlastname=driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actlastname.equals(lastName)) {
			System.out.println(lastName+" lastname is verified==> PASS");}
		else {
			System.out.println(lastName+" lastname is verified==> FAIL");
		}
		String actstartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actstartdate.equals(startdate)) {
			System.out.println(startdate+" startdate is verified==> PASS");}
		else {
			System.out.println(startdate+" startdate is verified==> FAIL");
		}
		String actenddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actenddate.equals(enddate)) {
			System.out.println(enddate+" enddate is verified==> PASS");}
		else {
			System.out.println(enddate+" enddate is verified==> FAIL");
		}

	}

}
