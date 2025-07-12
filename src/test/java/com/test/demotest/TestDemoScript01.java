package com.test.demotest;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.demo.TestCaseBase.TestCaseBase;
import com.test.demo.basepages.LoginPage;
import com.test.util.ExcelUtils;
import com.test.util.Log;

public class TestDemoScript01 extends TestCaseBase {
	
	
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException{
		
		String filePath = System.getProperty("user.dir")+"/src/main/resources/TestData/Cred.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];
		
		for(int i=1; i<rowCount; i++) {
			
			data[i-1][0] = ExcelUtils.getCellData(i, 0);	// Username
			data[i-1][1] = ExcelUtils.getCellData(i, 1);	// Password
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
	
	@DataProvider(name="LoginData2")
	public Object[][] getData(){
		
		return new Object[][] {
			{"user1","pass1"},
			{"user2","pass2"},
			{"user3","pass3"}
		};
	}
	
	@Test(dataProvider = "LoginData2")
//	@Test
	//@Parameters({"username","password"})
	//@Test

	public void TestScript(String username,String password) {
		
		LoginPage loginpage = new LoginPage(driver);
		
		//loginpage.UserLogin("standard_user", "secret_sauce");
		Log.info("Starting login test...");

		test.info("User Logging in");
		test.info("UserName "+username);
		loginpage.Login(username, password);
		test.pass("Login Succesfully");
	}

}
