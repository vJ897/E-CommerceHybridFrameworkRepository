package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReporter {

	public static ExtentReports generateExtendReport() {
		
		Properties cP = new Properties();
		File cPFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		try {
		FileInputStream file = new FileInputStream(cPFile);
		cP.load(file);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"/test-output/ExtentReport/extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Test Results");
		sparkReporter.config().setDocumentTitle("Test Report");
		//sparkReporter.config().setTimeStampFormat("mm/DD/YYYY hh:mm");
		
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Application URL",cP.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", cP.getProperty("browser"));
		extentReport.setSystemInfo("Email", cP.getProperty("validEmail"));
		extentReport.setSystemInfo("Password", cP.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentReport;
		
		
	}
}

