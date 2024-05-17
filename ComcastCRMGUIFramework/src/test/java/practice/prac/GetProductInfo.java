package practice.prac;

import java.io.IOException;
import java.time.Duration;

import javax.sound.sampled.TargetDataLine;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.FilleUtility.ExcelUtility;
import com.comcast.crm.generic.WebdriverUtility.WebDriverUtility;

public class GetProductInfo {
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.flipkart.com");
		//search product
		driver.findElement(By.name("q")).sendKeys(brandName,Keys.ENTER);
		String x="//div[text()='"+productName+"']/../../div[2]/div[1]/div/div";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
	}
	//capture
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		ExcelUtility elib=new ExcelUtility();
		int rowcount=elib.getlastRowCount("product");
		Object[][] objArr=new Object[rowcount][2];

		for(int i=0;i<rowcount;i++) {

			objArr[i][0]=elib.getDataFromExcel("product", i+1, 0);
			objArr[i][1]=elib.getDataFromExcel("product", i+1, 1);
		}
		return objArr ;
	}
}
