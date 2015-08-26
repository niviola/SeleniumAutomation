package business.logic;

import technical.level.GenericMethods;

public class ApplicationLogic extends GenericMethods {

	private String baseUrl = "http://localhost/passwordManager";
	
	public void start() {
		openURL(baseUrl);
	}
	
	public void stop() {
		quit();
	}
}
