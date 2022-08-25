package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement myAccountLnk;
	
	@FindBy(xpath = "//a[text()=' Electronics']")
	private WebElement electronicsLnk;
	
	@FindBy(xpath = "//a[text()=' Furniture']")
	private WebElement furnitureLnk;
	
	@FindBy(xpath = "//a[text()=' Fashion']")
	private WebElement fashionLnk;

	public WebElement getMyAccountLnk() {
		return myAccountLnk;
	}
	
	public WebElement getElectronicsLnk() {
		return electronicsLnk;
	}
	
	public WebElement getFurnitureLnk() {
		return furnitureLnk;
	}

	public WebElement getFashionLnk() {
		return fashionLnk;
	}

	public void NavToMyAccount() {
		
		getMyAccountLnk().click();
		
	}
	
	public void NavToElectronics() {
		
		getElectronicsLnk().click();
		
	}
	
	public void NavToFurnitureLnk() {
		
		getFurnitureLnk().click();
		
	}
	
	public void NavToFashion() {
		
		getFashionLnk().click();
		
	}
	
	
}
