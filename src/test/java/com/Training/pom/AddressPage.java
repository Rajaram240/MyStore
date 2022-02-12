package com.Training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Training.testcases.BaseClass;


public class AddressPage extends BaseClass {
WebDriver ldriver;
	
	public AddressPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
public ShippingPage clickOnCheckOut() throws Throwable {
	proceedToCheckOut.click();
		return new ShippingPage(ldriver);
	}
	
}
