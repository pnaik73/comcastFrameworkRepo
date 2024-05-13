package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	@FindBy(id="mouseArea_Organization Name")
	private WebElement actOrg;

	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;

	@FindBy(id="dtlview_Last Name")
	private WebElement lastName;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement supportStartDate;

	@FindBy(id="dtlview_Support End Date")
	private WebElement supportEndDate;


	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getLastName() {
		return lastName;
	}


	public WebElement getActOrg() {
		return actOrg;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}


}
