package com.test.demotest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.demo.TestCaseBase.TestCaseBase;
import com.test.demo.basepages.LoginPage;
import com.test.util.Log;

public class LoginwithInvalidCredentials extends TestCaseBase {
	
	@Parameters({"username","password"})
	@Test
	public void TestScript(String username,String password) {
		
		LoginPage loginpage = new LoginPage(driver);
		
		//loginpage.UserLogin("standard_user", "secret_sauce");
		Log.info("Starting login test...");

		test.info("User Logging in");
		loginpage.Login(username, password);
		test.pass("Login Unsuccesfully");
	}

}
