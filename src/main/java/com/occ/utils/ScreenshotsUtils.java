package com.occ.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.occ.driver.DriverManager;

public final class ScreenshotsUtils {
	
	private ScreenshotsUtils(){
		
	}
	
	public static String getBase64(){
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
