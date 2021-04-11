package Test;

import java.awt.Robot;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.FocusPageObject;
import Pages.GoogleSearchPageObject;

public class GoogleSearchPageTest {
	
	private static WebDriver driver= null;
	
	
	public static void main(String[] args) {
		googleSearchTest();
		
	}
	
	
	public static void googleSearchTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		GoogleSearchPageObject searchPageObj = new GoogleSearchPageObject(driver);
		FocusPageObject focusObject= new FocusPageObject(driver);
	    JavascriptExecutor jse = (JavascriptExecutor)driver;					
		searchPageObj.setTextInSearchBox("Focus Services");		
		searchPageObj.clickSearchButton();
		searchPageObj.verifyFocusLink();
		focusObject.getFocusPage();					
		//focusObject.closePopup();		
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		focusObject.verifyButton();		
		focusObject.clickLocationsButton();		
		focusObject.linkValidation();
		focusObject.clickCentralAmerica();
		focusObject.verifyTitle();
		focusObject.clickAsiaLocation();
		focusObject.verifyAsiaLocationText();
	}

}
