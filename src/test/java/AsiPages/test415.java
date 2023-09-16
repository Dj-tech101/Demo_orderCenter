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

public class test415 {

	public WebDriver driver;

	public JavascriptExecutor js;
	public Actions act;

	public WebDriverWait wait;

	public test415(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

//	locato
//	
//	public void waituntillallelement(Locator l1) {
//		
//		WebDriverWait w1= new WebDriverWait(driver, Duration.ofSeconds(50));
//		
//		w1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(null))
//	}

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

	public void DateFormateSend(String date) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(dateFormate)).sendKeys(date);
	}

	// MODEL

	// @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[1]")

	@FindBy(xpath = "//table/tbody/tr[2]/td[2]/div")
	WebElement model;

	public void clickonModel(String value) throws InterruptedException {

		if (!value.equals("null")) {

			Actions act4 = new Actions(driver);

			Thread.sleep(1000);
			// act4.moveToElement(model).click(model).build().perform();
			WebElement e2 = wait.until(ExpectedConditions
					.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr[2]/td[2]/div"))));

			e2.click();

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

	public void modelSelection(String model) throws InterruptedException {

		WebDriverWait selection = new WebDriverWait(driver, Duration.ofSeconds(25));

		for (int i = 0; i < Modellist.size(); i++) {

			String modelText = Modellist.get(i).getText();
			// Thread.sleep(10);
			if (modelText.equalsIgnoreCase(model)) {

				WebElement e1 = Modellist.get(i);
				// break;

				// selection.until(ExpectedConditions.elementToBeClickable(e1)).click();
				e1.click();
				break;

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

		// Thread.sleep(1500);
		Actions act = new Actions(driver);

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//input[@aria-invalid='false' and @type='text'])[3]")));

		act.sendKeys(element, doorquantity).build().perform();
		// wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
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

	// STAINLESS STEEL SHAFT DRUMS & BEARINGS

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[8]")
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

	@FindBy(xpath = "//table/tbody/tr[13]/td[3]")
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
	// MANUAL CHAIN HOIST

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[9]")
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

	@FindBy(xpath = "//table/tbody/tr[14]/td[3]")
	WebElement pricemanualChainHoist;

	public String getpricemanualChainHoist() throws InterruptedException {

		Thread.sleep(1000);
		WebElement pricetest = wait.until(ExpectedConditions.visibilityOf(pricemanualChainHoist));

		String priceValue = pricetest.getText();

		return priceValue;

	}

	// ESCAPE SIDE GUIDES

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[10]")
	WebElement escapeGuide;

	public void escapeGuide() {

		wait.until(ExpectedConditions.elementToBeClickable(escapeGuide)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> escapeGuidelist;

	public void escapeGuideselection(String model) {

		for (int i = 0; i < escapeGuidelist.size(); i++) {

			String modelText = escapeGuidelist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = escapeGuidelist.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	// PRICE ESCAPE SIDE GUIDES

	@FindBy(xpath = "//table/tbody/tr[15]/td[3]")
	WebElement priceescapeGuide;

	public String getpriceescapeGuide() {

		String priceValue = priceescapeGuide.getText();

		return priceValue;

	}

	// ADVANCED DOUBLE LIPPED

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[11]")
	WebElement advanceDoubleLipped;

	public void advanceDoubleLipped() {

		wait.until(ExpectedConditions.elementToBeClickable(advanceDoubleLipped)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> advanceDoubleLippedlist;

	public void advanceDoubleLippedselection(String model) {

		for (int i = 0; i < advanceDoubleLippedlist.size(); i++) {

			String modelText = advanceDoubleLippedlist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = advanceDoubleLippedlist.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	// PRICE ADVANCED DOUBLE LIPPED

	@FindBy(xpath = "//table/tbody/tr[16]/td[3]")
	WebElement priceadvanceDoubleLipped;

	public String getpriceadvanceDoubleLipped() {

		String priceValue = priceadvanceDoubleLipped.getText();

		return priceValue;

	}

	// ERROR MESSAGE FOR ADVANCE LIPPED
	@FindBy(xpath = "//p[contains(text(),'Please select ADVANCED DOUBLE LIPPED HORIZONTAL PROFILE SEAL')]")
	WebElement ErrorMessageAdvancelipped;

	public String getErrorMessageAdvancelipped() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageAdvancelipped.getText();

	}

	// SLIMLINE SIDE PLATES

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[12]")
	WebElement slimlineSidePlates;

	public void slimlineSidePlates() {

		wait.until(ExpectedConditions.elementToBeClickable(slimlineSidePlates)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> slimlineSidePlateslist;

	public void slimlineSidePlatesselection(String model) {

		for (int i = 0; i < slimlineSidePlateslist.size(); i++) {

			String modelText = slimlineSidePlateslist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = slimlineSidePlateslist.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	// PRICE SLIMLINE SIDE PLATES

	@FindBy(xpath = "//table/tbody/tr[17]/td[3]")
	WebElement priceslimlineSidePlates;

	public String getpriceslimlineSidePlates() {

		String priceValue = priceslimlineSidePlates.getText();

		return priceValue;

	}

	// ERROR MESSAGE SLIMLINE SIDE
	@FindBy(xpath = "//p[contains(text(),'Please select SLIMLINE SIDE PLATES (NO HOLES)')]")
	WebElement ErrorMessageSlimLineSide;

	public String getErrorMessageSlimLineSide() {
		js = (JavascriptExecutor) driver;

//				WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageSlimLineSide.getText();

	}

	// VISION AND SCREEN

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[13]")
	WebElement visionandScreen;

	public void visionandScreen() {

		wait.until(ExpectedConditions.elementToBeClickable(visionandScreen)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> visionandScreenList;

	public void visionandScreenSelection(String model) throws InterruptedException {

		for (int i = 0; i < visionandScreenList.size(); i++) {

			String modelText = visionandScreenList.get(i).getText();

			// System.out.println(modelText);

			// Thread.sleep(500);
			if (modelText.equalsIgnoreCase(model)) {

				visionandScreenList.get(i).click();

				break;

				// act.moveToElement(ele).click(ele).build().perform();
				// ele.click();

			}
		}

	}

	@FindBy(xpath = "//p[contains(text(),'Please select VISION AND SCREEN')]")
	WebElement ErrorVisionAndScreen;

	public String getErrorVisionAndScreen() {
		js = (JavascriptExecutor) driver;

//				WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorVisionAndScreen.getText();

	}

	// PRICE VISION AND SCREEN

	@FindBy(xpath = "//table/tbody/tr[18]/td[3]")
	WebElement PricevisionandScreen;

	public String getPricevisionandScreen() {

		String priceValue = PricevisionandScreen.getText();

		return priceValue;

	}

	// WINDOW QUANTITY

	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement windowQuantity;

	public void windowQuantitysendkey(String date) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(windowQuantity)).sendKeys(date);

		Thread.sleep(400);
	}

	// Error message

	@FindBy(xpath = "//p[contains(text(),'Please enter a value between 1 and 5')]")
	WebElement ErrorWindowQuantity;

	public String getErrorWindowQuantity() {

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).perform();

		js = (JavascriptExecutor) driver;

//				WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,3000)", "");

		return ErrorWindowQuantity.getText();

	}
	// LOGO AND PRINT LOCATION

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[14]")
	WebElement LogoAndPrintLocation;

	public void LogoAndPrintLocation() {

		wait.until(ExpectedConditions.elementToBeClickable(LogoAndPrintLocation)).click();

	}

	// LOGO AND PRINT

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> LogoAndPrintLocationList;

	public void LogoAndPrintLocationSelection(String model) {

		for (int i = 0; i < LogoAndPrintLocationList.size(); i++) {

			String modelText = LogoAndPrintLocationList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = LogoAndPrintLocationList.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	@FindBy(xpath = "//p[contains(text(),'Please select LOGO AND PRINT LOCATION')]")
	WebElement ErrorLogoAndPrintLocation;

	public String getErrorLogoAndPrintLocation() {

		for (int i = 0; i < 2; i++) {

			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_UP).perform();

		}

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ErrorLogoAndPrintLocation));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return ErrorLogoAndPrintLocation.getText();

	}

	// LOGOS AND PRINTS SIZE

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[15]")
	WebElement logoAndPrintSize;

	public void logoAndPrintSizeLocation() {

		wait.until(ExpectedConditions.elementToBeClickable(logoAndPrintSize)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> logoAndPrintSizeList;

	public void logoAndPrintSizeSelection(String model) throws InterruptedException {

		for (int i = 0; i < logoAndPrintSizeList.size(); i++) {

			WebElement element2 = wait.until(ExpectedConditions.visibilityOf(logoAndPrintSizeList.get(i)));

			String modelText = element2.getText();

			// System.out.println(modelText);
			// Thread.sleep(15);
			if (modelText.equalsIgnoreCase(model)) {

				logoAndPrintSizeList.get(i).click();

				// act.moveToElement(element3).click(element3).build().perform();
				// break;

			}
		}

	}

	// PRICE LOGOS AND PRINTS SIZE

	@FindBy(xpath = "//table/tbody/tr[21]/td[3]")
	WebElement pricelogoAndPrintSize;

	public String getpricelogoAndPrintSize() {

		String priceValue = pricelogoAndPrintSize.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select LOGOS AND PRINTS SIZE')]")
	WebElement ErrorLogoAndPrintsize;

	public String getErrorLogoAndPrintsize() {

//		for (int i = 0; i < 3; i++) {
//
//			if (ErrorLogoAndPrintsize.isDisplayed()) {
//				break;
//				
//			}
//			else {
//				
//				Actions actions = new Actions(driver);
//				actions.sendKeys(Keys.PAGE_UP).perform();
//			}
//			
//
//		}

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ErrorLogoAndPrintsize));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return ErrorLogoAndPrintsize.getText();

	}

	// MECHANICAL HEIGHT

	@FindBy(xpath = "(//input[@type='text'])[7]")
	WebElement mechanicalHeight;

	public void mechanicalHeightsendkey(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		// System.out.println("lets padd value as "+value);

//		Actions act=new Actions(driver);
//		
//		act.sendKeys(mechanicalHeight, value);
		mechanicalHeight.sendKeys(value);

	}

	@FindBy(xpath = "(//p[contains(text(),'Please enter a value between 1 and 50')])[1]")
	WebElement ErrorMechanicalSideHeight;

	public String getErrorMechanicalSideHeight() {

//		for (int i = 0; i < 3; i++) {
//
//			if (ErrorLogoAndPrintsize.isDisplayed()) {
//				break;
//				
//			}
//			else {
//				
//				Actions actions = new Actions(driver);
//				actions.sendKeys(Keys.PAGE_UP).perform();
//			}
//			
//
//		}

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ErrorMechanicalSideHeight));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return ErrorMechanicalSideHeight.getText();

	}
	// MECHANICAL width

	@FindBy(xpath = "(//input[@type='text'])[8]")
	WebElement mechanicalWidth;

	public void mechanicalWidthsendkey(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(mechanicalWidth)).sendKeys(value);
	}

	@FindBy(xpath = "(//p[contains(text(),'Please enter a value between 1 and 50')])[2]")
	WebElement ErrorMechanicalSidewidth;

	public String getErrorMechanicalSideWidth() {

//		for (int i = 0; i < 3; i++) {
//
//			if (ErrorLogoAndPrintsize.isDisplayed()) {
//				break;
//				
//			}
//			else {
//				
//				Actions actions = new Actions(driver);
//				actions.sendKeys(Keys.PAGE_UP).perform();
//			}
//			
//
//		}

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ErrorMechanicalSidewidth));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return ErrorMechanicalSidewidth.getText();

	}

	// MECHANICAL FLOOR

	@FindBy(xpath = "(//input[@type='text'])[9]")
	WebElement mechanicalFloor;

	public void mechanicalFloorsendkey(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(mechanicalFloor)).sendKeys(value);
	}

	@FindBy(xpath = "(//p[contains(text(),'Please enter a value between 1 and 50')])[3]")
	WebElement ErrorMechanicalSideFloor;

	public String getErrorMechanicalSideFloor() {

//		for (int i = 0; i < 3; i++) {
//
//			if (ErrorLogoAndPrintsize.isDisplayed()) {
//				break;
//				
//			}
//			else {
//				
//				Actions actions = new Actions(driver);
//				actions.sendKeys(Keys.PAGE_UP).perform();
//			}
//			
//
//		}

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ErrorMechanicalSideFloor));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return ErrorMechanicalSideFloor.getText();

	}

	// NON-MECHANICAL Height

	@FindBy(xpath = "(//input[@type='text'])[10]")
	WebElement non_mechanicalheight;

	public void non_mechanicalHeightsendkey(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(non_mechanicalheight)).sendKeys(value);
	}

	@FindBy(xpath = "(//p[contains(text(),'Please enter a value between 1 and 50')])[4]")
	WebElement ErrorNonMechanicalSideheight;

	public String getErrorNonMechanicalSideheight() {

//		for (int i = 0; i < 3; i++) {
//
//			if (ErrorLogoAndPrintsize.isDisplayed()) {
//				break;
//				
//			}
//			else {
//				
//				Actions actions = new Actions(driver);
//				actions.sendKeys(Keys.PAGE_UP).perform();
//			}
//			
//
//		}

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ErrorNonMechanicalSideheight));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return ErrorNonMechanicalSideheight.getText();

	}

	// NON-MECHANICAL width

	@FindBy(xpath = "(//input[@type='text'])[11]")
	WebElement non_mechanicalHeight;

	public void non_mechanicalWidthsendkey(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(non_mechanicalHeight)).sendKeys(value);
	}

	@FindBy(xpath = "(//p[contains(text(),'Please enter a value between 1 and 50')])[5]")
	WebElement ErrorNonMechanicalSidewidth;

	public String getErrorNonMechanicalSideWidth() {

//		for (int i = 0; i < 3; i++) {
//
//			if (ErrorLogoAndPrintsize.isDisplayed()) {
//				break;
//				
//			}
//			else {
//				
//				Actions actions = new Actions(driver);
//				actions.sendKeys(Keys.PAGE_UP).perform();
//			}
//			
//
//		}

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ErrorNonMechanicalSidewidth));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return ErrorNonMechanicalSidewidth.getText();

	}

// NON-MECHANICAL FLOOR

	@FindBy(xpath = "(//input[@type='text'])[12]")
	WebElement non_mechanicalFloor;

	public void non_mechanicalFloorSendkey(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(non_mechanicalFloor)).sendKeys(value);
	}

	@FindBy(xpath = "(//p[contains(text(),'Please enter a value between 1 and 50')])[6]")
	WebElement ErrorNonMechanicalSidefloor;

	public String getErrorNonMechanicalSidefloor() {

//		for (int i = 0; i < 3; i++) {
//
//			if (ErrorLogoAndPrintsize.isDisplayed()) {
//				break;
//				
//			}
//			else {
//				
//				Actions actions = new Actions(driver);
//				actions.sendKeys(Keys.PAGE_UP).perform();
//			}
//			
//
//		}

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ErrorNonMechanicalSidefloor));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return ErrorNonMechanicalSidefloor.getText();

	}

	// CONTROL PANEL
	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[16]")
	WebElement controlPanel;

	public void controlPanel() {

		wait.until(ExpectedConditions.elementToBeClickable(controlPanel)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> ControlPanelList;

	public void ControlPanelSelection(String model) throws InterruptedException {

		for (int i = 0; i < ControlPanelList.size(); i++) {

			String text = ControlPanelList.get(i).getText();
			if (text.contains(model)) {

				// System.out.println(ControlPanelList.get(i).getText());

				js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", ControlPanelList.get(i));

				break;

			}
		}
	}

	// PRICE LOGOS AND PRINTS SIZE

	@FindBy(xpath = "//table/tbody/tr[28]/td[3]")
	WebElement priceControlPanel;

	public String getpriceControlPanel() {

		String priceValue = priceControlPanel.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select CONTROL PANEL')]")
	WebElement ErrorContrlPanel;

	public String getErrorContrlPanel() {

//		for (int i = 0; i < 3; i++) {
//
//			if (ErrorLogoAndPrintsize.isDisplayed()) {
//				break;
//				
//			}
//			else {
//				
//				Actions actions = new Actions(driver);
//				actions.sendKeys(Keys.PAGE_UP).perform();
//			}
//			
//
//		}

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ErrorContrlPanel));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return ErrorContrlPanel.getText();

	}

	// INCOMMING POWER

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[17]")
	WebElement incommingPower;

	public void incommingPower() {

		wait.until(ExpectedConditions.elementToBeClickable(incommingPower)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> incommingPowerList;

	public void incommingPowerSelection(String model) throws InterruptedException {

		for (int i = 0; i < incommingPowerList.size(); i++) {

			WebElement element2 = wait.until(ExpectedConditions.visibilityOf(incommingPowerList.get(i)));

			String modelText = element2.getText();

			// System.out.println(modelText);
			// Thread.sleep(15);
			if (modelText.equalsIgnoreCase(model)) {

				// System.out.println(model);
				incommingPowerList.get(i).click();
				break;

				// act.moveToElement(element3).click(element3).build().perform();
				// break;

			}
		}

	}

	// PRICE LOGOS AND PRINTS SIZE

	@FindBy(xpath = "//table/tbody/tr[29]/td[3]")
	WebElement incommingPowerprice;

	public String getPriceIncommingPower() {

		String priceValue = incommingPowerprice.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select INCOMING POWER')]")
	WebElement errorincommingPower;

	public String geterrorincommingPower() {

//		for (int i = 0; i < 3; i++) {
//
//			if (ErrorLogoAndPrintsize.isDisplayed()) {
//				break;
//				
//			}
//			else {
//				
//				Actions actions = new Actions(driver);
//				actions.sendKeys(Keys.PAGE_UP).perform();
//			}
//			
//
//		}

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(errorincommingPower));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return errorincommingPower.getText();

	}

	// ADDITIONAL CABLE

	@FindBy(xpath = "(//input[@type='text'])[13]")
	WebElement ADDITIONALCABLE;

	public void additionalCable(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(ADDITIONALCABLE)).sendKeys(value);
	}

	@FindBy(xpath = "(//p[contains(text(),'Please enter ADDITIONAL CABLES (FEET)')])")
	WebElement ErrorAdditionalCable;

	public String getErrorAdditionalCable() {

//		for (int i = 0; i < 3; i++) {
//
//			if (ErrorLogoAndPrintsize.isDisplayed()) {
//				break;
//				
//			}
//			else {
//				
//				Actions actions = new Actions(driver);
//				actions.sendKeys(Keys.PAGE_UP).perform();
//			}
//			
//
//		}

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ErrorAdditionalCable));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return ErrorAdditionalCable.getText();

	}

	// LINE LOAD REACTOR

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[18]")
	WebElement LINELOADReactor;

	public void LINELOADReactor() {

		wait.until(ExpectedConditions.elementToBeClickable(LINELOADReactor)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> LINELOADReactorlist;

	public void LINELOADReactorselection(String model) throws InterruptedException {

		for (int i = 0; i < LINELOADReactorlist.size(); i++) {

			WebElement element2 = wait.until(ExpectedConditions.visibilityOf(LINELOADReactorlist.get(i)));

			String modelText = element2.getText();

			// System.out.println(modelText);
			// Thread.sleep(15);
			if (modelText.equalsIgnoreCase(model)) {

				// System.out.println(model);
				LINELOADReactorlist.get(i).click();
				break;

				// act.moveToElement(element3).click(element3).build().perform();
				// break;

			}
		}

	}

	// PRICE LOGOS AND PRINTS SIZE

	@FindBy(xpath = "//table/tbody/tr[31]/td[3]")
	WebElement LINELOADReactorprice;

	public String getLINELOADReactorprice() {

		String priceValue = LINELOADReactorprice.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select LINE LOAD REACTOR')]")
	WebElement errorLINELOADReactor;

	public String geterrorLINELOADReactor() {

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(errorLINELOADReactor));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return errorLINELOADReactor.getText();

	}
	// Additional PhotoCell

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[19]")
	WebElement AdditionalPhotoCell;

	public void AdditionalPhotoCell() {

		wait.until(ExpectedConditions.elementToBeClickable(AdditionalPhotoCell)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> AdditionalPhotoCelllist;

	public void AdditionalPhotoCellSelection(String model) throws InterruptedException {

		for (int i = 0; i < AdditionalPhotoCelllist.size(); i++) {

			String text = AdditionalPhotoCelllist.get(i).getText();

//				System.out.println("actual "+text);
//				System.out.println("expected "+model );
			if (text.equalsIgnoreCase(model)) {

				// System.out.println(ControlPanelList.get(i).getText());

				js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", AdditionalPhotoCelllist.get(i));

				break;

			}
		}

	}

	// PRICE LOGOS AND PRINTS SIZE

	@FindBy(xpath = "//table/tbody/tr[32]/td[3]")
	WebElement AdditionalPhotoCellprice;

	public String getAdditionalPhotoCelllistprice() {

		String priceValue = AdditionalPhotoCellprice.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select ADDITIONAL PHOTOCELL')]")
	WebElement errorAdditionalPhotoCell;

	public String geterrorAdditionalPhotoCell() {

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(errorAdditionalPhotoCell));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return errorAdditionalPhotoCell.getText();

	}

	// Additional PhotoCell height

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[20]")
	WebElement AdditionalPhotoCellHeight;

	public void AdditionalPhotoCellHeight() {

		wait.until(ExpectedConditions.elementToBeClickable(AdditionalPhotoCellHeight)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> AdditionalPhotoCellHeightlist;

	public void AdditionalPhotoCellHeightselection(String model) throws InterruptedException {

		for (int i = 0; i < AdditionalPhotoCellHeightlist.size(); i++) {

			String text = AdditionalPhotoCellHeightlist.get(i).getText();

//				System.out.println("actual "+text);
//				System.out.println("expected "+model );
			if (text.equalsIgnoreCase(model)) {

				// System.out.println(ControlPanelList.get(i).getText());

				js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", AdditionalPhotoCellHeightlist.get(i));

				break;

			}
		}

	}

	// PRICE LOGOS AND PRINTS SIZE

	@FindBy(xpath = "//table/tbody/tr[33]/td[3]")
	WebElement PriceAdditionalPhotoCellHeight;

	public String getPriceAdditionalPhotoCellHeight() {

		String priceValue = PriceAdditionalPhotoCellHeight.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select ADDITIONAL PHOTOCELL HEIGHT')]")
	WebElement errorAdditionalPhotoCellHeight;

	public String geterrorAdditionalPhotoCellHeight() {

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(errorAdditionalPhotoCellHeight));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return errorAdditionalPhotoCellHeight.getText();

	}

	// INTELLI-EDGE (DYNALOGIX 5)

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[21]")
	WebElement INTELLIedgeDynalogix;

	public void INTELLIedgeDynalogix() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(INTELLIedgeDynalogix)).click();
		// Thread.sleep(500);

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> INTELLIedgeDynalogixlist;

	public void INTELLIedgeDynalogixselection(String model) throws InterruptedException {

		for (int i = 0; i < INTELLIedgeDynalogixlist.size(); i++) {

			String text = INTELLIedgeDynalogixlist.get(i).getText();

//			System.out.println("actual " + text);
//			System.out.println("expected " + model);
			if (text.equalsIgnoreCase(model)) {

				// System.out.println(ControlPanelList.get(i).getText());

				js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", INTELLIedgeDynalogixlist.get(i));

				break;

			}
		}

	}

	// PRICE LOGOS AND PRINTS SIZE

	@FindBy(xpath = "//table/tbody/tr[34]/td[3]")
	WebElement PriceINTELLIedgeDynalogix;

	public String getPriceINTELLIedgeDynalogix() {

		String priceValue = PriceINTELLIedgeDynalogix.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select INTELLI-EDGE (DYNALOGIX 5)')]")
	WebElement ErrorINTELLIedgeDynalogix;

	public String getErrorINTELLIedgeDynalogix() {

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ErrorINTELLIedgeDynalogix));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return ErrorINTELLIedgeDynalogix.getText();

	}

	// CRATING

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[22]")
	WebElement crating;

	public void crating() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(crating)).click();
		// Thread.sleep(500);

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> cratinglist;

	public void cratingselection(String model) throws InterruptedException {

		for (int i = 0; i < cratinglist.size(); i++) {

			String text = cratinglist.get(i).getText();

//			System.out.println("actual " + text);
//			System.out.println("expected " + model);
			if (text.equalsIgnoreCase(model)) {

				// System.out.println(ControlPanelList.get(i).getText());

				js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", cratinglist.get(i));

				break;

			}
		}

	}

	// PRICE LOGOS AND PRINTS SIZE

	@FindBy(xpath = "//table/tbody/tr[35]/td[3]")
	WebElement Pricecrating;

	public String getPricecrating() {

		String priceValue = Pricecrating.getText();

		return priceValue;

	}

	@FindBy(xpath = "//p[contains(text(),'Please select CRATING')]")
	WebElement errorCrating;

	public String geterrorCrating() {

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(errorCrating));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return errorCrating.getText();

	}
	//
	// DOOR NUMBER

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement DoorNumber;

	public void DoorNumber(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(DoorNumber)).sendKeys(value);
	}

	@FindBy(xpath = "(//p[contains(text(),'Please enter DOOR NUMBER ###')])")
	WebElement errorDoorNumber;

	public String geterrorDoorNumber() {

//		for (int i = 0; i < 3; i++) {
//
//			if (ErrorLogoAndPrintsize.isDisplayed()) {
//				break;
//				
//			}
//			else {
//				
//				Actions actions = new Actions(driver);
//				actions.sendKeys(Keys.PAGE_UP).perform();
//			}
//			
//
//		}

		js = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.visibilityOf(errorDoorNumber));
		;

		// js.executeScript("window.scrollBy(0,3000)", "");

		return errorDoorNumber.getText();

	}

	public void submittFormForFabriCColore(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol) throws InterruptedException {

		DateFormateSend(date);
		clickonModel(model);
		modelSelection(model);
		doorQuantitySendkey(doorQty);
		doorWidthSendkey(width);
		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);
		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		bottomcurtainColore(bottomCol);

	}

	public void submittFormForStainlessSteelDrumHood(String date, String model, String doorQty, String width,
			String height, String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum)
			throws InterruptedException {

		DateFormateSend(date);
		clickonModel(model);
		modelSelection(model);
		doorQuantitySendkey(doorQty);
		doorWidthSendkey(width);
		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);
		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		bottomcurtainColore(bottomCol);
		bottomcurtainColoreselection(bottomCol);

		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

	}

	public void call(String date, String model, String doorQty, String width, String height, String motorLoc,
			String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum, String manualChainHo)
			throws InterruptedException {
		DateFormateSend(date);
		clickonModel(model);

		Thread.sleep(1000);
		modelSelection(model);
		doorQuantitySendkey(doorQty);
		doorWidthSendkey(width);
	}

	public void callForFinalSubmission(String date, String model, String doorNumber, String doorQty, String spf,
			String width, String height, String motorLoc, String firstPhoto, String fabriccol, String bottomCol,
			String stainlessDrum, String manualChainHo) throws InterruptedException {
		DateFormateSend(date);
		clickonModel(model);

		Thread.sleep(1000);
		modelSelection(model);
		DoorNumber(doorNumber);

		doorQuantitySendkey(doorQty);
		spf();
		spfselection(spf);

		doorWidthSendkey(width);
	}

	public void submittFormForManualChainHoist(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);
		Thread.sleep(800);

	}

	public void submittFormForEscapeGuide(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		Thread.sleep(800);

	}

	public void submittFormForAdvanceLipped(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		Thread.sleep(500);

	}

	public void submittFormForSlimLine(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

	}

	public void submittVisionAndScreen(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision)
			throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);

	}

	public void submittWindowQuantity(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window)
			throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

	}

	public void submittlogoandWidth(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
	}

	public void submittlogoprintSize(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		logoAndPrintSizeSelection(logoSize);
	}

	public void submittMechanicalSideHeight(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		mechanicalHeightsendkey(mechanicalHeight);
	}

	public void submittMechanicalSideWidth(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth)
			throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
	}

	public void submittMechanicalSideFloor(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor)
			throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);
	}

	public void submittnonMechanicalSideheight(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
			String NonHeight) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
	}

	public void submittnonMechanicalSidewidth(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
			String NonHeight, String Nonwidth) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
		non_mechanicalWidthsendkey(Nonwidth);
	}

	public void submittnonMechanicalSideFloor(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
			String NonHeight, String Nonwidth, String nonfloor) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		// Actions actions1 = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
		non_mechanicalWidthsendkey(Nonwidth);
		non_mechanicalFloorSendkey(nonfloor);
	}

	public void submittnonControlPanel(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
			String NonHeight, String Nonwidth, String nonfloor, String controlPanel) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		// Actions actions1 = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
		non_mechanicalWidthsendkey(Nonwidth);
		non_mechanicalFloorSendkey(nonfloor);

		controlPanel();
		ControlPanelSelection(controlPanel);
	}

	public void submitIncommingPower(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower)
			throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		// Actions actions1 = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
		non_mechanicalWidthsendkey(Nonwidth);
		non_mechanicalFloorSendkey(nonfloor);

		controlPanel();
		ControlPanelSelection(controlPanel);
		incommingPower();
		incommingPowerSelection(incommingPower);

	}

	public void submitAdditionalCable(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
			String additionalCable) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		// Actions actions1 = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
		non_mechanicalWidthsendkey(Nonwidth);
		non_mechanicalFloorSendkey(nonfloor);

		controlPanel();
		ControlPanelSelection(controlPanel);
		incommingPower();
		incommingPowerSelection(incommingPower);
		additionalCable(additionalCable);

	}

	public void submitLineLoadReactor(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
			String additionalCable, String lineload) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		// Actions actions1 = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
		non_mechanicalWidthsendkey(Nonwidth);
		non_mechanicalFloorSendkey(nonfloor);

		controlPanel();
		ControlPanelSelection(controlPanel);
		incommingPower();
		incommingPowerSelection(incommingPower);
		additionalCable(additionalCable);

		LINELOADReactor();
		LINELOADReactorselection(lineload);

	}

	public void submitadditionalcell(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
			String additionalCable, String lineload, String AdditionalPhotoCell) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		// Actions actions1 = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
		non_mechanicalWidthsendkey(Nonwidth);
		non_mechanicalFloorSendkey(nonfloor);

		controlPanel();
		ControlPanelSelection(controlPanel);
		incommingPower();
		incommingPowerSelection(incommingPower);
		additionalCable(additionalCable);

		LINELOADReactor();
		LINELOADReactorselection(lineload);
		AdditionalPhotoCell();
		AdditionalPhotoCellSelection(AdditionalPhotoCell);

	}

	public void submitadiitionalCellHeight(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
			String additionalCable, String lineload, String AdditionalPhotoCell, String adiitionalCellHeight)
			throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		// Actions actions1 = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
		non_mechanicalWidthsendkey(Nonwidth);
		non_mechanicalFloorSendkey(nonfloor);

		controlPanel();
		ControlPanelSelection(controlPanel);
		incommingPower();
		incommingPowerSelection(incommingPower);
		additionalCable(additionalCable);

		LINELOADReactor();
		LINELOADReactorselection(lineload);
		AdditionalPhotoCell();
		AdditionalPhotoCellSelection(AdditionalPhotoCell);
		AdditionalPhotoCellHeight();
		AdditionalPhotoCellHeightselection(adiitionalCellHeight);

	}

	public void submit() {

	}

	public void submitedgeDynalogix(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
			String additionalCable, String lineload, String AdditionalPhotoCell, String adiitionalCellHeight,
			String edgeDynalogix) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		// Actions actions1 = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
		non_mechanicalWidthsendkey(Nonwidth);
		non_mechanicalFloorSendkey(nonfloor);

		controlPanel();
		ControlPanelSelection(controlPanel);
		incommingPower();
		incommingPowerSelection(incommingPower);
		additionalCable(additionalCable);

		LINELOADReactor();
		LINELOADReactorselection(lineload);
		AdditionalPhotoCell();
		AdditionalPhotoCellSelection(AdditionalPhotoCell);
		AdditionalPhotoCellHeight();
		AdditionalPhotoCellHeightselection(adiitionalCellHeight);

		INTELLIedgeDynalogix();

		// System.out.println(edgeDynalogix);
		INTELLIedgeDynalogixselection(edgeDynalogix);

	}

	public void submitcrating(String date, String model, String doorQty, String width, String height, String motorLoc,
			String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum, String manualChainHo,
			String escapeGu, String advanceLipped, String Slimline, String vision, String window, String logoAndPrint,
			String logoSize, String mechanicalHeight, String MechWidth, String MechFloor, String NonHeight,
			String Nonwidth, String nonfloor, String controlPanel, String incommingPower, String additionalCable,
			String lineload, String AdditionalPhotoCell, String adiitionalCellHeight, String edgeDynalogix,
			String crating) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		// Actions actions1 = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
		non_mechanicalWidthsendkey(Nonwidth);
		non_mechanicalFloorSendkey(nonfloor);

		controlPanel();
		ControlPanelSelection(controlPanel);
		incommingPower();
		incommingPowerSelection(incommingPower);
		additionalCable(additionalCable);

		LINELOADReactor();
		LINELOADReactorselection(lineload);
		AdditionalPhotoCell();
		AdditionalPhotoCellSelection(AdditionalPhotoCell);
		AdditionalPhotoCellHeight();
		AdditionalPhotoCellHeightselection(adiitionalCellHeight);

		INTELLIedgeDynalogix();

		// System.out.println(edgeDynalogix);
		INTELLIedgeDynalogixselection(edgeDynalogix);

		crating();
		cratingselection(crating);

	}

	public void submitDoorNumber(String date, String model, String doorQty, String width, String height,
			String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
			String additionalCable, String lineload, String AdditionalPhotoCell, String adiitionalCellHeight,
			String edgeDynalogix, String crating, String doorNumber) throws InterruptedException {

		call(date, model, doorQty, width, height, motorLoc, firstPhoto, fabriccol, bottomCol, stainlessDrum,
				manualChainHo);

		doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		// Actions actions1 = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
		non_mechanicalWidthsendkey(Nonwidth);
		non_mechanicalFloorSendkey(nonfloor);

		controlPanel();
		ControlPanelSelection(controlPanel);
		incommingPower();
		incommingPowerSelection(incommingPower);
		additionalCable(additionalCable);

		LINELOADReactor();
		LINELOADReactorselection(lineload);
		AdditionalPhotoCell();
		AdditionalPhotoCellSelection(AdditionalPhotoCell);
		AdditionalPhotoCellHeight();
		AdditionalPhotoCellHeightselection(adiitionalCellHeight);

		INTELLIedgeDynalogix();

		// System.out.println(edgeDynalogix);
		INTELLIedgeDynalogixselection(edgeDynalogix);

		crating();
		cratingselection(crating);
		DoorNumber(doorNumber);

	}

	public void CallFinal(String date, String model, String doorNumber, String doorQuantity, String Spf,
			String dooropeWidth, String doorHeight) throws InterruptedException {

		DateFormateSend(date);
		clickonModel(model);
		modelSelection(model);

		Thread.sleep(500);

		DoorNumber(doorNumber);
		doorQuantitySendkey(doorQuantity);
		spf();
		spfselection(Spf);
		doorWidthSendkey(dooropeWidth);
		doorHeightsendkeys(doorHeight);

	}

	public void finalSubmission(String date, String model, String doorNumber, String doorQty, String spf, String width,
			String height, String motorLoc, String firstPhoto, String fabriccol, String bottomCol, String stainlessDrum,
			String manualChainHo, String escapeGu, String advanceLipped, String Slimline, String vision, String window,
			String logoAndPrint, String logoSize, String mechanicalHeight, String MechWidth, String MechFloor,
			String NonHeight, String Nonwidth, String nonfloor, String controlPanel, String incommingPower,
			String additionalCable, String lineload, String AdditionalPhotoCell, String adiitionalCellHeight,
			String edgeDynalogix, String crating) throws InterruptedException {

		CallFinal(date, model, doorNumber, doorQty, spf, width, height);

		// doorHeightsendkeys(height);
		motorLocation(motorLoc);
		motorLocationselection(motorLoc);

		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstPhoto);
		CurtainFabricColore(fabriccol);
		CurtainFabricColoreselection(fabriccol);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		bottomcurtainColore(bottomCol);

		bottomcurtainColoreselection(bottomCol);
