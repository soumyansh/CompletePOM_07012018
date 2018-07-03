package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.TopMenu;
import utilities.ExcelReader;

public class Page {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static FileInputStream fis1;

	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\TestData.xlsx");
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static TopMenu menu;

	@BeforeSuite
	public void setup() {
	
		if (extent == null) {
			extent = new ExtentReports(System.getProperty("user.dir") + "//src//test//Reports//ExtentReports.html",
					true);
			extent.loadConfig(new File(System.getProperty("user.dir") + "//src//test//Reports//ReportsConfig.xml"));
		}
		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis1 = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("mozilla")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.get(config.getProperty("URL"));

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			menu = new TopMenu(driver);
		}
	}

	public boolean isElementPresent(String locator) {
		if (driver.findElement(By.xpath(locator)).isDisplayed()) {
			return true;
		} else
			return false;

	}

	public void verifyEquals(String Expected,String Actuals) {
		
		try {
			Assert.assertEquals(Actuals, Expected);
		} catch (Throwable t) {
			// TODO Auto-generated catch block
		logger.log(LogStatus.FAIL,"Assertion Failed");
		}
	}
	
	public static void Quit() {
		driver.quit();
	}
}
