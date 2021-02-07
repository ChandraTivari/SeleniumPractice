package com.qa.Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int Counter=0;
	int retryLimit=3;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(Counter<retryLimit)
		{
			Counter++;
			return true;
		}
		return false;
		
	}
	

}
