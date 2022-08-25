package org.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public void HandelPopUp() throws AWTException {

		//creating Robot class for Handling Pop up
		Robot click = new Robot();

		click.keyPress(KeyEvent.VK_ENTER);
		click.keyRelease(KeyEvent.VK_ENTER);

	}

	public static String getEData(String sheet, int row, int col) throws Throwable {

		//creating FileInputSream to load Excel File
		FileInputStream fise = new FileInputStream("./data/TestData.xlsx");

		//creating Workbook 
		Workbook book = WorkbookFactory.create(fise);

		String E = book.getSheet(sheet).getRow(row).getCell(col).toString();
		return E;
	}

	public static String getPData(String value) throws Throwable {

		//use FileInputStream to load Property File
		FileInputStream fis = new FileInputStream("./data/commonData.properties");

		//create object of properties and load the File
		Properties prop = new Properties();
		prop.load(fis);

		String P = prop.getProperty(value);

		return P;

	}


	public static void main(String[] args) throws Throwable {
		

		WebDriver driver = null;

		Practice handel = new Practice();

		if(getPData("browser").equalsIgnoreCase("Chrome")) {

			//initiate browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();


		}

		else if(getPData("browser").equalsIgnoreCase("Firefox")) {

			//initiate browser
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		//WebDriverWait wait = new WebDriverWait(driver, 10);

		//maximize browser window
		driver.manage().window().maximize();

		//declare implicit wait
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		//navigate to application
		driver.get(getPData("url"));

		//navigate to my account
		driver.findElement(By.xpath("//a[text()='My Account']")).click();

		//Enter the valid credentials in all the text box
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(getPData("username"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(getPData("password"));

		//click on sign up
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		//adding a book to a cart as per the precondition
		driver.findElement(By.xpath("//a[text()=' Books']")).click();
		driver.findElement(By.xpath("//a[text()='The Wimpy Kid Do -It- Yourself Book']")).click();
		driver.findElement(By.xpath("//a[text()=' ADD TO CART']")).click();

		//handling Updated to cart pop up
		handel.HandelPopUp();
		
		Thread.sleep(3000);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='billingaddress']")));\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		driver.findElement(By.xpath("//span[@class='ir']")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		handel.HandelPopUp();

		//updating Shipping address
		driver.findElement(By.xpath("//textarea[@name='billingaddress']")).clear();
		driver.findElement(By.xpath("//textarea[@name='billingaddress']")).sendKeys(getEData("My_Cart", 1, 2));

		driver.findElement(By.xpath("//input[@name='bilingstate']")).clear();
		driver.findElement(By.xpath("//input[@name='bilingstate']")).sendKeys(getEData("My_Cart", 1, 3));

		driver.findElement(By.xpath("//input[@name='billingcity']")).clear();
		driver.findElement(By.xpath("//input[@name='billingcity']")).sendKeys(getEData("My_Cart", 1, 4));

		driver.findElement(By.xpath("//input[@name='billingpincode']")).clear();
		driver.findElement(By.xpath("//input[@name='billingpincode']")).sendKeys(getEData("My_Cart", 1, 5));

		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();

		//handling Shipping address updated pop up
		handel.HandelPopUp();

		//updating Billing address
		driver.findElement(By.xpath("//textarea[@name='shippingaddress']")).clear();
		driver.findElement(By.xpath("//textarea[@name='shippingaddress']")).sendKeys(getEData("Practice", 1, 2));

		driver.findElement(By.xpath("//input[@name='shippingstate']")).clear();
		driver.findElement(By.xpath("//input[@name='shippingstate']")).sendKeys(getEData("Practice", 4, 2));

		driver.findElement(By.xpath("//input[@name='shippingcity']")).clear();
		driver.findElement(By.xpath("//input[@name='shippingcity']")).sendKeys(getEData("Practice", 7, 2));

		driver.findElement(By.xpath("//input[@name='shippingpincode']")).clear();
		driver.findElement(By.xpath("//input[@name='shippingpincode']")).sendKeys(getEData("Practice", 10, 2));

		driver.findElement(By.xpath("(//button[text()='Update'])[2]")).click();

		//handling Updates shipping address pop up
		handel.HandelPopUp();

		//click on Proceed to checkout
		driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();


	}

}