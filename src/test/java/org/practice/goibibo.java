package org.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class goibibo {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com");
		
		driver.findElement(By.xpath("//div[@class='sc-bkkeKt gAqCbJ fswFld ']/descendant::p")).click();
		driver.findElement(By.xpath("//input")).sendKeys("Banglore");
		driver.findElement(By.xpath("//p[text()='Bengaluru International Airport']")).click();
		
		//driver.findElement(By.xpath("//div[@class='sc-hiCibw hIEqKD']/descendant::p")).click();
		driver.findElement(By.xpath("//input")).sendKeys("London");
		driver.findElement(By.xpath("//p[text()='Heathrow Airport']")).click();
		
		driver.findElement(By.xpath("//div[text()='September 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='30']")).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		
		driver.findElement(By.xpath("//p[text()='Adults']/parent::div[@class='sc-ehCJOs kXqgMf']/descendant::span[@class='sc-Galmp clPQEB']/following-sibling::span/child::*")).click();
		driver.findElement(By.xpath("//li[text()='business']")).click();
		driver.findElement(By.xpath("//a[text()='Done']")).click();
		
		driver.findElement(By.xpath("//p[text()='Click to add a return flight for better discounts']")).click();
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		driver.findElement(By.xpath("//div[text()='December 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='31']")).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		
		driver.findElement(By.xpath("//a[text()='Done']")).click();
		
		driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
		
	}

}