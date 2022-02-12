package com.Training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Training.testcases.BaseClass;

public class SearchResultPage  extends BaseClass{
WebDriver ldriver;
	
	public  SearchResultPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	public boolean isProductAvailable() throws Throwable {
		
		return productResult.isDisplayed();
	}
	public AddToCartPage clickOnProduct() throws Throwable {
		productResult.click();
		
		return new AddToCartPage(ldriver);
	}
	
	

}
