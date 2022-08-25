package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	public PaymentPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitPaymentBtn;
	
	public void SubmitPayment() {
		
		submitPaymentBtn.click();
		
	}
	
}
