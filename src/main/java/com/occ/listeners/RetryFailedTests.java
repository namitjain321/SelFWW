package com.occ.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.occ.enums.configProperties;
import com.occ.utils.ConfigPropertiesUtils;

public class RetryFailedTests implements IRetryAnalyzer{

	private int MaxRetries= 1;
	private int count=0;

	@Override

	public boolean retry(ITestResult result) {
		boolean value=false;
		try {
			if(ConfigPropertiesUtils.getValue(configProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
			{	
				value=count<MaxRetries;
				count++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
