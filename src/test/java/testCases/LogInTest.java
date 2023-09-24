package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Utils;

public class LogInTest extends Base {
	
	public LogInTest() {
		super(); //lead to parent constructor
	}
	
	public WebDriver driver;
	LoginPage lp;
	
	@BeforeMethod
	public void setup() {
		 driver = initializeBrowserAndOpenApplicationURL(cP.getProperty("browser"));
		 HomePage homePage = new HomePage(driver);	
		 homePage.clickOnMyAccount();
		 lp = homePage.clickOnLoginOption();
		// driver.findElement(By.xpath("//span[text()= 'My Account']")).click();
		// driver.findElement(By.xpath("//li/a[text()= 'Login']")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test (priority = 1)
	public void verifyLoinWithValidCradentials() {
		AccountPage ap=lp.login(cP.getProperty("validEmail"), cP.getProperty("validPassword")+"!!!");
		Assert.assertTrue(ap.getDisplayStatusofEditYourAccountInformationOption(), "error");
		//lp.enterEmailAddress(cP.getProperty("validEmail"));
		// driver.findElement(By.id("input-email")).sendKeys(pp.getProperty("validEmail"));
		//lp.enterPassword(cP.getProperty("validPassword"));
		// driver.findElement(By.id("input-password")).sendKeys(pp.getProperty("validPassword"));
		//AccountPage ap = lp.clickLoginButton();
		//driver.findElement(By.xpath("//input[@class= 'btn btn-primary']")).click();
		//Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Edit your account information']")).isDisplayed());
	
		 	
	}
	@Test (priority = 2,dependsOnMethods={"verifyLoinWithValidCradentials"})
	public void verifyLoginWithInvalidCradentials() {
		lp.login(Utils.generateEmailWithTimeStamp(),Utils.generatePasswordWithTimeStamp());
		// lp.enterEmailAddress(Utils.generateEmailWithTimeStamp());
		// driver.findElement(By.id("input-email")).sendKeys(Utils.generateEmailWithTimeStamp());
		// lp.enterPassword(Utils.generatePasswordWithTimeStamp());
		// driver.findElement(By.id("input-password")).sendKeys(Utils.generatePasswordWithTimeStamp());
		 //lp.clickLoginButton();
		// driver.findElement(By.xpath("//input[@class= 'btn btn-primary']")).click();
		 String actualWarningMessage = lp.getInvalidEmailPasswordMessage();
		// String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		// String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password";
		 System.out.print(Utils.generateEmailWithTimeStamp());
		 
		 Assert.assertTrue(actualWarningMessage.contains(tdP.getProperty("expectedWarningMessage")),"Expected waring message is not displayed");

	}
	@Test (priority = 3)
	public void verifyLoginWithInvalidEmailValidPassward() {
		 lp.login(Utils.generateEmailWithTimeStamp(), cP.getProperty("validPassword"));
		 //LoginPage lp = new LoginPage(driver);
		// lp.enterEmailAddress(Utils.generateEmailWithTimeStamp());
		 //lp.enterPassword(cP.getProperty("validPassword"));
		// lp.clickLoginButton();
		 //driver.findElement(By.id("input-email")).sendKeys(Utils.generateEmailWithTimeStamp());
		 //driver.findElement(By.id("input-password")).sendKeys(pp.getProperty("validPassword"));
		 //driver.findElement(By.xpath("//input[@class= 'btn btn-primary']")).click();
		 String actualWarningMessage = lp.getInvalidEmailPasswordMessage();
		 // String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		 //String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password";
		// System.out.print(Utils.generateEmailWithTimeStamp());
		 
		 Assert.assertTrue(actualWarningMessage.contains(tdP.getProperty("expectedWarningMessage")),"Expected waring message is not displayed");
		
	}
	@Test (priority = 4)
	public void verifyLoginWithValidEmailInvalidPassward() {
		 lp.login(cP.getProperty("validEmail"), Utils.generatePasswordWithTimeStamp());
		 //LoginPage lp = new LoginPage(driver);
		// lp.enterEmailAddress(cP.getProperty("validEmail"));
		// lp.enterPassword(Utils.generatePasswordWithTimeStamp());
		// lp.clickLoginButton();
		// driver.findElement(By.id("input-email")).sendKeys(pp.getProperty("validEmail"));
		// driver.findElement(By.id("input-password")).sendKeys(Utils.generatePasswordWithTimeStamp());
		// driver.findElement(By.xpath("//input[@class= 'btn btn-primary']")).click();
		 String actualWarningMessage = lp.getInvalidEmailPasswordMessage();
		 System.out.print(actualWarningMessage);
		 //String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		// String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password";
		// System.out.print(Utils.generateEmailWithTimeStamp()); 
		 Assert.assertTrue(actualWarningMessage.contains(tdP.getProperty("expectedWarningMessage")),"Expected waring message is not displayed");
	}
	@Test (priority = 5)
	public void verifyLoginWithoutCradentials() {
		 lp.login("", "");
		 //LoginPage lp = new LoginPage(driver);
		 //lp.enterEmailAddress("");
		 //lp.enterPassword("");
		 //lp.clickLoginButton();
		 // driver.findElement(By.id("input-email")).sendKeys("");
		 // driver.findElement(By.id("input-password")).sendKeys("");
		 // driver.findElement(By.xpath("//input[@class= 'btn btn-primary']")).click();
		 String actualWarningMessage = lp.getInvalidEmailPasswordMessage();
		 //String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		//  String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password";
		 //System.out.print(Utils.generateEmailWithTimeStamp());
		 
		 Assert.assertTrue(actualWarningMessage.contains(tdP.getProperty("expectedWarningMessage")),"Expected waring message is not displayed");
		
	}
	
	

}
