package Drivers;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public WebDriver initializeWebdriver(String browser)throws  Exception {
		if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);

		}
		else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		else {
			throw new RuntimeException("BrowserType Not Supported");

		}
		
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		      //Setting implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				driver.manage().window().maximize();
				
				//Setting WebDriverWait with max timeout value of 20 seconds
				wait =new WebDriverWait(driver,Duration.ofSeconds(20));
				return driver;

		
	}
	public static WebDriver getDriver() {
		return driver;
	}

	public static void closeallDriver() {
		//driver.close();
	}

	
}


