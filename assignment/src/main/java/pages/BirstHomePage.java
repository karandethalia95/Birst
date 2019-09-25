package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BrowserFactory;

public class BirstHomePage extends BrowserFactory {
	
	@FindBy(xpath="//img[@src='https://www.birst.com/wp-content/themes/birst2015/images/Birst-by-Infor-FNL.png']")
	WebElement birstLogo;
	
	@FindBy(linkText = "Resources")
	WebElement resources;
	
	public BirstHomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLogoAndClickResources() {
		WebDriverWait wait = new WebDriverWait(driver,120);

		if(birstLogo.getAttribute("class").equalsIgnoreCase("desktop-logo"))
		{
			System.out.println("yes");
			resources.click();
		}
		else {
			System.out.println("no");
		}
	}
	
}


