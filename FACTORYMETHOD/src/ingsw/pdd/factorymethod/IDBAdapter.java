package ingsw.pdd.factorymethod;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDBAdapter {

	public Connection getConnection() throws SQLException;
}
