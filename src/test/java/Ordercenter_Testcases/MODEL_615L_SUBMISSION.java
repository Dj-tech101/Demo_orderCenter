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
import AsiPages.test615L;
import XlutilityPackage.DataProviderName;
import log4jfile.logfile;
import orderCenter_BaseClass.Baseclass;
import pages.Dashboard;
import pages.addProductDetails;
import pages.cartPage;
import pages.loginPage;
import pages.orderCenter;
import pages.orderCenterProducts;

public class MODEL_615L_SUBMISSION extends Baseclass {

	public loginPage login;
	public Dashboard dashboard;
	public orderCenter ordercenterPage;
	public orderCenterProducts orderCenterProductspage;
	public addProductDetails add;
	public cartPage cartpage;
	public test615L asi;

	@Test(dataProvider = "615fDetails", retryAnalyzer = RetryAnalysisPackage.RetryOne.class)

	public void validate615lsubmission(String date, String modelva, String doornumber, String doorQuty, String spfValue, String doorWid, String doorHeig, String doorloc, String motorLoc, String incomingpower)
			throws InterruptedException, FileNotFoundException {

		Logger log = logfile.getlogger();

		log.info("test whaterver");
				

		asi = new test615L(driver);
		asi.callFinalSubmission(date, modelva, doornumber, doorQuty, spfValue, doorWid, doorHeig, doorloc, motorLoc, incomingpower);
		;
		String ExpectedPrice = asi.getFinalPriceForm();

//		asi.clickOnSubmitButton();
//		orderCenterProductspage = new orderCenterProducts(driver);
//
//		orderCenterProductspage.clickOnCartButton();
//
//		cartpage = new cartPage(driver);
//
//		String ActualPrice = cartpage.getPriceForAddedProduct();
//
//		Assert.assertEquals(ActualPrice, ExpectedPrice);
//				

	}

	@DataProvider(name = "615fDetails")
	public String[][] data() throws EncryptedDocumentException, IOException {

		String path = "C:\\Users\\webca\\eclipse-workspace\\ordercenterASI\\testData\\test615L.xlsx";

		DataProviderName data = new DataProviderName(path);

		return data.getdataProvider(path);

	}
}
