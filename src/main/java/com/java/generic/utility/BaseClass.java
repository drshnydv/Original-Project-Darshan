package com.java.generic.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;

	FileUtility FLib = new FileUtility();
	WebDriverUtility WLib = new WebDriverUtility();
	ExcelUtility ELib = new ExcelUtility();

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() {

		System.out.println("Before Suite");

	}
	
	//@Parameters("Browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable{
		
		System.out.println("Launch the Browser");

		String Browser = FLib.getPropertyKeyValue("browser");

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
		
		WLib.waitForElementInDOM(driver);

	}

	/*@BeforeMethod
	public void configBM() throws Throwable {

		String Url = FLib.getPropertyKeyValue("url1");
		String UserName = FLib.getPropertyKeyValue("username");
		String Password = FLib.getPropertyKeyValue("password");

		driver.get(Url);

		HomePage hp = new HomePage(driver);
		Login lp = new Login(driver);

		hp.NavToMyAccount();
		lp.UserLogin(UserName, Password);

		System.out.println("Sucessfully logggedin");

	}

	@AfterMethod
	public void configAM() {

		Logout lop = new Logout(driver);
		lop.UserLogout();

		System.out.println("Sussessfully loggedout");

	}*/

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {

		System.out.println("Closing the browser");
		driver.quit();

	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() {

		System.out.println("After Suite");

	}

}