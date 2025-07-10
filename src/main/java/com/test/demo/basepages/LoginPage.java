package com.test.demo.basepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	By UserNameTextBox = By.id("user-name");
	
	By PasswordTextBox = By.id("password");
	
	By LoginButton = By.id("login-button");
	
	public LoginPage(WebDriver Driver) {
		this.driver=Driver;
	}
	
	public void UserLogin(String UserName,String Password) {
		
		driver.findElement(UserNameTextBox).clear();
		driver.findElement(UserNameTextBox).sendKeys(UserName);
		driver.findElement(PasswordTextBox).clear();
		driver.findElement(PasswordTextBox).sendKeys(Password);
		driver.findElement(LoginButton).click();
	}
}
