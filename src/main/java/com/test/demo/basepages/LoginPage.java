package com.test.demo.basepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.util.Log;

public class LoginPage {

	private WebDriver driver;
	
	By UserNameTextBox = By.id("user-name");
	
//	By PasswordTextBox = By.id("password");
	
//	By LoginButton = By.id("login-button");
	
	@FindBy(xpath="//input[@id='login-button']")
	public WebElement LoginButton;
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement usernameTextbox;
	
	@FindBy(id="password")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//div[@class='app_logo']")
	WebElement PageTitle;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username) {
		
		//usernameTextbox.clear();
	//	usernameTextbox.sendKeys(username);
//		driver.findElement(usernameTextBox).clear();
		driver.findElement(UserNameTextBox).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
//		driver.findElement(passwordTextBox).clear();
//		driver.findElement(passwordTextBox).sendKeys(password);
	}

	public void clickLogin() {
		
		Log.info("Clicking login button..");
		LoginButton.click();
//		driver.findElement(loginButton).click();	
	}
	public void Login(String UserName,String Password) {
		Log.info("Adding credentials");
		enterUsername(UserName);
		enterPassword(Password);
		clickLogin();
		Assert.assertTrue(PageTitle.getText().contains("Swag Labs"), "Title is Displayed");
		//return PageTitle.getText().contains("Swag Labs");
	}
}
