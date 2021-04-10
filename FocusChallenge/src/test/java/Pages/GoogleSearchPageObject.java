package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearchPageObject {
	
	
	WebDriver driver=null;
	
	By textbox_search = By.name("q");
	By button_search= By.className("gNO89b");
	By popup_close= By.xpath("//html");	
	By button_locations= By.xpath("//*[@id=\"menu-item-4726\"]/a");
	By northAmerica_link = By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[1]/a[1]");
	
	
	public GoogleSearchPageObject(WebDriver driver) {
		this.driver = driver;
		
	}
	

	public void setTextInSearchBox(String text) {
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(textbox_search).sendKeys(text);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void clickSearchButton() {
		driver.findElement(button_search).sendKeys(Keys.RETURN);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}	
	
		
}
