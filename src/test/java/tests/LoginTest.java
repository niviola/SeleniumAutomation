package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import business.logic.ApplicationLogic;
import model.User;
import ru.yandex.qatools.allure.annotations.Step;
import technical.level.GenericMethods;

public class LoginTest extends GenericMethods {
	
	static ApplicationLogic app = new ApplicationLogic();
	User usr = new User();
	//static TestBase tb;
	
	@BeforeClass
	public static void beforeLoginTests() throws Exception {
		app.start();
	}
	
	@Test
	public void testInvalidCredentials() throws Exception {
		log.info("<- LoginTest.testInvalidCredentials");
		usr.login = "admin123";
		usr.password = "admin123";
		enterCredentials();
		checkTextAfterInvalidLogin();
		log.info("->");
	} 
	
	@Test
	public void testBlankCredentials() throws Exception {
		log.info("<- LoginTest.testBlankCredentials");
		usr.login = "";
		usr.password = "";
		enterCredentials();
		checkTextAfterBlankLogin();
		System.out.println("->");
	}
	
	@Step
	private void enterCredentials() {
		type(By.cssSelector("#LoginForm_username"), usr.login);
		type(By.cssSelector("#LoginForm_password"), usr.password);
		click(By.cssSelector("a.button"));
	}
	
	private void checkTextAfterBlankLogin() {
		log.debug("<--- LoginTest.checkTextAfterInvalidLogin");
		assertThat(getElementText(By.cssSelector("small.error:first-of-type")), containsString("Username cannot be blank."));
		assertThat(getElementText(By.cssSelector("small.error:last-of-type")), containsString("Password cannot be blank."));
		log.debug("--->");
	}
	
	@Step
	private void checkTextAfterInvalidLogin() {
		log.debug("<--- LoginTest.checkTextAfterInvalidLogin");
		assertThat(getElementText(By.cssSelector("small.error")), containsString("Login is incorrect."));
		log.debug("--->");
	}

	/*@AfterClass
	public static void afterLoginTests() throws Exception {
		app.stop();
		TestBase.beforeAllTests();
	}*/
}
