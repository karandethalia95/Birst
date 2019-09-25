package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserFactory;

public class GoogleSearch extends BrowserFactory {
	
	@FindBy(xpath="//input[@title='Search']")
	WebElement searchBar;
	
	public GoogleSearch(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle(){
		return driver.getTitle();
	}
	
	public void search() {
		searchBar.sendKeys("birst.com");
		searchBar.submit();
	}
	
	public void searchForBirst() {
		if(driver.findElement(By.xpath("//div[contains(text(),'Birst: Business Intelligence & Analytics, BI Software')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//a[@href='https://www.birst.com/']")).click();
		}
		
	}

}
