package com.herokuapp.theinternet.loginpagetest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestUtilities;
import pages.LoginPage;
import pages.SecureAreaPage;
import pages.WelcomePage;

public class PositiveLoginTests extends TestUtilities{

	@Parameters({ "username", "password"})
	@Test
	public void logInTest(String username, String password) {
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.clickFormAuthenticationLink();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.logIn(username, password);
		
		SecureAreaPage areaPage = new SecureAreaPage(driver);
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		Assert.assertEquals(areaPage.getCurrentUrl(), expectedUrl);
		Assert.assertTrue(areaPage.logoutButtonIsDisplayed(),"logOut Button is not visible.");
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = areaPage.getFlashCardMsg();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
	
}
