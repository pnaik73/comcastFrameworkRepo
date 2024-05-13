package com.comcast.crm.contactTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.FilleUtility.ExcelUtility;
import com.comcast.crm.generic.FilleUtility.FileUtility;
import com.comcast.crm.generic.WebdriverUtility.JavaUtility;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.SearchLookUp;

public class CreateContactWithOrg extends BaseClass{

@Test
public void createContactWithOrg() throws EncryptedDocumentException, IOException, InterruptedException {
		//read data from excel
		String lastName=elib.getDataFromExcel("contact",1,5)+jlib.getRandonNumber();
		String orgName=elib.getDataFromExcel("contact",1,2)+jlib.getRandonNumber();

		HomePage hp =new HomePage(driver);
		hp.getOrgLink().click();;
		
		OrganizationsPage op =new OrganizationsPage(driver);
		op.getCreateOrgbutton().click();
		
		CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
		cno.createOrg(orgName);Thread.sleep(2000);
		hp.getContactLink().click();
		ContactPage cp =new ContactPage(driver);
		cp.getCreateContactbutton().click();
		cp.getLastnameEdit().sendKeys(lastName);
		CreatingNewContactPage cnp=new CreatingNewContactPage(driver);
		cnp.getOrgLookup().click();
		wlib.switchToTabOnUrl(driver, "Accounts&action");
		SearchLookUp sl=new SearchLookUp(driver);
		sl.getSearchEdit().sendKeys(orgName);
	   sl.getSearchbutton().click();Thread.sleep(2000);
	   driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();Thread.sleep(2000);		
	   wlib.switchToTabOnUrl(driver, "Contacts&action");
	    cp.getSavebutton().click();
				//verify orgName
		
		String actOrgname1 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actOrgname1.trim().equals(orgName)) {
			System.out.println(orgName+" organisation is verfied ===> pass");
		}else {
			System.out.println(orgName+" organisation is verfied ===> fail");
		}
	}

}
