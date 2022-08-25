package org.practiceagain;

import org.testng.annotations.Test;

import com.java.generic.utility.BaseClass;
import com.java.generic.utility.ExcelUtility;
import com.java.generic.utility.FileUtility;
import com.java.generic.utility.WebDriverUtility;
import com.shophunt.pomrepositrylib.AdminHomePage;
import com.shophunt.pomrepositrylib.Login;
import com.shophunt.pomrepositrylib.Logout;

public class DeleteProductComponentTest extends BaseClass {
	
	FileUtility FLib = new FileUtility();
	WebDriverUtility WLib = new WebDriverUtility();
	ExcelUtility ELib = new ExcelUtility();
	
	@Test(groups = "regressionTest")
	public void test() throws Throwable {


		String AdminUrl = FLib.getPropertyKeyValue("adminurl");
		String AdminId = FLib.getPropertyKeyValue("adminid");
		String AdminPassword = FLib.getPropertyKeyValue("adminpassword");
		
		driver.get(AdminUrl);

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