package com.herokuapp.theinternet.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage extends BasePageObject {

	@FindBy(xpath = "//input[@Type='checkbox']")
	List<WebElement> checkboxesList;

	public CheckboxesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectCheckboxes() {
		for (WebElement element : checkboxesList) {
			if (!element.isSelected()) {
				click(element);
			}
		}
	}
	
	public boolean areAllCheckboxesSelected() {
		for (WebElement element : checkboxesList) {
			if (!element.isSelected()) {
				return false;
			}
		}
		return true;
	}

}
