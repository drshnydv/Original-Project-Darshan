package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage {
	
	public ElectronicsPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[@href='sub-category.php?scid=4']")
	private WebElement MobliesLnk;
	
	public WebElement getMobliesLnk() {
		return MobliesLnk;
	}
	
	public void GetMobiles() {
		
		getMobliesLnk().click();
		
	}
	
}
