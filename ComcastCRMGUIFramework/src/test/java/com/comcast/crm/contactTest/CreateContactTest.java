package com.comcast.crm.contactTest;

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
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.SearchLookUp;
/**
 * 
 * @author Priyanka
 */
@Listeners(com.comcast.crm.generic.listnerutility.ListnerImplementation.class)
public class CreateContactTest extends BaseClass{
	@Test(groups={"smoke test","regression"})
	public void createContTest() throws IOException{

		/*read data from excel*/
		String lastName=elib.getDataFromExcel("contact",1,5)+jlib.getRandonNumber();
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		ContactPage cp= new ContactPage(driver);
		cp.getCreateContactbutton().click();
		CreatingNewContactPage cnc=new CreatingNewContactPage(driver);
		cnc.createContact(lastName);

		/*verification*/
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actHeader=cip.getHeaderMsg().getText();
		boolean status = actHeader.contains(lastName);
		Assert.assertEquals(status, true);
		Reporter.log("Header msg verified",true);

		String actlastname=cip.getLastName().getText();
		SoftAssert assertobj=new SoftAssert();
		assertobj.assertEquals(actlastname,lastName );
		Reporter.log("last name verified",true);
	}
	@Test(groups="regression")
	public void createContactWithOrg() throws EncryptedDocumentException, IOException, InterruptedException {
		/*read data from excel*/
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
		
		/*verify orgName*/
		ContactInfoPage cip= new ContactInfoPage(driver);
		String actLastName=cip.getLastName().getText();
		SoftAssert asserObj=new SoftAssert();
		asserObj.assertEquals(actLastName, lastName);
		String actOrgname1 =cip.getActOrg().getText();
		boolean status = actOrgname1.contains(orgName);
		Assert.assertEquals(status, true);

	}
	@Test(groups="regression")
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

		/*verification*/
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actlastname=cip.getLastName().getText();
		Assert.assertEquals(actlastname, lastName);
		Reporter.log("lastname verified");
		String actstartdate=cip.getSupportStartDate().getText();
		Assert.assertEquals(actstartdate,startdate);
		Reporter.log("startDate verified");
		String actenddate=cip.getSupportEndDate().getText();
		Assert.assertEquals(actenddate, enddate);
		Reporter.log("enddate verified");
	}


}




