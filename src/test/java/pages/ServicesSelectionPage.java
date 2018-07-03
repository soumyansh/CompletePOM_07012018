package pages;

import org.openqa.selenium.By;

import base.Page;


public class ServicesSelectionPage extends Page {

	public ReportsPage SelectCRM(){
		driver.findElement(By.cssSelector(".zicon-apps-crm.zicon-apps-96")).click();
		return new ReportsPage();
	}
	
}
