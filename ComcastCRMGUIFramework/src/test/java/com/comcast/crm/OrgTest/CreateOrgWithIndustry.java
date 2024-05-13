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

public class CreateOrgWithIndustry extends BaseClass{
	@Test
	public void CreateOrgWithIndustryTest() throws EncryptedDocumentException, IOException, InterruptedException {
		//read data from excel
		String orgName=elib.getDataFromExcel("org",4,2)+jlib.getRandonNumber();
		String industry=elib.getDataFromExcel("org",4,4);
		String type=elib.getDataFromExcel("org",4,5);

		//navigation to organization page
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		//navigate to orgnization page
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getCreateOrgbutton().click();
		CreatingNewOrganizationPage cp=new CreatingNewOrganizationPage(driver);
		cp.createOrg(orgName, industry, type);

		//verification
		String actindustry=driver.findElement(By.id("dtlview_Industry")).getText();
		if(actindustry.equals(industry)) {
			System.out.println(industry+" is verified==> PASS");}
		else {
			System.out.println(industry+" is verified==> FAIL");
		}
		String acttype=driver.findElement(By.id("dtlview_Type")).getText();
		if(acttype.contains(type)) {
			System.out.println(type+" is verified==> PASS");}
		else {
			System.out.println(type+" is verified==> FAIL");
		}

	}

}

