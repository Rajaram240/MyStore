package com.Training.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Training.dataprovider.DataProviders;
import com.Training.pom.AddToCartPage;
import com.Training.pom.IndexPage;
import com.Training.pom.SearchResultPage;


public class AddToCartPageTest extends BaseClass{
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;

	@Test(groups = {"Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void addToCartTest(String productName, String qty, String size) throws Throwable {
		logger.info("addToCartTest");
		index= new IndexPage(driver);
		searchResultPage=index.search(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		logger.info("addToCartTest");
		
	}
}

