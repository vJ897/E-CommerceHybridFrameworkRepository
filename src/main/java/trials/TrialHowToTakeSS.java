package trials;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TrialHowToTakeSS {

	public static void main(String[] args) {
	
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.version"));
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.bing.com/search?form=NTPCHB&q=Bing+AI&showconv=1");
		File srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath= System.getProperty("user.dir")+"/screenshots/bing.png";
		try {
			FileHandler.copy(srcScreenShot, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
