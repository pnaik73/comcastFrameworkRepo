package com.comcast.crm.OrgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.FilleUtility.ExcelUtility;
import com.comcast.crm.generic.FilleUtility.FileUtility;
import com.comcast.crm.generic.WebdriverUtility.JavaUtility;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrgwithContact extends BaseClass {

	@Test
	public void createOrgWithContactTest() throws EncryptedDocumentException, IOException {

		//read data from excel
		String orgName=elib.getDataFromExcel("org",7,2)+jlib.getRandonNumber();
		String phoneNum=elib.getDataFromExcel("org",7,4);

		HomePage hp = new HomePage(driver);
		OrganizationsPage op=new OrganizationsPage(driver);
		CreatingNewOrganizationPage cp =new CreatingNewOrganizationPage(driver);

		//login to the application
		hp.getOrgLink().click();
		op.getCreateOrgbutton().click();
		cp.createOrg(orgName, phoneNum);

		//verification
		String actphonemun=driver.findElement(By.id("dtlview_Phone")).getText();
		if(actphonemun.equals(phoneNum)) {
			System.out.println(phoneNum+" phone number is verified==> PASS");}
		else {
			System.out.println(phoneNum+" is verified==> FAIL");
		}

	}

}
