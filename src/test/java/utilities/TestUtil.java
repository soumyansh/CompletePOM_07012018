package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.LogStatus;

import base.Page;

public class TestUtil extends Page {
	public static String ScreenShotName;

	public static void CaptureScreenshot() throws IOException {
		Date d = new Date();
		String d1 = d.toString().replace(":", "_").replace(" ", "_");

		ScreenShotName = "Screen_" + d1 + ".jpg";
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destpath = System.getProperty("user.dir") + "//src//test//Screenshots//" + ScreenShotName;

		File dest = new File(destpath);
		FileUtils.copyFile(scr, dest);
		logger.log(LogStatus.INFO, logger.addScreenCapture(destpath));

	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();

		int rows = excel.getRowCount(sheetName);

		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}

	public static boolean isTestRunnable(String testname, ExcelReader excel) {

		int rows = excel.getRowCount("TestSuite");
		for (int i = 2; i <= rows; i++) {
			String testcase = excel.getCellData("TestSuite", "TCID", i);
			if (testcase.equalsIgnoreCase(testname)) {
				String runmode = excel.getCellData("TestSuite", "RunMode", i);
				if (runmode.equalsIgnoreCase("Y")) {
					return true;
				} else
					return false;
			}
		}
		return false;

	}
}
