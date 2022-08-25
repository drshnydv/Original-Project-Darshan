package org.Shophunt.My_Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.java.generic.utility.FileUtility;
import com.java.generic.utility.WebDriverUtility;
import com.shophunt.pomrepositrylib.AdminHomePage;
import com.shophunt.pomrepositrylib.Login;
import com.shophunt.pomrepositrylib.Logout;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DeleteTheProductAndVerify {

	public static void main(String[] args) throws Throwable {

		FileUtility FLib = new FileUtility();
		WebDriverUtility WLib = new WebDriverUtility();

		String Browser = FLib.getPropertyKeyValue("browser");
		String AdminUrl = FLib.getPropertyKeyValue("adminurl");
		String AdminId = FLib.getPropertyKeyValue("adminid");
		String AdminPassword = FLib.getPropertyKeyValue("adminpassword");

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

		driver.manage().window().maximize();

		WLib.waitForElementInDOM(driver);

		Login lp = new Login(driver);
		AdminHomePage ahp = new AdminHomePage(driver);
		Logout lop = new Logout(driver);

		//Navigate to application
		driver.get(AdminUrl);

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

		driver.close();

	}

}
