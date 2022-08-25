package org.practice;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.java.generic.utility.BaseClass;
import com.java.generic.utility.ExcelUtility;
import com.java.generic.utility.FileUtility;
import com.java.generic.utility.WebDriverUtility;
import com.shophunt.pomrepositrylib.AddToCartBtn;
import com.shophunt.pomrepositrylib.AdminHomePage;
import com.shophunt.pomrepositrylib.BedsPage;
import com.shophunt.pomrepositrylib.ElectronicsPage;
import com.shophunt.pomrepositrylib.FashionPage;
import com.shophunt.pomrepositrylib.FootwarePage;
import com.shophunt.pomrepositrylib.FurnituresPage;
import com.shophunt.pomrepositrylib.HomePage;
import com.shophunt.pomrepositrylib.Login;
import com.shophunt.pomrepositrylib.Logout;
import com.shophunt.pomrepositrylib.MobilesPage;
import com.shophunt.pomrepositrylib.MyCartPage;
import com.shophunt.pomrepositrylib.PaymentPage;

public class Sample extends BaseClass {
	
	FileUtility FLib = new FileUtility();
	WebDriverUtility WLib = new WebDriverUtility();
	ExcelUtility ELib = new ExcelUtility();
	
	@Test(priority = 1)
	public void test1() throws Throwable {
		
		String Url = FLib.getPropertyKeyValue("url1");
		String UserName = FLib.getPropertyKeyValue("username");
		String Password = FLib.getPropertyKeyValue("password");

		String BillingAddress = ELib.getExcelData("My_Cart", 1, 6);
		String BillingState = ELib.getExcelData("My_Cart", 1, 3);
		String BillingCity = ELib.getExcelData("My_Cart", 1, 4);
		String BillingPincode = ELib.getExcelData("My_Cart", 1, 5);
		String ShippingAddress = ELib.getExcelData("My_Cart", 1, 6);
		String ShippingState = ELib.getExcelData("My_Cart", 1, 7);
		String ShippingCity = ELib.getExcelData("My_Cart", 1, 8);
		String ShippingPincode = ELib.getExcelData("My_Cart", 1, 9);

		HomePage hp = new HomePage(driver);
		Login lp = new Login(driver);
		ElectronicsPage ep = new ElectronicsPage(driver);
		MobilesPage mp = new MobilesPage(driver);
		AddToCartBtn atc = new AddToCartBtn(driver);
		FurnituresPage fp = new FurnituresPage(driver);
		BedsPage bp = new BedsPage(driver);
		FashionPage fasp = new FashionPage(driver);
		FootwarePage footp = new FootwarePage(driver);
		MyCartPage mcp = new MyCartPage(driver);
		PaymentPage pp = new PaymentPage(driver);

		//navigate to application
	    driver.get(Url);
	    
	    //Login 
	    hp.NavToMyAccount();
	    lp.UserLogin(UserName, Password);
		
		//navigate to Electronics page
		hp.NavToElectronics();;


		//navigate to mobiles in sub category
		ep.getMobliesLnk();

		//select a particular mobile 
		mp.GetIphone13();

		//click on add to cart button
		atc.AddToCart();

		//click on OK button on “product has been added to cart” message popup
		WLib.swithToAlertWindowAndAccpect(driver,"Product has been added to the cart");

		//navigate to Furniture page
		hp.NavToFurnitureLnk();

		//navigate to Beds in sub category
		fp.GetBedsLnk();

		//select a particular Bed 
		bp.GetInduscraft();

		//click on add to cart button
		atc.AddToCart();

		//click on OK button on “Product has been added to cart” message popup
		WLib.swithToAlertWindowAndAccpect(driver,"Product has been added to the cart");

		//navigate to Fashion page
		hp.NavToFashion();

		//navigate to Men Footwares in sub category
		fasp.GetFootwareLnk();

		//select a particular Footware 
		footp.GetAdidasMessiShoes();

		//click on add to cart button
		atc.AddToCart();

		//click on OK button on “Product has been added to cart” message popup
		WLib.swithToAlertWindowAndAccpect(driver,"Product has been added to the cart");

		//increase the quantity of the products
		mcp.IncreaseTheProductsQuantity();

		//click on “update shopping” cart button
		mcp.UpdateShoppingCart();

		//click on OK button on Your cart has been added to cart message popup
		WLib.swithToAlertWindowAndAccpect(driver,"Your Cart hasbeen Updated");

		//updating Shipping address
		mcp.UpadteShippingAddress(ShippingAddress, ShippingState, ShippingCity, ShippingPincode);

		//handling Shipping address updated pop up
		WLib.swithToAlertWindowAndAccpect(driver,"Billing Address has been updated");

		//updating Billing address
		mcp.UpadteBillingAddress(BillingAddress, BillingState, BillingCity, BillingPincode);
		
		//SoftAssert sa = new SoftAssert();
		//sa.assertEquals(true, false);

		//handling Updates shipping address pop up
		WLib.swithToAlertWindowAndAccpect(driver,"Shipping Address has been updated");

		//click on Proceed to checkout
		mcp.ProceedToChechOut();

		//click on submit button in chose payment method
		pp.SubmitPayment();
		
		Logout lop = new Logout(driver);
		lop.UserLogout();

		System.out.println("Sussessfully loggedout");
		
		//sa.assertAll();

	}

