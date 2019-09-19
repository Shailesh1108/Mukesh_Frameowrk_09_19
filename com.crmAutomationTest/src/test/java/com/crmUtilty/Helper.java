package com.crmUtilty;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper 
{
	
	
	public static WebDriver driver ;
	public static String  captureScreenShot()
	{
	 File src=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 String screenShotsPath = System.getProperty("user.dir")+ "./ScreenShots/FreeCRM_" + getCurrentDateTime() + ".png"; //if we will keep above then we will get static error 
	 try {
		FileHandler.copy(src,new File(screenShotsPath));
		
	} 
	 catch (Exception e) {
		
		e.printStackTrace();
	}
	return screenShotsPath;
	}
	
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat= new SimpleDateFormat("MM__dd__yyyy__HH__mm__ss");
		Date currentDate= new Date();
		return customFormat.format(currentDate);
		
	}

}
