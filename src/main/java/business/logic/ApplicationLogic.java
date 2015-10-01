package business.logic;

import technical.level.GenericMethods;

public class ApplicationLogic extends GenericMethods {

	private String baseUrl = "http://localhost/passwordManager";
	
	public void start() {
		log.info("<--- ApplicationLogic.start");
		openURL(baseUrl);
		log.info("---> ApplicationLogic.start");
	}
	
	public void stop() {
		log.info("<--- ApplicationLogic.stop");
		quit();
		log.info("---> ApplicationLogic.stop");
	}
}
