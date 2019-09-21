package com.crm.Base;

import java.io.File;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crmUtilty.BrowserFactory;
import com.crmUtilty.ConfigDataProvider;
import com.crmUtilty.Helper;

public class BaseClass 
{
	
	public ExtentReports report;
	public ConfigDataProvider configdataprovider;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		configdataprovider = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter( new File(System.getProperty("user.dir")+ " C:\\Users\\S.Keshri\\git\\repository\\com.crmAutomationTest\\Reports\\FreeCRM_"+ Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		///Reports/FreeCRM
		
		
		
	}

	@BeforeClass
	public void tearUp()
	{
		BrowserFactory.startApplication(configdataprovider.getBrowser(),configdataprovider.StagingURL());
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			//Helper.captureScreenShot(); //to add screenshot at the screen shot folder
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot()).build());
		}
		
		if(result.getStatus()==ITestResult.SUCCESS) 
		{
			Helper.captureScreenShot(); //to add screenshot at the screen shot folder
			logger.pass("Test Pass",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot()).build());
			
			//We can use listener for reporting but we cant get screen shot on  extent report and if we will do then we need to strugle alot for this.
			//We can use log 4j for custom lg in the extent report and this is just for our help
		}
		
		report.flush();
	}
	
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser();
	}
	
	
	
}