package com.occ.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.occ.driver.Driver;


public class BaseTests {

	protected BaseTests(){

	}


	@BeforeMethod
	@Parameters("Browser")
	protected void setUp(String BrowserValue) throws Exception{
		Driver.initialize(BrowserValue);
	}

	@AfterMethod
	protected void tearDown(){
		Driver.quit();
	}

}
