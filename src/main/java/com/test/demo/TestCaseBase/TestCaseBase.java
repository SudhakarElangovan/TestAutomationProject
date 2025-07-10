package com.test.demo.TestCaseBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestCaseBase {
	
	public  WebDriver driver;
	@BeforeTest
	public void Setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		
	}

	@AfterTest
	public void TearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
