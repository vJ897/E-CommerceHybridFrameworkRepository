package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement invalidProduct;
	
	public boolean validHPProductStatus() {
		return validHPProduct.isDisplayed();
	}
	public String productIsNotAvailableMessage() {
		return invalidProduct.getText();
	}
	

}
