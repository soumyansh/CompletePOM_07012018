package pages;

import org.openqa.selenium.By;

import base.Page;

public class ReportsPage extends Page {

	public void ReportsSelection(String SearchReport) {
		driver.findElement(By.xpath("//*[text()='Reports']")).click();
		driver.findElement(By.id("searchReport")).sendKeys(SearchReport);
	}
	
}
