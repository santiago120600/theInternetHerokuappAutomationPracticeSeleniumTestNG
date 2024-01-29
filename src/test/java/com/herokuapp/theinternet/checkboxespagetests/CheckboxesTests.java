package com.herokuapp.theinternet.checkboxespagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class CheckboxesTests extends TestUtilities{
	
	@Test
	public void selectAllCheckboxes() {
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.clickCheckboxesLink();
		CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
		Assert.assertFalse(checkboxesPage.areAllCheckboxesSelected());
		checkboxesPage.selectCheckboxes();
		Assert.assertTrue(checkboxesPage.areAllCheckboxesSelected());
		
	}
	
	

}
