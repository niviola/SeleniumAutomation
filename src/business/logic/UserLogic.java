package business.logic;

import model.User;

import org.openqa.selenium.By;

import technical.level.GenericMethods;

public class UserLogic extends GenericMethods {

	public void login(User usr) {
		fillLoginForm(usr);
		submitLogin();
	}

	private void fillLoginForm(User usr) {
		type(By.id("LoginForm_username"), usr.login);
		type(By.id("LoginForm_password"), usr.password);
	}

	private void submitLogin() {
		click(By.cssSelector("a.button"));
	}
}