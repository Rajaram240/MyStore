package com.Training.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Training.dataprovider.DataProviders;
import com.Training.pom.IndexPage;
import com.Training.pom.SearchResultPage;



public class SearchResultPageTest extends BaseClass {
	private IndexPage index;
	private SearchResultPage searchResultPage;
	
	@Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void productAvailabilityTest(String productName) throws Throwable
	{
		index= new IndexPage(driver);
		searchResultPage=index.search(productName);
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		logger.info("productAvailabilityTest");
	}
	}

