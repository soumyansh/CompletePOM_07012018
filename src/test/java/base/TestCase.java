package base;

import org.testng.annotations.AfterSuite;

public class TestCase {

	
	@AfterSuite
	public void tearDown() {
		Page.Quit();
	}
}
