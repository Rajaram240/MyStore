package com.Training.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Training.pom.IndexPage;
import com.Training.pom.LoginPage;



public class LoginPageTest extends BaseClass {
	private LoginPage loginPage;
	private IndexPage indexPage;
	
	@Test(groups = "Smoke")
	public void loginTest() throws IOException 
	{
		logger.info("loginTest");
	indexPage= new IndexPage(driver);
	logger.info("user is going to click on SignIn");
	loginPage=indexPage.clickOnSignIn();
		logger.info("enter uname and password");
		loginPage=new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("Entered username");
				
		loginPage.setPassword(password);
				logger.info("Entered password");
				loginPage.clickSubmit();
				String actualURL=driver.getCurrentUrl();
			    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
			    logger.info("Verifying if user is able to login");
			    Assert.assertEquals(actualURL, expectedURL);
			    logger.info("Login is Sucess");
	}
}
