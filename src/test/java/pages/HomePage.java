package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import base.Page;


public class HomePage extends Page{

public void goToSignup() {

		driver.findElement(By.cssSelector(".zh-signup")).click();
		logger.log(LogStatus.INFO,"Signup Clicked");
	}

	public LoginPage goToLogin()  {
		driver.findElement(By.cssSelector(".zh-login")).click();
		logger.log(LogStatus.INFO,"Login Clicked");
		return new LoginPage();
	}

	public void goToSupport() {
		driver.findElement(By.cssSelector(".zh-support")).click();
	}
}
