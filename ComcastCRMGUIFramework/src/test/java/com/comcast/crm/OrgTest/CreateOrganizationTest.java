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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.FilleUtility.ExcelUtility;
import com.comcast.crm.generic.FilleUtility.FileUtility;
import com.comcast.crm.generic.WebdriverUtility.JavaUtility;
import com.comcast.crm.generic.WebdriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;
import com.comcast.crm.generic.listnerutility.ListnerImplementation;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

import junit.framework.Assert;
/**
 * 
 * @author Priyanka
 */
@Listeners(com.comcast.crm.generic.listnerutility.ListnerImplementation.class)
public class CreateOrganizationTest extends BaseClass {
	@Test(groups="smoke test")
	public void createOrgTest() throws EncryptedDocumentException, IOException {
		
		//navigation to organization page
		UtilityClassObject.gettest().log(Status.INFO, "create org");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		String orgName=elib.getDataFromExcel("org",7,2)+jlib.getRandonNumber();
		//navigate to orgnization page
		UtilityClassObject.gettest().log(Status.INFO, "create org");
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getCreateOrgbutton().click();
		//enter all the details n create new organization
		UtilityClassObject.gettest().log(Status.INFO, "create org");
		CreatingNewOrganizationPage cp= new CreatingNewOrganizationPage(driver);
		
		cp.createOrg(orgName);
		//verification
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrg=oip.getActorg().getText();	
		Assert.assertEquals(actOrg, orgName);
		Reporter.log("org name verified",true);
		String headermsg=oip.getHeaderMsg().getText();
		boolean status = headermsg.contains(orgName);
		Assert.assertEquals(status, true);
		Reporter.log("header msg verified",true);
	}
	@Test(groups="regression")
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
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String actphonemun=oip.getActPhonenum().getText();
		Assert.assertEquals(actphonemun, phoneNum);
		Reporter.log("phone num verified",true);
	}

	@Test(groups="regression")

	public void createOrgWithIndustryTest() throws EncryptedDocumentException, IOException, InterruptedException {
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
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String actindustry=oip.getActIndustry().getText();
		Assert.assertEquals(actindustry, industry);
		Reporter.log("actindustry verified",true);

		String acttype=oip.getActType().getText();
		Assert.assertEquals(acttype, type);
		Reporter.log("type verified",true);
	}
	@Test(groups="regression")
	public void deleteOrgTest() throws EncryptedDocumentException, IOException {

		//read data from excel
		String orgName=elib.getDataFromExcel("org",13,2)+jlib.getRandonNumber();

		//navigation to organization page
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		//navigate to orgnization page
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getCreateOrgbutton().click();

		//enter all the details n create new organization
		CreatingNewOrganizationPage cp= new CreatingNewOrganizationPage(driver);
		cp.createOrg(orgName);

		//verification
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String headerorgname=oip.getHeaderMsg().getText();
		boolean status = headerorgname.contains(orgName);
		Assert.assertTrue(status);

		String actorgname=oip.getActorg().getText();
		boolean status1 = actorgname.contains(orgName);
		Assert.assertTrue(status1);


		hp.getOrgLink().click();
		op.getSearchEdit().sendKeys(orgName);
		wlib.select(op.getsearchdropdowm(),"Organization Name");
		op.getsearchbutton().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();	
		wlib.switchtoAlertAndAccept(driver);
	}
}
