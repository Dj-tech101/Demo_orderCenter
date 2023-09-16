package AsiPages;

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

public class testRC300 {

	
	public WebDriver driver;

	public JavascriptExecutor js;
	public Actions act;

	public WebDriverWait wait;

	public testRC300(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	
	// Submit button

		@FindBy(xpath = "//span[contains(text(),'Submit')]")
		WebElement SubmitButton;

		public void clickOnSubmitButton() {

			js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

			js.executeScript("arguments[0].scrollIntoView(true);", SubmitButton);

			WebDriverWait waitbutton = new WebDriverWait(driver, Duration.ofSeconds(400));

			waitbutton.until(ExpectedConditions.elementToBeClickable(SubmitButton)).click();

			;

		}

	
	//DateFormate

		@FindBy(xpath = "//input[@placeholder='MM-DD-YYYY']")
		WebElement dateFormate;

		public void DateFormateSend(String date) {

			wait = new WebDriverWait(driver, Duration.ofSeconds(500));

			wait.until(ExpectedConditions.visibilityOf(dateFormate)).sendKeys(date);
		}
		
		
		// MODEL

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

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

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
		
		// DOOR QUANTITY

		@FindBy(xpath = "//p[contains(text(),'greater than or equal to 1')]")
		WebElement ErrorDoorQuantity;

		@FindBy(xpath = "//p[contains(text(),'Please enter numbers only (without decimal)')]")
		WebElement errorMessageForDecimal;

		public String geterrorMessageForDecimal() {
			js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//				;

			js.executeScript("window.scrollBy(0,-3000)", "");

			return errorMessageForDecimal.getText();

		}

		public String getErrorMessageDoorQuantity() {
			js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

			js.executeScript("window.scrollBy(0,-3000)", "");

			return ErrorDoorQuantity.getText();

		}

		@FindBy(xpath = "(//input[@type='text'])[2]")
		WebElement doorQuantity;

		public void doorQuantitySendkey(String doorquantity) {

			wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
			;

		}

		// SPF

		@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[2]")
		WebElement spf;

		public void spf() {

			wait.until(ExpectedConditions.elementToBeClickable(spf)).click();

		}

		@FindBy(xpath = "//li[@role='option']")
		List<WebElement> spflist;

		public void spfselection(String model) {

			for (int i = 0; i < spflist.size(); i++) {

				String modelText = spflist.get(i).getText();

				if (modelText.equalsIgnoreCase(model)) {

					spflist.get(i).click();

				}
			}

		}

		// DOOR OPENING WIDTH

		@FindBy(xpath = "(//input[@type='text'])[3]")
		WebElement doorWidth;

		public void doorWidthSendkey(String date) {

			wait = new WebDriverWait(driver, Duration.ofSeconds(500));

			wait.until(ExpectedConditions.visibilityOf(doorWidth)).sendKeys(date);
		}

		// VALIDATION MESSAGE FOR INVALID VALUE

		@FindBy(xpath = "//p[contains(text(),'Please enter a value between 36 and 144')]")
		WebElement errorMessageWidth;

		public String geterrorMessageWidth() {
			js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//				;

			js.executeScript("window.scrollBy(0,-3000)", "");

			return errorMessageWidth.getText();

		}

		//// VALIDATION MESSAGE FOR INVALID DECIMAL VALUE

		@FindBy(xpath = "//p[contains(text(),'Please enter valid decimal value (.00, .25, .50, .75)')]")
		WebElement errorMessageForDecimalValue;

		public String geterrorMessageForDecimalValue() {
			js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

			js.executeScript("window.scrollBy(0,-3000)", "");

			return errorMessageForDecimalValue.getText();

		}

		// DOOR OPENING height

		@FindBy(xpath = "(//input[@type='text'])[4]")
		WebElement doorHeight;

		public void doorHeightsendkeys(String date) {

			wait = new WebDriverWait(driver, Duration.ofSeconds(500));

			wait.until(ExpectedConditions.visibilityOf(doorHeight)).sendKeys(date);
		}
		// VALIDATION MESSAGE FOR INVALID VALUE

		@FindBy(xpath = "//p[contains(text(),'Please enter a value between 48 and 144')]")
		WebElement errorMessageHight;

		public String geterrorMessageHight() {
			js = (JavascriptExecutor) driver;

//				WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//					;

			js.executeScript("window.scrollBy(0,-3000)", "");

			return errorMessageHight.getText();

		}

		//// VALIDATION MESSAGE FOR INVALID DECIMAL VALUE

		@FindBy(xpath = "//p[contains(text(),'Please enter valid decimal value (.00, .25, .50, .75)')]")
		WebElement errorMessageForDecimalValueHeight;

		public String geterrorMessageForDecimalValueHeight() {
			js = (JavascriptExecutor) driver;

//				WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

			js.executeScript("window.scrollBy(0,-3000)", "");

			return errorMessageForDecimalValueHeight.getText();

		}

		//// VALIDATION MESSAGE FOR SPECIAL CHARACTER

		@FindBy(xpath = "//p[contains(text(),'Please enter a valid DOOR OPENING HEIGHT')]")
		WebElement errorMessageSpecialCharacterHeight;

		public String geterrorMessageSpecialCharacterHeight() {
			js = (JavascriptExecutor) driver;

//					WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

			js.executeScript("window.scrollBy(0,-3000)", "");

			return errorMessageSpecialCharacterHeight.getText();

		}

		@FindBy(xpath = "//table/tbody/tr[7]/td[3]")
		WebElement basePrice;
		
		public String getBasePrice() throws InterruptedException {
			
			Thread.sleep(1500);
			String text=wait.until(ExpectedConditions.visibilityOf(basePrice)).getText();
			return text;
			
		}

		
	
}
