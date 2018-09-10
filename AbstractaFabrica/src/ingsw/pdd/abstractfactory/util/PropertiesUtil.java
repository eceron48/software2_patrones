package ingsw.pdd.abstractfactory.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties loadProperty(String PropertiesURL) {
		try {
			Properties properties=new Properties();
			InputStream entrada=PropertiesUtil.class.getClassLoader().getResourceAsStream(PropertiesURL);
			properties.load(entrada);
			return properties;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
