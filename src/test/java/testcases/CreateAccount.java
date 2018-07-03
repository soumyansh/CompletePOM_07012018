package testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import base.Page;
import base.TestCase;
import pages.AccountsPage;
import pages.ReportsPage;
import pages.ServicesSelectionPage;
import utilities.TestUtil;

public class CreateAccount extends TestCase {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void CreateAccountTest(Hashtable<String,String>data){
		
	ReportsPage rp=new ReportsPage();
	rp.ReportsSelection(data.get("MemberName"));
	System.out.println("hi");
		
	}

}


