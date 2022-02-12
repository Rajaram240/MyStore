package com.Training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Training.testcases.BaseClass;


public class OrderSummary extends BaseClass {
WebDriver ldriver;
	
	public OrderSummary(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
		confirmOrderBtn.click();
		return new OrderConfirmationPage(ldriver);
	}
}
