package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="firstname")
	WebElement firstNameField;
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	WebElement firstNameFieldWarning;
	@FindBy(name="lastname")
	WebElement lastNameField;
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	WebElement lastNameFieldWarning;
	@FindBy(name="email")
	WebElement emailField;
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	WebElement emailFieldWarning;
	@FindBy(name="telephone")
	WebElement telephoneField;
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	WebElement telephoneFieldWarning;	
	@FindBy(id="input-password")
	WebElement newPasswordField;
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	WebElement newPasswordFieldWarning;
	@FindBy(id="input-confirm")
	WebElement confirmPasswordField;
	@FindBy(name="agree")
	WebElement agreeField;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement agreeFieldWarning;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueOption;
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	WebElement newsLetterOption;
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);	
	}
	public String getFirstNameWarningText() {
		return firstNameFieldWarning.getText();
	}
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);	
	}
	public String getLastNameWarningText() {
		return lastNameFieldWarning.getText();
	}
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);	
	}
	public String getemailFieldWarningText() {
		return emailFieldWarning.getText();
	}
	public void enterTelephoneNumber(String telephoneNumber) {
		telephoneField.sendKeys(telephoneNumber);	
	}
	public String getTelephoneNumberWarningText() {
		return telephoneFieldWarning.getText();
	}
	public void enterNewPassword(String passwordText) {
		newPasswordField.sendKeys(passwordText);	
	}
	public String getPasswordFieldWarningText() {
		return newPasswordFieldWarning.getText();
	}
	public void confirmNewPassword(String passwordText) {
		confirmPasswordField.sendKeys(passwordText);	
	}
	public void clickAgree() {
		agreeField.click();
	}
	public String getAgreeFieldWarning() {
		return agreeFieldWarning.getText();	
	}
	
	public AccountSuccessPage clickContinue() {
		continueOption.click();
		return new AccountSuccessPage(driver);
	}
	public void clickNewsLetterOption() {
		newsLetterOption.click();
	}
	
	
	
	
	
	
	
	
	

}
