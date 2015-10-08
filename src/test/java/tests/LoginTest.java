package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.User;

public class LoginTest extends TestBase {
	static User usr = new User();
	
	@BeforeClass
	public static void beforeLoginTests() throws Exception {
		userLogic.logOut();
		usr.login = "admin";
		usr.password = "admin";
	}
	
	@Test
	public void testInvalidCredentials() throws Exception {
		usr.login = "admin123";
		usr.password = "admin123";
		userLogic.enterCredentials(usr);
		userLogic.checkTextAfterInvalidLogin();
	}

	@Test
	public void testBlankCredentials() throws Exception {
		usr.login = "";
		usr.password = "";
		userLogic.enterCredentials(usr);
		userLogic.checkTextAfterBlankLogin();
	}
	
	
	@AfterClass
	public static void loginBackToApp() {
		usr.login = "admin";
		usr.password = "admin";
		userLogic.enterCredentials(usr);
	}
}
