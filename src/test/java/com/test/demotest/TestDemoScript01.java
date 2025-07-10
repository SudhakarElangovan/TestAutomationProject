package com.test.demotest;

import org.testng.annotations.Test;

import com.test.demo.TestCaseBase.TestCaseBase;
import com.test.demo.basepages.LoginPage;
import com.test.util.Log;

public class TestDemoScript01 extends TestCaseBase {
	
	@Test
	public void TestScript() {
		
		LoginPage loginpage = new LoginPage(driver);
		
		//loginpage.UserLogin("standard_user", "secret_sauce");
		Log.info("Starting login test...");
	//	test = ExtentReportManager.createTest("Login Test - ");

	//	test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);

		Log.info("Adding credentials");
	//	test.info("Adding Credentails");
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
//		loginPage.enterUsername(username);
//		loginPage.enterPassword(password);
	//	test.info("Clicking on Login button");
		loginPage.clickLogin();		
	}

}
