package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public Properties prop;
	public static WebDriver driver;
	
	public WebDriver initialiseDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\data.properties");
		
		prop.load(fileInput);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if(browserName.equals("FireFox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.23.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		} else {
			
			System.out.println("Internet Expolrer driver is not initialised");
		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String getScreenshot(WebDriver driver, String screenshotname) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotname + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		
		return destination;
	}
	
	public WebDriver getDriver() {
		
		return driver;
	}

}
