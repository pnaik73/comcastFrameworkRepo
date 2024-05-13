package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class ContactPage extends HomePage{
	WebDriver driver;
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactbutton;
	
	@FindBy(name="lastname")
	private WebElement lastnameEdit;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;
    	 PageFactory.initElements(driver,this);
     }	

	public WebElement getCreateContactbutton() {
		return createContactbutton;
	}

	public WebElement getLastnameEdit() {
		return lastnameEdit;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
 
		
}
