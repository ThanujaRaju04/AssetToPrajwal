package com.cg.ams.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.ams.exception.AMSException;
import com.cg.ams.exception.AMSExceptionList;


public class JdbcUtility {
	static Connection connection = null;

	public static Connection getConnection() throws AMSException {
		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream(new File(
					"resources/jdbc.properties")));

			String driver = properties.getProperty("db.driver");
			String url = properties.getProperty("db.url");
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");

			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (FileNotFoundException e) {
			throw new AMSException(AMSExceptionList.Error1);
		} catch (IOException e) {
			throw new AMSException(AMSExceptionList.Error2);
		} catch (ClassNotFoundException e) {
			throw new AMSException(AMSExceptionList.Error3);
		} catch (SQLException e) {
			throw new AMSException(AMSExceptionList.Error4);
		}
		return connection;

	}

	static void closeConnection() throws AMSException {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new AMSException(AMSExceptionList.Error5);
		}

	}
}