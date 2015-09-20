package business.logic;

import technical.level.GenericMethods;

public class ApplicationLogic extends GenericMethods {

	private String baseUrl = "http://localhost/passwordManager";
	
	public void start() {
		System.out.println("<--- ApplicationLogic.start");
		openURL(baseUrl);
		System.out.println("---> ApplicationLogic.start");
	}
	
	public void stop() {
		System.out.println("<--- ApplicationLogic.stop");
		quit();
		System.out.println("---> ApplicationLogic.stop");
	}
}
