package testcases;


import java.util.Hashtable;

import org.testng.annotations.Test;

import utilities.TestUtil;
import base.Page;
import base.TestCase;
import pages.AccountsPage;
import pages.HomePage;

public class LoginTest extends TestCase{

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void doLogin(Hashtable<String, String> data) {
		
			HomePage hm = new HomePage();
			hm.goToLogin().doLogin(data.get("UserName"),data.get("Password")).SelectCRM();
			
			//Page.menu.Accounts();
			
			
	}
}
