package ingsw.pdd.factorymethod.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static Properties loadProperty(String propertiesURL) {
		
		try {
			Properties properties=new Properties();
			InputStream inputstream=PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesURL);
			properties.load(inputstream);
			return properties;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
