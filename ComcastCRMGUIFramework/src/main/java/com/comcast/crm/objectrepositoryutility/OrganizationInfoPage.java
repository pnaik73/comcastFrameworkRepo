package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement actorg;
	
	@FindBy(id="dtlview_Phone")
	private WebElement actPhonenum;
	
	@FindBy(id="dtlview_Industry")
	private WebElement actIndustry;
	
	@FindBy(id="dtlview_Type")
	private WebElement actType;

	public WebElement getActIndustry() {
		return actIndustry;
	}

	public WebElement getActType() {
		return actType;
	}

	public WebElement getActorg() {
		return actorg;
	}

	public WebElement getActPhonenum() {
		return actPhonenum;
	}

	public void setHeaderMsg(WebElement headerMsg) {
		this.headerMsg = headerMsg;
	}

	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	} 


}


