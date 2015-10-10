package business.logic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import model.User;
import ru.yandex.qatools.allure.annotations.Step;
import technical.level.GenericMethods;

import org.openqa.selenium.By;

public class UserLogic extends GenericMethods {
	
	@Step
	public void login(User usr) {
		log.info("<--- " + usr);
		fillLoginForm(usr);
		submitLogin();
		assertThat(getPageTitle(), containsString("PHP Password Manager - Entry"));
		assertThat(getElementText(By.cssSelector("div#content h1")), containsString("Manage Entries"));
		log.info("--->");
	}

	private void fillLoginForm(User usr) {
		log.debug("<--- " + usr);
		type(By.id("LoginForm_username"), usr.login);
		type(By.id("LoginForm_password"), usr.password);
		log.debug("--->");
	}

	private void submitLogin() {
		log.debug("<---");
		click(By.cssSelector("a.button"));
		waitWhileAjaxCompleted(10);
		log.debug("--->");
	}
	
	@Step
	public void logOut() {
		log.info("<---");
//		openURL("http://localhost/passwordManager/index.php?r=user/logout");
//		click(By.linkText("Profile"));
		hover(By.linkText("Profile"));
		waitWhileAjaxCompleted(10);
		click(By.cssSelector(".dropdown>li>a[href*=logout]"));
		waitForElement(By.cssSelector("a.button"));
		log.info("--->");
	}
	
	@Step
	public void enterCredentials(User usr) {
		log.info("<--- " + usr);
		fillLoginForm(usr);
		submitLogin();
		log.info("--->");
	}
	
	@Step
	public void checkTextAfterBlankLogin() {
		log.info("<---");
		assertThat(getElementText(By.cssSelector("small.error:first-of-type")), containsString("Username cannot be blank."));
		assertThat(getElementText(By.cssSelector("small.error:last-of-type")), containsString("Password cannot be blank."));
		log.info("--->");
	}
	
	@Step
	public void checkTextAfterInvalidLogin() {
		log.info("<---");
		assertThat(getElementText(By.cssSelector("small.error")), containsString("Login is incorrect."));
		log.info("--->");
	}

	@Step
	private void checkTextAfterValidLogin() {
		log.info("<---");
		assertThat(getElementText(By.cssSelector("small.error")), containsString("Login is incorrect."));
		log.info("--->");
	}
}
