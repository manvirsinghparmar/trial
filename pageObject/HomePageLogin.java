package com.ecom.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLogin {
	
	WebDriver lDriver;
	
	public HomePageLogin( WebDriver rDriver){
		lDriver = rDriver;
		PageFactory.initElements(rDriver,this);
		} 
	
	@FindBy(css="a.login")
	@CacheLookup
	WebElement signInBtn;
	
	@FindBy(name="email")
	@CacheLookup
	WebElement emailId;
	
	@FindBy(name="passwd")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(name="SubmitLogin")
	@CacheLookup
	WebElement loginBtn;
	
	
	
	public void setEmail(String user) {
		emailId.sendKeys(user);
	}
	
	public void setPwd(String pswd) {
		pwd.sendKeys(pswd);
	}
	
	public void clickSignIn() {
		signInBtn.click();
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	
	

}
