package com.shophunt.pomrepositrylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {

	public Logout(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutBtn;

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement logOutDropDdownBtn;

	public WebElement getUserLogoutBtn() {
		return logoutBtn;
	}

	public void UserLogout() {

		logoutBtn.click();

	}

	public void AdminLogout() {

		logOutDropDdownBtn.click();
		logoutBtn.click();

	}

}
