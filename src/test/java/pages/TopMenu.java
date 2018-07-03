package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Page;

public class TopMenu{

	WebDriver driver;
	public TopMenu(WebDriver driver) {
		this.driver = driver;
	}


	public void Leads(){
	
		driver.findElement(By.xpath("//*[text()='Leads']")).click();
	}


	public AccountsPage Accounts() {
		driver.findElement(By.xpath("//*[text()='Accounts']")).click();
		return new AccountsPage();
		
		
	}
	
	public ReportsPage Reports() {
		driver.findElement(By.xpath("//*[text()='Reports']")).click();
		return new ReportsPage();
		
		
	}
}
