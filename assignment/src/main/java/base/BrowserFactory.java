package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WebEventListener;

public class BrowserFactory {

	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	public static Properties prop;
	
	public BrowserFactory(){
		try {
			//ClassLoader classLoader =  Thread.currentThread().getContextClassLoader();
			FileInputStream input = new FileInputStream("./config.properties");
			prop = new Properties();
			prop.load(input);
			System.out.println("Loaded");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			}		
	}
	
	public void initialization() {
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","./driver executables/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else {
			System.out.println("No Drivers Found");
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
}
