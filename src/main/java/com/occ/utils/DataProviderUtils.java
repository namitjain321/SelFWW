package com.occ.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.occ.constants.FrameworkConstants;

public final class DataProviderUtils {

	private static int ReturnListLength;
	@DataProvider
	public static Object[][] getData(Method m){
		String TestName=m.getName();
		List<Map<String,String>> ListFromExcel=new ArrayList<>();
		if(ListFromExcel.isEmpty()){
			ListFromExcel=ExcelUtils.getTestData(FrameworkConstants.getIterationsheetname());
		}
		List<Map<String,String>> ReturnMatchingList=new ArrayList<>();
		for(int i=0;i<ListFromExcel.size();i++){
			if(ListFromExcel.get(i).get("Test Case Name").equalsIgnoreCase(TestName)){	
				ReturnMatchingList.add(ListFromExcel.get(i));
			}
		}

		ReturnListLength=ReturnMatchingList.size();

		Object[][] FinalReturnList = new Object[ReturnListLength][1];
		for(int j=0;j<ReturnListLength;j++){
			FinalReturnList[j][0]=ReturnMatchingList.get(j);
		}
		return FinalReturnList;
	}
}

