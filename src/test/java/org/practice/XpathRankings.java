package org.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathRankings {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://olympics.com/en/");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple");
		
		//driver.findElement(By.id("nav-search-submit-button")).click();
		
		List<WebElement> E = driver.findElements(By.xpath("//span[text()='Eliud KIPCHOGE']/ancestor::li/descendant::div[@class='featured-athlete__medals text-body-sm']/span"));
		
		for (WebElement lv : E) {
			
			System.out.println(lv.getText());
			
		}
		 
		/*List<WebElement> F = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		 List<WebElement> E1 = driver.findElements(By.xpath("//span[contains(text(),'Apple')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price']"));	
		 
		 for(int i = 0 ; i<F.size(); i++) {
			 
			 System.out.println(F.get(i).getText()+" , "+E1.get(i).getText());
			 
		 }*/

	}

}