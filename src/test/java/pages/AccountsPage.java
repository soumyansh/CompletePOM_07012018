package pages;

import org.openqa.selenium.By;

import base.Page;
import utilities.TestUtil;

public class AccountsPage extends Page {

	public void AccountCreation(String membername){
		
		driver.findElement(By.cssSelector(".newwhitebtn.customPlusBtn")).click();
		driver.findElement(By.cssSelector("#Crm_Accounts_ACCOUNTNAME")).sendKeys(membername);
	
	}
	
}
