package com.occ.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.occ.constants.FrameworkConstants;
import com.occ.enums.configProperties;
import com.occ.utils.ConfigPropertiesUtils;

public final class ExtentReport {

	private ExtentReport(){

	}
	private static ExtentReports extent;
	//public static ExtentTest test;
	public static void initReoprts() throws Exception{
		if(Objects.isNull(extent)){
			extent=new ExtentReports();
			ExtentSparkReporter sparkReporter=new ExtentSparkReporter(FrameworkConstants.getExtentreportpath());
			extent.attachReporter(sparkReporter);
			sparkReporter.config().setDocumentTitle("Framework Report");
			sparkReporter.config().setReportName("OCC REPORT");
		}
		else{
			System.out.println("Reports not initialized");	
		}
	}

	public static void tearReoprts(){
		if(Objects.nonNull(extent)){
			extent.flush();	
		}
		else{
			System.out.println("Reports not Flushed");	
		}
		ExtentManager.unload();
		try {
			if(ConfigPropertiesUtils.getValue(configProperties.OPENREPORTBYDEFAULT).equalsIgnoreCase("yes")){
				Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportpath()).toURI());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void CreateTest(String TestName){
		ExtentManager.setExtentTest(extent.createTest(TestName));
	}
}