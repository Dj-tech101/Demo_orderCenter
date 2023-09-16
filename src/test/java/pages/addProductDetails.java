package pages;

import java.awt.Desktop.Action;
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

public class addProductDetails {

	public WebDriver driver;

	public JavascriptExecutor js;
	public Actions act;

	public WebDriverWait wait;

	public addProductDetails(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='MM-DD-YYYY']")
	WebElement dateFormate;

	public void DateFormateSend(String date) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(dateFormate)).sendKeys(date);
	}

	// model

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])")
	WebElement model;

	public void clickonModel() {

		wait.until(ExpectedConditions.visibilityOf(model)).click();

	}

	@FindBy(xpath = "//li[contains(text(),'RC')]")
	List<WebElement> Modellist;

	public void modelSelection(String model) {

		for (int i = 0; i < Modellist.size(); i++) {

			String modelText = Modellist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				wait.until(ExpectedConditions.visibilityOf(Modellist.get(i))).click();

			}
		}
	}

	// DOOR QUANTITY

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement doorQuanntity;

	public void doorQuanntitysendkeys(String doorQty) {

		wait.until(ExpectedConditions.visibilityOf(doorQuanntity)).sendKeys(doorQty);
	}

	// SPF

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[2]")
	WebElement spf;

	public void spfclick() {

		js = (JavascriptExecutor) driver;

		act = new Actions(driver);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(spf));

		act.click(element).build().perform();

		// js.executeScript("arguments[0].click();",element);

	}

	@FindBy(xpath = "//li")
	List<WebElement> spfList;

	public void spfSelection(String value) {

		for (int i = 0; i < spfList.size(); i++) {

			String spfText = spfList.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				WebElement element = wait.until(ExpectedConditions.visibilityOf(spfList.get(i)));
				act.click(element).build().perform();

			}
		}
	}

	// DOOR OPENING WIDTH

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement width;

	public void doorWidthSendKeys(String doorwidth) {

		wait.until(ExpectedConditions.visibilityOf(width)).sendKeys(doorwidth);
	}

	// DOOR OPENING HEIGHT

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement height;

	public void doorHeightSendKeys(String doorHeight) {

		wait.until(ExpectedConditions.visibilityOf(height)).sendKeys(doorHeight);
	}

	// MOTOR LOCATION

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[4]")
	WebElement motorLocation;

	public void motorLocationClick() {

		wait.until(ExpectedConditions.visibilityOf(motorLocation)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> motorlocationlist;

	public void motarLocationSelection(String value) {

		for (int i = 0; i < motorlocationlist.size(); i++) {

			String spfText = motorlocationlist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(motorlocationlist.get(i))).click();
			}
		}
	}

	// FIRST PHOTOCELL HEIGHT

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[5]")
	WebElement firstPhotocellHeight;

	public void firstPhotocellHeightClick() {

		wait.until(ExpectedConditions.visibilityOf(firstPhotocellHeight)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> firstPhotocellHeightlist;

	public void firstPhotocellHeightSelection(String value) {

		for (int i = 0; i < firstPhotocellHeightlist.size(); i++) {

			String spfText = firstPhotocellHeightlist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(firstPhotocellHeightlist.get(i))).click();
			}
		}
	}

	// CURTAIN FABRIC COLOR
	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[6]")
	WebElement CurtainColore;

	public void CurtainColoreclick() {

		wait.until(ExpectedConditions.visibilityOf(CurtainColore)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> CurtainColorelist;

	public void CurtainColoreselection(String value) {

		
		try {
			for (int i = 0; i < CurtainColorelist.size(); i++) {

				String spfText = CurtainColorelist.get(i).getText();

				if (spfText.equalsIgnoreCase(value)) {

					wait.until(ExpectedConditions.visibilityOf(CurtainColorelist.get(i))).click();
				}
			}
		} catch (Exception StaleElementReferenceException) {
			// TODO: handle exception
		}
		
	}

	// BOTTOM BAG CURTAIN COLOR

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[7]")
	WebElement bottomCurtainColore;

	public void bottomCurtainColoreclick() {

		wait.until(ExpectedConditions.visibilityOf(bottomCurtainColore)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> bottomCurtainColorelist;

	public void bottomCurtainColoreselection(String value) {

		for (int i = 0; i < bottomCurtainColorelist.size(); i++) {

			String spfText = bottomCurtainColorelist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(bottomCurtainColorelist.get(i))).click();
			}
		}
	}

	// SIDE GUIDE COVER

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[8]")
	WebElement sideGuideCover;

	public void sideGuideCoverclick() {

		wait.until(ExpectedConditions.visibilityOf(sideGuideCover)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> sideGuideCoverlist;

	public void sideGuideCoverselection(String value) {

		for (int i = 0; i < sideGuideCoverlist.size(); i++) {

			String spfText = sideGuideCoverlist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(sideGuideCoverlist.get(i))).click();
			}
		}
	}

	// SIDE GUIDE COVER COLOR

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[9]")
	WebElement sideGuideCovercolore;

	public void sideGuideCovercoloreclick() {

		wait.until(ExpectedConditions.visibilityOf(sideGuideCovercolore)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> sideGuideCovercolorelist;

	public void sideGuideCovercoloreselection(String value) {

		for (int i = 0; i < sideGuideCovercolorelist.size(); i++) {

			String spfText = sideGuideCovercolorelist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(sideGuideCovercolorelist.get(i))).click();
			}
		}
	}

	// MOTOR COVER

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[10]")
	WebElement motorCover;

	public void motorCoverclick() {

		wait.until(ExpectedConditions.visibilityOf(motorCover)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> motorCoverlist;

	public void motorCoverselection(String value) {

		for (int i = 0; i < motorCoverlist.size(); i++) {

			String spfText = motorCoverlist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(motorCoverlist.get(i))).click();
			}
		}
	}

	// MOTOR COVER COLOR

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[11]")
	WebElement motorCovercolore;

	public void motorCovercoloreclick() {

		wait.until(ExpectedConditions.visibilityOf(motorCovercolore)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> motorCovercolorelist;

	public void motorCovercoloreselection(String value) {

		for (int i = 0; i < motorCovercolorelist.size(); i++) {

			String spfText = motorCovercolorelist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(motorCovercolorelist.get(i))).click();
			}
		}
	}

	// DRUM HOOD/DRUM FASCIA

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[12]")
	WebElement drumFascia;

	public void drumFasciaclick() {

		wait.until(ExpectedConditions.visibilityOf(drumFascia)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> drumFascialist;

	public void drumFasciaSelection(String value) {

		for (int i = 0; i < drumFascialist.size(); i++) {

			String spfText = drumFascialist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(drumFascialist.get(i))).click();
			}
		}
	}

	// DRUM HOOD/DRUM FASCIA COLOR

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[13]")
	WebElement drumFasciacolore;

	public void drumFasciacoloreclick() {

		wait.until(ExpectedConditions.visibilityOf(drumFasciacolore)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> drumFasciacolorelist;

	public void drumFasciacoloreselection(String value) {

		
		try {
			for (int i = 0; i < drumFasciacolorelist.size(); i++) {

				String spfText = drumFasciacolorelist.get(i).getText();

				if (spfText.equalsIgnoreCase(value)) {

					wait.until(ExpectedConditions.visibilityOf(drumFasciacolorelist.get(i))).click();
				}
			}
		} catch (Exception StaleElementReferenceException) {
			// TODO: handle exception
		}
		
	}

	// STAINLESS STEEL INNER & OUTER SIDE GUIDES

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[14]")
	WebElement steelinnerOuterGuide;

	public void steelinnerOuterGuideclick() {

		wait.until(ExpectedConditions.visibilityOf(steelinnerOuterGuide)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> steelinnerOuterGuidelist;

	public void steelinnerOuterGuideselection(String value) {

		for (int i = 0; i < steelinnerOuterGuidelist.size(); i++) {

			String spfText = steelinnerOuterGuidelist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				WebElement element = wait.until(ExpectedConditions.visibilityOf(steelinnerOuterGuidelist.get(i)));

				act.click(element).build().perform();

			}
		}
	}

	// STAINLESS STEEL SHAFT DRUMS & BEARINGS

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[15]")
	WebElement steeldrumBearing;

	public void steeldrumBearingclick() {

		wait.until(ExpectedConditions.visibilityOf(steeldrumBearing)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> steeldrumBearinglist;

	public void steeldrumBearingselection(String value) {

		for (int i = 0; i < steeldrumBearinglist.size(); i++) {

			String spfText = steeldrumBearinglist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(steeldrumBearinglist.get(i))).click();
			}
		}
	}

	// HEAVY IMPACT ZONE BUG SCREEN

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[16]")
	WebElement heavyImpactZone;

	public void heavyImpactZoneclick() {

		wait.until(ExpectedConditions.visibilityOf(heavyImpactZone)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> heavyImpaclisttZonelist;

	public void heavyImpactZoneselection(String value) {

		for (int i = 0; i < heavyImpaclisttZonelist.size(); i++) {

			String spfText = heavyImpaclisttZonelist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(heavyImpaclisttZonelist.get(i))).click();
			}
		}
	}

	// MANUAL CHAIN HOIST

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[17]")
	WebElement manualChainHoist;

	public void manualChainHoistclick() {

		wait.until(ExpectedConditions.visibilityOf(manualChainHoist)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> manualChainHoistlist;

	public void manualChainHoistselection(String value) {

		for (int i = 0; i < manualChainHoistlist.size(); i++) {

			String spfText = manualChainHoistlist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(manualChainHoistlist.get(i))).click();
			}
		}
	}

	// FORE FRAME

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[18]")
	WebElement foreFrame;

	public void foreFrameclick() {

		wait.until(ExpectedConditions.visibilityOf(foreFrame)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> foreFramelist;

	public void foreFrameselection(String value) {

		for (int i = 0; i < foreFramelist.size(); i++) {

			String spfText = foreFramelist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(foreFramelist.get(i))).click();
			}
		}
	}

	// VISION AND SCREEN

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[19]")
	WebElement visionAndScreen;

	public void visionAndScreenclick() {

		wait.until(ExpectedConditions.visibilityOf(visionAndScreen)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> visionAndScreenlist;

	public void visionAndScreenselection(String value) {

		for (int i = 0; i < visionAndScreenlist.size(); i++) {

			String spfText = visionAndScreenlist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(visionAndScreenlist.get(i))).click();
			}
		}
	}

	// WINDOW QUANTITY

	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement WindowQuantity;

	public void WindowQuantitysendkeys(String doorQty) {

		wait.until(ExpectedConditions.visibilityOf(WindowQuantity)).sendKeys(doorQty);
	}

	// LOGO AND PRINT LOCATION

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[20]")
	WebElement logoAndPrintLocation;

	public void logoAndPrintLocationclick() {

		wait.until(ExpectedConditions.visibilityOf(logoAndPrintLocation)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> logoAndPrintLocationlist;

	public void logoAndPrintLocationselection(String value) {

		for (int i = 0; i < logoAndPrintLocationlist.size(); i++) {

			String spfText = logoAndPrintLocationlist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(logoAndPrintLocationlist.get(i))).click();
			}
		}
	}

	// LOGOS AND PRINTS SIZE

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[21]")
	WebElement logoAndPrintSize;

	public void logoAndPrintSizeClick() {

		wait.until(ExpectedConditions.visibilityOf(logoAndPrintSize)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> logoAndPrintSizelist;

	public void logoAndPrintSizeselection(String value) {

		for (int i = 0; i < logoAndPrintSizelist.size(); i++) {

			String spfText = logoAndPrintSizelist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(logoAndPrintSizelist.get(i))).click();
			}
		}
	}

	// MECHANICAL SIDE LOGO HEIGHT (INCHES)

	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement mechanicalHeight;

	public void mechanicalHeightsendkeys(String doorQty) {

		wait.until(ExpectedConditions.visibilityOf(mechanicalHeight)).sendKeys(doorQty);
	}

	// MECHANICAL SIDE LOGO width (INCHES)

	@FindBy(xpath = "(//input[@type='text'])[7]")
	WebElement mechanicalWidth;

	public void mechanicalWidthsendkeys(String doorQty) {

		wait.until(ExpectedConditions.visibilityOf(mechanicalWidth)).sendKeys(doorQty);
	}

	// MECHANICAL SIDE LOGO FROM FLOOR (INCHES)

	@FindBy(xpath = "(//input[@type='text'])[8]")
	WebElement mechanicalfloor;

	public void mechanicalfloorsendkeys(String doorQty) {

		wait.until(ExpectedConditions.visibilityOf(mechanicalfloor)).sendKeys(doorQty);
	}

	// NON-MECHANICAL SIDE LOGO HEIGHT (INCHES)

	@FindBy(xpath = "(//input[@type='text'])[9]")
	WebElement nonmechanicalheight;

	public void nonmechanicalheightsendkeys(String doorQty) {

		wait.until(ExpectedConditions.visibilityOf(nonmechanicalheight)).sendKeys(doorQty);
	}

	// NON-MECHANICAL SIDE LOGO width (INCHES)

	@FindBy(xpath = "(//input[@type='text'])[10]")
	WebElement nonmechanicalWidth;

	public void nonmechanicalWidthsendkeys(String doorQty) {

		wait.until(ExpectedConditions.visibilityOf(nonmechanicalWidth)).sendKeys(doorQty);
	}

	// NON-MECHANICAL SIDE LOGO floor (INCHES)

	@FindBy(xpath = "(//input[@type='text'])[11]")
	WebElement nonmechanicalFloor;

	public void nonmechanicalFloorsendkeys(String doorQty) {

		wait.until(ExpectedConditions.visibilityOf(nonmechanicalFloor)).sendKeys(doorQty);
	}

	// ControlPanel

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[22]")
	WebElement controlPanel;

	public void controlPanelclick() {

		wait.until(ExpectedConditions.visibilityOf(controlPanel)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> controlPanellist;

	public void controlPanelselection(String value) {

		for (int i = 0; i < controlPanellist.size(); i++) {

			String spfText = controlPanellist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(controlPanellist.get(i))).click();
			}
		}
	}

//INCOMING POWER
	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[23]")
	WebElement incomingPower;

	public void incomingPowerclick() {

		wait.until(ExpectedConditions.visibilityOf(incomingPower)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> incomingPowerlist;

	@FindBy(xpath = "//li[contains(text(),'120V/1')]")
	WebElement voltage;

	public void incomingPowerSelection(String value) {

		wait.until(ExpectedConditions.elementToBeClickable(voltage)).click();
		for (int i = 0; i < incomingPowerlist.size(); i++) {

			// String spfText = incomingPowerlist.get(i).getText();

//			

//			if (spfText.equalsIgnoreCase(value)) {
//			
//				System.out.println("ready to click on voltage");
//				WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(incomingPowerlist.get(i)));;
//			
//
//                 ele.click();
//				 
//			
//			}
		}
	}

	// ADDITIONAL CABLES (FEET)

	@FindBy(xpath = "(//input[@type='text'])[12]")
	WebElement additionalCable;

	public void additionalCablesendkeys(String doorQty) {

		wait.until(ExpectedConditions.visibilityOf(additionalCable)).sendKeys(doorQty);
	}

	// LINE LOAD REACTOR

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[24]")
	WebElement lineLoadReactor;

	public void lineLoadReactorclick() {

		wait.until(ExpectedConditions.visibilityOf(lineLoadReactor)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> lineLoadReactorlist;

	public void lineLoadReactorselection(String value) {

		for (int i = 0; i < lineLoadReactorlist.size(); i++) {

			String spfText = lineLoadReactorlist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(lineLoadReactorlist.get(i))).click();
			}
		}
	}

	// CRATING

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[25]")
	WebElement crating;

	public void cratingclick() {

		wait.until(ExpectedConditions.visibilityOf(lineLoadReactor)).click();
	}

	@FindBy(xpath = "//li")
	List<WebElement> cratinglist;

	public void cratingselection(String value) {

		for (int i = 0; i < cratinglist.size(); i++) {

			String spfText = cratinglist.get(i).getText();

			if (spfText.equalsIgnoreCase(value)) {

				wait.until(ExpectedConditions.visibilityOf(cratinglist.get(i))).click();
			}
		}
	}

	// DOORnUMBER
	@FindBy(xpath = "(//input[@type='text'])[13]")
	WebElement Doornumber;

	public void Doornumbersendkeys(String doorQty) {

		wait.until(ExpectedConditions.visibilityOf(Doornumber)).sendKeys(doorQty);
	}

}
