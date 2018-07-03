package customlisteners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import utilities.TestUtil;
import base.Page;

import com.relevantcodes.extentreports.LogStatus;

import base.Page;

public class CustomListeners extends Page implements ITestListener {

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		logger.log(LogStatus.FAIL, "Failed");
		try {
			TestUtil.CaptureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.endTest(logger);
		extent.flush();

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		logger.log(LogStatus.SKIP, "Skipped");
		try {
			TestUtil.CaptureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.endTest(logger);
		extent.flush();
		
	}

	public void onTestStart(ITestResult result) {
		logger=extent.startTest(result.getName().toUpperCase());
	
	}

	public void onTestSuccess(ITestResult result) {
		logger.log(LogStatus.PASS, "completed successfully");
		try {
			TestUtil.CaptureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.endTest(logger);
		extent.flush();
		
	}

}
