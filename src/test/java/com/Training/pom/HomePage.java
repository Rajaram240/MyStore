package com.Training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Training.testcases.BaseClass;

public class HomePage extends BaseClass{
WebDriver ldriver;
	
	public  HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//span[contains(text(),'My wishlists')]")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
	private WebElement orderHistory;
	
	public boolean validateMyWishList() throws Throwable {
		
		 return myWishList.isDisplayed();
	}
	
	public boolean validateOrderHistory() throws Throwable {
		 return orderHistory.isDisplayed();
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=driver.getCurrentUrl();
		return homePageURL;
	}	
}
