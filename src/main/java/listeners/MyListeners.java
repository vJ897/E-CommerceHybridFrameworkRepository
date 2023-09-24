package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentReporter;

public class MyListeners implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Started Project Test's Execution");
		extentReport= ExtentReporter.generateExtendReport();
	}
	@Override
	public void onTestStart(ITestResult result) {
		

		System.out.println(result.getName() + "started executing");
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO,result.getName()+"started executing");
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.log(Status.PASS,result.getName()+"successfully executing");
		System.out.println(result.getName() + "successfully executed");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Screenshot Taken");
		WebDriver driver = null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {

			e.printStackTrace();
		}
		File srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath= System.getProperty("user.dir")+"/screenshots/"+result.getName()+".png";
		try {
			FileHandler.copy(srcScreenShot, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		System.out.println("Screenshot Taken");
		
		extentTest.addScreenCaptureFromPath(screenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName()+"failed");
		
		System.out.println(result.getThrowable());
		System.out.println(result.getName() + "failed");
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println(result.getName() + "skipped");
		System.out.println(result.getThrowable());
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+"skipped");
		
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println( "Execution Finished");
		extentReport.flush();
		File extentReport = new File(System.getProperty("user.dir")+"/test-output/ExtentReport/extentReport.html");
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
