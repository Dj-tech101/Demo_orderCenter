package AsiPages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.xml.sax.Locator;

public class test615LAW {

	public WebDriver driver;

	public JavascriptExecutor js;
	public Actions act;

	public WebDriverWait wait;

	public test615LAW(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//table/tbody/tr[37]/td[2]")
	WebElement finalprice;

	public String getFinalPriceForm() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement e1 = wait.until(ExpectedConditions.visibilityOf(finalprice));

		return e1.getText();

	}

//	locato
//	
//	public void waituntillallelement(Locator l1) {
//		
//		WebDriverWait w1= new WebDriverWait(driver, Duration.ofSeconds(50));
//		
//		w1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(null))
//	}x`x`x`

	// Submit button

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	WebElement SubmitButton;

	public void clickOnSubmitButton() {

//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//		;

		js.executeScript("arguments[0].scrollIntoView(true);", SubmitButton);

		WebDriverWait waitbutton = new WebDriverWait(driver, Duration.ofSeconds(400));

		waitbutton.until(ExpectedConditions.elementToBeClickable(SubmitButton)).click();

		;

	}

//DateFormate

	@FindBy(xpath = "//input[@placeholder='MM-DD-YYYY']")
	WebElement dateFormate;

	public void DateFormateSend(String date) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(dateFormate)).sendKeys(date);

		Thread.sleep(1500);
	}

	// MODEL

	// @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[1]")

	@FindBy(xpath = "//table/tbody/tr[2]/td[2]/div/div/div/div")
	WebElement model;

	public void clickonModel(String value) throws InterruptedException {

//		if (!value.equals("null")) {
////
		Actions act4 = new Actions(driver);

		Thread.sleep(1000);
		// act4.moveToElement(model).click(model).build().perform();
		WebElement e2 = wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr[2]/td[2]/div/div/div/div"))))

		;

		e2.click();

//
//			wait.until(ExpectedConditions.elementToBeClickable(model)).click();

//		else {
//			System.out.println("Please pass the model");
//		}

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

	public void modelSelection(String model) throws InterruptedException {

		WebDriverWait selection = new WebDriverWait(driver, Duration.ofSeconds(15));

		for (int i = 0; i < Modellist.size(); i++) {

			String modelText = Modellist.get(i).getText();
			// Thread.sleep(10);
			
			if (modelText.equals(model)) {

				Modellist.get(i).click();

			}
		}

	}

	// DOOR NUMBER

	@FindBy(xpath = "(//input[@aria-invalid='false' and @type='text'])[2]")
	WebElement doorNumberedit;

	public void doorNumberSendKeys(String doorquantity) throws InterruptedException {

		// System.out.println(doorquantity);
		// Thread.sleep(1500);
		Actions act = new Actions(driver);

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@aria-invalid='false' and @type='text'])[2]")));

		// act.sendKeys(element, doorquantity).build().perform();
		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		element.sendKeys(doorquantity);

		;

	}
//--------------------------------------------------------------------------------//

	// DOOR QUANTITY

	@FindBy(xpath = "//p[contains(text(),'greater than or equal to 1')]")
	WebElement ErrorDoorQuantity;

	@FindBy(xpath = "//p[contains(text(),'Please enter numbers only (without decimal)')]")
	WebElement errorMessageForDecimal;

	public String geterrorMessageForDecimal() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageForDecimal.getText();

	}

	public String getErrorMessageDoorQuantity() {
		js = (JavascriptExecutor) driver;

//	WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorDoorQuantity.getText();

	}

	@FindBy(xpath = "(//input[@aria-invalid='false' and @type='text'])[3]")
	WebElement doorQuantity;

	public void doorQuantitySendkey(String doorquantity) throws InterruptedException {

		// System.out.println(doorquantity);
		// Thread.sleep(1500);
		Actions act = new Actions(driver);

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@aria-invalid='false' and @type='text'])[3]")));

		// act.sendKeys(element, doorquantity).build().perform();
		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		element.sendKeys(doorquantity);

		;

	}
//--------------------------------------------------------------------------------//

//DorrNumber

	@FindBy(xpath = "//p[contains(text(),'Please enter DOOR NUMBER ###')]")
	WebElement ErrorDoorNumber;

	public String getErrorDoorNumber() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorDoorNumber.getText();

	}

	@FindBy(xpath = "(//input[@aria-invalid='true' or @type='text'])[2]")
	WebElement doorNumber;

	public void doorNumberSendkey(String doorquantity) throws InterruptedException {

		// Thread.sleep(1500);
		Actions act = new Actions(driver);

//		WebElement element = wait.until(ExpectedConditions
//				.presenceOfElementLocated(By.xpath("(//input[@aria-invalid='true' or @type='text'])[2]")));
//
//		act.sendKeys(element, doorquantity).build().perform();
//		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		
		
   wait= new WebDriverWait(driver, Duration.ofSeconds(25));
   
   wait.until(ExpectedConditions.elementToBeClickable(doorNumber)).sendKeys(doorquantity);
		   
	}

	// SPF

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[2]")
	WebElement spf;

	public void spf() throws InterruptedException {

		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(spf)).click();

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

	@FindBy(xpath = "(//input[@aria-invalid='false' and @type='text'])[4]")
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

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageWidth.getText();

	}

	//// VALIDATION MESSAGE FOR INVALID DECIMAL VALUE

	@FindBy(xpath = "//p[contains(text(),'Please enter valid decimal value (.00, .25, .50, .75)')]")
	WebElement errorMessageForDecimalValue;

	public String geterrorMessageForDecimalValue() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageForDecimalValue.getText();

	}

	// DOOR OPENING height

	@FindBy(xpath = "(//input[@aria-invalid='false' and @type='text'])[5]")
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

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//				;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageHight.getText();

	}

	//// VALIDATION MESSAGE FOR INVALID DECIMAL VALUE

	@FindBy(xpath = "//p[contains(text(),'Please enter valid decimal value (.00, .25, .50, .75)')]")
	WebElement errorMessageForDecimalValueHeight;

	public String geterrorMessageForDecimalValueHeight() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageForDecimalValueHeight.getText();

	}

	//// VALIDATION MESSAGE FOR SPECIAL CHARACTER

	@FindBy(xpath = "//p[contains(text(),'Please enter a valid DOOR OPENING HEIGHT')]")
	WebElement errorMessageSpecialCharacterHeight;

	public String geterrorMessageSpecialCharacterHeight() {
		js = (JavascriptExecutor) driver;

//				WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageSpecialCharacterHeight.getText();

	}

	// ---------------------------------------------------------------------------------------------//

	// door LOCATION

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[3]")
	WebElement DoorLocation;

	public void DoorLocation(String value) throws InterruptedException {
		if (!value.equals("null")) {

			Actions act5 = new Actions(driver);
			act5.moveToElement(DoorLocation).click(DoorLocation).build().perform();
		} else {
			System.out.println("null motor location");
		}
	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> DoorLocationlist;

	public void DoorLocationSelection(String model) {

		for (int i = 0; i < DoorLocationlist.size(); i++) {

			String modelText = DoorLocationlist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				act = new Actions(driver);
				act.moveToElement(DoorLocationlist.get(i)).click(DoorLocationlist.get(i)).build().perform();

			}
		}

	}
	//// VALIDATION MESSAGE FOR INVALID OPTION

	@FindBy(xpath = "//p[contains(text(),'Please select DOOR LOCATION')]")
	WebElement ErrorMessageForDoorLocation;

	public String getErrorMessageForDoorLocation() {
		js = (JavascriptExecutor) driver;

//				WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageForDoorLocation.getText();

	}

	// -----------------------------------------------------------------------//

	// MOTOR LOCATION

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[4]")
	WebElement motorLocation;

	public void motorLocation(String value) throws InterruptedException {
		if (!value.equals("null")) {

			Actions act5 = new Actions(driver);
			act5.moveToElement(motorLocation).click(motorLocation).build().perform();
		} else {
			System.out.println("null motor location");
		}
	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> motorLocationlist;

	public void motorLocationselection(String model) {

		for (int i = 0; i < motorLocationlist.size(); i++) {

			String modelText = motorLocationlist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				act = new Actions(driver);
				act.moveToElement(motorLocationlist.get(i)).click(motorLocationlist.get(i)).build().perform();

			}
		}

	}
////VALIDATION MESSAGE FOR INVALID OPTION

	@FindBy(xpath = "//p[contains(text(),'Please select MOTOR LOCATION')]")
	WebElement ErrorMessageForMotorLocation;

	public String getErrorMessageForMotorLocation() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageForMotorLocation.getText();

	}

	// ----------------------------------------------------------------------------//

	// FIRST PHOTOCELL HEIGHT

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[5]")
	WebElement firstPhtocellHeght;

	public void firstPhtocellHeght() {

		wait.until(ExpectedConditions.elementToBeClickable(firstPhtocellHeght)).click();

	}

	// DEFOULT VALUE

	public String getdefoultvalueFIRSTPHOTOCELL() {

		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(40));

		String text = wait6.until(ExpectedConditions.visibilityOf(firstPhtocellHeght)).getText();

		// firstPhtocellHeght.getText();

		return text;

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> firstPhtocellHeghtlist;

	public void firstPhtocellHeghtselection(String model) {

		for (int i = 0; i < firstPhtocellHeghtlist.size(); i++) {

			String modelText = firstPhtocellHeghtlist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele1 = firstPhtocellHeghtlist.get(i);

				act.moveToElement(ele1).click(ele1).build().perform();

			}
		}

	}

	// --------------------------------------------------------------------------------------------//

	// CURTAIN FABRIC COLOR

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[6]")
	WebElement CurtainFabricColore;

	public void CurtainFabricColore(String value) {

		if (!value.equals("null")) {

			// wait.until(ExpectedConditions.elementToBeClickable(CurtainFabricColore)).click();
			CurtainFabricColore.click();
		} else {
			System.out.println("please pass the fabric colore");
		}

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> CurtainFabricColorelist;

	public List<String> getCurtainFabricColorelist() {
		List<String> l1 = new ArrayList<String>();

		for (int i = 0; i < CurtainFabricColorelist.size(); i++) {

			String text = CurtainFabricColorelist.get(i).getText();

			// System.out.println(text);
			l1.add(text);

		}
		return l1;

	}

	public void CurtainFabricColoreselection(String model) throws InterruptedException {

		for (int i = 0; i < CurtainFabricColorelist.size(); i++) {

			String modelText = CurtainFabricColorelist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele2 = CurtainFabricColorelist.get(i);

				// Thread.sleep(1000);
				act.moveToElement(ele2).click(ele2).build().perform();
				// Thread.sleep(500);
			}
		}
	}

	public String getdefoultdefoultValueCUTAINFABRICCOLORE() {
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(40));

		String text = wait6.until(ExpectedConditions.visibilityOf(CurtainFabricColore)).getText();

		// firstPhtocellHeght.getText();

		return text;
	}

	@FindBy(xpath = "//table/tbody/tr[11]/td[3]")
	WebElement priceforCurtainFabricColore;

	public String getpriceforCurtainFabricColore() throws InterruptedException {

		Thread.sleep(1500);
		String text = wait.until(ExpectedConditions.visibilityOf(priceforCurtainFabricColore)).getText();
		return text;

	}
