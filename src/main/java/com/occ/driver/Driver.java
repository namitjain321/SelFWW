package com.occ.driver;

import java.util.Objects;

import com.occ.enums.configProperties;
import com.occ.factories.DriverFactory;
import com.occ.utils.ConfigPropertiesUtils;

public final class Driver {

	private Driver()
	{
	}
	public static void initialize(String BrowserName) throws Exception{
		
		if(Objects.isNull(DriverManager.getDriver())){
				DriverManager.setDriver(DriverFactory.DriverRetrun(BrowserName));
				DriverManager.getDriver().get(ConfigPropertiesUtils.getValue(configProperties.URL));
			}

		}
	public static void quit(){
		if(Objects.nonNull(DriverManager.getDriver())){
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
