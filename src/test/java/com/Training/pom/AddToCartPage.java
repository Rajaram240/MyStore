package com.Training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Training.testcases.BaseClass;


public class AddToCartPage extends BaseClass{
WebDriver ldriver;
	
	public AddToCartPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	
	@FindBy(name="group_1")
	private WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement addToCartMessag;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public void enterQuantity(String quantity1) throws Throwable {
		
		quantity.sendKeys(quantity1);
	}
	
	public void selectSize(String size1) throws Throwable {
		size.sendKeys(size1);
	}
	
	public void clickOnAddToCart() throws Throwable {
		addToCartBtn.click();
	}
	
	public boolean validateAddtoCart() throws Throwable {
		return addToCartMessag.isDisplayed();
		
	}
	public OrderPage clickOnCheckOut() throws Throwable {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("getElementByXpath('//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]').click();");
		js.executeScript("arguments[0].click();", proceedToCheckOutBtn);
		return new OrderPage(ldriver);
	}
	

}
