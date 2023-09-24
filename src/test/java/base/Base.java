package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.Utils;

public class Base {
	
	WebDriver driver;
	public Properties cP;
	public Properties tdP;
	
	public Base() {
		cP = new Properties();
		File cPFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		try {
		FileInputStream file = new FileInputStream(cPFile);
		cP.load(file);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		tdP = new Properties();
		File tdPFile = new File(System.getProperty("user.dir")+"/src/main/java/testData/testdata.properties");
		try {
		FileInputStream file = new FileInputStream(tdPFile);
		tdP.load(file);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
		
		 switch (browserName.toLowerCase()) {
         case "chrome":
             driver = new ChromeDriver();
             break;
         case "edge":
             driver = new EdgeDriver();
             break;
         case "firefox":
             driver = new FirefoxDriver();
             break;
         case "safari":
             driver = new SafariDriver();
             break;
         default:
             throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
		
		driver.get(cP.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGE_LOAD_TIME));
		
		return driver;
		
	}
	

}
