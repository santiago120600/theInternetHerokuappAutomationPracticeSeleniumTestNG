package com.herokuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	protected WebDriver driver;

	protected static String testSuiteName;
	protected static String testName;
	
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser, ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		BrowserDriverFactory factory = new BrowserDriverFactory(browser);
		driver = factory.createDriver();
		ctx.setAttribute("driver", this.driver);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		this.testSuiteName= ctx.getSuite().getName();
		this.testName = testName;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
