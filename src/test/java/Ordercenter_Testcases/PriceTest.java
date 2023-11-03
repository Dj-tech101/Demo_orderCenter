package Ordercenter_Testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AsiPages.test415;
import XlutilityPackage.DataProviderName;
import orderCenter_BaseClass.Baseclass;

public class PriceTest extends Baseclass {

	public test415 asi415;

	public  String dollar = "$";

	@Test(dataProvider = "pricetest",retryAnalyzer = RetryAnalysisPackage.RetryOne.class)
	public void validate(String value,String width,String height) throws InterruptedException {
		
		asi415 = new test415(driver);

		asi415.DateFormateSend("11-10-2023");

		try {
			asi415.clickonModel("415");
			asi415.modelSelection("415");
			asi415.DoorNumber("ass4156");
			asi415.doorWidthSendkey(width);
			asi415.doorHeightsendkeys(height);
			String actual_productPrice = asi415.getProductPrice();
			String Expected_ProductPrice =   value+".00";
			Assert.assertEquals(actual_productPrice, Expected_ProductPrice);
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
	}

	@DataProvider(name = "pricetest")
	public String[][] data() throws EncryptedDocumentException, IOException {

		String path = "C:\\Users\\webca\\eclipse-workspace\\ordercenterASI\\testData\\Book3.xlsx";

		DataProviderName data = new DataProviderName(path);

		return data.getdataProvider(path);

	}
}
