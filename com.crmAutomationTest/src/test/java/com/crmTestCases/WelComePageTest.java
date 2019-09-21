package com.crmTestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Base.BaseClass;
import com.crmPages.WelComePage;

public class WelComePageTest extends BaseClass
{
	 public WelComePageTest welcomepage;
	 public WebDriver driver;
	 
	 public WelComePageTest()
	 {
		 super();
	 }
	
	 
	 
	@Test(priority=1)
	public boolean Validate_JP_Title()
	{
		
		report.createTest("Login to CRM");
		welcomepage= new WelComePageTest();	
		boolean flag= welcomepage.Validate_JP_Title();
		Assert.assertTrue(flag);
		return flag;
		
		
	}
	
	

}
