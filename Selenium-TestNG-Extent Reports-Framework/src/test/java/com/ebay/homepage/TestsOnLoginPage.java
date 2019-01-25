package com.ebay.homepage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Obj_Homepage;
import pageObjects.Obj_Login_page;
import resources.Base;

public class TestsOnLoginPage extends Base{
	
	private static final Logger logger = LogManager.getLogger(TestsOnLoginPage.class);
	
	@BeforeTest
	public void setup() throws IOException {
		
		driver = initialiseDriver();
		
	}
	
	
	@Test(dataProvider="getData")
	public void login(String username, String password) {
		
		driver.get(prop.getProperty("url"));
		logger.info("URL submitted");
		
		Obj_Homepage obj_home = new Obj_Homepage(driver);
		obj_home.clickLoginLink().click();;
		logger.info("Clicked on Sign in link");
		
		Obj_Login_page obj_login = new Obj_Login_page(driver);
		obj_login.enterUsername().sendKeys(username);
		logger.info("Username entered");
		
		obj_login.enterPassword().sendKeys(password);
		logger.info("Password entered");
		
		obj_login.clickSignInButton().click();
		logger.info("Clicked on Sign in button");
		
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
		driver=null;
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "aa@gmail.com";
		data[0][1] = "abcsd2454";
		data[1][0] = "bb@gmail.com";
		data[1][1] = "124jkjhjh3";
		
		return data;
		
	}
	

}
