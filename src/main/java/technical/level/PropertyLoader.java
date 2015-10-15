package technical.level;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/*
 * Class that extracts properties from the prop file.
 * 
 * @author Sebastiano Armeli-Battana
 */
public class PropertyLoader {

	private static final String PROP_FILE = "/application.properties";
	private static final String LOCAL_PROP_FILE = "/local.properties";

	public static String loadProperty(String name) {
		File f = new File("c:\\Users\\Viktor-VM\\git\\SeleniumAutomation\\src\\main\\resources\\local.properties");
		Properties props = new Properties();
		try {
			if (f.exists()){
			props.load(PropertyLoader.class.getResourceAsStream(LOCAL_PROP_FILE));
			System.out.println("using LOCAL_PROP_FILE");
			}
			else {
				props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
				System.out.println("using PROP_FILE");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = "";

		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}
}
