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

public class orderCenter {

	
	public WebDriver driver;

	public JavascriptExecutor js;
	public Actions act;

	public WebDriverWait wait;

	public orderCenter(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "(//span[contains(text(),'Edit')])[1]")
	WebElement editOrder;
	
	
	public void ClickonEditBurton() throws InterruptedException {
		
		Thread.sleep(200);
		wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.visibilityOf(editOrder)).click();
	}
	
}
