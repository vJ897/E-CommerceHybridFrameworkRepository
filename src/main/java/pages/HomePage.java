package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()= 'My Account']")
	private WebElement myAccountDropMenu;	
	@FindBy(xpath="//li/a[text()= 'Login']")
	private WebElement loginOption;
	@FindBy(linkText="Register")
	private WebElement registerOption;
	@FindBy(name="search")
	private WebElement searchOption;
	@FindBy(xpath="(//i[@class='fa fa-search'])[1]")
	private WebElement search;
	
	
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	public LoginPage clickOnLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	public RegisterPage clickOnRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	public SearchPage clickOnSearchButton() {
		search.click();
		return new SearchPage(driver);
	}
	public void enterValidSearchOption() {
		searchOption.sendKeys("HP");
	}
	public void enterInValidSearchOption() {
		searchOption.sendKeys("Realme");
	}
	public void enterWithoutSearchOption() {
		searchOption.sendKeys("");
	}


}
