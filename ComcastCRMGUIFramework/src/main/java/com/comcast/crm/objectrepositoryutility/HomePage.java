package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink; 
	 
	public WebElement getProductLink() {
		return productLink;
	}

	@FindBy(linkText="Contacts")
	private WebElement contactLink;

	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;

	@FindBy(linkText="More")
	private WebElement moreLink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	public WebElement getMoreLink() {
		return moreLink;
	}

	public void setMoreLink(WebElement moreLink) {
		this.moreLink = moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}
   
	public HomePage() {
	}
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	

	public void navigateToCampaignLink() {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();
	}

	public void logout() throws InterruptedException {
		Thread.sleep(3000);
		mousemoveonElement(driver, adminImg);
		signOutLink.click();
	}
}
