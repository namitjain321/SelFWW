package com.occ.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.occ.enums.configProperties;
import com.occ.utils.ConfigPropertiesUtils;
import com.occ.utils.ScreenshotsUtils;

public class ExtentLogger {

	private ExtentLogger(){

	}

	public static void Pass(String Message){
		ExtentManager.getExtentTest().pass(Message);
	}
	public static void Fail(String Message){
		ExtentManager.getExtentTest().fail(Message);
	}
	public static void Skip(String Message){
		ExtentManager.getExtentTest().skip(Message);
	}
	
	
	public static void Pass(String Message, boolean IsScreenShotNeeded) throws Exception{
		if(ConfigPropertiesUtils.getValue(configProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && IsScreenShotNeeded){
			ExtentManager.getExtentTest().pass(Message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64()).build());
		}
		else{
			Pass(Message);
		}
	}

	public static void Fail(String Message, boolean IsScreenShotNeeded) throws Exception{
		if(ConfigPropertiesUtils.getValue(configProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && IsScreenShotNeeded){
			ExtentManager.getExtentTest().fail(Message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64()).build());
		}
		else{
			Fail(Message);
		}
	}

	public static void Skip(String Message, boolean IsScreenShotNeeded) throws Exception{
		if(ConfigPropertiesUtils.getValue(configProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && IsScreenShotNeeded){
			ExtentManager.getExtentTest().skip(Message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64()).build());
		}
		else{
			Skip(Message);
		}
	}

}
