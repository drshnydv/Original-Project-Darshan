package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FurnituresPage {

	public FurnituresPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[@href='sub-category.php?scid=9']")
	private WebElement bedsLnk;

	public WebElement getBedsLnk() {
		return bedsLnk;
	}
	
	public void GetBedsLnk() {
		
		getBedsLnk().click();
		
	}
	
}
