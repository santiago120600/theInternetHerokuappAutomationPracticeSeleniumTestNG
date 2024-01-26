package com.herokuapp.theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BasePageObject{
	
	@FindBy(linkText = "Form Authentication")
	WebElement formAuthenticationLink;

	public WelcomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickFormAuthenticationLink() {
		click(formAuthenticationLink);
	}
	
	
}
