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
		System.out.println("<- UserLogic.login");
		fillLoginForm(usr);
		submitLogin();
		assertThat(getPageTitle(), containsString("PHP Password Manager - Entry"));
		assertThat(getElementText(By.cssSelector("div#content h1")), containsString("Manage Entries"));
		System.out.println("-> UserLogic.login");
	}

	private void fillLoginForm(User usr) {
		type(By.id("LoginForm_username"), usr.login);
		type(By.id("LoginForm_password"), usr.password);
	}

	private void submitLogin() {
		click(By.cssSelector("a.button"));
		waitWhileAjaxCompleted(10);
	}
}
