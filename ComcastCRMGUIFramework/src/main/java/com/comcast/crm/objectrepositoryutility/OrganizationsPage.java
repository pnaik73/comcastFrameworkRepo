package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgbutton;
	
	@FindBy(name="search_text")
	private WebElement SearchEdit;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchdropdowm;
	
	@FindBy(name="submit")
	private WebElement searchbutton;
	
	public WebElement getsearchbutton() {
		return searchbutton;
	}

	public WebElement getSearchEdit() {
		return SearchEdit;
	}

	public WebElement getsearchdropdowm() {
		return searchdropdowm;
	}

	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
    	 PageFactory.initElements(driver,this);
	}
	
	public WebElement getCreateOrgbutton() {
		return createOrgbutton;
	}

	
}


