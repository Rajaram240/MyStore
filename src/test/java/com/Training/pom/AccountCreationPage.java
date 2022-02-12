package com.Training.pom;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Training.testcases.BaseClass;


public class AccountCreationPage extends BaseClass{
WebDriver ldriver;
	
	public  AccountCreationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//h1[text()='Create an account']")
	private WebElement formTitle;
	
	@FindBy(id = "uniform-id_gender1")
	private WebElement mr;
	
	@FindBy(id = "id_gender2")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(name = "customer_lastname")
	private WebElement lastName;

	@FindBy(name = "passwd")
	private WebElement passWord;

	@FindBy(name = "days")
	private WebElement days;

	@FindBy(name = "months")
	private WebElement months;

	@FindBy(name = "years")
	private WebElement years;

	@FindBy(name = "firstname")
	private WebElement customerNirstName;

	@FindBy(name = "lastname")
	private WebElement customerLastName;

	@FindBy(name = "company")
	private WebElement companyName;

	@FindBy(name = "address1")
	private WebElement address;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "id_state")
	private WebElement state;

	@FindBy(name = "postcode")
	private WebElement postCode;

	@FindBy(name = "id_country")
	private WebElement country;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "phone_mobile")
	private WebElement mobile;

	@FindBy(name = "alias")
	private WebElement ref;

	@FindBy(name = "submitAccount")
	private WebElement registerBtn;
	public void createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String comPany, 
			String addr, 
			String cityString, 
			String zip, 
			String mobilePhone) throws Throwable {
		
		if(gender.equalsIgnoreCase("Mr")) {
			((WebElement) ldriver).click();
		} else {
			((WebElement) ldriver).click();
		}
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		passWord.sendKeys(pswd);
		companyName.sendKeys(comPany);
		address.sendKeys(addr);
		city.sendKeys(cityString);
		
		postCode.sendKeys(zip);

		postCode.sendKeys(zip);
		mobile.sendKeys(mobilePhone);
		
	}
	public Boolean getCountryDropown(String countryToCheck) {
	    return country.getText().equals(countryToCheck);
	}
	public Boolean getStateDropown(String stateToCheck) {
	    return state.getText().equals(stateToCheck);
	}
	public Boolean getdayDropown(String daysToCheck) {
	    return days.getText().equals(daysToCheck);
	}
	public Boolean getmonthDropown(String monthToCheck) {
	    return months.getText().equals(monthToCheck);
	}
	public Boolean getyearDropown(String yearsToCheck) {
	    return years.getText().equals(yearsToCheck);
	}
	public HomePage validateRegistration() throws Throwable {
		registerBtn.click();
		return new HomePage(ldriver);
	}
	
	public boolean validateAcountCreatePage() throws Throwable {
		 return formTitle.isDisplayed();
	}
	
}