	@Test(priority = 2)
	public void BuyAProductAndCheck() throws Throwable {

		String Url = FLib.getPropertyKeyValue("url1");
		String AdminUrl = FLib.getPropertyKeyValue("adminurl");
		String AdminId = FLib.getPropertyKeyValue("adminid");
		String AdminPassword = FLib.getPropertyKeyValue("adminpassword");
		String UserName = FLib.getPropertyKeyValue("username1");
		String Password = FLib.getPropertyKeyValue("password1");

		String BillingAddress = ELib.getExcelData("My_Cart", 4, 2);
		String BillingState = ELib.getExcelData("My_Cart", 4, 3);
		String BillingCity = ELib.getExcelData("My_Cart", 4, 4);
		String BillingPincode = ELib.getExcelData("My_Cart", 4, 5);
		String ShippingAddress = ELib.getExcelData("My_Cart", 4, 6);
		String ShippingState = ELib.getExcelData("My_Cart", 4, 7);
		String ShippingCity = ELib.getExcelData("My_Cart", 4, 8);
		String ShippingPincode = ELib.getExcelData("My_Cart", 4, 9);

		//navigate to application
		driver.navigate().to(Url);

		HomePage hp = new HomePage(driver);
		Login lp = new Login(driver);
		ElectronicsPage ep = new ElectronicsPage(driver);
		MobilesPage mp = new MobilesPage(driver);
		AddToCartBtn atc = new AddToCartBtn(driver);
		MyCartPage mcp = new MyCartPage(driver);
		PaymentPage pp = new PaymentPage(driver);
		Logout lop = new Logout(driver);
		AdminHomePage ahp = new AdminHomePage(driver);

		//Login 
		hp.NavToMyAccount();
		lp.UserLogin(UserName, Password);

		//navigate to Electronics page
		hp.NavToElectronics();;

		//navigate to mobiles in sub category
		ep.getMobliesLnk();

		//select a particular mobile 
		mp.GetIphone13();

		//click on add to cart button
		atc.AddToCart();

		//Click on Ok in the popup 
		WLib.swithToAlertWindowAndAccpect(driver,"Product has been added to the cart");

		//updating Shipping address
		mcp.UpadteShippingAddress(ShippingAddress, ShippingState, ShippingCity, ShippingPincode);

		//handling Shipping address updated pop up
		WLib.swithToAlertWindowAndAccpect(driver,"Billing Address has been updated");

		//updating Billing address
		mcp.UpadteBillingAddress(BillingAddress, BillingState, BillingCity, BillingPincode);

		//handling Updates shipping address pop up
		WLib.swithToAlertWindowAndAccpect(driver,"Shipping Address has been updated");

		//click on Proceed to checkout
		mcp.ProceedToChechOut();

		//click on submit button in chose payment method
		pp.SubmitPayment();

		//log out from user module
		lop.UserLogout();

		//Navigate to application
		driver.navigate().to(AdminUrl);

		//Enter username, password and click on Login button
		lp.AdminLogin(AdminId, AdminPassword);

		//Click on Order Management drop down and select the Today's Order tab
		ahp.OrderManagement();

		//Click on Show Entry dropdown and select the option 10
		WLib.selectV(ahp.showEntriesDropDown, "100");

		//
		WebElement P = ahp.appleIphone13;

		if(P.isDisplayed()) {

			System.out.println("Test case passed");
		}

		else {

			System.out.println("Test case failed");

		}

	}

