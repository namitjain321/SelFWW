package com.occ.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.occ.reports.ExtentLogger;
import com.occ.reports.ExtentReport;

public class Listeners implements ITestListener, ISuiteListener{



	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentLogger.Fail(result.getMethod().getMethodName()+": test is failed",true);
			//ExtentLogger.Fail(result.getThrowable().toString());
			//ExtentLogger.Fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
		try{
			ExtentLogger.Skip(result.getMethod().getMethodName()+": test is skipped",true);
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentReport.CreateTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			ExtentLogger.Pass(result.getMethod().getMethodName()+": test is passed",true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		ExtentReport.tearReoprts();
	}

	@Override
	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		try {
			ExtentReport.initReoprts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}