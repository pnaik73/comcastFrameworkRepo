package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	@FindBy(name="accountname")
	private WebElement orgnameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(name="industry")
	private WebElement industryEdit;
	
	@FindBy(name="accounttype")
	private WebElement typeEdit;
	
	@FindBy(id="phone")
	private WebElement phoneEdit;
	
	

	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
    	 PageFactory.initElements(driver,this);
     } 
	
	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createOrg(String orgName) {
		orgnameEdt.sendKeys(orgName);
		savebtn.click();
	}
	
	public void createOrg(String orgName,String industry,String type) {
		orgnameEdt.sendKeys(orgName);
		Select sel =new Select(industryEdit);
		sel.selectByVisibleText(industry);
		Select sel1= new Select(typeEdit);
		sel1.selectByVisibleText(type);
		savebtn.click();
	}
	
public void createOrg(String orgname,String phoneNum) {
	orgnameEdt.sendKeys(orgname);
	phoneEdit.sendKeys(phoneNum);
	savebtn.click();
	
}
}
