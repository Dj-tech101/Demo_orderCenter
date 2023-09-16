package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

	public WebDriver driver;

	public JavascriptExecutor js;
	public Actions act;

	public WebDriverWait wait;

	public loginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='username' and  @placeholder='Email Address']")
	WebElement userName;

	public void usernameSendKeys(String user) {
		act = new Actions(driver);

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys("mahesh@sstsoftwareservices.com");


	}
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	WebElement Submit;
	
	public void clickonTabKey(String pass) {
		
		act.keyDown(Keys.TAB).sendKeys("Admin@123").build().perform();
	}
	
	public void clickonSubmitButton() {
		
		wait.until(ExpectedConditions.visibilityOf(Submit)).click();	
	}

}
