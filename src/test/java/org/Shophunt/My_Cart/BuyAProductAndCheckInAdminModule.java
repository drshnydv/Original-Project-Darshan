package org.Shophunt.My_Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.java.generic.utility.ExcelUtility;
import com.java.generic.utility.FileUtility;
import com.java.generic.utility.WebDriverUtility;
import com.shophunt.pomrepositrylib.AddToCartBtn;
import com.shophunt.pomrepositrylib.AdminHomePage;
import com.shophunt.pomrepositrylib.ElectronicsPage;
import com.shophunt.pomrepositrylib.HomePage;
import com.shophunt.pomrepositrylib.Login;
import com.shophunt.pomrepositrylib.Logout;
import com.shophunt.pomrepositrylib.MobilesPage;
import com.shophunt.pomrepositrylib.MyCartPage;
import com.shophunt.pomrepositrylib.PaymentPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyAProductAndCheckInAdminModule {

	public static void main(String[] args) throws Throwable {

		FileUtility FLib = new FileUtility();
		WebDriverUtility WLib = new WebDriverUtility();
		ExcelUtility ELib = new ExcelUtility();


		String Browser = FLib.getPropertyKeyValue("browser");
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

		driver.close();

	}

}