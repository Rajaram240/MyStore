package com.Training.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Training.pom.HomePage;
import com.Training.pom.IndexPage;
import com.Training.pom.LoginPage;


public class HomePageTest extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
//	@Test
//	public void wishListTest() throws Throwable
//	{ 
//		logger.info("loginTest for wishlist validation");
//		indexPage= new IndexPage(driver);
//		loginPage=indexPage.clickOnSignIn();
//		logger.info("enter uname and password");
//		loginPage=new LoginPage(driver);
//		loginPage.setUserName(username);
//		logger.info("Entered username");
//				
//		loginPage.setPassword(password);
//				logger.info("Entered password");
//				loginPage.clickSubmit();
//				
//				boolean result=homePage.validateMyWishList();
//				Assert.assertTrue(result);
//				logger.info("wishlist found");
//	}
@	Test
	public void wishlistAndorderHistoryandDetailsTest() throws Throwable {
	logger.info("loginTest for order history validation");
	indexPage= new IndexPage(driver);
	loginPage=indexPage.clickOnSignIn();
	logger.info("enter uname and password");
	loginPage=new LoginPage(driver);
	loginPage.setUserName(username);
	logger.info("Entered username");
			
	loginPage.setPassword(password);
			logger.info("Entered password");
			loginPage.clickSubmit();
			
			homePage=new HomePage(driver);
			logger.info("navigated to homepage");
			boolean result=homePage.validateOrderHistory();
			System.out.println("result");
			Assert.assertTrue(result);
			
			
			logger.info("order history validated");
			boolean results=homePage.validateMyWishList();
	Assert.assertTrue(results);
	logger.info("wishlist found");
}
}