////VALIDATION MESSAGE FOR INVALID OPTION

	@FindBy(xpath = "//p[contains(text(),'196666')]")
	WebElement ErrorMessagecurtainFabricColore;

	public String getErrorMessagecurtainFabricColore() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessagecurtainFabricColore.getText();

	}

	// --------------------------------------------------------------------------------------------------//

	// BOTTOM BAG CURTAIN COLOR

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[7]")
	WebElement bottomcurtainColore;

	public void bottomcurtainColore(String value) {

		if (!value.equals("null")) {

			WebElement e3 = wait.until(ExpectedConditions.refreshed(
					ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@aria-haspopup='listbox'])[7]"))));

			e3.click();

		} else {
			System.out.println("please pass the colore for bottom");
		}

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> bottomcurtainColorelist;

	public void bottomcurtainColoreselection(String model) throws InterruptedException {

		Actions act3 = new Actions(driver);

		for (int i = 0; i < bottomcurtainColorelist.size(); i++) {

			String modelText = bottomcurtainColorelist.get(i).getText();

			// System.out.println(model);
			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = bottomcurtainColorelist.get(i);

				// Thread.sleep(1200);
				// act3.moveToElement(ele).click(ele).build().perform();
				ele.click();
				break;

			}
		}

	}

	public List<String> getbottomcurtainColorelist() {

		List<String> l1 = new ArrayList<String>();

		for (int i = 0; i < bottomcurtainColorelist.size(); i++) {

			String text = bottomcurtainColorelist.get(i).getText();

			// System.out.println("name of color "+text);

			l1.add(text);

		}
		return l1;

	}

	@FindBy(xpath = "(//div[@role='button'])[6]")
	WebElement selectedelement;

	public String getdefoultdefoultValuebottomFabricColore() throws InterruptedException {

		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Thread.sleep(2000);

		String text2 = selectedelement.getText();

		// System.out.println("selection "+text2);
		// wait6.until(ExpectedConditions.visibilityOf(bottomcurtainColore)).getText();

		// firstPhtocellHeght.getText();

		return text2;
	}

	@FindBy(xpath = "//table/tbody/tr[12]/td[3]")
	WebElement priceforBottomFabricColore;

	public String getpriceforbottomcurtainColore() {

		String text = wait.until(ExpectedConditions.visibilityOf(priceforBottomFabricColore)).getText();
		return text;

	}
////VALIDATION MESSAGE FOR INVALID OPTION

	@FindBy(xpath = "//p[contains(text(),'Please select BOTTOM BAG CURTAIN COLOR')]")
	WebElement ErrorMessagebottomcurtainColore;

	public String getErrorMessagebottomcurtainColore() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessagebottomcurtainColore.getText();

	}

	// Price BOTTOM BAG CURTAIN COLOR

	@FindBy(xpath = "//table/tbody/tr[12]/td[3]")
	WebElement priceBottombagCurtainColore;

	public String getPriceBottombagColore() {

		String priceValue = priceBottombagCurtainColore.getText();

		return priceValue;

	}

	// ------------------------------------------------------------------------------------------------------//

	//

	// sideguide colore CURTAIN COLOR

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[9]")
	WebElement sideGuideColore;

	public void sideGuideColore(String value) {

		if (!value.equals("null")) {

			WebElement e3 = wait.until(ExpectedConditions.refreshed(
					ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@aria-haspopup='listbox'])[9]"))));

			e3.click();

		} else {
			System.out.println("please pass the colore for bottom");
		}

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> sideGuidColorelist;

	public void sideGuidColorelistselection(String model) throws InterruptedException {

		Actions act3 = new Actions(driver);

		for (int i = 0; i < sideGuidColorelist.size(); i++) {

			String modelText = sideGuidColorelist.get(i).getText();

			// System.out.println(model);
			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = sideGuidColorelist.get(i);

				// Thread.sleep(1200);
				// act3.moveToElement(ele).click(ele).build().perform();
				ele.click();

			}
		}

	}

	public List<String> getsideGuidColorelist() {

		List<String> l1 = new ArrayList<String>();

		for (int i = 0; i < bottomcurtainColorelist.size(); i++) {

			String text = bottomcurtainColorelist.get(i).getText();

			// System.out.println("name of color "+text);

			l1.add(text);

		}
		return l1;

	}

	//// VALIDATION MESSAGE FOR INVALID OPTION

	@FindBy(xpath = "//p[contains(text(),'Please select SIDE GUIDE COVER COLOR')]")
	WebElement ErrorMessagesideGuidCol;

	public String getErrorMessagesideGuidCol() {
		js = (JavascriptExecutor) driver;

//				WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessagesideGuidCol.getText();

	}

	// Price BOTTOM BAG CURTAIN COLOR

	@FindBy(xpath = "//table/tbody/tr[14]/td[3]")
	WebElement priceSideGuideColore;

	public String getpriceSideGuideColore() {

		String priceValue = priceSideGuideColore.getText();

		return priceValue;

	}

	// SIDE GUIDE COVER

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[8]")
	WebElement sideGuideCover;

	public void sideGuideCover(String value) {

		if (!value.equals("null")) {

			WebElement e3 = wait.until(ExpectedConditions.refreshed(
					ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@aria-haspopup='listbox'])[8]"))));

			e3.click();

		} else {
			System.out.println("please pass the colore for bottom");
		}

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> sideGuideCoverlist;

	public void sideGuideCoverselection(String model) throws InterruptedException {

		Actions act3 = new Actions(driver);

		for (int i = 0; i < sideGuideCoverlist.size(); i++) {

			String modelText = sideGuideCoverlist.get(i).getText();

			// System.out.println(model);
			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = sideGuideCoverlist.get(i);

				// Thread.sleep(1200);
				// act3.moveToElement(ele).click(ele).build().perform();
				ele.click();

			}
		}

	}

	public List<String> getsideGuideCoverlist() {

		List<String> l1 = new ArrayList<String>();

		for (int i = 0; i < sideGuideCoverlist.size(); i++) {

			String text = sideGuideCoverlist.get(i).getText();

			// System.out.println("name of color "+text);

			l1.add(text);

		}
		return l1;

	}

//	@FindBy(xpath = "(//div[@role='button'])[6]")
//	WebElement selectedelement;
//
//	public String getdefoultdefoultValuebottomFabricColore() throws InterruptedException {
//
//		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// Thread.sleep(2000);
//
//		String text2 = selectedelement.getText();
//
//		// System.out.println("selection "+text2);
//		// wait6.until(ExpectedConditions.visibilityOf(bottomcurtainColore)).getText();
//
//		// firstPhtocellHeght.getText();
//
//		return text2;
//	}

	@FindBy(xpath = "//table/tbody/tr[14]/td[3]")
	WebElement priceforsideGuideCover;

	public String getpriceforsideGuideCover() {

		String text = wait.until(ExpectedConditions.visibilityOf(priceforsideGuideCover)).getText();
		return text;

	}
////VALIDATION MESSAGE FOR INVALID OPTION

	@FindBy(xpath = "//p[contains(text(),'Please select SIDE GUIDE COVER')]")
	WebElement ErrorMessageideGuideCover;

	public String getErrorMessageideGuideCover() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageideGuideCover.getText();

	}

//
//	// Price BOTTOM BAG CURTAIN COLOR
//
//	@FindBy(xpath = "//table/tbody/tr[12]/td[3]")
//	WebElement priceBottombagCurtainColore;
//
//	public String getPriceBottombagColore() {
//
//		String priceValue = priceBottombagCurtainColore.getText();
//
//		return priceValue;
//
//	}

	// ------------------------------------------------------------------------------------------------------//

	// MOTOR COVER

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[9]")
	WebElement MotorCover;

	public void MotorCover(String value) {

		if (!value.equals("null")) {

			WebElement e3 = wait.until(ExpectedConditions.refreshed(
					ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@aria-haspopup='listbox'])[9]"))));

			e3.click();

		} else {
			System.out.println("please pass the colore for bottom");
		}

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> MotorCoverlist;

	public void MotorCoverselection(String model) throws InterruptedException {

		Actions act3 = new Actions(driver);

		for (int i = 0; i < MotorCoverlist.size(); i++) {

			String modelText = MotorCoverlist.get(i).getText();

			// System.out.println(model);
			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = MotorCoverlist.get(i);

				// Thread.sleep(1200);
				// act3.moveToElement(ele).click(ele).build().perform();
				ele.click();
				break;

			}
		}

	}

	public List<String> getMotorCoverlist() {

		List<String> l1 = new ArrayList<String>();

		for (int i = 0; i < MotorCoverlist.size(); i++) {

			String text = MotorCoverlist.get(i).getText();

			// System.out.println("name of color "+text);

			l1.add(text);

		}
		return l1;

	}

//	@FindBy(xpath = "(//div[@role='button'])[6]")
//	WebElement selectedelement;
//
//	public String getdefoultdefoultValuebottomFabricColore() throws InterruptedException {
//
//		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// Thread.sleep(2000);
//
//		String text2 = selectedelement.getText();
//
//		// System.out.println("selection "+text2);
//		// wait6.until(ExpectedConditions.visibilityOf(bottomcurtainColore)).getText();
//
//		// firstPhtocellHeght.getText();
//
//		return text2;
//	}

	@FindBy(xpath = "//table/tbody/tr[15]/td[3]")
	WebElement priceformotorCover;

	public String getpriceformotorCover() {

		String text = wait.until(ExpectedConditions.visibilityOf(priceformotorCover)).getText();
		return text;

	}