	@Test(priority = 3)
	public void VerifyInsertPageComp() throws Throwable {

		String AdminUrl = FLib.getPropertyKeyValue("adminurl");
		String AdminId = FLib.getPropertyKeyValue("adminid");
		String AdminPassword = FLib.getPropertyKeyValue("adminpassword");


		String Category = ELib.getExcelData("Create_Category", 4, 2);
		String SubCategory = ELib.getExcelData("Create_Category", 4, 3);
		String ProductName = ELib.getExcelData("Create_Category", 4, 4);
		String ProductCompany = ELib.getExcelData("Create_Category", 4, 5);
		String ProductPriceBD = ELib.getExcelData("Create_Category", 4, 6);
		String ProductPrice = ELib.getExcelData("Create_Category", 4, 7);
		String ProductDescription = ELib.getExcelData("Create_Category", 4, 8);
		String ProductShippingCharge = ELib.getExcelData("Create_Category", 4, 9);
		String image1 = "D:\\Eclipse\\eclipse_workspace\\Shopping_Selenium_project\\photos\\iphone1.jpeg";
		String image2 = "D:\\Eclipse\\eclipse_workspace\\Shopping_Selenium_project\\photos\\iphone2.jpg";

		Login lp = new Login(driver);
		AdminHomePage ahp = new AdminHomePage(driver);


		//Navigate to application
		driver.navigate().to(AdminUrl);

		//Enter username, password and click on Login button
		lp.AdminLogin(AdminId, AdminPassword);

		//Click on Manage Products major tab
		ahp.InsertProduct();

		WLib.select(ahp.getCategoryDropDown(), Category);

		WLib.select(ahp.getSubcategoryDropDown(), SubCategory);

		ahp.InsertProduct(ProductName, ProductCompany, ProductPriceBD, ProductPrice, ProductDescription, ProductShippingCharge);

		WLib.selectV(ahp.getProductAvailabilityDropDown(), "In Stock");

		ahp.InsertImage(image1, image2);

		ahp.Submit();

		String text = ahp.Message();

		if(text.contains("Well done!")) {

			System.out.println("Test case pass");

		}

		else {

			System.out.println("Test case Fail");

		}

	}

	@Test(priority = 4)
	public void DeleteTheProduct() throws Throwable {

		String AdminUrl = FLib.getPropertyKeyValue("adminurl");
		String AdminId = FLib.getPropertyKeyValue("adminid");
		String AdminPassword = FLib.getPropertyKeyValue("adminpassword");

		Login lp = new Login(driver);
		AdminHomePage ahp = new AdminHomePage(driver);
		Logout lop = new Logout(driver);

		//Navigate to application
		driver.navigate().to(AdminUrl);

		//Enter username, password and click on Login button
		lp.AdminLogin(AdminId, AdminPassword);

		//Click on Manage Products major tab
		ahp.ManageProduct();

		//Click on Show Entry dropdown and select the option 10
		WLib.selectV(ahp.getShowEntriesDropDown(), "100");

		//Select one product and click on delete icon
		ahp.DeleteProduct();

		//Click on Ok in the popup 
		WLib.swithToAlertWindowAndAccpect(driver, "Are you sure you want to delete?");

		//Logout
		lop.AdminLogout();

	}

}