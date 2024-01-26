package com.herokuapp.theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePageObject{
	
	@FindBy(id = "username")
	WebElement usernameInput;
	
	@FindBy(id = "password")
	WebElement passwordInput;
	
	@FindBy(className = "radius")
	WebElement logInButton;
	
	@FindBy(id = "flash")
	WebElement flashCardMsg;
	

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void logIn(String username, String password) {
		type(usernameInput, username);
		type(passwordInput, password);
		click(logInButton);
	}
	
	public String getFlashCardMsg() {
		return flashCardMsg.getText();
	}
	
}
