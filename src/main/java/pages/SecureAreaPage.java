package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage {
	
	private WebDriver driver;

	@FindBy(id = "flash")
	WebElement flashCardMsg;
	
	
	@FindBy(xpath = "//a[@class='button secondary radius']")
	WebElement logoutBtn;
	
	public SecureAreaPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean logoutButtonIsDisplayed() {
		return logoutBtn.isDisplayed();
	}
	
	public String getFlashCardMsg() {
		return flashCardMsg.getText();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}
