package com.Training.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Training.pom.IndexPage;



public class IndexPageTest extends BaseClass {
	private IndexPage indexPage;
	
	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable {
		driver.getCurrentUrl();
		logger.info("URL is opened");
		indexPage=new IndexPage(driver);
	boolean logo=indexPage.validateLogo();
		Assert.assertTrue(logo);
		System.out.println(logo);
		logger.info("Logo is validated");
	}
	@Test(groups = "Smoke")
	public void getStoreTitle() {

		logger.info("title validation started");
		indexPage=new IndexPage(driver);
		String actTitle=indexPage.getStoreTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "My Store");
		logger.info("title is validated");
	}

}
