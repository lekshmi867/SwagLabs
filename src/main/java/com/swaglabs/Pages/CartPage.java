package com.swaglabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.swaglabs.Browsers.ProxyDriver;

public class CartPage extends Page {
	public static final String PAGE_URL = "/cart.html";
	public CartPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	
	private static final By checkout=By.cssSelector("button[id='checkout']");
	
	public CheckoutPage clickCheckout() {
		((ProxyDriver) wd).click(checkout);
		return new CheckoutPage(wd,true);
	}
	@Override
	protected void isLoaded() {

		if (!urlContains(wd.getCurrentUrl())) {
			throw new Error();
		}
		
	}
	
	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}


}
