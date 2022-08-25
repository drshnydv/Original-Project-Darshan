package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BedsPage {
	
	public BedsPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[text()='alishaank TEAK WOOD ROYAL ELITE Solid Wood King Box Bed  (Finish Color - METALIC, Delivery Condition']")
	private WebElement induscraft;

	public WebElement getInduscraft() {
		return induscraft;
	}
	
	public void GetInduscraft() {
		
		getInduscraft().click();
		
	}

}
