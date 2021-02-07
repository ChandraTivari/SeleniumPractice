package com.qa.ExtentReportListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ExtentReportListener extends TestBase implements ITestListener{
	
	
	public ExtentReportListener()
	{
		super();
	}

	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test case:"+result.getMethod().getMethodName()+"Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL, "Test case:"+result.getMethod().getMethodName()+"    Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		//Attach screenshot on failure
		
		String scPath=TestUtil.takeScreenshot();
		
		test.addScreenCaptureFromPath(scPath, "Test Case Failure Screenshot");
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		extent=setupExtentReport();
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
	
	

}
