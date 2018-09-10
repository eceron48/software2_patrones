package ingsw.pdd.factorymethod;

import java.util.Properties;

import ingsw.pdd.factorymethod.impl.MYSQLDBAdapter;
import ingsw.pdd.factorymethod.impl.OracleDBAdapter;
import ingsw.pdd.factorymethod.util.PropertiesUtil;

public class DBFactory {
	private static final String DB_FACTORY_PROPERTY_URL = "META-INF/DBFactory.properties";
	 private static final String DEFAULT_DB_CLASS_PROP = "defaultDBClass";
	 
	 public static IDBAdapter getDBadapter(DBType dbType) {
		switch(dbType) {
		
		case MYSQL:
			return new MYSQLDBAdapter();
		case Oracle:
			return new OracleDBAdapter();
			
		default:
			throw new IllegalArgumentException("No soportado");
		}
		 
	 }
	 @SuppressWarnings("deprecation")
	public static IDBAdapter getDefaultDBAdapter() {
		 try {
			Properties prop= PropertiesUtil.loadProperty(DB_FACTORY_PROPERTY_URL);
			String DefaultDBClass=prop.getProperty(DEFAULT_DB_CLASS_PROP);
			System.out.println("DefaultDBClass==>"+DefaultDBClass);
			return (IDBAdapter) Class.forName(DefaultDBClass).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	 	}

}
