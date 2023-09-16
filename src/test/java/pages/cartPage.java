package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cartPage {
	
	public WebDriver driver;

	public JavascriptExecutor js;
	public Actions act;

	public WebDriverWait wait;

	public cartPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	
	
	@FindBy(xpath = "//table/tbody/tr/td[6]")
WebElement priceofAddedProduct;
	
	
	public String getPriceForAddedProduct() {
		
		
		String text=priceofAddedProduct.getText();
		
		return text;
		
	}

}
