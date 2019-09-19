package com.crmUtilty;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory 
{
	public static   WebDriver driver;
	//Why we need to define 




	public static void startApplication(String browserName, String appUrl)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".Driver/chromeDriver.exe");
			 driver = new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.InternetExplorer.driver", "");
			 driver = new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.GecoDriver.driver", "");
			driver = new ChromeDriver();
		}

		else 
		{
			System.out.println("We dont support any browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}


  public static  void quitBrowser()
	{
		driver.quit();
	}

}
