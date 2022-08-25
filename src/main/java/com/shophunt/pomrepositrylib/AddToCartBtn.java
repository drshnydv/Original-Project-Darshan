package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartBtn {
	
	public AddToCartBtn(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[text()=' ADD TO CART']")
	private WebElement addToCartBtn;

	public WebElement GetAddToCartBtn() {
		return addToCartBtn;
	}
	
	public void AddToCart() {
		
		GetAddToCartBtn().click();
		
	}
}
