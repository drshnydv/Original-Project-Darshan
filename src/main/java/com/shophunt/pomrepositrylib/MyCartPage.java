package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {

	public MyCartPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Apple iPhone 13 Pro Max (Sierra Blue-1TB)']/ancestor::tr/descendant::span[@class='ir']")
	private WebElement increaseBtnForAppleIphone13;

	@FindBy(xpath = "//a[text()='alishaank TEAK WOOD ROYAL ELITE Solid Wood King Box Bed  (Finish Color - METALIC, Delivery Condition']/ancestor::tr/descendant::span[@class='ir']")
	private WebElement increaseBtnForInduscraftBed;

	@FindBy(xpath = "//a[text()='Adidas MESSI 16.3 TF Football turf Shoes  (Blue)']/ancestor::tr/descendant::span[@class='ir']")
	private WebElement increaseBtnForAdidasMessiShoes;

	@FindBy(xpath = "//textarea[@name='billingaddress']")
	private WebElement shippingAddressEdt;

	@FindBy(xpath = "//input[@name='bilingstate']")
	private WebElement shippingStateEdt;

	@FindBy(xpath = "//input[@name='billingcity']")
	private WebElement shippingCityEdt;

	@FindBy(xpath = "//input[@name='billingpincode']")
	private WebElement shippingPincodeEdt;

	@FindBy(xpath = "//textarea[@name='shippingaddress']")
	private WebElement billingAddressEdt;

	@FindBy(xpath = "//input[@name='shippingstate']")
	private WebElement billingStateEdt;

	@FindBy(xpath = "//input[@name='shippingcity']")
	private WebElement billingCityEdt;

	@FindBy(xpath = "//input[@name='shippingpincode']")
	private WebElement billingPincodeEdt;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement updateShoppingCartBtn;

	@FindBy(xpath = "//button[text()='PROCCED TO CHEKOUT']")
	private WebElement proceedToCheckOutBtn;

	@FindBy(xpath = "//span[text()='Shipping Address']/ancestor::table/descendant::button")
	private WebElement shippingDetailsUpdateBtn;

	@FindBy(xpath = "//span[text()='Billing Address']/ancestor::table/descendant::button")
	private WebElement billingDetailsUpdateBtn;

	public WebElement getIncreaseBtnForAppleIphone13() {
		return increaseBtnForAppleIphone13;
	}

	public WebElement getIncreaseBtnForInduscraftBed() {
		return increaseBtnForInduscraftBed;
	}

	public WebElement getIncreaseBtnForAdidasMessiShoes() {
		return increaseBtnForAdidasMessiShoes;
	}

	public WebElement getShippingAddressEdt() {
		return shippingAddressEdt;
	}

	public WebElement getShippingStateEdt() {
		return shippingStateEdt;
	}

	public WebElement getShippingCityEdt() {
		return shippingCityEdt;
	}

	public WebElement getShippingPincodeEdt() {
		return shippingPincodeEdt;
	}

	public WebElement getBillingAddressEdt() {
		return billingAddressEdt;
	}

	public WebElement getBillingStateEdt() {
		return billingStateEdt;
	}

	public WebElement getBillingCityEdt() {
		return billingCityEdt;
	}

	public WebElement getBillingPincodeEdt() {
		return billingPincodeEdt;
	}

	public WebElement getShippingDetailsUpdateBtn() {
		return shippingDetailsUpdateBtn;
	}

	public WebElement getBillingDetailsUpdateBtn() {
		return billingDetailsUpdateBtn;
	}

	public WebElement getUpdateShoppingCartBtn() {
		return updateShoppingCartBtn;
	}

	public WebElement getProceedToCheckOutBtn() {
		return proceedToCheckOutBtn;
	}

	public void IncreaseTheProductsQuantity() {

		increaseBtnForAppleIphone13.click();

		increaseBtnForInduscraftBed.click();
		increaseBtnForInduscraftBed.click();

		increaseBtnForAdidasMessiShoes.click();
		increaseBtnForAdidasMessiShoes.click();
		increaseBtnForAdidasMessiShoes.click();

	}

	public void UpadteShippingAddress(String address, String state, String city, String pincode ) {

		shippingAddressEdt.clear();
		shippingAddressEdt.sendKeys(address);

		shippingStateEdt.clear();
		shippingStateEdt.sendKeys(state);

		shippingCityEdt.clear();
		shippingCityEdt.sendKeys(city);

		shippingPincodeEdt.clear();
		shippingPincodeEdt.sendKeys(pincode);

		shippingDetailsUpdateBtn.click();

	}

	public void UpdateShoppingCart() {

		updateShoppingCartBtn.click();

	}


	public void UpadteBillingAddress(String address, String state, String city, String pincode ) {

		getBillingAddressEdt().clear();
		getBillingAddressEdt().sendKeys(address);

		getBillingStateEdt().clear();
		getBillingStateEdt().sendKeys(state);

		getBillingCityEdt().clear();
		getBillingCityEdt().sendKeys(city);

		getBillingPincodeEdt().clear();
		getBillingPincodeEdt().sendKeys(pincode);

		billingDetailsUpdateBtn.click();

	}

	public void ProceedToChechOut() {

		getProceedToCheckOutBtn().click();

	}

}