//
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessDrum);

		manualChainHoist();
		manualChainHoistSelection(manualChainHo);

		escapeGuide();
		escapeGuideselection(escapeGu);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);
		slimlineSidePlates();
		slimlineSidePlatesselection(Slimline);

		visionandScreen();
		visionandScreenSelection(vision);
		windowQuantitysendkey(window);

		LogoAndPrintLocation();
		LogoAndPrintLocationSelection(logoAndPrint);
		logoAndPrintSizeLocation();
		// System.out.println(logoSize);
		logoAndPrintSizeSelection(logoSize);
		// Actions actions1 = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		mechanicalHeightsendkey(mechanicalHeight);
		mechanicalWidthsendkey(MechWidth);
		mechanicalFloorsendkey(MechFloor);

		non_mechanicalHeightsendkey(NonHeight);
		non_mechanicalWidthsendkey(Nonwidth);
		non_mechanicalFloorSendkey(nonfloor);

		controlPanel();
		ControlPanelSelection(controlPanel);
		incommingPower();
		incommingPowerSelection(incommingPower);
		additionalCable(additionalCable);

		LINELOADReactor();
		LINELOADReactorselection(lineload);
		AdditionalPhotoCell();
		AdditionalPhotoCellSelection(AdditionalPhotoCell);
		AdditionalPhotoCellHeight();
		AdditionalPhotoCellHeightselection(adiitionalCellHeight);

		INTELLIedgeDynalogix();

		// System.out.println(edgeDynalogix);
		INTELLIedgeDynalogixselection(edgeDynalogix);

		crating();
		cratingselection(crating);

	}

	public void updateTesting(String date, String modelvalue, String doorQua, String spfvalue, String doorWid, String doorhi, String motorloc, String firstcellHeiight, String curtainFabr, String bottambag, String stainlessSteel, String manualChainhoist, String escapGuidesele, String advanceLipped, String visionAndLinne, String controlPanelselection, String incommingPow, String additionalc, String additional, String additionalphoto, String cratingsele) throws InterruptedException {

		DateFormateSend(date);
		clickonModel(modelvalue);
		modelSelection(modelvalue);
		doorQuantitySendkey(doorQua);
		spf();
		spfselection(spfvalue);
		doorWidthSendkey(doorWid);
		doorHeightsendkeys(doorhi);

		motorLocation(motorloc);
		motorLocationselection(motorloc);
		firstPhtocellHeght();
		firstPhtocellHeghtselection(firstcellHeiight);
		CurtainFabricColore(curtainFabr);
		CurtainFabricColoreselection(curtainFabr);
		bottomcurtainColore(bottambag);
		bottomcurtainColoreselection(bottambag);
		stainlessSteelDrumBearing();
		stainlessSteelDrumBearingSelection(stainlessSteel);
		manualChainHoist();
		manualChainHoistSelection(manualChainhoist);
		escapeGuide();
		escapeGuideselection(escapGuidesele);
		advanceDoubleLipped();
		advanceDoubleLippedselection(advanceLipped);

		visionandScreen();
		visionandScreenSelection(visionAndLinne);
		controlPanel();
		ControlPanelSelection(controlPanelselection);
		incommingPower();
		incommingPowerSelection(incommingPow);
		additionalCable(additionalc);
		AdditionalPhotoCell();
		AdditionalPhotoCellSelection(additional);
		AdditionalPhotoCellHeight();
		AdditionalPhotoCellHeightselection(additionalphoto);
		crating();
		cratingselection(cratingsele);

	}

}
