package com.occ.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.occ.constants.FrameworkConstants;

public final class ExcelUtils {

	private ExcelUtils(){}

	public static List<Map<String,String>> getTestData(String PassedSheetName){
		List <Map<String,String>> list=null;
		FileInputStream fs = null;
		//XSSFWorkbook workbook=null;
		try {
			fs = new FileInputStream(FrameworkConstants.getExcelfilepath());
			@SuppressWarnings("resource")
			XSSFWorkbook workbook=new XSSFWorkbook(fs);
			XSSFSheet sheet=workbook.getSheet(PassedSheetName);
			
			int RowCount=sheet.getLastRowNum();
			int ColumnCount=sheet.getRow(0).getLastCellNum();

			Map<String,String> map=null;
			list=new ArrayList<>();
			for(int i=1;i<=RowCount;i++){
				map=new HashMap<>();
				for(int j=0;j<ColumnCount;j++){
					String Key=sheet.getRow(0).getCell(j).getStringCellValue();
					String Value=sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(Key, Value);
				}
				list.add(map);
			} 
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(Objects.nonNull(fs)){
					fs.close();
					//workbook.close();
				} 
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}