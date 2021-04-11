package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.awt.Robot;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FocusPageObject {
	WebDriver driver = null;
	
	//By popup_close= By.xpath("//*[@id=\"spu-7930\"]/div/a");	
	By button_locations= By.xpath("//a[@href='https://www.focusservices.com/locations/']");
	By northAmericaLocation_link = By.xpath("//a[@href='#north-america']");
	//By nowHiring = By.xpath("//*[@id=\"text-4\"]/div/p/a/span");
	By centralAmericaLocation_link = By.xpath("//a[@href='#central-america']");
	By asiaLocation_link = By.xpath("//a[@href='#asia']");
	
		
	public FocusPageObject(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//Method to get the web page of Focus Services.
	public void getFocusPage() {
		driver.get("https://www.focusservices.com/");	
		
		}
	
	//public void closePopup() {		
		
	//	driver.findElement(popup_close).click();			
		
	//	}
	
	// Method to verify if the Now Hiring! button exist in the Web Page.
	public void verifyButton()	{
		
		
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//a[@href='https://www.focusservices.com/apply/']"));
		if(dynamicElement.size() != 0){
		 //If list size is non-zero, element is present
		 System.out.println("Now hiring! button exist");
		}
		else{
		 //Else if size is 0, then element is not present
		 System.out.println("Now hiring! button doesn't exists");
		}
		
	}
	//Method to click the location's button on the Focus Services WebPage
		public void clickLocationsButton() {		
			
			driver.findElement(button_locations).click();
			
		}
		
	//	Method to validate if the North America link exist 
		public void linkValidation() {
			String actualTitle = driver.findElement(northAmericaLocation_link).getText();
			String expectedTitle = "NORTH AMERICA";
			Assert.assertEquals(expectedTitle, actualTitle);
			
			System.out.println("AssertCompleted the link to north america is available");
			
		}
		
		//Method to get to the Central America Tab
		public void clickCentralAmerica() {
			driver.findElement(centralAmericaLocation_link).click();
			
		}
		//Method to verify if the central america tab includes the tittle "El Salvador & Nicaragua".
		public void verifyTitle()	{
			
			String retrieveText = driver.findElement(By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[2]/div[2]/div/div/section/div/h2")).getText();

			if(retrieveText.equals("El Salvador & Nicaragua")) {
			//User defined message on console
			System.out.println("The Tittle El Salvador & Nicaragua is being displayed properly");
			}else {
				System.out.println("Value does not match");
			}
						
		}
		//Method to get to the Asia Tab
		public void clickAsiaLocation() {
			driver.findElement(asiaLocation_link).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		//Verify if exist the “Bacolod City, Philippines” text block
		public void verifyAsiaLocationText() {
			String retrieveText = driver.findElement(By.xpath("//*[@id=\"av-tab-section-1\"]/div/div[2]/div[3]/div/div/div[2]/section/div/h3/b")).getText();

			if(retrieveText.equals("Bacolod City, Philippines")) {
			//User defined message on console
			System.out.println("The text Bacolod City, Philippines is being displayed properly");
			}else {
				System.out.println("The text Bacolod City, Philippines is not being displayed in the page");
			}
		}
		
}
