package com.herokuapp.theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage extends BasePageObject{
	
	@FindBy(id = "flash")
	WebElement flashCardMsg;
	
	
	@FindBy(xpath = "//a[@class='button secondary radius']")
	WebElement logoutBtn;
	
	public SecureAreaPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public boolean logoutButtonIsDisplayed() {
		return logoutBtn.isDisplayed();
	}
	
	public String getFlashCardMsg() {
		return flashCardMsg.getText();
	}
	

}
