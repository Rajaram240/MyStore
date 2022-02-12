package com.Training.testcases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Training.dataprovider.DataProviders;
import com.Training.pom.AddToCartPage;
import com.Training.pom.AddressPage;
import com.Training.pom.IndexPage;
import com.Training.pom.LoginPage;
import com.Training.pom.OrderConfirmationPage;
import com.Training.pom.OrderPage;
import com.Training.pom.OrderSummary;
import com.Training.pom.PaymentPage;
import com.Training.pom.SearchResultPage;
import com.Training.pom.ShippingPage;

public class EndToEndTest extends BaseClass {
	public static Properties prop;
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummary orderSummary;
	private OrderConfirmationPage orderConfirmationPage;
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void endToEndTest(String productName, String qty, String size) throws Throwable {
		logger.info("endToEndTesting start");
		logger.info("index page start");
		index= new IndexPage(driver);
		logger.info("search product ");
		searchResultPage=index.search(productName);
		logger.info("searchresult");
		addToCartPage=searchResultPage.clickOnProduct();
		logger.info("addToCartPage enter quantity");
		addToCartPage.enterQuantity(qty);
		logger.info("addToCartPage enter size");
		addToCartPage.selectSize(size);
		logger.info("click on addToCartPage");
		addToCartPage.clickOnAddToCart();
		logger.info("addToCartPage checkout");
		orderPage=addToCartPage.clickOnCheckOut();
		logger.info("user login");
		loginPage=orderPage.clickOnCheckOut();
		logger.info("address page");
		
			addressPage=	loginPage.setUserName(username);
				loginPage.setPassword(password);
				loginPage.clickSubmit();
		
		logger.info("shipping page");
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		logger.info("payment page");
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		logger.info("order summary page");
		orderSummary=paymentPage.clickOnPaymentMethod();
		logger.info("orderConfirmationPage");
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		logger.info("validated");
		logger.info("endToEndTesting ends");
	}

}
