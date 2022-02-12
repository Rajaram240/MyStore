package com.Training.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Training.dataprovider.DataProviders;
import com.Training.pom.AddToCartPage;
import com.Training.pom.IndexPage;
import com.Training.pom.OrderPage;
import com.Training.pom.SearchResultPage;


public class OrderPageTest extends BaseClass{
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
		logger.info("verifyTotalPrice");
		index= new IndexPage(driver);
		searchResultPage=index.search(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		logger.info("clickoncheckoutpage");
		orderPage=addToCartPage.clickOnCheckOut();
		logger.info("checkoutpage");
		Double unitPrice=orderPage.getUnitPrice();
		logger.info("valiadte unitprice");
		Double totalPrice=orderPage.getTotalPrice();
		System.out.println(totalPrice);
		logger.info("valiadte totalprice");
		Double totalExpectedPrice=(totalPrice)+2;
		System.out.println(totalExpectedPrice);
		logger.info("valiadte totalexpectedprice");
		Assert.assertEquals(totalPrice+2, totalExpectedPrice);
		logger.info("verifyiedTotalPrice");
	}
}
 