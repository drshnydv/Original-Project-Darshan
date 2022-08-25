package org.Shophunt.My_Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.java.generic.utility.ExcelUtility;
import com.java.generic.utility.FileUtility;
import com.java.generic.utility.WebDriverUtility;
import com.shophunt.pomrepositrylib.AddToCartBtn;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Increasing_the_number_of_Products {

	public static void main(String[] args) throws Throwable {

		FileUtility FLib = new FileUtility();
		WebDriverUtility WLib = new WebDriverUtility();
		ExcelUtility ELib = new ExcelUtility();


		String Browser = FLib.getPropertyKeyValue("browser");
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

		WebDriver driver = null;

		if(Browser.equalsIgnoreCase("Chrome")) {

			//initiate browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();


		}

		else if(Browser.equalsIgnoreCase("Firefox")) {

			//initiate browser
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		//maximize browser window
		driver.manage().window().maximize();

		//declare implicit wait
		WLib.waitForElementInDOM(driver);

		//navigate to application
		driver.get(Url);

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
		Logout lop = new Logout(driver);

		//Login 
		hp.NavToMyAccount();
		lp.UserLogin(UserName, Password);

		//navigate to Electronics page
		hp.NavToElectronics();


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

		//handling Updates shipping address pop up
		WLib.swithToAlertWindowAndAccpect(driver,"Shipping Address has been updated");

		//click on Proceed to checkout
		mcp.ProceedToChechOut();
		
		//click on submit button in chose payment method
		pp.SubmitPayment();

		//log out from user module
		lop.UserLogout();

		driver.close();

	}

}