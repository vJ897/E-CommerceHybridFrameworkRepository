package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.SearchPage;

public class SearchTest extends Base {
	
	public SearchTest() {
		super();
	}

	public WebDriver driver;
	SearchPage sp;
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(cP.getProperty("browser"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test (priority = 1)
	public void verifySearchWithValidProduct() {
		HomePage hp= new HomePage(driver);
		//SearchPage sp= new SearchPage(driver);
		hp.enterValidSearchOption();
		sp= hp.clickOnSearchButton();
		//driver.findElement(By.name("search")).sendKeys("HP");	
		//driver.findElement(By.xpath("(//i[@class='fa fa-search'])[1]")).click();
		//String message= driver.findElement(By.linkText("HP LP3065")).getText();
		//System.out.println(message);
		Assert.assertTrue(sp.validHPProductStatus());
		
	}
	@Test (priority = 2)
	public void verifySearchWithInValidProduct() {
		HomePage hp= new HomePage(driver);
		//SearchPage sp= new SearchPage(driver);
		hp.enterInValidSearchOption();
		sp=hp.clickOnSearchButton();
		//driver.findElement(By.name("search")).sendKeys("realme");	
		//driver.findElement(By.xpath("(//i[@class='fa fa-search'])[1]")).click();
		//String message= driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
		//System.out.println(message);
		Assert.assertTrue(sp.productIsNotAvailableMessage().contains(tdP.getProperty("expectedProductIsNotAvailableMessage")));
		
	}
	@Test (priority = 3)
	public void verifySearchWithoutAnyProduct() {
		HomePage hp= new HomePage(driver);
		//SearchPage sp= new SearchPage(driver);
		hp.enterWithoutSearchOption();
		sp= hp.clickOnSearchButton();
		//driver.findElement(By.name("search")).sendKeys("");	
		//driver.findElement(By.xpath("(//i[@class='fa fa-search'])[1]")).click();
		//String message= driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
		//System.out.println(message);
		//Assert.assertTrue(message.contains("There is no product that matches the search criteria"));
		Assert.assertTrue(sp.productIsNotAvailableMessage().contains(tdP.getProperty("expectedProductIsNotAvailableMessage")));
		
	}
	
}
