package com.Training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Training.testcases.BaseClass;


public class PaymentPage extends BaseClass {
WebDriver ldriver;
	
	public PaymentPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	private WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
	
	public OrderSummary clickOnPaymentMethod() throws Throwable {
		bankWireMethod.click();
		return new OrderSummary(driver);
	}


}
