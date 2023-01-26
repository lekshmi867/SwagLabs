package com.swaglabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.swaglabs.Browsers.ProxyDriver;

public class ProductPage extends Page {
	public static final String PAGE_URL = "/inventory.html";
	public ProductPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
		
	}
	
	private static final By addToCart=By.cssSelector("button[id='add-to-cart-sauce-labs-backpack']");
	private static final By cartIcon=By.cssSelector("a.shopping_cart_link");
	private static final By menuIcon=By.cssSelector("button[id='react-burger-menu-btn']");
	private static final By logoutIcon=By.cssSelector("a[id='logout_sidebar_link']");
	
	private void clickMenIcon() {
		((ProxyDriver) wd).click(menuIcon);	
	}
	
	public SwagLabPage clickLogout() {
		clickMenIcon();
		((ProxyDriver) wd).click(logoutIcon);
		return new SwagLabPage(wd,true);
	}
	
	private void clickAddToCart() {
		((ProxyDriver) wd).click(addToCart);
	}
	
	public CartPage  selectCart() {
		clickAddToCart();
		((ProxyDriver) wd).click(cartIcon);
		return new CartPage(wd,true);
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
