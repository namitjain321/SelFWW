package com.occ.constants;

import com.occ.enums.configProperties;
import com.occ.utils.ConfigPropertiesUtils;

public final class FrameworkConstants {

	private final static String ChromePath=System.getProperty("user.dir")+"/src/test/resources/executables/geckodriver.exe";
	private final static String ResourcePath=System.getProperty("user.dir")+"/src/test/resources/";
	private final static String ConfigPath=System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
	private final static  int explcitwait=10;
	private final static  String ExtentReportFolderPath=System.getProperty("user.dir")+"/extent-test-output/";
	private static String ExtentReportFilePath="";
	private final static  String ExcelFilePath=ResourcePath+"/Excel/testdata.xlsx";
	private final static String IterationSheetName="DATA";
	private final static String RunManagerSheetName="RUNMANAGER";
	
	
	public static String getRunmanagersheetname() {
		return RunManagerSheetName;
	}

	public static String getIterationsheetname() {
		return IterationSheetName;
	}

	public static String getExcelfilepath() {
		return ExcelFilePath;
	}

	public static String getExtentreportpath() throws Exception{
		if(ExtentReportFilePath==""){
			ExtentReportFilePath=CreateReportfilepath();
		}
		return ExtentReportFilePath;
	}

	public static String CreateReportfilepath() throws Exception {
		if(ConfigPropertiesUtils.getValue(configProperties.SAMEREPORT).equalsIgnoreCase("no")){
			return ExtentReportFolderPath+System.currentTimeMillis()+"/"+"index.html";
		}
		else
		return ExtentReportFolderPath+"/"+"index.html";
	}

	private FrameworkConstants(){
	}
	
	public static int getExplcitwait() {
		return explcitwait;
	}

	public static String getConfigpath() {
		return ConfigPath;
	}
	
	public static String getChromepath() {
		return ChromePath;
	}

}
