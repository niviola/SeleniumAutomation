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
	
	public void Ending() {    // this is to fix INFO: Command failed.... error message
        try{    
          driver.close();
          Thread.sleep(3000);
           }
       catch(Exception b){
          b.getMessage();
           }
	}
}
