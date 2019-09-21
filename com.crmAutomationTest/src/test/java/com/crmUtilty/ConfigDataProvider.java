package com.crmUtilty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider
{
	 public Properties pro;
	public  ConfigDataProvider()
	{
		File src= new File("C:\\Users\\S.Keshri\\git\\repository\\com.crmAutomationTest\\Configurtaion/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);	
			pro= new Properties();
			pro.load(fis);
		} 
		catch (Exception e) 
		{
		
			e.printStackTrace();
		}
		
	}
	
	
	public String getDataFromConfig(String keyToSearch)
	{
		return pro.getProperty("keyToSearch");
	}
	
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	
	public String StagingURL()
	{
		return pro.getProperty("qaUrl");
	}

}
