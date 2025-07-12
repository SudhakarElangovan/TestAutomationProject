package com.test.demo.TestCaseBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.test.util.ExtentReportManager;
import com.test.util.Log;

public class TestCaseBase {
	
	protected static ExtentReports extent;
	protected static ExtentTest test;
	public  WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		Log.info("Starting WebDriver...");
		test = ExtentReportManager.createTest("Test");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test.info("Navigating to URL");
		Log.info("Navigating to URL...");
		driver.get("https://www.saucedemo.com/");
		
		
	}
	
	
	
	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
	}
	
	@AfterSuite
	public void teardownReport() {
		extent.flush();
		//String reportPath = ExtentReportManager.reportPath;
		//EmailUtils.sendTestReport(reportPath);
	}
	
	@AfterMethod
public void tearDown(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			
			String screenshotPath = ExtentReportManager.captureScreenshot(driver, "FailScreenshot");
			test.fail("Test Failed.. Check Screenshot", 
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		
		
		if (driver != null) {
			Log.info("Closing Browser...");
			driver.quit();
		}
	}

}
