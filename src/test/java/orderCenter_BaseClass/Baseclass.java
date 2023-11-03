package orderCenter_BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import XlutilityPackage.propertyFile;
import io.cucumber.messages.types.Duration;
import pages.Dashboard;
import pages.loginPage;
import pages.orderCenter;
import pages.orderCenterProducts;

public class Baseclass {

	public WebDriver driver;
	public WebDriverWait wait;
	public loginPage login;
	public Dashboard dashboard;
	public orderCenter ordercenterPage;
	public orderCenterProducts orderCenterProductspage;

	public propertyFile pro;

	@SuppressWarnings("unused")
	@BeforeMethod
	public void lounchingBrowser() throws InterruptedException, IOException {

		pro = new propertyFile();

		String Browser = pro.getBrowser();

		System.out.println(Browser);

		if (true) {

			System.out.println("lounching chrome browser");

			driver = new ChromeDriver();

			// driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));

			driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(30));

			driver.manage().deleteAllCookies();

			driver.get(pro.getUrl());

			login = new loginPage(driver);

			login.usernameSendKeys(pro.getUsername());

			login.clickonTabKey(pro.getPassoword());
			login.clickonSubmitButton();

			dashboard = new Dashboard(driver);

			dashboard.clcikOnOrdercenterButton();

			ordercenterPage = new orderCenter(driver);

			ordercenterPage.ClickonEditBurton();
			orderCenterProductspage = new orderCenterProducts(driver);

			orderCenterProductspage.clickOnAsiButton();
			// orderCenterProductspage.clickOnRaynorbutton();

		}

		else if (Browser.equals("Firefox")) {

			driver = new FirefoxDriver();

			// driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			driver.get(pro.getUrl());

			login = new loginPage(driver);

			login.usernameSendKeys(pro.getUsername());

			login.clickonTabKey(pro.getPassoword());
			login.clickonSubmitButton();

			dashboard = new Dashboard(driver);

			dashboard.clcikOnOrdercenterButton();

			ordercenterPage = new orderCenter(driver);

			ordercenterPage.ClickonEditBurton();
			orderCenterProductspage = new orderCenterProducts(driver);

			orderCenterProductspage.clickOnAsiButton();

		} else {
			System.out.println("-----------please provide the browser Details----------");
		}
	}

	@AfterMethod

	public void tearDown() {

		driver.close();

	}
}
