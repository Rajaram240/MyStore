package com.Training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Training.testcases.BaseClass;




public class LoginPage extends BaseClass{
WebDriver ldriver;
	
	public  LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public AddressPage setUserName(String uname)
	{
		userName.sendKeys(uname);
		return new AddressPage(ldriver);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	
	public void clickSubmit()
	{
		signInBtn.click();
	}	
	
public void enterEmail(String email)
{
	emailForNewAccount.sendKeys(email);
}
public void createSubmit()
{
	createNewAccountBtn.click();
}	
public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		emailForNewAccount.sendKeys(newEmail);
		createNewAccountBtn.click();
	
	return new AccountCreationPage(ldriver);
}

//public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
//	//action.scrollByVisibilityOfElement(getDriver(), userName);
//	
//	JavascriptExecutor js = (JavascriptExecutor)driver;
//	js.executeScript("arguments[0].scrollIntoView();", userName);
//	userName.sendKeys("username");
//	password.sendKeys(pswd);
//	signInBtn.click();
//	Thread.sleep(2000);
//	addressPage=new AddressPage(ldriver);
//	return addressPage;
//}

}
