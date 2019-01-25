package com.ebay.homepage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Obj_Homepage;
import resources.Base;

public class TestsOnHomepage extends Base {

	private static final Logger logger = LogManager.getLogger(TestsOnHomepage.class);

	@BeforeTest
	public void setup() throws IOException {

		driver = initialiseDriver();
		driver.get(prop.getProperty("url"));
		logger.info("URL submitted");

	}

	@Test
	public void verifyHomePageTitle() {
		String titleContent = driver.getTitle();
		Assert.assertEquals(titleContent, "abcefe");
		logger.info("Title Verified");

	}

	@Test
	public void verifyNavigationBar() {

		Obj_Homepage obj_home = new Obj_Homepage(driver);
		Assert.assertTrue(obj_home.checkNavigationBar().isDisplayed());
		logger.info("Verified the navigation bar");
	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;
	}
}
