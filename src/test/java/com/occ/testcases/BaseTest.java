package com.occ.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.occ.driver.Driver;


public class BaseTest {

	protected BaseTest(){

	}


	@BeforeMethod
	@Parameters("Browser")
	protected void setUp(String BrowserValue) throws Exception{
		System.out.println("(Base Test SETUP METHOD )Current thread is : "+Thread.currentThread());
		//Driver.initialize(BrowserValue);
	}

	@AfterMethod
	protected void tearDown(){
		System.out.println("(Base Test TearDown METHOD )Current thread is : "+Thread.currentThread());
		Driver.quit();
	}

}
