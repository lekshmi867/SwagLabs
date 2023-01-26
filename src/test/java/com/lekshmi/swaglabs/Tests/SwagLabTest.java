package com.lekshmi.swaglabs.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglabs.Base.TestBase;
import com.swaglabs.Pages.ProductPage;
import com.swaglabs.Pages.SwagLabPage;

public class SwagLabTest extends TestBase {
	SwagLabPage swagLabPage;
	ProductPage productPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		swagLabPage = new SwagLabPage(driver, true).get();
	}

	@Test
	public void verifyUserIsAbleToBuyProducts() {
		productPage = swagLabPage.login("standard_user", "secret_sauce");
		productPage.clickLogout();

	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}

}
