package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	private WebDriver driver;
	
	@FindBy(linkText = "Form Authentication")
	WebElement formAuthenticationLink;

	public WelcomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFormAuthenticationLink() {
		formAuthenticationLink.click();
	}
	
	
}
