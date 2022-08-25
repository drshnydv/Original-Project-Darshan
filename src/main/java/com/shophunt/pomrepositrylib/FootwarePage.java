package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FootwarePage {
	
	public FootwarePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[text()='Adidas MESSI 16.3 TF Football turf Shoes  (Blue)']")
	private WebElement adidasMessiShoes;

	public WebElement getAdidasMessiShoes() {
		return adidasMessiShoes;
	}
	
	public void GetAdidasMessiShoes() {
		
		getAdidasMessiShoes().click();
		
	}

}
