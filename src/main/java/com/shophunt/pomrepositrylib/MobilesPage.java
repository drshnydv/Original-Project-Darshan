package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilesPage {
	
	public MobilesPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[text()='Apple iPhone 13 Pro Max (Sierra Blue-1TB)']")
	private WebElement AppleIphone13Lnk;
	
	
	public WebElement getAppleIphone13Lnk() {
		return AppleIphone13Lnk;
	}


	public void GetIphone13() {
		
		getAppleIphone13Lnk().click();
		
	}

}
