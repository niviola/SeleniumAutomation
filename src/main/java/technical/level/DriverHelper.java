package technical.level;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import junit.framework.Assert;

public class DriverHelper {

	private static DriverHelper singleton;
	private WebDriver driver;

	public static DriverHelper getInstance() {
		if (singleton == null) {
			singleton = new DriverHelper();
			singleton.setDriver();
		}
		return singleton;
	}

	@SuppressWarnings("deprecation")
	private void setDriver() {
		String browserName = PropertyLoader.loadProperty("browser");
		switch (browserName) {
			case "firefox":				
		 		driver = new FirefoxDriver();
			    break;
			
			case "chrome":
				driver = new ChromeDriver();
				break;
					
			case "opera":
				System.setProperty("webdriver.opera.driver", "C:/tools/drivers/operadriver.exe");
				driver = new OperaDriver();
				break;
				
			case "ie":
				System.setProperty("webdriver.ie.driver", "C:/tools/drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
				
			default:
				Assert.fail("unsupported browser " + browserName);
				break;
		}
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
	}

	public WebDriver getDriver() {
		return driver;
	}
}
