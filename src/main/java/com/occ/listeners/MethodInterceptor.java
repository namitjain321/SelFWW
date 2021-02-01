package com.occ.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.occ.constants.FrameworkConstants;
import com.occ.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<Map<String,String>> list=ExcelUtils.getTestData(FrameworkConstants.getRunmanagersheetname());
		
		List<IMethodInstance> Result=new ArrayList<>();
		
		
		for(int i=0;i<methods.size();i++){
			for (int j=0;j<list.size();j++){
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("Test Case Name"))){
					if(list.get(j).get("Execute").equalsIgnoreCase("y")){
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("Priority")));
						Result.add(methods.get(i));
					}
				}

			}
		}

		return Result;
	}
}
