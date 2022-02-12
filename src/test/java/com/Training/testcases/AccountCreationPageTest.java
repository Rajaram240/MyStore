package com.Training.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Training.dataprovider.DataProviders;
import com.Training.pom.AccountCreationPage;
import com.Training.pom.HomePage;
import com.Training.pom.IndexPage;
import com.Training.pom.LoginPage;



public class AccountCreationPageTest  extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private AccountCreationPage acountCreationPage;
	private HomePage homePage;
	@Test(groups = "Sanity",dataProvider = "email", dataProviderClass = DataProviders.class)
	public void verifyCreateAccountPageTest(String email) throws Throwable
	{
		indexPage= new IndexPage(driver);
		loginPage=indexPage.clickOnSignIn();
		acountCreationPage=loginPage.createNewAccount(email);
		boolean result=acountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
		logger.info("validated");
	}
	
	@Test(groups = "Regression",dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class)
	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
		logger.info("createAccountTest");
		indexPage= new IndexPage(driver);
		loginPage=indexPage.clickOnSignIn();
		acountCreationPage=loginPage.createNewAccount(hashMapValue.get("Email"));
		acountCreationPage.createAccount(
				hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"));
		homePage=acountCreationPage.validateRegistration();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homePage.getCurrURL());
		logger.info("createAccountTest");
	}

}


