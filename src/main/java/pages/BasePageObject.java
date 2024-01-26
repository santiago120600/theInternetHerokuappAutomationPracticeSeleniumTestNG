package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	
	protected WebDriver driver;

	public BasePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	protected void click(WebElement element) {
		element.click();
	}
	
	protected void type(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 10;
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(condition);
	}

	protected void waitForVisibilityOf(WebElement element, Integer... timeOutInSeconds) {
		waitFor(ExpectedConditions.visibilityOf(element), timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null);
	}
	
	

}
