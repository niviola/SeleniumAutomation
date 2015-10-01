package technical.level;

import org.apache.log4j.Logger;

public class LoggerHelper {
	private static LoggerHelper singleton; 
	private Logger logger;
	
	public static LoggerHelper getInstance() {
		if (singleton == null) {
			singleton = new LoggerHelper();
			singleton.setLogger();
		}
		return singleton;
	}
	
	private void setLogger() {
		logger = Logger.getLogger("framework");
	}
	
	public Logger getLogger() {
		return logger;
	}
}
