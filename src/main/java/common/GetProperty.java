package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetProperty {
	
	Properties properties;
	
	/*
	 *initialize properties file
	 */
	public Properties initiaze_prop() {
		try {
			FileInputStream fip = new FileInputStream("./src/main/resources/config/config.properties");
			properties=new Properties();
			properties.load(fip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
