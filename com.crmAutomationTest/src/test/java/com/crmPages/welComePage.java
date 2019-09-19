package com.crmPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class welComePage
{
	public WebDriver driver;
	
	
	public welComePage()
	{
		PageFactory.initElements(driver,welComePage.class);
	}
	
	
	
	
	@FindBy(xpath="//span[text(),'Log In']")
	WebElement LogiIn_btn_element;
	
	
	public boolean validateLogin_btn()
	{
		return LogiIn_btn_element.isDisplayed();
	}

}
