package technical.level;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
	
	private void setDriver() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
