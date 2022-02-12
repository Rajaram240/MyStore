package com.Training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Training.testcases.BaseClass;


public class ShippingPage extends BaseClass {
WebDriver ldriver;
	
	public ShippingPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	public void checkTheTerms() throws Throwable {
	terms.click();
	}
	public PaymentPage clickOnProceedToCheckOut() throws Throwable {
		proceedToCheckOutBtn.click();
		return new PaymentPage(ldriver);
	}

	

}
