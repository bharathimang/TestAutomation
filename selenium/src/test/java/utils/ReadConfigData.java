package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigData {
	public static Properties prop;
	
	public ReadConfigData() throws IOException {
		File file=new File("src/test/resources/Configurations/Config.properties");
		FileReader fr=new FileReader(file);
		prop=new Properties();
		prop.load(fr);
	}
	
	public String getURL(String key) {
		return prop.getProperty(key);
	}
	
	public String getChromePath(String key) {
		return prop.getProperty(key);
	}
	
	public String getUserName(String key) {
		return prop.getProperty(key);
	}
	
	public String getPassword(String key) {
		return prop.getProperty(key);
	}

}
