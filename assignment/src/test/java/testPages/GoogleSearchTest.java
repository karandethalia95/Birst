package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BrowserFactory;
import pages.BirstHomePage;
import pages.GoogleSearch;
import pages.ResourcesPage;

public class GoogleSearchTest extends BrowserFactory {
	
	BrowserFactory iDriver;
	GoogleSearch googleSearch;
	BirstHomePage birstHome;
	ResourcesPage resource;
	
	@BeforeMethod
	public void setup() {
		iDriver = new BrowserFactory();
		iDriver.initialization();
	}
	
	@Test
	public void titleTestandSearch(){
		googleSearch = new GoogleSearch();
		WebDriverWait wait = new WebDriverWait(driver,120);
		boolean waiter = wait.until(ExpectedConditions.titleContains("Google"));
		System.out.println(waiter);
		if(waiter)
		{
		String title = googleSearch.validateTitle();
		Assert.assertEquals(title, "Google");
		System.out.println("Landed on Google.com");
		googleSearch.search();
		}
		else
		{
			System.out.println("Not Google");
		}
		
		googleSearch.searchForBirst();
		
		birstHome = new BirstHomePage();
		birstHome.verifyLogoAndClickResources();
		
		resource = new ResourcesPage();
		resource.filter();
		
		
	}
	

}
