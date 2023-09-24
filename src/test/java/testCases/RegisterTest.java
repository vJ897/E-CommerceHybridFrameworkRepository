package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.Utils;

public class RegisterTest extends Base {
	public RegisterTest() {
		super();
	}
	
	public WebDriver driver;
	RegisterPage rp;
	AccountSuccessPage asp;
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(cP.getProperty("browser"));
		HomePage homePage = new HomePage(driver);	
		homePage.clickOnMyAccount();
		rp =homePage.clickOnRegisterOption();
		//driver.findElement(By.linkText("My Account")).click();
		//driver.findElement(By.linkText("Register")).click();		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test (priority = 1)
	public void RegisterNewAccountWithMandatoryFields() {
		//RegisterPage rp = new RegisterPage(driver);
		//AccountSuccessPage asp = new AccountSuccessPage(driver);
		rp.enterFirstName(tdP.getProperty("firstname"));
		rp.enterLastName(tdP.getProperty("lastname"));
		rp.enterEmail(Utils.generateEmailWithTimeStamp());
		rp.enterTelephoneNumber(Utils.generateRandomTelephoneNumber());
		rp.enterNewPassword(tdP.getProperty("password"));
		rp.confirmNewPassword(tdP.getProperty("password"));
		rp.clickAgree();
		asp =rp.clickContinue();
//		driver.findElement(By.name("firstname")).sendKeys("Arya");
//		driver.findElement(By.name("lastname")).sendKeys("Stark");
//		driver.findElement(By.name("email")).sendKeys(Utils.generateEmailWithTimeStamp());
//		driver.findElement(By.name("telephone")).sendKeys(Utils.generateRandomTelephoneNumber());
//		driver.findElement(By.id("input-password")).sendKeys(pp.getProperty("validPassword"));
//		driver.findElement(By.id("input-confirm")).sendKeys(pp.getProperty("validPassword"));
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertTrue(asp.accountPageSuccessStatus(), "Registration Unsuccessful");
// 		Assert.assertTrue(driver.findElement(By.linkText("Success")).isDisplayed(), "Registration Unsuccessful");
		
		
	}
	@Test (priority =2)
	public void RegisterNewAccountWithAllFields() {
		//RegisterPage rp = new RegisterPage(driver);
		//AccountSuccessPage asp = new AccountSuccessPage(driver);
		rp.enterFirstName(tdP.getProperty("firstname"));
		rp.enterLastName(tdP.getProperty("lastname"));
		rp.enterEmail(Utils.generateEmailWithTimeStamp());
		rp.enterTelephoneNumber(Utils.generateRandomTelephoneNumber());
		rp.enterNewPassword(tdP.getProperty("password"));
		rp.confirmNewPassword(tdP.getProperty("password"));
		rp.clickAgree();
		rp.clickNewsLetterOption();
		asp= rp.clickContinue();
		//driver.findElement(By.name("firstname")).sendKeys("Arya");
		//driver.findElement(By.name("lastname")).sendKeys("Stark");
		//driver.findElement(By.name("email")).sendKeys(Utils.generateEmailWithTimeStamp());
		//driver.findElement(By.name("telephone")).sendKeys(Utils.generateRandomTelephoneNumber());
		//driver.findElement(By.id("input-password")).sendKeys("012345");
		//driver.findElement(By.id("input-confirm")).sendKeys("012345");
		//driver.findElement(By.name("agree")).click();
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertTrue(asp.accountPageSuccessStatus(), "Registration Unsuccessful");
		
	}
	@Test (priority =3)
	public void RegisterNewAccountWithoutFillingMandatoryFields() {
		//RegisterPage rp = new RegisterPage(driver);
		
		rp.clickContinue();
		String actualWarning= rp.getAgreeFieldWarning();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//String actualWarning= driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(actualWarning.contains(tdP.getProperty("expectedAgreeFieldWarning")),"No Warning Message");
		String firstNameWarning = rp.getFirstNameWarningText();
		//String firstNameWarning = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertEquals(firstNameWarning,tdP.getProperty("expectedFirstNameFieldWarning"), "No first name warning message");
		//String lastNameWarning = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
		String lastNameWarning = rp.getLastNameWarningText();
		Assert.assertEquals(lastNameWarning,tdP.getProperty("expectedLastNameFieldWarning"), "No last name warning message");		
		//String emailAddressWarning = driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
		String emailAddressWarning = rp.getemailFieldWarningText();
		Assert.assertEquals(emailAddressWarning,tdP.getProperty("expectedEmailFieldWarning"), "No email address warning message");
		//String telephoneNumberWarning = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
		String telephoneNumberWarning = rp.getTelephoneNumberWarningText();
		Assert.assertEquals(telephoneNumberWarning,tdP.getProperty("expectedTelephoneNumberFieldWarning"), "No telephone number warning message");
		//String PasswardWarning = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
		String PasswardWarning = rp.getPasswordFieldWarningText();
		Assert.assertEquals(PasswardWarning,tdP.getProperty("expectedPasswordFieldWarning"), "No telephone number warning message");
		System.out.println(actualWarning);
		System.out.println(lastNameWarning);
		System.out.println(firstNameWarning);
		System.out.println(emailAddressWarning);
		System.out.println(telephoneNumberWarning);
		System.out.println(PasswardWarning);
		
		
		
		
		/*	Assert.assertTrue(driver.findElement(By.linkText("First Name must be between 1 and 32 characters!")).isDisplayed(), "Registration Unsuccessful");
		Assert.assertTrue(driver.findElement(By.linkText("Last Name must be between 1 and 32 characters!")).isDisplayed(), "Registration Unsuccessful");
		Assert.assertTrue(driver.findElement(By.linkText("E-Mail Address does not appear to be valid!")).isDisplayed(), "Registration Unsuccessful");
		Assert.assertTrue(driver.findElement(By.linkText("Telephone must be between 3 and 32 characters!")).isDisplayed(), "Registration Unsuccessful");
		Assert.assertTrue(driver.findElement(By.linkText("Password must be between 4 and 20 characters!")).isDisplayed(), "Registration Unsuccessful");
		*/
	}
	
}
