package myPackage.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropRdr {
	private static Properties Config = null;
	private static FileInputStream fs = null;
	
	public static Properties getConfig(){
		Config = new Properties();
		try {
			fs = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/properties/config.properties");
			Config.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Config;
		
	}
	
	public static Properties getHub(){
		Config = new Properties();
		try {
			fs = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/properties/SeleniumHub.properties");
			Config.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Config;
		
	}
}
