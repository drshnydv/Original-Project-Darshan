package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	public AdminHomePage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='collapsed']")
	private WebElement orderManagementBtn;

	@FindBy(xpath = "//a[@href='todays-orders.php']")
	private WebElement todaysOrderBtn;

	@FindBy(xpath = "//a[text()='Manage Products ']")
	private WebElement manageProduct;
	
	@FindBy(xpath = "//a[text()='Insert Product ']")
	private WebElement insterProduct;
	
	@FindBy(name = "category")
	public WebElement categoryDropDown;
	
	@FindBy(name = "subcategory")
	public WebElement subcategoryDropDown;
	
	@FindBy(name = "productName")
	private WebElement productNameEdt;
	
	@FindBy(name = "productCompany")
	private WebElement productCompanyEdt;
	
	@FindBy(name = "productpricebd")
	private WebElement productpricebdEdt;
	
	@FindBy(name = "productprice")
	private WebElement productpriceEdt;
	
	@FindBy(name = "productDescription")
	private WebElement productDescriptionEdt;
	
	@FindBy(name = "productShippingcharge")
	private WebElement productShippingchargeEdt;

	@FindBy(xpath = "//select[@name='DataTables_Table_0_length']")
	public WebElement showEntriesDropDown;

	@FindBy(xpath = "//td[text()='Apple iPhone 13 Pro Max (Sierra Blue-1TB)']")
	public WebElement appleIphone13;
	
	@FindBy(name = "productAvailability")
	public WebElement productAvailabilityDropDown;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//strong")
	private WebElement messageDis;
	
	@FindBy(xpath = "//input[@name='productimage1']")
	private WebElement image1Btn;
	
	@FindBy(xpath = "//input[@name='productimage2']")
	private WebElement image2Btn;

	@FindBy(xpath = "//td[text()='Iphone']/parent::tr/descendant::i[@class='icon-remove-sign']")
	private WebElement productToDelete;

	public WebElement getOrderManagementBtn() {
		return orderManagementBtn;
	}

	public WebElement getTodaysOrderBtn() {
		return todaysOrderBtn;
	}

	public WebElement getManageProduct() {
		return manageProduct;
	}

	public WebElement getInsterProduct() {
		return insterProduct;
	}

	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}

	public WebElement getSubcategoryDropDown() {
		return subcategoryDropDown;
	}

	public WebElement getShowEntriesDropDown() {
		return showEntriesDropDown;
	}

	public WebElement getAppleIphone13() {
		return appleIphone13;
	}

	public WebElement getProductToDelete() {
		return productToDelete;
	}

	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getProductCompanyEdt() {
		return productCompanyEdt;
	}

	public WebElement getProductpricebdEdt() {
		return productpricebdEdt;
	}

	public WebElement getProductpriceEdt() {
		return productpriceEdt;
	}

	public WebElement getProductDescriptionEdt() {
		return productDescriptionEdt;
	}

	public WebElement getProductShippingchargeEdt() {
		return productShippingchargeEdt;
	}

	public WebElement getProductAvailabilityDropDown() {
		return productAvailabilityDropDown;
	}

	public void OrderManagement() {

		orderManagementBtn.click();
		todaysOrderBtn.click();

	}

	public void ManageProduct() {

		manageProduct.click();

	}
	
	public void InsertProduct() {
		
		insterProduct.click();
		
	}

	public void DeleteProduct() {

		productToDelete.click();

	}
	
	public void InsertProduct(String name, String company, String pricebd, String price, String description, String shippingcharge) {
		
		productNameEdt.sendKeys(name);
		productCompanyEdt.sendKeys(company);
		productpricebdEdt.sendKeys(pricebd);
		productpriceEdt.sendKeys(price);
		productDescriptionEdt.sendKeys(description);
		productShippingchargeEdt.sendKeys(shippingcharge);
		
	}
	
	public void InsertImage(String image1, String image2) {
		
		image1Btn.sendKeys(image1);
		image2Btn.sendKeys(image2);
		
	}
	
	public void Submit() {
		
		submitBtn.click();
		
	}
	
	public String Message() {
		
		return messageDis.getText();
		
	}

}