////VALIDATION MESSAGE FOR INVALID OPTION

	@FindBy(xpath = "//p[contains(text(),'Please select MOTOR COVER')]")
	WebElement ErrorMessagemotorCover;

	public String getErrorMessagemotorCover() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessagemotorCover.getText();

	}

	// ------------------------------------------------------------------------------------------------------//

	// DRUM HOOD/DRUM FASCIA

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[10]")
	WebElement DRUM_HOOD;

	public void DRUM_HOOD(String value) {

		if (!value.equals("null")) {

			WebElement e3 = wait.until(ExpectedConditions.refreshed(
					ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@aria-haspopup='listbox'])[10]"))));

			e3.click();

		} else {
			System.out.println("please pass the colore for bottom");
		}

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> DRUM_HOODlist;

	public void DRUM_HOODselection(String model) throws InterruptedException {

		Actions act3 = new Actions(driver);

		for (int i = 0; i < DRUM_HOODlist.size(); i++) {

			String modelText = DRUM_HOODlist.get(i).getText();

			// System.out.println(model);
			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = DRUM_HOODlist.get(i);

				// Thread.sleep(1200);
				// act3.moveToElement(ele).click(ele).build().perform();
				ele.click();

			}
		}

	}

	public List<String> DRUM_HOOD() {

		List<String> l1 = new ArrayList<String>();

		for (int i = 0; i < DRUM_HOODlist.size(); i++) {

			String text = DRUM_HOODlist.get(i).getText();

			// System.out.println("name of color "+text);

			l1.add(text);

		}
		return l1;

	}

//	@FindBy(xpath = "(//div[@role='button'])[6]")
//	WebElement selectedelement;
//
//	public String getdefoultdefoultValuebottomFabricColore() throws InterruptedException {
//
//		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// Thread.sleep(2000);
//
//		String text2 = selectedelement.getText();
//
//		// System.out.println("selection "+text2);
//		// wait6.until(ExpectedConditions.visibilityOf(bottomcurtainColore)).getText();
//
//		// firstPhtocellHeght.getText();
//
//		return text2;
//	}

	@FindBy(xpath = "//table/tbody/tr[16]/td[3]")
	WebElement priceforDRUM_HOOD;

	public String getpriceforDRUM_HOOD() {

		String text = wait.until(ExpectedConditions.visibilityOf(priceforDRUM_HOOD)).getText();
		return text;

	}
////VALIDATION MESSAGE FOR INVALID OPTION

	@FindBy(xpath = "//p[contains(text(),'Please select DRUM HOOD/DRUM FASCIA')]")
	WebElement ErrorMessageDRUM_HOOD;

	public String getErrorMessageDRUM_HOOD() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageDRUM_HOOD.getText();

	}

	// ------------------------------------------------------------------------------------------------------//

	// STAINLESS STEEL INNER & OUTER SIDE GUIDES

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[12]")
	WebElement STAINLESS_STEEL_INNER;

	public void STAINLESS_STEEL_INNER(String value) {

		if (!value.equals("null")) {

			WebElement e3 = wait.until(ExpectedConditions.refreshed(
					ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@aria-haspopup='listbox'])[11]"))));

			e3.click();

		} else {
			System.out.println("please pass the colore for bottom");
		}

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> STAINLESS_STEEL_INNERlist;

	public void STAINLESS_STEEL_INNERselection(String model) throws InterruptedException {

		Actions act3 = new Actions(driver);

		for (int i = 0; i < STAINLESS_STEEL_INNERlist.size(); i++) {

			String modelText = STAINLESS_STEEL_INNERlist.get(i).getText();

			// System.out.println(model);
			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = STAINLESS_STEEL_INNERlist.get(i);

				// Thread.sleep(1200);
				// act3.moveToElement(ele).click(ele).build().perform();
				ele.click();

			}
		}

	}

	public List<String> STAINLESS_STEEL_INNER() {

		List<String> l1 = new ArrayList<String>();

		for (int i = 0; i < STAINLESS_STEEL_INNERlist.size(); i++) {

			String text = STAINLESS_STEEL_INNERlist.get(i).getText();

			// System.out.println("name of color "+text);

			l1.add(text);

		}
		return l1;

	}

//	@FindBy(xpath = "(//div[@role='button'])[6]")
//	WebElement selectedelement;
//
//	public String getdefoultdefoultValuebottomFabricColore() throws InterruptedException {
//
//		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// Thread.sleep(2000);
//
//		String text2 = selectedelement.getText();
//
//		// System.out.println("selection "+text2);
//		// wait6.until(ExpectedConditions.visibilityOf(bottomcurtainColore)).getText();
//
//		// firstPhtocellHeght.getText();
//
//		return text2;
//	}

	@FindBy(xpath = "//table/tbody/tr[17]/td[3]")
	WebElement priceforSTAINLESS_STEEL_INNER;

	public String getpriceforSTAINLESS_STEEL_INNER() {

		String text = wait.until(ExpectedConditions.visibilityOf(priceforSTAINLESS_STEEL_INNER)).getText();
		return text;

	}
