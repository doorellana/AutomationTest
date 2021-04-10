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

public class FocusPageObject {
	WebDriver driver=null;
	By popup_close= By.xpath("//html");	
	By button_locations= By.xpath("//*[@id=\"menu-item-4726\"]/a");
	By northAmerica_link = By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[1]/a[1]");
	//By nowHiring = By.xpath("//*[@id=\"text-4\"]/div/p/a/span");
	
	public FocusPageObject(WebDriver driver) {
		this.driver = driver;
		
	}
	public void closePopup() {
		driver.get("https://www.focusservices.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.findElement(popup_close).click();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		}
	public void verifyButton()	{
		
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//a[@href='https://www.focusservices.com/apply/']"));
		if(dynamicElement.size() != 0){
		 //If list size is non-zero, element is present
		 System.out.println("Now hiring button exist");
		}
		else{
		 //Else if size is 0, then element is not present
		 System.out.println("Now hiring button doesn't exists");
		}
		
		
	}
	
		public void clickLocationsButton() {		
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(button_locations).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		public void linkValidation() {
			String actualTitle = driver.findElement(northAmerica_link).getText();
			String expectedTitle = "NORTH AMERICA";
			Assert.assertEquals(expectedTitle, actualTitle);
			
			System.out.println("AssertCompleted");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
}
