package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GoogleSearchPageObject;

public class GoogleSearchPageTest {
	
	private static WebDriver driver= null;
	
	public static void main(String[] args) {
		googleSearchTest();
		
	}
	
	public static void googleSearchTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		GoogleSearchPageObject searchPageObj = new GoogleSearchPageObject(driver);
		
		driver.get("https://google.com");
		
		searchPageObj.setTextInSearchBox("Focus Services");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		searchPageObj.clickSearchButton();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.focusservices.com/");	
		
		//searchPageObj.closePopup();
		searchPageObj.clickLocationsButton();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		searchPageObj.linkValidation();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

}