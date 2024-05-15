package practice.prac;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class Retry {
@Test(retryAnalyzer=com.comcast.crm.generic.listnerutility.RetryListnerImplementation.class)
public void activateSim() {
	System.out.println("execute activateSim");
	//Assert.assertEquals("","Login");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}
}
