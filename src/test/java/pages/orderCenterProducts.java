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

public class orderCenterProducts {

	public WebDriver driver;

	public JavascriptExecutor js;
	public Actions act;

	public WebDriverWait wait;

	public orderCenterProducts(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[contains(text(),'Raynor')]")
	WebElement raynorButton;

	public void clickOnRaynorbutton() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(raynorButton)).click();

	}

	@FindBy(xpath = "//p[contains(text(),'ASI')]")
	WebElement ASI;

	public void clickOnAsiButton() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(ASI)).click();

	}

	@FindBy(xpath = "(//p[contains(text(),'Kelley')])[3]")
	WebElement SealKelly;

	public void clickOnSealKelly() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(SealKelly)).click();

	}

	@FindBy(xpath = "//span[contains(text(),'Cart')]")
	WebElement cartButton;

	public void clickOnCartButton() throws InterruptedException {

		act = new Actions(driver);

		js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,4000)", "");
		
		Thread.sleep(2000);

		js.executeScript("arguments[0].click();", cartButton);
		
		
		

	}

}
