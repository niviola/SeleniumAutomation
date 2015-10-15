package technical.level;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
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
			setupFirefox();
			    break;
			
			case "chrome":
				driver = new ChromeDriver();
				break;
					
			case "opera":
			setupOpera();
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

	private void setupFirefox() {
		//Download setting browser.download.manager.closeWhenDone   application/vnd.ms-excel, x-application/octet-stream
		
		
		FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderlist", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.manager.closeWhenDone", true);
        
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        //profile.setPreference("browser.helperapps.neverAsk.saveToDisk","text/csv");
        
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
        profile.setPreference("browser.download.manager.focusWhenStarting", false);  
        profile.setPreference("browser.download.useDownloadDir", true);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
        profile.setPreference("pdfjs.disabled", true);
        
        
        profile.setPreference("browser.download.dir", PropertyLoader.loadProperty("downloadDirectory"));
        driver = new FirefoxDriver(profile);
	}

	private void setupOpera() {
		System.setProperty("webdriver.opera.driver", "C:/tools/drivers/operadriver.exe");
		driver = new OperaDriver();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
