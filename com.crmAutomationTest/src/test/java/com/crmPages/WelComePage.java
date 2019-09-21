package com.crmPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelComePage
{
	public WebDriver driver;
	
	
	public WelComePage()
	{
		PageFactory.initElements(driver,WelComePage.class);
	}

	@FindBy(xpath="//span[text(),'Log In']")//check xpath
	WebElement LogiIn_btn_element;
	
	//Japan_button_Tab
	@FindBy(xpath="//a[@title= \"Japan Free CRM\"]")
	WebElement JP_btn_element;
	
	
	
	//Signup  btn
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement Signup_btn_element;
	
	
	
	//LoginButton
	@FindBy(xpath="//span[text()='Log In']")
	WebElement login_button_element;
	
	
	
	//Need to write path for CRM drop down in the Utilty and xpath fro it, how to use, it
	
	public boolean validateLogin_btn_title()
	{
		return LogiIn_btn_element.isDisplayed();
	}
	
	
	
	public boolean  validateJp_button_title()
	{
		 return JP_btn_element.isDisplayed();
		
	}
	
	
	public boolean  validateSignupButton()
	{
		return Signup_btn_element.isEnabled();
	}
	
	public boolean  validateLoginBtton()
	{
		return login_button_element.isDisplayed();
	}

}
