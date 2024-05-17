package practice.prac;
/**
 * test class for contact module
 * @author priyanka
 */

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContact extends BaseClass{
	/**
	 * scenario: login()==> navigateContact==>createContact()==>verify
	 */
	@Test
	public void searchcontactTest() {
		/*step 1 : login to app*/
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp("url", "un", "pwd");
	}
	

}
