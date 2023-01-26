package com.lekshmi.swaglabs.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglabs.Base.TestBase;
import com.swaglabs.Pages.CartPage;
import com.swaglabs.Pages.CheckoutPage;
import com.swaglabs.Pages.CompletePage;
import com.swaglabs.Pages.ProductPage;
import com.swaglabs.Pages.SwagLabPage;

public class CompleteTest extends TestBase {
	SwagLabPage swagLabPage;
	ProductPage productPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	CompletePage completePage;
	
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		swagLabPage = new SwagLabPage(driver,true).get();
		}
	
	@Test
	public void verifyUserIsAbleToBuyProducts() {
		productPage=swagLabPage.login("standard_user", "secret_sauce");
		cartPage=productPage.selectCart();
		checkoutPage=cartPage.clickCheckout();
		completePage=checkoutPage.checkoutProduct("lekshmi", "vijay", "678945");
		Assert.assertEquals(completePage.getOrderCompleteSuccessTxt(), "THANK YOU FOR YOUR ORDER");
		
	}
	
	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
