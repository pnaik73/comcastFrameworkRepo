package practice.prac;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

import junit.framework.Assert;
public class Invoice extends BaseClass {
	
@Test
public void createInvoice() {
	System.out.println("execute createInvoiceTest");
    String acttitle=driver.getTitle();
    Assert.assertEquals(acttitle,"Login");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}
@Test
public void createInvoiceWithContactTest() {
	
	System.out.println("execute createInvoiceWithContactTest");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");

}}
