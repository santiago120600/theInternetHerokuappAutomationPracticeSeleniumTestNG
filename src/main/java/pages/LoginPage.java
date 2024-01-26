package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	
	Wait<WebDriver> wait;
	
	@FindBy(id = "username")
	WebElement usernameInput;
	
	@FindBy(id = "password")
	WebElement passwordInput;
	
	@FindBy(className = "radius")
	WebElement logInButton;
	
	@FindBy(id = "flash")
	WebElement flashCardMsg;
	

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	public void logIn(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(logInButton));
		logInButton.click();
	}
	
	public String getFlashCardMsg() {
		return flashCardMsg.getText();
	}
	
}
