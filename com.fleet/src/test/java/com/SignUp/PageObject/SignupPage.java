package com.SignUp.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	WebDriver ldriver;
	public SignupPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="")
	WebElement FirstName;
	
	@FindBy(xpath="")
	WebElement LastName;
	
	@FindBy(xpath="")
	WebElement Emailid;
	
	@FindBy(xpath="")
	WebElement password;
	
	@FindBy(xpath="")
	WebElement Confirmpassword;
	
	@FindBy(xpath="")
	WebElement terms;
	
	@FindBy(xpath="")
	WebElement submit;
	
	public void firstName(String firstname)
	{
		FirstName.sendKeys(firstname);
	}
	public void lastName(String lastname)
	{
		LastName.sendKeys(lastname);
	}
	
	public void email(String mail)
	{
		Emailid.sendKeys(mail);
	}
	
	public void pwd(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void conpwd(String cpwd)
	{
		Confirmpassword.sendKeys(cpwd);
	}
	
	public void toClickterms()
	{
		terms.click();
	}
	
	public void toClickSubmit()
	{
		submit.click();
	}
}
