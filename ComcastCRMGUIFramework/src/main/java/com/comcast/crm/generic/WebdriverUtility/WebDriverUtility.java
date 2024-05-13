package com.comcast.crm.generic.WebdriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.objectrepositoryutility.HomePage;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void opennewtab(WebDriver driver) {
		 driver.switchTo().newWindow(WindowType.TAB);
	}
	

	public void switchToTabOnUrl(WebDriver driver,String partialurl) {
		Set<String> allwid = driver.getWindowHandles();
		Iterator<String> it =allwid.iterator();
		while(it.hasNext()) {
			String wid=it.next();
			driver.switchTo().window(wid);

			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialurl)) {
				break;
			}
		}
	}
	public void switchToTabOnTitle(WebDriver driver,String partialtitle) {
		Set<String> allwid = driver.getWindowHandles();
		Iterator<String> it =allwid.iterator();
		while(it.hasNext()) {
			String wid=it.next();
			driver.switchTo().window(wid);

			String actTitle = driver.getTitle();
			if(actTitle.contains(partialtitle)) {
				break;
			}
		}
	}

	public void switchtoFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}

	public void switchtoFrame(WebDriver driver , String nameID) {
		driver.switchTo().frame(nameID);
	}

	public void switchtoFrame(WebDriver driver , WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchtoAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchtoAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void select(WebElement element , String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	public void select(WebElement element ,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
 
	public void mousemoveonElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void doubleclick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	

	}