////VALIDATION MESSAGE FOR INVALID OPTION

	@FindBy(xpath = "//p[contains(text(),'Please select STAINLESS STEEL INNER & OUTER SIDE GUIDES')]")
	WebElement ErrorMessageSTAINLESS_STEEL_INNER;

	public String getErrorMessageSTAINLESS_STEEL_INNER() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageSTAINLESS_STEEL_INNER.getText();

	}

	// ------------------------------------------------------------------------------------------------------//

	// STAINLESS STEEL SHAFT DRUMS & BEARINGS

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[13]")
	WebElement stainlessSteelDrumBearing;

	public void stainlessSteelDrumBearing() {

		wait.until(ExpectedConditions.elementToBeClickable(stainlessSteelDrumBearing)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> stainlessSteelDrumBearinglist;

	public void stainlessSteelDrumBearingSelection(String model) throws InterruptedException {

		for (int i = 0; i < stainlessSteelDrumBearinglist.size(); i++) {

			String modelText = stainlessSteelDrumBearinglist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = stainlessSteelDrumBearinglist.get(i);

				act.moveToElement(ele).click(ele).build().perform();

				// Thread.sleep(500);

			}
		}

	}

	// PRICE STAINLESS STEEL SHAFT DRUMS & BEARINGS

	@FindBy(xpath = "//table/tbody/tr[18]/td[3]")
	WebElement pricestainlessSteelDrumBearing;

	public String getpricestainlessSteelDrumBearing() {

		String priceValue = pricestainlessSteelDrumBearing.getText();

		return priceValue;

	}

	public String getdefoultdefoultValuestainlessSteelDrumBearing() {
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(40));

		String text = wait6.until(ExpectedConditions.visibilityOf(stainlessSteelDrumBearing)).getText();

		// firstPhtocellHeght.getText();

		return text;
	}

	@FindBy(xpath = "//p[contains(text(),'Please select STAINLESS STEEL SHAFTS, DRUMS & BEARINGS')]")
	WebElement ErrorMessageStainlessSteel;

	public String getErrorMessageStainlessSteel() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageStainlessSteel.getText();

	}

	// -------------------------------------------------------------------------------------------//

	// STAINLESS STEEL PACKAGE

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[14]")
	WebElement STAINLESS_STEEL_PACKAGE;

	public void STAINLESS_STEEL_PACKAGE() {

		wait.until(ExpectedConditions.elementToBeClickable(STAINLESS_STEEL_PACKAGE)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> STAINLESSlist_STEEL_PACKAGElist;

	public void STAINLESS_STEEL_PACKAGESelection(String model) throws InterruptedException {

		for (int i = 0; i < STAINLESSlist_STEEL_PACKAGElist.size(); i++) {

			String modelText = STAINLESSlist_STEEL_PACKAGElist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = STAINLESSlist_STEEL_PACKAGElist.get(i);

				act.moveToElement(ele).click(ele).build().perform();

				// Thread.sleep(500);

			}
		}

	}

	// PRICE STAINLESS STEEL SHAFT DRUMS & BEARINGS

	@FindBy(xpath = "//table/tbody/tr[19]/td[3]")
	WebElement pricesSTAINLESS_STEEL_PACKAGE;

	public String getpricesSTAINLESS_STEEL_PACKAGE() {

		String priceValue = pricesSTAINLESS_STEEL_PACKAGE.getText();

		return priceValue;

	}

//	public String getdefoultdefoultValuestainlessSteelDrumBearing() {
//		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(40));
//
//		String text = wait6.until(ExpectedConditions.visibilityOf(stainlessSteelDrumBearing)).getText();
//
//		// firstPhtocellHeght.getText();
//
//		return text;
//	}

	@FindBy(xpath = "//p[contains(text(),'Please select STAINLESS STEEL PACKAGE')]")
	WebElement ErrorMessageStainlessSteelPackage;

	public String getErrorMessageStainlessSteelPackage() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageStainlessSteelPackage.getText();

	}

	// --------------------------------------------------------------------------------------------//

	// ADDITIONAL REINSERTION POINTS

	@FindBy(xpath = "//p[contains(text(),'Please enter a value between 1 and 20')]")
	WebElement ErrorADDITIONAL_REINSERTION_POINTS;

	public String getErrorADDITIONAL_REINSERTION_POINTS() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageForDecimal.getText();

	}

	@FindBy(xpath = "//table/tbody/tr[20]/td[3]")
	WebElement pricesADDITIONAL_REINSERTION_POINTS;

	public String getpricesADDITIONAL_REINSERTION_POINTS() {

		String priceValue = pricesADDITIONAL_REINSERTION_POINTS.getText();

		return priceValue;

	}

	@FindBy(xpath = "(//input[@aria-invalid='true' or @type='text'])[5]")
	WebElement ADDITIONAL_REINSERTION_POINTS;

	public void ADDITIONAL_REINSERTION_POINTSSendkey(String doorquantity) throws InterruptedException {

		// Thread.sleep(1500);
		Actions act = new Actions(driver);

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@aria-invalid='true' and @type='text'])[6]")));

		act.sendKeys(element, doorquantity).build().perform();
		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		;

	}

	// --------------------------------------------------------------------------------------------//

	// HEAVY_IMPACT_ZONE

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[12]")
	WebElement HEAVY_IMPACT_ZONE;

	public void HEAVY_IMPACT_ZONE() {

		wait.until(ExpectedConditions.elementToBeClickable(HEAVY_IMPACT_ZONE)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> HEAVY_IMPACT_ZONEList;

	public void HEAVY_IMPACT_ZONESelection(String model) throws InterruptedException {

		for (int i = 0; i < HEAVY_IMPACT_ZONEList.size(); i++) {

			String modelText = HEAVY_IMPACT_ZONEList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = HEAVY_IMPACT_ZONEList.get(i);

				act.moveToElement(ele).click(ele).build().perform();

				// Thread.sleep(500);

			}
		}

	}

	// PRICE STAINLESS STEEL SHAFT DRUMS & BEARINGS

	@FindBy(xpath = "//table/tbody/tr[21]/td[3]")
	WebElement pricesHEAVY_IMPACT_ZONE;

	public String getpricespricesHEAVY_IMPACT_ZONE() {

		String priceValue = pricesHEAVY_IMPACT_ZONE.getText();

		return priceValue;

	}

//	public String getdefoultdefoultValuestainlessSteelDrumBearing() {
//		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(40));
//
//		String text = wait6.until(ExpectedConditions.visibilityOf(stainlessSteelDrumBearing)).getText();
//
//		// firstPhtocellHeght.getText();
//
//		return text;
//	}

	@FindBy(xpath = "//p[contains(text(),'Please select Heavy Impact Zone')]")
	WebElement ErrorMessageHEAVY_IMPACT_ZONE;

	public String getErrorMessageHEAVY_IMPACT_ZONE() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageHEAVY_IMPACT_ZONE.getText();

	}

	// --------------------------------------------------------------------------------------------//

	// MANUAL CHAIN HOIST

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[13]")
	WebElement manualChainHoist;

	public void manualChainHoist() {

		wait.until(ExpectedConditions.elementToBeClickable(manualChainHoist)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> manualChainHoistList;

	public void manualChainHoistSelection(String model) throws InterruptedException {

		for (int i = 0; i < manualChainHoistList.size(); i++) {

			String modelText = manualChainHoistList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = manualChainHoistList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	// PRICE MANUAL CHAIN HOIST

	@FindBy(xpath = "//table/tbody/tr[22]/td[3]")
	WebElement pricemanualChainHoist;

	public String getpricemanualChainHoist() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(pricemanualChainHoist));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	// --------------------------------------------------------------------------------------------//

	// FORE-FRAME

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[17]")
	WebElement FORE_FRAME;

	public void FORE_FRAME() {

		wait.until(ExpectedConditions.elementToBeClickable(FORE_FRAME)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> FORE_FRAMEList;

	public void FORE_FRAMESelection(String model) throws InterruptedException {

		for (int i = 0; i < FORE_FRAMEList.size(); i++) {

			String modelText = FORE_FRAMEList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = FORE_FRAMEList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	// PRICE MANUAL CHAIN HOIST

	@FindBy(xpath = "//table/tbody/tr[23]/td[3]")
	WebElement priceFORE_FRAME;

	public String getpriceFORE_FRAME() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceFORE_FRAME));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select FORE-FRAME')]")
	WebElement ErrorMessageFORE_FRAME;

	public String getErrorMessageFORE_FRAME() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageFORE_FRAME.getText();

	}

	// --------------------------------------------------------------------------------------------//

	// INSULATING_CURTAIN

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[18]")
	WebElement INSULATING_CURTAIN;

	public void INSULATING_CURTAIN() {

		wait.until(ExpectedConditions.elementToBeClickable(FORE_FRAME)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> INSULATING_CURTAINlist;

	public void INSULATING_CURTAINSelection(String model) throws InterruptedException {

		for (int i = 0; i < INSULATING_CURTAINlist.size(); i++) {

			String modelText = INSULATING_CURTAINlist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = INSULATING_CURTAINlist.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	// PRICE MANUAL CHAIN HOIST

	@FindBy(xpath = "//table/tbody/tr[24]/td[3]")
	WebElement priceINSULATING_CURTAIN;

	public String getpriceINSULATING_CURTAIN() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceINSULATING_CURTAIN));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select INSULATING CURTAIN')]")
	WebElement ErrorMessageINSULATING_CURTAIN;

	public String getErrorMessageINSULATING_CURTAIN() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageINSULATING_CURTAIN.getText();

	}

//--------------------------------------------------------------------------------------------//

	// EGRESS_CURTAIN

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[18]")
	WebElement EGRESS_CURTAIN;

	public void EGRESS_CURTAIN() {

		wait.until(ExpectedConditions.elementToBeClickable(EGRESS_CURTAIN)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> EGRESS_CURTAINlist;

	public void EGRESS_CURTAINSelection(String model) throws InterruptedException {

		for (int i = 0; i < EGRESS_CURTAINlist.size(); i++) {

			String modelText = EGRESS_CURTAINlist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = EGRESS_CURTAINlist.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[25]/td[3]")
	WebElement priceEGRESS_CURTAIN;

	public String getEGRESS_CURTAIN() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceEGRESS_CURTAIN));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select EGRESS CURTAIN')]")
	WebElement ErrorMessageEGRESS_CURTAIN;

	public String getErrorMessageEGRESS_CURTAIN() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageEGRESS_CURTAIN.getText();

	}

//--------------------------------------------------------------------------------------------//

	// SEALED_BOTTOM_BAG

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[19]")
	WebElement SEALED_BOTTOM_BAG;

	public void SEALED_BOTTOM_BAG() {

		wait.until(ExpectedConditions.elementToBeClickable(SEALED_BOTTOM_BAG)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> SEALED_BOTTOM_BAGList;

	public void SEALED_BOTTOM_BAGSelection(String model) throws InterruptedException {

		for (int i = 0; i < SEALED_BOTTOM_BAGList.size(); i++) {

			String modelText = SEALED_BOTTOM_BAGList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = SEALED_BOTTOM_BAGList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[26]/td[3]")
	WebElement priceSEALED_BOTTOM_BAG;

	public String getpriceSEALED_BOTTOM_BAG() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceSEALED_BOTTOM_BAG));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select SEALED BOTTOM BAG')]")
	WebElement ErrorMessageSEALED_BOTTOM_BAG;

	public String getErrorMessageSEALED_BOTTOM_BAG() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageSEALED_BOTTOM_BAG.getText();

	}

//--------------------------------------------------------------------------------------------//

//	WINDOW_QUANTITY

	@FindBy(xpath = "//p[contains(text(),'Please enter a value between 1 and 5')]")
	WebElement errorWINDOW_QUANTITY;

	public String geterrorWINDOW_QUANTITY() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorWINDOW_QUANTITY.getText();

	}

	@FindBy(xpath = "//table/tbody/tr[28]/td[3]")
	WebElement pricesWINDOW_QUANTITY;

	public String getpricesVISION_AND_SCREEN() {

		String priceValue = pricesWINDOW_QUANTITY.getText();

		return priceValue;

	}

	@FindBy(xpath = "(//input[@aria-invalid='true' or @type='text'])[6]")
	WebElement WINDOW_QUANTITY;

	public void WINDOW_QUANTITYSendKeys(String doorquantity) throws InterruptedException {

		WINDOW_QUANTITY.sendKeys(doorquantity);

		// Thread.sleep(1500);
//		Actions act = new Actions(driver);
//
//		WebElement element = wait.until(ExpectedConditions
//				.presenceOfElementLocated(By.xpath("(//input[@aria-invalid='true' or @type='text'])[6]")));
//
//		act.sendKeys(element, doorquantity).build().perform();
//		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		;

	}

//--------------------------------------------------------------------------------------------//

//VISION_AND_SCREEN

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[15]")
	WebElement VISION_AND_SCREEN;

	public void VISION_AND_SCREEN() {

		wait.until(ExpectedConditions.elementToBeClickable(VISION_AND_SCREEN)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> VISION_AND_SCREENLiST;

	public void VISION_AND_SCREENelection(String model) throws InterruptedException {

		for (int i = 0; i < VISION_AND_SCREENLiST.size(); i++) {

			String modelText = VISION_AND_SCREENLiST.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = VISION_AND_SCREENLiST.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[27]/td[3]")
	WebElement priceVISION_AND_SCREEN;

	public String getpriceVISION_AND_SCREEN() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceVISION_AND_SCREEN));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select VISION AND SCREEN')]")
	WebElement ErrorMessageVISION_AND_SCREEN;

	public String getErrorMessageVISION_AND_SCREEN() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageVISION_AND_SCREEN.getText();

	}
//--------------------------------------------------------------------------------------------//

	// LOGO_AND_PRINT_LOCATION

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[21]")
	WebElement LOGO_AND_PRINT_LOCATION;

	public void LOGO_AND_PRINT_LOCATION() {

		wait.until(ExpectedConditions.elementToBeClickable(LOGO_AND_PRINT_LOCATION)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> LOGO_AND_PRINT_LOCATIONList;

	public void LOGO_AND_PRINT_LOCATIONSelection(String model) throws InterruptedException {

		for (int i = 0; i < LOGO_AND_PRINT_LOCATIONList.size(); i++) {

			String modelText = LOGO_AND_PRINT_LOCATIONList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = LOGO_AND_PRINT_LOCATIONList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[29]/td[3]")
	WebElement priceLOGO_AND_PRINT_LOCATION;

	public String getpriceLOGO_AND_PRINT_LOCATION() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceLOGO_AND_PRINT_LOCATION));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select LOGOS AND PRINTS SIZE')]")
	WebElement ErrorMessageLOGO_AND_PRINT_LOCATION;

	public String getErrorMessageLOGO_AND_PRINT_LOCATION() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageLOGO_AND_PRINT_LOCATION.getText();

	}

	// --------------------------------------------------------------------------------------------//

	// LOGOS_AND_PRINTS_SIZE

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[22]")
	WebElement LOGOS_AND_PRINTS_SIZE;

	public void LOGOS_AND_PRINTS_SIZE() {

		wait.until(ExpectedConditions.elementToBeClickable(LOGOS_AND_PRINTS_SIZE)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> LOGOS_AND_PRINTS_SIZEList;

	public void LOGOS_AND_PRINTS_SIZESelection(String model) throws InterruptedException {

		for (int i = 0; i < LOGOS_AND_PRINTS_SIZEList.size(); i++) {

			String modelText = LOGOS_AND_PRINTS_SIZEList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = LOGOS_AND_PRINTS_SIZEList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[30]/td[3]")
	WebElement priceLOGOS_AND_PRINTS_SIZE;

	public String getpriceLOGOS_AND_PRINTS_SIZE() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceLOGOS_AND_PRINTS_SIZE));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select LOGOS AND PRINTS SIZE')]")
	WebElement ErrorMessageLOGOS_AND_PRINTS_SIZE;

	public String getErrorMessageLOGOS_AND_PRINTS_SIZE() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageLOGOS_AND_PRINTS_SIZE.getText();

	}

	// --------------------------------------------------------------------------------------------//

	// MECHANICAL SIDE LOGO HEIGHT (INCHES)

	@FindBy(xpath = "//p[contains(text(),'Please enter a value between 1 and 50')]")
	WebElement errorMeghanicalHeight;

	public String geterrorMeghanicalHeight() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMeghanicalHeight.getText();

	}

	@FindBy(xpath = "//table/tbody/tr[31]/td[3]")
	WebElement priceerrorMeghanicalHeight;

	public String getpriceerrorMeghanicalHeight() {

		String priceValue = priceerrorMeghanicalHeight.getText();

		return priceValue;

	}

	@FindBy(xpath = "(//input[@aria-invalid='true' or @type='text'])[8]")
	WebElement MeghanicalHeight;

	public void MeghanicalHeightSendKeys(String doorquantity) throws InterruptedException {

		// Thread.sleep(1500);
		Actions act = new Actions(driver);

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@aria-invalid='true' or @type='text'])[8]")));

		act.sendKeys(element, doorquantity).build().perform();
		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		;

	}

	// --------------------------------------------------------------------------------------------//

	// MECHANICAL SIDE LOGO WIDTH (INCHES)

	@FindBy(xpath = "//p[contains(text(),'Please enter a value between 1 and 50')]")
	WebElement errorMeghanicalWidth;

	public String geterrorMeghanicalWidth() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMeghanicalWidth.getText();

	}

	@FindBy(xpath = "//table/tbody/tr[32]/td[3]")
	WebElement priceerrorMeghanicalWidth;

	public String getpriceerrorMeghanicalWidth() {

		String priceValue = priceerrorMeghanicalWidth.getText();

		return priceValue;

	}

	@FindBy(xpath = "(//input[@aria-invalid='true' or @type='text'])[9]")
	WebElement MeghanicalWidth;

	public void MeghanicalWidthSendKeys(String doorquantity) throws InterruptedException {

		// Thread.sleep(1500);
		Actions act = new Actions(driver);

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@aria-invalid='true' or @type='text'])[9]")));

		act.sendKeys(element, doorquantity).build().perform();
		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		;

	}

	// --------------------------------------------------------------------------------------------//

	// MECHANICAL SIDE LOGO FROM FLOOR (INCHES

	@FindBy(xpath = "//p[contains(text(),'Please enter a value between 1 and 50')]")
	WebElement errorMeghanicalFloor;

	public String geterrorMeghanicalFloor() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMeghanicalFloor.getText();

	}

	@FindBy(xpath = "//table/tbody/tr[33]/td[3]")
	WebElement priceerrorMeghanicalFloor;

	public String getpriceerrorMeghanicalFloor() {

		String priceValue = priceerrorMeghanicalFloor.getText();

		return priceValue;

	}

	@FindBy(xpath = "(//input[@aria-invalid='true' or @type='text'])[10]")
	WebElement MeghanicalFloor;

	public void MeghanicalFloorSendKeys(String doorquantity) throws InterruptedException {

		// Thread.sleep(1500);
		Actions act = new Actions(driver);

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@aria-invalid='true' or @type='text'])[10]")));

		act.sendKeys(element, doorquantity).build().perform();
		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		;

	}

	// --------------------------------------------------------------------------------------------//

	//// NON-MECHANICAL SIDE LOGO HEIGHT (INCHES)

	@FindBy(xpath = "//p[contains(text(),'Please enter a value between 1 and 50')]")
	WebElement errorNonMeghanicalHeight;

	public String geterrorNonMeghanicalHeight() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorNonMeghanicalHeight.getText();

	}

	@FindBy(xpath = "//table/tbody/tr[34]/td[3]")
	WebElement priceerrorNonMeghanicalHeight;

	public String getpriceerrorNonMeghanicalHeight() {

		String priceValue = priceerrorNonMeghanicalHeight.getText();

		return priceValue;

	}

	@FindBy(xpath = "(//input[@aria-invalid='true' or @type='text'])[11]")
	WebElement NonMeghanicalHeight;

	public void NonMeghanicalHeightSendKeys(String doorquantity) throws InterruptedException {

		// Thread.sleep(1500);
		Actions act = new Actions(driver);

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@aria-invalid='true' or @type='text'])[11]")));

		act.sendKeys(element, doorquantity).build().perform();
		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		;

	}

	//// --------------------------------------------------------------------------------------------//

	// NON-MECHANICAL SIDE LOGO WIDTH (INCHES)

	@FindBy(xpath = "//p[contains(text(),'Please enter a value between 1 and 50')]")
	WebElement errorNonMeghanicalwidth;

	public String geterrorNonMeghanicalwidth() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorNonMeghanicalwidth.getText();

	}

	@FindBy(xpath = "//table/tbody/tr[35]/td[3]")
	WebElement priceerrorNonMeghanicalWidth;

	public String getpriceerrorNonMeghanicalWidth() {

		String priceValue = priceerrorNonMeghanicalWidth.getText();

		return priceValue;

	}

	@FindBy(xpath = "(//input[@aria-invalid='true' or @type='text'])[12]")
	WebElement NonMeghanicalWidth;

	public void NonMeghanicalWidthSendKeys(String doorquantity) throws InterruptedException {

		// Thread.sleep(1500);
		Actions act = new Actions(driver);

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@aria-invalid='true' or @type='text'])[12]")));

		act.sendKeys(element, doorquantity).build().perform();
		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		;

	}

