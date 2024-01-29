package com.herokuapp.theinternet.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;

	protected static String testSuiteName;
	protected static String testName;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp(ITestContext ctx) {
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\GlobalData.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String browser = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");		
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
