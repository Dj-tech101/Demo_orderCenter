package Ordercenter_Testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AsiPages.test615;
import AsiPages.test615F;
import XlutilityPackage.DataProviderName;
import log4jfile.logfile;
import orderCenter_BaseClass.Baseclass;
import pages.Dashboard;
import pages.addProductDetails;
import pages.cartPage;
import pages.loginPage;
import pages.orderCenter;
import pages.orderCenterProducts;

public class Submit615FForm extends Baseclass {

	public loginPage login;
	public Dashboard dashboard;
	public orderCenter ordercenterPage;
	public orderCenterProducts orderCenterProductspage;
	public addProductDetails add;
	public cartPage cartpage;
	public test615F asi;

	@Test(dataProvider = "test1", retryAnalyzer = RetryAnalysisPackage.RetryOne.class)

	public void ValidateDoorNumberSubmition123(String date, String modelva, String doorQuty, 
			String spfValue, String doorWid, String doorHeig,
String motorLoc, String firstphotocel, String curtainColore, 
String bottomCurtainColore, String sideguideColore, String motorCover,
String drumHoodFascia, String visionScreen, String windowqty, String incomingpower,
String lineloadreacotr, String additionalCable, String additionalPhotocellHeight,String additionalphotcell)
			throws InterruptedException, FileNotFoundException {

		Logger log = logfile.getlogger();

		log.info("test whaterver");
				

		asi = new test615F(driver);
		asi.callFinalSubmission(date, modelva, doorQuty, spfValue, doorWid, doorHeig, motorLoc, firstphotocel, curtainColore, bottomCurtainColore, sideguideColore, motorCover, drumHoodFascia, visionScreen, windowqty, incomingpower, lineloadreacotr, additionalCable, additionalPhotocellHeight,additionalphotcell);;
		String ExpectedPrice = asi.getFinalPriceForm();

		asi.clickOnSubmitButton();
		orderCenterProductspage = new orderCenterProducts(driver);

		orderCenterProductspage.clickOnCartButton();

		cartpage = new cartPage(driver);

		String ActualPrice = cartpage.getPriceForAddedProduct();

		Assert.assertEquals(ActualPrice, ExpectedPrice);
				

	}

	@DataProvider(name = "test1")
	public String[][] data() throws EncryptedDocumentException, IOException {

		String path = "C:\\Users\\webca\\eclipse-workspace\\ordercenterASI\\testData\\test615F.xlsx";

		DataProviderName data = new DataProviderName(path);

		return data.getdataProvider(path);

	}
}