////--------------------------------------------------------------------------------------------//

//	NON-MECHANICAL SIDE LOGO FROM FLOOR

	@FindBy(xpath = "//p[contains(text(),'Please enter a value between 1 and 50')]")
	WebElement errorNonMeghanicalfloor;

	public String geterrorNonMeghanicalfloor() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorNonMeghanicalfloor.getText();

	}

	@FindBy(xpath = "//table/tbody/tr[36]/td[3]")
	WebElement priceerrorNonMeghanicalfloor;

	public String getpriceerrorNonMeghanicalfloor() {

		String priceValue = priceerrorNonMeghanicalfloor.getText();

		return priceValue;

	}

	@FindBy(xpath = "(//input[@aria-invalid='true' or @type='text'])[13]")
	WebElement NonMeghanicalFloor;

	public void NonMeghanicalFloorSendKeys(String doorquantity) throws InterruptedException {

		// Thread.sleep(1500);
		Actions act = new Actions(driver);

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@aria-invalid='true' or @type='text'])[13]")));

		act.sendKeys(element, doorquantity).build().perform();
		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		;

	}

////--------------------------------------------------------------------------------------------//

	// CONTROL_PANEL

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[20]")
	WebElement CONTROL_PANEL;

	public void CONTROL_PANEL() {

		wait.until(ExpectedConditions.elementToBeClickable(LOGOS_AND_PRINTS_SIZE)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> CONTROL_PANELList;

	public void CONTROL_PANELSelection(String model) throws InterruptedException {

		for (int i = 0; i < CONTROL_PANELList.size(); i++) {

			String modelText = CONTROL_PANELList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = CONTROL_PANELList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[37]/td[3]")
	WebElement priceCONTROL_PANEL;

	public String getpriceCONTROL_PANEL() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceCONTROL_PANEL));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select CONTROL PANEL')]")
	WebElement ErrorMessageCONTROL_PANEL;

	public String getErrorMessageCONTROL_PANEL() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageCONTROL_PANEL.getText();

	}

////--------------------------------------------------------------------------------------------//

	// INCOMING_POWER

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[17]")
	WebElement INCOMING_POWER;

	public void INCOMING_POWER() throws InterruptedException {

		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(INCOMING_POWER)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> INCOMING_POWERList;

	public void INCOMING_POWERSelection(String model) throws InterruptedException {

		for (int i = 0; i < INCOMING_POWERList.size(); i++) {

			String modelText = INCOMING_POWERList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = INCOMING_POWERList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[38]/td[3]")
	WebElement priceINCOMING_POWER;

	public String getpriceINCOMING_POWER() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceINCOMING_POWER));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select INCOMING POWER')]")
	WebElement ErrorMessageINCOMING_POWER;

	public String getErrorMessageINCOMING_POWER() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageINCOMING_POWER.getText();

	}

//--------------------------------------------------------------------------------------------------------------//

	// ADDITIONAL_CABLES (FEET)

	@FindBy(xpath = "//p[contains(text(),'Please enter a valid ADDITIONAL CABLES (FEET)')]")
	WebElement errorADDITIONAL_CABLES;

	public String geterrorADDITIONAL_CABLES() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorADDITIONAL_CABLES.getText();

	}

	@FindBy(xpath = "//table/tbody/tr[39]/td[3]")
	WebElement priceerrorADDITIONAL_CABLES;

	public String getpriceerrorADDITIONAL_CABLES() {

		String priceValue = priceerrorADDITIONAL_CABLES.getText();

		return priceValue;

	}

	@FindBy(xpath = "//table/tbody/tr[26]/td/div/div/div/input")
	WebElement ADDITIONAL_CABLES;

	public void ADDITIONAL_CABLESSendKeys(String doorquantity) throws InterruptedException {

//		js=(JavascriptExecutor)driver;
//		
//		js.executeScript("arguments[0].click();", ADDITIONAL_CABLES);

		ADDITIONAL_CABLES.sendKeys(doorquantity);

//		// Thread.sleep(1500);
//		Actions act = new Actions(driver);
//
//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ADDITIONAL_CABLES));
//
//		act.sendKeys(element, doorquantity).build().perform();
//		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		;

	}
	// --------------------------------------------------------------------------------------------------------------//

	// LINE_LOAD_REACTOR

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[18]")
	WebElement LINE_LOAD_REACTOR;

	public void LINE_LOAD_REACTOR() {

		wait.until(ExpectedConditions.elementToBeClickable(LINE_LOAD_REACTOR)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> LINE_LOAD_REACTORList;

	public void LINE_LOAD_REACTORSelection(String model) throws InterruptedException {

		for (int i = 0; i < LINE_LOAD_REACTORList.size(); i++) {

			String modelText = LINE_LOAD_REACTORList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = LINE_LOAD_REACTORList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				Thread.sleep(100);

				break;
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[40]/td[3]")
	WebElement priceLINE_LOAD_REACTOR;

	public String getpriceLINE_LOAD_REACTOR() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceLINE_LOAD_REACTOR));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select LINE LOAD REACTOR')]")
	WebElement ErrorMessageLINE_LOAD_REACTOR;

	public String getErrorMessageLINE_LOAD_REACTOR() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageLINE_LOAD_REACTOR.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// ADDITIONAL_PHOTOCELL

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[19]")
	WebElement ADDITIONAL_PHOTOCELL;

	public void ADDITIONAL_PHOTOCELL() {

		wait.until(ExpectedConditions.elementToBeClickable(ADDITIONAL_PHOTOCELL)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> ADDITIONAL_PHOTOCELLlist;

	public void ADDITIONAL_PHOTOCELLSelection(String model) throws InterruptedException {

		System.out.println(ADDITIONAL_PHOTOCELLlist.size());

		for (int i = 0; i < ADDITIONAL_PHOTOCELLlist.size(); i++) {

			String modelText = ADDITIONAL_PHOTOCELLlist.get(i).getText();

			if (modelText.contains(model)) {

				System.out.println(modelText);
				WebElement ele = ADDITIONAL_PHOTOCELLlist.get(i);
				Thread.sleep(500);
				WebElement find = wait.until(ExpectedConditions.elementToBeClickable(ele));

				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", find);

				break;

			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[41]/td[3]")
	WebElement priceADDITIONAL_PHOTOCELL;

	public String getpriceADDITIONAL_PHOTOCELL() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceADDITIONAL_PHOTOCELL));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select ADDITIONAL PHOTOCELL')]")
	WebElement ErrorMessageADDITIONAL_PHOTOCELL;

	public String getErrorMessageADDITIONAL_PHOTOCELL() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageADDITIONAL_PHOTOCELL.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// ADDITIONAL PHOTOCELL HEIGHT

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[20]")
	WebElement ADDITIONAL_PHOTOCELLHeight;

	public void ADDITIONAL_PHOTOCELLHeight() {

		wait.until(ExpectedConditions.elementToBeClickable(ADDITIONAL_PHOTOCELLHeight)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> ADDITIONAL_PHOTOCELLHeightList;

	public void ADDITIONAL_PHOTOCELLHeightSelection(String model) throws InterruptedException {

		for (int i = 0; i < ADDITIONAL_PHOTOCELLHeightList.size(); i++) {

			String modelText = ADDITIONAL_PHOTOCELLHeightList.get(i).getText();

			if (modelText.contains(model)) {

				WebElement ele = ADDITIONAL_PHOTOCELLHeightList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[42]/td[3]")
	WebElement priceADDITIONAL_PHOTOCELLHeight;

	public String getpriceADDITIONAL_PHOTOCELLHeight() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceADDITIONAL_PHOTOCELLHeight));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select ADDITIONAL PHOTOCELL HEIGHT')]")
	WebElement ErrorMessageADDITIONAL_PHOTOCELLHeight;

	public String getErrorMessageADDITIONAL_PHOTOCELLHeight() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageADDITIONAL_PHOTOCELLHeight.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// INTELLI_EDGE (DYNALOGIX 5)

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[28]")
	WebElement INTELLI_EDGE;

	public void INTELLI_EDGE() {

		wait.until(ExpectedConditions.elementToBeClickable(INTELLI_EDGE)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> INTELLI_EDGEList;

	public void INTELLI_EDGESelection(String model) throws InterruptedException {

		for (int i = 0; i < INTELLI_EDGEList.size(); i++) {

			String modelText = INTELLI_EDGEList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = INTELLI_EDGEList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[43]/td[3]")
	WebElement priceINTELLI_EDGE;

	public String getpriceINTELLI_EDGE() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceINTELLI_EDGE));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select INTELLI-EDGE (DYNALOGIX 5)')]")
	WebElement ErrorMessageINTELLI_EDGE;

	public String getErrorMessageINTELLI_EDGE() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageINTELLI_EDGE.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// PNEUMATIC_BOTTOM EDGE WITH SWITCH

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[29]")
	WebElement PNEUMATIC_BOTTOM;

	public void PNEUMATIC_BOTTOM() {

		wait.until(ExpectedConditions.elementToBeClickable(PNEUMATIC_BOTTOM)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> PNEUMATIC_BOTTOMList;

	public void PNEUMATIC_BOTTOMSelection(String model) throws InterruptedException {

		for (int i = 0; i < PNEUMATIC_BOTTOMList.size(); i++) {

			String modelText = PNEUMATIC_BOTTOMList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = PNEUMATIC_BOTTOMList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[44]/td[3]")
	WebElement pricePNEUMATIC_BOTTOM;

	public String getpriceNEUMATIC_BOTTOM() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(pricePNEUMATIC_BOTTOM));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select PNEUMATIC BOTTOM EDGE WITH SWITCH')]")
	WebElement ErrorMessagePNEUMATIC_BOTTOM;

	public String GETErrorMessagePNEUMATIC_BOTTOM() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessagePNEUMATIC_BOTTOM.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// EXTENDED_ZIPPER

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[25]")
	WebElement EXTENDED_ZIPPER;

	public void EXTENDED_ZIPPER() {

		wait.until(ExpectedConditions.elementToBeClickable(EXTENDED_ZIPPER)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> EXTENDED_ZIPPERlIST;

	public void EXTENDED_ZIPPERSelection(String model) throws InterruptedException {

		for (int i = 0; i < EXTENDED_ZIPPERlIST.size(); i++) {

			String modelText = EXTENDED_ZIPPERlIST.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = EXTENDED_ZIPPERlIST.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[45]/td[3]")
	WebElement priceEXTENDED_ZIPPER;

	public String GETpriceEXTENDED_ZIPPER() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceEXTENDED_ZIPPER));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select EXTENDED ZIPPER')]")
	WebElement ErrorMessageEXTENDED_ZIPPER;

	public String GETErrorMessageEXTENDED_ZIPPER() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageEXTENDED_ZIPPER.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// STAINLESS_STEEL ZIPPER CABLE

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[26]")
	WebElement STAINLESS_STEEL;

	public void STAINLESS_STEEL() {

		wait.until(ExpectedConditions.elementToBeClickable(STAINLESS_STEEL)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> STAINLESS_STEELlist;

	public void STAINLESS_STEELSelection(String model) throws InterruptedException {

		for (int i = 0; i < STAINLESS_STEELlist.size(); i++) {

			String modelText = STAINLESS_STEELlist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = STAINLESS_STEELlist.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[46]/td[3]")
	WebElement STAINLESS_STEELPrice;

	public String getSTAINLESS_STEELPrice() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(STAINLESS_STEELPrice));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select STAINLESS STEEL ZIPPER CABLE')]")
	WebElement ErrorMessageSTAINLESS_STEEL;

	public String getErrorMessageSTAINLESS_STEEL() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageSTAINLESS_STEEL.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// REDUCED_LINTEL

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[32]")
	WebElement REDUCED_LINTEL;

	public void REDUCED_LINTEL() {

		wait.until(ExpectedConditions.elementToBeClickable(REDUCED_LINTEL)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> REDUCED_LINTELList;

	public void REDUCED_LINTELSelection(String model) throws InterruptedException {

		for (int i = 0; i < REDUCED_LINTELList.size(); i++) {

			String modelText = REDUCED_LINTELList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = REDUCED_LINTELList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[47]/td[3]")
	WebElement REDUCED_LINTELPrice;

	public String getREDUCED_LINTELPrice() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(REDUCED_LINTELPrice));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select REDUCED LINTEL')]")
	WebElement ErrorMessageREDUCED_LINTEL;

	public String getErrorMessageREDUCED_LINTEL() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageREDUCED_LINTEL.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// EZX_BLOWER_UNIT (BERNER)

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[34]")
	WebElement EZX_BLOWER_UNIT;

	public void EXTENDED_HEADER() {

		wait.until(ExpectedConditions.elementToBeClickable(EZX_BLOWER_UNIT)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> EZX_BLOWER_UNITList;

	public void EXTENDED_HEADERSelection(String model) throws InterruptedException {

		for (int i = 0; i < EZX_BLOWER_UNITList.size(); i++) {

			String modelText = EZX_BLOWER_UNITList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = EZX_BLOWER_UNITList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[49]/td[3]")
	WebElement EZX_BLOWER_UNITPrice;

	public String getEXTENDED_HEADERPrice() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(EZX_BLOWER_UNITPrice));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select EZX Blower Unit (Berner)')]")
	WebElement ErrorMessageEZX_BLOWER_UNIT;

	public String getErrorMessageEZX_BLOWER_UNIT() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageEZX_BLOWER_UNIT.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// EZX_BLOWER_UNIT (BERNER) VOLTAGE

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[35]")
	WebElement EZX_BLOWER_UNITVoltage;

	public void EZX_BLOWER_UNIT() {

		wait.until(ExpectedConditions.elementToBeClickable(EZX_BLOWER_UNITVoltage)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> EZX_BLOWER_UNITVoltageList;

	public void EZX_BLOWER_UNITVoltageSelection(String model) throws InterruptedException {

		for (int i = 0; i < EZX_BLOWER_UNITVoltageList.size(); i++) {

			String modelText = EZX_BLOWER_UNITVoltageList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = EZX_BLOWER_UNITVoltageList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[50]/td[3]")
	WebElement EZX_BLOWER_UNIT_VOLTAGEPrice;

	public String getEZX_BLOWER_UNIT_VOLTAGEPrice() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(EZX_BLOWER_UNIT_VOLTAGEPrice));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select EZX BLOWER UNIT (BERNER) VOLTAGE')]")
	WebElement ErrorMessageEZX_BLOWER_UNIT_VOLTAGE;

	public String getErrorMessageEZX_BLOWER_UNIT_VOLTAGE() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageEZX_BLOWER_UNIT_VOLTAGE.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// EZX_BLOWER_UNIT (BERNER) REMOTE WALL SWITCH BLOWER & HEAT (ON/OFF)

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[36]")
	WebElement EZX_BLOWER_UNITREMOTWALL;

	public void EZX_BLOWER_UNITREMOTWALL() {

		wait.until(ExpectedConditions.elementToBeClickable(EZX_BLOWER_UNITREMOTWALL)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> EZX_BLOWER_UNITREMOTWALLllIST;

	public void EZX_BLOWER_UNITREMOTWALLlSelection(String model) throws InterruptedException {

		for (int i = 0; i < EZX_BLOWER_UNITREMOTWALLllIST.size(); i++) {

			String modelText = EZX_BLOWER_UNITREMOTWALLllIST.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = EZX_BLOWER_UNITREMOTWALLllIST.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[51]/td[3]")
	WebElement EZX_BLOWER_UNITREMOTWALLPrice;

	public String getEZX_BLOWER_UNITREMOTWALLPrice() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(EZX_BLOWER_UNITREMOTWALLPrice));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select EZX BLOWER UNIT (BERNER) REMOTE WALL SWITCH BLOWER & HEAT (ON/OFF)')]")
	WebElement ErrorMessageEZX_BLOWER_UNITREMOTWALL;

	public String getErrorMessageEZX_BLOWER_UNITREMOTWALL() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageEZX_BLOWER_UNITREMOTWALL.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// EZXBLOWER UNIT (BERNER) FINISH

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[37]")
	WebElement EZX_BLOWER_UNITFinish;

	public void EZX_BLOWER_UNITFinish() {

		wait.until(ExpectedConditions.elementToBeClickable(EZX_BLOWER_UNITFinish)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> EZX_BLOWER_UNITFinishList;

	public void EZX_BLOWER_UNITFinishSelection(String model) throws InterruptedException {

		for (int i = 0; i < EZX_BLOWER_UNITFinishList.size(); i++) {

			String modelText = EZX_BLOWER_UNITFinishList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = EZX_BLOWER_UNITFinishList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[52]/td[3]")
	WebElement EZX_BLOWER_UNITFinishPrice;

	public String getEZX_BLOWER_UNITFinishPrice() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(EZX_BLOWER_UNITFinishPrice));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select EZX BLOWER UNIT (BERNER) FINISH')]")
	WebElement EZX_BLOWER_UNITFinishErrorMessage;

	public String getEZX_BLOWER_UNITFinishErrorMessage() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return EZX_BLOWER_UNITFinishErrorMessage.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// EZX BLOWER UNIT (BERNER) TIME DELAY

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[38]")
	WebElement EZX_BLOWER_UNITDelay;

	public void EZX_BLOWER_UNITDelay() {

		wait.until(ExpectedConditions.elementToBeClickable(EZX_BLOWER_UNITDelay)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> EZX_BLOWER_UNITDelayList;

	public void EZX_BLOWER_UNITDelaySelection(String model) throws InterruptedException {

		for (int i = 0; i < EZX_BLOWER_UNITDelayList.size(); i++) {

			String modelText = EZX_BLOWER_UNITDelayList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = EZX_BLOWER_UNITDelayList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[53]/td[3]")
	WebElement EZX_BLOWER_UNITDelayPrice;

	public String getEZX_BLOWER_UNITDelayPrice() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(EZX_BLOWER_UNITDelayPrice));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select EZX BLOWER UNIT (BERNER) TIME DELAY')]")
	WebElement EZX_BLOWER_UNITDelayErrorMessage;

	public String getEZX_BLOWER_UNITDelayErrorMessage() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return EZX_BLOWER_UNITDelayErrorMessage.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// EZX BLOWER UNIT (BERNER) INDUSTRIAL THERMOSTAT SWITCH

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[39]")
	WebElement EZX_BLOWER_UNITSWITCH;

	public void EZX_BLOWER_UNITSWITCH() {

		wait.until(ExpectedConditions.elementToBeClickable(EZX_BLOWER_UNITSWITCH)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> EZX_BLOWER_UNITSWITCHList;

	public void EZX_BLOWER_UNITSWITCHSelection(String model) throws InterruptedException {

		for (int i = 0; i < EZX_BLOWER_UNITSWITCHList.size(); i++) {

			String modelText = EZX_BLOWER_UNITSWITCHList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = EZX_BLOWER_UNITSWITCHList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[54]/td[3]")
	WebElement EZX_BLOWER_UNITSWITCHPrice;

	public String getEZX_BLOWER_UNITSWITCHPrice() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(EZX_BLOWER_UNITSWITCHPrice));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select EZX BLOWER UNIT (BERNER) INDUSTRIAL THERMOSTAT SWITCH')]")
	WebElement EZX_BLOWER_UNITSWITCHErrorMessage;

	public String getEZX_BLOWER_UNITSWITCHErrorMessage() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return EZX_BLOWER_UNITSWITCHErrorMessage.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	// CRATING

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[40]")
	WebElement CRATING;

	public void CRATING() {

		wait.until(ExpectedConditions.elementToBeClickable(CRATING)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> CRATINGList;

	public void CRATINGSelection(String model) throws InterruptedException {

		for (int i = 0; i < CRATINGList.size(); i++) {

			String modelText = CRATINGList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = CRATINGList.get(i);

				act.moveToElement(ele).click(ele).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[55]/td[3]")
	WebElement CRATINGListPrice;

	public String getCRATINGListPrice() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(CRATINGListPrice));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select CRATING')]")
	WebElement CRATINGErrorMessage;

	public String getCRATINGErrorMessage() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return CRATINGErrorMessage.getText();

	}

	// --------------------------------------------------------------------------------------------------------------//

	public void callFinalSubmission(String date, String modelva, String doorQuty, String spfValue, String doorWid,
			String doorHeig, String doorloc, String motorLoc, String firstphotocel, String curtainColore,
			String bottomCurtainColore, String sideguideColore, String motorCover, String drumHoodFascia,
			String visionScreen, String windowqty, String incomingpower, String lineloadreacotr, String additionalCable,
			String additionalphotcell, String additionalPhotocellHeight, String extreamPackage, String doornumber)
			throws InterruptedException {

		DateFormateSend(date);
		clickonModel(modelva);
		modelSelection(modelva);
//		doorNumberSendkey(doornumber);
//		doorQuantitySendkey(doorQuty);
//		doorWidthSendkey(doorWid);
//		doorHeightsendkeys(doorHeig);
//		DoorLocation(doorloc);
//		DoorLocationSelection(doorloc);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//		MotorCover(motorCover);
//		MotorCoverselection(motorCover);
//		INCOMING_POWER();
//		INCOMING_POWERSelection(incomingpower);
//		LINE_LOAD_REACTOR();
//		LINE_LOAD_REACTORSelection(lineloadreacotr);

	}

	// EXTREAM PACKAGE

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[24]")
	WebElement EXTREAM_PACKAGE;

	public void EXTREAM_PACKAGE() {

		wait.until(ExpectedConditions.elementToBeClickable(EXTREAM_PACKAGE)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> EXTREAM_PACKAGELIST;

	public void EXTREAM_PACKAGE_SELECTION(String model) throws InterruptedException {

		for (int i = 0; i < EXTREAM_PACKAGELIST.size(); i++) {

			String modelText = EXTREAM_PACKAGELIST.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = EXTREAM_PACKAGELIST.get(i);

				WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(ele));

				act.moveToElement(e1).click(e1).build().perform();
				// Thread.sleep(100);
			}
		}

	}

	@FindBy(xpath = "//table/tbody/tr[25]/td[3]")
	WebElement PRICEEXTREAM_PACKAGE;

	public String GETPRICEEXTREAM_PACKAGE() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(priceEGRESS_CURTAIN));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select EGRESS CURTAIN')]")
	WebElement ERRORMESSAGEPRICEEXTREAM_PACKAGE;

	public String GETERRPRICEEXTREAM_PACKAGE() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageEGRESS_CURTAIN.getText();

	}

//	public void submittFormForFabriCColore(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol) throws InterruptedException {
//
//		DateFormateSend(date);
//		clickonModel(model);
//		modelSelection(model);
//		doorQuantitySendkey(doorQty);
//		doorWidthSendkey(width);
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		bottomcurtainColore(bottomCol);
//
//	}
//
//	public void submittFormForStainlessSteelDrumHood(String date, String model, String doorQty, String width,
//			String height, String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum)
//			throws InterruptedException {
//
//		DateFormateSend(date);
//		clickonModel(model);
//		modelSelection(model);
//		doorQuantitySendkey(doorQty);
//		doorWidthSendkey(width);
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		bottomcurtainColore(bottomCol);
//		bottomcurtainColoreselection(bottomCol);
//
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//	}
//
//	public void call(String date, String model, String doorQty, String width, String height, String motorLoc,
//			String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum, String manualChainHo)
//			throws InterruptedException {
//		DateFormateSend(date);
//		clickonModel(model);
//
//		Thread.sleep(1000);
//		modelSelection(model);
//		doorQuantitySendkey(doorQty);
//		doorWidthSendkey(width);
//	}
//	
//	public void callForFinalSubmission(String date, String model,String doorNumber,String doorQty,String spf, String width, String height, String motorLoc,
//			String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum, String manualChainHo)
//			throws InterruptedException {
//		DateFormateSend(date);
//		clickonModel(model);
//
//		Thread.sleep(1000);
//		modelSelection(model);
//		DoorNumber(doorNumber);
//
//		
//		doorQuantitySendkey(doorQty);
//		spf();
//		spfselection(spf);
//		
//		doorWidthSendkey(width);
//	}
//
//	public void submittFormForManualChainHoist(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//		Thread.sleep(800);
//
//	}
//
//	public void submittFormForEscapeGuide(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		Thread.sleep(800);
//
//	}
//
//	public void submittFormForAdvanceLipped(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		Thread.sleep(500);
//
//	}
//
//	public void submittFormForSlimLine(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//	}
//
//	public void submittVisionAndScreen(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision)
//			throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//
//	}
//
//	public void submittWindowQuantity(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window)
//			throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//	}
//
//	public void submittlogoandWidth(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//	}
//
//	public void submittlogoprintSize(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		logoAndPrintSizeSelection(logoSize);
//	}
//
//	public void submittMechanicalSideHeight(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		mechanicalHeightsendkey(mechanicalHeight);
//	}
//
//	public void submittMechanicalSideWidth(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth)
//			throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//	}
//
//	public void submittMechanicalSideFloor(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor)
//			throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//	}
//
//	public void submittnonMechanicalSideheight(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//	}
//
//	public void submittnonMechanicalSidewidth(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight, String Nonwidth) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//		non_mechanicalWidthsendkey(Nonwidth);
//	}
//
//	public void submittnonMechanicalSideFloor(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight, String Nonwidth, String nonfloor) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		// Actions actions1 = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//		non_mechanicalWidthsendkey(Nonwidth);
//		non_mechanicalFloorSendkey(nonfloor);
//	}
//
//	public void submittnonControlPanel(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight, String Nonwidth, String nonfloor, String controlPanel) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		// Actions actions1 = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//		non_mechanicalWidthsendkey(Nonwidth);
//		non_mechanicalFloorSendkey(nonfloor);
//
//		controlPanel();
//		ControlPanelSelection(controlPanel);
//	}
//
//	public void submitIncommingPower(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower)
//			throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		// Actions actions1 = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//		non_mechanicalWidthsendkey(Nonwidth);
//		non_mechanicalFloorSendkey(nonfloor);
//
//		controlPanel();
//		ControlPanelSelection(controlPanel);
//		incommingPower();
//		incommingPowerSelection(incommingPower);
//
//	}
//
//	public void submitAdditionalCable(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
//			String additionalCable) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		// Actions actions1 = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//		non_mechanicalWidthsendkey(Nonwidth);
//		non_mechanicalFloorSendkey(nonfloor);
//
//		controlPanel();
//		ControlPanelSelection(controlPanel);
//		incommingPower();
//		incommingPowerSelection(incommingPower);
//		additionalCable(additionalCable);
//
//	}
//
//	public void submitLineLoadReactor(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
//			String additionalCable, String lineload) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		// Actions actions1 = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//		non_mechanicalWidthsendkey(Nonwidth);
//		non_mechanicalFloorSendkey(nonfloor);
//
//		controlPanel();
//		ControlPanelSelection(controlPanel);
//		incommingPower();
//		incommingPowerSelection(incommingPower);
//		additionalCable(additionalCable);
//
//		LINELOADReactor();
//		LINELOADReactorselection(lineload);
//
//	}
//
//	public void submitadditionalcell(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
//			String additionalCable, String lineload, String AdditionalPhotoCell) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		// Actions actions1 = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//		non_mechanicalWidthsendkey(Nonwidth);
//		non_mechanicalFloorSendkey(nonfloor);
//
//		controlPanel();
//		ControlPanelSelection(controlPanel);
//		incommingPower();
//		incommingPowerSelection(incommingPower);
//		additionalCable(additionalCable);
//
//		LINELOADReactor();
//		LINELOADReactorselection(lineload);
//		AdditionalPhotoCell();
//		AdditionalPhotoCellSelection(AdditionalPhotoCell);
//
//	}
//
//	public void submitadiitionalCellHeight(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
//			String additionalCable, String lineload, String AdditionalPhotoCell, String adiitionalCellHeight)
//			throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		// Actions actions1 = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//		non_mechanicalWidthsendkey(Nonwidth);
//		non_mechanicalFloorSendkey(nonfloor);
//
//		controlPanel();
//		ControlPanelSelection(controlPanel);
//		incommingPower();
//		incommingPowerSelection(incommingPower);
//		additionalCable(additionalCable);
//
//		LINELOADReactor();
//		LINELOADReactorselection(lineload);
//		AdditionalPhotoCell();
//		AdditionalPhotoCellSelection(AdditionalPhotoCell);
//		AdditionalPhotoCellHeight();
//		AdditionalPhotoCellHeightselection(adiitionalCellHeight);
//
//	}
//
//	
//	public void submit() {
//		
//	}
//	public void submitedgeDynalogix(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
//			String additionalCable, String lineload, String AdditionalPhotoCell, String adiitionalCellHeight,
//			String edgeDynalogix) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		// Actions actions1 = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//		non_mechanicalWidthsendkey(Nonwidth);
//		non_mechanicalFloorSendkey(nonfloor);
//
//		controlPanel();
//		ControlPanelSelection(controlPanel);
//		incommingPower();
//		incommingPowerSelection(incommingPower);
//		additionalCable(additionalCable);
//
//		LINELOADReactor();
//		LINELOADReactorselection(lineload);
//		AdditionalPhotoCell();
//		AdditionalPhotoCellSelection(AdditionalPhotoCell);
//		AdditionalPhotoCellHeight();
//		AdditionalPhotoCellHeightselection(adiitionalCellHeight);
//
//		INTELLIedgeDynalogix();
//
//	//	System.out.println(edgeDynalogix);
//		INTELLIedgeDynalogixselection(edgeDynalogix);
//
//	}
//	public void submitcrating(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
//			String additionalCable, String lineload, String AdditionalPhotoCell, String adiitionalCellHeight,
//			String edgeDynalogix,String crating) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		// Actions actions1 = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//		non_mechanicalWidthsendkey(Nonwidth);
//		non_mechanicalFloorSendkey(nonfloor);
//
//		controlPanel();
//		ControlPanelSelection(controlPanel);
//		incommingPower();
//		incommingPowerSelection(incommingPower);
//		additionalCable(additionalCable);
//
//		LINELOADReactor();
//		LINELOADReactorselection(lineload);
//		AdditionalPhotoCell();
//		AdditionalPhotoCellSelection(AdditionalPhotoCell);
//		AdditionalPhotoCellHeight();
//		AdditionalPhotoCellHeightselection(adiitionalCellHeight);
//
//		INTELLIedgeDynalogix();
//
//	//	System.out.println(edgeDynalogix);
//		INTELLIedgeDynalogixselection(edgeDynalogix);
//		
//		crating();
//		cratingselection(crating);
//
//	}
//	public void submitDoorNumber(String date, String model, String doorQty, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
//			String additionalCable, String lineload, String AdditionalPhotoCell, String adiitionalCellHeight,
//			String edgeDynalogix,String crating,String doorNumber) throws InterruptedException {
//
//		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
//				manualChainHo);
//
//		doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		// Actions actions1 = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//		non_mechanicalWidthsendkey(Nonwidth);
//		non_mechanicalFloorSendkey(nonfloor);
//
//		controlPanel();
//		ControlPanelSelection(controlPanel);
//		incommingPower();
//		incommingPowerSelection(incommingPower);
//		additionalCable(additionalCable);
//
//		LINELOADReactor();
//		LINELOADReactorselection(lineload);
//		AdditionalPhotoCell();
//		AdditionalPhotoCellSelection(AdditionalPhotoCell);
//		AdditionalPhotoCellHeight();
//		AdditionalPhotoCellHeightselection(adiitionalCellHeight);
//
//		INTELLIedgeDynalogix();
//
//	//	System.out.println(edgeDynalogix);
//		INTELLIedgeDynalogixselection(edgeDynalogix);
//		
//		crating();
//		cratingselection(crating);
//		DoorNumber(doorNumber);
//
//	}
//	
//	
//	
//	
//	public void CallFinal(String date,String model,String doorNumber,String doorQuantity,String Spf,String dooropeWidth,
//		String doorHeight) throws InterruptedException {
//		
//		DateFormateSend(date);
//		clickonModel(model);
//		modelSelection(model);
//		
//		Thread.sleep(500);	
//		
//		DoorNumber(doorNumber);
//		doorQuantitySendkey(doorQuantity);
//		spf();
//		spfselection(Spf);
//		doorWidthSendkey(dooropeWidth);
//		doorHeightsendkeys(doorHeight);
//		
//		
//	}
//	
//	public void finalSubmission(String date, String model,String doorNumber, String doorQty,String spf, String width, String height,
//			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
//			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
//			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
//			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
//			String additionalCable, String lineload, String AdditionalPhotoCell, String adiitionalCellHeight,
//			String edgeDynalogix,String crating) throws InterruptedException {
//
//		CallFinal(date, model,doorNumber,doorQty,spf, width, height
//				);
//
//		//doorHeightsendkeys(height);
//		motorLocation(motorLoc);
//		motorLocationselection(motorLoc);
//
//		firstPhtocellHeght();
//		firstPhtocellHeghtselection(firstPhoto);
//		CurtainFabricColore(fabriccol);
//		CurtainFabricColoreselection(fabriccol);
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
//		bottomcurtainColore(bottomCol);
//
//		bottomcurtainColoreselection(bottomCol);
////
//		stainlessSteelDrumBearing();
//		stainlessSteelDrumBearingSelection(stainlessDrum);
//
//		manualChainHoist();
//		manualChainHoistSelection(manualChainHo);
//
//		escapeGuide();
//		escapeGuideselection(escapeGu);
//		advanceDoubleLipped();
//		advanceDoubleLippedselection(advanceLipped);
//		slimlineSidePlates();
//		slimlineSidePlatesselection(Slimline);
//
//		visionandScreen();
//		visionandScreenSelection(vision);
//		windowQuantitysendkey(window);
//
//		LogoAndPrintLocation();
//		LogoAndPrintLocationSelection(logoAndPrint);
//		logoAndPrintSizeLocation();
//		// System.out.println(logoSize);
//		logoAndPrintSizeSelection(logoSize);
//		// Actions actions1 = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform();
//
//		mechanicalHeightsendkey(mechanicalHeight);
//		mechanicalWidthsendkey(MechWidth);
//		mechanicalFloorsendkey(MechFloor);
//
//		non_mechanicalHeightsendkey(NonHeight);
//		non_mechanicalWidthsendkey(Nonwidth);
//		non_mechanicalFloorSendkey(nonfloor);
//
//		controlPanel();
//		ControlPanelSelection(controlPanel);
//		incommingPower();
//		incommingPowerSelection(incommingPower);
//		additionalCable(additionalCable);
//
//		LINELOADReactor();
//		LINELOADReactorselection(lineload);
//		AdditionalPhotoCell();
//		AdditionalPhotoCellSelection(AdditionalPhotoCell);
//		AdditionalPhotoCellHeight();
//		AdditionalPhotoCellHeightselection(adiitionalCellHeight);
//
//		INTELLIedgeDynalogix();
//
//	//	System.out.println(edgeDynalogix);
//		INTELLIedgeDynalogixselection(edgeDynalogix);
//		
//		crating();
//		cratingselection(crating);
//		
//	}
//	
//	

}
