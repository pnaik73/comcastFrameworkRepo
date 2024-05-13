package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;
/**
 * @author Priyanka
 * 
 * contains Login page elements & business logic for login()
 * 
 */
public class LoginPage extends WebDriverUtility{  //Rule 1: create a separate java class
	WebDriver driver=null; 
	//rule 3:object initialisatio

	//rule 2: object creation
	@FindBy(name="user_name")
	private WebElement usernameEdit;

	@FindBy(name="user_password")
	private WebElement passwordEdit;

	@FindBy(id="submitButton")
	private WebElement loginbuttont; 

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}


	//rule 4: object encapsulation
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginbuttont() {
		return loginbuttont;
	}
	
/**
 * Login to application based on username , password ,url arguments
 * @param url
 * @param username
 * @param password
 */
	//rule 5: utilization
	public void loginToapp(String url,String username,String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		getUsernameEdit().sendKeys(username);
		getPasswordEdit().sendKeys(password);
		getLoginbuttont().click();
	}




}
