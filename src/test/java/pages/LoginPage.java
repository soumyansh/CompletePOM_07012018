package pages;

import org.openqa.selenium.By;

import base.Page;


public class LoginPage extends Page {

	public ServicesSelectionPage doLogin(String username,String password){
		driver.findElement(By.cssSelector("#lid")).sendKeys(username);
		driver.findElement(By.cssSelector("#pwd")).sendKeys(password);
		driver.findElement(By.cssSelector("#signin_submit")).click();
		return new ServicesSelectionPage();
	}
	
}
