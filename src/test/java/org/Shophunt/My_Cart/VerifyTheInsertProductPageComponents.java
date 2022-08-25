package org.Shophunt.My_Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.java.generic.utility.ExcelUtility;
import com.java.generic.utility.FileUtility;
import com.java.generic.utility.WebDriverUtility;
import com.shophunt.pomrepositrylib.AdminHomePage;
import com.shophunt.pomrepositrylib.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTheInsertProductPageComponents {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = null;

		FileUtility FLib = new FileUtility();
		WebDriverUtility WLib = new WebDriverUtility();
		ExcelUtility ELib = new ExcelUtility();


		String Browser = FLib.getPropertyKeyValue("browser");
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

		driver.manage().window().maximize();

		WLib.waitForElementInDOM(driver);

		Login lp = new Login(driver);
		AdminHomePage ahp = new AdminHomePage(driver);


		//Navigate to application
		driver.get(AdminUrl);

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

		driver.close();


	}

}
