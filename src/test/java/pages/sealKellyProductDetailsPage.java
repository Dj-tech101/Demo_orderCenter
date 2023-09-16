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

public class sealKellyProductDetailsPage {

	public WebDriver driver;

	public JavascriptExecutor js;
	public Actions act;

	public WebDriverWait wait;

	public sealKellyProductDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[1]")
	WebElement model;

	public void clickonModel(String value) throws InterruptedException {

		if (!value.equals("null")) {

			Actions act4 = new Actions(driver);

			Thread.sleep(2000);
			act4.moveToElement(model).click(model).build().perform();
			// wait.until(ExpectedConditions.elementToBeClickable(model)).click();
		}

		else {
			System.out.println("Please pass the model");
		}
	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> Modellist;

	// VALIDATION MESSAGE FOR MODEL
	@FindBy(xpath = "//p[contains(text(),'Please select MODEL')]")
	WebElement ModelErrorMessage;

	public String getModelValidationMessage() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//		;

		js.executeScript("arguments[0].scrollIntoView(true);", ModelErrorMessage);

		return ModelErrorMessage.getText();

	}

	public void modelSelection(String model) {

		WebDriverWait selection = new WebDriverWait(driver, Duration.ofSeconds(25));

		for (int i = 0; i < Modellist.size(); i++) {

			String modelText = Modellist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement e1 = Modellist.get(i);

				selection.until(ExpectedConditions.elementToBeClickable(e1)).click();

			}
		}

	}

	// SidePad Height
	@FindBy(xpath = "(//input[@type='text'])[10]")
	WebElement sidePadHeight;

	public void movetoelementone() {

		Actions act = new Actions(driver);

		act.moveToElement(sidePadHeight).build().perform();
	}

	public void sidepadHeightSendkeys(String value) {

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", sidePadHeight);

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(sidePadHeight)).sendKeys(value);

	}

	// side pad Back Face

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[11]")
	WebElement SidPadBack;

	public void clickOnsSidePadback(String value) throws InterruptedException {

		if (!value.equals("null")) {

			Actions act4 = new Actions(driver);

			Thread.sleep(2000);
			act4.moveToElement(SidPadBack).click(SidPadBack).build().perform();
			// wait.until(ExpectedConditions.elementToBeClickable(model)).click();
		}

		else {
			System.out.println("Please pass the sidpack");
		}
	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> sidePadList;

	public void SidePadSelection(String sidepad) {

		WebDriverWait selection = new WebDriverWait(driver, Duration.ofSeconds(25));

		for (int i = 0; i < sidePadList.size(); i++) {

			String modelText = sidePadList.get(i).getText();

			if (modelText.equalsIgnoreCase(sidepad)) {

				WebElement e1 = sidePadList.get(i);

				selection.until(ExpectedConditions.elementToBeClickable(e1)).click();

			}
		}
	}

	@FindBy(xpath = "//table/tbody/tr[22]/td[3]")
	WebElement PriceSidepad;

	public String getPriceForSidepat() {

		String text = wait.until(ExpectedConditions.visibilityOf(PriceSidepad)).getText();
		return text;
	}

}
