package com.Training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
WebDriver ldriver;
	
	public IndexPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	public LoginPage clickOnSignIn()
	{
		signInBtn.click();
		return new LoginPage(ldriver);
	}
	public String getStoreTitle()
	{
		String title=ldriver.getTitle();
		return title;
	}
	public boolean validateLogo()
	{
		return myStoreLogo.isDisplayed();
	}
	public SearchResultPage search(String productName)
	{
		searchProductBox.sendKeys(productName);;
		return new SearchResultPage(ldriver);
	}
	public void searchbutton()
	{
		searchButton.click();
	}
	
	
}
