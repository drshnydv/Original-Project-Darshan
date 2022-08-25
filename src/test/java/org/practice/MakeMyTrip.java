package org.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://makemytrip.com");
		
		driver.findElement(By.xpath("//p[@data-cy='submit']")).click();
		
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		
		driver.findElement(By.xpath("//span[text()='IndiGo']/ancestor::div[@class='makeFlex hrtlCenter flexOne gap-x-10']/descendant::span[@class='box']")).click();
		
	}

}
