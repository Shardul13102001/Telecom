package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;

	public static Properties getProperty() throws IOException
	{
		if(prop == null)
		{
			prop = new Properties();
			try {
				FileInputStream fi = new FileInputStream("src/test/resources/config.properties");
				prop.load(fi);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return prop;
	}
}
