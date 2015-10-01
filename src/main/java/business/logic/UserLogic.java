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
		log.info("<--- UserLogic.login");
		fillLoginForm(usr);
		submitLogin();
		assertThat(getPageTitle(), containsString("PHP Password Manager - Entry"));
		assertThat(getElementText(By.cssSelector("div#content h1")), containsString("Manage Entries"));
		log.info("---> UserLogic.login");
	}

	private void fillLoginForm(User usr) {
		log.debug("<--- UserLogic.fillLoginForm" + usr);
		type(By.id("LoginForm_username"), usr.login);
		type(By.id("LoginForm_password"), usr.password);
		log.debug("--->");
	}

	private void submitLogin() {
		log.debug("<--- UserLogic.fillLoginForm");
		click(By.cssSelector("a.button"));
		waitWhileAjaxCompleted(10);
		log.debug("--->");
	}
}
