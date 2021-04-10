package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.util.List;

public class GoogleSearchPageObject {
	
	WebDriver driver=null;
	
	By textbox_search = By.name("q");
	By button_search= By.className("gNO89b");
	By popup_close= By.className("spu-close spu-close-popup spu-close-top_right");
	By button_locations= By.xpath("//*[@id=\"menu-item-4726\"]/a");
	By northAmerica_link = By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[1]/a[1]");
	
	public GoogleSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	

	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		driver.findElement(button_search).sendKeys(Keys.RETURN);
		
	}	
	
	public void closePopup() {
		
		driver.findElement(popup_close).sendKeys(Keys.RETURN);
		
	}
	public void clickLocationsButton() {
		
		driver.findElement(button_locations).click();
		
	}
	public void linkValidation() {
		String actualTitle = driver.findElement(northAmerica_link).getText();
		String expectedTitle = "NORTH AMERICA";
		Assert.assertEquals(expectedTitle, actualTitle);
		
		System.out.println("AssertCompleted");
	}
	
}
