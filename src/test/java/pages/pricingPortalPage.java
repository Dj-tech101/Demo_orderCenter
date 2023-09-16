package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pricingPortalPage {

	public WebDriver driver;

	public JavascriptExecutor js;
	public Actions act;

	public WebDriverWait wait;

	public pricingPortalPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//p[contains(text(),'Raynor')]")
	WebElement raynorButton;

	public void clickOnRaynotButton() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(raynorButton)).click();

	}
	@FindBy(xpath = "//p[contains(text(),'ASI')]")
	WebElement ASIButton;

	public void clickOnASIButtonButton() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(ASIButton)).click();

	}
}
