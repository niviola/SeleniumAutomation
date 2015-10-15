package technical.level;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileHelper {

	public void eraseFilesFromDirectory() throws IOException {
		File dir = new File(PropertyLoader.loadProperty("downloadDirectory"));
		FileUtils.cleanDirectory(dir); 
	}
}