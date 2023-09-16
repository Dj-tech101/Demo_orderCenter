package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Dashboard {

	
	public WebDriver driver;

	public JavascriptExecutor js;
	public Actions act;

	public WebDriverWait wait;

	public Dashboard(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy (xpath = "(//button[@type='button'])[2]/img")
	WebElement ordercenteroption;
	
	
	public void clcikOnOrdercenterButton() {
		
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
		
		boolean button=wait.until(ExpectedConditions.elementToBeClickable(ordercenteroption)).isSelected();
		
		if (!button) {
			
			System.out.println( ordercenteroption.getText());
			
			ordercenteroption.click();
		}
		
	}
	@FindBy (xpath = "(//button[@type='button'])[3]/img")
	WebElement pricingPortal;
	
	
	public void clickpricingPortal() {
		
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
		
		boolean button=wait.until(ExpectedConditions.elementToBeClickable(ordercenteroption)).isSelected();
		
		if (!button) {
			
			System.out.println( pricingPortal.getText());
			
			pricingPortal.click();
		}
		
	}
	
	
}
