package com.comcast.crm.OrgTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.FilleUtility.ExcelUtility;
import com.comcast.crm.generic.FilleUtility.FileUtility;
import com.comcast.crm.generic.WebdriverUtility.JavaUtility;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrg extends BaseClass {
@Test
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

		if(headerorgname.contains(orgName)) {
			System.out.println(orgName+" in header is verified==> PASS");}
		else {
			System.out.println(orgName+" in header is created==> FAIL");
		}
		String actorgname=driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actorgname.contains(orgName)) {
			System.out.println(orgName+" is verified==> PASS");}
		else {
			System.out.println(orgName+" is verified==> FAIL");
		}

		hp.getOrgLink().click();
		op.getSearchEdit().sendKeys(orgName);
		wlib.select(op.getsearchdropdowm(),"Organization Name");
		op.getsearchbutton().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();	
		wlib.switchtoAlertAndAccept(driver);

	}
}
