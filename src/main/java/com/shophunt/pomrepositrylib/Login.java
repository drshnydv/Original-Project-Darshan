package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public Login(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name = "email")
	private WebElement userNameEdt;
	
	@FindBy(name = "password")
	private WebElement userPasswordEdt;
	
	@FindBy(id = "inputEmail")
	private WebElement adminNameEdt;
	
	@FindBy(id = "inputPassword")
	private WebElement adminPasswordEdt;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void UserLogin(String userName,String password) {
		
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
		
	}
	
	public void AdminLogin(String username, String password) {
		
		adminNameEdt.sendKeys(username);
		adminPasswordEdt.sendKeys(password);
		loginBtn.click();
		
	}
		
}