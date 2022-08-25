package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FashionPage {
	
	public FashionPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[@href='sub-category.php?scid=12']")
	private WebElement footwareLnk;

	public WebElement getFootwareLnk() {
		return footwareLnk;
	}
	
	public void GetFootwareLnk() {
		
		getFootwareLnk().click();
		
	}

}
