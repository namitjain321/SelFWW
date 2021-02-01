package com.occ.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private ExtentManager(){

	}

	private static ThreadLocal<ExtentTest> test= new ThreadLocal<>();

	static ExtentTest getExtentTest(){
		return test.get();
	}

	static void setExtentTest(ExtentTest PassedTest){
		test.set(PassedTest);
	}

	static void unload(){
		test.remove();
	}



}
