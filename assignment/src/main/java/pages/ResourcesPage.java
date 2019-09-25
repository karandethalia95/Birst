package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BrowserFactory;

public class ResourcesPage extends BrowserFactory {
	
	public void filter() {
		
		Select filterByType = new Select(driver.findElement(By.id("resource-type")));
		filterByType.selectByValue("webinar");
		
		Select filterByRole = new Select(driver.findElement(By.id("resource-role")));
		filterByRole.selectByValue("BI/IT");
		
		WebElement webinarLink = driver.findElement(By.xpath("//div[@class='resource-title']//a[@href='https://pages.infor.com/20190605-bst-webinar-introducing-birst7.html']"));
		if(webinarLink.getText().equalsIgnoreCase("Introducing Birst 7 - Meet the next generation of enterprise analytics"))
		{
			System.out.println("ÿes");
			webinarLink.click();
			//Actions action = new Actions(driver);
			//action.moveToElement(webinarLink).click().build().perform();
		}
		
	}

}
