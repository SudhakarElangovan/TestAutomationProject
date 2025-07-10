package com.test.demotest;

import org.testng.annotations.Test;

import com.test.demo.TestCaseBase.TestCaseBase;
import com.test.demo.basepages.LoginPage;

public class TestDemoScript01 extends TestCaseBase {
	
	@Test
	public void TestScript() {
		
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.UserLogin("standard_user", "secret_sauce");
		driver.getTitle();
		
	}

}
