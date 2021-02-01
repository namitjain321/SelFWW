package com.occ.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import com.occ.constants.FrameworkConstants;
import com.occ.enums.configProperties;


public final class ConfigPropertiesUtils {

	private static Properties property=new Properties();
	private ConfigPropertiesUtils(){

	}

	static{
		try(FileInputStream File=new FileInputStream(FrameworkConstants.getConfigpath())){	
			property.load(File);
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	public static String getValue(configProperties key) throws Exception
	{
		if (Objects.nonNull(property.getProperty(key.name().toLowerCase()))&&Objects.nonNull(property.getProperty(key.name().toLowerCase()))){
			return property.getProperty(key.name().toLowerCase()).trim();
		}
		else
		{
			throw new Exception("Key does not match"+key);
		}

	}
}
