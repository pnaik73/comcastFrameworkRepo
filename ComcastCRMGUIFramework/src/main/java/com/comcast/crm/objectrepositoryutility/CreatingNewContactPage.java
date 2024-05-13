package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility{
	@FindBy(name="lastname")
	private WebElement lastnameEdit;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;


	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgLookup;
	
	@FindBy(id="jscal_field_support_start_date")
	private WebElement supportStartDate;
	
	@FindBy(id="jscal_field_support_end_date")
	private WebElement supportEndDate;

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameEdit() {
		return lastnameEdit;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}


	public WebElement getOrgLookup() {
		return orgLookup;
	}


	public void createContact(String lastname) {
		getLastnameEdit().sendKeys(lastname);
		getSavebutton().click();
	}


}